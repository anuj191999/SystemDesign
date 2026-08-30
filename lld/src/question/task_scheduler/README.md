# Distributed Job Scheduler — LLD

multiple stateless scheduler nodes pull jobs from a shared store
and execute them, with **exactly-once execution** and **automatic recovery
from node crashes**, and no leader election.

---

## 1. Requirements

### Functional Requirements (kept deliberately small)

| # | Requirement |
|---|-------------|
| F1 | Client can submit a job to run at / after a given time. |
| F2 | A job executes **exactly once**, even though multiple scheduler nodes are polling and executing concurrently. |
| F3 | If the node executing a job crashes mid-execution, another node detects it and re-runs the job. |
| F4 | A failing job is retried with backoff up to a max attempt count, then marked `FAILED`. |
| F5 | Job status is queryable at any time (`PENDING` / `CLAIMED` / `RUNNING` / `COMPLETED` / `FAILED`). |

Intentionally **out of scope** (called out so it's clear they were dropped
on purpose, not missed): cron/recurring schedules, job priorities/DAG
dependencies, multi-tenant auth, a REST/API layer, persistence beyond an
in-memory store.

### Non-Functional Requirements (the actual point of this problem)

| # | Requirement | How it's satisfied |
|---|-------------|---------------------|
| NF1 | **Exactly-once execution** | Atomic `PENDING → CLAIMED` compare-and-set in `JobStore.tryClaim`. Only one node's CAS can win. |
| NF2 | **Fault tolerance** | Lease + heartbeat. A dead node stops renewing its lease; a background reaper detects the expiry and requeues the job. |
| NF3 | **Horizontal scalability** | `SchedulerNode` is stateless and leader-free — add as many as you want, they all run identical code. |
| NF4 | **No single point of failure in execution** | No coordinator/leader is needed to decide who runs what; correctness comes from per-job atomicity, not from a central decision-maker. |
| NF5 | **Pluggable storage** | All persistence sits behind the `JobStore` interface. `InMemoryJobStore` is swappable for Postgres (row locks), DynamoDB (conditional writes), Redis, etc. without touching scheduling logic. |

---

## 2. Core Idea (the thing to say out loud in the interview)

> Every job carries a **lease**: `leaseOwner` + `leaseExpiryMillis`.
> Claiming a job is a single atomic operation (`PENDING → CLAIMED`) —
> that operation *is* the exactly-once guarantee, not any external lock
> service. While a node runs a job it periodically **renews** the lease
> (heartbeat). A background **reaper** scans for jobs stuck in
> `CLAIMED`/`RUNNING` whose lease has expired — meaning the owner is
> presumed dead — and resets them to `PENDING` so any node can claim them
> again.

This is the same pattern used by Quartz (JDBC row locks), Kafka consumer
group rebalancing, and Chronos/Airflow-style schedulers. It avoids needing
ZooKeeper/etcd-style leader election just to decide who executes a job.

---

## 3. Class Structure

```
JobTask.java                 functional interface: the work to run
JobStatus.java                enum: PENDING/CLAIMED/RUNNING/COMPLETED/FAILED
Job.java                      entity: id, task, schedule, lease, retry state
JobStore.java                 storage contract (the abstraction boundary)
InMemoryJobStore.java         in-memory impl (swap for a real DB in prod)
SchedulerNode.java             one cluster member: poll -> claim -> run -> heartbeat
DistributedJobScheduler.java  cluster facade: add nodes, submit jobs, run the reaper
Main.java                     demo proving all guarantees end-to-end
```

**Dependency direction:** `Main` depends on `DistributedJobScheduler`,
which depends on `SchedulerNode` and `JobStore`. `SchedulerNode` only
knows about `JobStore` (interface) and `Job`/`JobTask` — it has **no**
idea whether the store is in-memory or a real database. This is the key
seam for extending the design.

---

## 4. Job Lifecycle

```
PENDING --(node wins tryClaim)--> CLAIMED --(execution starts)--> RUNNING
   ^                                                                 |
   |                                                                 |
   +----------- lease expires, reaper requeues -----------------------
   |
   +----------- task throws & retries remain (markFailedOrRetry) -----

RUNNING --(task returns normally)--------> COMPLETED
RUNNING --(task throws, retries exhausted)-> FAILED
```

---

## 5. Key Mechanisms

- **Atomic claim (`tryClaim`)** — the exactly-once guarantee. In
  `InMemoryJobStore` this is a `synchronized(job)` block; in a real DB
  it's a single conditional `UPDATE ... WHERE status='PENDING'` checked
  for `rowsAffected == 1`.
- **Lease + heartbeat** — `SchedulerNode` renews the lease for jobs it is
  actively running every second. If the node dies, renewal stops.
- **Reaper** — runs on a schedule, finds `CLAIMED`/`RUNNING` jobs with an
  expired lease, and calls `requeue()`. This is what actually delivers
  fault tolerance (F3); it is independent of any single node.
- **Retry with backoff** — `markFailedOrRetry` increments `retryCount`
  and pushes `scheduledTimeMillis` forward linearly (`backoff * attempt`)
  until `maxRetries` is exhausted, then marks `FAILED`.
- **Crash vs. ordinary failure** — `SchedulerNode.runJob` treats an
  `InterruptedException` (simulated crash / forced shutdown) differently
  from any other `Exception` (a normal task failure). On a real crash the
  process can't update the store at all, so the code deliberately does
  **not** call `markFailedOrRetry` — it just stops, leaving the lease to
  expire and the reaper to take over.

---

## 6. How to Run

```bash
javac *.java
java Main
```

The demo:
1. Starts `node-1`, hands it a slow job (`job-3`).
2. Starts `node-2`, submits a normal job (`job-1`) and a flaky job
   (`job-2`) that fails twice before succeeding.
3. **Kills `node-1` mid-execution of `job-3`** to simulate a crash.
4. Waits, then prints final statuses.

Expected outcome: all three jobs end up `COMPLETED`, `job-2` shows two
failed attempts before success, and the log shows the reaper detecting
`node-1`'s expired lease and `node-2` re-running `job-3` — proving the
job was **never double-executed** and **never lost**.

Sample log excerpt:
```
--- killing node-1 to simulate a crash mid-job ---
[node-1] *** CRASHED ***
[node-1] ABORTED SlowReportJob (node died, leaving lease to expire)
...
[reaper] lease expired for SlowReportJob (owner=node-1) -> requeueing
[node-2] START  SlowReportJob (job-3)
     >> report generated
[node-2] DONE   SlowReportJob
```

---

## 7. Known Limitations & Natural Follow-Up Questions

These are worth raising proactively in an interview — they show you know
where the simple version breaks down:

- **Zombie/fencing problem**: if a "crashed" node isn't actually dead but
  just slow/partitioned, it could wake up after being reaped and still
  write `COMPLETED` for a job another node has since restarted — causing
  double execution after all. Real systems fix this with a **fencing
  token** (a monotonically increasing lease version) checked on every
  write, not just at claim time.
- **In-memory store is single-process**: it simulates multiple nodes with
  threads in one JVM. A real deployment needs a shared store reachable by
  all nodes (Postgres/DynamoDB/Redis).
- **No recurring/cron jobs**: would add a `cronExpression` field and,
  on `markCompleted`, compute and insert the next occurrence.
- **No job priority or sharding**: at high volume you'd want to shard
  `fetchDueJobs` (e.g., by job ID hash range per node) to avoid every
  node scanning every job.
- **Reaper is not itself fault-tolerant here**: only one reaper runs in
  the demo. In production every node would run its own reaper loop
  (cheap and idempotent — `requeue` is safe to call redundantly).
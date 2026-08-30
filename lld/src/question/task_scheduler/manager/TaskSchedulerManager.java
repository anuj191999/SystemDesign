package question.task_scheduler.manager;

import question.task_scheduler.model.ScheduledTaskWrapper;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskSchedulerManager {

    private PriorityQueue<ScheduledTaskWrapper> queue =
            new PriorityQueue<>(Comparator.comparingLong(t -> t.getSchedule().getNextRunTime()));

    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public void scheduleTask(ScheduledTaskWrapper task) {
        queue.offer(task);
    }

    public void start() {
        while (true) {
            long now = System.currentTimeMillis();

            if (!queue.isEmpty() && queue.peek().getSchedule().getNextRunTime() <= now) {
                ScheduledTaskWrapper task = queue.poll();


                executor.submit(() -> {
                    assert task != null;
                    task.run();
                });

                assert task != null;
                if (task.getSchedule().isRecurring()) {
                    task.getSchedule().setNextRunTime(
                            now + task.getSchedule().getInterval()
                    );
                    queue.offer(task);
                }
            }
        }
    }
}
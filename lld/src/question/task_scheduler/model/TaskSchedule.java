package question.task_scheduler.model;

public class TaskSchedule {
    private String taskId;
    private long nextRunTime;
    private long interval;
    private boolean isRecurring;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public long getNextRunTime() {
        return nextRunTime;
    }

    public void setNextRunTime(long nextRunTime) {
        this.nextRunTime = nextRunTime;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public TaskSchedule(String taskId, long nextRunTime, long interval, boolean isRecurring) {
        this.taskId = taskId;
        this.nextRunTime = nextRunTime;
        this.interval = interval;
        this.isRecurring = isRecurring;
    }
}

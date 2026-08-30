package question.task_scheduler.model;

import question.task_scheduler.tasks.ScheduledTask;

import java.util.Map;

public class ScheduledTaskWrapper {

    private ScheduledTask task;
    private TaskSchedule schedule;
    private Map<String, String> config;

    public ScheduledTaskWrapper(ScheduledTask task, TaskSchedule schedule, Map<String, String> config) {
        this.task = task;
        this.schedule = schedule;
        this.config = config;
    }

    public ScheduledTask getTask() {
        return task;
    }

    public void setTask(ScheduledTask task) {
        this.task = task;
    }

    public TaskSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(TaskSchedule schedule) {
        this.schedule = schedule;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    public void run() {
        task.execute(config);
    }
}

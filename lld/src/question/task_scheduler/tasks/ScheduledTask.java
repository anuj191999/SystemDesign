package question.task_scheduler.tasks;

import java.util.Map;

@FunctionalInterface
public interface ScheduledTask {
    void execute(Map<String,String> taskConfig);
}

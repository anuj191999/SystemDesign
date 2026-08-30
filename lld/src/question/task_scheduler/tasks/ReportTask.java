package question.task_scheduler.tasks;

import java.util.Map;

public class ReportTask implements ScheduledTask{
    @Override
    public void execute(Map<String, String> taskConfig) {
        System.out.println("ReportTask.execute() :: invoked");
    }
}

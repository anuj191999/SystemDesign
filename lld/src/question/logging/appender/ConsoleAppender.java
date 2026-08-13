package question.logging.appender;

import question.logging.formater.LogFormatter;
import question.logging.model.LogEvent;

public class ConsoleAppender implements Appender{

    @Override
    public void append(LogEvent event, LogFormatter formatter) {
        String formatted=formatter.format(event);
        System.out.println(formatted);
    }
}

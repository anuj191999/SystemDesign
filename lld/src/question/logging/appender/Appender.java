package question.logging.appender;

import question.logging.formater.LogFormatter;
import question.logging.model.LogEvent;

public interface Appender {
    void append(LogEvent event, LogFormatter formatter);
}

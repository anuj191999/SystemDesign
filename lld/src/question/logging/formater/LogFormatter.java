package question.logging.formater;

import question.logging.model.LogEvent;

public interface LogFormatter {
    String format(LogEvent event);
}

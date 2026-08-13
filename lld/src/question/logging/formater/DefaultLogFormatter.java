package question.logging.formater;

import question.logging.model.LogEvent;

public class DefaultLogFormatter implements LogFormatter{

    @Override
    public String format(LogEvent event) {
        return String.format(
                "%s | %s [%s] %s | %s",
                event.getTime(),
                event.getLevel(),
                event.getThreadName(),
                event.getLoggerName(),
                event.getMessage()
        );
    }
}

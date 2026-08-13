package question.logging.config;

import question.logging.appender.Appender;
import question.logging.enums.LogLevel;
import question.logging.formater.LogFormatter;

import java.util.List;

public class LoggerConfig {
    private LogLevel level;
    private List<Appender> appenderList;
    private LogFormatter formatter;

    public LoggerConfig(LogLevel level, List<Appender> appenderList, LogFormatter formatter) {
        this.level = level;
        this.appenderList = appenderList;
        this.formatter = formatter;
    }

    public LogLevel getLevel() {
        return level;
    }

    public List<Appender> getAppenderList() {
        return appenderList;
    }

    public LogFormatter getFormatter() {
        return formatter;
    }
}

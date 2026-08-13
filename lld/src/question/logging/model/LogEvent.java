package question.logging.model;

import question.logging.enums.LogLevel;

import java.time.LocalDateTime;

public class LogEvent {
    private LogLevel level;
    private String message;
    private LocalDateTime time;
    private String threadName;
    private String loggerName; // src (class name)

    public LogEvent(String message, LogLevel level, String loggerName) {
        this.message = message;
        this.level = level;
        this.threadName = Thread.currentThread().getName();
        this.loggerName = loggerName;
        this.time=LocalDateTime.now();
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getLoggerName() {
        return loggerName;
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "level=" + level +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", threadName='" + threadName + '\'' +
                ", loggerName='" + loggerName + '\'' +
                '}';
    }
}

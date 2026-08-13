package question.logging.enums;

public enum LogLevel {
    INFO(1),
    DEBUG(2),
    ERROR(3),
    WARNING(4);

    private final int priority;

    LogLevel(int priority) {
        this.priority = priority;
    }

    public boolean isEnabled(LogLevel configuredLevel) {
        return this.priority >= configuredLevel.priority;
    }
}

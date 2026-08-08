package question.NotificationSender.model;

import question.NotificationSender.enums.ChannleType;
import question.NotificationSender.enums.NotificationStatus;

import java.util.UUID;

public class Notification {
    private String id;
    private String message;
    private ChannleType channleType;
    private NotificationStatus status;

    public Notification(String message, ChannleType channleType, NotificationStatus status) {
        id= UUID.randomUUID().toString();
        this.message = message;
        this.channleType = channleType;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public ChannleType getChannleType() {
        return channleType;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
}

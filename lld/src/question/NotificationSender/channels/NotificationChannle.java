package question.NotificationSender.channels;
import question.NotificationSender.model.User;
import question.NotificationSender.model.Notification;

public interface NotificationChannle {
    boolean send(User user, Notification event);
}

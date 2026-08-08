package question.NotificationSender;

import question.NotificationSender.enums.ChannleType;
import question.NotificationSender.enums.NotificationStatus;
import  question.NotificationSender.model.*;

import java.util.UUID;

public class NotificationService {
    private final NotificationDispatcher dispatcher = new NotificationDispatcher();
    public void notifyUser(User user, String message) {
        for (ChannleType channel : user.getPreference()) {
            Notification notification = new Notification(message,channel, NotificationStatus.PENDING);
            dispatcher.dispatch(user, notification);
        }
    }
}

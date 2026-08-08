package question.NotificationSender;
import question.NotificationSender.channels.ChannelFactory;
import question.NotificationSender.channels.NotificationChannle;
import question.NotificationSender.enums.*;
import question.NotificationSender.model.*;

import question.NotificationSender.policy.RetryPolicy;

class NotificationDispatcher {
    private RetryPolicy retryPolicy = new RetryPolicy();
    public void dispatch(User user, Notification notification) {
        NotificationChannle channel = ChannelFactory.getChannle(notification.getChannleType());
        int attempt = 0;
        boolean success = false;
        while (retryPolicy.shouldRetry(attempt) && !success) {
            attempt++;
            success = channel.send(user, notification);
        }
        NotificationStatus status = success ? NotificationStatus.SENT : NotificationStatus.FAILED;
        notification.setStatus(status);
    }
}

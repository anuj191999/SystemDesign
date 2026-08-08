package question.NotificationSender.policy;

public class RetryPolicy {
    int maxRetries = 3;
    public boolean shouldRetry(int attempt) {
        return attempt < maxRetries;
    }
}

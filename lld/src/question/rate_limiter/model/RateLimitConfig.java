package question.rate_limiter.model;

public class RateLimitConfig {

    private final long capacity;
    private final long refillOrLeakAmount;
    private final long refillOrLeakDurations;
    private final long limit;
    private final long windowSizeMillis;

    private RateLimitConfig(Builder b){
        this.capacity=b.capacity;
        this.refillOrLeakAmount=b.refillOrLeakAmount;
        this.refillOrLeakDurations=b.refillOrLeakDurationMs;
        this.limit=b.limit;
        this.windowSizeMillis=b.windowSizeMillis;
    }

    public long getCapacity() {
        return capacity;
    }

    public long getRefillOrLeakAmount() {
        return refillOrLeakAmount;
    }

    public long getRefillOrLeakDurations() {
        return refillOrLeakDurations;
    }

    public long getLimit() {
        return limit;
    }

    public long getWindowSizeMillis() {
        return windowSizeMillis;
    }

    public static class Builder {
        private long capacity;
        private long refillOrLeakAmount;
        private long refillOrLeakDurationMs;
        private long limit;
        private long windowSizeMillis;

        public Builder capacity(long v) { this.capacity = v; return this; }
        public Builder refillTokens(long v) { this.refillOrLeakAmount = v; return this; }
        public Builder leakRequests(long v) { this.refillOrLeakAmount = v; return this; }
        public Builder refillDurationMillis(long v) { this.refillOrLeakDurationMs = v; return this; }
        public Builder leakDurationMillis(long v) { this.refillOrLeakDurationMs = v; return this; }
        public Builder limit(long v) { this.limit = v; return this; }
        public Builder windowSizeMillis(long v) { this.windowSizeMillis = v; return this; }

        public RateLimitConfig build() { return new RateLimitConfig(this); }
    }
}

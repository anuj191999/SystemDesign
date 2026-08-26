package question.rate_limiter.algorithm;

import java.time.LocalDateTime;

public class TokenBucketAlgorithm implements RateLimiterAlgorithm{

    private final long capacity;
    private final double refillRatePerMillis;
    private double availableTokens;
    private long lastRefillTimeStampMs;
    private final Object lock=new Object();

    public TokenBucketAlgorithm(long capacity, double refillTokens, long refillDurationMillis) {
        if(capacity<=0 || refillDurationMillis<=0){
            throw  new IllegalArgumentException("capacity and refillDurationMillis must be positive");
        }
        this.capacity = capacity;
        this.refillRatePerMillis = (double) refillTokens/(double) refillDurationMillis;
        this.availableTokens = capacity;
        this.lastRefillTimeStampMs = System.currentTimeMillis();
    }

    @Override
    public boolean allowRequest() {
        synchronized (lock){
            refill();
            System.out.println(LocalDateTime.now());
            if(availableTokens>=1.0){
                try {
                    Thread.sleep(1000);
                }
                catch (Exception ignored){}
                availableTokens-=1.0;
                return true;
            }
            return false;
        }
    }

    private void refill(){
        long now=System.currentTimeMillis();
        long elapsed=now-lastRefillTimeStampMs;

        if(elapsed>0){
            double tokensToAdd=elapsed*refillRatePerMillis;
            if(tokensToAdd>0){
                availableTokens=Math.min(capacity,availableTokens+tokensToAdd);
                lastRefillTimeStampMs=now;
            }
        }
    }
}

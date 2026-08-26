package question.rate_limiter.algorithm;

import question.rate_limiter.enums.AlgorithmType;
import question.rate_limiter.model.RateLimitConfig;


public class AlgorithmFactory {
    private AlgorithmFactory(){}

    public  static RateLimiterAlgorithm create(AlgorithmType type, RateLimitConfig config){

        switch (type){
            case TOKEN_BUCKET:
            {
                return new TokenBucketAlgorithm(
                        config.getCapacity(),
                        config.getRefillOrLeakAmount(),
                        config.getRefillOrLeakDurations()
                );
            }
            case LEAKY_BUCKET:{
                return new LeakyBucketAlgorithm(
                        config.getCapacity(),
                        config.getRefillOrLeakAmount(),
                        config.getRefillOrLeakDurations()
                );
            }
            case FIXED_WINDOW_COUNTER:{
                return new FixedWindowCounterAlgorithm(
                        config.getLimit(),
                        config.getWindowSizeMillis()
                );
            }
            case SLIDING_WINDOW_LOG:{
                return new SlidingWindowLogAlgorithm(
                        config.getLimit(),
                        config.getWindowSizeMillis()
                );
            }
            default:
                throw new IllegalArgumentException("Unknown algorithm type : "+type);
        }
    }
}

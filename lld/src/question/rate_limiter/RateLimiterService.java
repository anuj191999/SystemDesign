package question.rate_limiter;

import question.rate_limiter.algorithm.AlgorithmFactory;
import question.rate_limiter.algorithm.RateLimiterAlgorithm;
import question.rate_limiter.model.RateLimitRule;
import question.rate_limiter.model.RateLimiterResult;
import question.rate_limiter.model.RequestContext;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterService implements Runnable{
    private final List<RateLimitRule> rules;
    private final ConcurrentHashMap<String, RateLimiterAlgorithm> bucketStore=new ConcurrentHashMap<>();

    public RateLimiterService(List<RateLimitRule> rules){
        this.rules=rules;
    }

    public RateLimiterResult isAllowed(RequestContext context){
        for(RateLimitRule rule:rules){
            String dimensionKey=rule.getKeyResolver().resolveKey(context);
            String bucketKey=rule.getRuleName()+" | "+dimensionKey;
            RateLimiterAlgorithm algorithm=bucketStore.computeIfAbsent(bucketKey,k-> AlgorithmFactory.create(rule.getAlgorithmType(),rule.getRateLimitConfig()));
            if(!algorithm.allowRequest()){
                return RateLimiterResult.deny(rule.getRuleName());
            }
        }
        return RateLimiterResult.allow();
    }
    public int activeBucketCount(){
        return bucketStore.size();
    }

    @Override
    public void run() {

    }
}

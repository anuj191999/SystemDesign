package question.rate_limiter.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowLogAlgorithm implements RateLimiterAlgorithm{

    private final long limit;
    private final long windowSizeMillis;
    private final Deque<Long> requestTimesStamps=new ArrayDeque<>();
    private final Object lock=new Object();

    public SlidingWindowLogAlgorithm(long limit,long windowSizeMillis){
        if(limit<=0 || windowSizeMillis<=0){
            throw new IllegalArgumentException("limit and windowSizeMillis must be positive");
        }

        this.limit=limit;
        this.windowSizeMillis=windowSizeMillis;
    }



    @Override
    public boolean allowRequest() {
        synchronized (lock){
            long now=System.currentTimeMillis();
            long windowStart=now-windowSizeMillis;
            while(!requestTimesStamps.isEmpty() && requestTimesStamps.peekFirst()<=windowStart){
                requestTimesStamps.pollFirst();
            }
            if(requestTimesStamps.size()<limit){
                requestTimesStamps.addLast(now);
                return true;
            }
            return false;
        }
    }
}

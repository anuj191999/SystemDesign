package question.rate_limiter.algorithm;

public class FixedWindowCounterAlgorithm implements RateLimiterAlgorithm{

    private final long limit;
    private final long windowSizeMillis;
    private long currentWindowStart;
    private long countInWindow;
    private final Object lock=new Object();

    public FixedWindowCounterAlgorithm(long limit, long windowSizeMillis) {
        if(limit==0 || windowSizeMillis<=0){
            throw new IllegalArgumentException("limit and windowSizeMillis mute be positive");
        }

        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
        this.currentWindowStart=alignedWindowStart(System.currentTimeMillis());
        this.countInWindow=0;
    }

    private long alignedWindowStart(long nowMs){
        return (nowMs/windowSizeMillis)*windowSizeMillis;
    }

    @Override
    public boolean allowRequest() {
       synchronized (lock){
           long now=System.currentTimeMillis();
           long windowForNow=alignedWindowStart(now);
           if(windowForNow!=currentWindowStart){
               currentWindowStart=windowForNow;
               countInWindow=0;
           }
           if (countInWindow<limit){
               countInWindow++;
               return true;
           }
           return false;
       }
    }
}

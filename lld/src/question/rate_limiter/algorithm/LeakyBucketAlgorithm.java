package question.rate_limiter.algorithm;

import java.awt.*;

public class LeakyBucketAlgorithm implements RateLimiterAlgorithm{

    private final long capacity;
    private final double leakRatePerMillis;
    private double currentWaterLevel;
    private long lastLeakTimeStampMs;
    private final Object lock=new Object();

    public LeakyBucketAlgorithm(long capacity, double leakUnits, long leakDurationMillis) {
        if(capacity<=0 || leakDurationMillis<=0){
            throw  new IllegalArgumentException("capacity and leakDurationMillis must be positive");
        }
        this.capacity = capacity;
        this.leakRatePerMillis = (double) leakUnits/(double)leakDurationMillis;
        this.currentWaterLevel = 0;
        this.lastLeakTimeStampMs = System.currentTimeMillis();
    }

    @Override
    public boolean allowRequest() {
       synchronized (lock){
           leak();
           if(currentWaterLevel+1.0<=capacity){
               currentWaterLevel+=1.0;
               return true;
           }
           return false;
       }
    }

    private void leak(){
        long now=System.currentTimeMillis();
        long elapsed=now-lastLeakTimeStampMs;
        if(elapsed>0){
            double leaked=elapsed*leakRatePerMillis;
            if(leaked>0){
                currentWaterLevel=Math.max(0,currentWaterLevel-leaked);
                lastLeakTimeStampMs=now;
            }
        }
    }
}

package question.rate_limiter.model;

public class RateLimiterResult {

    private final boolean allowed;
    private final String deniedByRule;

    private RateLimiterResult(boolean allowed, String deniedByRule){
        this.allowed=allowed;
        this.deniedByRule=deniedByRule;
    }

    public static RateLimiterResult allow(){
        return  new RateLimiterResult(true,null);
    }
    public static RateLimiterResult  deny(String ruleName){
        return new RateLimiterResult(false,ruleName);
    }

    public boolean isAllowed(){ return allowed;}
    public String getDeniedByRule() {return deniedByRule;}

    @Override
    public String toString(){
        return this.allowed?"ALLOWED":"DENIED ( rule="+deniedByRule + ")";
    }
}

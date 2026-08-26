package question.rate_limiter.model;

public class RequestContext {

    private final String ip;
    private final String serverId;
    private final String region;
    private final String userId;

    public RequestContext(String ip,String serverId,String region,String userId){
        this.ip=ip;
        this.serverId=serverId;
        this.region=region;
        this.userId=userId;
   }

    public String getIp() {
        return ip;
    }

    public String getServerId() {
        return serverId;
    }

    public String getRegion() {
        return region;
    }

    public String getUserId() {
        return userId;
    }
}

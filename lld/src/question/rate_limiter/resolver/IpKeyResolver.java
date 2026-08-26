package question.rate_limiter.resolver;

import question.rate_limiter.model.RequestContext;

public class IpKeyResolver implements KeyResolver{

    @Override
    public String resolveKey(RequestContext context) {
        return "IP:"+context.getIp();
    }
}

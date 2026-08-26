package question.rate_limiter.resolver;

import question.rate_limiter.model.RequestContext;

public class ServerKeyResolver implements KeyResolver{

    @Override
    public String resolveKey(RequestContext context) {
        return "SERVER:"+context.getServerId();
    }
}

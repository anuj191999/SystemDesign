package question.rate_limiter.resolver;

import question.rate_limiter.model.RequestContext;

public interface KeyResolver {

    String resolveKey(RequestContext context);
}

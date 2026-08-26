package question.rate_limiter.model;

import question.rate_limiter.enums.AlgorithmType;
import question.rate_limiter.resolver.KeyResolver;

public class RateLimitRule {

    private final String ruleName;
    private final KeyResolver keyResolver;
    private final AlgorithmType algorithmType;
    private final RateLimitConfig rateLimitConfig;

    public RateLimitRule(String ruleName, KeyResolver keyResolver, AlgorithmType algorithmType, RateLimitConfig rateLimitConfig) {
        this.ruleName = ruleName;
        this.keyResolver = keyResolver;
        this.algorithmType = algorithmType;
        this.rateLimitConfig = rateLimitConfig;
    }

    public String getRuleName() {
        return ruleName;
    }

    public KeyResolver getKeyResolver() {
        return keyResolver;
    }

    public AlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    public RateLimitConfig getRateLimitConfig() {
        return rateLimitConfig;
    }
}

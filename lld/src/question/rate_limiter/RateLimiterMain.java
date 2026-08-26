package question.rate_limiter;

import question.rate_limiter.enums.AlgorithmType;
import question.rate_limiter.model.RateLimitConfig;
import question.rate_limiter.model.RateLimitRule;
import question.rate_limiter.model.RateLimiterResult;
import question.rate_limiter.model.RequestContext;
import question.rate_limiter.resolver.GeographyKeyResolver;
import question.rate_limiter.resolver.IpKeyResolver;
import question.rate_limiter.resolver.ServerKeyResolver;

import java.util.List;


public class RateLimiterMain {
    public static void main(String[] args) throws InterruptedException {
        // IP rule is the tight one on purpose: capacity 3, refills slowly (3 tokens per 5 sec).
        // This is the rule that should actually reject requests during the burst below.
        RateLimitRule ipRule = new RateLimitRule(
                "IP_TOKEN_BUCKET",
                new IpKeyResolver(),
                AlgorithmType.TOKEN_BUCKET,
                new RateLimitConfig.Builder()
                        .capacity(3)
                        .refillTokens(3)
                        .refillDurationMillis(5000)
                        .build());

        // Server and Geo rules are kept loose so they don't interfere -
        // in this demo the IP rule alone should decide allow/deny.
        RateLimitRule serverRule = new RateLimitRule(
                "SERVER_SLIDING_WINDOW",
                new ServerKeyResolver(),
                AlgorithmType.SLIDING_WINDOW_LOG,
                new RateLimitConfig.Builder().limit(10).windowSizeMillis(5000).build());

        RateLimitRule geoRule = new RateLimitRule(
                "GEO_FIXED_WINDOW",
                new GeographyKeyResolver(),
                AlgorithmType.FIXED_WINDOW_COUNTER,
                new RateLimitConfig.Builder().limit(10).windowSizeMillis(5000).build());

        RateLimiterService service = new RateLimiterService(List.of(ipRule));

        RequestContext ctx = new RequestContext("192.168.1.10", "server-1", "IN", "user-42");


        int requestCount = 8;
        Thread[] threads = new Thread[requestCount];

        // Create threads that all call isAllowed() on the SAME shared service/context -
        // this is the burst: 8 requests arriving at (roughly) the same time.
        for (int i = 0; i < requestCount; i++) {
            int requestId = i + 1;
            threads[i] = new Thread(() -> {
                RateLimiterResult result = service.isAllowed(ctx);
                System.out.println("Request #" + requestId + " -> " + result);
            });
        }

        for (Thread t : threads) {
            t.start(); // fire them close together
        }
        for (Thread t : threads) {
            t.join();  // wait for all to finish before printing is done
        }

        // Expected: capacity is 3, so ~3 requests should be ALLOWED and the rest DENIED
        // (by IP_TOKEN_BUCKET). Exact count can vary slightly run to run since thread
        // start order isn't perfectly simultaneous, but it should never be "8 allowed".
    }
}

package com.alibaba.reactive.observability;

import reactor.core.publisher.Mono;

/**
 * Metrics service
 *
 * @author leijuan
 */
public interface MetricsService {

    /**
     * scrape metrics
     *
     */
    Mono<String> scrape();
}

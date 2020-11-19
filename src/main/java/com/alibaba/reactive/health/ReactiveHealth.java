package com.alibaba.reactive.health;

import reactor.core.publisher.Mono;

/**
 * reactive health check interface
 *
 * @author leijuan
 */
public interface ReactiveHealth {
    /**
     * health status: 0:unknown, 1: serving, 2: not serving
     *
     * @param serviceName service name
     * @return health status
     */
    Mono<Integer> check(String serviceName);
}

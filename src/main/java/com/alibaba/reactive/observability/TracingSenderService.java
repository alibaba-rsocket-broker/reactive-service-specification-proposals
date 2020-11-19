package com.alibaba.reactive.observability;

import reactor.core.publisher.Mono;

import java.util.List;

/**
 * tracing sender service
 *
 * @author leijuan
 */
public interface TracingSenderService {

    Mono<Void> sendSpans(List<byte[]> encodedSpans);

}

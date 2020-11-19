package com.alibaba.reactive.messaging;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * reactive messaging service
 *
 * @author leijuan
 */
public interface MessagingService {
    /**
     * send message
     *
     * @param topic topic name
     * @param data  data
     * @return void
     */
    Mono<Void> send(@NotNull String topic, byte[] data);

    /**
     * subscribe topic
     *
     * @param topic topic name
     * @return message flux
     */
    Flux<byte[]> subscribe(@NotNull String topic);

    /**
     * subscribe with queue pattern
     *
     * @param topic topic
     * @param group group name
     * @return message flux
     */
    Flux<byte[]> subscribeInGroup(@NotNull String topic, @NotNull String group);
}

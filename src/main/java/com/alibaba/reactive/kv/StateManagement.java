package com.alibaba.reactive.kv;

import reactor.core.publisher.Mono;

/**
 * statement management: get, put and delete
 *
 * @author leijuan
 */
public interface StateManagement {

    Mono<byte[]> get(String key);

    Mono<Void> put(String key, byte[] bytes);

    Mono<Void> delete(String key);

}

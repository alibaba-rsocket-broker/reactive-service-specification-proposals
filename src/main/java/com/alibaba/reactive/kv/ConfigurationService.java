package com.alibaba.reactive.kv;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Configuration service, products like etcd, consul, redis etc
 *
 * @author leijuan
 */
public interface ConfigurationService {
    /**
     * put setting into configuration
     *
     * @param key   key
     * @param value value
     * @return void
     */
    Mono<Void> put(@NotNull String key, @NotNull String value);

    /**
     * get setting from configuration
     *
     * @param key key
     * @return value
     */
    Mono<String> get(@NotNull String key);

    /**
     * delete setting from configuration
     *
     * @param key key
     * @return void
     */
    Mono<Void> delete(@NotNull String key);

    /**
     * watch setting
     *
     * @param key key
     * @return value flux
     */
    Flux<String> watch(@NotNull String key);
}

package com.alibaba.reactive.security;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

/**
 * secret service
 *
 * @author leijuan
 */
public interface SecretService {

    /**
     * read secret
     *
     * @param path path
     * @return secret value
     */
    Mono<char[]> read(@NotNull String path);

    /**
     * write secret
     *
     * @param path   path
     * @param secret secret value
     * @return void
     */
    Mono<Void> write(@NotNull String path, char[] secret);

    /**
     * delete secret
     *
     * @param path path
     * @return void
     */
    Mono<Void> delete(@NotNull String path);
}

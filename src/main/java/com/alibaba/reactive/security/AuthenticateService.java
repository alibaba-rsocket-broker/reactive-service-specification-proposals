package com.alibaba.reactive.security;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

/**
 * authenticate service
 *
 * @author leijuan
 */
public interface AuthenticateService {

    Mono<Boolean> authenticate(@NotNull String type, @NotNull String token);
}

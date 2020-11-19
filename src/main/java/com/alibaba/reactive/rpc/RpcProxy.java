package com.alibaba.reactive.rpc;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

/**
 * RPC Proxy interface
 *
 * @author leijuan
 */
public interface RpcProxy {
    /**
     * invoke RPC service
     *
     * @param serviceName service name
     * @param method      method name
     * @param args        arguments
     * @return result
     */
    Mono<Object> invoke(@NotNull String serviceName, @NotNull String method, Object... args);

    /**
     * invoke RPC service
     *
     * @param serviceName service name
     * @param method      method name
     * @param version     service version
     * @param args        arguments
     * @return result
     */
    Mono<Object> invokeWithVersion(@NotNull String serviceName, @NotNull String method, String version, Object... args);


}

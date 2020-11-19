package com.alibaba.reactive.kv;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Mono;

/**
 * KV blob service, such as levelDB, AWS S3, Aliyun OSS
 *
 * @author leijuan
 */
public interface KVBlobService {

    /**
     * put setting into configuration
     *
     * @param key   key
     * @param value value
     * @return void
     */
    Mono<Void> put(@NotNull String key, byte[] value);

    /**
     * get setting from configuration
     *
     * @param key key
     * @return value
     */
    Mono<byte[]> get(@NotNull String key);

    /**
     * delete setting from configuration
     *
     * @param key key
     * @return void
     */
    Mono<Void> delete(@NotNull String key);

}

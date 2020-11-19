package com.alibaba.reactive.cache;

import java.io.Closeable;
import java.io.Serializable;

/**
 * Reactive Cache Manager
 *
 * @author leijuan
 */
public interface ReactiveCacheManager extends Closeable {

    /**
     * get cache
     *
     * @param name       name
     * @param expireTime expired time, unit is millisecond
     * @param <K>        key type
     * @param <V>        value type
     * @return cache
     */
    <K extends Serializable, V extends Serializable> Cache<K, V> cache(String name, Integer expireTime);

}

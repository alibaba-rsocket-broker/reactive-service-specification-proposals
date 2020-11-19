package com.alibaba.reactive.cache;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.io.Serializable;
import java.util.Set;

/**
 * Reactive API for cache
 *
 * @author leijuan
 */
public interface Cache<K extends Serializable, V extends Serializable> {
    /**
     * get value
     *
     * @param key key
     * @return value
     */
    Mono<V> get(@NotNull K key);

    /**
     * put value in cache
     *
     * @param key   key
     * @param value value
     * @return void
     */
    Mono<Void> put(@NotNull K key, @NotNull V value);

    /**
     * get exiting value and put with new value
     *
     * @param key   key
     * @param value value
     * @return existing value
     */
    Mono<V> getAndPut(@NotNull K key, @NotNull V value);

    /**
     * put all items into cache from map
     *
     * @param map map
     * @return void
     */
    Mono<Void> putAll(java.util.Map<? extends K, ? extends V> map);

    /**
     * remove item from cache
     *
     * @param key key value
     * @return void
     */
    Mono<Void> remove(@NotNull K key);

    /**
     * remove item from cache and return the item
     *
     * @param key key
     * @return value
     */
    Mono<V> getAndRemove(@NotNull K key);

    /**
     * remove all items from cache
     *
     * @param keys key list
     * @return void
     */
    Mono<Void> removeAll(Set<? extends K> keys);

    /**
     * contain value or not
     *
     * @param key key
     * @return exits mark
     */
    Mono<Boolean> containsKey(@NotNull K key);

    /**
     * get values
     *
     * @param keys keys
     * @return value flux
     */
    Flux<Tuple2<K, V>> getAll(Set<? extends K> keys);

    /**
     * get values
     *
     * @param prefix prefix
     * @return value flux
     */
    Flux<Tuple2<K, V>> findAllByPrefix(@NotNull String prefix);
}

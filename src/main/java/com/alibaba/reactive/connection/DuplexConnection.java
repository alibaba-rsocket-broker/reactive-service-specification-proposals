package com.alibaba.reactive.connection;

import io.netty.buffer.ByteBuf;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Duplex Connection
 *
 * @author leijuan
 */
public interface DuplexConnection {
    /**
     * Sends the source of Frames on this connection and returns the {@code Publisher} representing
     * the result of this send.
     *
     * @param frames Stream of {@code Frame}s to send on the connection.
     * @return {@code Publisher} that completes when all the frames are written on the connection
     * successfully and errors when it fails.
     */
    Mono<Void> send(Publisher<ByteBuf> frames);


    /**
     * Returns a stream of all {@code Frame}s received on this connection.
     *
     * <h2>Completion</h2>
     * <p>
     *
     * <h2>Error</h2>
     * <p>
     *
     * <h2>Multiple Subscriptions</h2>
     * <p>
     * Returned {@code Publisher} is not required to support multiple concurrent subscriptions.
     * RSocket will never have multiple subscriptions to this source. Implementations <em>MUST</em>
     * emit an {@link IllegalStateException} for subsequent concurrent subscriptions, if they do not
     * support multiple concurrent subscriptions.
     *
     * @return Stream of all {@code Frame}s received.
     */
    Flux<ByteBuf> receive();
}

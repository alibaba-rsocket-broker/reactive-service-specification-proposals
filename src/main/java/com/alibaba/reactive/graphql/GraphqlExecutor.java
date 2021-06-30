package com.alibaba.reactive.graphql;

import io.netty.buffer.ByteBuf;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * GraphQL Executor for client
 *
 * @author leijuan
 */
public interface GraphqlExecutor {

    /**
     * used for network transportation
     *
     * @param invocationData invocation data
     * @return map result
     */
    Mono<ByteBuf> execute(ByteBuf invocationData);

    /**
     * used for network transportation
     *
     * @param invocationData invocation data
     * @return map stream
     */
    Flux<ByteBuf> subscribe(ByteBuf invocationData);

    default Mono<Map<String, Object>> execute(@Language("GraphQL") @NotNull String query) {
        return execute(query, null, null);
    }

    default Mono<Map<String, Object>> execute(@Language("GraphQL") String query,
                                              @NotNull Map<String, Object> variables) {
        return execute(query, variables, null);
    }

    /**
     * execute  GraphQL query, include Query, Mutation and Subscription
     *
     * @param query         query document
     * @param variables     variables
     * @param operationName operation name
     * @return map of the result that strictly follows the GraphQL spec
     */
    default Mono<Map<String, Object>> execute(@Language("GraphQL") @NotNull String query,
                                              @Nullable Map<String, Object> variables,
                                              @Nullable String operationName) {
        return execute(GraphqlJsonUtils.queryToJsonByteBuf(query, variables, operationName))
                .map(GraphqlJsonUtils::convertResultToMap);
    }

    default Flux<Map<String, Object>> subscribe(@Language("GraphQL") @NotNull String subscription) {
        return subscribe(subscription, null);
    }

    /**
     * GraphQL subscribe
     *
     * @param subscription subscription
     * @param variables    variables
     * @return data flux
     */
    default Flux<Map<String, Object>> subscribe(@Language("GraphQL") @NotNull String subscription,
                                                @Nullable Map<String, Object> variables) {
        return subscribe(GraphqlJsonUtils.queryToJsonByteBuf(subscription, variables, null))
                .map(GraphqlJsonUtils::convertResultToMap);
    }
}

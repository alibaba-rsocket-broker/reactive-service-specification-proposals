package com.alibaba.reactive.graphql;

import org.intellij.lang.annotations.Language;

/**
 * GraphQL query language annotation
 *
 * @author linux_china
 */
public @interface Gql {

    /**
     * GraphQL Query language
     *
     * @return query
     */
    @Language("GraphQL") String value();

    /**
     * operation name, such as query, mutation, subscription
     *
     * @return operation name
     */
    String operation() default "";
}

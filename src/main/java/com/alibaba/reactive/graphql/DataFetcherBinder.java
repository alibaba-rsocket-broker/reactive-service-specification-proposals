package com.alibaba.reactive.graphql;

import java.lang.annotation.*;

/**
 * Bind a method to be a data fetcher
 *
 * @author linux_china
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DataFetcherBinder {
    String parentType();

    String field() default "";
}

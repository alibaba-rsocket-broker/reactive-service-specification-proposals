package com.alibaba.reactive.graphql;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DataFetcherBinder(parentType = "Query")
public @interface Query {

    String field() default "";
}

package com.alibaba.reactive.graphql;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DataFetcherBinder(parentType = "Subscription")
public @interface Subscription {
    String field() default "";
}

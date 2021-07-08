package com.alibaba.reactive.graphql;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DataFetcherBinder(parentType = "Mutation")
public @interface Mutation {

    String field() default "";
}

package com.alibaba.reactive.graphql;

import java.util.Map;

/**
 * GraphQL query exception
 *
 * @author linux_china
 */
public class GraphqlQueryException extends Exception {
    private Map<String, Object> result;

    public GraphqlQueryException(Map<String, Object> result) {
        super(result.get("errors").toString());
        this.result = result;
    }

    public Map<String, Object> getResult() {
        return result;
    }
}

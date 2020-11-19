package com.alibaba.reactive.observability;

import java.util.Map;
import java.io.Serializable;

/**
 * tracing Span
 *
 * @author leijuan
 */
public class Span implements Serializable {
    /**
     * trace id: uuid
     */
    private String traceId;
    /**
     * span id
     */
    private Long id;
    /**
     * parent span id
     */
    private Long parentId;
    /**
     * span kind: SPAN_KIND_UNSPECIFIED = 0, CLIENT = 1
     */
    private byte kind;
    /**
     * endpoint to trigger span
     */
    private String endpoint;
    /**
     * span name
     */
    private String name;
    /**
     * timestamp for span's start event
     */
    private long timestamp;
    /**
     * duration for span's start event,and unit is nanosecond(纳秒, 十亿分之一秒），持续的最长时间为292年
     */
    private long duration;
    /**
     * span tags
     */
    private Map<String, String> tags;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public byte getKind() {
        return kind;
    }

    public void setKind(byte kind) {
        this.kind = kind;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }
}

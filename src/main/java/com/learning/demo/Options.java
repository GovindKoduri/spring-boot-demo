package com.learning.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Options {
    @JsonProperty("model")
    private String model;

    @JsonProperty("usage")
    private Usage usage;

    @JsonProperty("source")
    private String source;

    @JsonProperty("contexts")
    private List<Object> contexts;
}

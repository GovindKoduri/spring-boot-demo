package com.learning.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties({"message"})
public class PsChatResponse {

    @JsonProperty("data")
    private Data data;
}

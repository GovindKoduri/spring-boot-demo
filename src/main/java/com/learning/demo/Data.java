package com.learning.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties({"participants", "message"})
public class Data {

    @JsonProperty("id")
    private String id;

    @JsonProperty("userid")
    private String userid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonIgnore
    private Options options;

    @JsonProperty("messages")
    private List<Message> messages;
}

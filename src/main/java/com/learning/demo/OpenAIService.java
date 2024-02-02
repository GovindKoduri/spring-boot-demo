package com.learning.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class OpenAIService {
    @Autowired
    private OpenAIConfig openAIConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public OpenAIService(RestTemplate restTemplate, OpenAIConfig openAIConfig) {
        this.restTemplate = restTemplate;
        this.openAIConfig = openAIConfig;
    }

    public String callOpenAI(String search) {
        //log.info("search data: {}", search);
        String apiKey = openAIConfig.getApiKey();
        String apiUrl = "https://api.psnext.info/api/chat";

        // Replace with your actual JSON payload
        String jsonPayload = "{\n" +
                "    \"message\":\"" + search + "\",\n" +
                "    \"options\": \n" +
                "        {\n" +
                "        \"model\": \"gpt35turbo\"\n" +
                "        }\n" +
                "}";

        // Set up headers with the content type
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers and the JSON payload
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayload, headers);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make the POST request
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, String.class);

        try {
            PsChatResponse psChatResponse = new ObjectMapper().readValue(responseEntity.getBody(), PsChatResponse.class);
            return psChatResponse.getData().getMessages().get(2).getContent();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.learning.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/avengers-ai")
public class OpenAIController {

    @Autowired
    private OpenAIService openAIService;

    @GetMapping("/call")
    public String callOpenAI(@RequestParam(name = "search") String search) {
        return openAIService.callOpenAI(search);
    }
}

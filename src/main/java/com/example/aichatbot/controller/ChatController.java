package com.example.aichatbot.controller;

import com.example.aichatbot.model.ChatRequest;
import com.example.aichatbot.model.ChatResponse;
import com.example.aichatbot.service.OpenAIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatController {

    private final OpenAIService openAIService;

    public ChatController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {

        String reply = openAIService.chat(request.getMessage());

        return new ChatResponse(reply);
    }
}
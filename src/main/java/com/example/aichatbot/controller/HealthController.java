package com.example.aichatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "Application is running!";
    }

    @GetMapping("/")
    public String root() {
        return "Welcome to AI Chatbot Application";
    }
}


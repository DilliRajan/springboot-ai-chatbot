package com.example.aichatbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import java.util.Map;
import java.util.List;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public OpenAIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String chat(String message) {
        // Validate API key
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new RuntimeException("OpenAI API key is not configured. Please set the OPENAI_API_KEY environment variable.");
        }

        try {
            String url = "https://api.openai.com/v1/chat/completions";

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> requestBody = Map.of(
                    "model", "gpt-3.5-turbo",
                    "messages", new Object[]{
                            Map.of("role", "user", "content", message)
                    },
                    "max_tokens", 150
            );

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(url, entity, Map.class);

            if (response.getBody() == null) {
                throw new RuntimeException("Empty response from OpenAI API");
            }

            Map<String, Object> responseBody = response.getBody();
            List<?> choices = (List<?>) responseBody.get("choices");

            if (choices == null || choices.isEmpty()) {
                throw new RuntimeException("No choices returned from OpenAI API");
            }

            Map<String, Object> choice = (Map<String, Object>) choices.get(0);
            Map<String, Object> messageMap = (Map<String, Object>) choice.get("message");

            Object content = messageMap.get("content");
            return content != null ? content.toString() : "No response content";

        } catch (RestClientException e) {
            throw new RuntimeException("Error calling OpenAI API: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error processing OpenAI response: " + e.getMessage(), e);
        }
    }
}
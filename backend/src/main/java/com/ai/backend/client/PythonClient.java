package com.ai.backend.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Component
public class PythonClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getAnswer(String question) {
        String url = "http://localhost:8000/ask";

        Map<String, String> body = new HashMap<>();
        body.put("question", question);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, body, Map.class);

        return response.getBody().get("answer").toString();
    }
}
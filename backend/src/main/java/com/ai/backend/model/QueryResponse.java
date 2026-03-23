package com.ai.backend.model;

public class QueryResponse {
    private String answer;

    public QueryResponse(String answer) {
        this.answer = answer;
    }

    public String getAnswer() { return answer; }
}

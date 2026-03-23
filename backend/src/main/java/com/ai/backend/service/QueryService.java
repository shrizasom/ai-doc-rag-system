package com.ai.backend.service;

import com.ai.backend.client.PythonClient;
import com.ai.backend.model.QueryRequest;
import com.ai.backend.model.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    @Autowired
    private PythonClient pythonClient;

    public QueryResponse ask(QueryRequest request) {
        String answer = pythonClient.getAnswer(request.getQuestion());
        return new QueryResponse(answer);
    }
}

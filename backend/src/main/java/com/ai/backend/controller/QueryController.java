package com.ai.backend.controller;

import com.ai.backend.service.QueryService;
import com.ai.backend.model.QueryRequest;
import com.ai.backend.model.QueryResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping("/ask")
    public QueryResponse ask(@RequestBody QueryRequest request) {
        return queryService.ask(request);
    }
}

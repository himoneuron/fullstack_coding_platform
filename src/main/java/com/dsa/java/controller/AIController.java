package com.dsa.java.controller;

import com.dsa.java.ai.AIService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/explain")
    public String explain(@RequestBody Map<String, Object> body) {

        String problemId = (String) body.get("problemId");
        Map<String, Object> input = (Map<String, Object>) body.get("input");
        Object output = body.get("output");

        return aiService.explain(problemId, input, output);
    }
}
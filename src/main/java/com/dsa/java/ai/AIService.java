package com.dsa.java.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AIService {

    private final ChatClient chatClient;

    public AIService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String explain(String problemId, Map<String, Object> input, Object output) {

        String prompt = """
        You are a DSA expert.

        Problem: %s
        Input: %s
        Output: %s

        Explain:
        1. What is happening
        2. Approach used
        3. Optimal solution
        4. Time & Space Complexity

        Keep it simple and structured.
        """.formatted(problemId, input, output);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
package com.dsa.java.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "execution_logs")
public class ExecutionLog {

    @Id
    private String id;

    private String problemId;
    private Map<String, Object> input;
    private Object output;
    private LocalDateTime timestamp;

    // ✅ ADD THIS CONSTRUCTOR
    public ExecutionLog(String problemId, Map<String, Object> input, Object output) {
        this.problemId = problemId;
        this.input = input;
        this.output = output;
        this.timestamp = LocalDateTime.now(); // 🔥 IMPORTANT
    }

    // empty constructor (required)
    public ExecutionLog() {}

    // getters + setters
}
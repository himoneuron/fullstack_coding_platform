package com.dsa.java.service;

import com.dsa.java.model.ExecutionLog;
import com.dsa.java.repository.ExecutionLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
@Service
public class ExecutionService {

    private final ExecutionLogRepository repository;

    public ExecutionService(ExecutionLogRepository repository) {
        this.repository = repository;
    }

     public void save(ExecutionLog log) {
        repository.save(log);
    }

    
    public String explain(String problem, String input) {

    return "This is a mock AI explanation:\n\n" +
           "We rotate the array using reversal algorithm.\n" +
           "Time Complexity: O(n)\n" +
           "Space Complexity: O(1)";
}
}
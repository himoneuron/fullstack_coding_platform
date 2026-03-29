package com.dsa.java.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.dsa.java.engine.executor.ExecutionEngine;


@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/execute")
public class ExecutionController {

    private final ExecutionEngine engine;

    public ExecutionController(ExecutionEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/{problemId}")
    public Object execute(
            @PathVariable("problemId") String problemId,
            @RequestBody Map<String, Object> input
    ) {
        return engine.execute(problemId, input);
    }
}
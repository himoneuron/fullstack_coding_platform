package com.dsa.java.engine.executor;

import com.dsa.java.engine.registry.solverRegistry;
import com.dsa.java.engine.solver.ProblemSolver;
import com.dsa.java.model.ExecutionLog;
import com.dsa.java.repository.ExecutionLogRepository;
import com.dsa.java.service.ExecutionService;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class ExecutionEngine {

    private final solverRegistry registry;
    private final ExecutionService executionService;

    public ExecutionEngine(solverRegistry registry, ExecutionService executionService) {
        this.registry = registry;
        this.executionService = executionService;
    }

    public Object execute(String problemId, Map<String, Object> input) {

        System.out.println("🔥 EXECUTE CALLED: " + problemId);

        ProblemSolver solver = registry.getSolver(problemId);

        Object output = solver.solve(input);

        System.out.println("🔥 OUTPUT: " + output);

        ExecutionLog log = new ExecutionLog(problemId, input, output);

        System.out.println("🔥 SAVING TO DB...");

        executionService.save(log);   // ✅ CLEAN

        return output;
    }
}
package com.dsa.java.engine.registry;

import com.dsa.java.engine.solver.ProblemSolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class solverRegistry {

    private final Map<String, ProblemSolver> solverMap = new HashMap<>();

    public solverRegistry(List<ProblemSolver> solvers) {
        for (ProblemSolver solver : solvers) {
            solverMap.put(solver.getProblemId(), solver);
        }
    }

    public ProblemSolver getSolver(String problemId) {
        if (!solverMap.containsKey(problemId)) {
            throw new RuntimeException("Solver not found: " + problemId);
        }
        return solverMap.get(problemId);
    }
}
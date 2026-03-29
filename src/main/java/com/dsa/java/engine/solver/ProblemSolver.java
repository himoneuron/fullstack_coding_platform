package com.dsa.java.engine.solver;

import java.util.Map;

public interface ProblemSolver {
    String getProblemId();
    String getCategory();
    String getSubCategory();
    Object solve(Map<String, Object> input);
}
package com.dsa.java.algorithms.arrayStrings.rotation;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dsa.java.engine.solver.ProblemSolver;

@Component
public class RotateArraySolver implements ProblemSolver {

    @Override
    public String getProblemId() {
        return "ARRAY_ROTATION";
    }

    @Override
    public String getCategory() {
        return "ARRAYS";
    }

    @Override
    public String getSubCategory() {
        return "ROTATION";
    }

    @Override
    public Object solve(Map<String, Object> input) {

    java.util.List<Integer> list = (List<Integer>) input.get("array");
    int[] arr = list.stream().mapToInt(i -> i).toArray();

    int k = (int) input.get("k");

    rotate(arr, k);

    return arr;
}

    private void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
package com.my.company.dynamicprogramming.maximumSubarrayProblem;

import org.apache.commons.lang3.tuple.ImmutableTriple;

public class Kadanes {
    public static void main(String[] args) {
        int[] A = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        ImmutableTriple result = findMaxSubarray(A);
        System.out.println(result);
    }

    public static ImmutableTriple findMaxSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ImmutableTriple(0, -1, 0); // Returns {sum, start_index, end_index}
        }

        int globalMaxSum = nums[0];
        int currentMaxSum = nums[0];
        int globalStart = 0;
        int globalEnd = 0;
        int currentStart = 0;

        for (int i = 1; i < nums.length; i++) {
            // Option 1: Start a new subarray with the current element
            // Option 2: Extend the previous subarray with the current element
            if (nums[i] > currentMaxSum + nums[i]) {
                currentMaxSum = nums[i];
                currentStart = i;
            } else {
                currentMaxSum = currentMaxSum + nums[i];
            }

            // Update the overall maximum sum and its indices
            if (currentMaxSum > globalMaxSum) {
                globalMaxSum = currentMaxSum;
                globalStart = currentStart;
                globalEnd = i;
            }
        }

        return new ImmutableTriple(globalMaxSum, globalStart, globalEnd);
    }
}

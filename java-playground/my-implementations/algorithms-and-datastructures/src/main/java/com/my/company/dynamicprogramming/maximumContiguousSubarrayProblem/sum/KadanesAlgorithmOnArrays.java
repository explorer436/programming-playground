package com.my.company.dynamicprogramming.maximumContiguousSubarrayProblem.sum;

import org.apache.commons.lang3.tuple.ImmutableTriple;

public class KadanesAlgorithmOnArrays {

    public static void main(String[] args) {
        int[] A = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        ImmutableTriple result = findMaxSubarray(A);
        System.out.println("maxSubSum:" + result.left);
        System.out.println("left index:" + result.middle);
        System.out.println("right index:" + result.right);
    }

    public static ImmutableTriple findMaxSubarray(int[] A) {
        if (A == null || A.length == 0) {
            return new ImmutableTriple(0, -1, 0); // Returns {sum, start_index, end_index}
        }

        int globalMaxSum = A[0];
        int currentMaxSum = A[0];
        int globalStart = 0;
        int globalEnd = 0;
        int currentStart = 0;

        for (int i = 1; i < A.length; i++) {
            // Option 1: Start a new subarray with the current element
            // Option 2: Extend the previous subarray with the current element
            if (A[i] > currentMaxSum + A[i]) {
                currentMaxSum = A[i];
                currentStart = i;
            } else {
                currentMaxSum = currentMaxSum + A[i];
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

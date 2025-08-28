package com.my.company.dynamicprogramming.maximumSubarrayProblem;

import org.apache.commons.lang3.tuple.ImmutableTriple;

public class DivideAndConquer {
    public static void main(String[] args) {
        int[] A = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};


    }

    private static ImmutableTriple maxSubSum(int[] A, int leftIndex, int rightIndex) {
        int maxSum = Integer.MIN_VALUE;

        if (leftIndex == rightIndex) {
            // termination condition
            if (A[leftIndex] > 0) {
                maxSum = A[leftIndex];
            } else {
                maxSum = Integer.MIN_VALUE;
            }
        } else {
            int centerIndex = leftIndex + (rightIndex - leftIndex) / 2;

            // Calculate the maxSum for the two halves
            ImmutableTriple abc = maxSubSum(A, leftIndex, centerIndex);
            int leftMaxSum = (int) abc.left;
            int leftBeginIndex = (int) abc.middle;
            int leftEndIndex = (int) abc.right;

            ImmutableTriple def = maxSubSum(A, centerIndex + 1, rightIndex);
            int rightMaxSum = (int) def.left;
            int rightBeginIndex = (int) def.middle;
            int rightEndIndex = (int) def.right;

            
        }
    }
}

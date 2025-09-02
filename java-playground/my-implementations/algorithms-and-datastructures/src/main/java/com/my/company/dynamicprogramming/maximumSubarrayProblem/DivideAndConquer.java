package com.my.company.dynamicprogramming.maximumSubarrayProblem;

import org.apache.commons.lang3.tuple.ImmutableTriple;

public class DivideAndConquer {
    public static void main(String[] args) {
        int[] A = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        ImmutableTriple result = maxSubSum(A, 0, A.length - 1);
        System.out.println(result);
    }

    private static ImmutableTriple maxSubSum(int[] A, int leftIndex, int rightIndex) {
        int maxSum;

        if (leftIndex == rightIndex) {
            // termination condition
            if (A[leftIndex] > 0) {
                maxSum = A[leftIndex];
            } else {
                maxSum = Integer.MIN_VALUE;
            }
            return new ImmutableTriple(leftIndex, maxSum, 0);
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

            int leftExtendMaxSum = 0;
            int leftExtendTempSum = 0;
            int tempIndex1 = 0;
            for (int i = centerIndex; i < centerIndex - 1; i++) {
                leftExtendTempSum += A[i];
                if (leftExtendTempSum > leftMaxSum) {
                    tempIndex1 = i;
                    leftExtendMaxSum = leftExtendTempSum;
                }
            }

            int rightExtendMaxSum = 0;
            int rightExtendTempSum = 0;
            int tempIndex2 = 0;
            for (int i = centerIndex + 1; i < rightIndex; i++) {
                rightExtendTempSum += A[i];
                if (rightExtendTempSum > rightExtendMaxSum) {
                    tempIndex2 = i;
                    rightExtendMaxSum = rightExtendTempSum;
                }
            }

            maxSum = leftExtendMaxSum + rightExtendMaxSum;
            int beginIndex = tempIndex1;
            int endIndex = tempIndex2;
            if (maxSum < leftMaxSum) {
                beginIndex = leftBeginIndex;
                endIndex = leftEndIndex;
                maxSum = leftMaxSum;
            }
            if (maxSum < rightMaxSum) {
                beginIndex = rightBeginIndex;
                endIndex = rightEndIndex;
                maxSum = rightMaxSum;
            }

            return new ImmutableTriple(beginIndex, endIndex, maxSum);
        }
    }
}

package com.my.company.dynamicprogramming.maximumContiguousSubarrayProblem.sum;

public class BruteForce2 {
    public static void main(String[] args) {
        int[] A = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = 0;
        int beginIndex = 0;
        int endIndex = 1;
        for (int i = 0; i < A.length; i++) {
            int tempSum = 0;
            for (int j = i; j < A.length; j++) {
                tempSum = tempSum + A[j];
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                    beginIndex = i;
                    endIndex = j;
                }
            }
        }

        System.out.println("beginIndex:" + beginIndex + " endIndex:" + endIndex);
        System.out.println("between " + A[beginIndex] + " and " + A[endIndex]);
    }
}

package com.my.company.dynamicprogramming.maximumContiguousSubarrayProblem;

public class DivideAndConquer {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    static int maxSubarraySum(int[] arr) {
        return MaxSum(arr, 0, arr.length - 1);
    }

    // Recursive function to calculate maximum subarray sum
    static int MaxSum(int[] arr, int left, int right) {

        // Invalid range
        if (left > right) {
            return Integer.MIN_VALUE;
        }

        // Base case: one element
        if (left == right) {
            return arr[left];
        }

        // Find middle point
        int centerIndex = left + (right - left) / 2;

        // Return the maximum of three cases:
        // 1. Maximum subarray sum in left half
        // 2. Maximum subarray sum in right half
        // 3. Maximum subarray sum crossing the midpoint
        return max(MaxSum(arr, left, centerIndex),
                MaxSum(arr, centerIndex + 1, right),
                maxCrossingSum(arr, left, centerIndex, right));
    }

    // Find the maximum possible sum in arr[] such that arr[m] is part of it
    static int maxCrossingSum(int[] arr, int l, int centerIndex, int right) {

        // Include elements on left of mid
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = centerIndex; i >= l; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        // Include elements on right of mid
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = centerIndex; i <= right; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        // Return maximum of left sum, right sum, and their combination
        return max(leftSum + rightSum - arr[centerIndex], leftSum, rightSum);
    }

    static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

}

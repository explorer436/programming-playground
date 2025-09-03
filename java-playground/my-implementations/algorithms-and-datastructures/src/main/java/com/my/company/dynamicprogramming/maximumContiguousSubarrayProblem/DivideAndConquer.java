package com.my.company.dynamicprogramming.maximumContiguousSubarrayProblem;

import org.apache.commons.lang3.tuple.ImmutableTriple;

public class DivideAndConquer {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    static ImmutableTriple<Integer, Integer, Integer> maxSubarraySum(int[] arr) {
        return MaxSum(arr, 0, arr.length - 1);
    }

    // Recursive function to calculate maximum subarray sum
    static ImmutableTriple<Integer, Integer, Integer> MaxSum(int[] arr, int left, int right) {

        // Base case: one element
        if (left == right) {
            return new ImmutableTriple<>(left, right, arr[left]);
        } else {
            // Find middle point
            int centerIndex = left + (right - left) / 2;

            ImmutableTriple leftlow_leftHigh_leftMax = MaxSum(arr, left, centerIndex);
            ImmutableTriple rightlow_rightHigh_rightMax = MaxSum(arr, centerIndex + 1, right);
            ImmutableTriple crossingLow_crossingHigh_crossingMax = maxCrossingSum(arr, left, centerIndex, right);

            // Return the maximum of three cases:
            // 1. Maximum subarray sum in left half
            // 2. Maximum subarray sum in right half
            // 3. Maximum subarray sum crossing the midpoint
            if ((int) leftlow_leftHigh_leftMax.right > (int) rightlow_rightHigh_rightMax.right && (int) leftlow_leftHigh_leftMax.right > (int) crossingLow_crossingHigh_crossingMax.right) {
                return leftlow_leftHigh_leftMax;
            } else if ((int) rightlow_rightHigh_rightMax.right > (int) leftlow_leftHigh_leftMax.right && (int) rightlow_rightHigh_rightMax.right > (int) crossingLow_crossingHigh_crossingMax.right) {
                return rightlow_rightHigh_rightMax;
            } else {
                return crossingLow_crossingHigh_crossingMax;
            }
        }
    }

    // Find the maximum possible sum in arr[] such that arr[m] is part of it
    static ImmutableTriple<Integer, Integer, Integer> maxCrossingSum(int[] arr, int left, int mid, int right) {

        int maxLeft = 0, maxRight = 0;

        // Include elements on left of mid
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        // Include elements on right of mid
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int j = mid + 1; j <= right; j++) {
            sum += arr[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        // Return maximum of left sum, right sum, and their combination
        return new ImmutableTriple<>(maxLeft, maxRight, leftSum + rightSum);
    }

}

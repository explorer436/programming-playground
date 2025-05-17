package com.my.company.datastructures.arrays;

public class EquilibriumIndexOfArray {

  public static void main(String[] args) {
    // TODO

  }

  // TODO implement this on your own.
  int solution(int A[], int N) {

    long sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum += (long) A[i];
    }
    long leftSum = 0;
    long rightSum = 0;

    for (int i = 0; i < A.length; i++) {
      rightSum = sum - (leftSum + A[i]);
      if (leftSum == rightSum) {
        return i;
      }
      leftSum += A[i];
    }
    return -1;
  }

  /*
   * In order to avoid O(N^2) and achieve O(N) performance: The key observation for better running time is to update the left/right sums in constant time instead of recomputing them from the scratch.
   */

  // TODO
  int equi(int arr[], int n) {
    if (n == 0) return -1;
    long sum = 0;
    int i;
    for (i = 0; i < n; i++) sum += (long) arr[i];

    long sum_left = 0;
    for (i = 0; i < n; i++) {
      long sum_right = sum - sum_left - (long) arr[i];
      if (sum_left == sum_right) return i;
      sum_left += (long) arr[i];
    }
    return -1;
  }

  // TODO
  public static int equilibriumIndex(int[] array) {
    int INDEX_NOT_FOUND = -1;
    int rSum = 0, lSum = 0;

    for (int index = 0; index < array.length; index++) {
      rSum += array[index];
    }

    for (int index = 0; index < array.length; index++) {
      lSum +=
          (index == 0) ? 0 : array[index - 1]; // cumulative sum before (left sum) the current index
      rSum -= array[index]; // sum after (right sum) the current index onwards
      if (lSum
          == rSum) { // if both sums, cumulative sum before the current index and cumulative sum
        // after the current index is equal, we got the equilibrium index
        return index;
      }
    }
    return INDEX_NOT_FOUND;
  }
}

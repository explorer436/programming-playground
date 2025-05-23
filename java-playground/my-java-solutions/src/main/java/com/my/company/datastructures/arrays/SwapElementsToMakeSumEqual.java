package com.my.company.datastructures.arrays;

import com.my.company.streamsapi.ReductionOperations;

public class SwapElementsToMakeSumEqual {

  public static void main(String[] args) {
    int[] A = {1, 8, 9, 10, 13};
    int[] B = {3, 5, 7, 11, 17};

    System.out.println("result : " + bruteForceSolution_slow(A, B, 5));

    System.out.println("result : " + solution_fast(A, B, 5));
  }

  // O(n power 2)
  public static boolean bruteForceSolution_slow(int[] A, int[] B, int m) {
    int sum_a = ReductionOperations.getSumOfAllElementsOfArray(A);

    int sum_b = ReductionOperations.getSumOfAllElementsOfArray(B);

    // aIndex = bIndex - but they don't have to be of equal length.
    for (int aIndex = 0; aIndex < A.length; aIndex++) {
      for (int bIndex = 0; bIndex < A.length; bIndex++) {
        int difference = B[bIndex] - A[aIndex];

        if (sum_a + difference == sum_b - difference) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * The best approach is to count the elements of array A and calculate the difference d between
   * the sums of the elements of array A and B. For every element of array B, we assume that we will
   * swap it with some element from array A. The difference d tells us the value from array A that
   * we are interested in swapping, because only one value will cause the two totals to be equal.
   * The occurrence of this value can be found in constant time from the array used for counting.
   */
  // O(n + m)
  public static boolean solution_fast(int[] A, int[] B, int m) {
    int sum_a = ReductionOperations.getSumOfAllElementsOfArray(A);

    int sum_b = ReductionOperations.getSumOfAllElementsOfArray(B);

    int difference = sum_b - sum_a;

    for (int bIndex = 0; bIndex < A.length; bIndex++) {
      int counterPart = B[bIndex] - difference;

      int[] arrACount = countingArrayElements(A);
      // System.out.println("countingArrayElements : " + Arrays.toString(abc));
      // [1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1]

      if (0 <= counterPart && counterPart <= m && 0 != arrACount[counterPart]) ;
      {
        return true;
      }
    }

    return false;
  }

  /*
   * If we know that all the elements are in the set {0, 1, . . . , m}, then the array used for counting should be of size m + 1.
   *
   * In our scenario, A = { 1, 8, 9, 10, 13 }. So, the length of count[] should be at least 13.
   */
  private static int[] countingArrayElements(int[] A) {
    int minElement = ReductionOperations.getMinElementInIntArray(A);
    int maxElement = ReductionOperations.getMaxElementInIntArray(A);

    int[] count = new int[maxElement - minElement + 1];

    // System.out.println(Arrays.toString(count));
    // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    // System.out.println("count length : " + count.length);
    // 13

    for (int aIndex = 0; aIndex < A.length; aIndex++) {
      count[A[aIndex] - 1] = count[A[aIndex] - 1] + 1;
    }

    return count;
  }
}

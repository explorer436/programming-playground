package com.my.company.datastructures.arrays;

import java.util.Arrays;

import com.my.company.codility.prefixsums.PrefixSums;

public class SubarraysWithNegativeSum {

  public static void main(String[] args) {

    int[] A;

    A = new int[] {1, -2, 4, -5, 1};
    solution(A);

    System.out.println();

    A = new int[] {1, -1};
    solution(A);

    System.out.println();

    A = new int[] {-2, -1};
    solution(A);

    System.out.println();

    A = new int[] {-2, 2, -1};
    solution(A);
  }

  /**
   * 1 -2 4 -5 1 |___| |___| |___| |___| |_______| |_______| |_______| |___________| |___________|
   * |_______________|
   */
  public static void solution(int[] A) {
    System.out.println("A : " + Arrays.toString(A));
    int negativeSubArrayCount = 0;

    if (null != A && A.length != 0) {
      if (A.length == 1) {
        if (A[0] < 0) {
          negativeSubArrayCount = negativeSubArrayCount + 1;
        }
      } else if (A.length > 1) {
        int[] prefixSums = PrefixSums.prefixSumsOfAnArray(A);

        for (int indexOfA = 0; indexOfA < A.length; indexOfA++) {
          for (int j = indexOfA; j < A.length; j++) {
            if (indexOfA == j) {
              if (A[indexOfA] < 0) {
                negativeSubArrayCount = negativeSubArrayCount + 1;
                System.out.println(
                    "found negativeSumArray at indices [" + indexOfA + ", " + j + "].");
              }
            } else {
              int upperSum = prefixSums[j];

              // REMEMBER - special condition when dealing with prefix sums.
              int lowerSum;
              if (indexOfA == 0) {
                lowerSum = 0;
              } else {
                lowerSum = prefixSums[indexOfA - 1];
              }

              int currentSum = upperSum - lowerSum;

              if (currentSum < 0) {
                negativeSubArrayCount = negativeSubArrayCount + 1;
                System.out.println(
                    "found negativeSumArray at indices [" + indexOfA + ", " + j + "].");
              }
            }
          }
        }
      }
    }

    System.out.println("negativeSubArrayCount : " + negativeSubArrayCount);
  }
}

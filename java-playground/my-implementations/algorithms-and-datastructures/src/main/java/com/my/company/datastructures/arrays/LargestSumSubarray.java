package com.my.company.datastructures.arrays;

public class LargestSumSubarray {

  public static void main(String[] args) {

    int[] A;

    A = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
    //                      |_____________|
    solution_noNeedToPrintIndices(A); // 7
    solution_printIndices(A); // 7, [startingIndex, endingIndex] = [2, 6]

    System.out.println();

    A = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    //                         |_________|
    solution_noNeedToPrintIndices(A); // 6
    solution_printIndices(A); // 6, [startingIndex, endingIndex] = [3, 6]

    System.out.println();

    A = new int[] {1, 1, -2, -3, 5};
    //                            |
    solution_noNeedToPrintIndices(A); // 5
    solution_printIndices(A); // 5, [startingIndex, endingIndex] = [4, 4]

    System.out.println();

    // all negative numbers
    A = new int[] {-2, -3, -1, -1, -2, -3};
    //                      |
    solution_noNeedToPrintIndices(A); // expected -1
    solution_printIndices(A); // -1, [startingIndex, endingIndex] = [2, 2]
  }

  /*
   * REMEMBER - always build a test case with all negative numbers.
   */

  /*
   * Brute force approach will be similar to the one implemented in MinAvgTwoSlice2.java
   */

  /**
   * See KadanesAlgorithm.pdf
   *
   * <p>A[0] A[1] A[2] A[3] A[4] A[5] A[6] A[7]
   * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   * -3 = -3 (discard) 5 = 5 (discard) -3 1 = 1 (discard) 5 -3 -2 = -2 (discard) 1 5 -3 -1 = -1
   * (discard) -2 1 5 -3 4 = 4 (currentMaxSum) -1 = 4 + -1 = 3 (currentMaxSum) -2 = 3 + -2 = 1
   * (currentMaxSum) 1 = 1 + 1 = 2 (currentMaxSum) 5 = 2 + 5 = 7 (currentMaxSum) -3 = 7 + -3 = 4
   * (currentMaxSum) -3 = -3 (currentMaxSum) 4 = -3 + 4 = 1 (discard) -1 -2 1 5 -3 -2
   * (currentMaxSum) -3 = -2 + -3 = -5 (discard) 4 -1 -2 1 5 -3
   *
   * <p>Keep track of currentMaxSum with every iteration and update globalMax when necessary.
   */

  /*
  	This includes single element arrays - in other words,
  	if there is one element in the array that is
  	greater than the sum of all the other elements combined,
  	that element is the result.
  */

  /*
   * Time Complexity: O(n)
   * Algorithmic Paradigm: Dynamic Programming
   */
  private static void solution_noNeedToPrintIndices(int[] A) {
    if (A.length > 0) {
      int currentMaxSum = A[0];
      int globalMax = A[0];

      for (int index = 1; index < A.length; index++) {
        int prevMaxSum = currentMaxSum;

        int prevMaxSumPlusCurrElement = prevMaxSum + A[index];

        currentMaxSum = A[index] > prevMaxSumPlusCurrElement ? A[index] : prevMaxSumPlusCurrElement;
        // same as - currentMaxSum = Math.max(A[index], prevMaxSumPlusCurrElement);

        if (currentMaxSum > globalMax) {
          globalMax = currentMaxSum;
        }
      }

      System.out.println("globalMax : " + globalMax);
    }
  }

  private static void solution_printIndices(int[] A) {
    if (A.length > 0) {
      int currentMaxSum = A[0];
      int globalMax = A[0];

      int startingIndex = 0;
      int globalMaxEndingIndex = 0;
      int globalMaxStartingPositionIndex = 0;

      for (int index = 1; index < A.length; index++) {
        int prevMaxSum = currentMaxSum;

        int prevMaxSumPlusCurrElement = prevMaxSum + A[index];

        if (A[index] != prevMaxSum) {
          if (A[index] > prevMaxSumPlusCurrElement) {
            currentMaxSum = A[index];
            startingIndex = index;
          } else {
            currentMaxSum = prevMaxSumPlusCurrElement;
          }
        }

        if (currentMaxSum > globalMax) {
          globalMax = currentMaxSum;
          globalMaxEndingIndex = index;
          globalMaxStartingPositionIndex = startingIndex;
        }
      }

      System.out.println(
          "globalMax : "
              + globalMax
              + ", [startingIndex, endingIndex] = ["
              + globalMaxStartingPositionIndex
              + ", "
              + globalMaxEndingIndex
              + "]");
    }
  }
}

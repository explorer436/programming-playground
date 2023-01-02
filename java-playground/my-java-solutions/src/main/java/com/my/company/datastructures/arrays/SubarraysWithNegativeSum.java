package com.my.company.datastructures.arrays;

import java.util.Arrays;

import com.my.company.codility.prefixsums.PrefixSums;

/**
 * We define the following:
 *
 * <p>A subarray of an n-element array is an array composed from a contiguous block of the original
 * array's elements. For example, if array = [1, 2, 3], then the subarrays are [1], [2], [3],
 * [1,2],[2,3], and [1,2,3]. Something like [1,3] would not be a subarray as it's not a contiguous
 * subsection of the original array.
 *
 * <p>The sum of an array is the total sum of its elements. An array's sum is negative if the total
 * sum of its elements is negative. An array's sum is positive if the total sum of its elements is
 * positive.
 *
 * <p>Given an array of n integers, find and print its number of negative subarrays on a new line.
 *
 * <p>Input Format
 *
 * <p>The first line contains a single integer,n, denoting the length of array . A = [a0, a1, ....,
 * an-1]. The second line contains n space-separated integers describing each respective element,
 * ai, in array A.
 *
 * <p>ConstraintsindexOfA 1 <= n <= 100
 *
 * <p>Output Format
 *
 * <p>Print the number of subarrays of A having negative sums.
 *
 * <p>Sample Input: 5 1 -2 4 -5 1
 *
 * <p>Sample Output: 9
 *
 * <p>Explanation: There are nine negative subarrays of A = [1,-2,4,-5,1]:
 *
 * <p>1. [0:1] => 1 + -2 = -1 2. [0:3] => 1 + -2 + 4 + -5 = -2 3. [0:4] => 1 + -2 + 4 + -5 + 1 = -1
 * 4. [1:1] => -2 5. [1:3] => -2 + 4 + -5 = -2 6. [1:4] => -2 + 4 + -5 + 1 = -2 7. [2:3] => 4 + -5 =
 * -1 8. [3:3] => -5 9. [3:4] => -5 + 1 = -4
 *
 * <p>Thus, we print 9 on a new line.
 */
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

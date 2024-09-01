package com.my.company.datastructures.arrays;

import com.my.company.datastructures.streamsapi.ReductionOperations;

import java.util.Arrays;

/**
 * Given an array of integers, find the sum of its elements.
 *
 * <p>For example, if the array ar = [1,2.3], 1 + 2 + 3 = 6, so return 6.
 *
 * <p>Function Description
 *
 * <p>Complete the simpleArraySum function in the editor below. It must return the sum of the array
 * elements as an integer.
 *
 * <p>simpleArraySum has the following parameter(s):
 *
 * <p>ar: an array of integers
 *
 * <p>Input Format
 *
 * <p>The first line contains an integer, n, denoting the size of the array. The second line
 * contains n space-separated integers representing the array's elements.
 *
 * <p>Constraints 0 < n, ar[i] <= 1000
 *
 * <p>Output Format
 *
 * <p>Print the sum of the array's elements as a single integer.
 *
 * <p>Sample Input
 *
 * <p>6 1 2 3 4 10 11
 *
 * <p>Sample Output
 *
 * <p>31
 *
 * <p>Explanation
 *
 * <p>We print the sum of the array's elements: .
 */
public class SimpleArraySum {

  public static void main(String[] args) {
    int[] inputArray = new int[] {1, 5, 2, 1, 4, 0};
    System.out.println(
        "result for input "
            + Arrays.toString(new int[] {1, 5, 2, 1, 4, 0})
            + " is "
            + simpleArraySum(inputArray));
    // 13

    // Using streams
    System.out.println("using stream API : " + ReductionOperations.getSumOfAllElementsOfArray(inputArray));
  }

  public static int simpleArraySum(int[] ar) {
    int result = 0;

    if (ar.length > 0) {
      for (int i : ar) {
        result = result + i;
      }
    }

    return result;
  }
}

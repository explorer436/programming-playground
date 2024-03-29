package com.my.company.datastructures.arrays;

import java.util.Arrays;

/**
 * Calculate and print the sum of the elements in an array, keeping in mind that some of those
 * integers may be quite large.
 *
 * <p>Function Description
 *
 * <p>Complete the aVeryBigSum function in the editor below. It must return the sum of all array
 * elements.
 *
 * <p>aVeryBigSum has the following parameter(s):
 *
 * <p>ar: an array of integers .
 *
 * <p>Input Format
 *
 * <p>The first line of the input consists of an integer n.
 *
 * <p>The next line contains "n" space-separated integers contained in the array.
 *
 * <p>Output Format
 *
 * <p>Print the integer sum of the elements in the array.
 *
 * <p>Constraints: 1 <= n <= 10 0 <= ar[i] <= (10 power 10)
 *
 * <p>Sample Input
 *
 * <p>5 1000000001 1000000002 1000000003 1000000004 1000000005
 *
 * <p>Output
 *
 * <p>5000000015
 *
 * <p>Note:
 *
 * <p>The range of the 32-bit integer is (-2 power 31) to ((2 power 31) -1) or [-2147483648,
 * 2147483647] .
 *
 * <p>When we add several integer values, the resulting sum might exceed the above range. You might
 * need to use long long int in C/C++ or long data type in Java to store such sums.
 */
public class VeryBigArraySum {

  public static void main(String[] args) {
    System.out.println(
        "result for input "
            + Arrays.toString(
                new long[] {1000000001, 1000000002, 1000000003, 1000000004, 1000000005})
            + " is "
            + aVeryBigSum(new long[] {1000000001, 1000000002, 1000000003, 1000000004, 1000000005}));
  }

  static long aVeryBigSum(long[] ar) {
    long result = 0;

    if (ar.length > 0) {
      for (long i : ar) {
        result = result + i;
      }
    }

    return result;
  }
}

package com.my.company.fractions;

/**
 * Given an array of integers, calculate the fractions of its elements that are positive, negative,
 * and are zeros. Print the decimal value of each fraction on a new line.
 *
 * <p>Note: This challenge introduces precision problems. The test cases are scaled to six decimal
 * places, though answers with absolute error of up to (10 power -4) are acceptable.
 *
 * <p>For example, given the array arr = [1,1,0,-1,-1] there are 5 elements, two positive, two
 * negative andone zero. Their ratios would be 2/5 = 0.400000, 2/5 = 0.400000 and 1/5 = 0.200000. It
 * should be printed as 0.400000 0.400000 0.200000
 *
 * <p>Function Description : Complete the plusMinus function in the editor below. It should print
 * out the ratio of positive, negative andzero items in the array, each on a separate line rounded
 * to six decimals. plusMinus has the following parameter(s): arr: an array of integers
 *
 * <p>Input Format The first line contains an integer, n, denoting the size of the array. The second
 * line contains n space-separated integers describing an array of numbers
 * arr(arr[0],arr[1],arr[2],...,arr[n-1])
 *
 * <p>Constrants: 0 < n <= 100 -100 <= arr[i] <= 100
 *
 * <p>Output format: You must print the following 3 lines: 1. A decimal representing of the fraction
 * of positive numbers in the array compared to its size. 2. A decimal representing of the fraction
 * of negative numbers in the array compared to its size. 3. A decimal representing of the fraction
 * of zeros in the array compared to its size.
 *
 * <p>Sample Input: 6 -4 3 -9 0 4 1
 *
 * <p>Sample Output: 0.500000 0.333333 0.166667
 *
 * <p>Explanation: There are 3 positive numbers, 2 negative numbers, and 1 zero in the array. The
 * proportions of occurrence are positive: 3/6 = 0.500000, negative: 2/6 = 0.333333 and zeros: 1/6 =
 * 0.166667.
 */
public class PlusMinus {

  public static void main(String[] args) {
    plusMinus(new int[] {-4, 3, -9, 0, 4, 1});
  }

  static void plusMinus(int[] arr) {

    float negativeNumbersCount = 0;
    float positiveNumbersCount = 0;
    float zeroesCount = 0;

    for (int i : arr) {
      if (i < 0) {
        negativeNumbersCount++;
      } else if (i > 0) {
        positiveNumbersCount++;
      } else {
        zeroesCount++;
      }
    }

    System.out.println("negativeNumbersCount : " + negativeNumbersCount);
    System.out.println("positiveNumbersCount : " + positiveNumbersCount);
    System.out.println("zeroesCount : " + zeroesCount);

    // Format Float to n decimal places
    System.out.println(String.format("%.6f", positiveNumbersCount / arr.length));
    System.out.println(String.format("%.6f", negativeNumbersCount / arr.length));
    System.out.println(String.format("%.6f", zeroesCount / arr.length));
  }
}

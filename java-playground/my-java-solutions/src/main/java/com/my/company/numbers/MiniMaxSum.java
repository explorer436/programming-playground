package com.my.company.numbers;

import java.math.BigDecimal;
import java.util.Arrays;

// REMEMBER
// Started out solving for this using integers. That blew up as the ranges of the numbers in the
// test cases kept growing bigger.
// When doing operations with BigInteger, do not try to convert the result back into int using
// BigInteger.intValue().
// Not sure what that is doing but it was giving negative values for large BigDecimal values.
// Just print the BigDecimal values on the console.
// This might turn into a problem in scenarios where an integer or a long value has to be returned
// from the method.

public class MiniMaxSum {

  public static void main(String[] args) {
    System.out.println("result for input " + Arrays.toString(new int[] {1, 2, 3, 4, 5}) + " is ");
    miniMaxSum(new int[] {1, 2, 3, 4, 5});

    System.out.println();

    System.out.println("result for input " + Arrays.toString(new int[] {1, 3, 5, 7, 9}) + " is ");
    miniMaxSum(new int[] {1, 3, 5, 7, 9});

    System.out.println();

    System.out.println("result for input " + Arrays.toString(new int[] {-1, -2, 3, 4, 5}) + " is ");
    miniMaxSum(new int[] {-1, -2, 3, 4, 5});

    System.out.println();

    System.out.println(
        "result for input " + Arrays.toString(new int[] {7, 69, 2, 211, 8974}) + " is ");
    miniMaxSum(new int[] {7, 69, 2, 211, 8974});

    System.out.println();

    System.out.println("result for input " + Arrays.toString(new int[] {5, 5, 5, 5, 5}) + " is ");
    miniMaxSum(new int[] {5, 5, 5, 5, 5});

    System.out.println();

    System.out.println(
        "result for input "
            + Arrays.toString(new int[] {793810624, 895642170, 685903712, 623789054, 468592370})
            + " is ");
    miniMaxSum(new int[] {793810624, 895642170, 685903712, 623789054, 468592370});
    // Expected Output 		    2572095760 2999145560

  }

  static void miniMaxSum(int[] ar) {
    BigDecimal totalSum = simpleArraySum(ar);

    // initialize the values to totalSum minus the first element in the list.
    BigDecimal maxSum = totalSum.subtract(new BigDecimal(ar[0]));
    BigDecimal minSum = totalSum.subtract(new BigDecimal(ar[0]));

    for (int i : ar) {
      // BigDecimalA.compareTo(BigDecimalB) : -1, 0, or 1 as BigDecimalB is numerically less than,
      // equal to, or greater than BigDecimalA.

      BigDecimal totalSumMinusCurrentElement = totalSum.subtract(new BigDecimal(i));

      boolean isTotalSumMinusCurrentElementGreaterThanCurrentMaxSum =
          totalSumMinusCurrentElement.compareTo(maxSum) > 0 ? true : false;
      boolean isTotalSumMinusCurrentElementLesserThanCurrentMinSum =
          minSum.compareTo(totalSumMinusCurrentElement) > 0 ? true : false;

      if (isTotalSumMinusCurrentElementGreaterThanCurrentMaxSum) {
        maxSum = totalSumMinusCurrentElement;
      }

      if (isTotalSumMinusCurrentElementLesserThanCurrentMinSum) {
        minSum = totalSumMinusCurrentElement;
      }
    }

    System.out.print(minSum + " " + maxSum);
  }

  static BigDecimal simpleArraySum(int[] ar) {
    BigDecimal result = new BigDecimal(0);

    if (ar.length > 0) {
      for (int i : ar) {
        result = result.add(new BigDecimal(i));
      }
    }

    return result;
  }

}

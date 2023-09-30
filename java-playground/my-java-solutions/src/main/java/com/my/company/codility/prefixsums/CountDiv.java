package com.my.company.codility.prefixsums;

/**
 * Level : Respectable
 *
 * <p>Compute number of integers divisible by k in range [a..b].
 *
 * <p>Write a function:
 *
 * <p>class Solution { public int solution(int A, int B, int K); }
 *
 * <p>that, given three integers A, B and K, returns the number of integers within the range [A..B]
 * that are divisible by K, i.e.:
 *
 * <p>{ i : A <= i <= B, i mod K = 0 }
 *
 * <p>For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are
 * three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * <p>Assume that:
 *
 * <p>A and B are integers within the range [0..2,000,000,000]; K is an integer within the range
 * [1..2,000,000,000]; A <= B.
 *
 * <p>Complexity: expected worst-case time complexity is O(1); expected worst-case space complexity
 * is O(1).
 */
public class CountDiv {

  public static void main(String[] args) throws Exception {
    int result = solution(6, 11, 2);
    if (3 != result) {
      throw new Exception("wrong answer - expected " + 3 + " but received " + result);
    }

    result = solution(6, 11, 3);
    if (2 != result) {
      throw new Exception("wrong answer - expected " + 2 + " but received " + result);
    }

    result = solution(6, 11, 3);
    if (20 != result) {
      throw new Exception("wrong answer - expected " + 20 + " but received " + result);
    }

    /*
     * A = 11, B = 345, K = 17 WRONG ANSWER got 19 expected 20
     */
  }

  // How is this solution using prefix sums?
  // Using the concept of prefix sums helps with the fact that (B/K) - ((A-1)/K) is not the same as
  // (B - (A - 1))/K
  public static int solution(int A, int B, int K) {
    // Explanation: Number of integers in the range [1 .. X] that divisible by K is
    // X/K.
    // So, within the range [A .. B], the result is B/K - (A - 1)/K

    // Note : This is not the same as (B - (A -1))/K

    int bDividedByK = B / K;

    int aDividedByK;
    if (A > 0) {
      aDividedByK = (A - 1) / K;
    } else {
      aDividedByK = 0;
    }

    if (0 == A) {
      bDividedByK = bDividedByK + 1;
    }

    return bDividedByK - aDividedByK;
  }
}

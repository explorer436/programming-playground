package com.my.company.codility.prefixsums;

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

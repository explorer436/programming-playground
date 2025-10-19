package com.my.company.datastructures.arrays;

import java.util.Arrays;

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

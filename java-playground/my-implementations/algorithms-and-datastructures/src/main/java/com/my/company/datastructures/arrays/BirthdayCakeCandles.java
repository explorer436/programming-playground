package com.my.company.datastructures.arrays;

import java.util.Arrays;

public class BirthdayCakeCandles {

  public static void main(String[] args) {
    System.out.println(
        "result for input "
            + Arrays.toString(new int[] {3, 2, 1, 3})
            + " is "
            + birthdayCakeCandles(new int[] {3, 2, 1, 3}));

    System.out.println();

    System.out.println(
        "result for input "
            + Arrays.toString(new int[] {4, 4, 1, 3})
            + " is "
            + birthdayCakeCandles(new int[] {4, 4, 1, 3}));

    System.out.println();
  }

  static int birthdayCakeCandles(int[] ar) {

    Integer highestLengthCandle = ar[0];
    Integer count = 0;

    for (int i = 0; i < ar.length; i++) {
      if (ar[i] > highestLengthCandle) {
        highestLengthCandle = ar[i];
        count = 1;
      } else if (ar[i] == highestLengthCandle) {
        count = count + 1;
      }
    }

    return count;
  }
}

package com.my.company.datastructures.arrays;

import com.my.company.streamsapi.ReductionOperations;

import java.util.Arrays;

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

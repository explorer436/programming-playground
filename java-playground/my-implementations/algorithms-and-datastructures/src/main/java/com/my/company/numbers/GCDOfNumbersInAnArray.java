package com.my.company.numbers;

import java.util.Arrays;
import java.util.List;

public class GCDOfNumbersInAnArray {

  public static void main(String[] args) {

    int[] nums = new int[] {16, 32, 96};

    System.out.println(
        "GCD of all elements of the array "
            + Arrays.toString(nums)
            + " calculated using stream reduce is "
            + getGcd(nums));
  }

  public static int getGcd(List<Integer> inputList) {
    GCDOfTwoNumbersUsingEuclideanAlgorithm gcd = new GCDOfTwoNumbersUsingEuclideanAlgorithm();

      return inputList.stream().reduce(0, gcd::gcd);
  }

  public static int getGcd(int[] A) {
    GCDOfTwoNumbersUsingEuclideanAlgorithm gcd = new GCDOfTwoNumbersUsingEuclideanAlgorithm();

      return Arrays.stream(A).reduce(0, gcd::gcd);
  }


}

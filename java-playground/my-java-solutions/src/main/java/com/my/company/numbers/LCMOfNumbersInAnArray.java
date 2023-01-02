package com.my.company.numbers;

import java.util.Arrays;
import java.util.List;

public class LCMOfNumbersInAnArray {

  public static void main(String[] args) {

    int[] nums = new int[] {2, 4};
    System.out.println(
        "LCM of all elements of the array "
            + Arrays.toString(nums)
            + " calculated using stream reduce is "
            + getLcm(nums));

    nums = new int[] {2, 6};
    System.out.println(
        "LCM of all elements of the array "
            + Arrays.toString(nums)
            + " calculated using stream reduce is "
            + getLcm(nums));

    Integer[] a = new Integer[] {2, 4};
    System.out.println(
        "LCM of all elements of the array "
            + Arrays.toString(a)
            + " calculated using stream reduce is "
            + getLcm(Arrays.asList(a)));
  }

  public static int getLcm(List<Integer> inputList) {
    Integer lcmOfAllElementsOfAnArrayCalculatedUsingStreamReduce =
        inputList.stream()
            // .boxed()
            .reduce(1, (a, b) -> LCMOfTwoNumbers.lcmUsingEuclideanAlgorithm(a, b));

    return lcmOfAllElementsOfAnArrayCalculatedUsingStreamReduce;
  }

  public static int getLcm(int[] A) {
    Integer lcmOfAllElementsOfAnArrayCalculatedUsingStreamReduce =
        Arrays.stream(A)
            .boxed()
            .reduce(1, (a, b) -> LCMOfTwoNumbers.lcmUsingEuclideanAlgorithm(a, b));

    return lcmOfAllElementsOfAnArrayCalculatedUsingStreamReduce;
  }
}

package com.my.company.numbers;

import java.util.Arrays;
import java.util.List;

public class LCMOfNumbersInACollection {

  public static int getLcmOfNumbersInAList(List<Integer> inputList) {
      // .boxed()

      return inputList.stream()
          // .boxed()
          .reduce(1, LCMUsingEuclideanAlgorithm::lcmUsingEuclideanAlgorithm);
  }

  public static int getLcmOfNumbersInAnArray(int[] A) {

      return Arrays.stream(A)
          .boxed()
          .reduce(1, LCMUsingEuclideanAlgorithm::lcmUsingEuclideanAlgorithm);
  }
}

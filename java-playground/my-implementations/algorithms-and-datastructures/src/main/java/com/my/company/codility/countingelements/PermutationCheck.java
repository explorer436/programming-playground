package com.my.company.codility.countingelements;

import java.util.Arrays;

public class PermutationCheck {

  (String[] args) throws Exception {
    int[] A = {4, 1, 3, 2};

    int result;

    result = solution(A);
    if (result != 1) {
      throw new Exception("wrong answer - expected " + 1 + " but received " + result);
    }

    int[] A2 = {4, 1, 3};
    result = solution(A2);
    if (result != 0) {
      throw new Exception("wrong answer - expected " + 0 + " but received " + result);
    }

    int[] A3 = {1};
    result = solution(A3);
    if (result != 1) {
      throw new Exception("wrong answer - expected " + 1 + " but received " + result);
    }

    int[] A4 = {2};
    result = solution(A4);
    if (result != 0) {
      throw new Exception("wrong answer - expected " + 0 + " but received " + result);
    }

    int[] A5 = {};
    result = solution(A5);
    if (result != 0) {
      throw new Exception("wrong answer - expected " + 0 + " but received " + result);
    }

    System.out.println("done");
  }

  public static int solution(int[] A) {
    int result = 0;
    if (A.length > 0) {
      Arrays.sort(A);

      boolean allNumbersInThePermutationExist = false;

      // check for the existence of each number starting from 1 in the sorted array.
      for (int i = 0; i < A.length; i++) {
        if ((i + 1) == A[i]) {
          allNumbersInThePermutationExist = true;
        } else {
          allNumbersInThePermutationExist = false;
          break;
        }
      }

      if (allNumbersInThePermutationExist) {
        result = 1;
      }
    }
    return result;
  }
}

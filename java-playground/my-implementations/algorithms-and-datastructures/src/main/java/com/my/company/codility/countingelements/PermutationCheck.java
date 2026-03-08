package com.my.company.codility.countingelements;

import java.util.Arrays;

public class PermutationCheck {

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

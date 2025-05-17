package com.my.company.codility.timecomplexity;

import java.util.Arrays;

public class PermMissingElem {

  public static void main(String[] args) throws Exception {
    int result;

    int[] A = {2, 3, 1, 5};
    result = solution(A);
    if (result != 4) {
      throw new Exception("wrong answer - expected " + 4 + " but received " + result);
    }

    int[] A2 = {1};
    result = solution(A2);
    if (result != 2) {
      throw new Exception("wrong answer - expected " + 2 + " but received " + result);
    }

    int[] A3 = {1, 2, 3};
    result = solution(A3);
    if (result != 4) {
      throw new Exception("wrong answer - expected " + 4 + " but received " + result);
    }

    int[] A4 = {2, 3, 4};
    result = solution(A4);
    if (result != 1) {
      throw new Exception("wrong answer - expected " + 1 + " but received " + result);
    }

    int[] A5 = {};
    result = solution(A5);
    if (result != 1) {
      throw new Exception("wrong answer - expected " + 1 + " but received " + result);
    }

    System.out.println("done");
  }

  public static int solution(int[] A) {
    int result = 0;
    if (A.length > 0) {
      // O(N*log(N))
      Arrays.sort(A);

      for (int aIndex = 0; aIndex < A.length; aIndex++) {
        if ((aIndex + 1) != A[aIndex]) {
          result = aIndex + 1;
          break;
        }
      }
      if (0 == result) {
        result = A[A.length - 1] + 1;
      }
    } else {
      result = 1;
    }
    return result;
  }
}

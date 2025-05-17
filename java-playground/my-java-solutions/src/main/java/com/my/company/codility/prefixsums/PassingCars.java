package com.my.company.codility.prefixsums;

public class PassingCars {
  // A = [ 0, 1, 0, 1, 1]

  public static void main(String[] args) throws Exception {
    if (5 != solution(new int[] {0, 1, 0, 1, 1})) {
      throw new Exception("wrong answer");
    }

    if (1 != solution(new int[] {0, 1})) {
      throw new Exception("wrong answer");
    }

    if (0 != solution(new int[] {1, 0})) {
      throw new Exception("wrong answer");
    }

    System.out.println("done");
  }

  /*
   * assuming 0 represents cars going in the right direction and 1 represents cars going in the left direction.
   *
   *  ->      ->
   * 	0,	1,	0,	1,	1
   *     <-      <-   <-
   */
  public static int solution(int[] A) {
    int right_count = 0;
    int passingCars = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        right_count = right_count + 1;
      }
      if (A[i] == 1) {
        // the car is going left.
        // all the cars going in the left direction will pass the cars that are going right.
        passingCars = passingCars + right_count;
      }
      if (passingCars > 1000000000) {
        return -1;
      }
    }
    return passingCars;
  }
}

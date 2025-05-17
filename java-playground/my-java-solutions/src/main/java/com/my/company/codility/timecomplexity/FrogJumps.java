package com.my.company.codility.timecomplexity;

public class FrogJumps {

  public static void main(String[] args) throws Exception {
    int result;

    result = solution(10, 85, 30);
    if (result != 3) {
      throw new Exception("wrong answer - expected " + 3 + " but received " + result);
    }

    result = solution(10, 70, 30);
    if (result != 2) {
      throw new Exception("wrong answer - expected " + 2 + " but received " + result);
    }

    System.out.println("done");
  }

  public static int solution(int X, int Y, int D) {
    int result = 0;
    if (Y > X && D != 0) {
      System.out.println("(Y - X) % D : " + (Y - X) % D);
      result = (((Y - X) % D) == 0) ? ((Y - X) / D) : (((Y - X) / D) + 1);
    }
    return result;
  }
}

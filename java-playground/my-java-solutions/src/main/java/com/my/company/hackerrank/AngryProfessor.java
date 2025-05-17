package com.my.company.hackerrank;

public class AngryProfessor {

  public static void main(String[] args) throws Exception {

    int[] a;
    String result;

    a = new int[] {-1, -3, 4, 2};
    result = angryProfessor(4, a);
    if (!"YES".equals(result)) {
      throw new Exception("wrong answer - expected " + "YES" + " but received " + result);
    }

    a = new int[] {0, -1, 2, 1};
    result = angryProfessor(2, a);
    if (!"NO".equals(result)) {
      throw new Exception("wrong answer - expected " + "NO" + " but received " + result);
    }

    a = new int[] {};
    result = angryProfessor(1, a);
    if (!"YES".equals(result)) {
      throw new Exception("wrong answer - expected " + "YES" + " but received " + result);
    }

    a = new int[] {0, -1, 2, 1};
    result = angryProfessor(2, a);
    if (!"NO".equals(result)) {
      throw new Exception("wrong answer - expected " + "NO" + " but received " + result);
    }

    a = new int[] {0, -1, 2, 1};
    result = angryProfessor(-2, a);
    if (!"NO".equals(result)) {
      throw new Exception("wrong answer - expected " + "NO" + " but received " + result);
    }

    System.out.println("done");
  }

  static String angryProfessor(int k, int[] a) {
    String classCancelled = "YES";

    if (null == a || k > a.length) {
      return classCancelled;
    } else {
      int count = 0;
      for (int i : a) {
        if (i <= 0) {
          count++;
        }

        if (count == k || count > k) {
          classCancelled = "NO";
          break;
        }
      }
    }

    return classCancelled;
  }
}

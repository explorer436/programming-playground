package com.my.company.recursion;

public class ChoosingKOutOfNThings {
  public static void main(String[] args) {
    System.out.println(getNumberOfGroups(5, 2));
  }

  public static int getNumberOfGroups(int n, int k) {
    if ((k == 0) || (k == n)) {
      return 1;
    } else if (k > n) {
      return 0;
    } else {
      return getNumberOfGroups(n - 1, k - 1) + getNumberOfGroups(n - 1, k);
    }
  }
}

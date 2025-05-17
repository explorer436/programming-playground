package com.my.company.recursion;

public class OrganizingAParade {
  public static void main(String[] args) {
    System.out.println(solve(20));
  }

  public static int solve(int n) {
    if (n == 1) {
      return 2;
    } else if (n == 2) {
      return 3;
    } else // n > 2, so n - 1 > 0 and n - 2 > 0
    {
      return solve(n - 1) + solve(n - 2);
    }
  }
}

package com.my.company.hackerrank;

import com.my.company.numbers.ReverseInteger;

public class BeautifulDaysAtTheMovies {

  public static void main(String[] args) throws Exception {
    int result;

    result = beautifulDays(20, 23, 6);
    if (2 != result) {
      throw new Exception("wrong answer - expected " + "2" + " but received " + result);
    }

    result = beautifulDays(13, 45, 3);
    if (33 != result) {
      throw new Exception("wrong answer - expected " + "33" + " but received " + result);
    }

    System.out.println("done");
  }

  private static int beautifulDays(int i, int j, int k) {
    int result = 0;

    ReverseInteger r = new ReverseInteger();
    for (int temp = i; temp <= j; i++) {
      if (Math.abs(i - r.reverseWithoutConvertingTheIntegerIntoString(i)) % k == 0) {
        result = result + 1;
      }

      temp++;
    }

    return result;
  }
}

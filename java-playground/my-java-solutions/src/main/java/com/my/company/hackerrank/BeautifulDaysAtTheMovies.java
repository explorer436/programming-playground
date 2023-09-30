package com.my.company.hackerrank;

import com.my.company.numbers.ReverseInteger;

/**
 * Lily likes to play games with integers. She has created a new game where she determines the
 * difference between a number and its reverse. For instance, given the number is 12, its reverse is
 * 21. Their difference is 9. The number 120 reversed is 21, and their difference is 99. . She
 * decides to apply her game to decision making. She will look at a numbered range of days and will
 * only go to a movie on a beautiful day . Given a range of numbered days, [i,...,j] and a number k,
 * determine the number of days in the range that are beautiful. Beautiful numbers are defined as
 * numbers where |i - reverse(i)| is evenly divisible by k. If a day's value is a beautiful number,
 * it is a beautiful day. Print the number of beautiful days in the range.
 *
 * <p>Function Description Complete the beautifulDays function in the editor below. It must return
 * the number of beautiful days in the range. beautifulDays has the following parameter(s): i: the
 * starting day number j: the ending day number k: the divisor
 *
 * <p>Input Format A single line of three space-separated integers describing the respective values
 * of i, j, and k.
 *
 * <p>Constraints 1 <= i <= j <= 2 * 10 ^ 6 1 <= k <= 2 * 10 ^ 9
 *
 * <p>Output Format Print the number of beautiful days in the inclusive range between i and j.
 *
 * <p>Sample Input 20 23 6 Sample Output 2 Explanation Lily may go to the movies on days 20, 21, 22
 * and 23. Only two days, 20 and 22, in this interval are beautiful. Thus, we print 2 as our answer.
 */
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

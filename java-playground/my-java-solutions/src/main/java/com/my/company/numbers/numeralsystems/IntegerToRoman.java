package com.my.company.numbers.numeralsystems;

import java.util.Collections;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * <p>Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, two is written as II in Roman
 * numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The
 * number twenty seven is written as XXVII, which is XX + V + II.
 *
 * <p>Roman numerals are usually written largest to smallest from left to right. However, the
 * numeral for four is not IIII. Instead, the number four is written as IV. Because the one is
 * before the five we subtract it making four. The same principle applies to the number nine, which
 * is written as IX. There are six instances where subtraction is used:
 *
 * <p>I can be placed before V (5) and X (10) to make 4 and 9. X can be placed before L (50) and C
 * (100) to make 40 and 90. C can be placed before D (500) and M (1000) to make 400 and 900. Given
 * an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to
 * 3999.
 *
 * <p>Example 1:
 *
 * <p>Input: 3 Output: "III" Example 2:
 *
 * <p>Input: 4 Output: "IV" Example 3:
 *
 * <p>Input: 9 Output: "IX" Example 4:
 *
 * <p>Input: 58 Output: "LVIII" Explanation: L = 50, V = 5, III = 3. Example 5:
 *
 * <p>Input: 1994 Output: "MCMXCIV" Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

  public static void main(String[] args) throws Exception {

    String result;

    result = intToRoman(1);
    if (!"I".equals(result)) {
      throw new Exception("wrong answer - expected " + "I" + " but received " + result);
    }

    result = intToRoman(3);
    if (!"III".equals(result)) {
      throw new Exception("wrong answer - expected " + "III" + " but received " + result);
    }

    result = intToRoman(8);
    if (!"VIII".equals(result)) {
      throw new Exception("wrong answer - expected " + "VIII" + " but received " + result);
    }

    result = intToRoman(9);
    if (!"IX".equals(result)) {
      throw new Exception("wrong answer - expected " + "IX" + " but received " + result);
    }

    result = intToRoman(13);
    if (!"XIII".equals(result)) {
      throw new Exception("wrong answer - expected " + "XIII" + " but received " + result);
    }

    result = intToRoman(31);
    if (!"XXXI".equals(result)) {
      throw new Exception("wrong answer - expected " + "XXXI" + " but received " + result);
    }

    result = intToRoman(43);
    if (!"XLIII".equals(result)) {
      throw new Exception("wrong answer - expected " + "LVIII" + " but received " + result);
    }

    result = intToRoman(58);
    if (!"LVIII".equals(result)) {
      throw new Exception("wrong answer - expected " + "LVIII" + " but received " + result);
    }

    result = intToRoman(83);
    if (!"LXXXIII".equals(result)) {
      throw new Exception("wrong answer - expected " + "LXXXIII" + " but received " + result);
    }

    result = intToRoman(94);
    if (!"XCIV".equals(result)) {
      throw new Exception("wrong answer - expected " + "XCIV" + " but received " + result);
    }

    result = intToRoman(1001);
    if (!"MI".equals(result)) {
      throw new Exception("wrong answer - expected " + "MI" + " but received " + result);
    }

    result = intToRoman(1794);
    if (!"MDCCXCIV".equals(result)) {
      throw new Exception("wrong answer - expected " + "MDCCXCIV" + " but received " + result);
    }

    result = intToRoman(1994);
    if (!"MCMXCIV".equals(result)) {
      throw new Exception("wrong answer - expected " + "MCMXCIV" + " but received " + result);
    }

    result = intToRoman(2020);
    if (!"MMXX".equals(result)) {
      throw new Exception("wrong answer - expected " + "MMXX" + " but received " + result);
    }

    result = intToRoman(3999);
    if (!"MMMCMXCIX".equals(result)) {
      throw new Exception("wrong answer - expected " + "MMMCMXCIX" + " but received " + result);
    }
  }

  private static String intToRoman(int i) {
    String result = "";

    if (i < 1) {
      return result;
    }

    int remainder = 0;
    if (i > 1000) {
      int numberOfMs = i / 1000;
      remainder = i % 1000;

      result = String.join(result, Collections.nCopies(numberOfMs, "M")) + intToRoman(remainder);
    } else if (i > 500) {
      int numberOfLs = i / 100;

      if (numberOfLs == 9) {
        remainder = i % 100;
        result = String.join(result, "CM") + intToRoman(remainder);
      } else {
        remainder = i % 500;
        result = String.join(result, Collections.nCopies((i / 500), "D")) + intToRoman(remainder);
      }
    } else if (i > 100) {
      int numberOfCs = i / 100;
      remainder = i % 100;

      if (numberOfCs == 4) {
        result = String.join(result, "CD") + intToRoman(remainder);
      } else {
        result = String.join(result, Collections.nCopies(numberOfCs, "C")) + intToRoman(remainder);
      }
    } else if (i > 50) {
      int numberOfXs = i / 10;

      if (numberOfXs == 9) {
        remainder = i % 10;

        result = String.join(result, "XC") + intToRoman(remainder);
      } else {
        remainder = i % 50;
        result = String.join(result, Collections.nCopies((i / 50), "L")) + intToRoman(remainder);
      }
    } else if (i > 10) {
      int numberOfXs = i / 10;
      remainder = i % 10;

      if (numberOfXs == 4) {
        result = String.join(result, "XL") + intToRoman(remainder);
      } else {
        result = String.join(result, Collections.nCopies(numberOfXs, "X")) + intToRoman(remainder);
      }
    } else if (i > 5) {
      int numberOfIs = i / 1;

      if (numberOfIs == 9) {
        result = "IX";
      } else {
        remainder = i % 5;

        result = String.join(result, Collections.nCopies((i / 5), "V")) + intToRoman(remainder);
      }
    } else if (i >= 1) {
      if (i == 4) {
        result = "IV";
      } else {
        int numberOfIs = i;

        result = String.join(result, Collections.nCopies(numberOfIs, "I"));
      }
    }

    return result;
  }
}

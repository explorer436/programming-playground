package com.my.company.numbers.numeralsystems;

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
 * (100) to make 40 and 90. C can be placed before D (500) and M (1000) to make 400 and 900. Given a
 * roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to
 * 3999.
 *
 * <p>Example 1:
 *
 * <p>Input: "III" Output: 3 Example 2:
 *
 * <p>Input: "IV" Output: 4 Example 3:
 *
 * <p>Input: "IX" Output: 9 Example 4:
 *
 * <p>Input: "LVIII" Output: 58 Explanation: L = 50, V= 5, III = 3. Example 5:
 *
 * <p>Input: "MCMXCIV" Output: 1994 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToDecimal {

    public static int romanToDecimal(String str) {
        int result = 0;

        if (str.contains("IV")) {
            result = result + 4;
            str = str.replace("IV", "");
        }
        if (str.contains("IX")) {
            result = result + 9;
            str = str.replace("IX", "");
        }
        if (str.contains("XL")) {
            result = result + 40;
            str = str.replace("XL", "");
        }
        if (str.contains("XC")) {
            result = result + 90;
            str = str.replace("XC", "");
        }
        if (str.contains("CD")) {
            result = result + 400;
            str = str.replace("CD", "");
        }
        if (str.contains("CM")) {
            result = result + 900;
            str = str.replace("CM", "");
        }

        if (str.length() >= 1) {
            if (str.length() == 1) {
                result = result + getIntegerValueForRomanCharacter(str);
            } else {
                String lastElementOnTheRight = str.substring(str.length() - 1);

                result =
                        result
                                + getIntegerValueForRomanCharacter(lastElementOnTheRight)
                                + romanToDecimal(str.substring(0, str.length() - 1));
            }
        }

        return result;
    }

    private static int getIntegerValueForRomanCharacter(String s) {
        switch (s) {
            case "M":
                return 1000;
            case "D":
                return 500;
            case "C":
                return 100;
            case "L":
                return 50;
            case "X":
                return 10;
            case "V":
                return 5;
            case "I":
                return 1;
            default:
                return 0;
        }
    }
}

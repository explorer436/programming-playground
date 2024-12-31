package com.my.company.numbers.numeralsystems;

public class RomanToDecimal {

    public static int romanToDecimal(String str) {
        int result = 0;

        // handle special cases first
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

        // after handling all special cases
        if (str.length() == 1) {
            result = result + getIntegerValueForRomanCharacter(str);
        }
        if (str.length() > 1) {
            String lastElementOnTheRight = str.substring(str.length() - 1);

            result =
                    result
                            + getIntegerValueForRomanCharacter(lastElementOnTheRight)
                            + romanToDecimal(str.substring(0, str.length() - 1));

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

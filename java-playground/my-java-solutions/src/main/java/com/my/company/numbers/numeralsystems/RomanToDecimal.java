package com.my.company.numbers.numeralsystems;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {

    private static final Map<Character, Integer> romanMap = new HashMap<>();
    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public int romanToDecimal(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        s = s.toUpperCase();
        int result = 0;
        int previousValue = 0; // Stores the value of the numeral to the right

        // Iterate from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if (!romanMap.containsKey(currentChar)) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + currentChar);
            }
            int currentValue = romanMap.get(currentChar);

            if (currentValue < previousValue) {
                // If current value is less than the one on its right, subtract it (e.g., 'I' in "IV")
                result -= currentValue;
            } else {
                // Otherwise, add it (e.g., 'V' in "IV", 'X' in "XI")
                result += currentValue;
            }
            previousValue = currentValue; // Update previousValue for the next iteration
        }
        return result;
    }

    public int romanToDecimal2(String str) {
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
                            + romanToDecimal2(str.substring(0, str.length() - 1));

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

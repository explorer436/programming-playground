package com.my.company.numbers.numeralsystems;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DecimalToRoman {

    // Using LinkedHashMap to maintain insertion order (from largest to smallest value)
    // This is crucial for the greedy algorithm.
    private static final LinkedHashMap<Integer, String> romanNumeralMap = new LinkedHashMap<>();

    static {
        romanNumeralMap.put(1000, "M");
        romanNumeralMap.put(900, "CM");
        romanNumeralMap.put(500, "D");
        romanNumeralMap.put(400, "CD");
        romanNumeralMap.put(100, "C");
        romanNumeralMap.put(90, "XC");
        romanNumeralMap.put(50, "L");
        romanNumeralMap.put(40, "XL");
        romanNumeralMap.put(10, "X");
        romanNumeralMap.put(9, "IX");
        romanNumeralMap.put(5, "V");
        romanNumeralMap.put(4, "IV");
        romanNumeralMap.put(1, "I");
    }

    /*
    This is an improvement from intToRoman2.
    The conditions of all the if-else statements are now moved into the LinkedHashMap.
    And then, we run a for loop on the LinkedHashMap.
     */
    public String intToRoman(int i) {
        String result = "";

        if (i < 1) {
            return result;
        }

        StringBuilder roman = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanNumeralMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();

            // While the number is still large enough to subtract the current value
            while (i >= value) {
                roman.append(symbol); // Append the Roman symbol
                i -= value;         // Subtract the value from the number
            }
        }
        return roman.toString();
    }

    public static String intToRoman2(int i) {
        String result = "";

        if (i < 1) {
            return result;
        }

        int remainder;

        if (i >= 1000) {
            int numberOfMs = i / 1000;
            remainder = i % 1000;

            result = String.join(result, Collections.nCopies(numberOfMs, "M")) + intToRoman2(remainder);
        } else if (i >= 500) {
            int numberOfLs = i / 100;

            if (numberOfLs == 9) {
                remainder = i % 100;
                result = String.join(result, "CM") + intToRoman2(remainder);
            } else {
                remainder = i % 500;
                result = String.join(result, Collections.nCopies((i / 500), "D")) + intToRoman2(remainder);
            }
        } else if (i >= 100) {
            int numberOfCs = i / 100;
            remainder = i % 100;

            if (numberOfCs == 4) {
                result = String.join(result, "CD") + intToRoman2(remainder);
            } else {
                result = String.join(result, Collections.nCopies(numberOfCs, "C")) + intToRoman2(remainder);
            }
        } else if (i >= 50) {
            int numberOfXs = i / 10;

            if (numberOfXs == 9) {
                remainder = i % 10;
                result = String.join(result, "XC") + intToRoman2(remainder);
            } else {
                remainder = i % 50;
                result = String.join(result, Collections.nCopies((i / 50), "L")) + intToRoman2(remainder);
            }
        } else if (i >= 10) {
            int numberOfXs = i / 10;
            remainder = i % 10;

            if (numberOfXs == 4) {
                result = String.join(result, "XL") + intToRoman2(remainder);
            } else {
                result = String.join(result, Collections.nCopies(numberOfXs, "X")) + intToRoman2(remainder);
            }
        } else if (i >= 5) {
            int numberOfIs = i / 1;

            if (numberOfIs == 9) {
                result = "IX";
            } else {
                remainder = i % 5;
                result = String.join(result, Collections.nCopies((i / 5), "V")) + intToRoman2(remainder);
            }
        } else if (i >= 1) {
            if (i == 4) {
                result = "IV";
            } else {
                result = String.join(result, Collections.nCopies(i, "I"));
            }
        }

        return result;
    }
}

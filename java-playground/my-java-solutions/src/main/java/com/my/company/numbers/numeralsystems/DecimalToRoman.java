package com.my.company.numbers.numeralsystems;

import java.util.Collections;

public class DecimalToRoman {

    public static String intToRoman(int i) {
        String result = "";

        if (i < 1) {
            return result;
        }

        int remainder = 0;

        if (i >= 1000) {
            int numberOfMs = i / 1000;
            remainder = i % 1000;

            result = String.join(result, Collections.nCopies(numberOfMs, "M")) + intToRoman(remainder);
        } else if (i >= 500) {
            int numberOfLs = i / 100;

            if (numberOfLs == 9) {
                remainder = i % 100;
                result = String.join(result, "CM") + intToRoman(remainder);
            } else {
                remainder = i % 500;
                result = String.join(result, Collections.nCopies((i / 500), "D")) + intToRoman(remainder);
            }
        } else if (i >= 100) {
            int numberOfCs = i / 100;
            remainder = i % 100;

            if (numberOfCs == 4) {
                result = String.join(result, "CD") + intToRoman(remainder);
            } else {
                result = String.join(result, Collections.nCopies(numberOfCs, "C")) + intToRoman(remainder);
            }
        } else if (i >= 50) {
            int numberOfXs = i / 10;

            if (numberOfXs == 9) {
                remainder = i % 10;
                result = String.join(result, "XC") + intToRoman(remainder);
            } else {
                remainder = i % 50;
                result = String.join(result, Collections.nCopies((i / 50), "L")) + intToRoman(remainder);
            }
        } else if (i >= 10) {
            int numberOfXs = i / 10;
            remainder = i % 10;

            if (numberOfXs == 4) {
                result = String.join(result, "XL") + intToRoman(remainder);
            } else {
                result = String.join(result, Collections.nCopies(numberOfXs, "X")) + intToRoman(remainder);
            }
        } else if (i >= 5) {
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

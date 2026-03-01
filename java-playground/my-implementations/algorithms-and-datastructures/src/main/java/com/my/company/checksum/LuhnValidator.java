package com.my.company.checksum;

public class LuhnValidator {

    /**
     * This code handles the number as a String to accommodate long identifiers (like credit card numbers) that might exceed the capacity of a standard int.
     *
     * Key Logic Explained
     *
     * 1. The Reverse Loop: We start at number.length() - 1 because the Luhn check always calculates from the rightmost digit (the check digit).
     * 1. The alternate Flag: This boolean keeps track of which digits to double. Since we start at the check digit (which is not doubled), we toggle the flag at the end of every iteration.
     * 1. The n -= 9 Trick: In the algorithm, if doubling a digit results in something like 14, you add the digits ($1 + 4 = 5$). Mathematically, for any number between 10 and 18, subtracting 9 gives you the exact same result as adding the two digits.
     *
     * Common Pitfalls to Watch For
     *
     * 1. Non-Numeric Characters: If your input string contains spaces or dashes (like 4532-1234...), the Integer.parseInt will throw an error. You should strip those out using number.replaceAll("\\D", "") before processing.
     * 1. Leading Zeros: Since we treat the number as a String, leading zeros are preserved and won't break the logic.
     */
    public boolean isValid(String number) {
        int sum = 0;
        boolean alternate = false;

        // Loop from right to left
        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));

            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9; // Equivalent to adding digits (e.g., 16 -> 1+6=7)
                }
            }

            sum += n;
            alternate = !alternate; // Toggle for every second digit
        }

        return (sum % 10 == 0);
    }
}
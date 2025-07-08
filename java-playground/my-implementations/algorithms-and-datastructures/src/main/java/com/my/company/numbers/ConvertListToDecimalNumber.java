package com.my.company.numbers;

public class ConvertListToDecimalNumber {

    public static int convertArrayToDecimalMath(int[] digits) {
        if (digits == null || digits.length == 0) {
            // Or throw new IllegalArgumentException("Array cannot be null or empty");
            return 0; // Default for empty or null array
        }

        int number = 0;
        for (int digit : digits) {
            // Basic validation: ensure digits are single digits (0-9)
            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException("Array elements must be single non-negative digits (0-9). Found: " + digit);
            }
            number = number * 10 + digit;

            // Optional: Check for potential overflow if the number can get very large
            // This check is a bit simplified. For true large number handling, use BigInteger.
            if (number < 0 && digits.length > String.valueOf(Integer.MAX_VALUE).length() -1 ) { // Heuristic for overflow
                // Or if ( (Integer.MAX_VALUE - digit) / 10 < previous_number_value_before_multiplication )
                System.err.println("Warning: Potential integer overflow for result: " + number + ". Consider using long or BigInteger.");
                // throw new ArithmeticException("Integer overflow"); // Or handle as needed
            }
        }
        return number;
    }

    // Version using long to handle larger numbers
    public static long convertArrayToDecimalMathLong(int[] digits) {
        if (digits == null || digits.length == 0) {
            return 0L;
        }

        long number = 0L;
        for (int digit : digits) {
            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException("Array elements must be single non-negative digits (0-9). Found: " + digit);
            }
            number = number * 10L + digit;
            // Similar overflow check for long if needed, though less likely for typical inputs
            if (number < 0 && digits.length > String.valueOf(Long.MAX_VALUE).length() -1 ) {
                System.err.println("Warning: Potential long overflow for result: " + number + ". Consider using BigInteger.");
            }
        }
        return number;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4};
        System.out.println("Array: [1, 3, 4] -> Decimal (math): " + convertArrayToDecimalMath(arr1)); // Output: 134

        int[] arr2 = {9, 0, 2, 1, 0};
        System.out.println("Array: [9, 0, 2, 1, 0] -> Decimal (math): " + convertArrayToDecimalMath(arr2)); // Output: 90210

        int[] arr3 = {0, 0, 5};
        System.out.println("Array: [0, 0, 5] -> Decimal (math): " + convertArrayToDecimalMath(arr3)); // Output: 5

        int[] arr4 = {};
        System.out.println("Array: [] -> Decimal (math): " + convertArrayToDecimalMath(arr4)); // Output: 0

        int[] arrLarge = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7}; // This is Integer.MAX_VALUE
        System.out.println("Array for Integer.MAX_VALUE -> Decimal (math long): " + convertArrayToDecimalMathLong(arrLarge));

        int[] arrTooLargeForInt = {2, 1, 4, 7, 4, 8, 3, 6, 4, 8}; // Integer.MAX_VALUE + 1
        // System.out.println("Array too large for int -> Decimal (math int): " + convertArrayToDecimalMath(arrTooLargeForInt)); // Will overflow
        System.out.println("Array too large for int -> Decimal (math long): " + convertArrayToDecimalMathLong(arrTooLargeForInt));

        try {
            int[] arrInvalid = {1, 10, 2};
            System.out.println(convertArrayToDecimalMath(arrInvalid));
        } catch (IllegalArgumentException e) {
            System.err.println("Error for [1, 10, 2]: " + e.getMessage());
        }
    }
}

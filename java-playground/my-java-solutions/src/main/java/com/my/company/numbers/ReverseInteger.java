package com.my.company.numbers;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * <p>Example 1:
 *
 * <p>Input: 123 Output: 321
 *
 * <p>Example 2:
 *
 * <p>Input: -123 Output: -321
 *
 * <p>Example 3:
 *
 * <p>Input: 120 Output: 21
 *
 * <p>Note: Assume we are dealing with an environment which could only store integers within the
 * 32-bit signed integer range: [(-2 power 31), (2 power 31 - 1)].
 *
 * <p>For the purpose of this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 */
public class ReverseInteger {

    public int reverseUsingStringByteArray(int x) {

        int reverse = 0;

        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
        }

        String initialString = String.valueOf(Math.abs(x));

        String reversed = reverseStringUsingByteArray(initialString);

        try {
            reverse = Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
        }

        if (isNegative) {
            reverse = reverse * -1;
        }
        return reverse;
    }

    /**
     * Take a look at StringReversal.java
     */
    public static String reverseStringUsingByteArray(String input) {
        String reversedString = null;

        if (input != null) {
            byte[] strAsByteArray = input.getBytes();

            byte[] result = new byte[strAsByteArray.length];

            // Store result in reverse order into result byte[]
            for (int i = 0; i < strAsByteArray.length; i++) {
                result[i] = strAsByteArray[strAsByteArray.length - i - 1];
            }

            reversedString = new String(result);
        }

        return reversedString;
    }

    /*
     * Solve it without converting the integer to string.
     */
    public int reverseWithoutConvertingTheIntegerIntoString(int x) {

        int reverse = 0;

        while (x != 0) {
            int unitsPlace = x % 10;
            x = x / 10;

            if ((reverse > Integer.MAX_VALUE / 10)
                    || (reverse == Integer.MAX_VALUE / 10 && unitsPlace > 7)) {
                return 0;
            }
            if ((reverse < Integer.MIN_VALUE / 10)
                    || (reverse == Integer.MAX_VALUE / 10 && unitsPlace < -8)) {
                return 0;
            }

            reverse = (reverse * 10) + unitsPlace;
        }

        return reverse;
    }

    public static void main(String[] args) throws Exception {

        int result;

        result = new ReverseInteger().reverseUsingStringByteArray(123);
        if (result != 321) {
            throw new Exception("wrong answer - expected" + 321 + " but received " + result);
        }

        result = new ReverseInteger().reverseUsingStringByteArray(-123);
        if (result != -321) {
            throw new Exception("wrong answer - expected" + -321 + " but received " + result);
        }

        result = new ReverseInteger().reverseUsingStringByteArray(120);
        if (result != 21) {
            throw new Exception("wrong answer - expected" + -321 + " but received " + result);
        }

        // input is 2147483647
        result = new ReverseInteger().reverseUsingStringByteArray(Integer.MAX_VALUE);
        if (result != 0) {
            throw new Exception("wrong answer - expected" + 0 + " but received " + result);
        }

        result = new ReverseInteger().reverseUsingStringByteArray(Integer.MIN_VALUE);
        if (result != 0) {
            throw new Exception("wrong answer - expected" + 0 + " but received " + result);
        }

        result = new ReverseInteger().reverseUsingStringByteArray(964632435);
        if (result != 534236469) {
            throw new Exception("wrong answer - expected" + 534236469 + " but received " + result);
        }

        result = new ReverseInteger().reverseUsingStringByteArray(Integer.MAX_VALUE + 1);
        if (result != 0) {
            throw new Exception("wrong answer - expected" + 0 + " but received " + result);
        }

        result = new ReverseInteger().reverseUsingStringByteArray(2147483646);
        if (result != 0) {
            throw new Exception("wrong answer - expected" + 0 + " but received " + result);
        }

        System.out.println("----------------");

        result = new ReverseInteger().reverseWithoutConvertingTheIntegerIntoString(123);
        if (result != 321) {
            throw new Exception("wrong answer - expected" + 321 + " but received " + result);
        }

        result = new ReverseInteger().reverseWithoutConvertingTheIntegerIntoString(-123);
        if (result != -321) {
            throw new Exception("wrong answer - expected" + -321 + " but received " + result);
        }

        result = new ReverseInteger().reverseWithoutConvertingTheIntegerIntoString(120);
        if (result != 21) {
            throw new Exception("wrong answer - expected" + -321 + " but received " + result);
        }

        // input is 2147483647
        result = new ReverseInteger().reverseWithoutConvertingTheIntegerIntoString(Integer.MAX_VALUE);
        if (result != 0) {
            throw new Exception("wrong answer - expected" + 0 + " but received " + result);
        }

        result = new ReverseInteger().reverseWithoutConvertingTheIntegerIntoString(Integer.MIN_VALUE);
        if (result != 0) {
            throw new Exception("wrong answer - expected" + 0 + " but received " + result);
        }

        result = new ReverseInteger().reverseWithoutConvertingTheIntegerIntoString(964632435);
        if (result != 534236469) {
            throw new Exception("wrong answer - expected" + 534236469 + " but received " + result);
        }

        result =
                new ReverseInteger().reverseWithoutConvertingTheIntegerIntoString(Integer.MAX_VALUE + 1);
        if (result != 0) {
            throw new Exception("wrong answer - expected" + 0 + " but received " + result);
        }

        result = new ReverseInteger().reverseWithoutConvertingTheIntegerIntoString(2147483646);
        if (result != 0) {
            throw new Exception("wrong answer - expected" + 0 + " but received " + result);
        }

        System.out.println("done");
    }
}

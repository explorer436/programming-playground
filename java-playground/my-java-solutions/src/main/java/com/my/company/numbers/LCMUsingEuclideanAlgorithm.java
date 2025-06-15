package com.my.company.numbers;

import java.math.BigInteger;

public class LCMUsingEuclideanAlgorithm {

    public static void main(String[] args) {

        System.out.println(
                "LCM of 12 and 18 using EuclideanAlgorithm is : " + lcmUsingEuclideanAlgorithm(12, 18));

        System.out.println();

        System.out.println(
                "LCM of BigIntegers 12 and 18 is : "
                        + lcmOfBigIntegers(new BigInteger("12"), new BigInteger("18")));
    }

    public static int lcmUsingEuclideanAlgorithm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        } else {
            int gcd = new GCDOfTwoNumbersUsingEuclideanAlgorithm().gcd(number1, number2);
            return Math.abs(number1 * number2) / gcd;
        }
    }

    public static BigInteger lcmOfBigIntegers(BigInteger number1, BigInteger number2) {

        // See GCDOfTwoNumbersUsingEuclideanAlgorithm.gcdOfBigIntegers()
        BigInteger gcd = number1.gcd(number2);

        BigInteger absProduct = number1.multiply(number2).abs();
        return absProduct.divide(gcd);
    }
}

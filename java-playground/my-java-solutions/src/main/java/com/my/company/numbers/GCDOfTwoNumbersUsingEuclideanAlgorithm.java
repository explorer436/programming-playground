package com.my.company.numbers;

import java.math.BigInteger;

public class GCDOfTwoNumbersUsingEuclideanAlgorithm {

    public int gcd(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return number1 + number2;
        } else {
            int biggerValue = Math.max(number1, number2);
            int smallerValue = Math.min(number1, number2);
            return gcd(smallerValue, biggerValue % smallerValue);
        }
    }

    /*public int gcd2(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return number1 + number2;
        } else {
            int absNumber1 = Math.abs(number1);
            int absNumber2 = Math.abs(number2);
            int biggerValue = Math.max(absNumber1, absNumber2);
            int smallerValue = Math.min(absNumber1, absNumber2);
            return gcd(biggerValue % smallerValue, smallerValue);
        }
    }*/

    public BigInteger gcdOfBigIntegers(BigInteger number1, BigInteger number2) {
        return number1.gcd(number2);
    }

}

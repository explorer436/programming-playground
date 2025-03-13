package com.my.company.numbers;

import java.math.BigInteger;

public class GCDOfTwoNumbersUsingEuclideanAlgorithm {

  public static void main(String[] args) {
    System.out.println("GCD of 12 and 18 is : " + gcd(12, 18));

    System.out.println("GCD of 12 and 0 is : " + gcd(12, 0));

    System.out.println("GCD of 8 and 12 is : " + gcd(8, 12));

    System.out.println(
        "GCD of 8 and 12 is : " + gcdOfBigIntegers(new BigInteger("8"), new BigInteger("12")));
  }

  public static int gcd(int number1, int number2) {
    if (number1 == 0 || number2 == 0) {
      return number1 + number2;
    } else {
      int absNumber1 = Math.abs(number1);
      int absNumber2 = Math.abs(number2);
      int biggerValue = Math.max(absNumber1, absNumber2);
      int smallerValue = Math.min(absNumber1, absNumber2);
      return gcd(biggerValue % smallerValue, smallerValue);
    }
  }

  public static BigInteger gcdOfBigIntegers(BigInteger number1, BigInteger number2) {
    return number1.gcd(number2);
  }

}

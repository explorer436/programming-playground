package com.my.company.numbers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.my.company.utility.PrintUtils;

/**
 * In arithmetic and number theory, the least common multiple, lowest common multiple, or smallest
 * common multiple of two integers a and b, usually denoted by LCM(a, b), is the smallest positive
 * integer that is divisible by both a and b. Since division of integers by zero is undefined, this
 * definition has meaning only if a and b are both different from zero.
 *
 * <p>Note : Negative integers and zero aren't candidates for LCM.
 */
public class LCMOfTwoNumbers {

    public static void main(String[] args) {
        System.out.println("LCM of 12 and 18 is : " + lcm_MultiplicationIsAddition(12, 18));

        System.out.println();

        Map<Integer, Integer> primeFactorsMapFor12 = getPrimeFactors(12);
        System.out.println("prime factors for 12");
        PrintUtils.printMap(primeFactorsMapFor12);

        System.out.println();

        Map<Integer, Integer> primeFactorsMapFor18 = getPrimeFactors(18);
        System.out.println("prime factors for 18");
        PrintUtils.printMap(primeFactorsMapFor18);

        System.out.println();

        System.out.println(
                "LCM of 12 and 18 using PrimeFactorizationApproach is : "
                        + lcmUsingPrimeFactorizationApproach(12, 18));

        System.out.println();

        System.out.println(
                "LCM of 12 and 18 using EuclideanAlgorithm is : " + lcmUsingEuclideanAlgorithm(12, 18));

        System.out.println();

        System.out.println(
                "LCM of BigIntegers 12 and 18 is : "
                        + lcmOfBigIntegers(new BigInteger("12"), new BigInteger("18")));
    }

    /**
     * REMEMBER LCM using the Euclidean Algorithm :
     *
     * <p>There's an interesting relation between the LCM and GCD (Greatest Common Divisor) of two
     * numbers that says that the absolute value of the product of two numbers is equal to the product
     * of their GCD and LCM.
     *
     * <p>As stated, gcd(a, b) * lcm(a, b) = |a * b|. Consequently, lcm(a, b) = |a * b|/gcd(a, b).
     *
     * <p>Using this formula, our original problem of finding lcm(a,b) has now been reduced to just
     * finding gcd(a,b).
     *
     * <p>Granted, there are multiple strategies to finding GCD of two numbers. However, the Euclidean
     * algorithm is known to be one of the most efficient of all.
     *
     * <p>For this reason, let's briefly understand the crux of this algorithm, which can be summed up
     * in two relations:
     *
     * <p>gcd (a, b) = gcd(|a%b|, |a| ); where |a| >= |b| gcd(p, 0) = gcd(0, p) = |p|
     *
     * <p>Let's see how we can find lcm(12, 18) using the above relations: We have gcd(12, 18) =
     * gcd(18%12, 12) = gcd(6,12) = gcd(12%6, 6) = gcd(0, 6) = 6 Therefore, lcm(12, 18) = |12 x 18| /
     * gcd(12, 18) = (12 x 18) / 6 = 36
     */
    public static int lcmUsingEuclideanAlgorithm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        } else {
            int gcd = GCDOfTwoNumbersUsingEuclideanAlgorithm.gcd(number1, number2);
            return Math.abs(number1 * number2) / gcd;
        }
    }

    /**
     * Using the Prime Factorization Approach to calculate LCM :
     *
     * <p>Algorithm : The prime factorization approach calculates the LCM from the prime decomposition
     * of the two numbers. We can use the prime factors and exponents from the prime factorization to
     * calculate LCM of the two numbers:
     *
     * <p>When, |a| = (2 power p1) * (3 power p2) * (5 power p3) * … and |b| = (2 power q1) * (3 power
     * q2) * (5 power q3) * … then, lcm(a, b) = (2 power max(p1, q1)) * (3 power max(p2, q2)) * (5
     * power max(p3, q3)) …
     */
    public static int lcmUsingPrimeFactorizationApproach(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }

        Map<Integer, Integer> primeFactorsForNum1 = getPrimeFactors(number1);
        Map<Integer, Integer> primeFactorsForNum2 = getPrimeFactors(number2);

        Set<Integer> primeFactorsUnionSet = new HashSet<>(primeFactorsForNum1.keySet());
        primeFactorsUnionSet.addAll(primeFactorsForNum2.keySet());

        int lcm = 1;

        for (Integer primeFactor : primeFactorsUnionSet) {
            lcm *=
                    Math.pow(
                            primeFactor,
                            Math.max(
                                    primeFactorsForNum1.getOrDefault(primeFactor, 0),
                                    primeFactorsForNum2.getOrDefault(primeFactor, 0)));
        }

        return lcm;
    }

    /**
     * Fundamental theorem of arithmetic : In number theory, the fundamental theorem of arithmetic,
     * also called the unique factorization theorem or the unique-prime-factorization theorem, states
     * that every integer greater than 1 either is a prime number itself or can be represented as the
     * product of prime numbers and that, moreover, this representation is unique, up to (except for)
     * the order of the factors. For example, 1200 = (2 power 4) × (3 power 1) × (5 power 2) = 2 × 2 ×
     * 2 × 2 × 3 × 5 × 5 = 5 × 2 × 5 × 2 × 3 × 2 × 2 = ... The theorem says two things for this
     * example: first, that 1200 can be represented as a product of primes, and second, that no matter
     * how this is done, there will always be exactly four 2s, one 3, two 5s, and no other primes in
     * the product.
     *
     * <p>The fundamental theorem of arithmetic states that it's possible to uniquely express every
     * integer greater than one as a product of powers of prime numbers. So, for any integer N > 1, we
     * have N = (2 power k1) * (3 power k2) * (5 power k3) *… Using the result of this theorem, we'll
     * now understand the prime factorization approach to find the LCM of two numbers.
     */
    public static Map<Integer, Integer> getPrimeFactors(int number) {
        int absNumber = Math.abs(number);

        Map<Integer, Integer> primeFactorsMap = new HashMap<Integer, Integer>();

        for (int factor = 2; factor <= absNumber; factor++) {
            while (absNumber % factor == 0) {
                Integer power = primeFactorsMap.get(factor);
                if (power == null) {
                    power = 0;
                }
                primeFactorsMap.put(factor, power + 1);
                absNumber /= factor;
            }
        }

        return primeFactorsMap;
    }

    /**
     * We can find the LCM of two numbers by using the simple fact that multiplication is repeated
     * addition.
     *
     * <p>This uses an iterative approach.
     *
     * <p>The LCM of any number with zero is zero itself. So, we can make an early exit from the
     * procedure whenever either of the given integers is 0.
     *
     * <p>The lower bound of the LCM of two non-zero integers is the larger of the absolute values of
     * the two numbers.
     *
     * <p>The LCM can never be a negative integer. So, we'll only use absolute values of the integers
     * for finding the possible multiples until we find a common multiple.
     *
     * <p>Algorithm : 1. If a = 0 or b = 0, then return with lcm(a, b) = 0, else go to step 2. 2.
     * Calculate absolute values of the two numbers. 3. Initialize lcm as the higher of the two values
     * computed in step 2. 4. If lcm is divisible by the lower absolute value, then return. 5.
     * Increment lcm by the higher absolute value among the two and go to step 4.
     */
    public static int lcm_MultiplicationIsAddition(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }

        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    public static BigInteger lcmOfBigIntegers(BigInteger number1, BigInteger number2) {

        // See GCDOfTwoNumbersUsingEuclideanAlgorithm.gcdOfBigIntegers()
        BigInteger gcd = number1.gcd(number2);

        BigInteger absProduct = number1.multiply(number2).abs();
        return absProduct.divide(gcd);
    }
}

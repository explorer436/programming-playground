package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GCDOfTwoNumbersUsingEuclideanAlgorithmTests {
    GCDOfTwoNumbersUsingEuclideanAlgorithm gcdOfTwoNumbersUsingEuclideanAlgorithm = new GCDOfTwoNumbersUsingEuclideanAlgorithm();

    @Test
    public void test_gcdOfTwoNumbersUsingEuclideanAlgorithm_01() {
        int actual = gcdOfTwoNumbersUsingEuclideanAlgorithm.gcd(8, 12);
        assertEquals(4, actual);
    }

    @Test
    public void test_gcdOfTwoNumbersUsingEuclideanAlgorithm_02() {
        int actual = gcdOfTwoNumbersUsingEuclideanAlgorithm.gcd(12, 18);
        assertEquals(6, actual);
    }

    @Test
    public void test_gcdOfTwoNumbersUsingEuclideanAlgorithm_03() {
        int actual = gcdOfTwoNumbersUsingEuclideanAlgorithm.gcd(12, 0);
        assertEquals(12, actual);
    }
}

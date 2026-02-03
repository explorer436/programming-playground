package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LCMTests {

    LCMUsingDivision lcmUsingDivision = new LCMUsingDivision();

    LCMUsingPrimeFactorization lcmUsingPrimeFactorization = new LCMUsingPrimeFactorization();

    LCMUsingEuclideanAlgorithm lcmUsingEuclideanAlgorithm = new LCMUsingEuclideanAlgorithm();

    LCMOfNumbersInACollection lcmOfNumbersInACollection = new LCMOfNumbersInACollection();

    @Test
    void lcm_MultiplicationIsAddition() {
        assertEquals(36, lcmUsingDivision.lcm_MultiplicationIsAddition(12, 18));
    }

    @Test
    void lcmUsingPrimeFactorizationApproach() {
        assertEquals(36, lcmUsingPrimeFactorization.lcmUsingPrimeFactorizationApproach(12, 18));
    }

    @Test
    void lcmUsingEuclideanAlgorithm() {
        assertAll(
                () -> assertEquals(36, lcmUsingEuclideanAlgorithm.lcmUsingEuclideanAlgorithm(12, 18)),
                () -> assertEquals(new BigInteger("36"), lcmUsingEuclideanAlgorithm.lcmOfBigIntegers(new BigInteger("12"), new BigInteger("18")))
        );

    }

    @Test
    void getLcmOfNumbersInACollection() {
        assertAll(
                () -> assertEquals(4, lcmOfNumbersInACollection.getLcmOfNumbersInAList(Arrays.asList(2, 4))),
                () -> assertEquals(4, lcmOfNumbersInACollection.getLcmOfNumbersInAnArray(new int[]{2, 4})),
                () -> assertEquals(6, lcmOfNumbersInACollection.getLcmOfNumbersInAnArray(new int[]{2, 6}))
        );
    }
}
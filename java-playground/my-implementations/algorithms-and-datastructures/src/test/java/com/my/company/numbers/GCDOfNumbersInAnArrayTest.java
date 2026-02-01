package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GCDOfNumbersInAnArrayTest {

    GCDOfNumbersInAnArray  gcd = new GCDOfNumbersInAnArray();

    @Test
    void test_getGcd() {
        assertAll(
                () -> assertEquals(16, gcd.getGcdOfNumbersInAList(Arrays.asList(new Integer[] {16, 32, 96}))),
                () -> assertEquals(16, gcd.getGcdOfNumbersInAnArray(new int[] {16, 32, 96}))
        );
    }
}
package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfEvenFibonacciNumbersBelowNTest {

    SumOfEvenFibonacciNumbersBelowN sum = new SumOfEvenFibonacciNumbersBelowN();

    @Test
    void sumOfEvenFibonacciNumbersBelowN() {
        assertEquals(4613732, sum.sumOfEvenFibonacciNumbersBelowN(4 * 1000000));
    }
}
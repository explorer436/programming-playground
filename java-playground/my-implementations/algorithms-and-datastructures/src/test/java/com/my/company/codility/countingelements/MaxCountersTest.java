package com.my.company.codility.countingelements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxCountersTest {

    MaxCounters maxCounters = new MaxCounters();

    @Test
    void test_bruteForceSolution_slow() {
        assertAll(
                () -> assertArrayEquals(new int[]{3,2,2,4,2}, maxCounters.bruteForceSolution_slow(5, new int[]{3, 4, 4, 6, 1, 4, 4}))
        );
    }

    @Test
    void test_solution() {
        assertAll(
                () -> assertArrayEquals(new int[]{3,2,2,4,2}, maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}))
        );
    }
}
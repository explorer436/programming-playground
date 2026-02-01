package com.my.company.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BetweenTwoSetsTest {

    BetweenTwoSets betweenTwoSets = new BetweenTwoSets();

    @Test
    void getTotalX() {
        assertAll(
                () -> assertEquals(3, betweenTwoSets.getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96))),
                () -> assertEquals(2, betweenTwoSets.getTotalX(Arrays.asList(2, 6), Arrays.asList(24, 36))),
                () -> assertEquals(0, betweenTwoSets.getTotalX(Arrays.asList(0, 2, 6), Arrays.asList(24, 36))),
                () -> assertEquals(0, betweenTwoSets.getTotalX(Arrays.asList(2, 6), Arrays.asList(0, 24, 36))),
                () -> assertEquals(9, betweenTwoSets.getTotalX(Arrays.asList(1), Arrays.asList(100)))
        );
    }
}
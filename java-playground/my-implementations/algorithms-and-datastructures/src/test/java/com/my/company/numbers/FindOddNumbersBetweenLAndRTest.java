package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindOddNumbersBetweenLAndRTest {

    FindOddNumbersBetweenLAndR findOddNumbersBetweenLAndR = new FindOddNumbersBetweenLAndR();

    @Test
    void test_findOddNumbersBetweenLAndR() {
        assertAll(
                () -> assertTrue(Arrays.equals(new int[]{3, 5}, findOddNumbersBetweenLAndR.findOddNumbersBetweenLAndR(2, 5))),
                () -> assertTrue(Arrays.equals(new int[]{-5, -3, -1, 1, 3, 5}, findOddNumbersBetweenLAndR.findOddNumbersBetweenLAndR(-5, 5)))
        );
    }

}
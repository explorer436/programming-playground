package com.my.company.codility.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OddNumberOfAnArrayTests {

    OddNumberOfAnArray oddNumberOfAnArray = new OddNumberOfAnArray();

    @Test
    public void test_01() throws Exception {
        assertAll(
                () -> assertEquals(7, oddNumberOfAnArray.findOddNumberInTheArray(new int[] {9, 3, 9, 3, 9, 7, 9})),
                () -> assertEquals(1, oddNumberOfAnArray.findOddNumberInTheArray(new int[] {1})),
                () -> assertEquals(0, oddNumberOfAnArray.findOddNumberInTheArray(new int[] {})),
                () -> assertTrue(oddNumberOfAnArray.isThereAnOddNumberInTheArray(new int[] {9, 3, 9, 3, 9, 7, 9})),
                () -> assertTrue(oddNumberOfAnArray.isThereAnOddNumberInTheArray(new int[] {1})),
                () -> assertFalse(oddNumberOfAnArray.isThereAnOddNumberInTheArray(new int[] {1, 2, 1, 2})),
                () -> assertFalse(oddNumberOfAnArray.isThereAnOddNumberInTheArray(new int[] {}))
        );

    }
}

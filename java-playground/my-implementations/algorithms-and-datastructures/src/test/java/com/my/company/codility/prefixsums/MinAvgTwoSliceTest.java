package com.my.company.codility.prefixsums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinAvgTwoSliceTest {

    MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

    MinAvgTwoSlice2  minAvgTwoSlice2 = new MinAvgTwoSlice2();

    MinAvgTwoSlice3   minAvgTwoSlice3 = new MinAvgTwoSlice3();

    @Test
    void test_minAvgTwoSlice_getStartingPositionOfMinimumSlice() {
        assertEquals(1, minAvgTwoSlice.getStartingPositionOfMinimumSlice(new int[] {4, 2, 2, 5, 1, 5, 8}));
    }

    /*@Test
    void test_minAvgTwoSlice2_getStartingPositionOfMinimumSlice() {
        assertEquals(1, minAvgTwoSlice2.getStartingPositionOfMinimumSlice(new int[] {4, 2, 2, 5, 1, 5, 8}));
    }

    @Test
    void test_minAvgTwoSlice3_getStartingPositionOfMinimumSlice() {
        assertEquals(1, minAvgTwoSlice3.getStartingPositionOfMinimumSlice(new int[] {4, 2, 2, 5, 1, 5, 8}));
    }*/

}
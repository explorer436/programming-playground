package com.my.company.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagonalDifferenceTests {

    public final DiagonalDifference classUnderTest = new DiagonalDifference();

    @Test
    public void test_absoluteDiffBetweenSumsOfDiagonals() {
        assertEquals(15, classUnderTest.absoluteDiffBetweenSumsOfDiagonals(new int[][] {
                {11, 2, 4},
                {4, 5, 6},
                {10, 8, -12}}));

        assertEquals(2, classUnderTest.absoluteDiffBetweenSumsOfDiagonals(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {9, 8, 9}
        }));
    }

    @Test
    public void test_absoluteDiffBetweenSumsOfDiagonals_alternate() {
        assertEquals(15, classUnderTest.absoluteDiffBetweenSumsOfDiagonals_alternate(new int[][] {
                {11, 2, 4},
                {4, 5, 6},
                {10, 8, -12}}));

        assertEquals(2, classUnderTest.absoluteDiffBetweenSumsOfDiagonals_alternate(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {9, 8, 9}
        }));
    }

    @Test
    public void test_sumOfElementsOfLeftToRightDiagonal() {
        assertEquals(4, classUnderTest.sumOfElementsOfLeftToRightDiagonal(new int[][] {
                {11, 2, 4},
                {4, 5, 6},
                {10, 8, -12}}));
        assertEquals(15, classUnderTest.sumOfElementsOfLeftToRightDiagonal(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {9, 8, 9}
        }));
    }

    @Test
    public void test_sumOfElementsOfRightToLeftDiagonal() {
        assertEquals(19, classUnderTest.sumOfElementsOfRightToLeftDiagonal(new int[][] {
                {11, 2, 4},
                {4, 5, 6},
                {10, 8, -12}}));
        assertEquals(17, classUnderTest.sumOfElementsOfRightToLeftDiagonal(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {9, 8, 9}
        }));
    }

}

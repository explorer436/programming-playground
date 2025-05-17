package com.my.company.sorting.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuicksortTests {

    Quicksort sortingClassUnderTest = new Quicksort();

    Integer[] intArray1 = new Integer[]{5, 7, 0, 3, 4, 2, 6, 1};
    Integer[] intArray2 = new Integer[]{-1, 0, -2};
    Integer[] intArray3 = new Integer[]{1, 3, 7, 2, 5};
    Integer[] intArray4 = new Integer[]{};
    Integer[] intArray5 = new Integer[]{5};

    String[] strArray = new String[]{"ghi", "abc", "def"};

    @Test
    public void test_01() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray1, 0, intArray1.length - 1);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_02() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray2, 0 , intArray2.length - 1);
        Integer[] expected = new Integer[]{-2, -1, 0};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_03() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray3, 0 , intArray3.length - 1);
        Integer[] expected = new Integer[]{1, 2, 3, 5, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_04() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray4, 0 , intArray4.length - 1);
        Integer[] expected = new Integer[]{};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_05() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray5, 0 , intArray5.length - 1);
        Integer[] expected = new Integer[]{5};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_06() {
        Comparable[] actual = sortingClassUnderTest.sort(strArray, 0, strArray.length - 1);
        String[] expected = new String[]{"abc", "def", "ghi"};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

}

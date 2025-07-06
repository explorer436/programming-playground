package com.my.company.sorting.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortTests {

    InsertionSort sortingClassUnderTest = new InsertionSort();

    Integer[] intArray1 = new Integer[]{5, 7, 0, 3, 4, 2, 6, 1};
    Integer[] intArray2 = new Integer[]{-1, 0, -2};
    Integer[] intArray3 = new Integer[]{1, 3, 7, 2, 5};
    Integer[] intArray4 = new Integer[]{};
    Integer[] intArray5 = new Integer[]{5};

    String[] strArray = new String[]{"ghi", "abc", "def"};

    @Test
    public void test_01() {
        Comparable[] actual = sortingClassUnderTest.sort_iterative(intArray1);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_02() {
        Comparable[] actual = sortingClassUnderTest.sort_iterative(intArray2);
        Integer[] expected = new Integer[]{-2, -1, 0};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_03() {
        Comparable[] actual = sortingClassUnderTest.sort_iterative(intArray3);
        Integer[] expected = new Integer[]{1, 2, 3, 5, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_04() {
        Comparable[] actual = sortingClassUnderTest.sort_iterative(intArray4);
        Integer[] expected = new Integer[]{};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_05() {
        Comparable[] actual = sortingClassUnderTest.sort_iterative(intArray5);
        Integer[] expected = new Integer[]{5};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_06() {
        Comparable[] actual = sortingClassUnderTest.sort_iterative(strArray);
        String[] expected = new String[]{"abc", "def", "ghi"};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

        @Test
    public void test_01_2() {
        Comparable[] actual = sortingClassUnderTest.sort_recursive(intArray1, intArray1.length);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_02_2() {
        Comparable[] actual = sortingClassUnderTest.sort_recursive(intArray2, intArray2.length);
        Integer[] expected = new Integer[]{-2, -1, 0};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_03_2() {
        Comparable[] actual = sortingClassUnderTest.sort_recursive(intArray3, intArray3.length);
        Integer[] expected = new Integer[]{1, 2, 3, 5, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_04_2() {
        Comparable[] actual = sortingClassUnderTest.sort_recursive(intArray4, intArray4.length);
        Integer[] expected = new Integer[]{};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_05_2() {
        Comparable[] actual = sortingClassUnderTest.sort_recursive(intArray5, intArray5.length);
        Integer[] expected = new Integer[]{5};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_06_2() {
        Comparable[] actual = sortingClassUnderTest.sort_recursive(strArray, strArray.length);
        String[] expected = new String[]{"abc", "def", "ghi"};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}

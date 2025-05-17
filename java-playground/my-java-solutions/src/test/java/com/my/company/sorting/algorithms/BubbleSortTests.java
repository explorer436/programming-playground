package com.my.company.sorting.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTests {

    BubbleSort sortingClassUnderTest = new BubbleSort();

    Integer[] intArray1 = new Integer[]{5, 7, 0, 3, 4, 2, 6, 1};
    Integer[] intArray2 = new Integer[]{-1, 0, -2};
    Integer[] intArray3 = new Integer[]{1, 3, 7, 2, 5};
    Integer[] intArray4 = new Integer[]{};
    Integer[] intArray5 = new Integer[]{5};

    String[] strArray = new String[]{"ghi", "abc", "def"};

    @Test
    public void test_01() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray1);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_02() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray2);
        Integer[] expected = new Integer[]{-2, -1, 0};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_03() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray3);
        Integer[] expected = new Integer[]{1, 2, 3, 5, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_04() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray4);
        Integer[] expected = new Integer[]{};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_05() {
        Comparable[] actual = sortingClassUnderTest.sort(intArray5);
        Integer[] expected = new Integer[]{5};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_06() {
        Comparable[] actual = sortingClassUnderTest.sort(strArray);
        String[] expected = new String[]{"abc", "def", "ghi"};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}

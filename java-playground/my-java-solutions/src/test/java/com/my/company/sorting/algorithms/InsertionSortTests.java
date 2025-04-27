package com.my.company.sorting.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortTests {

    InsertionSort insertionSort = new InsertionSort();

    Integer[] intArray = new Integer[]{5, 7, 0, 3, 4, 2, 6, 1};

    String[] strArray = new String[]{"ghi", "abc", "def"};

    @Test
    public void test_insertionSort_iterative_01() {
        Comparable[] actual = insertionSort.insertionSort_iterative(intArray);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_insertionSort_iterative_02() {
        Comparable[] actual = insertionSort.insertionSort_iterative(strArray);
        String[] expected = new String[]{"abc", "def", "ghi"};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_insertionSort_recursive_01() {
        Comparable[] actual = insertionSort.insertionSort_recursive(intArray, intArray.length);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test_insertionSort_recursive_02() {
        Comparable[] actual = insertionSort.insertionSort_recursive(strArray, strArray.length);
        String[] expected = new String[]{"abc", "def", "ghi"};

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}

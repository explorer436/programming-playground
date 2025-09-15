package com.my.company.sorting.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortTests {

    MergeSort sortingClassUnderTest = new MergeSort();

    Integer[] intArray1 = new Integer[]{5, 7, 0, 3, 4, 2, 6, 1};
    Integer[] intArray2 = new Integer[]{-1, 0, -2};
    Integer[] intArray3 = new Integer[]{1, 3, 7, 2, 5};
    Integer[] intArray4 = new Integer[]{};
    Integer[] intArray5 = new Integer[]{5};

    String[] strArray = new String[]{"ghi", "abc", "def"};

    @Test
    public void test_01() {
        sortingClassUnderTest.sort(intArray1);
        Integer[] expected = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};

        assertEquals(expected.length, intArray1.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], intArray1[i]);
        }
    }

    @Test
    public void test_02() {
        sortingClassUnderTest.sort(intArray2);
        Integer[] expected = new Integer[]{-2, -1, 0};

        assertEquals(expected.length, intArray2.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], intArray2[i]);
        }
    }

    @Test
    public void test_03() {
        sortingClassUnderTest.sort(intArray3);
        Integer[] expected = new Integer[]{1, 2, 3, 5, 7};

        assertEquals(expected.length, intArray3.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], intArray3[i]);
        }
    }

    @Test
    public void test_04() {
        sortingClassUnderTest.sort(intArray4);
        Integer[] expected = new Integer[]{};

        assertEquals(expected.length, intArray4.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], intArray4[i]);
        }
    }

    @Test
    public void test_05() {
        sortingClassUnderTest.sort(intArray5);
        Integer[] expected = new Integer[]{5};

        assertEquals(expected.length, intArray5.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], intArray5[i]);
        }
    }

    @Test
    public void test_06() {
        sortingClassUnderTest.sort(strArray);
        String[] expected = new String[]{"abc", "def", "ghi"};

        assertEquals(expected.length, strArray.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], strArray[i]);
        }
    }

}

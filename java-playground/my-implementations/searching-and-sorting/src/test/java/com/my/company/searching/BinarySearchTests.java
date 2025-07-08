package com.my.company.searching;

import com.my.company.search.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTests {

    BinarySearch binarySearch = new BinarySearch();

    int[] anArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void test_01() {
        int actual = binarySearch.binarySearchUsingRecursion(4, anArray, 0, anArray.length);
        assertEquals(3, actual);
    }

    @Test
    public void test_02() {
        int actual = binarySearch.binarySearchUsingRecursion(10, anArray, 0, anArray.length);
        assertEquals(9, actual);
    }

    @Test
    public void test_03() {
        int actual = binarySearch.binarySearchUsingRecursion(15, anArray, 0, anArray.length);
        assertEquals(-1, actual);
    }

    @Test
    public void test_04() {
        int actual = binarySearch.binarySearchUsingIteration(4, anArray);
        assertEquals(3, actual);
    }

    @Test
    public void test_05() {
        int actual = binarySearch.binarySearchUsingIteration(10, anArray);
        assertEquals(9, actual);
    }

    @Test
    public void test_06() {
        int actual = binarySearch.binarySearchUsingIteration(15, anArray);
        assertEquals(-1, actual);
    }

}

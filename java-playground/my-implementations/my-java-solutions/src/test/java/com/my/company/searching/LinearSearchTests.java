package com.my.company.searching;

import com.my.company.search.LinearSearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchTests {

    LinearSearch linearSearch = new LinearSearch();

    int[] anArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void test_01() {
        int actual = linearSearch.linearSearch(anArray, 4);
        assertEquals(3, actual);
    }

    @Test
    public void test_02() {
        int actual = linearSearch.linearSearch(anArray, 10);
        assertEquals(9, actual);
    }

    @Test
    public void test_03() {
        int actual = linearSearch.linearSearch(anArray, 15);
        assertEquals(-1, actual);
    }

}

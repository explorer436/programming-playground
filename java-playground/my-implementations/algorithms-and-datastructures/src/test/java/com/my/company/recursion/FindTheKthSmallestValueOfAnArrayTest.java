package com.my.company.recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindTheKthSmallestValueOfAnArrayTest {

    Integer[] anArray = new Integer[] {4, 7, 3, 6, 8, 1, 9, 2};

    @Test
    public void test_01() {
        assertEquals(-1, FindTheKthSmallestValueOfAnArray.kthSmall(0, Arrays.asList(anArray)));
    }

    @Test
    public void test_02() {
        assertEquals(1, FindTheKthSmallestValueOfAnArray.kthSmall(1, Arrays.asList(anArray)));
    }

    @Test
    public void test_03() {
        assertEquals(3, FindTheKthSmallestValueOfAnArray.kthSmall(3, Arrays.asList(anArray)));
    }

    @Test
    public void test_04() {
        assertEquals(7, FindTheKthSmallestValueOfAnArray.kthSmall(6, Arrays.asList(anArray)));
    }

    @Test
    public void test_05() {
        assertEquals(8, FindTheKthSmallestValueOfAnArray.kthSmall(7, Arrays.asList(anArray)));
    }

    @Test
    public void test_06() {
        assertEquals(9, FindTheKthSmallestValueOfAnArray.kthSmall(8, Arrays.asList(anArray)));
    }

    @Test
    public void test_07() {
        assertEquals(-1, FindTheKthSmallestValueOfAnArray.kthSmall(9, Arrays.asList(anArray)));
    }

}
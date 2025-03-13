package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextSmallerNumberTests {

    NextSmallerNumber nextSmallerNumber = new NextSmallerNumber();

    @Test
    public void test_01() {
        int actual = nextSmallerNumber.findNextSmallerNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 3);
        assertEquals(-1, actual);
    }

    @Test
    public void test_02() {
        int actual = nextSmallerNumber.findNextSmallerNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 21);
        assertEquals(19, actual);
    }

    @Test
    public void test_03() {
        int actual = nextSmallerNumber.findNextSmallerNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 12);
        assertEquals(12, actual);
    }

    @Test
    public void test_04() {
        int actual = nextSmallerNumber.findNextSmallerNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 13);
        assertEquals(12, actual);
    }

    @Test
    public void test_05() {
        int actual = nextSmallerNumber.findNextSmallerNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 14);
        assertEquals(12, actual);
    }

    @Test
    public void test_06() {
        int actual = nextSmallerNumber.findNextSmallerNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 2);
        assertEquals(-1, actual);
    }

    @Test
    public void test_07() {
        int actual = nextSmallerNumber.findNextSmallerNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 22);
        assertEquals(21, actual);
    }

    @Test
    public void test_08() {
        int actual = nextSmallerNumber.findNextSmallerNumber(new int[]{}, 22);
        assertEquals(-1, actual);
    }

    @Test
    public void test_09() {
        int actual = nextSmallerNumber.findNextSmallerNumber(null, 22);
        assertEquals(-1, actual);
    }
}

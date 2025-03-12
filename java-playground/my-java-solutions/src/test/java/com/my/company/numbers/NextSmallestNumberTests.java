package com.my.company.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextSmallestNumberTests {

    NextSmallestNumber nextSmallestNumber = new NextSmallestNumber();

    @Test
    public void test_01() throws Exception {
        int actual = nextSmallestNumber.findNextSmallestNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 3);
        assertEquals(-1, actual);
    }

    @Test
    public void test_02() throws Exception {
        int actual = nextSmallestNumber.findNextSmallestNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 21);
        assertEquals(19, actual);
    }

    @Test
    public void test_03() throws Exception {
        int actual = nextSmallestNumber.findNextSmallestNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 12);
        assertEquals(12, actual);
    }

    @Test
    public void test_04() throws Exception {
        int actual = nextSmallestNumber.findNextSmallestNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 13);
        assertEquals(12, actual);
    }

    @Test
    public void test_05() throws Exception {
        int actual = nextSmallestNumber.findNextSmallestNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 14);
        assertEquals(12, actual);
    }

    @Test
    public void test_06() throws Exception {
        int actual = nextSmallestNumber.findNextSmallestNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 2);
        assertEquals(-1, actual);
    }

    @Test
    public void test_07() throws Exception {
        int actual = nextSmallestNumber.findNextSmallestNumber(new int[]{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}, 22);
        assertEquals(21, actual);
    }

    @Test
    public void test_08() throws Exception {
        int actual = nextSmallestNumber.findNextSmallestNumber(new int[]{}, 22);
        assertEquals(-1, actual);
    }

    @Test
    public void test_09() throws Exception {
        int actual = nextSmallestNumber.findNextSmallestNumber(null, 22);
        assertEquals(-1, actual);
    }
}

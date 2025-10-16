package com.my.company.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseAnArrayTests {

    ReverseAnArray reverseAnArray = new ReverseAnArray();

    @Test
    public void test_twoSum_01() throws Exception {
        int[] initial = new int[]{2, 7, 11, 15};
        reverseAnArray.reverse(initial);
        assertArrayEquals(new int[]{15, 11, 7, 2}, initial);
    }

}

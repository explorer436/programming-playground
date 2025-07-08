package com.my.company.datastructures.arrays;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumTests {

    TwoSum twoSum = new TwoSum();

    @Test
    public void test_twoSum_01() throws Exception {
        ImmutablePair actual = twoSum.twoSum(new int[] {2, 7, 11, 15}, 9);
        assertEquals(new ImmutablePair<>(0,1), actual);
    }

    @Test
    public void test_twoSum_02() throws Exception {
        ImmutablePair actual = twoSum.twoSum(new int[] {3, 2, 4}, 6);
        assertEquals(new ImmutablePair<>(1,2), actual);
    }

    @Test
    public void test_twoSum_03() throws Exception {
        ImmutablePair actual = twoSum.twoSum(new int[] {3, 2, 4}, 9);
        assertEquals(null, actual);
    }

    @Test
    public void test_twoSum_04() throws Exception {
        ImmutablePair actual = twoSum.twoSum(new int[] {0, 4, 3, 0}, 0);
        assertEquals(new ImmutablePair<>(0,3), actual);
    }

    @Test
    public void test_twoSum_05() throws Exception {
        ImmutablePair actual = twoSum.twoSum(new int[] {-1,-2,-3,-4,-5}, -8);
        assertEquals(new ImmutablePair<>(2,4), actual);
    }
}

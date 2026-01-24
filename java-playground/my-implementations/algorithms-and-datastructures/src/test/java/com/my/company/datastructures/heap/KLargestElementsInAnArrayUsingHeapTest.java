package com.my.company.datastructures.heap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KLargestElementsInAnArrayUsingHeapTest {

    KLargestElementsInAnArrayUsingHeap klargestElementsInAnArrayUsingHeap = new KLargestElementsInAnArrayUsingHeap();

    @Test
    public void testKLargest() {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        ArrayList<Integer> res = klargestElementsInAnArrayUsingHeap.kLargest(arr, k);
        assertEquals(res, Arrays.asList(50, 30, 23));
    }

}
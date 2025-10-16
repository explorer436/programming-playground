package com.my.company.datastructures.heap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxHeapTests {

    @Test
    public void test() {

        List<Integer> list = new ArrayList<>();
        list.add(80);
        list.add(75);
        list.add(60);
        list.add(68);
        list.add(55);
        list.add(40);
        list.add(52);
        list.add(67);

        MaxHeap maxHeap = new MaxHeap(list);
        maxHeap.printHeap();

        maxHeap.insert(100);
        maxHeap.printHeap();

        maxHeap.insert(70);
        maxHeap.printHeap();

        // heap.delete(1);
        // heap.printHeap();

        // heap.delete(5);
        // heap.printHeap();

        // heap.delete(0);
        // heap.printHeap();

        // System.out.println(heap.peek());

        maxHeap.removeRoot();

        maxHeap.printHeap();

        maxHeap.removeRoot();

        maxHeap.printHeap();
    }
}

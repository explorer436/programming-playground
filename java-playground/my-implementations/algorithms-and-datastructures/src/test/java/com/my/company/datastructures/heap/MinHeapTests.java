package com.my.company.datastructures.heap;

import org.junit.jupiter.api.Test;

public class MinHeapTests {

    @Test
    public void test() {
        MinHeap h = new MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.printHeap();

        h.deleteNodeAtIndex(1);
        h.printHeap();

        h.insert(15);
        h.insert(5);
        h.insert(4);
        h.insert(45);
        h.printHeap();

        h.removeRoot();
        h.printHeap();

        h.peek();

        h.changeValueOnAKey(2, 1);
        h.printHeap();

        h.peek();
    }
}

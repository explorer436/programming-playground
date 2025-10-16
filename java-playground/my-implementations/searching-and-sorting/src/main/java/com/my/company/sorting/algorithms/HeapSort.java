package com.my.company.sorting.algorithms;

import com.my.company.datastructures.heap.MinHeap;

/**
 * O(nlong). In place sorting.
 */
public class HeapSort {

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(80);
        minHeap.insert(75);
        minHeap.insert(60);
        minHeap.insert(68);
        minHeap.insert(55);
        minHeap.insert(40);
        minHeap.insert(52);
        minHeap.insert(67);

        minHeap.printHeap();

        System.out.println("--------");

        minHeap.sort();

        minHeap.printHeap();
    }
}

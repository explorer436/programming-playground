package com.my.company.sorting;

import com.my.company.datastructures.heap.Heap;

/**
 * O(nlong). In place sorting. Once a heap is sorted, it is not a heap anymore - since it is sorted.
 */
public class HeapSort {

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        System.out.println("--------");

        heap.sort();

        heap.printHeap();
    }
}

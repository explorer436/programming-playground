package com.my.company.datastructures.heap;


import java.util.Collections;

public class MinHeap {

    private int[] heapArray;

    private int capacity;

    private int current_heap_size;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }

    // TODO Create a constructor that takes an array as input parameter

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    public boolean insert(int value) {
        if (current_heap_size == capacity) {
            return false;
        }

        // First insert the new value at the end
        int i = current_heap_size;
        heapArray[i] = value;
        current_heap_size++;

        // Fix the min heap property if it is violated
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        return true;
    }

    // Returns the minimum value (value at root) from min heap
    public int peek() {
        System.out.println(heapArray[0]);
        return heapArray[0];
    }


    // Method to remove minimum element (or root) from min heap
    public int removeRoot() {
        if (current_heap_size <= 0) {
            return Integer.MAX_VALUE;
        }

        if (current_heap_size == 1) {
            current_heap_size--;
            return heapArray[0];
        }

        // Store the minimum value,
        // and remove it from heap
        int root = heapArray[0];

        heapArray[0] = heapArray[current_heap_size - 1];
        current_heap_size--;
        sinkDownFromIndex(0, current_heap_size);

        return root;
    }

    // This function deletes node at the given index.
    // It first reduces the value of the node to minus infinite.
    // Then calls removeRoot()
    public void deleteNodeAtIndex(int index) {

        heapArray[index] = Integer.MIN_VALUE;

        while (index != 0 && heapArray[index] < heapArray[parent(index)]) {
            swap(heapArray, index, parent(index));
            index = parent(index);
        }

        removeRoot();
    }

    // A recursive method to heapify a subtree
    // with the root at given index
    // This method assumes that the subtrees
    // are already heapified
    private void sinkDownFromIndex(int index, int n) {
        int l = left(index);
        int r = right(index);

        int smallestIndex = index;
        if (l < n && heapArray[l] < heapArray[smallestIndex]) {
            smallestIndex = l;
        }
        if (r < n && heapArray[r] < heapArray[smallestIndex]) {
            smallestIndex = r;
        }

        if (smallestIndex != index) {
            swap(heapArray, index, smallestIndex);
            sinkDownFromIndex(smallestIndex, n);
        }
    }

    // Changes value at an index
    public void changeValueAtIndex(int index, int new_val) {
        if (heapArray[index] == new_val) {
            return;
        }

        int original = heapArray[index];
        heapArray[index] = new_val;

        if (original < new_val) {
            sinkDownFromIndex(index, current_heap_size);
        } else {
            while (index != 0 && heapArray[index] < heapArray[parent(index)]) {
                swap(heapArray, index, parent(index));
                index = parent(index);
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < current_heap_size; i++) {
            System.out.print(heapArray[i]);
            System.out.print(", ");
        }
        System.out.println(" ");
    }

    public void sort() {

        int lastHeapIndex = current_heap_size - 1;

        for (int i = 0; i < current_heap_size; i++) {
            // swap first root with the last element of the heap.
            // and do the same thing by reducing the size of the heap by 1.
            int tmp = heapArray[0];
            heapArray[0] = heapArray[lastHeapIndex - i];
            heapArray[lastHeapIndex - i] = tmp;

            sinkDownFromIndex(0, lastHeapIndex - i);
        }
        // When this is done, the array is sorted but it will be a max-heap (the largest element is at the root)

        // If we want to avoid reversing the array, we have to start with a MaxHeap - not a MinHeap
        // Classic array reversal
        int mid = current_heap_size / 2;
        int length = current_heap_size - 1;
        for ( int i = 0; i < mid; i++ ) {
            int temp = heapArray[i];
            heapArray[i] = heapArray[length - i];
            heapArray[length - i] = temp;
        }
    }
}

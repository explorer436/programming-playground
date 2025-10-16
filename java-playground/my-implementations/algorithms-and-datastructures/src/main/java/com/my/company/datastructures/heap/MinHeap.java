package com.my.company.datastructures.heap;


class MinHeap {

    private int[] heapArray;

    private int capacity;

    private int current_heap_size;

    public MinHeap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }

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

    public boolean insert(int key) {
        if (current_heap_size == capacity) {
            return false;
        }

        // First insert the new key at the end
        int i = current_heap_size;
        heapArray[i] = key;
        current_heap_size++;

        // Fix the min heap property if it is violated
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        return true;
    }

    // Returns the minimum key (key at root) from min heap
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
        heapArray[current_heap_size - 1] = 0;
        current_heap_size--;
        sinkDown(0);

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
    private void sinkDown(int index) {
        int l = left(index);
        int r = right(index);

        int smallest = index;
        if (l < current_heap_size && heapArray[l] < heapArray[smallest]) {
            smallest = l;
        }
        if (r < current_heap_size && heapArray[r] < heapArray[smallest]) {
            smallest = r;
        }

        if (smallest != index) {
            swap(heapArray, index, smallest);
            sinkDown(smallest);
        }
    }

    // Changes value on a key
    public void changeValueOnAKey(int index, int new_val) {
        if (heapArray[index] == new_val) {
            return;
        }

        int original = heapArray[index];
        heapArray[index] = new_val;

        if (original < new_val) {
            sinkDown(index);
        } else {
            while (index != 0 && heapArray[index] < heapArray[parent(index)]) {
                swap(heapArray, index, parent(index));
                index = parent(index);
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < heapArray.length; i++) {
            System.out.print(heapArray[i]);
            System.out.print(", ");
        }
        System.out.println(" ");
    }
}

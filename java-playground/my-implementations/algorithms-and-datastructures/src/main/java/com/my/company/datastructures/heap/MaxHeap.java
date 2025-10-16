package com.my.company.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    private List<Integer> heapArrayList;

    public MaxHeap(List<Integer> heapArrayList) {
        this.heapArrayList = heapArrayList;
    }

    public List<Integer> getHeapArrayList() {
        // return a copy of the heap
        return new ArrayList<>(heapArrayList);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public int getParentNode(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heapArrayList.get(index1);
        heapArrayList.set(index1, heapArrayList.get(index2));
        heapArrayList.set(index2, temp);
    }

    public void insert(int value) {
        heapArrayList.add(value);
        int current = heapArrayList.size() - 1;

        while (current > 0 && heapArrayList.get(current) > heapArrayList.get(getParentNode(current))) {
            swap(current, getParentNode(current));
            current = getParentNode(current);
        }
    }

    // remove the element at index = 0
    public Integer removeRoot() {
        if (heapArrayList.size() == 0) {
            return null;
        }

        if (heapArrayList.size() == 1) {
            return heapArrayList.remove(0);
        }

        int root = heapArrayList.get(0);
        heapArrayList.set(0, heapArrayList.remove(heapArrayList.size() - 1));
        sinkDown(0);

        return root;
    }

    public boolean isEmpty() {
        return heapArrayList.size() == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heapArrayList.get(0);
    }

    /*
        Starting with index, compare each node's value to the value at it's left and right. Move it appropriately.
        You may see this method called with the name "Heapify".
     */
    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heapArrayList.size() && heapArrayList.get(leftIndex) > heapArrayList.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heapArrayList.size() && heapArrayList.get(rightIndex) > heapArrayList.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else  {
                return;
            }
        }
    }

    /*public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parentNode = getParentNode(index);
        int deletedValue = heap[index];

        // grab the right most value in the heap and put it in the deleted place.
        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parentNode]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        size--;

        return deletedValue;
    }

    public void sort() {
        int lastHeapIndex = size - 1;

        for (int i = 0; i < lastHeapIndex; i++) {
            // swap first root with the last element of the heap.
            // and do the same thing by reducing the size of the heap by 1.
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = tmp;

            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    public int getChild(int index, boolean left) {
        return (2 * index) + (left ? 1 : 2);
    }*/

    public void printHeap() {
        for (int i = 0; i < heapArrayList.size(); i++) {
            System.out.print(heapArrayList.get(i));
            System.out.print(", ");
        }
        System.out.println(" ");
    }
}

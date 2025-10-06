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

    public Integer remove() {
        if (heapArrayList.size() == 0) {
            return null;
        }

        if (heapArrayList.size() == 1) {
            return heapArrayList.remove(0);
        }

        int maxValue = heapArrayList.get(0);
        heapArrayList.set(0, heapArrayList.remove(heapArrayList.size() - 1));
        sinkDown(0);

        return maxValue;
    }

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

    /*public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;

        fixHeapAbove(size);

        size++;
    }

    private void fixHeapAbove(int currentIndex) {
        int newValue = heap[currentIndex];

        while (currentIndex > 0 && newValue > heap[getParentNode(currentIndex)]) {
            heap[currentIndex] = heap[getParentNode(currentIndex)];
            currentIndex = getParentNode(currentIndex);
        }

        heap[currentIndex] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }

                index = childToSwap;
            } else {
                break;
            }
        }
    }

    public int delete(int index) {
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

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
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

    public boolean isEmpty() {
        return size == 0;
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

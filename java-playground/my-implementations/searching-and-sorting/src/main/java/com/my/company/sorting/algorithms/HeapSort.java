package com.my.company.sorting.algorithms;

import com.my.company.datastructures.heap.MaxHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * O(nlong). In place sorting. Once a heap is sorted, it is not a heap anymore - since it is sorted.
 */
/*public class HeapSort {

  public static void main(String[] args) {


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

    System.out.println("--------");

    for (int i=list.size()-1;i>0;i--) {
        swap(list, list.get(0), list.get(list.size()-1));
        // heapify(list, n, i);
    }

    maxHeap.printHeap();
  }

    private static void swap(List<Integer> l, int index1, int index2) {
        int temp = l.get(index1);
        l.set(index1, l.get(index2));
        l.set(index2, temp);
    }
}*/

    public class HeapSort {

        /**
         * Main function to perform Heap Sort on an array.
         *
         * @param arr The array to be sorted.
         */
        public static void sort(int[] arr) {
            int N = arr.length;

            // Stage 1: Build a Max-Heap (rearrange the array)
            // Starts from the last non-leaf node (N/2 - 1) up to the root (0)
            for (int i = N / 2 - 1; i >= 0; i--) {
                heapify(arr, N, i);
            }

            // Stage 2: One by one extract an element from the heap
            // The largest element is always at the root (index 0)
            for (int i = N - 1; i > 0; i--) {
                // Move current root to the end of the array (swap A[0] with A[i])
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // Call max heapify on the reduced heap
                // The heap size decreases by 1 (i) in each iteration
                heapify(arr, i, 0);
            }
        }

        /**
         * To heapify a subtree rooted at index i (Max-Heap property).
         *
         * @param arr The array (representing the heap).
         * @param N   The size of the heap (the unsorted part of the array).
         * @param i   The root index of the subtree to be heapified.
         */
        private static void heapify(int[] arr, int N, int i) {
            int largest = i; // Initialize largest as root
            int left = 2 * i + 1; // Left child index
            int right = 2 * i + 2; // Right child index

            // If left child is larger than root and is within the heap bounds (N)
            if (left < N && arr[left] > arr[largest]) {
                largest = left;
            }

            // If right child is larger than current largest and is within the heap bounds (N)
            if (right < N && arr[right] > arr[largest]) {
                largest = right;
            }

            // If largest is not root
            if (largest != i) {
                // Swap arr[i] and arr[largest]
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Recursively heapify the affected sub-tree
                heapify(arr, N, largest);
            }
        }

        /**
         * Utility function to print the array.
         *
         * @param arr The array to print.
         */
        static void printArray(int[] arr) {
            for (int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // Driver code to test the Heap Sort implementation
        public static void main(String[] args) {
            int[] arr = {12, 11, 13, 5, 6, 7};
            System.out.println("Original array:");
            printArray(arr);

            // Perform Heap Sort
            sort(arr);

            System.out.println("\nSorted array:");
            printArray(arr);
        }
    }

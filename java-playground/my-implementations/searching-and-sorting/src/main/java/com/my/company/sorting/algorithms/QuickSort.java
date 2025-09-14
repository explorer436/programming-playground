package com.my.company.sorting.algorithms;

import com.my.company.utility.ArrayUtils;

import java.util.Arrays;

public class QuickSort {

    /**
     * Public method to initiate the Quicksort process.
     *
     * @param arr The array to be sorted.
     * @return
     */
    public static Comparable[] sort(Comparable[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        quicksort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * The recursive Quicksort function.
     *
     * @param arr  The array (or sub-array) to sort.
     * @param low  The starting index of the sub-array.
     * @param high The ending index of the sub-array.
     */
    private static void quicksort(Comparable[] arr, int low, int high) {
        if (low < high) {
            // pi is the partitioning index, arr[pi] is now at its correct sorted position
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quicksort(arr, low, pivotIndex - 1);  // Sort left sub-array
            quicksort(arr, pivotIndex + 1, high); // Sort right sub-array
        }
    }

    /**
     * This function takes the last element as pivot, places
     * the pivot element at its correct position in the sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot.
     * (Lomuto partition scheme)
     *
     * @param arr  The array (or sub-array).
     * @param low  Starting index.
     * @param high Ending index (pivot element is at this index).
     * @return The index of the pivot element after partitioning.
     */
    private static int partition(Comparable[] arr, int low, int high) {
        Comparable pivot = arr[high]; // Choose the last element as the pivot
        int i = low - 1;    // Index of the smaller element

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or equal to the pivot
            if (arr[j].compareTo(pivot) <= 0) {
                i++; // Increment index of smaller element
                ArrayUtils.swap(arr, i, j); // Swap arr[i] and arr[j]
            }
        }
        // After the loop, all elements arr[low...i] are <= pivot.
        // Place the pivot element (arr[high]) at its correct position
        ArrayUtils.swap(arr, i + 1, high);
        return i + 1; // Return the partitioning index
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        Integer[] arr1 = {10, 7, 8, 9, 1, 5};
        System.out.println("Original array: " + Arrays.toString(arr1));
        QuickSort.sort(arr1);
        System.out.println("Sorted array: " + Arrays.toString(arr1));
        System.out.println("---");

        Integer[] arr2 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        System.out.println("Original array: " + Arrays.toString(arr2));
        QuickSort.sort(arr2);
        System.out.println("Sorted array: " + Arrays.toString(arr2));
        System.out.println("---");

        Integer[] arr3 = {5, 4, 3, 2, 1}; // Worst case for this pivot choice
        System.out.println("Original array: " + Arrays.toString(arr3));
        QuickSort.sort(arr3);
        System.out.println("Sorted array: " + Arrays.toString(arr3));
        System.out.println("---");
    }
}
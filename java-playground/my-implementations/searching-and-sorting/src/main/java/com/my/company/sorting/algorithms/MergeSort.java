package com.my.company.sorting.algorithms;

public class MergeSort {

    public Comparable[] sort(Comparable[] intArray1) {
        return mergeSort(intArray1, 0, intArray1.length);
    }

    // Main mergeSort function to divide the array
    public Comparable[] mergeSort(Comparable[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            mergeSort(arr, left, mid);        // Sort left half
            mergeSort(arr, mid + 1, right);   // Sort right half
            return merge(arr, left, mid, right);     // Merge sorted halves
        }
        return arr;
    }

    // Merge function to combine two sorted subarrays
    public Comparable[] merge(Comparable[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;    // Size of left subarray
        int n2 = right - mid;       // Size of right subarray

        // Create temporary arrays
        Comparable[] L = new Comparable[n1];
        Comparable[] R = new Comparable[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays back into arr
        int i = 0;    // Index for left subarray
        int j = 0;    // Index for right subarray
        int k = left; // Index for merged array

        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L, if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R, if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return arr;
    }
}
package com.my.company.sorting.algorithms;

import com.my.company.utility.ArrayUtils;

public class SelectionSort {

    public static Comparable[] sort(Comparable[] array) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                // Grab the i of the first element from the subarray array[i..length]
                int min = i;

                for (int j = min + 1; j < array.length; j++) {
                    // Starting with the next element from min, compare each element with the element at min.
                    // If it is smaller, exchange them.
                    if (array[min].compareTo(array[j]) > 0) {
                        min = j;
                    }
                }

                // swap A[i] and A[min]
                ArrayUtils.swap(array, i, min);
            }
        }
        return array;
    }
}

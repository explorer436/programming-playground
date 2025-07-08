package com.my.company.sorting.algorithms;

import com.my.company.utility.ArrayUtils;

public class SelectionSort {

    public static Comparable[] sort(Comparable[] array) {
        if (null != array) {
            for (int index = 0; index < array.length; index++) {
                // Grab the index of the first element from the subarray array[index..length]
                int min = index;

                for (int j = min + 1; j < array.length; j++) {
                    // Starting with the next element from min, compare each element with the element at min.
                    // If it is smaller, exchange them.
                    if (array[min].compareTo(array[j]) > 0) {
                        ArrayUtils.exch(array, index, j);
                    }
                }
            }
        }
        return array;
    }
}

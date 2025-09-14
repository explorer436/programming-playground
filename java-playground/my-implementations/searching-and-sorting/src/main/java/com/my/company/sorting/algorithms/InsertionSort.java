package com.my.company.sorting.algorithms;

import com.my.company.utility.ArrayUtils;

public class InsertionSort {

    // See the test class

    public Comparable[] sort_iterative(Comparable[] a) {
        int length = a.length;

        // We want to start the loop at index 1 - not at index 0

        for (int i = 1; i < length; i++) {

            // Find the correct place for a[i] in the sorted part.
            for (int j = i; j > 0; j--) {
                Comparable aj_1 = a[j - 1];
                boolean isElementAtJMinusOneGreaterThanElementAtJ = aj_1.compareTo(a[j]) > 0; // Using compareTo to support multiple primitive types.
                if (isElementAtJMinusOneGreaterThanElementAtJ) {
                    ArrayUtils.swap(a, j - 1, j);
                } else {
                    break;
                }
            }
        }

        return a;
    }

    public Comparable[] sort_recursive(Comparable[] a, int numberOfElementsToBeSorted) {

        if (numberOfElementsToBeSorted <= 1) {
            return a;
        }

        // we are replacing the outer for loop with a recursive call.
        sort_recursive(a, numberOfElementsToBeSorted - 1);

        for (int j = numberOfElementsToBeSorted - 1; j > 0; j--) {
            boolean isTheFirstGreaterThanTheSecond = a[j - 1].compareTo(a[j]) > 0;
            if (isTheFirstGreaterThanTheSecond) {
                ArrayUtils.swap(a, j - 1, j);
            } else {
                break;
            }
        }

        return a;
    }
}

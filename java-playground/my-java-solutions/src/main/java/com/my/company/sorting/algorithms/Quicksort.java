package com.my.company.sorting.algorithms;

public class Quicksort {

    public Comparable[] sort(Comparable[] a, int beginning, int ending) {

        // one element arrays.
        if (ending - beginning < 2) {
            return a;
        }

        int pivotIndex = partition(a, beginning, ending);

        sort(a, beginning, pivotIndex);
        sort(a, pivotIndex + 1, ending);

        return a;
    }

    public static int partition(Comparable[] a, int beginning, int ending) {

        // Use the first element of a as the pivot.
        Comparable pivot = a[beginning];

        // i will be traversing from left to right.
        // j will be traversing from right to left.
        int i = beginning;
        int j = ending;

        // When i and j cross each other, the traversal should stop.
        while (i < j) {

            // Use j to look for elements that are less than the pivot (starting from the ending of the array).
            // Empty loop body - we are not doing anything in the body of the loop.
            // It's purpose is to keep decrementing j until we find an element that is lesser than the pivot.
            // Pre-decrement j because, we don't want to consider the last element of the array.
            while (i < j && a[--j].compareTo(pivot) >= 0) {
            }

            // If we fall out of the loop above, it means that we found an element that is lesser than the pivot.
            // In that case, move the element at j to location i.
            // This is not a swap. This is just a move operation.
            // Don't worry about losing the previous data element that was stored at j.
            // We already saved it in the variable 'pivot'.
            if (i < j) {
                a[i] = a[j];
            }

            // Now, we are going to use i to look for elements that are greater than the pivot (starting from the beginning of the array).
            // Empty loop body - we are not doing anything in the body of the loop.
            // It's purpose is to keep incrementing i until we find an element that is greater than the pivot.
            // Pre-increment i because, we don't want to consider the index i - which we already used in the previous step.
            while (i < j && a[++i].compareTo(pivot) <= 0) {
            }

            // If we fall out of the loop above, it means that we found an element that is greater than the pivot.
            // In that case, move the element at i to location j.
            // This is not a swap. this is just a move operation.
            // Don't worry about losing the previous data element that was stored at index j.
            // We already saved it at the index i (before incrementing i).
            if (i < j) {
                a[j] = a[i];
            }
        }

        // When we drop out of the while loop above, it means that i crossed j.
        // At this point, j is the index where we want to insert the pivot.
        a[j] = pivot;

        // Return the index where we inserted the pivot.
        return j;
    }
}

package com.my.company.sorting.algorithms;

public class MergeSort {

    public Comparable[] sort(Comparable[] intArray1) {
        return sort_ascending(intArray1, 0, intArray1.length);
    }

    /**
     * the partitioning part is logical partitioning - meaning, we will not be creating any new
     * arrays. instead, we will just be using the arrays to keep track of the sub arrays.
     */
    public static Comparable[] sort_ascending(Comparable[] a, int beginning, int ending) {

        if (ending - beginning <= 1) {
            return a;
        }

        // this is the partitioning part of the recursion.
        // the array is divided into two parts until the size of each of the parts is 1.
        // int midIndex = (ending + beginning) / 2;
        int midIndex = beginning + (ending - beginning) / 2;
        // mid = (0 + 5) / 2 = 2

        sort_ascending(a, 0, midIndex);
        sort_ascending(a, midIndex, ending);

        merge_ascending(a, beginning, midIndex, ending);

        return a;
    }

    public static void merge_ascending(Comparable[] a, int beginning, int mid, int ending) {

        // if the last element from the left array is lower than the first element from the right array, there is no need to do anything.

        if (a[mid - 1].compareTo(a[mid]) < 0) {
            return;
        }

        int i = beginning;
        int j = mid;
        int tempIndex = 0;

        Comparable[] temp = new Comparable[ending - beginning];

        // drop out as soon as we finish traversing the left array or the right array.
        while (i < mid && j < ending) {
            temp[tempIndex++] = (a[i].compareTo(a[j]) <= 0) ? a[i++] : a[j++];
        }

        // after we drop out of the while loop, we need to handle the leftover elements that are
        // either in left array or in the right array.

        // TODO write detailed explanations for this.

        // if we have elements left over in the left array, we need to copy them over.
        // but if we have elements left over in the right array, we don't have to do anything.
        // that is because, they are already in the correct positions.
        System.arraycopy(a, i, a, beginning + tempIndex, mid - i);

        System.arraycopy(temp, 0, a, beginning, tempIndex);

    }

    public static void sort_descending(Comparable[] a, int beginning, int ending) {
        if (null != a) {
            // breaking condition for the recursion
            // in our case, we need to break out on one element arrays - one element arrays are already
            // sorted.
            if (ending - beginning < 2) {
                return;
            } else {
                // this is the partitioning part of the recursion. the array is divided into two parts until
                // the size of each of the parts is 1.
                int mid = (ending + beginning) / 2;
                // mid = (0 + 5) / 2 = 2

                // TODO this part is confusing. why is this not mid and mid -1 or mid + 1?
                sort_descending(a, 0, mid);
                sort_descending(a, mid, ending);

                merge_descending(a, beginning, mid, ending);
            }
        }
    }

    public static void merge_descending(Comparable[] a, int beginning, int mid, int ending) {
        // if the last element from the left array is lower than the first element from the right array,
        // there is no need to do anything.
        if (a[mid - 1].compareTo(a[mid]) > 0) {
            return;
        } else {
            int i = beginning;
            int j = mid;
            int tempIndex = 0;

            Comparable[] temp = new Comparable[ending - beginning];

            // drop out as soon as we finish traversing the left array or the right array.
            while (i < mid && j < ending) {
                temp[tempIndex++] = (a[i].compareTo(a[j]) >= 0) ? a[i++] : a[j++];
            }

            // after we drop out of the while loop, we need to handle the leftover elements that are
            // either in left array or in the right array.

            // TODO write detailed explanations for this.

            // if we have elements left over in the left array, we need to copy them over.
            // but if we have elements left over in the right array, we don't have to do anything.
            // that is because, they are already in the correct positions.
            System.arraycopy(a, i, a, beginning + tempIndex, mid - i);

            System.arraycopy(temp, 0, a, beginning, tempIndex);
        }
    }

}

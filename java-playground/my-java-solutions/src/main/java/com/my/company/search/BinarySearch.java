package com.my.company.search;

public class BinarySearch {

    // A prerequisite is, the array has to be ordered.
    public int binarySearchUsingRecursion(int key, int[] numbers, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        try {
            int mid = lo + (hi - lo) / 2;
            if (key < numbers[mid]) {
                return binarySearchUsingRecursion(key, numbers, lo, mid - 1);
            } else if (key > numbers[mid]) {
                return binarySearchUsingRecursion(key, numbers, mid + 1, hi);
            } else {
                return mid;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    // A prerequisite is, the array has to be ordered.
    public int binarySearchUsingIteration(int key, int[] numbers) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < numbers[mid]) {
                hi = mid - 1;
            } else if (key > numbers[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

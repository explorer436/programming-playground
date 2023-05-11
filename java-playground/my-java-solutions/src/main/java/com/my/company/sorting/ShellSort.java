package com.my.company.sorting;

import com.my.company.utility.ArrayUtils;
import com.my.company.utility.PrintUtils;

/**
 * This is basically insertion sort with different gap values. For insertion sort, the gap value is
 * always 1.
 *
 * <p>There will be several iterations using larger gap values but the last iteration will always be
 * using a gap value = 1. At that point, it is basically the same as insertion sort.
 *
 * <p>The same logic can be applied to bubble sort as well.
 */
public class ShellSort {

    public static void main(String[] args) {

        Integer[] intArray = new Integer[]{5, 7, 0, 3, 4, 2, 6, 1};
        System.out.println("--------before sorting-----------");
        PrintUtils.printArray(intArray);
        sort(intArray);
        System.out.println("---------printing the sorted list------------");
        PrintUtils.printArray(intArray);

        System.out.println();

        String[] strArray = new String[]{"ghi", "abc", "def"};
        System.out.println("--------before sorting-----------");
        PrintUtils.printArray(strArray);
        sort(strArray);
        System.out.println("---------printing the sorted list------------");
        PrintUtils.printArray(strArray);
    }

    public static void sort(Comparable[] a) {
        int length = a.length;

        // we are starting with gap value = size / 2 and decrementing it by 2 each time.

        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {
            // the code below is the exact same code for insertion sort. the difference being, i is
            // initialized to gap.
            for (int i = gap; i < length; i++) {
                for (int j = i; j > 0; j--) {
                    boolean isTheFirstGreaterThanTheSecond = a[j - 1].compareTo(a[j]) > 0;
                    if (isTheFirstGreaterThanTheSecond) {
                        ArrayUtils.exch(a, j - 1, j);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}

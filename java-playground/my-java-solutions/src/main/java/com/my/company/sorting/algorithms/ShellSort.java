package com.my.company.sorting.algorithms;

import com.my.company.utility.ArrayUtils;
import com.my.company.utility.PrintUtils;

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

    public static Comparable[] sort(Comparable[] a) {
        int length = a.length;

        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {
            // the code below is the exact same code for insertion sort. the difference being, i is initialized to gap.
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
        return a;
    }
}

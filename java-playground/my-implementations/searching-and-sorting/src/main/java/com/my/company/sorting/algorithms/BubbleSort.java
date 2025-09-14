package com.my.company.sorting.algorithms;

import com.my.company.utility.ArrayUtils;

public class BubbleSort {

    // Why do we need two for loops?
    public Comparable[] sort(Comparable[] a) {
        if (null != a && a.length > 1) {
            int n = a.length;
            for (int i = 0; i <= n - 1 ; i++) {
                for (int j = 0; j <= n - i - 2; j++) {
                    // first is lesser than the second
                    if (a[j].compareTo(a[j + 1]) > 0) {
                        ArrayUtils.swap(a, j, j + 1);
                    }
                }
            }
        }
        return a;
    }

}

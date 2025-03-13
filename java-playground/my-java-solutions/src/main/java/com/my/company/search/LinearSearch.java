package com.my.company.search;

public class LinearSearch {

    public int linearSearch(int[] anArray, int value) {
        for (int i = 0; i < anArray.length; i++) {
            if (anArray[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

package com.my.company.datastructures.arrays;

public class ReverseAnArray {
    public void reverse(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int mid = arr.length / 2;
        int length = arr.length - 1;
        for ( int i = 0; i < mid; i++ ) {
            int temp = arr[i];
            arr[i] = arr[length - i];
            arr[length - i] = temp;
        }
    }
}

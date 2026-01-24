package com.my.company.recursion;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestValueOfAnArrayUsingRecursion {

    public static int kthSmall(int k, List<Integer> anArray) {

        ArrayList<Integer> smallerThanPivot = new ArrayList<Integer>();
        ArrayList<Integer> equalToPivot = new ArrayList<Integer>();
        ArrayList<Integer> largenThanPivot = new ArrayList<Integer>();

        int size = anArray.size();

        if (k <= 0 || size <= 0) {
            return -1;
        }
        // when the size of the array is 1, we want pivot index = 0
        int pivotIndex = 0;
        if (size == 1) {
            if (k == 1) {
                return anArray.get(0);
            } else {
                return -1;
            }
        }
        pivotIndex = (size + 1) / 2;

        int pivot = anArray.get(pivotIndex);
        for (int i : anArray) {
            if (i < pivot) {
                smallerThanPivot.add(i);
            } else if (i == pivot) {
                equalToPivot.add(i);
            } else if (i > pivot) {
                largenThanPivot.add(i);
            }
        }

        if (k <= smallerThanPivot.size()) {
            return kthSmall(k, smallerThanPivot);
        } else if (k == smallerThanPivot.size() + 1) {
            // The element at the pivot index is the answer.
            return equalToPivot.get(0);
        }

        // There is a possibility that k could be greater than the size of smallerThanPivot but largenThanPivot is empty.
        // In that scenario, the value from equalToPivot would be the result.
        else if (k > smallerThanPivot.size() + 1 && (k - smallerThanPivot.size() - equalToPivot.size()) <= largenThanPivot.size()) {
            return kthSmall(k - smallerThanPivot.size() - equalToPivot.size(), largenThanPivot);
        }

        return -1;
    }
}

package com.my.company.codility.countingelements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestPositiveNumberMissingFromArray {

    /**
     * This is not a constant space solution.
     *
     * <p>This approach may take O(n) time on average, but it requires O(n) extra space.
     */
    public int getFirstMissingPositiveInteger_ImplementedUsingMap(int[] A) {

        if (null == A || 0 == A.length) {
            return 1;
        } else {
            Integer result = null;
            Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

            // loop through them starting from index = 0.
            for (int i = 0; i < A.length; i++) {
                mp.put(A[i], i);
            }

            // loop through numbers starting from 1 and check the map for each number.
            for (int i = 1; i <= A.length; i++) {
                if (!mp.containsKey(i)) {
                    return i;
                }
            }

            if (null == result) {
                // all elements are in the array.
                return A.length + 1;
            }
        }
        return 0;
    }

    /**
     * This is not a constant space solution.
     *
     * <p>This approach may take O(n) time on average, but it requires O(n) extra space.
     */
    public int getFirstMissingPositiveInteger_ImplementedUsingSet(int[] A) {
        int result = 1;

        if (null == A || 0 == A.length) {
            // do nothing
        } else {
            // remove duplicates.
            // When memory is a limitation, this solution will not work.

            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < A.length; i++) {
                set.add(A[i]);
            }

            // loop through them starting from the number 1.
            for (int i = 0; i <= A.length; i++) {
                if (!set.contains((i + 1))) {
                    result = i + 1;
                    break;
                }
            }
        }
        return result;
    }
}

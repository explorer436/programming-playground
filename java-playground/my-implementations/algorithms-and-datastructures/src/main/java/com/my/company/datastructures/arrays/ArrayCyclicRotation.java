package com.my.company.datastructures.arrays;

import java.util.Collections;
import java.util.List;

public class ArrayCyclicRotation {

    /**
     * This can also be written using System.arraycopy( result, 0, A, 0, A.length ) or
     * Arrays.copyOfRange().
     *
     * <p>int[] newArray = Arrays.copyOfRange(oldArray, startIndex, endIndex);
     *
     * <p>public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
     * Copies an array from the specified source array, beginning at the specified position, to the
     * specified position of the destination array. A subsequence of array components are copied from
     * the source array referenced by src to the destination array referenced by dest. The number of
     * components copied is equal to the length argument. The components at positions srcPos through
     * srcPos+length-1 in the source array are copied into positions destPos through destPos+length-1,
     * respectively, of the destination array.
     *
     * <p>But the disadvantage of that approach is that it creates an extra array - not good when
     * space complexity is considered.
     */
    public int[] solution(int[] A, int K) {
        // System.out.println("A.length : " + A.length + " and K : " + K);

        if (0 == A.length || K == A.length) {
            return A;
        }

        if (K > A.length) {
            K = K % A.length;
        }

        // using an intermediate array to hold the results.
        // not an in-place solution.

        // for an in-place solution, look at rotate2()

        int[] result = new int[A.length];

        for (int i = 0; i < K; i++) {
            result[i] = A[A.length - K + i];
        }

        int j = 0;
        for (int i = K; i < A.length; i++) {
            result[i] = A[j];
            j++;
        }

        return result;
    }

    /**
     * Return elements at only specific positions after cyclic rotation instead of returning the
     * entire rotated array.
     */
    protected int[] getQueriedPositionsAfterCyclicArrayRotation(int[] a, int k, int[] queries) {

        int[] rotatedArray = solution(a, k);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = rotatedArray[queries[i]];
        }

        return result;
    }

    /**
     * Take a look at OpenJDK's implementation here : OpenJDK's rotate implementation :
     * https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/Collections.java
     */
    protected List<?> rotate2(List<?> list, int distance) {

        int size = list.size();

        if (size == 0) {
            return list;
        }

        int mid = -distance % size;

        if (mid < 0) {
            mid = mid + size;
        }

        if (mid == 0) {
            return list;
        }

    /*
      	OpenJDK's reverse implementation :
    	https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/Collections.java
    */
        Collections.reverse(list.subList(0, mid));
        Collections.reverse(list.subList(mid, size));
        Collections.reverse(list);

        return list;
    }
}

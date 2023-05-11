package com.my.company.datastructures.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MaximumAndMinimumElementsInAnArray {

    public static void main(String[] args) {

        int[] anArray;

        anArray = new int[]{5, 2, 10, 1, 9, 3, 8, 4, 6, 7, 0};
        System.out.println(Arrays.toString(anArray));
        System.out.println(
                "largestValue : " + MaximumAndMinimumElementsInAnArray.largestValue_recursion(anArray));
        System.out.println(
                "smallest : " + MaximumAndMinimumElementsInAnArray.smallestValue_recursion(anArray));

        System.out.println();

        anArray = new int[]{5, 2, 1, 9, 3, 8, 4, 6, 7, 0};
        System.out.println(Arrays.toString(anArray));
        System.out.println(
                "largestValue : " + MaximumAndMinimumElementsInAnArray.largestValue_recursion(anArray));
        System.out.println(
                "smallest : " + MaximumAndMinimumElementsInAnArray.smallestValue_recursion(anArray));

        System.out.println();

        anArray = new int[]{5};
        System.out.println(Arrays.toString(anArray));
        System.out.println(
                "largestValue : " + MaximumAndMinimumElementsInAnArray.largestValue_recursion(anArray));
        System.out.println(
                "smallest : " + MaximumAndMinimumElementsInAnArray.smallestValue_recursion(anArray));

        System.out.println();

        anArray = new int[]{-2, -1, 0};
        System.out.println(Arrays.toString(anArray));
        System.out.println(
                "largestValue : " + MaximumAndMinimumElementsInAnArray.largestValue_recursion(anArray));
        System.out.println(
                "smallest : " + MaximumAndMinimumElementsInAnArray.smallestValue_recursion(anArray));

        System.out.println();

        Integer[] anArray2;

        anArray2 = new Integer[]{-1, 0, -2};
        System.out.println(Arrays.toString(anArray));
        // System.out.println("largestValue : " +
        // MaximumAndMinimumElementsInAnArray.largestValue_recursion(anArray));
        System.out.println(
                "smallest of Integers : "
                        + MaximumAndMinimumElementsInAnArray.smallestValue_comparable(anArray2));
        System.out.println(
                "index of smallest of Integers : "
                        + MaximumAndMinimumElementsInAnArray.indexOfSmallestValue_comparable(anArray2));

        System.out.println();

        Integer[] anArray3 = new Integer[]{-1};
        System.out.println(Arrays.toString(anArray3));
        // System.out.println("largestValue : " +
        // MaximumAndMinimumElementsInAnArray.largestValue_recursion(anArray));
        System.out.println(
                "smallest of Integers : "
                        + MaximumAndMinimumElementsInAnArray.smallestValue_comparable(anArray3));
        System.out.println(
                "index of smallest of Integers : "
                        + MaximumAndMinimumElementsInAnArray.indexOfSmallestValue_comparable(anArray3));

        System.out.println();

        System.out.println(Arrays.toString(anArray));
        System.out.println(
                "largestValue using openjdk's max method : "
                        + MaximumAndMinimumElementsInAnArray.max(Arrays.asList(anArray2)));
    }

    /**
     * if (anArray has only one entry) maxArray(anArray) is the entry in anArray else if (anArray has
     * more than one entry) maxArray(anArray) is the maximum of maxArray(left half of anArray) and
     * maxArray(right half of anArray)
     *
     * <p>Notice that this strategy ﬁts the divide-and-conquer model that the binary search algorithm
     * uses. That is, we proceed by dividing the problem and conquering the subproblems. However,
     * there is a difference between this algorithm and the binary search algorithm. Although the
     * binary search algorithm conquers only one of its subproblems at each step, maxArray conquers
     * both. Because both subproblems are solved recursively, this approach is called multipath
     * recursion. After maxArray conquers the subproblems, it must reconcile the two solutions—that
     * is, it must ﬁnd the maximum of the two maximums.
     */

    /**
     * (Tournament Method) Divide the array into two parts and compare the maximums and minimums of
     * the two parts to get the maximum and the minimum of the whole array.
     *
     * <p>Pair MaxMin(array, array_size) if array_size = 1 return element as both max and min else if
     * arry_size = 2 one comparison to determine max and min return that pair else (array_size > 2)
     * recur for max and min of left half recur for max and min of right half one comparison
     * determines true max of the two candidates one comparison determines true min of the two
     * candidates return the pair of max and min
     */
    public static int largestValue_recursion(int[] anArray) {

        int result = 0;

        if (null != anArray && anArray.length != 0) {
            if (anArray.length == 1) {
                result = anArray[0];
            } else {
                int midPoint = (anArray.length + 1) / 2;
                int[] firstHalf = Arrays.copyOfRange(anArray, 0, midPoint);
                int[] secondHalf = Arrays.copyOfRange(anArray, midPoint, anArray.length);

                result =
                        largestValue_recursion(firstHalf) > largestValue_recursion(secondHalf)
                                ? largestValue_recursion(firstHalf)
                                : largestValue_recursion(secondHalf);
            }
        }

        return result;
    }

    public static int smallestValue_recursion(int[] anArray) {

        int result = 0;

        if (null != anArray && anArray.length != 0) {
            if (anArray.length == 1) {
                result = anArray[0];
            } else {
                int midPoint = (anArray.length + 1) / 2;
                int[] firstHalf = Arrays.copyOfRange(anArray, 0, midPoint);
                int[] secondHalf = Arrays.copyOfRange(anArray, midPoint, anArray.length);

                result =
                        smallestValue_recursion(firstHalf) < smallestValue_recursion(secondHalf)
                                ? smallestValue_recursion(firstHalf)
                                : smallestValue_recursion(secondHalf);
            }
        }

        return result;
    }

    public static Comparable smallestValue_comparable(Comparable[] anArray) {

        Comparable result = 0;

        if (null != anArray && anArray.length != 0) {
            if (anArray.length == 1) {
                result = anArray[0];
            } else {
                int midPoint = (anArray.length + 1) / 2;
                Comparable[] firstHalf = Arrays.copyOfRange(anArray, 0, midPoint);
                Comparable[] secondHalf = Arrays.copyOfRange(anArray, midPoint, anArray.length);

                int comparisonResult =
                        smallestValue_comparable(firstHalf).compareTo(smallestValue_comparable(secondHalf));
                result =
                        comparisonResult < 0
                                ? smallestValue_comparable(firstHalf)
                                : smallestValue_comparable(secondHalf);
            }
        }

        return result;
    }

    /*
     * These methods are not useful for SelectionSort.
     * SelectionSort needs the index of the current smallest element in the array.
     * We need a method to return the index of the current smallest element in the array instead of
     * returning the smallest element in the array.
     */

    public static int indexOfSmallestValue_comparable(Comparable[] anArray) {

        int result = 0;

        if (null != anArray && anArray.length != 0) {
            if (anArray.length == 1) {
                result = 0;
            } else {
                for (int index = 0; index < anArray.length; index++) {
                    if (anArray[result].compareTo(anArray[index]) > 0) {
                        result = index;
                    }
                }
            }
        }

        return result;
    }

    // TODO understand the implementation below.

    /**
     * Take a look at OpenJDK's collection implementations here.
     * https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/Collections.java
     */
    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
        Iterator<? extends T> i = coll.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (next.compareTo(candidate) > 0) candidate = next;
        }

        return candidate;
    }
}

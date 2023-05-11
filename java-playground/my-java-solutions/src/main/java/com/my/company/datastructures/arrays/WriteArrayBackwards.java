package com.my.company.datastructures.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

import com.my.company.utility.ArrayUtils;

public class WriteArrayBackwards {

    private static final int REVERSE_THRESHOLD = 18;

    public static void main(String[] args) {

        String[] myStringArray;

        myStringArray = new String[]{"t", "e", "s", "t", "i", "n", "g"};
        WriteArrayBackwards.printArrayInReverse_recursive(myStringArray);

        myStringArray = new String[]{"t"};
        WriteArrayBackwards.printArrayInReverse_recursive(myStringArray);

        myStringArray = new String[]{};
        WriteArrayBackwards.printArrayInReverse_recursive(myStringArray);

        System.out.println();

        myStringArray = new String[]{"t", "e", "s", "t", "i", "n", "g"};
        WriteArrayBackwards.printArrayInReverse_iterative(myStringArray);

        myStringArray = new String[]{"t"};
        WriteArrayBackwards.printArrayInReverse_iterative(myStringArray);

        myStringArray = new String[]{};
        WriteArrayBackwards.printArrayInReverse_iterative(myStringArray);
    }

    public static void printArrayInReverse_recursive(String[] strArray) {

        if (null != strArray && strArray.length > 1) {
            System.out.println(strArray[strArray.length - 1]);
            printArrayInReverse_recursive(Arrays.copyOfRange(strArray, 0, strArray.length - 1));
        }
        // base condition
        else if (strArray.length == 1) {
            System.out.println(strArray[0]);
        }
    }

    public static void printArrayInReverse_iterative(String[] strArray) {

        // base condition
        if (strArray.length == 1) {
            System.out.println(strArray[0]);
        } else if (null != strArray && strArray.length > 1) {
            for (int index = strArray.length; index >= 1; index--) {
                System.out.println(strArray[index - 1]);
            }
        }
    }

    // TODO understand the implementation below.

    /**
     * OpenJDK's reverse implementation :
     * https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/Collections.java
     */

    /**
     * Reverses the order of the elements in the specified list.
     *
     * <p>This method runs in linear time.
     *
     * @param list the list whose elements are to be reversed.
     * @throws UnsupportedOperationException if the specified list or its list-iterator does not
     *                                       support the <tt>set</tt> operation.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void reverse(List<?> list) {

        int size = list.size();

        if (size < REVERSE_THRESHOLD || list instanceof RandomAccess) {
            for (int i = 0, mid = size >> 1, j = size - 1; i < mid; i++, j--) ArrayUtils.swap(list, i, j);
        } else {

            // instead of using a raw type here, it's possible to capture
            // the wildcard but it will require a call to a supplementary
            // private method
            ListIterator fwd = list.listIterator();
            ListIterator rev = list.listIterator(size);

            for (int i = 0, mid = list.size() >> 1; i < mid; i++) {
                Object tmp = fwd.next();
                fwd.set(rev.previous());
                rev.set(tmp);
            }
        }
    }
}

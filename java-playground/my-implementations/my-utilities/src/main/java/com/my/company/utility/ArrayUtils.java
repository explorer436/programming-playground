package com.my.company.utility;

import java.util.List;

public class ArrayUtils {

  // swap the integers at indices i and j
  public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  // swap the characters at indices i and j
  public static void swap(char[] a, int i, int j) {
    char temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  // exchange a[i] and a[j]
  public static void swap(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  // TODO understand the implementation below.

  // Remember : how to swap elements without using a temp variable.

  /**
   * OpenJDK's swap implementation :
   * https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/Collections.java
   */

  /**
   * Swaps the elements at the specified positions in the specified list. (If the specified
   * positions are equal, invoking this method leaves the list unchanged.)
   *
   * @param list The list in which to swap elements.
   * @param i the index of one element to be swapped.
   * @param j the index of the other element to be swapped.
   * @throws IndexOutOfBoundsException if either <tt>i</tt> or <tt>j</tt> is out of range (i &lt; 0
   *     || i &gt;= list.size() || j &lt; 0 || j &gt;= list.size()).
   * @since 1.4
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void swap(List<?> list, int i, int j) {
    // instead of using a raw type here, it's possible to capture
    // the wildcard but it will require a call to a supplementary
    // private method
    final List l = list;
    l.set(i, l.set(j, l.get(i)));
  }
}

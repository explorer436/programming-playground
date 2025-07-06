package com.my.company.datastructures.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array containing positive and negative integers,
 *
 * <p>how to move all the negative integers to the left side of the array?
 *
 * <p>how to get a count of the total number or negative integers in the array?
 *
 * <p>how to get a count of the total number or positive integers in the array? (length - total
 * number of negative integers)
 */
public class DropFirstNElementsOfAnArray {

  public static void main(String[] args) {
    int[] A = {4, 1, 3, 2, -5, -1};

    System.out.println(
        "result after skipping 2 elements from the beginning of the array "
            + Arrays.toString(A)
            + " is ");
    skipFirstKElementsOfArray(A, 2);

    System.out.println();

    System.out.println(
        "result after skipping 10 elements from the beginning of the array "
            + Arrays.toString(A)
            + " is ");
    skipFirstKElementsOfArray(A, 10);
  }

  /**
   * If we already know the total number of elements that should be dropped from the beginning of an
   * array, look at the method skipFirstKElementsOfArray() below.
   */

  /** Use collection streams (skip method) to get a specific part of the array. */
  public static void skipFirstKElementsOfArray(int[] A, int K) {
    if (0 == A.length || K == A.length) {
      System.out.println(Arrays.toString(A));
    }

    // An alternative is to use List's list.subList(a, b) method.
    // If we want to do it only using arrays, use int[] newArray = Arrays.copyOfRange(oldArray,
    // startIndex, endIndex);
    // But the disadvantage of that approach is that it creates an extra array - not good when space
    // complexity is considered.

    /**
     * boxed Stream<Integer> boxed() Returns a Stream consisting of the elements of this stream,
     * each boxed to an Integer. This is an intermediate operation.
     *
     * <p>skip Stream<T> skip(long n) Returns a stream consisting of the remaining elements of this
     * stream after discarding the first n elements of the stream. If this stream contains fewer
     * than n elements then an empty stream will be returned.
     */
    List<Integer> result = Arrays.stream(A).boxed().skip(K).collect(Collectors.toList());

    System.out.println("initial array before skipping " + K + " elements : " + Arrays.toString(A));
    System.out.println(
        "new array after skipping " + K + " elements : " + Arrays.toString(result.toArray()));
  }
}

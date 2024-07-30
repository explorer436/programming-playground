package com.my.company.sorting.algorithms;

import com.my.company.utility.PrintUtils;

/**
 * The quicksort algorithm’s desirable features are that it is in-place (uses only a small auxiliary
 * stack) and that it requires time proportional to N log N on the average to sort an array of
 * length N. None of the algorithms that we have so far considered combine these two properties.
 * Furthermore, quicksort has a shorter inner loop than most other sorting algorithms, which means
 * that it is fast in practice as well as in theory.
 *
 * <p>The basic algorithm Quicksort is a divide-and-conquer method for sorting. It works by
 * partitioning an array into two subarrays, then sorting the subarrays indepen- dently. Quicksort
 * is complementary to mergesort: for mergesort, we break the array into two subarrays to be sorted
 * and then combine the ordered subarrays to make the whole ordered array; for quicksort, we
 * rearrange the array such that, when the two subarrays are sorted, the whole array is ordered. In
 * the first instance, we do the two recursive calls before working on the whole array; in the
 * second instance, we do the two recursive calls after working on the whole array. For mergesort,
 * the array is divided in half; for quicksort, the position of the partition depends on the
 * contents of the array.
 */
public class Quicksort {

  public static void main(String[] args) {

    Integer[] intArray = new Integer[] {5, 7, 0, 3, 4, 2, 6, 1};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    quickSort(intArray, 0, intArray.length);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);

    System.out.println();

    String[] strArray = new String[] {"ghi", "abc", "def"};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(strArray);
    quickSort(strArray, 0, strArray.length);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(strArray);
  }

  public static void quickSort(Comparable[] a, int beginning, int ending) {
    // one element arrays.
    if (ending - beginning < 2) {
      return;
    }

    int pivotIndex = partition(a, beginning, ending);

    quickSort(a, beginning, pivotIndex);
    quickSort(a, pivotIndex + 1, ending);
  }

  public static int partition(Comparable[] a, int beginning, int ending) {
    // this uses the first element of a as the pivot.
    Comparable pivot = a[beginning];

    // i will be traversing from left to right and j will be traversing from right to left.
    int i = beginning;
    int j = ending;

    // when i and j cross each other, the traversal should stop.
    while (i < j) {
      // we are going to use j to look for elements that are less than the pivot (starting from the
      // ending of the array).
      // empty loop body - we are not doing anything in the body of the loop.
      // it's purpose is to keep decrementing j until we find an element that is lesser than the
      // pivot.
      // pre-decrement j because, we don't want to consider the last element of the array.
      while (i < j && a[--j].compareTo(pivot) >= 0) {}

      // if we fall out of the loop above, it means that we found an element that is lesser than the
      // pivot.
      // in that case, move the element at j to location i.
      // this is not a swap. this is just a move operation.
      // don't worry about losing the previous data element that was stored at j. we already saved
      // it in the variable 'pivot'.
      if (i < j) {
        a[i] = a[j];
      }

      // now, we are going to use i to look for elements that are greater than the pivot (starting
      // from the beginning of the array).
      // empty loop body - we are not doing anything in the body of the loop.
      // it's purpose is to keep incrementing i until we find an element that is greater than the
      // pivot.
      // pre-increment i because, we don't want to consider the index i - which we already used in
      // the previous step.
      while (i < j && a[++i].compareTo(pivot) <= 0) {}

      // if we fall out of the loop above, it means that we found an element that is greater than
      // the pivot.
      // in that case, move the element at i to location j.
      // this is not a swap. this is just a move operation.
      // don't worry about losing the previous data element that was stored at index j. we already
      // saved it at the index i (before incrementing i).
      if (i < j) {
        a[j] = a[i];
      }
    }
    // when we drop out of the while loop above, it means that i crossed j.
    // at this point, j is the index where we want to insert the pivot.
    a[j] = pivot;

    // we need to return the index where we inserted the pivot.
    return j;
  }
}

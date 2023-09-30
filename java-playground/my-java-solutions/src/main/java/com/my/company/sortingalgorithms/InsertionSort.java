package com.my.company.sortingalgorithms;

import com.my.company.utility.ArrayUtils;
import com.my.company.utility.PrintUtils;

/*
*
See InsertionSort.png
Assuming that the entire array is divided into sorted and unsorted parts,
each of the elements from the unsorted part is inserted into the correct position in the sorted part.
Hence the name, Insertion sort.

	Insertion sort is an elementary sorting algorithm.
It has a time complexity of Θ(n ^ 2), thus being slower than heapsort, merge sort and also shellsort.
Insertion sort is well suited for sorting small data sets or for the insertion of new elements into a sorted sequence.

Idea :

Let a0, ..., an-1 be the sequence to be sorted.
At the beginning and after each iteration of the algorithm the sequence consists of two parts:
the first part a0, ..., ai-1 is already sorted,
the second part ai, ..., an-1 is still unsorted (i element 0, ..., n).

In order to insert element ai into the sorted part, it is compared with ai-1, ai-2 etc.
When an element aj with ajless or equalai is found, ai is inserted behind it.
If no such element is found, then ai is inserted at the beginning of the sequence.

After inserting element ai, the length of the sorted part has increased by one.
In the next iteration, ai+1 is inserted into the sorted part etc.
While at the beginning the sorted part consists of element a0 only, at the end it consists of all elements a0, ..., an-1.
*
*/
public class InsertionSort {

  public static void main(String[] args) {
    Integer[] intArray = new Integer[] {5, 7, 0, 3, 4, 2, 6, 1};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    System.out.println("---------printing the sorted list using iteration------------");
    insertionSort_iterative(intArray);
    PrintUtils.printArray(intArray);
    System.out.println("---------printing the sorted list using recursion------------");
    insertionSort_recursive(intArray, intArray.length);
    PrintUtils.printArray(intArray);

    System.out.println();

    String[] strArray = new String[] {"ghi", "abc", "def"};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(strArray);
    System.out.println("---------printing the sorted list using iteration------------");
    insertionSort_iterative(strArray);
    PrintUtils.printArray(strArray);
    System.out.println("---------printing the sorted list using recursion------------");
    insertionSort_recursive(strArray, strArray.length);
    PrintUtils.printArray(strArray);
  }

  /**
   * Initially, A[0] is considered to be a sorted part of size = 1. And the algorith starts
   * evaluating the initial array starting from the second position (i = 1).
   *
   * <p>A = [5, 7, 0, 3, 4, 2, 6, 1]
   * --------------------------------------------------------------------------------------------------------
   * i = 1 [5 7 0 3 4 2 6 1] i
   *
   * <p>j = 1 [5 7 0 3 4 2 6 1] j compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>A at the end of the iteration i = 1, [5 7 0 3 4 2 6 1]
   * --------------------------------------------------------------------------------------------------------
   * i = 2 [5 7 0 3 4 2 6 1] i
   *
   * <p>j = 2 [5 7 0 3 4 2 6 1] j compare A[j] with A[j - 1].. A[2] with A[1] and exchange them.
   *
   * <p>j = 1 [5 0 7 3 4 2 6 1] j compare A[j] with A[j - 1].. A[1] with A[0] and exchange them.
   *
   * <p>A at the end of the iteration i = 2, [0 5 7 3 4 2 6 1]
   * --------------------------------------------------------------------------------------------------------
   * i = 3 [0 5 7 3 4 2 6 1] i
   *
   * <p>j = 3 [0 5 7 3 4 2 6 1] j compare A[j] with A[j - 1].. A[3] with A[2] and exchange them.
   *
   * <p>j = 2 [0 5 3 7 4 2 6 1] j compare A[j] with A[j - 1].. A[2] with A[1] and exchange them.
   *
   * <p>j = 1 [0 3 5 7 4 2 6 1] j compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>A at the end of the iteration i = 3, [0 3 5 7 4 2 6 1]
   * --------------------------------------------------------------------------------------------------------
   * i = 4 [0 3 5 7 4 2 6 1] i
   *
   * <p>j = 4 [0 3 5 7 4 2 6 1] j compare A[j] with A[j - 1].. A[4] with A[3] and exchange them.
   *
   * <p>j = 3 [0 3 5 4 7 2 6 1] j compare A[j] with A[j - 1].. A[3] with A[2] and exchange them.
   *
   * <p>j = 2 [0 3 4 5 7 2 6 1] j compare A[j] with A[j - 1].. A[2] with A[1] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>j = 1 [0 3 4 5 7 2 6 1] j compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>A at the end of the iteration i = 4, [0 3 4 5 7 2 6 1]
   * --------------------------------------------------------------------------------------------------------
   * i = 5 [0 3 4 5 7 2 6 1] i
   *
   * <p>j = 5 [0 3 4 5 7 2 6 1] j compare A[j] with A[j - 1].. A[5] with A[4] and exchange them.
   *
   * <p>j = 4 [0 3 4 5 2 7 6 1] j compare A[j] with A[j - 1].. A[4] with A[3] and exchange them.
   *
   * <p>j = 3 [0 3 4 2 5 7 6 1] j compare A[j] with A[j - 1].. A[3] with A[2] and exchange them.
   *
   * <p>j = 2 [0 3 2 4 5 7 6 1] j compare A[j] with A[j - 1].. A[2] with A[1] and exchange them.
   *
   * <p>j = 1 [0 2 3 4 5 7 6 1] j compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>A at the end of the iteration i = 5, [0 2 3 4 5 7 6 1]
   * --------------------------------------------------------------------------------------------------------
   * i = 6 [0 2 3 4 5 7 6 1] i
   *
   * <p>j = 6 [0 2 3 4 5 7 6 1] j compare A[j] with A[j - 1].. A[6] with A[5] and exchange them.
   *
   * <p>j = 5 [0 2 3 4 5 6 7 1] j compare A[j] with A[j - 1].. A[5] with A[4] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>j = 4 [0 2 3 4 5 6 7 1] j compare A[j] with A[j - 1].. A[4] with A[3] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>j = 3 [0 2 3 4 5 6 7 1] j compare A[j] with A[j - 1].. A[3] with A[2] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>j = 2 [0 2 3 4 5 6 7 1] j compare A[j] with A[j - 1].. A[2] with A[1] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>j = 1 [0 2 3 4 5 6 7 1] j compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>A at the end of the iteration i = 6, [0 2 3 4 5 6 7 1]
   * --------------------------------------------------------------------------------------------------------
   * i = 7 [0 2 3 4 5 6 7 1] i
   *
   * <p>j = 7 [0 2 3 4 5 6 7 1] j compare A[j] with A[j - 1].. A[7] with A[6] and exchange them.
   *
   * <p>j = 6 [0 2 3 4 5 6 1 7] j compare A[j] with A[j - 1].. A[6] with A[5] and exchange them.
   *
   * <p>j = 5 [0 2 3 4 5 1 6 7] j compare A[j] with A[j - 1].. A[5] with A[4] and exchange them.
   *
   * <p>j = 4 [0 2 3 4 1 5 6 7] j compare A[j] with A[j - 1].. A[4] with A[3] and exchange them.
   *
   * <p>j = 3 [0 2 3 1 4 5 6 7] j compare A[j] with A[j - 1].. A[3] with A[2] and exchange them.
   *
   * <p>j = 2 [0 2 1 3 4 5 6 7] j compare A[j] with A[j - 1].. A[2] with A[1] and exchange them.
   *
   * <p>j = 1 [0 1 2 3 4 5 6 7] j compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j -
   * 1], no need to exchange them.
   *
   * <p>A at the end of the iteration i = 7, [0 1 2 3 4 5 6 7]
   */
  public static void insertionSort_iterative(Comparable[] a) {
    int length = a.length;

    for (int i = 1; i < length; i++) {
      for (int j = i; j > 0; j--) {
        boolean isTheFirstGreaterThanTheSecond = a[j - 1].compareTo(a[j]) > 0;
        if (isTheFirstGreaterThanTheSecond) {
          ArrayUtils.exch(a, j - 1, j);
        } else {
          break;
        }
      }
    }
  }

  /**
   * writing an recursive solution for this: step 1 : write a method that accepts the input array
   * and an extra parameter that tells the method about the number of elements that should be
   * sorted.
   *
   * <p>step 2 : breaking condition
   */
  public static void insertionSort_recursive(Comparable[] a, int numberOfElementsToBeSorted) {
    if (numberOfElementsToBeSorted == 1) {
      return;
    }

    // we are replacing the outer for loop with a recursive call.
    insertionSort_recursive(a, numberOfElementsToBeSorted - 1);

    int length = a.length;

    for (int j = numberOfElementsToBeSorted - 1; j > 0; j--) {
      boolean isTheFirstGreaterThanTheSecond = a[j - 1].compareTo(a[j]) > 0;
      if (isTheFirstGreaterThanTheSecond) {
        ArrayUtils.exch(a, j - 1, j);
      } else {
        break;
      }
    }
  }
}

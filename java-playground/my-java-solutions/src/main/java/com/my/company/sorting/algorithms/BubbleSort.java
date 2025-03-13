package com.my.company.sorting.algorithms;

import com.my.company.utility.ArrayUtils;
import com.my.company.utility.PrintUtils;

/** TODO add details here. */
public class BubbleSort {

  public static void main(String[] args) {

    Integer[] intArray;

    intArray = new Integer[] {-1, 0, -2};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    sort(intArray);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);

    System.out.println();

    intArray = new Integer[] {1, 3, 7, 2, 5};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    sort(intArray);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);

    System.out.println();

    intArray = new Integer[] {5};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    sort(intArray);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);

    System.out.println();

    intArray = new Integer[] {};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    sort(intArray);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);

    System.out.println();

    String[] strArray = new String[] {"ghi", "abc", "def"};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(strArray);
    sort(strArray);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(strArray);
  }

  // Why do we need two for loops?
  public static void sort(Comparable[] a) {
    if (null != a && a.length > 1) {
      // a variable to keep track of the upper limit until which the bigger number of the array will be moved.
      for (int i = a.length; i > 0; i--) {
        /*
         * a variable that is used to compare each pair starting with [0, 1] until the variable i.
         * with each comparison, the highest element is moved to the right.
         * so, with each iteration of j, the highest number of the element is moved to the far right.
         * this is for sorting from smallest to larger numbers.
         */
        for (int j = 1; j < i; j++) {
          Comparable first = a[j];
          Comparable second = a[j - 1];

          // second is lesser than first
          if (first.compareTo(second) < 0) {
            ArrayUtils.exch(a, j, j - 1);
          }
        }
      }
    }
  }


  // TODO
  /*
  function bubbleSort(array) {
    var done = false;
    while (!done) {
      done = true;
      for (var i = 1; i < array.length; i += 1) {
        if (array[i - 1] > array[i]) {
          done = false;
          var tmp = array[i - 1];
          array[i - 1] = array[i];
          array[i] = tmp;
        }
      }
    }

    return array;
  }
   */

}

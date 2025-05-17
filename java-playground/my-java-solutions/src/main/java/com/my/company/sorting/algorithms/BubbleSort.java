package com.my.company.sorting.algorithms;

import com.my.company.utility.ArrayUtils;

public class BubbleSort {

  // Why do we need two for loops?
  public Comparable[] sort(Comparable[] a) {
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
    return a;
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

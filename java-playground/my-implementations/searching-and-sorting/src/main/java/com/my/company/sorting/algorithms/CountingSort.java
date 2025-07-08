package com.my.company.sorting.algorithms;

import com.my.company.utility.PrintUtils;

/**
 * Use this only when the range of values in the array is reasonably small. This will not be a good
 * use case for array with numbers that range over large numbers. e.g. if min = 1, max = 10,000, do
 * not use this. Ideally, the range is approximately equal to the number of elements we want to
 * sort.
 */
public class CountingSort {

  public static void main(String[] args) {

    Integer[] intArray = new Integer[] {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);

    // Note that 'min' is provided a value of '1' - which is not in the array.

    sort(intArray, 1, 10);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);
  }

  // 2, 5, 9, 8, 2, 8, 7, 10, 4, 3

  /** This is the unstable version of it. */
  public static void sort(Integer[] arr, int min, int max) {
    // create an array to keep track of the count of elements.
    int countArray[] = new int[(max - min) + 1];
    // the size of countArray may not be the same as the size of input array.

    for (int i = 0; i < arr.length; i++) {
      // when we subtract the min value in the array from each of the elements in the array,
      // the result will be the index of the element in the array countArray.
      countArray[arr[i] - min]++;
    }

    // we need to write the contents of countArray back into the original array arr.

    // we use j to keep track of the index of arr.
    int j = 0;
    for (int i = min; i <= max; i++) {
      // need a while loop because there may be repetitions.
      // e.g. 2 is repeated in the input arr.
      while (countArray[i - min] > 0) {
        arr[j++] = i;
        countArray[i - min]--;
      }
    }
  }

  // TODO is there a way to make this work with arrays that contain negative numbers?

}

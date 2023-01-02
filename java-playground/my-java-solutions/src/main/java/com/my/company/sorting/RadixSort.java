package com.my.company.sorting;

import com.my.company.utility.PrintUtils;

/**
 * Assumption: The data has the same radix and width.
 *
 * <p>A radix is the number of unique values or numbers that the input has. e.g. the radix for the
 * decimal system is 10 - because there are 10 possible numbers in it - 0 to 9. for binary system,
 * it is 2. for the english alphabet, it is 26.
 *
 * <p>Width is number of digits or letters in the input. e.g. width of "hello" is 5. width of [1, 2,
 * 3, 4] is 4. width of the number "10" is 2.
 *
 * <p>Remember: For this, we have to use a stable sorting algorithm at each stage.
 *
 * <p>Points to be noted: 1. Counting sort is efficient if the range of input data is not
 * significantly greater than the number of objects to be sorted. Consider the situation where the
 * input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K. 2. It is not a
 * comparison based sorting. It running time complexity is O(n) with space proportional to the range
 * of data. 3. It is often used as a sub-routine to another sorting algorithm like radix sort. 4.
 * Counting sort uses a partial hashing to count the occurrence of the data object in O(1). 5.
 * Counting sort can be extended to work for negative inputs also.
 *
 * <p>Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of
 * input. Auxiliary Space: O(n+k)
 */
public class RadixSort {

  /**
   * example input array : [ 4725, 4586, 1330, 8792, 1594, 5729 ]
   *
   * <p>first, sort using the units position.
   *
   * <p>[ 1330, 8792, 1594, 4725, 4586, 5729 ]
   *
   * <p>then, sort using the tens position.
   *
   * <p>[ 1330, 4725, 5729, 4586, 8792, 1594 ]
   *
   * <p>then, sort using the hundreds position.
   *
   * <p>[ 1330, 4586, 1594, 4725, 5729, 8792 ]
   *
   * <p>then, sort using the thousands position.
   *
   * <p>[ 1330, 1594, 4586, 4725, 5729, 8792 ]
   */

  /** Counting sort is used as the algorthm for radix sort - must be stable counting sort. */
  public static void main(String[] args) {

    int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};

    radixSort(radixArray, 10, 4);

    PrintUtils.printArray(radixArray);
  }

  public static void radixSort(int[] input, int radix, int width) {
    for (int i = 0; i < width; i++) {
      radixSingleSort(input, i, radix);
    }
  }

  public static void radixSingleSort(int[] input, int position, int radix) {

    int numItems = input.length;
    int[] countArray = new int[radix];

    for (int value : input) {
      countArray[getDigit(position, value, radix)]++;
    }
    // Adjust the count array
    for (int j = 1; j < radix; j++) {
      countArray[j] += countArray[j - 1];
    }

    int[] temp = new int[numItems];
    for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
      temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
    }

    for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
      input[tempIndex] = temp[tempIndex];
    }
  }

  public static int getDigit(int position, int value, int radix) {
    return value / (int) Math.pow(radix, position) % radix;
  }
}

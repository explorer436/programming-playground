package com.my.company.codility.countingelements;

import java.util.Arrays;

public class MaxCounters {

  /**
   * java - Arrays.fill() public static void fill(Object[] a, Object val) { for (int i = 0, len =
   * a.length; i < len; i++) //this loop will continues to the length of a. a[i] = val; } So,
   * Complexity for this method would be O(n power 2).
   */
  public int[] bruteForceSolution_slow(int N, int[] A) {
    int[] counterArray = new int[N];
    System.out.println(Arrays.toString(counterArray));
    // [0, 0, 0, 0, 0]

    int maxElementInCounterArray = 0;
    for (int arrAIndex = 0; arrAIndex < A.length; arrAIndex++) {
      if (A[arrAIndex] == N + 1) {
        // O(n)
        Arrays.fill(counterArray, maxElementInCounterArray);
      } else if (1 <= A[arrAIndex] && A[arrAIndex] <= N) {
        counterArray[A[arrAIndex] - 1] = counterArray[A[arrAIndex] - 1] + 1;
        if (counterArray[A[arrAIndex] - 1] > maxElementInCounterArray) {
          maxElementInCounterArray = counterArray[A[arrAIndex] - 1];
        }
      }
    }

    return counterArray;
  }

  // O(N + M)
  public int[] solution(int N, int[] A) {
    int counter[] = new int[N];
    int current_max = -1;
    int leastPossibleCounterValue = 0;

    for (int currentIndex = 0; currentIndex < A.length; currentIndex++) {
      int currentAElement = A[currentIndex];

      // check if currentAElement is between 1 and N.
      if (1 <= currentAElement && currentAElement <= N) {
        int currentCounterElement = counter[currentAElement - 1];

        /**
         * check the value of currentCounterElement is less than leastPossibleCounterValue.
         *
         * <p>this tells us whether the value of currentCounterElement should be incremented or if
         * it should be first set to leastPossibleCounterValue and then incremented.
         */
        if (currentCounterElement < leastPossibleCounterValue) {
          currentCounterElement = leastPossibleCounterValue;
        }

        // increment currentCounterElement
        currentCounterElement = currentCounterElement + 1;

        // make sure the value of current_max is accurate. if it needs to be changed, change it.
        if (currentCounterElement > current_max) {
          current_max = currentCounterElement;
        }

        // set the value of currentCounterElement in counter array.
        counter[currentAElement - 1] = currentCounterElement;
      } else if (currentAElement == N + 1) {
        /**
         * this is the crucial difference between bruteForceSolution_slow() and this solution.
         * instead of changing the values of the elements in the entire counter array, we are
         * maintaining the value for leastPossibleCounterValue.
         */
        leastPossibleCounterValue = current_max;
      }
    }

    // there might be some orphan counter elements whose value might be smaller than
    // leastPossibleCounterValue.
    // for elements like that, set them to leastPossibleCounterValue.
    for (int i = 0; i < N; i++) {
      if (counter[i] < leastPossibleCounterValue) {
        counter[i] = leastPossibleCounterValue;
      }
    }

    return counter;
  }
}

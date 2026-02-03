package com.my.company.codility.prefixsums;

import com.my.company.utility.PrintUtils;

public class MinAvgTwoSlice {

    static float global_minimum_average = Integer.MAX_VALUE;

    static int indexWithMinimumAverage = 0;

    /*
     * This is overkill.
     * See MinAvgTwoSlice3.java for the most correct answer to the problem.
     */

    // This solution got only 60% score.
    // correctness 100%
    // performance 20%

    public int getStartingPositionOfMinimumSlice(int[] A) {
        int n = A.length;
        // square array with size A.length + 1
        int[][] cumulativeElementsOfTheArray = new int[n][n];

        int finalAnswer = 0;

        // run for loop on each element in the array
        for (int i = 0; i < n; i++) {
            System.out.println(">>> i : " + i);

            // if it is the first row, do not try to copy the prior row
            if (i != 0) {
                copyPriorRowIntoCurrentRow(cumulativeElementsOfTheArray, i);
            }

            // now increment the current row of cumulativeElementsOfTheArray with the value from the array
            // A
            finalAnswer =
                    incrementCountBasedOnLetterAtCurrentPostition(i, A, cumulativeElementsOfTheArray);
        }
        // end of the for loop for each letter in the string S

        System.out.println("final answer = " + finalAnswer);

        return finalAnswer;
    }

    private int incrementCountBasedOnLetterAtCurrentPostition(
            int i, int[] A, int[][] cumulativeElementsOfTheArray) {
        int valueAtCurrentPosition = A[i];

        for (int j = 0; j <= i; j++) {
            // this is to preserve the cumulative sum values of the elements in the array A
            cumulativeElementsOfTheArray[i][j] =
                    cumulativeElementsOfTheArray[i][j] + valueAtCurrentPosition;

            int divisor = i - j + 1;
            float currentAverage = (float) cumulativeElementsOfTheArray[i][j] / divisor;

            // i == j is not a valid scenario because the slice has to have at lease two elements in it.
            boolean condition = currentAverage < global_minimum_average && i != j;

            if (condition) {
                global_minimum_average = currentAverage;
                indexWithMinimumAverage = j;
            }
        }

        // printing
        System.out.println("after setting the current value for the position");
        System.out.println(PrintUtils.print2DArray(cumulativeElementsOfTheArray));

        return indexWithMinimumAverage;
    }

    private void copyPriorRowIntoCurrentRow(int[][] cumulativeElementsOfTheArray, int i) {
        for (int eachPositionInTheRow = 0;
             eachPositionInTheRow < cumulativeElementsOfTheArray.length;
             eachPositionInTheRow++) {
            cumulativeElementsOfTheArray[i][eachPositionInTheRow] =
                    cumulativeElementsOfTheArray[i - 1][eachPositionInTheRow];
        }
    }
}

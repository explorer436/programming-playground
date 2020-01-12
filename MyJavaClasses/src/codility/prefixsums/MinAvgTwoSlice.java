package codility.prefixsums;

/**
 * 

A non-empty array A consisting of N integers is given. 
A pair of integers (P, Q), such that 0 ≤ P < Q < N, 
is called a slice of array A (notice that the slice contains at least two elements). 
The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] 
divided by the length of the slice. 
To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8

contains the following example slices:

        slice (1, 2), whose average is (2 + 2) / 2 = 2;
        slice (3, 4), whose average is (5 + 1) / 2 = 3;
        slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

The goal is to find the starting position of a slice whose average is minimal.

Write a function:

    class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, 
returns the starting position of the slice with the minimal average. 
If there is more than one slice with a minimal average, 
you should return the smallest starting position of such a slice.

For example, given array A such that:
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8

the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [2..100,000];
        each element of array A is an integer within the range [−10,000..10,000].


 */
public class MinAvgTwoSlice {

	

    public static void main(String[] args)
    {
        int[] A = new int[] { 4, 2, 2, 5, 1, 5, 8 };
        printStartingPositionOfMinimumSlice(A);
    }

    static float global_minimum_average = Integer.MAX_VALUE;

    static int indexWithMinimumAverage = 0;

    private static void printStartingPositionOfMinimumSlice(int[] A)
    {
        int n = A.length;
        // square array with size A.length + 1
        int[][] cumulativeElementsOfTheArray = new int[n][n];

        int finalAnswer = 0;

        // run for loop on each element in the array
        for (int i = 0; i < n; i++)
        {
            System.out.println(">>> i : " + i);

            // if it is the first row, do not try to copy the prior row
            if (i != 0)
            {
                copyPriorRowIntoCurrentRow(cumulativeElementsOfTheArray, i);
            }

            // now increment the current row of cumulativeElementsOfTheArray with the value from the array A
            finalAnswer = incrementCountBasedOnLetterAtCurrentPostition(i, A, cumulativeElementsOfTheArray);

        }
        // end of the for loop for each letter in the string S

        System.out.println("final answer = " + finalAnswer);
    }

    private static int incrementCountBasedOnLetterAtCurrentPostition(int i, int[] A,
        int[][] cumulativeElementsOfTheArray)
    {
        int valueAtCurrentPosition = A[i];

        for (int j = 0; j <= i; j++)
        {
            // this is to preserve the cumulative sum values of the elements in the array A
            cumulativeElementsOfTheArray[i][j] = cumulativeElementsOfTheArray[i][j] + valueAtCurrentPosition;

            int divisor = i - j + 1;
            float currentAverage = (float) cumulativeElementsOfTheArray[i][j] / divisor;

            // i == j is not a valid scenario because the slice has to have at lease two elements in it.
            boolean condition = currentAverage < global_minimum_average && i != j;

            if (condition)
            {
                global_minimum_average = currentAverage;
                indexWithMinimumAverage = j;
            }
        }

        // printing
        System.out.println("after setting the current value for the position");
        System.out.println(print2DArray(cumulativeElementsOfTheArray));

        return indexWithMinimumAverage;
    }

    private static void copyPriorRowIntoCurrentRow(int[][] cumulativeElementsOfTheArray, int i)
    {
        for (int eachPositionInTheRow = 0; eachPositionInTheRow < cumulativeElementsOfTheArray.length; eachPositionInTheRow++)
        {
            cumulativeElementsOfTheArray[i][eachPositionInTheRow] = cumulativeElementsOfTheArray[i
                - 1][eachPositionInTheRow];
        }
    }

    private static String print2DArray(int[][] array)
    {
        return java.util.Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
    }



}

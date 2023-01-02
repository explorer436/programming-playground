package com.my.company.matrix;

import java.util.Arrays;
import java.util.List;

/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 *
 * <p>For example, the square matrix is shown below:
 *
 * <p>1 2 3 4 5 6 9 8 9
 *
 * <p>The left-to-right diagonal = 1 + 5 + 9 = 15. The right to left diagonal = 3 + 5 + 9 = 17.
 * Their absolute difference is |15 - 17| = 2.
 *
 * <p>Function description
 *
 * <p>Complete the "diagonalDifference" function in the editor below. It must return an integer
 * representing the absolute diagonal difference.
 *
 * <p>diagonalDifference takes the following parameter: arr: an array of integers .
 *
 * <p>Input Format
 *
 * <p>The first line contains a single integer, n, the number of rows and columns in the matrix .
 * Each of the next n lines describes a row, arr[i], and consists of n space-separated integers
 * arr[i][j].
 *
 * <p>Constraints -100 <= arr[i][j] <= 100.
 *
 * <p>Output Format Print the absolute difference between the sums of the matrix's two diagonals as
 * a single integer.
 *
 * <p>Sample Input
 *
 * <p>3 11 2 4 4 5 6 10 8 -12
 *
 * <p>Sample Output
 *
 * <p>15
 *
 * <p>Explanation
 *
 * <p>The primary diagonal is:
 *
 * <p>11 5 -12
 *
 * <p>Sum across the primary diagonal: 11 + 5 - 12 = 4
 *
 * <p>The secondary diagonal is:
 *
 * <p>4 5 10
 *
 * <p>Sum across the secondary diagonal: 4 + 5 + 10 = 19 Difference: |4 - 19| = 15
 *
 * <p>Note: |x| is the absolute value of x-
 */
public class DiagonalDifference {

  public static void main(String[] args) {
    int[][] a = {{11, 2, 4}, {4, 5, 6}, {10, 8, -12}};

    DiagonalDifference classUnderTest = new DiagonalDifference();

    System.out.println(
        "absoluteDiffBetweenSumsOfDiagonals for arrary "
            + Arrays.deepToString(a)
            + " is "
            + classUnderTest.absoluteDiffBetweenSumsOfDiagonals(a));

    System.out.println(
        "sumOfElementsOfPrimaryDiagonal for array "
            + Arrays.deepToString(a)
            + " is "
            + classUnderTest.sumOfElementsOfPrimaryDiagonal(a));

    System.out.println(
        "sumOfElementsOfSecondaryDiagonal "
            + Arrays.deepToString(a)
            + " is "
            + classUnderTest.sumOfElementsOfSecondaryDiagonal(a));

    int alternateSolutionForA =
        Math.abs(
            classUnderTest.sumOfElementsOfPrimaryDiagonal(a)
                - classUnderTest.sumOfElementsOfSecondaryDiagonal(a));
    System.out.println(
        "alternateSolution for array " + Arrays.deepToString(a) + " is " + alternateSolutionForA);

    System.out.println();

    int[][] b = {{1, 2, 3}, {4, 5, 6}, {9, 8, 9}};

    System.out.println(
        "absoluteDiffBetweenSumsOfDiagonals for arrary "
            + Arrays.deepToString(b)
            + " is "
            + classUnderTest.absoluteDiffBetweenSumsOfDiagonals(b));

    System.out.println(
        "sumOfElementsOfPrimaryDiagonal for array "
            + Arrays.deepToString(b)
            + " is "
            + classUnderTest.sumOfElementsOfPrimaryDiagonal(b));

    System.out.println(
        "sumOfElementsOfSecondaryDiagonal for array "
            + Arrays.deepToString(b)
            + " is "
            + classUnderTest.sumOfElementsOfSecondaryDiagonal(b));

    int alternateSolutionForB =
        Math.abs(
            classUnderTest.sumOfElementsOfPrimaryDiagonal(b)
                - classUnderTest.sumOfElementsOfSecondaryDiagonal(b));
    System.out.println(
        "alternateSolution for array " + Arrays.deepToString(b) + " is " + alternateSolutionForB);
  }

  // if the input is a list of lists instead of a two dimensional array
  public static int diagonalDifference(List<List<Integer>> arr) {
    int result = 0;

    for (int i = 0; i < arr.size(); i++) {
      int differenceBetweenElementsOfPrimaryAndSecondaryDiagonals =
          arr.get(i).get(i) - arr.get(i).get((arr.size() - 1) - i);
      result = result + differenceBetweenElementsOfPrimaryAndSecondaryDiagonals;
    }

    return Math.abs(result);
  }

  private int absoluteDiffBetweenSumsOfDiagonals(int[][] array) {
    int result = 0;

    for (int i = 0; i < array.length; i++) {
      int differenceBetweenElementsOfPrimaryAndSecondaryDiagonals =
          array[i][i] - array[i][(array.length - 1) - i];
      result = result + differenceBetweenElementsOfPrimaryAndSecondaryDiagonals;
    }

    return Math.abs(result);
  }

  private int sumOfElementsOfPrimaryDiagonal(int[][] array) {
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      result = result + array[i][i];
    }
    return result;
  }

  private int sumOfElementsOfSecondaryDiagonal(int[][] array) {
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      result = result + array[i][(array.length - 1) - i];
    }
    return result;
  }

  // TODO
  // There are a lot of helpful methods for matrices here :
  // https://introcs.cs.princeton.edu/java/95linear/Matrix.java.html
  // Take a look at them.
}

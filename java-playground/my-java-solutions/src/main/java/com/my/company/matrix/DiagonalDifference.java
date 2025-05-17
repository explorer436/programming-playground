package com.my.company.matrix;

import java.util.Arrays;
import java.util.List;

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

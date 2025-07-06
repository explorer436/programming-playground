package com.my.company.matrix;

import java.util.List;

public class DiagonalDifference {

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

  public int absoluteDiffBetweenSumsOfDiagonals(int[][] array) {
    int result = 0;

    for (int i = 0; i < array.length; i++) {
      int differenceBetweenElementsOfPrimaryAndSecondaryDiagonals = array[i][i] - array[i][(array.length - 1) - i];
      result = result + differenceBetweenElementsOfPrimaryAndSecondaryDiagonals;
    }

    return Math.abs(result);
  }

  public int absoluteDiffBetweenSumsOfDiagonals_alternate(int[][] array) {
    return Math.abs(
            sumOfElementsOfLeftToRightDiagonal(array)
                    - sumOfElementsOfRightToLeftDiagonal(array));
  }

  public int sumOfElementsOfLeftToRightDiagonal(int[][] array) {
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      result = result + array[i][i];
    }
    return result;
  }

  public int sumOfElementsOfRightToLeftDiagonal(int[][] array) {
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      result = result + array[i][(array.length - 1) - i];
    }
    return result;
  }

}

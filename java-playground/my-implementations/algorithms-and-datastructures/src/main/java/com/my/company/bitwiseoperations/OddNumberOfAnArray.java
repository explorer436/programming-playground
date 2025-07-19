package com.my.company.bitwiseoperations;

public class OddNumberOfAnArray {

  /*
   * return the odd number
   */
  public int findOddNumberInTheArray(int[] A) {
    int result = 0;
    for (int x : A) {
      result = result ^ x;
    }
    return result;
  }

  /*
   * return true or false
   */
  public boolean isThereAnOddNumberInTheArray(int[] A) {
    int xorResult = 0;
    for (int x : A) {
      xorResult = xorResult ^ x;
    }

    return xorResult != 0;
  }
}

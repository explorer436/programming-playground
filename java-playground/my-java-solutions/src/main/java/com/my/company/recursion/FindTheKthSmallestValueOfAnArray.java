package com.my.company.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

public class FindTheKthSmallestValueOfAnArray {
  public static void main(String[] args) {

    Integer[] anArray = new Integer[] {4, 7, 3, 6, 8, 1, 9, 2};

    System.out.println(
        "0th smallest element of anArray : "
            + FindTheKthSmallestValueOfAnArray.kSmall(0, Arrays.asList(anArray)));
    // expected -1

    System.out.println(
        "1st smallest element of anArray : "
            + FindTheKthSmallestValueOfAnArray.kSmall(1, Arrays.asList(anArray)));
    // expected 1

    System.out.println(
        "3rd smallest element of anArray : "
            + FindTheKthSmallestValueOfAnArray.kSmall(3, Arrays.asList(anArray)));
    // expected 3

    System.out.println(
        "6th smallest element of anArray : "
            + FindTheKthSmallestValueOfAnArray.kSmall(6, Arrays.asList(anArray)));
    // expected 7

    System.out.println(
        "7th smallest element of anArray : "
            + FindTheKthSmallestValueOfAnArray.kSmall(7, Arrays.asList(anArray)));
    // expected 8

    System.out.println(
        "8th smallest element of anArray : "
            + FindTheKthSmallestValueOfAnArray.kSmall(8, Arrays.asList(anArray)));
    // expected 9

    System.out.println(
        "9th smallest element of anArray : "
            + FindTheKthSmallestValueOfAnArray.kSmall(9, Arrays.asList(anArray)));
    // expected -1
  }

  public static int kSmall(int k, List<Integer> anArray) {

    ArrayList<Integer> S1 = new ArrayList<Integer>();
    ArrayList<Integer> S2 = new ArrayList<Integer>();
    ArrayList<Integer> S3 = new ArrayList<Integer>();

    int size = anArray.size();

    if (k <= 0 || size <= 0) {
      return -1;
    } else {
      // when the size of the array is 1, we want pivot index = 0
      int pivotIndex = 0;
      if (size != 1) {
        pivotIndex = (size + 1) / 2;
      } else if (size == 1) {
        if (k == 1) {
          return anArray.get(0);
        } else {
          return -1;
        }
      }
      int pivot = anArray.get(pivotIndex);

      for (int i : anArray) {
        if (i < pivot) {
          S1.add(i);
        } else if (i == pivot) {
          S2.add(i);
        } else if (i > pivot) {
          S3.add(i);
        }
      }

      if (k <= S1.size()) {
        return kSmall(k, S1);
      } else if (k == S1.size() + 1) {
        // The element at the pivot index is the answer.
        return S2.get(0);
      }
      // There is a possibility that k could be greater than the size of S1 but S3 is empty.
      // In that scenario, the value from S2 would be the result.
      else if (k > S1.size() + 1 && (k - S1.size() - S2.size()) <= S3.size()) {
        return kSmall(k - S1.size() - S2.size(), S3);
      }
    }
    return -1;
  }
}

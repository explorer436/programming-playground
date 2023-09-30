package com.my.company.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays of integers, return a pair of indexes, the first index from the first array and
 * the second index from the second array. Two numbers from the two different arrays should add up
 * to a specific target.
 *
 * <p>Each input may have more than one solution.
 *
 * <p>Example: Given ar1 = [1, 2, 3], ar1 = [5, 4, 5, 6], target = 7, Because ar1[1] + ar2[0] = 2 +
 * 5 = 7, return [1, 0]. Because ar1[1] + ar2[2] = 2 + 5 = 7, return [1, 2].
 */
public class TwoSumFromTwoDifferentArrays {
  /**
   * The elements of the input arrays are not sorted. If they are sorted, we can start at the middle
   * of the array and move to the left or right depending upon whether the sum of them is lower or
   * higher than the target number.
   *
   * <p>Can we try sorting the matrices first and then implementing it as an alternative to the
   * brute force solution?
   */
  public static void main(String[] args) {
    int[] ar1 = new int[] {1, 2, 3};
    int[] ar2 = new int[] {5, 4, 5, 6};

    // Expected output : [0, 3]
    System.out.println(
        "When input is "
            + Arrays.toString(ar1)
            + " and "
            + Arrays.toString(ar2)
            + " target is 7, TrueOrFalse output is "
            + new TwoSumFromTwoDifferentArrays()
                .twoSumAcrossTwoDifferentArrays_TrueOrFalse(ar1, ar2, 7));

    // Expected output : [0, 3]
    System.out.println(
        "When input is "
            + Arrays.toString(ar1)
            + " and "
            + Arrays.toString(ar2)
            + " target is 7, output is "
            + Arrays.toString(
                new TwoSumFromTwoDifferentArrays()
                    .twoSumAcrossTwoDifferentArrays_firstMatch(ar1, ar2, 7)));

    // Expected output : [(0, 3), (1, 2), (2, 1)]
    System.out.println(
        "When input is "
            + Arrays.toString(ar1)
            + " and "
            + Arrays.toString(ar2)
            + " target is 7, output is "
            + Arrays.toString(
                (new TwoSumFromTwoDifferentArrays()
                        .twoSumAcrossTwoDifferentArrays_allMatches_WithoutDuplicates(ar1, ar2, 7))
                    .toArray()));

    // Expected output : [(0, 3), (1, 0), (1, 2), (2, 1)]
    System.out.println(
        "When input is "
            + Arrays.toString(ar1)
            + " and "
            + Arrays.toString(ar2)
            + " target is 7, output is "
            + Arrays.toString(
                (new TwoSumFromTwoDifferentArrays()
                        .twoSumAcrossTwoDifferentArrays_allMatches_IncludingDuplicates(ar1, ar2, 7))
                    .toArray()));

    System.out.println();

    int[] ar3 = new int[] {-1, -2, -3};
    int[] ar4 = new int[] {-5, -4, -5, -6, 1};

    // Expected output : [0, 3]
    System.out.println(
        "When input is "
            + Arrays.toString(ar3)
            + " and "
            + Arrays.toString(ar4)
            + " target is -7, TrueOrFalse output is "
            + new TwoSumFromTwoDifferentArrays()
                .twoSumAcrossTwoDifferentArrays_TrueOrFalse(ar3, ar4, -7));

    // Expected output : [0, 3]
    System.out.println(
        "When input is "
            + Arrays.toString(ar3)
            + " and "
            + Arrays.toString(ar4)
            + " target is -7, output is "
            + Arrays.toString(
                new TwoSumFromTwoDifferentArrays()
                    .twoSumAcrossTwoDifferentArrays_firstMatch(ar3, ar4, -7)));

    // Expected output : [(0, 3), (1, 2), (2, 1)]
    System.out.println(
        "When input is "
            + Arrays.toString(ar3)
            + " and "
            + Arrays.toString(ar4)
            + " target is -7, output is "
            + Arrays.toString(
                (new TwoSumFromTwoDifferentArrays()
                        .twoSumAcrossTwoDifferentArrays_allMatches_WithoutDuplicates(ar3, ar4, -7))
                    .toArray()));

    // Expected output : [(0, 3), (1, 0), (1, 2), (2, 1)]
    System.out.println(
        "When input is "
            + Arrays.toString(ar3)
            + " and "
            + Arrays.toString(ar4)
            + " target is -7, output is "
            + Arrays.toString(
                (new TwoSumFromTwoDifferentArrays()
                        .twoSumAcrossTwoDifferentArrays_allMatches_IncludingDuplicates(
                            ar3, ar4, -7))
                    .toArray()));

    System.out.println();

    // Expected output : [0, 3]
    System.out.println(
        "When input is "
            + Arrays.toString(ar3)
            + " and "
            + Arrays.toString(ar4)
            + " target is 0, TrueOrFalse output is "
            + new TwoSumFromTwoDifferentArrays()
                .twoSumAcrossTwoDifferentArrays_TrueOrFalse(ar3, ar4, 0));

    // Expected output : [0, 3]
    System.out.println(
        "When input is "
            + Arrays.toString(ar3)
            + " and "
            + Arrays.toString(ar4)
            + " target is 0, output is "
            + Arrays.toString(
                new TwoSumFromTwoDifferentArrays()
                    .twoSumAcrossTwoDifferentArrays_firstMatch(ar3, ar4, 0)));

    // Expected output : [(0, 3), (1, 2), (2, 1)]
    System.out.println(
        "When input is "
            + Arrays.toString(ar3)
            + " and "
            + Arrays.toString(ar4)
            + " target is 0, output is "
            + Arrays.toString(
                (new TwoSumFromTwoDifferentArrays()
                        .twoSumAcrossTwoDifferentArrays_allMatches_WithoutDuplicates(ar3, ar4, 0))
                    .toArray()));

    // Expected output : [(0, 3), (1, 0), (1, 2), (2, 1)]
    System.out.println(
        "When input is "
            + Arrays.toString(ar3)
            + " and "
            + Arrays.toString(ar4)
            + " target is 0, output is "
            + Arrays.toString(
                (new TwoSumFromTwoDifferentArrays()
                        .twoSumAcrossTwoDifferentArrays_allMatches_IncludingDuplicates(ar3, ar4, 0))
                    .toArray()));
  }

  public boolean twoSumAcrossTwoDifferentArrays_TrueOrFalse(int[] ar1, int[] ar2, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = ar2.length - 1; i >= 0; i--) {
      map.put(ar2[i], i);
    }

    for (int i = 0; i < ar1.length; i++) {
      int complement = target - ar1[i];

      if (map.containsKey(complement)) {
        return true;
      }
    }
    return false;
  }

  public int[] twoSumAcrossTwoDifferentArrays_firstMatch(int[] ar1, int[] ar2, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = ar2.length - 1; i >= 0; i--) {
      map.put(ar2[i], i);
    }

    for (int i = 0; i < ar1.length; i++) {
      int complement = target - ar1[i];

      if (map.containsKey(complement)) {
        return new int[] {i, map.get(complement)};
      }
    }
    return null;
  }

  public List<IndexPair> twoSumAcrossTwoDifferentArrays_allMatches_WithoutDuplicates(
      int[] ar1, int[] ar2, int target) {
    List<IndexPair> result = new ArrayList<IndexPair>();

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < ar2.length; i++) {
      map.put(ar2[i], i);
    }

    for (int i = 0; i < ar1.length; i++) {
      int complement = target - ar1[i];

      if (map.containsKey(complement)) {
        result.add(new IndexPair(i, map.get(complement)));
      }
    }
    return result;
  }

  public List<IndexPair> twoSumAcrossTwoDifferentArrays_allMatches_IncludingDuplicates(
      int[] ar1, int[] ar2, int target) {
    List<IndexPair> result = new ArrayList<IndexPair>();

    Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

    for (int i = 0; i < ar2.length; i++) {
      if (map.containsKey(ar2[i])) {
        ArrayList<Integer> a = map.get(ar2[i]);
        a.add(i);
        map.put(ar2[i], a);
      } else {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(i);
        map.put(ar2[i], a);
      }
    }

    for (int i = 0; i < ar1.length; i++) {
      int complement = target - ar1[i];

      if (map.containsKey(complement)) {
        ArrayList<Integer> a = map.get(complement);
        for (int index : a) {
          result.add(new IndexPair(i, index));
        }
      }
    }

    return result;
  }

  private static class IndexPair {
    public IndexPair(int a, int b) {
      super();
      this.a = a;
      this.b = b;
    }

    private int a;

    private int b;

    @Override
    public String toString() {
      return "(" + a + ", " + b + ")";
    }
  }
}

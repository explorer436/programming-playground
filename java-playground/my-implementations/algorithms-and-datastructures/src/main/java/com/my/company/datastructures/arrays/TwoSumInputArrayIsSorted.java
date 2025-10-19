package com.my.company.datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumInputArrayIsSorted {

  public static void main(String[] args) {

    int[] nums;

    // num : [2, 7, 11, 15], target : 9, Expected : [1, 2]
    nums = new int[] {2, 7, 11, 15};
    System.out.println(
        "When input is "
            + Arrays.toString(nums)
            + " and target is 9, output is "
            + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, 9)));

    System.out.println();

    // num : [2, 3, 4], target : 6, Expected : [1,3]
    nums = new int[] {2, 3, 4};
    System.out.println(
        "When input is "
            + Arrays.toString(nums)
            + " and target is 9, output is "
            + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, 9)));
    System.out.println(
        "When input is "
            + Arrays.toString(nums)
            + " and target is 6, output is "
            + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, 6)));

    System.out.println();

    System.out.println();

    // num : [-1,-2,-3,-4,-5], target : -8, Expected : [2,4]
    nums = new int[] {-1, -2, -3, -4, -5};
    System.out.println(
        "When input is "
            + Arrays.toString(nums)
            + " and target is -3, output is "
            + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, -3)));
    System.out.println(
        "When input is "
            + Arrays.toString(nums)
            + " and target is -8, output is "
            + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, -8)));

    System.out.println();

    // num : [-2, -1, 0, 1, 2], target : -1, Expected : [1,2]
    nums = new int[] {-2, -1, 0, 1, 2};
    System.out.println(
        "When input is "
            + Arrays.toString(nums)
            + " and target is -1, output is "
            + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, -1)));
  }

  /**
   * REMEMBER - always consider "0" when writing edge cases with addition, subtraction,
   * multiplication and division.
   */

  /**
   * Question : Does the fact that the input array is sorted matter at all?
   *
   * <p>The same solution from TwoSum.java also works for this. In other words, the method in
   * TwoSum.java works on both sorted and unsorted arrays.
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] {map.get(complement) + 1, i + 1};
      } else {
        map.put(nums[i], i);
      }
    }

    return null;
  }
}

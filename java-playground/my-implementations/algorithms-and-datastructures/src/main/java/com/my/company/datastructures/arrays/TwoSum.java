package com.my.company.datastructures.arrays;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.HashMap;
import java.util.Map;
public class TwoSum {

  public ImmutablePair twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (map.containsKey(complement) && map.get(complement) != i) {
        return new ImmutablePair(map.get(complement), i);
      } else {
        map.put(nums[i], i);
      }
    }
    return null;
  }

  /**
   * The difference between twoSum and twoSum2 is that, with twoSum2, we are running through all the
   * elements of the input array all the time. And that may not be necessary.
   */
  public int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] {i, map.get(complement)};
      }
    }

    return null;
  }
}

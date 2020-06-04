package datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.


 *
 */
public class TwoSumInputArrayIsSorted {

	public static void main(String[] args) {
		
		int[] nums;

		// num : [2, 7, 11, 15], target : 9, Expected : [1, 2]
        nums = new int[] { 2, 7, 11, 15 };
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is 9, output is " + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, 9)));
        
        System.out.println();

        // num : [2, 3, 4], target : 6, Expected : [1,3]
        nums = new int[] { 2, 3, 4 };
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is 9, output is " + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, 9)));
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is 6, output is " + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, 6)));
        
        System.out.println();
        
        System.out.println();
        
        // num : [-1,-2,-3,-4,-5], target : -8, Expected : [2,4]
        nums = new int[] { -1,-2,-3,-4,-5 };
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is -3, output is " + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, -3)));
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is -8, output is " + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, -8)));
        
        System.out.println();
        
        // num : [-2, -1, 0, 1, 2], target : -1, Expected : [1,2]
        nums = new int[] { -2, -1, 0, 1, 2 };
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is -1, output is " + Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(nums, -1)));

	}
	
	/**
	 * REMEMBER - always consider "0" when writing edge cases with addition, subtraction, multiplication and division.
	 */
	
	/**
	 * Question : Does the fact that the input array is sorted matter at all?
	 * 
	 * The same solution from TwoSum.java also works for this.
	 * In other words, the method in TwoSum.java works on both sorted and unsorted arrays. 
	 */
	
	public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++)
        {
        	int complement = target - nums[i];
        	
        	if (map.containsKey(complement) && map.get(complement) != i)
            {
                return new int[] { map.get(complement) + 1, i +1 };
            }
            else
            {
            	map.put(nums[i], i);
            }
        }
        
        return null;
    }

}

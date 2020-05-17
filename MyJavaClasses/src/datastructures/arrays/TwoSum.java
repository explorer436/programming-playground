package datastructures.arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum
{

    public static void main(String[] args)
    {
    	// num : [3, 2, 4], target : 6, Expected : [0, 1]
        int[] nums = new int[] { 2, 7, 11, 15 };
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is 9, output is " + Arrays.toString(new TwoSum().twoSum(nums, 9)));
        
        System.out.println();

        // num : [3, 2, 4], target : 6, Expected : [1,2]
        nums = new int[] { 3, 2, 4 };
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is 9, output is " + Arrays.toString(new TwoSum().twoSum(nums, 9)));
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is 6, output is " + Arrays.toString(new TwoSum().twoSum(nums, 6)));
        
        System.out.println();

        // num : [0, 4, 3, 0], target : 0, Expected : [0,3]
        nums = new int[] { 0, 4, 3, 0 };
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is 0, output is " + Arrays.toString(new TwoSum().twoSum(nums, 0)));
        
        System.out.println();
        
        // num : [-1,-2,-3,-4,-5], target : -8, Expected : [2,4]
        nums = new int[] { -1, -2, -3, -4, -5 };
        System.out.println("When input is " + Arrays.toString(nums)  + " and target is -8, output is " + Arrays.toString(new TwoSum().twoSum(nums, -8)));
    }
    
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++)
        {
        	int complement = target - nums[i];
        	
        	if (map.containsKey(complement) && map.get(complement) != i)
            {
                return new int[] { map.get(complement), i };
            }
            else
            {
            	map.put(nums[i], i);
            }
        }
        return null;
    }

    /**
     * The difference between twoSum and twoSum2 is that, with twoSum2, we are running through all the elements of the input array all the time.
     * And that may not be necessary.
     * 
     */
    public int[] twoSum2(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i)
            {
                return new int[] { i, map.get(complement) };
            }
        }
        
        return null;
    }

}

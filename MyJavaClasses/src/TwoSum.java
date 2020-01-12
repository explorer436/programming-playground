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
        int[] nums = new int[] { 2, 7, 11, 15 };

        // num : [2, 7, 11, 15], target : 9, Expected : [0,1]
        Arrays.stream(new TwoSum().twoSum(nums, 9)).forEach(e -> System.out.print(e + " "));
        System.out.println("-------");

        // num : [3, 2, 4], target : 6, Expected : [1,2]
        nums = new int[] { 3, 2, 4 };
        Arrays.stream(new TwoSum().twoSum(nums, 6)).forEach(e -> System.out.print(e + " "));
        System.out.println("-------");

        // num : [0, 4, 3, 0], target : 0, Expected : [0,3]
        nums = new int[] { 0, 4, 3, 0 };
        Arrays.stream(new TwoSum().twoSum(nums, 0)).forEach(e -> System.out.print(e + " "));
        System.out.println("-------");

        // num : [-1,-2,-3,-4,-5], target : -8, Expected : [2,4]
        nums = new int[] { -1, -2, -3, -4, -5 };
        Arrays.stream(new TwoSum().twoSum(nums, -8)).forEach(e -> System.out.print(e + " "));
        System.out.println("-------");
    }

    // Runtime: 253 ms, faster than 5.07% of Java online submissions for Two Sum.
    // Memory Usage: 38.2 MB, less than 90.03% of Java online submissions for Two Sum.
    // public int[] twoSum(int[] nums, int target)
    // {
    // int result[] = new int[2];

    // for (int j = 0; j < nums.length; j++)
    // {
    // System.out.println("j : " + j);
    // System.out.println("nums[j] : " + nums[j]);

    // System.out.println("inside the if loop");
    // int remaining = target - nums[j];
    // System.out.println("remaining : " + remaining);
    // int indexOfRemaining = IntStream.range(0, nums.length)
    // .filter(i -> remaining == nums[i])
    // .findFirst()
    // .orElse(-1);
    // System.out.println("indexOfRemaining : " + indexOfRemaining);
    // if (-1 != indexOfRemaining && j != indexOfRemaining)
    // {
    // result[0] = j;
    // result[1] = indexOfRemaining;
    // break;
    // }
    // }

    // return result;

    // }

    public int[] twoSum(int[] nums, int target)
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
        // throw new IllegalArgumentException("No two sum solution");
        return null;
    }

}

package com.my.company.codility.countingelements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
Level : Respectable

Find the smallest positive integer that does not occur in a given sequence.


	Write a function:

    class Solution { public int solution(int[] A); }

	that, given an array A of N integers, returns the smallest positive integer 
	(greater than 0) that does not occur in A.
	
	For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
	
	Given A = [1, 2, 3], the function should return 4.
	
	Given A = [−1, −3], the function should return 1.
	
	Write an efficient algorithm for the following assumptions:
	
	        N is an integer within the range [1..100,000];
	        each element of array A is an integer within the range [−1,000,000..1,000,000].
	        
	        ---------------------------------------------------------------------------

	Find the smallest positive number missing from an unsorted array | Set 1
	
	You are given an unsorted array with both positive and negative elements. 
	You have to find the smallest positive number missing from the array in O(n) time using constant extra space. 
	You can modify the original array.
	
	Examples
	
	 Input:  {2, 3, 7, 6, 8, -1, -10, 15}
	 Output: 1
	
	 Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
	 Output: 4
	
	 Input: {1, 1, 0, -1, -2}
	 Output: 2 



 */
public class SmallestPositiveNumberMissingFromArray
{

	public static void main(String[] args)
	{
		  int[] A;
		  
		  A = new int[] { -1, -3 };
		  solution(A);
		  
		  A = new int[] { 3 };
		  solution(A);
		  
		  A = new int[] { 2, 2, 2, 2, 2 };
		  solution(A);
		  
		  A = new int[] {};
		  solution(A);
		  
		  int[] A1 = { 1, 3, 6, 4, 1, 2 };
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingMap(A1)); // 5

			int[] A2 = { 1, 2, 3 };
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingMap(A2)); // 4

			int[] A3 = { -1, -3 };
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingMap(A3)); // 1

			int[] A4 = { 3 };
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingMap(A4)); // 1

			int[] A5 = { 2, 2, 2, 2, 2 };
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingMap(A5)); // 1

			int[] A6 = {};
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingMap(A6)); // 1

			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingMap(null)); // 1
			
			System.out.println();
			
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingSet(A1)); // 5
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingSet(A2)); // 4
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingSet(A3)); // 1
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingSet(A4)); // 1
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingSet(A5)); // 1
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingSet(A6)); // 1
			System.out.println("result : " + getFirstMissingPositiveInteger_ImplementedUsingSet(null)); // 1
			
			System.out.println();
		 
	}
	
	// Approach 1 : start a for loop with 1 and search the array for each number. O(n^2) in worst case.
	
	// Approach 2 : Sort the array first - O(nLogn) . Then, do a linear scan - O(n) - overall, O(nLogn + n) ~ O(nLogn).
	
	// Approach 3 : Build a hashtable with the positive numbers in the array as keys.
	// 				This may take O(n) time on average, but it requires O(n) extra space. 
	
	// Approach 4 : linear time and constant space solution (You can modify the input array in-place.)
	// 				First : move all the negative elements of the array to the left of it. See MoveNegativeElementsToTheLeft.java
	//				Second : drop the negative numbers from the array. See DropFirstNElementsOfAnArray.java
	//				Third : at this point, all the elements left in the array are positive numbers.
	// 						start a for loop with 1 and match the index to the number. If there is a no-match, it means that index is not in the array.
	// 				Note : we would have to handle 0 in this case carefully.
	
	public static void solution(int[] A)
	{
		
	}
	
	/**
	 * This is not a constant space solution.
	 * 
	 * This approach may take O(n) time on average, but it requires O(n) extra space.
	 */
	public static int getFirstMissingPositiveInteger_ImplementedUsingMap(int[] A)
	{

		if (null == A || 0 == A.length)
		{
			return 1;
		}
		else
		{
			Integer result = null;
			Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
			
			// loop through them starting from index = 0.
			for (int i = 0; i < A.length; i++)
			{
				mp.put(A[i], i);
			}

			// loop through numbers starting from 1 and check the map for each number.
			for (int i = 1; i <= A.length; i++)
			{
				if (!mp.containsKey(i))
				{
					return i;
				}
			}
			
			if (null == result)
			{
				// all elements are in the array.
				return A.length + 1;
			}
		}
		return 0;
	}

	/**
	 * This is not a constant space solution.
	 * 
	 * This approach may take O(n) time on average, but it requires O(n) extra space.
	 */
	public static int getFirstMissingPositiveInteger_ImplementedUsingSet(int[] A)
	{
		int result = 1;

		if (null == A || 0 == A.length)
		{
			// do nothing
		}
		else
		{
			// remove duplicates.
			// When memory is a limitation, this solution will not work.
			
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < A.length; i++)
			{
				set.add(A[i]);
			}

			// loop through them starting from the number 1.
			for (int i = 0; i <= A.length; i++)
			{
				if (!set.contains((i + 1)))
				{
					result = i + 1;
					break;
				}
			}
		}
		return result;
	}
	
	
}

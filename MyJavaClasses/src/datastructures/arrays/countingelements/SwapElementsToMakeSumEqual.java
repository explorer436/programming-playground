package datastructures.arrays.countingelements;

import java.util.Arrays;
import collections.StreamReduce;

/**
 * 
Problem: You are given an integer m (1 <= m <= 1 000 000) and two non-empty, zero-indexed
arrays A and B of n integers, a 0 , a 1 , . . . , a n−1 and b 0 , b 1 , . . . , b n−1 respectively (0 � a i , b i � m).
The goal is to check whether there is a swap operation which can be performed on these
arrays in such a way that the sum of elements in array A equals the sum of elements in
array B after the swap. By swap operation we mean picking one element from array A and
one element from array B and exchanging them.

 */
public class SwapElementsToMakeSumEqual
{

	public static void main(String[] args)
	{
		int[] A = { 1, 8, 9, 10, 13 };
		int[] B = { 3, 5, 7, 11, 17 };
		
		System.out.println("result : " + bruteForceSolution_slow(A, B, 5));
		
		System.out.println("result : " + solution_fast(A, B, 5));
	}

	// O(n power 2)
	public static boolean bruteForceSolution_slow(int[] A, int[] B, int m)
	{
		int sum_a = StreamReduce.getSumOfAllElementsOfArray(A);
				
		int sum_b = StreamReduce.getSumOfAllElementsOfArray(B);
		
		// aIndex = bIndex - but they don't have to be of equal length.
		for (int aIndex = 0; aIndex < A.length; aIndex++)
		{
			for (int bIndex = 0; bIndex < A.length; bIndex++)
			{
				int difference = B[bIndex] - A[aIndex];
				
				if (sum_a + difference == sum_b - difference)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * The best approach is to count the elements of array A and calculate
		the difference d between the sums of the elements of array A and B.
		For every element of array B, we assume that we will swap it with some element from
		array A. The difference d tells us the value from array A that we are interested in swapping,
		because only one value will cause the two totals to be equal. The occurrence of this value can
		be found in constant time from the array used for counting.

	 */
	// O(n + m)
	public static boolean solution_fast(int[] A, int[] B, int m)
	{
		int sum_a = StreamReduce.getSumOfAllElementsOfArray(A);
		
		int sum_b = StreamReduce.getSumOfAllElementsOfArray(B);
		
		int difference = sum_b - sum_a;
		
		for (int bIndex = 0; bIndex < A.length; bIndex++)
		{
			int counterPart = B[bIndex] - difference;
			
			int[] arrACount = countingArrayElements(A);
			// System.out.println("countingArrayElements : " + Arrays.toString(abc));
			// [1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1]
			
			if (0 <= counterPart && counterPart <= m && 0 != arrACount[counterPart]);
			{
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * If we know that all the elements are in the set {0, 1, . . . , m}, then the array used for counting should be of size m + 1.
	 * 
	 * In our scenario, A = { 1, 8, 9, 10, 13 }. So, the length of count[] should be at least 13.
	 */
	private static int[] countingArrayElements(int[] A)
	{
		int minElement = StreamReduce.getMinElementInIntArray(A);
        int maxElement = StreamReduce.getMaxElementInIntArray(A);
		
		int[] count = new int[maxElement - minElement + 1];
		
		// System.out.println(Arrays.toString(count));
		// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		
		// System.out.println("count length : " + count.length);
		// 13
		
		for (int aIndex = 0; aIndex < A.length; aIndex++)
		{
			count[A[aIndex] - 1] = count[A[aIndex] - 1] + 1; 
		}
		
		return count;
	}
}

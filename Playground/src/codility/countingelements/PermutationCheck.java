package codility.countingelements;

/**
 * 
Level : Painless

Check whether array A is a permutation.


A non-empty zero-indexed array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), 
beyond input storage (not counting the storage required for input arguments).*/

import java.util.Arrays;

public class PermutationCheck
{

	public static void main(String[] args) throws Exception
	{
		int[] A = { 4, 1, 3, 2 };
		
		int result;
		
		result = solution(A);
		if (result != 1)
		{
			throw new Exception("wrong answer - expected " + 1 + " but received " + result);
		}

		int[] A2 = { 4, 1, 3 };
		result = solution(A2);
		if (result != 0)
		{
			throw new Exception("wrong answer - expected " + 0 + " but received " + result);
		}

		int[] A3 = { 1 };
		result = solution(A3);
		if (result != 1)
		{
			throw new Exception("wrong answer - expected " + 1 + " but received " + result);
		}

		int[] A4 = { 2 };
		result = solution(A4);
		if (result != 0)
		{
			throw new Exception("wrong answer - expected " + 0 + " but received " + result);
		}

		int[] A5 = {};
		result = solution(A5);
		if (result != 0)
		{
			throw new Exception("wrong answer - expected " + 0 + " but received " + result);
		}
		
		System.out.println("done");
	}

	public static int solution(int[] A)
	{
		int result = 0;
		if (A.length > 0)
		{
			Arrays.sort(A);
			
			boolean allNumbersInThePermutationExist = false;
			
			// check for the existence of each number starting from 1 in the sorted array.
			for (int i = 0; i < A.length; i++)
			{
				if ((i + 1) == A[i])
				{
					allNumbersInThePermutationExist = true;
				}
				else
				{
					allNumbersInThePermutationExist = false;
					break;
				}
			}

			if (allNumbersInThePermutationExist)
			{
				result = 1;
			}
		}
		return result;
	}

}

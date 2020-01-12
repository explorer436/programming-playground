package codility.countingelements;

/*A non-empty zero-indexed array A consisting of N integers is given.

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
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).*/

import java.util.Arrays;

public class PermCheck
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] A = { 4, 1, 3, 2 };
		System.out.println("result : " + solution(A));

		int[] A2 = { 4, 1, 3 };
		System.out.println("result : " + solution(A2));

		int[] A3 = { 1 };
		System.out.println("result : " + solution(A3));

		int[] A4 = { 2 };
		System.out.println("result : " + solution(A4));

		int[] A5 = {};
		System.out.println("result : " + solution(A5));
	}

	public static int solution(int[] A)
	{
		int result = 0;
		if (A.length > 0)
		{
			Arrays.sort(A);
			boolean found = false;
			for (int i = 0; i < A.length; i++)
			{
				/*
				 * System.out.println("i : " + i); System.out.println("A[i] : " + A[i]);
				 */
				if ((i + 1) == A[i])
				{
					found = true;
				}
				else
				{
					found = false;
					break;
				}
			}

			if (found)
			{
				result = 1;
			}
		}
		return result;
	}

}

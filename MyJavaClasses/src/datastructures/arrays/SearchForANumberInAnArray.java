package datastructures.arrays;

/**
 * 

Write a function:

    class Solution { public int solution(int[] A, int K); }

that, given an array A of N integers, returns the smallest positive integer 
(greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].




 */
public class SearchForANumberInAnArray
{

	public static void main(String[] args)
	{
		int[] A = { 5, 1, 2, 3, 4, 5, 1 };
		System.out.println("result : " + solution(A, 1));

		int[] A2 = { 3, 2, 3, 1, 3 };
		System.out.println("result : " + solution(A2, 5));
		System.out.println("result : " + solution(A2, 4));
		System.out.println("result : " + solution(A2, 3));

		/*
		 * int[] A3 = {-1, -3}; System.out.println("result : " + solution(A3));
		 * 
		 * int[] A4 = {3}; System.out.println("result : " + solution(A4));
		 * 
		 * int[] A5 = {2, 2, 2, 2, 2}; System.out.println("result : " + solution(A5));
		 * 
		 * int[] A6 = {}; System.out.println("result : " + solution(A6));
		 */

		System.out.println("result : " + solution(null, 4));
	}

	
	/**
	 * Why does it have to be this complicated?
	 *  
	 * Can't we just run a for loop on the array,
	 * and return YES or NO based on whether or not a match is found?
	 */
	public static String solution(int[] arr, int numberWeAreLookingFor)
	{
		if (null != arr)
		{
			int arrayLength = arr.length;

			// 1st comparison
			if (arr[arrayLength - 1] == numberWeAreLookingFor)
			{
				return "YES";
			}

			int backup = arr[arrayLength - 1];
			arr[arrayLength - 1] = numberWeAreLookingFor;

			// no termination condition and thus
			// no comparison
			for (int index = 0;; index++)
			{
				// this would be executed at-most n times
				// and therefore at-most n comparisons
				if (arr[index] == numberWeAreLookingFor)
				{
					// replace arr[n-1] with its actual element
					// as in original 'arr[]'
					arr[arrayLength - 1] = backup;

					// if 'numberWeAreLookingFor' is found before the '(n-1)th'
					// index, then it is present in the array
					
					// final comparison
					if (index < arrayLength - 1)
					{
						return "YES";
					}	

					// else "numberWeAreLookingFor" is not present in the array
					return "NO";
				}
			}
		}
		else
		{
			return "NO";
		}

	}
}

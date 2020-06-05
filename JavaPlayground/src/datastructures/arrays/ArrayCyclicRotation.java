package datastructures.arrays;

import java.util.Arrays;

/*
* 

An array A consisting of N integers is given. 
Rotation of the array means that each element is shifted right by one index, 
and the last element of the array is moved to the first place. 
For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] 
(elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, 
each element of A will be shifted to the right K times.

Write a function:

    class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, 
returns the array A rotated K times.

For example, given
    A = [3, 8, 9, 7, 6]
    K = 3

the function should return [9, 7, 6, 3, 8]. Three rotations were made:
    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]

For another example, given
    A = [0, 0, 0]
    K = 1

the function should return [0, 0, 0]

Given
    A = [1, 2, 3, 4]
    K = 4

the function should return [1, 2, 3, 4]

Assume that:

        N and K are integers within the range [0..100];
        each element of array A is an integer within the range [−1,000..1,000].

In your solution, focus on correctness. 
The performance of your solution will not be the focus of the assessment.

*/
public class ArrayCyclicRotation
{
	public static void main(String[] args)
	{

		System.out.println("result for input " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " and K = 2 is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 2)));
		
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " and K = 6 is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 6)));
				
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " and K = 10 is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 10)));
				
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { }) + " and K = 2 is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] {}, 2)));
				
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { }) + " and K = -2 is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] {}, -2)));
				
		System.out.println();
		
		System.out.println("--------");
		
		/**
		 * Take a look at DropFirstNElementsOfAnArray.skipFirstKElementsOfArray() for an example to skip x number of elements from the beginning of an array.
		 */
		System.out.println("result for skipping " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " and K = 2 is "); DropFirstNElementsOfAnArray.skipFirstKElementsOfArray(new int[] { 1, 5, 2, 1, 4, 0 }, 2);
		
		System.out.println("--------");
		
		System.out.println("result for input " + Arrays.toString(new int[] { 1, 2, 3 }) + " and K = 2 is " + Arrays.toString(
				ArrayCyclicRotation.circularArrayRotation(new int[] { 1, 2, 3 }, 2, new int[] { 0, 1, 2 })));
		
		System.out.println("result for input " + Arrays.toString(new int[] { }) + " and K = 2 is " + Arrays.toString(
				ArrayCyclicRotation.circularArrayRotation(new int[] {}, 2, new int[] {})));
		
	}

	/*
	 * This can also be written using System.arraycopy( result, 0, A, 0, A.length ) or Arrays.copyOfRange().
	 * But the disadvantage of that approach is that it creates an extra array - not good when space complexity is considered. 
	 * 
	 * TODO implement it using the two methods mentioned above.
	 */
	public static int[] solution(int[] A, int K)
	{
		// System.out.println("A.length : " + A.length + " and K : " + K);

		if (0 == A.length || K == A.length)
		{
			return A;
		}

		if (K > A.length)
		{
			K = K % A.length;
		}

		int[] result = new int[A.length];

		for (int i = 0; i < K; i++)
		{
			result[i] = A[A.length - K + i];
		}

		int j = 0;
		for (int i = K; i < A.length; i++)
		{
			result[i] = A[j];
			j++;
		}

		return result;
	}
	
	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		
		int[] rotatedArray = solution(a, k);
		System.out.println("rotatedArray : " + Arrays.toString(rotatedArray));
		System.out.println("queries.length : " + queries.length);
		
		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++)
		{
			System.out.println("i : " + i);
			System.out.println("queries[i] : " + queries[i]);
			result[i] = rotatedArray[queries[i]];
			System.out.println("result : " + Arrays.toString(result));
		}
		
		return result;
		
    }
	
	

}

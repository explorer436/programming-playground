package codility.arrays;

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
		ArrayCyclicRotation classUnderTest = new ArrayCyclicRotation();

		System.out.println("result for input " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " and K = 2 is " + Arrays.toString(classUnderTest.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 2)));
		
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " and K = 6 is " + Arrays.toString(classUnderTest.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 6)));
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " and K = 10 is " + Arrays.toString(classUnderTest.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 10)));
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { }) + " and K = 2 is " + Arrays.toString(classUnderTest.solution(new int[] { }, 2)));
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { }) + " and K = -2 is " + Arrays.toString(classUnderTest.solution(new int[] { }, -2)));
		System.out.println();
	}

	/*
	 * This can be written more elegantly using System.arraycopy( result, 0, A, 0, A.length ) or Arrays.copyOfRange()
	 * TODO implement it using the two methods mentioned above.
	 */
	public int[] solution(int[] A, int K)
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

}

package codility.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utility.PrintUtils;

/**
* 

Level : Painless

Rotate an array to the right by a given number of steps.


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

		System.out.println("result of rotating  " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " 2 times is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 2)));
		
		System.out.println("result of rotating  " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " 6 times is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 6)));
		
		System.out.println("result of rotating  " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " 10 times is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 10)));
		
		System.out.println("result of rotating  " + Arrays.toString(new int[] { }) + " 2 times is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] {}, 2)));
		
		System.out.println("result of rotating  " + Arrays.toString(new int[] { }) + " -2 times is " + Arrays.toString(
				ArrayCyclicRotation.solution(new int[] {}, -2)));
		
		System.out.println("--------");
		
		System.out.println("result of rotating  " + Arrays.toString(new int[] { 1, 2, 3 }) + " 2 times is " + Arrays.toString(
				ArrayCyclicRotation.getQueriedPositionsAfterCyclicArrayRotation(new int[] { 1, 2, 3 }, 2, new int[] { 0, 1, 2 })));
		
		System.out.println("result of rotating  " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " 2 times is " + Arrays.toString(
				ArrayCyclicRotation.getQueriedPositionsAfterCyclicArrayRotation(new int[] { 1, 5, 2, 1, 4, 0 }, 2, new int[] { 0, 1, 2 })));
		
		System.out.println("result of rotating  " + Arrays.toString(new int[] { }) + " 2 times is " + Arrays.toString(
				ArrayCyclicRotation.getQueriedPositionsAfterCyclicArrayRotation(new int[] {}, 2, new int[] {})));
		
		System.out.println("--------");
		
		/*
		System.out.println("result of rotating using CollectionsRotateMethod");
		ArrayCyclicRotation.usingCollectionsRotateMethod();
		*/
		
		
		System.out.print("result of rotating  ");
		Integer[] sourceArray = { 1, 5, 2, 1, 4, 0 };
		PrintUtils.printArray(sourceArray);
		System.out.print(" 2 times usingCollectionsRotateMethod is ");
		List result = rotate2(Arrays.asList(sourceArray), 2);
		PrintUtils.printList(result);
		
	}

	/**
	 * This can also be written using System.arraycopy( result, 0, A, 0, A.length ) or Arrays.copyOfRange().
	 * 
	 * int[] newArray = Arrays.copyOfRange(oldArray, startIndex, endIndex);
	 * 
	 * public static void arraycopy(Object src,
             int srcPos,
             Object dest,
             int destPos,
             int length)
             Copies an array from the specified source array, 
             beginning at the specified position, to the specified position of the destination array.
             A subsequence of array components are copied from the source array referenced by src 
             to the destination array referenced by dest.
             The number of components copied is equal to the length argument.
             The components at positions srcPos through srcPos+length-1 in the source array 
             are copied into positions destPos through destPos+length-1, respectively, of the destination array.

	 * But the disadvantage of that approach is that it creates an extra array - not good when space complexity is considered. 
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

		// using an intermediate array to hold the results.
		// not an in-place solution.
		
		// for an in-place solution, look at rotate2()
		
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
	
	/**
	 * 
	 	Return elements at only specific positions after cyclic rotation instead of returning the entire rotated array. 
	 * 
	 */
	static int[] getQueriedPositionsAfterCyclicArrayRotation(int[] a, int k, int[] queries) {
		
		int[] rotatedArray = solution(a, k);
		
		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++)
		{
			result[i] = rotatedArray[queries[i]];
		}
		
		return result;
    }
	
	/**
	 * Take a look at OpenJDK's implementation here :
	 * OpenJDK's rotate implementation : 
	 * https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/Collections.java
	 */
	private static List<?> rotate2(List<?> list, int distance) {

        int size = list.size();

        if (size == 0)
        {
        	return list;
        }

        int mid =  -distance % size;

        if (mid < 0)
        {
        	mid += size;
        }

        if (mid == 0)
        {
        	return list;
        } 

        /*
        	OpenJDK's reverse implementation : 
   	 		https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/Collections.java
   	 	*/
        Collections.reverse(list.subList(0, mid));
        Collections.reverse(list.subList(mid, size));
        Collections.reverse(list);
        
        return list;

    }

}

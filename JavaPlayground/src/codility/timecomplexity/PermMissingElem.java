package codility.timecomplexity;

import java.util.Arrays;

/** 
	

    An array A consisting of N different integers is given. 
    The array contains integers in the range [1..(N + 1)], 
    which means that exactly one element is missing.
    
    Your goal is to find that missing element.
    
    Write a function:
    
        class Solution { public int solution(int[] A); }
    
    that, given an array A, returns the value of the missing element.
    
    For example, given array A such that:
      A[0] = 2
      A[1] = 3
      A[2] = 1
      A[3] = 5
    
    the function should return 4, as it is the missing element.
    
    Write an efficient algorithm for the following assumptions:
    
            N is an integer within the range [0..100,000];
            the elements of A are all distinct;
            each element of array A is an integer within the range [1..(N + 1)].


*/
public class PermMissingElem
{

	public static void main(String[] args)
	{
		int[] A = { 2, 3, 1, 5 };
		System.out.println("result : " + solution(A));

		int[] A2 = { 1 };
		System.out.println("result : " + solution(A2));

		int[] A3 = { 1, 2, 3 };
		System.out.println("result : " + solution(A3));

		int[] A4 = { 2, 3, 4 };
		System.out.println("result : " + solution(A4));

		int[] A5 = {};
		System.out.println("result : " + solution(A5));
	}

	public static int solution(int[] A)
	{
		int result = 0;
		if (A.length > 0)
		{
			// O(N*log(N))
			Arrays.sort(A);
			
			for (int aIndex = 0; aIndex < A.length; aIndex++)
			{
				if ((aIndex + 1) != A[aIndex])
				{
					result = aIndex + 1;
					break;
				}
			}
			if (0 == result)
			{
				result = A[A.length - 1] + 1;
			}
		}
		else
		{
			result = 1;
		}
		return result;
	}

}

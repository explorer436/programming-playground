package codility.prefixsums;

/**
 * 
Level  : Painless

Count the number of passing cars on the road.


   A non-empty zero-indexed array A consisting of N integers is given. The
   consecutive elements of array A represent consecutive cars on a road.
   
   Array A contains only 0s and/or 1s:
   
   0 represents a car traveling east, 1 represents a car traveling west. The
   goal is to count passing cars. We say that a pair of cars (P, Q), where 0 â‰¤ P
   < Q < N, is passing when P is traveling to the east and Q is traveling to the
   west.
   
   For example, consider array A such that:
   
   A[0] = 0 A[1] = 1 A[2] = 0 A[3] = 1 A[4] = 1 
   We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
   
   Write a function:
   
   class Solution { public int solution(int[] A); }
   
   that, given a non-empty zero-indexed array A of N integers, returns the
   number of pairs of passing cars.
   
   The function should return -1 if the number of pairs of passing cars exceeds 1,000,000,000.
   
   For example, given:
   
   A[0] = 0 A[1] = 1 A[2] = 0 A[3] = 1 A[4] = 1 (A = [ 0, 1, 0, 1, 1]) the function should return 5, as explained above.
   
   Assume that:
   
   N is an integer within the range [1..100,000]; each element of array A is an
   integer that can have one of the following values: 0, 1. Complexity:
   
   expected worst-case time complexity is O(N); expected worst-case space
   complexity is O(1), beyond input storage (not counting the storage required
   for input arguments).
 * 
 */
public class PassingCars
{
	// A = [ 0, 1, 0, 1, 1]

	public static void main(String[] args) throws Exception
	{
		if (5 != solution(new int[] { 0, 1, 0, 1, 1 }))
		{
			throw new Exception("wrong answer");
		}

		if (1 != solution(new int[] { 0, 1 }))
		{
			throw new Exception("wrong answer");
		}

		if (0 != solution(new int[] { 1, 0 }))
		{
			throw new Exception("wrong answer");
		}

		System.out.println("done");
	}

	/*
	 * assuming 0 represents cars going in the right direction and 1 represents cars going in the left direction.
	 * 
	 *  ->      ->
	 * 	0,	1,	0,	1,	1
	 *     <-      <-   <-
	 */
	public static int solution(int[] A)
	{
		int right_count = 0;
		int passingCars = 0;

		for (int i = 0; i < A.length; i++)
		{
			if (A[i] == 0)
			{
				right_count = right_count + 1;
			}
			if (A[i] == 1)
			{
				// the car is going left.
				// all the cars going in the left direction will pass the cars that are going right.
				passingCars = passingCars + right_count;
			}
			if (passingCars > 1000000000)
			{
				return -1;
			}
		}
		return passingCars;
	}
}

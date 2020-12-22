package codility.timecomplexity;

/**
 * 

Level : Painless

Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.


    A non-empty array A consisting of N integers is given. 
    Array A represents numbers on a tape.
    
    Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: 
    A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
    
    The difference between the two parts is the value of: 
    |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
    
    In other words, it is the absolute difference between the sum of the first part and 
    the sum of the second part.
    
    For example, consider array A such that:
      A[0] = 3
      A[1] = 1
      A[2] = 2
      A[3] = 4
      A[4] = 3
    
    We can split this tape in four places:
    
            P = 1, difference = |3 − 10| = 7
            P = 2, difference = |4 − 9| = 5
            P = 3, difference = |6 − 7| = 1
            P = 4, difference = |10 − 3| = 7
    
    Write a function:
    
        class Solution { public int solution(int[] A); }
    
    that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
    
    For example, given:
      A[0] = 3
      A[1] = 1
      A[2] = 2
      A[3] = 4
      A[4] = 3
    
    the function should return 1, as explained above.
    
    Write an efficient algorithm for the following assumptions:
    
            N is an integer within the range [2..100,000];
            each element of array A is an integer within the range [−1,000..1,000].


 */
public class TapeEquilibrium
{

	public static void main(String args[])
	{
		int[] A = { 3, 1, 2, 4, 3 };
		int res = solution(A);
		System.out.println("res : " + res);

	}

	/**
	 * 	A			|	3	1	2	4	3
	 *  iteration 1	|	3	10
	 *  iteration 2	|		4	9
	 *  iteration 3	|			6	7
	 *  iteration 4	|				10	3
	 */
	public static int solution(int[] A)
	{
		int N = A.length;

		if (N == 2)
		{
			return Math.abs(A[0] - A[1]);
		}
		
		/**
		 * we will build two arrays.
		 * put the possible values for the first part of the sum in the first array.
		 * put the possible values for the second part of the sum in the second array.
		 * loop through the indexes of the two arrays and calculate the difference and find the minimum possible difference.
		 */

		int[] firstArray = new int[N - 1];
		firstArray[0] = A[0];
		for (int i = 1; i < N; i++)
		{
			if (i < N - 1)
			{
				firstArray[i] = firstArray[i - 1] + A[i]; // 3, 4, 6, 10
			}
		}

		int[] secondArray = new int[N - 1];
		secondArray[N - 2] = A[N - 1];
		for (int i = N - 3; i >= 0; i--)
		{
			secondArray[i] = secondArray[i + 1] + A[i + 1]; // 10, 9, 7, 3
		}

		// firstArray.length or secondArray.length - doesn't matter.
		// the two arrays are of equal length.
		int minimalDifference = Integer.MAX_VALUE;
		for (int j = 0; j < firstArray.length; j++)
		{
			int difference = Math.abs(firstArray[j] - secondArray[j]); // 3 - 10, 4 - 9, 6 - 7, 10 - 3
			if (difference < minimalDifference)
			{
				minimalDifference = difference;
			}
		}
		
		return minimalDifference;
	}
}

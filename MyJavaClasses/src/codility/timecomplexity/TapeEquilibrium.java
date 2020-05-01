package codility.timecomplexity;

/*
 * 

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

	public static int solution(int[] A)
	{
		int N = A.length;

		if (N == 2)
		{
			return Math.abs(A[0] - A[1]);
		}

		int[] firstArray = new int[N - 1];
		firstArray[0] = A[0];
		for (int i = 1; i < N; i++)
		{
			// firstArray[1] = firstArray[0] + A[1];
			// firstArray[2] = firstArray[1] + A[2];
			// firstArray[3] = firstArray[2] + A[3];
			// firstArray[4] = firstArray[3] + A[4];
			if (i < N - 1)
			{
				firstArray[i] = firstArray[i - 1] + A[i];
			}
		}

		int[] secondArray = new int[N - 1];
		secondArray[N - 2] = A[N - 1];
		for (int i = N - 3; i >= 0; i--)
		{
			secondArray[i] = secondArray[i + 1] + A[i + 1];
		}

		/* public static final int MAX_VALUE = 2147483647; */
		int result = Integer.MAX_VALUE;

		for (int j = 0; j < firstArray.length; j++)
		{
			int sum = Math.abs(firstArray[j] - secondArray[j]);
			if (sum < result)
			{
				result = sum;
			}
		}
		return result;
	}
}

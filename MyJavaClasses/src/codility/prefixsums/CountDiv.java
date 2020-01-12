package codility.prefixsums;

/**
 * Write a function:
 * 
 * class Solution { public int solution(int A, int B, int K); }
 * 
 * that, given three integers A, B and K, returns the number of integers within
 * the range [A..B] that are divisible by K, i.e.:
 * 
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * 
 * For example, for A = 6, B = 11 and K = 2, your function should return 3,
 * because there are three numbers divisible by 2 within the range [6..11],
 * namely 6, 8 and 10.
 * 
 * Assume that:
 * 
 * A and B are integers within the range [0..2,000,000,000]; K is an integer
 * within the range [1..2,000,000,000]; A ≤ B. Complexity:
 * 
 * expected worst-case time complexity is O(1); expected worst-case space
 * complexity is O(1).
 */
public class CountDiv
{

	public static void main(String[] args)
	{
		System.out.println("result : " + solution(6, 11, 2));

		System.out.println("result : " + solution(6, 11, 3));

		System.out.println("result : " + solution(11, 345, 17));// answer should be 20

		/*
		 * A = 11, B = 345, K = 17 WRONG ANSWER got 19 expected 20
		 */

		/*
		 * System.out.println("result : " + solution(2, A3));
		 * 
		 * System.out.println("result : " + solution(3, A4));
		 * 
		 * System.out.println("result : " + solution(1, A5));
		 * 
		 * System.out.println("result : " + solution(2, A5));
		 */
	}

	// how is this solution using prefix sums?
	public static int solution(int A, int B, int K)
	{
		// Explanation: Number of integers in the range [1 .. X] that divisible by K is
		// X/K.
		// So, within the range [A .. B], the result is B/K - (A - 1)/K

		int b = B / K;

		int a;
		if (A > 0)
		{
			a = (A - 1) / K;
		}
		else
		{
			a = 0;
		}

		if (0 == A)
		{
			b = b + 1;
		}

		return b - a;
	}

	/*
	 * public static int solution(int A, int B, int K) { int result = 0; int diff =
	 * (B - A);
	 * 
	 * if(0 == diff) { if(0 == (A % K)) { return 1; } else { return 0; } } else {
	 * if((0 == (A % K)) || (0 == (B % K))) { result = (diff/K) +1; } else { result
	 * = (diff/K); } } return result; }
	 */
}

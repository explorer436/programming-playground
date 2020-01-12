package codility.timecomplexity;

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

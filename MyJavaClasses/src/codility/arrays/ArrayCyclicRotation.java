package codility.arrays;


public class ArrayCyclicRotation
{
	public static void main(String[] args)
	{
		ArrayCyclicRotation solution = new ArrayCyclicRotation();

		for (int i : solution.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 2))
		{
			System.out.print(i + " - ");
		}
		System.out.println();
		System.out.println("------------------------------------------------");

		for (int i : solution.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 6))
		{
			System.out.print(i + " - ");
		}
		System.out.println();
		System.out.println("------------------------------------------------");

		for (int i : solution.solution(new int[] { 1, 5, 2, 1, 4, 0 }, 10))
		{
			System.out.print(i + " - ");
		}
		System.out.println();
		System.out.println("------------------------------------------------");

		for (int i : solution.solution(new int[] {}, 2))
		{
			System.out.print(i + " - ");
		}
		System.out.println();
		System.out.println("------------------------------------------------");

		for (int i : solution.solution(new int[] {}, -2))
		{
			System.out.print(i + " - ");
		}
		System.out.println();
		System.out.println("------------------------------------------------");
	}

	public int[] solution(int[] A, int K)
	{
		System.out.println("A.length : " + A.length + " and K : " + K);

		if (0 == A.length || K == A.length)
		{
			return A;
		}

		if (K > A.length)
		{
			K = K % A.length;
			System.out.println("K : " + K);
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

		// System.arraycopy( result, 0, A, 0, A.length );

		return result;
	}

}

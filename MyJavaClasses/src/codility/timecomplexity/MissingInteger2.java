package codility.timecomplexity;

/*
 * 
 * MissingInteger.java
 * 
 */
public class MissingInteger2
{

	public static void main(String[] args)
	{
		int[] A = { 5, 1, 2, 3, 4, 5, 1 };
		System.out.println("result : " + solution(A, 1));

		int[] A2 = { 3, 2, 3, 1, 3 };
		System.out.println("result : " + solution(A2, 5));

		/*
		 * int[] A3 = {-1, -3}; System.out.println("result : " + solution(A3));
		 * 
		 * int[] A4 = {3}; System.out.println("result : " + solution(A4));
		 * 
		 * int[] A5 = {2, 2, 2, 2, 2}; System.out.println("result : " + solution(A5));
		 * 
		 * int[] A6 = {}; System.out.println("result : " + solution(A6));
		 */

		System.out.println("result : " + solution(null, 4));
	}

	public static String solution(int[] arr, int k)
	{
		if (null != arr)
		{
			int n = arr.length;
			// 1st comparison
			if (arr[n - 1] == k)
				return "YES";

			int backup = arr[n - 1];
			arr[n - 1] = k;

			// no termination condition and thus
			// no comparison
			for (int i = 0;; i++)
			{
				// this would be executed at-most n times
				// and therefore at-most n comparisons
				if (arr[i] == k)
				{
					// replace arr[n-1] with its actual element
					// as in original 'arr[]'
					arr[n - 1] = backup;

					// if 'x' is found before the '(n-1)th'
					// index, then it is present in the array
					// final comparison
					if (i < n - 1)
						return "YES";

					// else not present in the array
					return "NO";
				}
			}
		}
		else
		{
			return "NO";
		}

	}
}

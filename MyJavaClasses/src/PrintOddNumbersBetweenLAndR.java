import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 * MissingInteger.java
 * 
 */
public class PrintOddNumbersBetweenLAndR
{

	public static void main(String[] args)
	{
		for (int i : solution(2, 5))
		{
			System.out.println("i : " + i);
		}

		/*
		 * int[] A2 = {3, 2, 3, 1, 3}; System.out.println("result : " + solution(A2,
		 * 5));
		 * 
		 * int[] A3 = {-1, -3}; System.out.println("result : " + solution(A3));
		 * 
		 * int[] A4 = {3}; System.out.println("result : " + solution(A4));
		 * 
		 * int[] A5 = {2, 2, 2, 2, 2}; System.out.println("result : " + solution(A5));
		 * 
		 * int[] A6 = {}; System.out.println("result : " + solution(A6));
		 * 
		 * System.out.println("result : " + solution(null, 4));
		 */
	}

	public static int[] solution(int l, int r)
	{
		List<Integer> result = new ArrayList<Integer>();
		for (int i = l; i <= r; i++)
		{
			if (i % 2 != 0)
			{
				result.add(i);
			}
		}

		int[] series = {};
		for (int i : result)
		{
			series = addElement(series, i);
		}
		return series;
	}

	static int[] addElement(int[] a, int e)
	{
		a = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}
}

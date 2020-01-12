package codility.countingelements;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FrogRiverOne
{

	public static void main(String[] args)
	{
		int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };
		System.out.println("result : " + solution(5, A));

		int[] A2 = { 3 };
		System.out.println("result : " + solution(5, A2));

		int[] A3 = { 3 };
		System.out.println("result : " + solution(2, A3));

		int[] A4 = { 3 };
		System.out.println("result : " + solution(3, A4));

		int[] A5 = { 1 };
		System.out.println("result : " + solution(1, A5));

		int[] A6 = { 2, 2, 2, 2, 2 };
		System.out.println("result : " + solution(2, A6));
	}

	public static int solution(int X, int[] A)
	{
		Map<Integer, Integer> indexesMap = new HashMap<Integer, Integer>();
		// start from the back
		for (int i = A.length - 1; i >= 0; i--)
		{
			indexesMap.put(A[i], i);
		}

		// now find the highest value in the map
		int earlistTime = -1;

		if (indexesMap.isEmpty())
		{
			return -1;
		}
		else
		{
			Set<Integer> keys = indexesMap.keySet();

			boolean allLeavesPresent = true;
			for (int j = 1; j <= X; j++)
			{
				// System.out.println("j : " + j);
				if (!keys.contains(j))
				{
					allLeavesPresent = false;
					break;
				}
			}
			// System.out.println("allLeavesPresent : " + allLeavesPresent);

			if (allLeavesPresent)
			{
				// now find the highest value in the map
				for (int i = 1; i <= X; i++)
				{
					Integer val = (Integer) indexesMap.get(i);

					if (val > earlistTime)
					{
						earlistTime = val;
					}
				}
			}
		}
		return earlistTime;
	}
}

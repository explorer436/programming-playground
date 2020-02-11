package codility.countingelements;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 

A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4

In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

    class Solution { public int solution(int X, int[] A); }

that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4

the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

        N and X are integers within the range [1..100,000];
        each element of array A is an integer within the range [1..X].


 */
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

package datastructures.arrays;

/**
 * 
	Largest Sum Contiguous Subarray

	Write an efficient program to find the sum of contiguous subarray 
	within a one-dimensional array of numbers which has the largest sum. 
 *
 */
public class LargestSumSubarray {

	public static void main(String[] args) {
		
		int[] A;
				
		A = new int[] {	-2, -3, 4, -1, -2, 1, 5, -3	};		
		solution(A); // 7
		
		A = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		solution(A); // 6
		
		// all negative numbers
		A = new int[] {-2, -3, -1, -1, -2, -3}; // TODO incorrect answer
		solution(A);

	}
	
	/*
	 * Brute force approach will be similar to the one implemented in MinAvgTwoSlice2.java
	 */
	
	/**
	 * See KadanesAlgorithm.pdf
	 * 
	 * 	
	 * A[0]					A[1]						A[2]						A[3]								A[4]							A[5]							A[6]							A[7]
	 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 																																																					-3 = -3 (discard)
	 * 																																													5 = 5 (discard)					-3
	 * 																																					1 = 1 (discard)					5								-3
	 * 																													-2 = -2 (discard)				1								5								-3
	 * 																				-1 = -1 (discard)					-2								1								5								-3
	 * 													4 = 4 (currentMaxSum)		-1 = 4 + -1 = 3	 (currentMaxSum)	-2 = 3 + -2 = 1 (currentMaxSum)	1 = 1 + 1 = 2 (currentMaxSum)	5 = 2 + 5 = 7 (currentMaxSum)	-3 = 7 + -3 = 4 (currentMaxSum)
	 * 						-3 = -3	(currentMaxSum)		4 = -3 + 4 = 1 (discard)	-1									-2								1								5								-3
	 * 	-2 (currentMaxSum)	-3 = -2 + -3 = -5 (discard)	4							-1									-2								1								5								-3
	 * 
	 * Keep track of currentMaxSum with every iteration and update globalMax when necessary.
	 */	
	
	/*
	 * Time Complexity: O(n)
	 * Algorithmic Paradigm: Dynamic Programming
	 */
	private static void solution(int[] A)
	{
		if (A.length > 0)
		{
			int currentMaxSum = A[0];
			int globalMax = A[0];
			for (int index = 1; index < A.length; index++)
			{
				int prevMaxPlusCurrElement = currentMaxSum + A[index];
				
				if (A[index] != prevMaxPlusCurrElement) 
				{
					currentMaxSum = A[index] > prevMaxPlusCurrElement ? A[index] : prevMaxPlusCurrElement;
				}
				else
				{
					currentMaxSum = A[index] + prevMaxPlusCurrElement;
				}
				
				if (currentMaxSum > globalMax)
				{
					globalMax = currentMaxSum;
				}
			}
			
			System.out.println("globalMax : " + globalMax);
		}
	}
}

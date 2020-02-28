package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Finding the k th Smallest Value of an Array.
 * 
 * The recursive solution proceeds by 
 * 1. Selecting a pivot value in the array
 * 2. Cleverly arranging, or partitioning , the values in the array about this pivot value
 * 3. Recursively applying the strategy to one of the partitions
 * 
 * Suppose that you want to fi nd the kth smallest value in the array segment anArray[first..last].
 * Let the pivot p be any value of the array segment.
 * You can partition the values of anArray[first..last] into three regions: 
 * S1, which contains the values less than or equal to p ; 
 * the pivot p itself; 
 * and S2, which contains the values greater than or equal to p . 
 * This partition implies that all of the values in S1 are no larger than all of the values in S2 .
 * 
 * All values in anArray[first..pivotIndex-1] are less than or equal to p, 
 * and all values in anArray[pivotIndex+1..last] are greater than or equal to p .
 * 
 * This partition induces three smaller problems, such that the solution to one of the problems will solve the original problem:
 * 1. If S1 contains k or more values, S1 contains the k smallest values of the array segment anArray[first..last] . 
 * 	  In this case, the kth smallest value must be in S1 . 
 *	Since S1 is the array segment anArray[first..pivotIndex-1] , this case occurs if k < pivotIndex – first + 1.
 * 2. If S1 contains k – 1 values, the kth smallest value must be the pivot p . 
 *	This is the base case; it occurs if k = pivotIndex – first + 1.
 * 3. If S1 contains fewer than k – 1 values, the kth smallest value in anArray[first..last] must be in S2 . 
 *	Because S1 contains pivotIndex – first values, the kth smallest value in anArray[first..last] is the ( k – ( pivotIndex – first + 1))st smallest value in S2 . 
 *	This case occurs if k > pivotIndex – first + 1.
 *
 */
public class FindTheKthSmallestValueOfAnArray {
	public static void main(String[] args) {
		
		// Integer[] anArray = new Integer[]{4, 7, 3, 6, 8, 1, 9, 2};
		ArrayList<Integer> anArray = new ArrayList<Integer>();
		anArray.add(4);
		anArray.add(7);
		anArray.add(3);
		anArray.add(6);
		anArray.add(8);
		anArray.add(1);
		anArray.add(9);
		anArray.add(2);
		System.out.println("3rd smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(3, anArray));
		
		System.out.println("6th smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(6, anArray));
		
		System.out.println("7th smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(7, anArray));
		
		System.out.println("8th smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(8, anArray));
		
		System.out.println("9th smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(9, anArray));
	}

	public static int kSmall(int k, List<Integer> anArray) {
		
		ArrayList<Integer> S1 = new ArrayList<Integer>();
		ArrayList<Integer> S2 = new ArrayList<Integer>();
		ArrayList<Integer> S3 = new ArrayList<Integer>();
					
		int size = anArray.size();
			
		// when the size of the array is 1, we want pivot index = 0
		int pivotIndex;		
		if (size != 1) 
		{
			pivotIndex = (size + 1) / 2;
		}
		else
		{
			pivotIndex = 0;
		}
		int pivot = anArray.get(pivotIndex);
		
		for (int i : anArray)
		{
			if (i < pivot)
			{
				S1.add(i);
			}
			else if (i == pivot)
			{
				S2.add(i);
			}
			else if (i > pivot)
			{
				S3.add(i);
			}
		}

		if (k <= S1.size())
		{
			return kSmall(k, S1);
		}
		// There is a possibility that k could be greater than the size of S1 but S3 is empty.
		// In that scenario, the value from S2 would be the result.
		else if (k > S1.size() + 1 && S3.size() > 0)
		{
			return kSmall(k -1, S3);
		}
		else
		{
			return S2.get(0);
		}
	}
}

package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

/**
 
Finding the k th Smallest Value of an Array.
 
You could solve this problem by sorting the array. Then the k th smallest value would be
anArray[k-1] . Although this approach is a legitimate solution, it does more than the problem
requires; a more efficient solution is possible. The solution outlined here finds the k th smallest value
without completely sorting the array.

Usually, using recursion, by knowing only the size of the original problem, 
you can determine the number of recursive calls that are necessary before you reach the base case.

The solution that you are about to see for finding the k th smallest value departs from these techniques. 
Although you solve the problem in terms of a smaller problem, just how much smaller this
problem is depends on the values in the array and cannot be predicted in advance. Also, the size of the
base case depends on the values in the array, as it did for the binary search.

The unpredictable nature of this solution is caused by the problem itself: The relationship
between the rankings of the values in any predetermined parts of the array and the ranking of the val-
ues in the entire array is not strong enough to determine the k th smallest value.



The recursive solution proceeds by 
1. Selecting a pivot value in the array
2. Cleverly arranging, or partitioning , the values in the array about this pivot value
3. Recursively applying the strategy to one of the partitions

Suppose that you want to find the kth smallest value in the array segment anArray[first..last].
Let the pivot p be any value of the array segment.
You can partition the values of anArray[first..last] into three regions: 
1.	S1, which contains the values less than or equal to p ; 
2.	the pivot p itself; 
3.	and S2, which contains the values greater than or equal to p . j

			S1				S2
	 _______________________________
	|______<= p____|p|____>= p______|
	first           pivot           last

This partition implies that all of the values in S1 are no larger than all of the values in S2 .

All values in anArray[first..pivotIndex-1] are less than or equal to p, 
and all values in anArray[pivotIndex+1..last] are greater than or equal to p .

This partition induces three smaller problems, such that the solution to one of the problems will solve the original problem:
1. If S1 contains k or more values, S1 contains the k smallest values of the array segment anArray[first..last] . 
   In this case, the kth smallest value must be in S1 . 
   Since S1 is the array segment anArray[first..pivotIndex-1] , this case occurs if k < pivotIndex – first + 1.
2. If S1 contains k – 1 values, the kth smallest value must be the pivot p . 
   This is the base case; it occurs if k = pivotIndex – first + 1.
3. If S1 contains fewer than k – 1 values, the kth smallest value in anArray[first..last] must be in S2 . 
   Because S1 contains pivotIndex – first values, the kth smallest value in anArray[first..last] is the ( k – ( pivotIndex – first + 1))st smallest value in S2 . 
   This case occurs if k > pivotIndex – first + 1.

A recursive definition can summarize this discussion. Let
kSmall(k, anArray, first, last) = k th smallest value in anArray[first..last]   

After you select the pivot value p and partition anArray[first..last] into S 1 and S 2 , you have that
kSmall(k, anArray, first, last) equals
* kSmall(k, anArray, first, pivotIndex – 1) if k < pivotIndex – first + 1
* p if k = pivotIndex – first + 1
* kSmall(k – (pivotIndex – first + 1), anArray, pivotIndex + 1, last) if k > pivotIndex – first + 1

There is always a pivot, and because it is not part of either S 1 or S 2 , the size of the array segment to
be searched decreases by at least 1 at each step. Thus, you will eventually reach the base case: The
desired value is a pivot. A high-level pseudocode solution is as follows.

 */
public class FindTheKthSmallestValueOfAnArray {
	public static void main(String[] args) {
		
		Integer[] anArray = new Integer[]{4, 7, 3, 6, 8, 1, 9, 2};

		System.out.println("0th smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(0, Arrays.asList(anArray)));
		// expected -1

		System.out.println("1st smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(1, Arrays.asList(anArray)));
		// expected 1

		System.out.println("3rd smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(3, Arrays.asList(anArray)));
		// expected 3
		
		System.out.println("6th smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(6, Arrays.asList(anArray)));
		// expected 7
		
		System.out.println("7th smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(7, Arrays.asList(anArray)));
		// expected 8
		
		System.out.println("8th smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(8, Arrays.asList(anArray)));
		// expected 9
		
		System.out.println("9th smallest element of anArray : " + FindTheKthSmallestValueOfAnArray.kSmall(9, Arrays.asList(anArray)));
		// expected -1
	}

	public static int kSmall(int k, List<Integer> anArray) {
		
		ArrayList<Integer> S1 = new ArrayList<Integer>();
		ArrayList<Integer> S2 = new ArrayList<Integer>();
		ArrayList<Integer> S3 = new ArrayList<Integer>();
					
		int size = anArray.size();
			
		if (k <= 0 || size <= 0)
		{
			return -1;
		}
		else
		{
			// when the size of the array is 1, we want pivot index = 0
			int pivotIndex = 0;
			if (size != 1) 
			{
				pivotIndex = (size + 1) / 2;
			}
			else if (size == 1)
			{
				if (k == 1)
				{
					return anArray.get(0);
				}
				else {
					return -1;
				}
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
			else if (k == S1.size() + 1)
			{
				// The element at the pivot index is the answer.
				return S2.get(0);
			}
			// There is a possibility that k could be greater than the size of S1 but S3 is empty.
			// In that scenario, the value from S2 would be the result.
			else if (k > S1.size() + 1 && (k - S1.size() - S2.size()) <= S3.size())
			{
				return kSmall(k - S1.size() - S2.size(), S3);
			}
		}
		return -1;
	}
}

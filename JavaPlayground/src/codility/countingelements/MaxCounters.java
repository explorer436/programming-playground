package codility.countingelements;

import java.util.Arrays;

/**
 * 

Level : Respectable

Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.


You are given N counters, initially set to 0, and you have two possible operations on them:

        increase(X) − counter X is increased by 1,
        max counter − all counters are set to the maximum value of any counter.

A non-empty array A of M integers is given. This array represents consecutive operations:

        if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
        if A[K] = N + 1 then operation K is max counter.

For example, given integer N = 5 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4

the values of the counters after each consecutive operation will be:
    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)

The goal is to calculate the value of every counter after all operations.

Write a function:

    class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, 
returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4

the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

        N and M are integers within the range [1..100,000];
        each element of array A is an integer within the range [1..N + 1].


 */
public class MaxCounters
{

	public static void main(String[] args)
	{
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };
		System.out.println("bruteForceSolution_slow : " + Arrays.toString(bruteForceSolution_slow(5, A)));
		
		System.out.println("solution : " + Arrays.toString(solution(5, A)));

		/*
		 * int[] A2 = {3}; System.out.println("result : " + solution(5, A2));
		 * 
		 * int[] A3 = {3}; System.out.println("result : " + solution(2, A3));
		 * 
		 * int[] A4 = {3}; System.out.println("result : " + solution(3, A4));
		 * 
		 * int[] A5 = {1}; System.out.println("result : " + solution(1, A5));
		 * 
		 * int[] A6 = {2, 2, 2, 2, 2}; System.out.println("result : " + solution(2,
		 * A5));
		 */
	}
	
	/**
	 * 
	 * java - Arrays.fill()
	 * public static void fill(Object[] a, Object val) {
	 *     for (int i = 0, len = a.length; i < len; i++) //this loop will continues to the length of a.
	 *         a[i] = val;
	 * }
	 * So, Complexity for this method would be O(n power 2).
	 */
	public static int[] bruteForceSolution_slow(int N, int[] A) { 
		int[] counterArray = new int[N];
		System.out.println(Arrays.toString(counterArray)); 
		// [0, 0, 0, 0, 0]
	  
		int maxElementInCounterArray = 0;
		for(int arrAIndex = 0; arrAIndex < A.length; arrAIndex++) 
		{
			  if(A[arrAIndex] == N + 1) 
			  { 
				  // O(n)
				  Arrays.fill(counterArray, maxElementInCounterArray);
			  }
			  else if(1<= A[arrAIndex] && A[arrAIndex] <= N) 
			  { 
				  counterArray[A[arrAIndex] - 1] = counterArray[A[arrAIndex] - 1] + 1;
				  if (counterArray[A[arrAIndex] - 1] > maxElementInCounterArray)
				  {
					  maxElementInCounterArray = counterArray[A[arrAIndex] - 1];
				  }
			  }
		}
		  
		return counterArray; 
	}

	// O(N + M)
	public static int[] solution(int N, int[] A)
	{
		int counter[] = new int[N];
		int current_max = -1;
		int leastPossibleCounterValue = 0;

		for (int currentIndex = 0; currentIndex < A.length; currentIndex++)
		{
			int currentAElement = A[currentIndex];
			
			// check if currentAElement is between 1 and N.
			if (1 <= currentAElement && currentAElement <= N)
			{
				int currentCounterElement = counter[currentAElement - 1];
				
				/**
				 * check the value of currentCounterElement is less than leastPossibleCounterValue.
				 * 
				 * this tells us whether the value of currentCounterElement should be incremented or 
				 * if it should be first set to leastPossibleCounterValue and then incremented.
				 */
				
				if (currentCounterElement < leastPossibleCounterValue)
				{
					currentCounterElement = leastPossibleCounterValue;
				}
				
				// increment currentCounterElement
				currentCounterElement = currentCounterElement + 1;
				
				// make sure the value of current_max is accurate. if it needs to be changed, change it.
				if (currentCounterElement > current_max)
				{
					current_max = currentCounterElement;
				}
				
				// set the value of currentCounterElement in counter array.
				counter[currentAElement - 1] = currentCounterElement;
			}
			else if (currentAElement == N + 1)
			{
				/**
				 * this is the crucial difference between bruteForceSolution_slow() and this solution.
				 * instead of changing the values of the elements in the entire counter array, 
				 * we are maintaining the value for leastPossibleCounterValue.
				 * 
				 */
				
				leastPossibleCounterValue = current_max;
			}
		}
		
		// there might be some orphan counter elements whose value might be smaller than leastPossibleCounterValue.
		// for elements like that, set them to leastPossibleCounterValue.
		for (int i = 0; i < N; i++)
		{
			if (counter[i] < leastPossibleCounterValue)
			{
				counter[i] = leastPossibleCounterValue;
			}
		}
		
		return counter;
	}
	 

}

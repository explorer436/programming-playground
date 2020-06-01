package codility.prefixsums;

/**
 * 

A non-empty array A consisting of N integers is given. 
A pair of integers (P, Q), such that 0 â‰¤ P < Q < N, 
is called a slice of array A (notice that the slice contains at least two elements). 
The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] 
divided by the length of the slice. 
To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q âˆ’ P + 1).

For example, array A such that:
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8

contains the following example slices:

        slice (1, 2), whose average is (2 + 2) / 2 = 2;
        slice (3, 4), whose average is (5 + 1) / 2 = 3;
        slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

The goal is to find the starting position of a slice whose average is minimal.

Write a function:

    class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, 
returns the starting position of the slice with the minimal average. 
If there is more than one slice with a minimal average, 
you should return the smallest starting position of such a slice.

For example, given array A such that:
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8

the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [2..100,000];
        each element of array A is an integer within the range [-10,000..10,000].


 */
public class MinAvgTwoSlice2 {

    public static void main(String[] args)
    {
    	MinAvgTwoSlice2 classUnderTest = new MinAvgTwoSlice2();
        int[] A = new int[] { 4, 2, 2, 5, 1, 5, 8 };
        classUnderTest.solution(A); // globalMinAvg : 2.0, indexOfGlobalMinAvg : 1
        
        A = new int[] { 4, 2, 2, 5, 1, 5, 8, 1, 3, 9, 1, 1, 7 };
        classUnderTest.solution(A); // globalMinAvg : 1.0, indexOfGlobalMinAvg : 10
        
        A = new int[] { 9 };
        classUnderTest.solution(A); // globalMinAvg : 9.0, indexOfGlobalMinAvg : 0
        
        A = new int[] { };
        classUnderTest.solution(A); // globalMinAvg : 0.0, indexOfGlobalMinAvg : 0
        
    }
    
    /*
	    This solution is only 60% correct.
	    correctness 100%
	    performance 20%
	    
	    Detected time complexity: O(N ** 2)
	    
	    This is on the right path to solving it. But the time complexity is bad.
	    It turns out that it is not necessary to traverse through the array for each length starting from 2 to n.
	    It is enough to traverse through the array for lengths 2 and 3 only.
	    See MinAvgTwoSlice3.java for the most correct answer to the problem.
    */

    /**
     *
     	4,  2,  2,  5,  1,  5,  8
     	|___|
     	    |___|
     	        |___|
     	            |___|
     	                |___|
     	                    |___|
     	|_______|
     	    |_______|
     	        |_______|
     	            |_______|
     	                |_______|
     	|___________|
     	    |___________|
     	        |___________|
     	            |___________|
     	|_______________|
     	    |_______________|
     	        |_______________|
     	|___________________|
     	    |___________________|
     	|_______________________|
     *
     */
    public void solution(int[] A)
    {
    	// return either the minimum average or the starting index of the slice with the minimum average based on the requirement.
    	
    	float globalMinAvg = 0;
    	int indexOfGlobalMinAvg = 0;
    	
    	int length = A.length;
    	
    	int[] prefixSums = PrefixSums.prefixSumsOfAnArray(A);
    	
    	if (A.length == 1)
    	{
    		globalMinAvg = (float) A[0];
    	}
    	else if (A.length > 1)
    	{
    		globalMinAvg = (float) prefixSums[1] / 2;
    		indexOfGlobalMinAvg = 0;
    	}

    	for (int indexOfA = 2; indexOfA <= length; indexOfA++)
    	{
        	for (int j = indexOfA; j < length; j++)
            {
        		int upperSum = prefixSums[j];
        		int lowerSum = prefixSums[j - indexOfA];
            	int currentSum = upperSum - lowerSum;
            	
            	float currentAvg = (float) currentSum / indexOfA;
            	
            	if (currentAvg < globalMinAvg)
            	{
            		globalMinAvg = currentAvg;
            		// System.out.println("updated globalMinAvg : " + globalMinAvg);
            		if (j == indexOfA)
            		{
            			indexOfGlobalMinAvg = indexOfA - 1;
            		}
            		else
            		{
            			indexOfGlobalMinAvg = (j - indexOfA) + 1;
            		}
            		// System.out.println("j : " + j);
            		// System.out.println("indexOfA : " + indexOfA);
            		
            	}
        	}
    	}
    	System.out.println("globalMinAvg : " + globalMinAvg + ", indexOfGlobalMinAvg : " + indexOfGlobalMinAvg);
    }

}

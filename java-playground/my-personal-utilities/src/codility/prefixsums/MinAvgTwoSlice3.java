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
public class MinAvgTwoSlice3 {

    public static void main(String[] args)
    {
    	MinAvgTwoSlice3 classUnderTest = new MinAvgTwoSlice3();
    	
        int[] A = new int[] { 4, 2, 2, 5, 1, 5, 8 };
        classUnderTest.solution(A); // globalMinAvg : 2.0, indexOfGlobalMinAvg : 1
        
        A = new int[] { 4, 2, 2, 5, 1, 5, 8, 1, 3, 9, 1, 1, 7 };
        classUnderTest.solution(A); // globalMinAvg : 1.0, indexOfGlobalMinAvg : 10
        
        A = new int[] { 9 };
        classUnderTest.solution(A); // globalMinAvg : 9.0, indexOfGlobalMinAvg : 0
        
        A = new int[] { };
        classUnderTest.solution(A); // globalMinAvg : 0.0, indexOfGlobalMinAvg : 0
        
    }
    
    /**
     * This follows the "Simplify and Generalize" approach for solving problems.
     */
    
    /**
    *
    	See MinAvgTwoSlice2.java
    	
    	
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
    	                
		See MinAvgTwoSliceProof.pdf for proof.
		
		Every slice must be of size two or three. 
		Slices of bigger sizes are created from such smaller slices. 
		Therefore should any bigger slice have an optimal value, all sub-slices must be the same, for this case to hold true. 
		Should this not be true, one of the sub-slices must be the optimal slice. 
		The others being bigger. 
		Therefore we check all possible slices of size 2 and 3, and return the smallest one. 
		The first such slice is the correct one, do not use <=!
    *
    */
    
    /**
     * 
		About the math behind the solution:
		Let e.g. 
		C denote the avg of a slice of size 5: 
		C=(v+w+x+y+z)/5. 
	     
		And let A and B denote the avg of corresponding slices of size 2 and 3, respectively, i.e., A=(v+w)/2 and B=(x+y+z)/3.
		Simple math shows: C = 0.4*A+0.6*B.
		Claim: it cannot be that C < A and C < B at the same time.

		Proof. Let say this is the case. Then we have 0.4*C < 0.4*A, and 0.6*C < 0.6*B. Summing these two, we get 0.4*C+0.6*C < 0.4*A+0.6*B, or equivalently C < C, which is obviously wrong.
		Therefore, either A <= C or B <= C. But, the algorithm already returns the best of A and B, thus the algorithm is also handling slices of size 5.
		For slices of bigger size, we can reason similarly.
     * 
     */
    
    /**
     * How would you deduce this assertion at first? It is really hard to reason this problem. 
     * What is the process to think of the solution?

    The problem is categorized as "Prefix sums", which is kinda misleading, 
    because the optimal solution does not use prefix sums.
    
    After I realized that, I started brainstorming other solutions. 
    It did not look like a DP problem as it did not have solvable sub-problems; 
    binary search seemed reasonable but O(n) would not work;

    After that I came back to the prefix sums.
    You can easily adapt the average if you know the number of elements, and the previous average (prefix sum).
    From this point on, you can try to find a solution that only adds new elements to an sub-slice if the average gets better, 
    or restarts the sub-slice. 
    Think of the caterpillar method. 
    The method seemed reasonable so I had to define the edge cases, starting with the smallest possible cases (1,2,3). 
    This led to me to realization, that you actually only need to consider slices of length 2 and 3. 
    If a slice of length 1 was allowed, the minimal element would be optimal. 
    Therefore you do not actually need to keep track of the prefix-sum and simplify the solution.
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
	
	   	for (int j = 2; j < length; j++)
		{
			int upperSum = prefixSums[j];
			int lowerSum = prefixSums[j - 2];
			int currentSum = upperSum - lowerSum;
			
			float currentAvg = (float) currentSum / 2;
			
			if (currentAvg < globalMinAvg)
			{
				globalMinAvg = currentAvg;
				// System.out.println("updated globalMinAvg : " + globalMinAvg);
				if (j == 2)
				{
					indexOfGlobalMinAvg = 2 - 1;
				}
				else
				{
					indexOfGlobalMinAvg = (j - 2) + 1;
				}
				// System.out.println("j : " + j);
				// System.out.println("indexOfA : " + indexOfA);
				
			}
		}
	       	
		for (int j = 3; j < length; j++)
		{
			int upperSum = prefixSums[j];
			int lowerSum = prefixSums[j - 3];
			int currentSum = upperSum - lowerSum;
			
			float currentAvg = (float) currentSum / 3;
			
			if (currentAvg < globalMinAvg)
			{
				globalMinAvg = currentAvg;
				// System.out.println("updated globalMinAvg : " + globalMinAvg);
				if (j == 3)
				{
					indexOfGlobalMinAvg = 3 - 1;
				}
				else
				{
					indexOfGlobalMinAvg = (j - 3) + 1;
				}
				// System.out.println("j : " + j);
				// System.out.println("indexOfA : " + indexOfA);
				
			}
		}
		
		System.out.println("globalMinAvg : " + globalMinAvg + ", indexOfGlobalMinAvg : " + indexOfGlobalMinAvg);
	}
}

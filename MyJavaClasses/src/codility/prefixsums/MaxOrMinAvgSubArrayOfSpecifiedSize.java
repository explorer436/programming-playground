package codility.prefixsums;

/**
 * 
Find maximum average subarray of k length

Given an array with positive and negative numbers, find the maximum average subarray of given length.

Example:

Input:  arr[] = {1, 12, -5, -6, 50, 3}, k = 4
Output: Maximum average subarray of length 4 begins
        at index 1.
Maximum average is (12 - 5 - 6 + 50)/4 = 51/4

 */

/**
 * 

Find the subarray with least average

Given an array arr[] of size n and integer k such that k <= n.

Examples :

Input:  arr[] = {3, 7, 90, 20, 10, 50, 40}, k = 3
Output: Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average 
among all subarrays of size 3.

Input:  arr[] = {3, 7, 5, 20, -10, 0, 12}, k = 2
Output: Subarray between [4, 5] has minimum average


 */

public class MaxOrMinAvgSubArrayOfSpecifiedSize {

    public static void main(String[] args)
    {
    	MaxOrMinAvgSubArrayOfSpecifiedSize classUnderTest = new MaxOrMinAvgSubArrayOfSpecifiedSize();
        
    	int[] A;
    	
    	A = new int[] { 1, 12, -5, -6, 50, 3 };        
        classUnderTest.minAvgOfGivenSize(A, 4); // 0.5 starting at index 0
        /*
        classUnderTest.minAvgOfGivenSize_constantSpace(A, 4); // 0.5 starting at index 0
        classUnderTest.maxAvgOfGivenSize(A, 4); // 12.75 starting at index 1
        classUnderTest.maxAvgOfGivenSize_constantSpace(A, 4); // 12.75 starting at index 1
        
        System.out.println();
        
        A = new int[] { 3, 7, 90, 20, 10, 50, 40 };        
        classUnderTest.minAvgOfGivenSize(A, 3); // 26.66 starting at index 3
        classUnderTest.minAvgOfGivenSize_constantSpace(A, 3); // 26.66 starting at index 3
        classUnderTest.maxAvgOfGivenSize(A, 3); // 40 starting at index = 2
        classUnderTest.maxAvgOfGivenSize_constantSpace(A, 3); // 40 starting at index = 2
        
        System.out.println();
        
        A = new int[] { 3, 7, 5, 20, -10, 0, 12 };  
        classUnderTest.minAvgOfGivenSize(A, 2); // -5 starting at position 4
        classUnderTest.minAvgOfGivenSize_constantSpace(A, 2); // -5 starting at position 4
        classUnderTest.maxAvgOfGivenSize(A, 2); // 12.5 starting at index 2
        classUnderTest.maxAvgOfGivenSize_constantSpace(A, 2); // 12.5 starting at index 2
        */
    }
    
    /**
     * Time complexity is O(n) but it requires O(n) auxiliary space.
     * In this scenario, using prefix sums may not be the best approach. 
     * 
     * Create an auxiliary array of size n. 
     * Store cumulative sum of elements in this array. 
     * Let the array be prefixSums[]. 
     * prefixSums[i] stores sum of elements from arr[0] to arr[i]. 
     * Once we have prefixSums[] array with us, we can compute sum between two indexes in O(1) time.
     */
    
    /*
     * A = [1, 12, -5, -6, 50, 3], k = 4
     * prefixSums : [	1	13	8	2	52	55	]
     *                  |___________| 
     *                       |___________| prefixSums[j] - prefixSums[j - k]
     *                          |___________|
     */
    
    public void minAvgOfGivenSize(int[] A, int k)
    {
    	int length = A.length;
    	
    	int[] prefixSums = PrefixSums.prefixSumsOfAnArray(A);
    	
    	// initialize 
    	float globalMinAvg = 0;
    	int indexOfGlobalMinAvg = 0;
    	
    	if (A.length >= k)
    	{
    		globalMinAvg = (float) prefixSums[k - 1] / k;
    		indexOfGlobalMinAvg = 0;
    		
    		for (int j = k; j < length; j++)
            {
        		int upperSum = prefixSums[j];
        		int lowerSum = prefixSums[j - k];
            	int currentSubArrSum = upperSum - lowerSum;
            	
            	float currentSubArrAvg = (float) currentSubArrSum / k;
            	
            	if (currentSubArrAvg < globalMinAvg)
            	{
            		globalMinAvg = currentSubArrAvg;
            		// System.out.println("updated globalMinAvg : " + globalMinAvg);
            		if (j == k)
            		{
            			indexOfGlobalMinAvg = k - 1;
            		}
            		else
            		{
            			indexOfGlobalMinAvg = (j - k) + 1;
            		}
            		// System.out.println("j : " + j);
            		// System.out.println("indexOfA : " + indexOfA);
            	}
        	}
    	}
        	
    	System.out.println("globalMinAvg : " + globalMinAvg);
    	System.out.println("indexOfGlobalMinAvg : " + indexOfGlobalMinAvg);

    }
    
    public void maxAvgOfGivenSize(int[] A, int k)
    {
    	int length = A.length;
    	
    	int[] prefixSums = PrefixSums.prefixSumsOfAnArray(A);
    	
    	// initialize 
    	float globalMaxAvg = 0;
    	int indexOfGlobalMaxAvg = 0;
    	
    	if (A.length >= k)
    	{
    		globalMaxAvg = (float) prefixSums[k - 1] / k;
    		indexOfGlobalMaxAvg = 0;
    		
    		for (int j = k; j < length; j++)
            {
        		int upperSum = prefixSums[j];
        		int lowerSum = prefixSums[j - k];
            	int currentSubArrSum = upperSum - lowerSum;
            	
            	float currentSubArrAvg = (float) currentSubArrSum / k;
            	
            	if (currentSubArrAvg > globalMaxAvg)
            	{
            		globalMaxAvg = currentSubArrAvg;
            		// System.out.println("updated globalMinAvg : " + globalMinAvg);
            		indexOfGlobalMaxAvg = (j - k) + 1;
            		
            		// System.out.println("j : " + j);
            		// System.out.println("indexOfA : " + indexOfA);
            	}
        	}
    	}
        	
    	System.out.println("globalMaxAvg : " + globalMaxAvg);
    	System.out.println("indexOfGlobalMaxAvg : " + indexOfGlobalMaxAvg);

    }
    
    /**
     * 
     * 	1) Initialize indexOfGlobalMinAvg = 0 // Beginning of result index
		2) Find sum of first k elements. Let this sum be 'currentSubArrSum'
		3) Initialize min_sum = sum
		4) Iterate from (k+1)'th to n'th element, do following
		   for every element arr[i]
		      a) currentSubArrSum = currentSubArrSum + arr[i] - arr[i-k]
		      b) If currentSubArrSum < min_sum
		           indexOfGlobalMinAvg = (i-k+1)
		5) Print indexOfGlobalMinAvg and indexOfGlobalMinAvg+k-1 as beginning and ending
		   indexes of resultant subarray.
     * 
     */
    
    /*
     * A = [1, 12, -5, -6, 50, 3], k = 4
     * prefixSums : [	1	13	8	2	52	55	]
     *                  |___________| 
     *                       |___________| currentSubArrSum + A[j] - A[j - k];
     *                          |___________|
     */
    
    public void maxAvgOfGivenSize_constantSpace(int[] A, int k)
    {
    	int length = A.length;
    	
    	// initialize 
    	float globalMaxAvg = 0;
    	int indexOfGlobalMaxAvg = 0;
    	
    	if (A.length >= k)
    	{
    		int currentSubArrSum = 0;
    		for (int index = 0; index < k; index++)
    		{
    			currentSubArrSum = currentSubArrSum + A[index];
    		}
    		globalMaxAvg = (float) currentSubArrSum / k;
    		indexOfGlobalMaxAvg = 0;
    		
    		for (int j = k; j < length; j++)
            {
    			// these two steps can be joined into one.
        		int sumWithNextElementAdded = currentSubArrSum + A[j];
            	currentSubArrSum = sumWithNextElementAdded - A[j - k];
            	
            	float currentSubArrAvg = (float) currentSubArrSum / k;
            	
            	if (currentSubArrAvg > globalMaxAvg)
            	{
            		globalMaxAvg = currentSubArrAvg;
            		indexOfGlobalMaxAvg = (j - k) + 1;
            		
            		// System.out.println("j : " + j);
            		// System.out.println("indexOfA : " + indexOfA);
            		
            	}
        	}
    	}
        	
    	System.out.println("globalMaxAvg : " + globalMaxAvg);
    	System.out.println("indexOfGlobalMaxAvg : " + indexOfGlobalMaxAvg);
    }
    
    public void minAvgOfGivenSize_constantSpace(int[] A, int k)
    {
    	int length = A.length;
    	
    	// initialize 
    	float globalMinAvg = 0;
    	int indexOfGlobalMinAvg = 0;
    	
    	if (A.length >= k)
    	{
    		int currentSubArrSum = 0;
    		for (int index = 0; index < k; index++)
    		{
    			currentSubArrSum = currentSubArrSum + A[index];
    		}
    		globalMinAvg = (float) currentSubArrSum / k;
    		indexOfGlobalMinAvg = 0;
    		
    		for (int j = k; j < length; j++)
            {
    			// these two steps can be joined into one.
        		int sumWithNextElementAdded = currentSubArrSum + A[j];        		
            	currentSubArrSum = sumWithNextElementAdded - A[j - k];
            	
            	float currentSubArrAvg = (float) currentSubArrSum / k;
            	
            	if (currentSubArrAvg < globalMinAvg)
            	{
            		globalMinAvg = currentSubArrAvg;
            		indexOfGlobalMinAvg = (j - k) + 1;
            		
            		// System.out.println("j : " + j);
            		// System.out.println("indexOfA : " + indexOfA);
            		
            	}
        	}
    	}
        	
    	System.out.println("globalMinAvg : " + globalMinAvg);
    	System.out.println("indexOfGlobalMinAvg : " + indexOfGlobalMinAvg);
    }

}

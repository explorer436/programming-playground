package com.my.company.datastructures.arrays;

/**
 * 
	You are given an integer n. Count the total of 1 + 2 + . . . + n.
	
	This is an illustration of time complexity. Read TimeComplexity.pdf
 *
 */
public class SumOfNaturalNumbersUptoN {

	public static void main(String[] args) throws Exception {
		
		int result;
		
		result = sumOfNaturalNumbersUptoN_slow(5);
		// 1 + 2 + 3 + 4 + 5 = 15
		if (result != 15)
		{
			throw new Exception("wrong answer - expected " + 15 + " but received " + result);
		}
		
		
		result = sumOfNaturalNumbersUptoN_fast(5);
		if (result != 15)
		{
			throw new Exception("wrong answer - expected " + 15 + " but received " + result);
		}
		
		System.out.println("done");
	}
	
	// O(n)
	public static int sumOfNaturalNumbersUptoN_slow(int n) {
        int result = 0;
        
        if (n > 0)
        {
        	for (int i = 1; i <= n; i++)
        	{
        		result = result + i;
        	}
        }
        
        return result;
    }
	
	// O(1)
	// Read TimeComplexity.pdf
	public static int sumOfNaturalNumbersUptoN_fast(int n) {
		int result = 0;
		
		if (n > 0)
		{
			return (n * (n + 1))/2;
		}
		
		return result;
    }

}

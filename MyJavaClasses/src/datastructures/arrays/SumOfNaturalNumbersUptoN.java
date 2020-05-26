package datastructures.arrays;

/**
 * 
	You are given an integer n. Count the total of 1 + 2 + . . . + n.
	
	This is an illustration of time complexity. Read TimeComplexity.pdf
 *
 */
public class SumOfNaturalNumbersUptoN {

	public static void main(String[] args) {
		System.out.println("result for input = 5 is : " + sumOfNaturalNumbersUptoN_slow(5));
		// 1 + 2 + 3 + 4 + 5 = 15
		
		System.out.println("result for input = 5 is : " + sumOfNaturalNumbersUptoN_fast(5));
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
	public static int sumOfNaturalNumbersUptoN_fast(int n) {
		int result = 0;
		
		if (n > 0)
		{
			return (n * (n + 1))/2;
		}
		
		return result;
    }

}

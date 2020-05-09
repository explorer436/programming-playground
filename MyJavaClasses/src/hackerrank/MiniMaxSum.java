package hackerrank;

import java.util.Arrays;

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. 
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.

For example, arr = [1,3,5,7,9]. Our minimum sum is 1 + 3 + 5 + 7 = 16 and our maximum sum is 3 + 5 + 7 + 9 = 24. 
We would print
16 24

Function Description

Complete the miniMaxSum function in the editor below. It should print two space-separated integers on one line: the minimum sum and the maximum sum of 4 of 5 elements.

miniMaxSum has the following parameter(s):
    arr: an array of integers 
	
Input Format:
A single line of five space-separated integers.

Constraints:
1 <= arr[i] <= (10 power 9)

Output Format:
Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)

Sample Input
1 2 3 4 5

Sample Output
10 14

Explanation
Our initial numbers are 1,2,3,4 and 5.
We can calculate the following sums using four of the five integers:

1. If we sum everything except 1, our sum is 2 + 3 + 4 + 5 = 14.
2. If we sum everything except 2, our sum is 1 + 3 + 4 + 5 = 13.
3. If we sum everything except 3, our sum is 1 + 2 + 4 + 5 = 12.
4. If we sum everything except 4, our sum is 1 + 2 + 3 + 5 = 11.
5. If we sum everything except 5, our sum is 1 + 2 + 3 + 4 = 10.

Hints: Beware of integer overflow! Use 64-bit Integer
 */

public class MiniMaxSum {
	
	public static void main(String[] args) {
		System.out.println("result for input " + Arrays.toString(new int[] { 1, 2, 3, 4, 5 }) + " is ");
		miniMaxSum(new int[] { 1, 2, 3, 4, 5 });
		
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { 1, 3, 5, 7, 9 }) + " is ");
		miniMaxSum(new int[] { 1, 3, 5, 7, 9 });
		
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { -1, -2, 3, 4, 5 }) + " is ");
		miniMaxSum(new int[] { -1, -2, 3, 4, 5 });

	}
	
	static void miniMaxSum(int[] ar) {
		Integer totalSum = simpleArraySum(ar);
	
		// initialize the values to the opposite extremes.
		Integer maxSum = Integer.MIN_VALUE;
		Integer minSum = Integer.MAX_VALUE;
        
        for (int i : ar)
        {
        	if ((totalSum - i) > maxSum)
        	{
        		maxSum = (totalSum - i);
        	}
        	
        	if ((totalSum - i) < maxSum)
        	{
        		minSum = (totalSum - i);
        	}
        }
        
        System.out.print(minSum + " " + maxSum);

    }
	
	static Integer simpleArraySum(int[] ar) {
		Integer result = 0;
        
        if (ar.length > 0)
        {
        	for (int i : ar)
            result = result + i;	
        }
        
        return result;

    }
    
}
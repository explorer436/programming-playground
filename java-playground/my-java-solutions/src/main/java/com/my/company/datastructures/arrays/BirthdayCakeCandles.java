package com.my.company.datastructures.arrays;

import java.util.Arrays;

/**
	You are in charge of the cake for your niece's birthday and 
	have decided the cake will have one candle for each year of her total age. 
	When she blows out the candles, she’ll only be able to blow out the tallest ones. 
	Your task is to find out how many candles she can successfully blow out.

	For example, if your niece is turning 4 years old, 
	and the cake will have candles of height 4, 4, 1, 3, 
	she will be able to blow out 2 candles successfully, 
	since the tallest candles are of height 4 and there are 2 such candles.
	
	Function Description:
	Complete the function birthdayCakeCandles in the editor below. 
	It must return an integer representing the number of candles she can blow out.
	
	birthdayCakeCandles has the following parameter(s):
	    ar: an array of integers representing candle heights
	
	Input Format:
	The first line contains a single integer, n, denoting the number of candles on the cake.
	The second line contains n space-separated integers, where each integer describes the height of candle i.
	
	Constraints:
	1 <= n <= (10 power 5)
	1 <= ar[i] <= (10 power 7)
	
	Output Format:
	Return the number of candles that can be blown out on a new line.
	
	Sample Input: 
	4
	3 2 1 3
	
	Sample Output: 
	2
	
	Explanation:
	We have one candle of height 1, one candle of height 2, and two candles of height 3. 
	Your niece only blows out the tallest candles, meaning the candles where height=3. 
	Because there are 2 such candles, we print 2 on a new line. 
 
 */

public class BirthdayCakeCandles {
	
	public static void main(String[] args) {
		System.out.println("result for input " + Arrays.toString(new int[] { 3, 2, 1, 3 }) + " is " + birthdayCakeCandles(new int[] { 3, 2, 1, 3 }));
		
		System.out.println();
		
		System.out.println("result for input " + Arrays.toString(new int[] { 4, 4, 1, 3 }) + " is " + birthdayCakeCandles(new int[] { 4, 4, 1, 3 }));
		
		System.out.println();

	}
	
	static int birthdayCakeCandles(int[] ar) {

		Integer highestLengthCandle = ar[0];
		Integer count = 0;
		
		for (int i = 0; i < ar.length; i++)
		{
			if (ar[i] > highestLengthCandle)
			{
				highestLengthCandle = ar[i];
				count = 1;
			}
			else if (ar[i] == highestLengthCandle)
			{
				count = count + 1;
			}
		}
		
		return count;
	}
    
}

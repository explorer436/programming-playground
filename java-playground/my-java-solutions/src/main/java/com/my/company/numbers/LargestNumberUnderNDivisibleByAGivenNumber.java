package com.my.company.numbers;

/** 
* Find the largest number under 100,000 that's divisible by 3829.
*/
public class LargestNumberUnderNDivisibleByAGivenNumber {

	public static void main(String[] args) {
		
		for (int i = 99999; i > 0; i--) 
		{
			if (i % 3829 == 0)
			{
				System.out.println("the answer is " + i);
				break;
			}
		}

	}

}
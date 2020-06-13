package numbers;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
[(-2 power 31),  (2 power 31 - 1)]. 

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println("input is 123 : " + new ReverseInteger().reverse(123)); // 321 	
		System.out.println("input is -123 : " + new ReverseInteger().reverse(-123)); // -321
		System.out.println("input is 120 : " + new ReverseInteger().reverse(120)); //21
		System.out.println("input is Integer.MAX_VALUE : " + new ReverseInteger().reverse(Integer.MAX_VALUE)); //0
		System.out.println("input is Integer.MIN_VALUE : " + new ReverseInteger().reverse(Integer.MIN_VALUE)); //0
		System.out.println("input is 964632435 : " + new ReverseInteger().reverse(964632435)); // 534236469
		System.out.println("input is Integer.MAX_VALUE + 1 : " + new ReverseInteger().reverse(Integer.MAX_VALUE + 1)); // 0
		System.out.println("input is 2147483646 : " + new ReverseInteger().reverse(2147483646)); // 534236469
		
		System.out.println("----------------");
		
		System.out.println("input is 123 : " + new ReverseInteger().reverse2(123)); // 321 	
		System.out.println("input is -123 : " + new ReverseInteger().reverse2(-123)); // -321
		System.out.println("input is 120 : " + new ReverseInteger().reverse2(120)); //21
		System.out.println("input is Integer.MAX_VALUE : " + new ReverseInteger().reverse2(Integer.MAX_VALUE)); //0
		System.out.println("input is Integer.MIN_VALUE : " + new ReverseInteger().reverse2(Integer.MIN_VALUE)); //0
		System.out.println("input is 964632435 : " + new ReverseInteger().reverse2(964632435)); // 534236469
		System.out.println("input is Integer.MAX_VALUE + 1 : " + new ReverseInteger().reverse2(Integer.MAX_VALUE + 1)); // 0
		System.out.println("input is 2147483646 : " + new ReverseInteger().reverse2(2147483646)); // 534236469
	}

	public int reverse(int x) {
		
		int reverse = 0;
		
		boolean isNegative = false;
		if (x < 0)
		{
			isNegative = true;
		}
		
		String initialString = String.valueOf(Math.abs(x));
		
		String reversed = reverseStringUsingByteArray(initialString);
		
		try 
		{
			reverse = Integer.parseInt(reversed);
		} 
		catch (NumberFormatException e) 
		{
		}
		
		if (isNegative)
		{
			reverse = reverse * -1;
		}
		return reverse;
    }
	
	/**
	 * Take a look at StringReversal.java
	 */
	public static String reverseStringUsingByteArray(String input) 
    { 
		String reversedString = null;
		
		if (input != null)
		{
			byte [] strAsByteArray = input.getBytes(); 
			  
	        byte [] result = new byte [strAsByteArray.length]; 
	  
	        // Store result in reverse order into result byte[] 
	        for (int i = 0; i<strAsByteArray.length; i++) 
	        {
	        	result[i] =  
	   	             strAsByteArray[strAsByteArray.length-i-1]; 
	        }
	            
	        reversedString = new String(result);
		}
		
		return reversedString;
    }
	
	/*
	 * This is the solution provided by Leetcode but it looks overly complicated.
	 * If they are returning 0 in overflow and underflow scenarios, why check for all the minute details like unitsPlace?
	 * 
	 * This may be an attempt to solve it without converting the integer to string.
	 */
	public int reverse2(int x) {
		
		int reverse = 0;
		
		while (x != 0)
		{
			int unitsPlace = x % 10;
			x = x/10;
			
			if ((reverse > Integer.MAX_VALUE / 10) || (reverse == Integer.MAX_VALUE / 10 && unitsPlace > 7))
			{
				return 0;
			}
			if ((reverse < Integer.MIN_VALUE / 10) || (reverse == Integer.MAX_VALUE / 10 && unitsPlace < -8))
			{
				return 0;
			}
			
			reverse = (reverse * 10) + unitsPlace;
		}
		
		return reverse;
    }

}

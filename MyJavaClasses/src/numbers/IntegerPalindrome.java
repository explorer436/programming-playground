package numbers;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:

TODO
Coud you solve it without converting the integer to a string?

 *
 */
public class IntegerPalindrome {

	public static void main(String[] args) {
		System.out.println((new IntegerPalindrome()).isPalindrome(121));
		System.out.println((new IntegerPalindrome()).isPalindrome(-121));
		System.out.println((new IntegerPalindrome()).isPalindrome(10));

	}
	
	public boolean isPalindrome(int x) {
		
		if (x < 0)
		{
			return false;
		}
		
		String initialIntInStringForm = String.valueOf(x);
		
		if (initialIntInStringForm.equals(reverseStringUsingByteArray(initialIntInStringForm)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
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

}

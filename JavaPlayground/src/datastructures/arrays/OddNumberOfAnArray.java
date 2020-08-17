package datastructures.arrays;

/*
 * 

A non-empty array A consisting of N integers is given. 
The array contains an odd number of elements, and 
each element of the array can be paired with another element that has the same value, 
except for one element that is left unpaired.

For example, in array A such that:
  A[0] = 9  
  A[1] = 3  
  A[2] = 9
  A[3] = 3  
  A[4] = 9  
  A[5] = 7
  A[6] = 9

        the elements at indexes 0 and 2 have value 9,
        the elements at indexes 1 and 3 have value 3,
        the elements at indexes 4 and 6 have value 9,
        the element at index 5 has value 7 and is unpaired.

Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, 
returns the value of the unpaired element.

For example, given array A such that:
  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9

the function should return 7, as explained in the example above.

Write an efficient algorithm for the following assumptions:

        N is an odd integer within the range [1..1,000,000];
        each element of array A is an integer within the range [1..1,000,000,000];
        all but one of the values in A occur an even number of times.


 */
public class OddNumberOfAnArray
{
	public static void main(String[] args)
	{
		System.out.println("starting test class");

		OddNumberOfAnArray classUnderTest = new OddNumberOfAnArray();

		System.out.println("The odd number in the array { 9, 3, 9, 3, 9, 7, 9 } is : " + classUnderTest.findOddNumberInTheArray(new int[] { 9, 3, 9, 3, 9, 7, 9 }));

		System.out.println("The odd number in the array { 1 } is : " + classUnderTest.findOddNumberInTheArray(new int[] { 1 }));
		
		System.out.println("The odd number in the array { } is : " + classUnderTest.findOddNumberInTheArray(new int[] { }));
		
		System.out.println("Is there an odd number in the array { 9, 3, 9, 3, 9, 7, 9 }) : " + classUnderTest.isThereAnOddNumberInTheArray(new int[] { 9, 3, 9, 3, 9, 7, 9 }));

		System.out.println("Is there an odd number in the array { 1 } : " + classUnderTest.isThereAnOddNumberInTheArray(new int[] { 1 }));
		
		System.out.println("Is there an odd number in the array { 1, 2, 1, 2 } : " + classUnderTest.isThereAnOddNumberInTheArray(new int[] { 1, 2, 1, 2 }));
		
		System.out.println("Is there an odd number in the array { } : " + classUnderTest.isThereAnOddNumberInTheArray(new int[] { }));

	}

	/**
	 * 
	    "^" - bitwise exclusive OR
	        - bitwise XOR
	    It tells whether there is an odd number of 1 bits 
	    (A XOR B XOR C XOR D XOR E} is true iff an odd number of the variables are true).    
	   
	    Bits for 0 - 0000
	    Bits for 9 - 1001
	    Bits for 3 - 0011
	    Bits for 7 - 0111
	  
	    XOR on 0 and { 9, 3, 9, 3, 9, 7, 9 }
	    
	    XOR on 0 and 9 - 0000
	                     1001
	                     ----
	                     1001
	                     
	    XOR on 1001 and 3 - 1001
	                        0011
	                        ----
	                        1010 
	                        
	    XOR on 1010 and 9 - 1010
	                        1001
	                        ----
	                        0011 
	                        
	    XOR on 0011 and 3 - 0011
	                        0011
	                        ----
	                        0000
	                        
	    XOR on 0000 and 9 - 0000
	                        1001
	                        ----
	                        1001  
	                        
	    XOR on 1001 and 7 - 1001
	                        0111
	                        ----
	                        1110
	                        
	    XOR on 0000 and 9 - 1110
	                        1001
	                        ----
	                        0111   - this evaluates to 7   
	                        
	                                                                                
	                                                                                
	 */
	
	/*
	 * return the odd number
	 */
	public int findOddNumberInTheArray(int[] A)
	{
		int result = 0;
		for (int x : A)
		{
			result ^= x;
		}
		return result;
	}
	
	/*
	 * return true or false
	 */
	public boolean isThereAnOddNumberInTheArray(int[] A)
	{
		int xorResult = 0;
		for (int x : A)
		{
			xorResult ^= x;
		}
		
		return xorResult != 0;
	}

}

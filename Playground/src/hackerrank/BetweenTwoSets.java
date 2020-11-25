package hackerrank;

import java.util.Arrays;
import java.util.List;

import numbers.GCDOfNumbersInAnArray;
import numbers.LCMOfNumbersInAnArray;

/**
 *
    You will be given two arrays of integers and asked to determine all integers that satisfy the following two
    conditions:
    1. The elements of the first array are all factors of the integer being considered
    2. The integer being considered is a factor of all elements of the second array
    
    These numbers are referred to as being between the two arrays. You must determine how many such
    numbers exist.
    
    For example, given the arrays a = [2, 6] and b = [24, 36], there are two numbers between them: 6 and 12.
    6 % 2 = 0,
    6 % 6 = 0,
    24 % 6 = 0 and 
    36 % 6 = 0 for the first value. 
    
    Similarly, 
    12 % 2 = 0,
    12 % 6 = 0 and
    24 % 12 = 0,
    36 % 12 = 0.
    
    Function Description
    
    Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.
    getTotalX has the following parameter(s):
        * a: an array of integers
        * b: an array of integers
    
    Input Format
    
    The first line contains two space-separated integers, n and m, the number of elements in array a and the number of elements in array b.
    
    The second line contains n distinct space-separated integers describing a[i] where 0 <= i < n.
    The third line contains m distinct space-separated integers describing b[j] where 0 <= j < m.
    
    Constraints
      * 1 <= n, m <= 10
      * 1 <= a[i] <= 100
      * 1 <= b[j] <= 100
    
    
    Output Format
    
    Print the number of integers that are considered to be between a and b.
    
    Sample Input
    
    2 3
    2 4
    16 32 96
    
    Sample Output
    3
    
    Explanation
    2 and 4 divide evenly into 4, 8, 12 and 16.
    4, 8 and 16 divide evenly into 16, 32, 96.
    4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all
    elements of b.
    
   This is an interesting problem that introduces us to 
   many concepts like LCM, GCD,
   calculating LCM of two numbers, calculating LCM of an array or numbers,
   calculating GCD of two numbers, calculating GCD of an array or numbers, 
   (using Stream API in java).
 *
 */


/**
 *  
   This is an interesting problem that introduces us to 
   many concepts like LCM, GCD,
   calculating LCM of two numbers, calculating LCM of an array or numbers,
   calculating GCD of two numbers, calculating GCD of an array or numbers, 
   (using Stream API in java).
 *
 */
public class BetweenTwoSets {

	public static void main(String[] args) {
		
		Integer[] a;
		Integer[] b;
		
		a = new Integer[] { 2, 4 };
		b = new Integer[] { 16, 32, 96 };
		System.out.println(getTotalX(Arrays.asList(a), Arrays.asList(b)));
		
		System.out.println();
		
		a = new Integer[] { 2, 6 };
		b = new Integer[] { 24, 36 };
		System.out.println(getTotalX(Arrays.asList(a), Arrays.asList(b)));
		
		System.out.println();
		
		a = new Integer[] { 0, 2, 6 };
		b = new Integer[] { 24, 36 };
		System.out.println(getTotalX(Arrays.asList(a), Arrays.asList(b)));
		
		System.out.println();
		
		a = new Integer[] { 2, 6 };
		b = new Integer[] { 0, 24, 36 };
		System.out.println(getTotalX(Arrays.asList(a), Arrays.asList(b)));
		
		System.out.println();
		
		a = new Integer[] { 1 };
		b = new Integer[] { 100 };
		// Expected answer = 9.
		System.out.println(getTotalX(Arrays.asList(a), Arrays.asList(b)));
	}
	
	public static int getTotalX(List<Integer> a, List<Integer> b) {
		
		if (a.contains(0))
		{
			return 0;
		}
		
		int lcmOfA = LCMOfNumbersInAnArray.getLcm(a);
		System.out.println("lcmOfA : " + lcmOfA);
		
		int gcdOfB = GCDOfNumbersInAnArray.getGcd(b);
		System.out.println("gcdOfB : " + gcdOfB);
		
		int count = 0;
		/**
		 * We have to run a multiplication table on lcmOfA as long it is less than or equal to the first element of array B.
		 */
		for (int i = 1; i <= b.get(0); i++)
		{
			int lcmOfAMultiple = i * lcmOfA;
			
			if (lcmOfAMultiple <= gcdOfB && gcdOfB % lcmOfAMultiple == 0)
			{
				count = count + 1;
			}
			else if (lcmOfAMultiple > gcdOfB)
			{
				// time to break out of the loop.
				break;
			}
		}
		
		return count;
	}

}

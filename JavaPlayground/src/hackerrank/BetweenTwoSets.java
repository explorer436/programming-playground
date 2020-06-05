package hackerrank;

import java.util.Arrays;
import java.util.List;

import numbers.GCDOfNumbersInAnArray;
import numbers.LCMOfNumbersInAnArray;

/**
 * This is an interesting problem that introduces us to 
 * many concepts like LCM, GCD,
 * calculating LCM of two numbers, calculating LCM of an array or numbers,
 * calculating GCD of two numbers, calculating GCD of an array or numbers, 
 * (using Stream API in java).
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

package numbers;

/**
 * In mathematics, the greatest common divisor (gcd) of two or more integers, 
 * which are not all zero, is the largest positive integer that divides each of the integers. 
 * 
 * For example, the gcd of 8 and 12 is 4.
 */
public class GCDOfTwoNumbersUsingEuclideanAlgorithm {

	public static void main(String[] args) {
		System.out.println("GCD of 12 and 18 is : " + gcd(12, 18));
		
		System.out.println("GCD of 8 and 12 is : " + gcd(8, 12));
	}
	
	/**
	 * Recursive implementation of the Euclidean algorithm:
	 */
	public static int gcd(int number1, int number2) {
	    if (number1 == 0 || number2 == 0) {
	        return number1 + number2;
	    } else {
	        int absNumber1 = Math.abs(number1);
	        int absNumber2 = Math.abs(number2);
	        int biggerValue = Math.max(absNumber1, absNumber2);
	        int smallerValue = Math.min(absNumber1, absNumber2);
	        return gcd(biggerValue % smallerValue, smallerValue);
	    }
	}

}

package com.my.company.numbers;

import java.math.BigInteger;

/**
   In mathematics, the greatest common divisor (gcd) of two or more integers, 
   which are not all zero, is the largest positive integer that divides each of the integers. 
   
   For example, the gcd of 8 and 12 is 4.
 */
public class GCDOfTwoNumbersUsingEuclideanAlgorithm {

	public static void main(String[] args) {
		System.out.println("GCD of 12 and 18 is : " + gcd(12, 18));

		System.out.println("GCD of 12 and 0 is : " + gcd(12, 0));
		
		System.out.println("GCD of 8 and 12 is : " + gcd(8, 12));
		
		System.out.println("GCD of 8 and 12 is : " + gcdOfBigIntegers(new BigInteger("8"), new BigInteger("12")));
	}
	
	/**
	   REMEMBER
	   
	   Euclidean algorithm:
	   Discovered by Euclid in the mid 4th century BC, it is referred to as the world's oldest algorithm.
	   
	   This uses a recursive implementation based on the fact that the gcd of two numbers also divides their difference.
	   
	   Algorithm : 
	   gcd(a,0) = a
	   gcd ( a , b ) = gcd ( b , a mod b ) 
	   
	   Example :
	   Consider the two numbers : 1112 and 695
	   
	   With the usual method, we factorize the two numbers into prime numbers and find the greatest common divisor from the prime numbers they share.
	   1112 = 139 * 2 * 2 * 2
	   695  = 139 * 5
	   ----------------------
	   GCD  = 139
	   ----------------------
	   However, with this method, the larger the two numbers get, the more difficult the prime factorization becomes.
	   
	   With Euclidean algorithm, it is easier to find the GCD more efficiently.
	   
	   step 1 : find the remainder of the larger number divided by the smaller number.
	   1112 mod 695 = 417
	   
	   step 2 : do a mod operation with the previous divisor, 695, and the previous remainder, 417.
	   695 mod 417 = 278
	   
	   step 3 : repeat the same operation, carrying out a mod operation with 417 and 278.
	   417 mod 278 = 139
	   
	   step 4 : repeat the same operation, carrying out a mod operation with 278 and 139.
	   278 mod 139 = 0
	   In other words, 278 is divisibly by 139.
	   When the remainder is 0, the divisor of the last operation, 139, is the GCD of 1112 and 695.
	   
	   Expressing this in terms of bar length : 
	   
	   -
	   |
	   |
	   |            -
	   |            |
	   |            |
	   |            |
	   |            |
	   |            |
	   -            -
	   1112         695

	   We will add segments in increments of n, the GCD. Since we already know that 139 is the GCD for these two numbers, for convenience, 1112 was given 8 segments and 695 was given 5 segments. However, if we do not know the GCD before, we do not know how many segments each of these numbers will have. However, we do know that both 1112 and 695 are multiples of GCD.

	   -
	   |
	   -
	   |
	   -
	   |
	   -            -
	   |            |
	   -            -
	   |            |
	   -            -
	   |            |
	   -            -
	   |            |
	   -            -                -------------
	   |            |                segment = GCD
	   -            -                -------------
	   1112         695

	   Here, we will find the remainder of the larger number divided by the smaller number.

	   -                                             -
	   |                                             |
	   -                                             -
	   |                     remainder =>            |    (the remainder is 417)
	   -                                             -
	   |                                             |
	   -            -                                -
	   |            |
	   -            -
	   |            |
	   -            -        
	   |            |
	   -            -
	   |            |
	   -            -
	   |            |
	   -            -
	   1112         695

	   Repeat the mod operation : 
	   -                                -
	   |
	   -
	   |
	   -                -
	   |                |
	   -                -                              -
	   |       mod      |          remainder =>        |
	   -                -                              -
	   |                |                              |
	   -                -                              -
	   695             417                            278

	   Repeat the mod operation : 
	   -
	   |
	   -                -                              
	   |                |
	   -                -                              -
	   |       mod      |          remainder =>        |
	   -                -                              -
	   417             278                            139

	   Repeat the mod operation : 
	   -                                              
	   |                
	   -                -
	   |       mod      |          remainder =>        0    -> It is here that we learn that GCD = 139.
	   -                -
	  278             139

	  This is how Euclidean algorithm is able to find the GCD by simply repeating divisions.
	  A big advantage is that even if the two target numbers are huge, the algorithm is able to find the GCD with the standard procedure.

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
	
	/**
	   The binary GCD algorithm, also known as Stein's algorithm, 
	   is an algorithm that computes the greatest common divisor of two non negative integers. 
	   Stein's algorithm uses simpler arithmetic operations than the conventional Euclidean algorithm; 
	   it replaces division with arithmetic shifts, comparisons, and subtraction. 
	   Although the algorithm was first published by the Israeli physicist and programmer Josef Stein in 1967, it may have been known in 1st-century China.
	   
	   Algorithm :
	   The algorithm reduces the problem of finding the GCD by repeatedly applying these identities:
	   
	   1. gcd(0, v) = v, because everything divides zero, and v is the largest number that divides v. 
	   	  Similarly, gcd(u, 0) = u. gcd(0, 0) is not typically defined, but it is convenient to set gcd(0, 0) = 0.
	   
	   2. If u and v are both even, then gcd(u, v) = 2·gcd(u/2, v/2), because 2 is a common divisor.
	   
	   3. If u is even and v is odd, then gcd(u, v) = gcd(u/2, v), because 2 is not a common divisor. 
	      Similarly, if u is odd and v is even, then gcd(u, v) = gcd(u, v/2).
	      
	   4. If u and v are both odd, and u ≥ v, then gcd(u, v) = gcd((u − v)/2, v). 
	      If both are odd and u < v, then gcd(u, v) = gcd((v − u)/2, u). 
	      These are combinations of one step of the simple Euclidean algorithm, which uses subtraction at each step, and an application of step 3 above. 
	      The division by 2 results in an integer because the difference of two odd numbers is even.
	      
	   5. Repeat steps 2–4 until u = v, or (one more step) until u = 0. 
	      In either case, the GCD is 2kv, where k is the number of common factors of 2 found in step 2.
	      
	   The algorithm requires O(n2) worst-case time, where n is the number of bits in the larger of the two numbers. 
	   Although each step reduces at least one of the operands by at least a factor of 2, 
	   the subtract and shift operations take linear time for very large integers 
	   (although they're still quite fast in practice, requiring about one operation per word of the representation).
	 */
	public static BigInteger gcdOfBigIntegers(BigInteger number1, BigInteger number2) {
		return number1.gcd(number2);
	}
	
	/**
	   TODO
	   Look at the recursive and iterative implementations in C here : https://en.wikipedia.org/wiki/Binary_GCD_algorithm
	   Implement them in java. 
	 */
	
	/**
	   From : https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/math/BigInteger.java
	   
       Returns a BigInteger whose value is the greatest common divisor of
       {@code abs(this)} and {@code abs(val)}.  Returns 0 if
       {@code this == 0 && val == 0}.
      
       @param  val value with which the GCD is to be computed.
       @return {@code GCD(abs(this), abs(val))}
     */
    /*public BigInteger gcd(BigInteger val) {
        if (val.signum() == 0)
            return this.abs();
        else if (this.signum == 0)
            return val.abs();

        MutableBigInteger a = new MutableBigInteger(this);
        MutableBigInteger b = new MutableBigInteger(val);

        MutableBigInteger result = a.hybridGCD(b);

        return result.toBigInteger(1);
    }*/
	
	/**
	   From : https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/math/MutableBigInteger.java
       Calculate GCD of this and b. This and b are changed by the computation.
     */
    /*MutableBigInteger hybridGCD(MutableBigInteger b) {
        // Use Euclid's algorithm until the numbers are approximately the
        // same length, then use the binary GCD algorithm to find the GCD.
        MutableBigInteger a = this;
        MutableBigInteger q = new MutableBigInteger();

        while (b.intLen != 0) {
            if (Math.abs(a.intLen - b.intLen) < 2)
                return a.binaryGCD(b);

            MutableBigInteger r = a.divide(b, q);
            a = b;
            b = r;
        }
        return a;
    }*/

}

package numbers;

import java.util.Arrays;

public class LCMOfNumbersInAnArray {

	public static void main(String[] args) {
		
		int[] nums = new int[] { 2, 4 };		
		System.out.println("LCM of all elements of the array " + Arrays.toString(nums) + " calculated using stream reduce is " + getLcm(nums));
		
		nums = new int[] { 2, 6 };		
		System.out.println("LCM of all elements of the array " + Arrays.toString(nums) + " calculated using stream reduce is " + getLcm(nums));

	}
	
	public static int getLcm(int[] A)
	{
		Integer lcmOfAllElementsOfAnArrayCalculatedUsingStreamReduce = Arrays.stream(A)
				   .reduce(
				       1,
				       (a, b) -> LCMOfTwoNumbers.lcmUsingEuclideanAlgorithm(a, b));
		
		return lcmOfAllElementsOfAnArrayCalculatedUsingStreamReduce;
	}

}

package datastructures.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utility.ArrayUtils;

/**
 * Given an array containing positive and negative integers, 
 * 
 * how to move all the negative integers to the left side of the array?
 * 
 * how to get a count of the total number or negative integers in the array?

 * how to get a count of the total number or positive integers in the array? (length - total number of negative integers)
 *
 */
public class MoveNegativeElementsToTheLeft
{

	public static void main(String[] args)
	{
		int[] A = { 4, 1, 3, 2, -5, -1 };
		
		int numberOfNegativeIntegersInArray = moveNegativeElementsToTheLeft(A);
		System.out.println("number of negative elements in the array " + Arrays.toString(A)+ " is : " + numberOfNegativeIntegersInArray);
		System.out.println("array after moving negative elements to the left : " + Arrays.toString(A));
		
		System.out.println("result after skipping " + numberOfNegativeIntegersInArray + " elements from the beginning of the array ");
		System.out.println(Arrays.toString(A) + " is ");
		DropFirstNElementsOfAnArray.skipFirstKElementsOfArray(A, numberOfNegativeIntegersInArray);
	}

	public static int moveNegativeElementsToTheLeft(int[] A)
	{
		int j = 0;
		
		for (int index = 0; index < A.length; index++)
		{
			if (A[index] < 0)
			{
				ArrayUtils.swap(A, index, j);
				j++;
			}
		}
		
		return j;
	}

}
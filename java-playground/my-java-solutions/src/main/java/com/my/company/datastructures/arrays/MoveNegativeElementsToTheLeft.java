package com.my.company.datastructures.arrays;

import java.util.Arrays;

import com.my.company.utility.ArrayUtils;

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
		
		moveNegativeElementsToTheLeft(A);
	}

	/*
	 * 
	 * 	4	1	3	2	-5	-1
	 *  |________________| because numberOfNegativeIntegersInArray = 0
	 *  	|________________| because numberOfNegativeIntegersInArray = 1
	 */
	public static void moveNegativeElementsToTheLeft(int[] A)
	{
		int numberOfNegativeIntegersInArray = 0;
		
		for (int index = 0; index < A.length; index++)
		{
			if (A[index] < 0)
			{
				ArrayUtils.swap(A, index, numberOfNegativeIntegersInArray);
				numberOfNegativeIntegersInArray++;
			}
		}
		
		// if you need the total number of negative elements in the array, return this.
		System.out.println("number of negative elements in the array " + Arrays.toString(A)+ " is : " + numberOfNegativeIntegersInArray);
		
		// if you need the array after moving the negative elements to the left of the array, return this.
		System.out.println("array after moving negative elements to the left : " + Arrays.toString(A));
		
		/*
		 * skipping the first n number of elements in an array using streams.
		 */
		System.out.println("result after skipping " + numberOfNegativeIntegersInArray + 
			" elements from the beginning of the array is ");
		DropFirstNElementsOfAnArray.skipFirstKElementsOfArray(A, numberOfNegativeIntegersInArray);
	}

}
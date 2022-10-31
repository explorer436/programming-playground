package com.my.company.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.my.company.utility.PrintUtils;

public class BucketSort {

	public static void main(String[] args) {
		int[] intArray = new int[] { 54, 46, 83, 66, 95, 92, 43 };
		System.out.println("--------before sorting-----------");
		PrintUtils.printArray(intArray);
		
		bucketSort(intArray);
		
		System.out.println("--------after sorting-----------");
		PrintUtils.printArray(intArray);

	}
	
	public static void bucketSort(int[] input)
	{
		// create buckets
		List<Integer>[] buckets = new List[10];
		
		for (int i = 0; i < buckets.length; i++) {
			// alternatively, use LinkedLists.
			buckets[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < input.length; i++) {
			buckets[hash(input[i])].add(input[i]);
		}
		
		for (List bucket : buckets)
		{
			Collections.sort(bucket);
		}
		
		int j = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int value : buckets[i]) {
				input[j++] = value;
			}
		}
	}
	
	private static int hash(int value)
	{
		return (value / (int) 10) % 10;
	}

}

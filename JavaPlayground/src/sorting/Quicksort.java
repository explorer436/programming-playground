package sorting;

import utility.PrintUtils;

public class Quicksort {
	// TODO
	
	public static void main(String[] args) {
		
		Integer[] intArray = new Integer[] { 5, 7, 0, 3, 4, 2, 6, 1 };
		System.out.println("--------before sorting-----------");
		PrintUtils.printArray(intArray);
		quickSort(intArray, 0, intArray.length);
		System.out.println("---------printing the sorted list------------");
		PrintUtils.printArray(intArray);
		
		
		System.out.println();
		
		String[] strArray = new String[] { "ghi", "abc", "def" };		
		System.out.println("--------before sorting-----------");
		PrintUtils.printArray(strArray);
		quickSort(strArray, 0, strArray.length);
		System.out.println("---------printing the sorted list------------");
		PrintUtils.printArray(strArray);
	}
	
	public static void quickSort(Comparable[] a, int beginning, int ending)
	{
		// one element arrays.
		if (ending - beginning < 2)
		{
			return;
		}
		
		int pivotIndex = partition(a, beginning, ending);
		
		quickSort(a, beginning, pivotIndex);
		quickSort(a, pivotIndex + 1, ending);
	}
	
	public static int partition(Comparable[] a, int beginning, int ending)
	{
		// this uses the first element of a as the pivot.
		
		Comparable pivot = a[beginning];
		
		// i will be traversing from left to right and j will be traversion from right to left.
		int i = beginning;
		int j = ending;
		
		// when i and j cross each other, the traversal should stop.
		while (i < j)
		{
			// we are going to use j to look for elements that are less than the pivot.
			// empty loop body - we are not doing anything in the body of the loop.
			// it's purpose is to keep decrementing j until we find an element that is lesser than the pivot.
			while (i < j && a[--j].compareTo(pivot) >= 0)
			{
				
			}
			// if we fall out of the loop above, it means that we found an element that is lesser than the pivot.
			// in that case, move the element at j to location i.
			if (i < j)
			{
				a[i] = a[j];
			}
			
			// now, we are going to use i to look for elements that are greater than the pivot.
			// empty loop body - we are not doing anything in the body of the loop.
			// it's purpose is to keep incrementing i until we find an element that is greater than the pivot.
			while (i < j && a[++i].compareTo(pivot) <= 0)
			{

			}
			// if we fall out of the loop above, it means that we found an element that is greater than the pivot.
			// in that case, move the element at i to location j.
			if (i < j)
			{
				a[j] = a[i];
			}
		}
		// when we drop out of the while loop above, it means that i crossed j.
		// at this point, j is the index where we want to insert the pivot.
		a[j] = pivot;
		
		// we need to return the index where we inserted the pivot.
		return j;
	}
}

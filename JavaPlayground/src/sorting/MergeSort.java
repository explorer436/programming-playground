package sorting;

import utility.PrintUtils;

/**
 * Mergesort guarantees to sort an array of N items in time proportional to N log N, no matter what the input. 
 * Its prime disadvantage is that it uses extra space proportional to N.
 */
public class MergeSort {
    
	public static void main(String[] args) {
		Integer[] intArray;

	    intArray = new Integer[] { -1, 0, -2 };
	    System.out.println("--------before sorting-----------");
	    PrintUtils.printArray(intArray);
	    sort(intArray, 0, intArray.length);
	    System.out.println("---------printing the sorted list------------");
	    PrintUtils.printArray(intArray);
	    
	    System.out.println();
	    
	    intArray = new Integer[] { 1, 3, 7, 2, 5 };
	    System.out.println("--------before sorting-----------");
	    PrintUtils.printArray(intArray);
	    sort(intArray, 0, intArray.length);
	    System.out.println("---------printing the sorted list------------");
	    PrintUtils.printArray(intArray);
	    
	    System.out.println();

	    intArray = new Integer[] { 5 };
	    System.out.println("--------before sorting-----------");
	    PrintUtils.printArray(intArray);
	    sort(intArray, 0, intArray.length);
	    System.out.println("---------printing the sorted list------------");
	    PrintUtils.printArray(intArray);
	    
	    System.out.println();

	    intArray = new Integer[] {};
	    System.out.println("--------before sorting-----------");
	    PrintUtils.printArray(intArray);
	    sort(intArray, 0, intArray.length);
	    System.out.println("---------printing the sorted list------------");
	    PrintUtils.printArray(intArray);
	    
	    System.out.println();
	    
	    String[] strArray = new String[] { "ghi", "abc", "def" };		
		System.out.println("--------before sorting-----------");
		PrintUtils.printArray(strArray);
		sort(strArray, 0, strArray.length);
		System.out.println("---------printing the sorted list------------");
		PrintUtils.printArray(strArray);
	}
    
	/**
	 * the partitioning part is logical partitioning - meaning, we will not be creating any new arrays. 
	 * instead, we will just be using the arrays to keep track of the sub arrays.
	 * 
	 */
    public static void sort(Comparable[] a, int beginning, int ending)
    {
    	if (null != a)
    	{
    		// breaking condition for the recursion
    		// in our case, we need to break out on one element arrays - one element arrays are already sorted.
    		if (ending - beginning < 2)
        	{
        		return;
        	}
        	else
        	{
        		// this is the partitioning part of the recursion. the array is divided into two parts until the size of each of the parts is 1.
        		int mid = (ending + beginning) / 2;        		
        		// mid = (0 + 5) / 2 = 2
        		
        		// TODO this part is confusing. why is this not mid and mid -1 or mid + 1?
        		sort(a, 0, mid);
        		sort(a, mid, ending);
        		
        		merge(a, beginning, mid, ending);
        	}
    	}
    }
    
    public static void merge(Comparable[] a, int beginning, int mid, int ending)
    {
    	// if the last element from the left array is lower than the first element from the right array, there is no need to do anything.
    	if (a[mid - 1].compareTo(a[mid]) < 0)
    	{
    		return;
    	}
    	else
    	{
    		int i = beginning;
    		int j = mid;
    		int tempIndex = 0;
    		
    		Comparable[] temp = new Comparable[ending - beginning];
    		
    		// drop out as soon as we finish traversing the left array or the right array.
    		while (i < mid && j < ending)
    		{
    			temp[tempIndex++] = (a[i].compareTo(a[j]) <= 0) ? a[i++] : a[j++];
    		}
    		
    		// after we drop out of the while loop, we need to handle the leftover elements that are either in left array or in the right array.
    		
    		// TODO write detailed explanations for this.
    		
    		// if we have elements left over in the left array, we need to copy them over.
    		// but if we have elements left over in the right array, we don't have to do anything.
    		// that is because, they are already in the correct positions.
    		System.arraycopy(a, i, a, beginning + tempIndex, mid - i);
    		
    		System.arraycopy(temp, 0, a, beginning, tempIndex);
    	}
    }
}
package sorting;

import utility.ArrayUtils;
import utility.PrintUtils;

/**
 * Selection sort: 
 * One of the simplest sorting algorithms works as follows:
 * 
 * First, find the smallest item in the array, and exchange it with the first
 * entry. Then, find the next smallest item and exchange it with the second
 * entry. Continue in this way until the entire array is sorted. This method is
 * called selection sort because it works by repeatedly selecting the smallest
 * remaining item.
 * 
 */
public class SelectionSort {
   public static void main(String[] args) {
    
    Integer[] intArray;

    intArray = new Integer[] { -1, 0, -2 };
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    sort(intArray);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);
    
    intArray = new Integer[] { 1, 3, 7, 2, 5 };
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    sort(intArray);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);

    intArray = new Integer[] { 5 };
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    sort(intArray);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);

    intArray = new Integer[] {};
    System.out.println("--------before sorting-----------");
    PrintUtils.printArray(intArray);
    sort(intArray);
    System.out.println("---------printing the sorted list------------");
    PrintUtils.printArray(intArray);

   } 

    public static void sort(Comparable[] A)
    {
        if (null != A)
        {
            for (int index = 0; index < A.length; index++)
            {
                // grab the first element from the subarray
                int min = index;

                for (int j = min + 1; j < A.length; j++)
                {
                    // starting with the next element, compare each element and if it is smaller, exchange them.
                    if (A[index].compareTo(A[j]) > 0)
                    {
                        ArrayUtils.exch(A, index, j);
                    }
                }
            }
        }
    }
}

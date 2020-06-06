package sorting;

import utility.ArrayUtils;
import utility.PrintUtils;

/**
 * Selection sort uses ~n2/2 compares and n exchanges to sort an array of length n. 
 * 
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


   /*   
        Animation of selection sort in action:

        In each step, the smallest element in the unsorted section is highlighted. 
        That element is swapped with the first element in the unsorted section.

        S    E   L   E   |C|   T   I   O   N   S   O   R   T
        --|             
        C | |E|  L   E    S    T   I   O   N   S   O   R   T
          -----|
        C    E | L  |E|   S    T   I   O   N   S   O   R   T
               -----|
        C    E   E  |L    S    T  |I|  O   N   S   O   R   T
                    ----|
        C    E   E   I  | S    T  |L|  O   N   S   O   R   T
                        ----|
        C    E   E   I    L |  T   S   O  |N|  S   O   R   T
                            -----|
        C    E   E   I    S    N | S  |O|  T   S   O   R   T
                                 ----|
        C    E   E   I    S    N   O | S   T   S  |O|  R   T
                                     ----|
        C    E   E   I    S    N   O   O | T   S   S  |R|  T
                                         ----|
        C    E   E   I    S    N   O   O   R ||S|  S   T   T
                                             ----|
        C    E   E   I    S    N   O   O   R   S ||S|  T   T
                                                 ----|
        C    E   E   I    S    N   O   O   R   S   S ||T|  T
                                                     ----|
        C    E   E   I    S    N   O   O   R   S   S   T ||T|
                                                         ----|
        C    E   E   I    S    N   O   O   R   S   S   T   T |
   */
    public static void sort(Comparable[] A)
    {
        if (null != A)
        {
            for (int index = 0; index < A.length; index++)
            {
                // grab the index of the first element from the subarray A[index..length]
                int min = index;

                for (int j = min + 1; j < A.length; j++)
                {
                    // starting with the next element from min, compare each element with the element at min 
                    // and if it is smaller, exchange them.
                    if (A[min].compareTo(A[j]) > 0)
                    {
                        ArrayUtils.exch(A, index, j);
                    }
                }
            }
        }
    }
}

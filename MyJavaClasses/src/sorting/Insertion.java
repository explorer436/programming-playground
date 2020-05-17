package sorting;

import utility.ArrayUtils;

/*
 * Example:   
 * The following table shows the sorting steps for sorting the sequence 5 7 0 3 4 2 6 1.
 * On the left side, in green, is the already sorted part of the sequence. 
 * On the far right is the number of positions in parentheses around which 
 * the inserted element has moved to the left.

5	7	0	3	4	2	6	1	 	(0)
5	7	0	3	4	2	6	1	 	(0)
0	5	7	3	4	2	6	1	 	(2)
0	3	5	7	4	2	6	1	 	(2)
0	3	4	5	7	2	6	1	 	(2)
0	2	3	4	5	7	6	1	 	(4)
0	2	3	4	5	6	7	1	 	(1)
0	1	2	3	4	5	6	7	 	(6)

 */
public class Insertion
{

	public static void sort(Comparable[] a)
	{
		int length = a.length;
		
		for (int i = 1; i < length; i++)
		{
			System.out.println("\t i loop - i = " + i);
			for (int j = i; j > 0; j--)
			{
				boolean isTheFirstGreaterThanTheSecond = a[j - 1].compareTo(a[j]) > 0;
				System.out.print("\t\t j loop - (j=" + j + ") - a[" + (j - 1) + "]=" + a[j - 1] + ", a[" + j + "] : " + a[j] + ", isTheFirstGreaterThanTheSecond : " + isTheFirstGreaterThanTheSecond);
				if (isTheFirstGreaterThanTheSecond)
				{
					System.out.println(", need to exchange");
					ArrayUtils.exch(a, j - 1, j);
				}
				else
				{
					// System.out.println(", do nothing.");
					// break out of both the loops.
					break;
				}
				System.out.println("\t\t end of j for loop.");
				printArray(a);
			}
		}
	}

	

	// read in a sequence of words from standard input and print
	// them out in sorted order
	public static void main(String[] args)
	{
		/*
		 * String[] strArray = new String[] { "ghi", "abc", "def" };
		 * 
		 * sort(strArray); for (int i = 0; i < strArray.length; i++) {
		 * System.out.println(strArray[i] + " "); } System.out.println();
		 */

		Integer[] intArray = new Integer[] { 5, 7, 0, 3, 4, 2, 6, 1 };

		System.out.println("--------before sorting-----------");
		printArray(intArray);
		sort(intArray);
		System.out.println("---------printing the sorted list------------");
		printArray(intArray);
		
	}
	
	private static void printArray(Comparable[] intArray)
	{
		for (int i = 0; i < intArray.length; i++)
		{
			System.out.print(intArray[i] + "\t");
		}
	}
}
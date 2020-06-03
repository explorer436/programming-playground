package sorting;

import utility.ArrayUtils;
import utility.PrintUtils;

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
public class InsertionSort
{
		
	public static void main(String[] args)
	{
		Integer[] intArray = new Integer[] { 5, 7, 0, 3, 4, 2, 6, 1 };
		System.out.println("--------before sorting-----------");
		PrintUtils.printArray(intArray);
		sort(intArray);
		System.out.println("---------printing the sorted list------------");
		PrintUtils.printArray(intArray);
		
		
		System.out.println();
		
		
		String[] strArray = new String[] { "ghi", "abc", "def" };		
		System.out.println("--------before sorting-----------");
		PrintUtils.printArray(strArray);
		sort(strArray);
		System.out.println("---------printing the sorted list------------");
		PrintUtils.printArray(strArray);
	}

	/**
	 * 
		A = [5, 7, 0, 3, 4, 2, 6, 1]
		--------------------------------------------------------------------------------------------------------
		i = 1	[5	7	0	3	4	2	6	1]
					i


		j = 1	[5	7	0	3	4	2	6	1]
					j
		compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j - 1], no need to exchange them.
		
		A at the end of the iteration i = 1, [5	7	0	3	4	2	6	1]
		--------------------------------------------------------------------------------------------------------		
		i = 2	[5	7	0	3	4	2	6	1]
						i


		j = 2	[5	7	0	3	4	2	6	1]
						j
		compare A[j] with A[j - 1].. A[2] with A[1] and exchange them.
		
		
		j = 1	[5	0	7	3	4	2	6	1]
					j
		compare A[j] with A[j - 1].. A[1] with A[0] and exchange them.
		
		A at the end of the iteration i = 2, [0	5	7	3	4	2	6	1]
		--------------------------------------------------------------------------------------------------------		
		i = 3	[0	5	7	3	4	2	6	1]
							i


		j = 3	[0	5	7	3	4	2	6	1]
							j
		compare A[j] with A[j - 1].. A[3] with A[2] and exchange them.
		
		
		j = 2	[0	5	3	7	4	2	6	1]
						j
		compare A[j] with A[j - 1].. A[2] with A[1] and exchange them.
		
		j = 1	[0	3	5	7	4	2	6	1]
					j
		compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j - 1], no need to exchange them.
		
		A at the end of the iteration i = 3, [0	3	5	7	4	2	6	1]			
		--------------------------------------------------------------------------------------------------------	
		i = 4	[0	3	5	7	4	2	6	1]
								i


		j = 4	[0	3	5	7	4	2	6	1]
								j
		compare A[j] with A[j - 1].. A[4] with A[3] and exchange them.
		
		
		j = 3	[0	3	5	4	7	2	6	1]
							j
		compare A[j] with A[j - 1].. A[3] with A[2] and exchange them.
		
		j = 2	[0	3	4	5	7	2	6	1]
						j
		compare A[j] with A[j - 1].. A[2] with A[1] and since A[j] > A[j - 1], no need to exchange them.
		
		j = 1	[0	3	4	5	7	2	6	1]
					j
		compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j - 1], no need to exchange them.
		
		A at the end of the iteration i = 4, [0	3	4	5	7	2	6	1]			
		--------------------------------------------------------------------------------------------------------	
		i = 5	[0	3	4	5	7	2	6	1]
									i


		j = 5	[0	3	4	5	7	2	6	1]
									j
		compare A[j] with A[j - 1].. A[5] with A[4] and exchange them.
		
		j = 4	[0	3	4	5	2	7	6	1]
								j
		compare A[j] with A[j - 1].. A[4] with A[3] and exchange them.
		
		j = 3	[0	3	4	2	5	7	6	1]
							j
		compare A[j] with A[j - 1].. A[3] with A[2] and exchange them.
		
		j = 2	[0	3	2	4	5	7	6	1]
						j
		compare A[j] with A[j - 1].. A[2] with A[1] and exchange them.
		
		j = 1	[0	2	3	4	5	7	6	1]
					j
		compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j - 1], no need to exchange them.
		
		A at the end of the iteration i = 5, [0	2	3	4	5	7	6	1]			
		--------------------------------------------------------------------------------------------------------	
		i = 6	[0	2	3	4	5	7	6	1]
										i


		j = 6	[0	2	3	4	5	7	6	1]
										j
		compare A[j] with A[j - 1].. A[6] with A[5] and exchange them.
		
		j = 5	[0	2	3	4	5	6	7	1]
									j
		compare A[j] with A[j - 1].. A[5] with A[4] and since A[j] > A[j - 1], no need to exchange them.
		
		j = 4	[0	2	3	4	5	6	7	1]
								j
		compare A[j] with A[j - 1].. A[4] with A[3] and since A[j] > A[j - 1], no need to exchange them.
		
		j = 3	[0	2	3	4	5	6	7	1]
							j
		compare A[j] with A[j - 1].. A[3] with A[2] and since A[j] > A[j - 1], no need to exchange them.
		
		j = 2	[0	2	3	4	5	6	7	1]
						j
		compare A[j] with A[j - 1].. A[2] with A[1] and since A[j] > A[j - 1], no need to exchange them.
		
		j = 1	[0	2	3	4	5	6	7	1]
					j
		compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j - 1], no need to exchange them.
		
		A at the end of the iteration i = 6, [0	2	3	4	5	6	7	1]	
		--------------------------------------------------------------------------------------------------------	
		i = 7	[0	2	3	4	5	6	7	1]
											i

		j = 7	[0	2	3	4	5	6	7	1]
											j
		compare A[j] with A[j - 1].. A[7] with A[6] and exchange them.
		
		j = 6	[0	2	3	4	5	6	1	7]
										j
		compare A[j] with A[j - 1].. A[6] with A[5] and exchange them.
		
		j = 5	[0	2	3	4	5	1	6	7]
									j
		compare A[j] with A[j - 1].. A[5] with A[4] and exchange them.
		
		j = 4	[0	2	3	4	1	5	6	7]
								j
		compare A[j] with A[j - 1].. A[4] with A[3] and exchange them.
		
		j = 3	[0	2	3	1	4	5	6	7]
							j
		compare A[j] with A[j - 1].. A[3] with A[2] and exchange them.
		
		j = 2	[0	2	1	3	4	5	6	7]
						j
		compare A[j] with A[j - 1].. A[2] with A[1] and exchange them.
		
		j = 1	[0	1	2	3	4	5	6	7]
					j
		compare A[j] with A[j - 1].. A[1] with A[0] and since A[j] > A[j - 1], no need to exchange them.
		
		A at the end of the iteration i = 7, [0	1	2	3	4	5	6	7]	

	 * 
	 */
	public static void sort(Comparable[] a)
	{
		int length = a.length;
		
		for (int i = 1; i < length; i++)
		{
			for (int j = i; j > 0; j--)
			{
				boolean isTheFirstGreaterThanTheSecond = a[j - 1].compareTo(a[j]) > 0;
				if (isTheFirstGreaterThanTheSecond)
				{
					ArrayUtils.exch(a, j - 1, j);
				}
				else
				{
					break;
				}
			}
		}
	}
	
	
}

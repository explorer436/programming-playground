package sorting;

/*
 * Example:   The following table shows the sorting steps for sorting the sequence 5 7 0 3 4 2 6 1. On the left side, in green, is the already sorted part of the sequence. On the far right is the number of positions in parentheses around which the inserted element has moved to the left.

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
			for (int j = i; j > 0; j--)
			{
				System.out.print("a[j - 1] : " + a[j - 1] + ", a[j] : " + a[j]);
				if (a[j - 1].compareTo(a[j]) > 0)
				{
					System.out.println(", need to exchange");
					exch(a, j - 1, j);
				}
				else
				{
					System.out.println(", else");
					break;
				}
			}
		}
	}

	// exchange a[i] and a[j]
	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
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

		sort(intArray);
		for (int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i] + " ");
		}
		System.out.println();
	}
}
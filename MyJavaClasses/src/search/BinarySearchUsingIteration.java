package search;

/**
 * Searches the array anArray[ﬁrst] through anArray[last] for a given value by using a binary search.
 */
public class BinarySearchUsingIteration {

	public static void main(String[] args) {
		int[] anArray = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println("position of 4 is : " + BinarySearchUsingIteration.position(4, anArray));
		System.out.println("position of 10 is : " + BinarySearchUsingIteration.position(10, anArray));
		System.out.println("position of 15 is : " + BinarySearchUsingIteration.position(15, anArray));

	}
	
	// A prerequisite is, the array has to be ordered.
	public static int position(int key, int[] a)
	{
		int lo = 0;		
		int hi = a.length - 1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			}
			else if (key > a[mid]) {
				lo = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}

}

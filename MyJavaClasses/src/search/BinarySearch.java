package search;

/**
 * Searches the array anArray[ﬁrst] through anArray[last] for a given value by using a binary search. 
@pre 0 <= ﬁrst, last <= SIZE - 1, where SIZE is the maximum size of the array, and anArray[ﬁrst] <= anArray[ﬁrst + 1] <= ... <= anArray[last]. 
@post anArray is unchanged and either anArray[index] contains the given value or index == -1. 
@param anArray The array to search. 
@param ﬁrst The low index to start searching from. 
@param last The high index to stop searching at. 
@param target The search key. 
@return Either index, such that anArray[index] == target, or -1.  
int binarySearch(const int anArray[], int ﬁrst, int last, int target) 
{ 
	int index; 
	if (ﬁrst > last) index = -1; 
		// target not in original array 
	else 
	{ 
		// If target is in anArray, 
		// anArray[ﬁrst] <= target <= anArray[last] 
		int mid = ﬁrst + (last - ﬁrst) / 2; 
		if (target == anArray[mid]) 
			index = mid; 
			// target found at anArray[mid] 
		else if (target < anArray[mid]) 
			// Point X 
			index = binarySearch(anArray, ﬁrst, mid - 1, target); 
		else 
			// Point Y 
			index = binarySearch(anArray, mid + 1, last, target); 
	} 
	// end if return index; 
} 
// end binarySearch

 */

public class BinarySearch {

	public static void main(String[] args) {
		int[] anArray = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println("position of 4 is : " + BinarySearch.position(4, anArray));
		System.out.println("position of 10 is : " + BinarySearch.position(10, anArray));
		System.out.println("position of 15 is : " + BinarySearch.position(15, anArray));

	}
	
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

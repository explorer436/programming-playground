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

	
}

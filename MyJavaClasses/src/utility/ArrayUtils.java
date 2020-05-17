package utility;

public class ArrayUtils {
	
	// swap the integers at indices i and j
    public static void swap(int[] A, int i, int j) 
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    // swap the characters at indices i and j
    public static void swap(char[] a, int i, int j) 
    {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    // exchange a[i] and a[j]
    public static void exch(Comparable[] a, int i, int j)
 	{
 		Comparable temp = a[i];
 		a[i] = a[j];
 		a[j] = temp;
 	}
}

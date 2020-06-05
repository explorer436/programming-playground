package codility.prefixsums;

/**
 * 
 * See PrefixSums.pdf
 * 
 */
public class PrefixSums
{

    public static int[] prefixSumsOfAnArray(int A[])
    {
    	int[] prefixSums = new int[A.length];
    	
    	if (A.length > 0)
    	{
    		prefixSums[0] = A[0];
    		for (int index = 1; index < A.length; index++)
        	{
    			int previousP = prefixSums[index - 1];
    			int currentA = A[index];
        		prefixSums[index] = previousP + currentA;
        	}
    	}
    	
    	return prefixSums;
    }

}

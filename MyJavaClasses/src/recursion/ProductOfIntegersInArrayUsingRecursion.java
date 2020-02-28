package recursion;

import java.util.Arrays;

/**
 * 
 * Write a recursive function that computes and 
 * returns the product of the integer in the array anArray[ﬁrst..last].
 *
 */
public class ProductOfIntegersInArrayUsingRecursion {
	public static void main(String[] args) {

        Integer[] anArray = new Integer[]{5, 2, 10};
        System.out.println("productOfElements of anArray : " + ProductOfFirstIntegersInArrayUsingRecursion.productOfElements(anArray));
        
        anArray = new Integer[]{5};
        System.out.println("productOfElements of anArray : " + ProductOfFirstIntegersInArrayUsingRecursion.productOfElements(anArray));
        
        anArray = new Integer[]{5, 2, 10, 0};
        System.out.println("productOfElements of anArray : " + ProductOfFirstIntegersInArrayUsingRecursion.productOfElements(anArray));
    }

    public static int productOfElements(Integer[] anArray) {
        
        int result = 0;

        if (null != anArray && anArray.length != 0)
        {
        	if (anArray.length == 1)
            {
                result = anArray[0];
            }
        	else
            {
                result = anArray[0] * productOfElements(Arrays.copyOfRange(anArray, 1, anArray.length));
            }
        }

        return result;
    }
}


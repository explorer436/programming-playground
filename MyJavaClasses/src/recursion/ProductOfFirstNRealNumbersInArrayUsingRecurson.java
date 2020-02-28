package recursion;

import java.util.Arrays;

/**
 * 
 * Write a recursive function that computes and 
 * returns the product of the ﬁrst n ≥ 1 real numbers in an array.
 *
 */
public class ProductOfFirstNRealNumbersInArrayUsingRecurson {
	public static void main(String[] args) {

        Integer[] anArray = new Integer[]{5, 2, 10, 1, 9, 3, 8, 4, 6, 7, 0};
        System.out.println("productOfElements of anArray : " + ProductOfFirstNRealNumbersInArrayUsingRecurson.productOfElements(3, anArray));
        
        anArray = new Integer[]{5, 2, 10, 1, 9, 3, 8, 4, 6, 7, 0};
        System.out.println("productOfElements of anArray : " + ProductOfFirstNRealNumbersInArrayUsingRecurson.productOfElements(1, anArray));
        
        anArray = new Integer[]{5, 2};
        System.out.println("productOfElements of anArray : " + ProductOfFirstNRealNumbersInArrayUsingRecurson.productOfElements(3, anArray));
    }

    public static int productOfElements(int limit, Integer[] anArray) {
        
        int result = 0;

        if (null != anArray && anArray.length != 0 && limit < anArray.length)
        {
        	if (limit == 1)
            {
                result = anArray[0];
            }
        	else if (limit <= anArray.length)
            {
        		result = anArray[0] * productOfElements(limit -1 , Arrays.copyOfRange(anArray, 1, anArray.length));
            }
        }

        return result;
    }
}

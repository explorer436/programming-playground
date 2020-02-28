package recursion;

import java.util.Arrays;

/*
 * if (anArray has only one entry) maxArray(anArray) is the entry in anArray
 * else if (anArray has more than one entry) 
 * maxArray(anArray) is the maximum of maxArray(left half of anArray) 
 * 		and maxArray(right half of anArray) 
 * 
 * Notice that this strategy ﬁts the divide-and-conquer model 
 * that the previous binary search algorithm used. 
 * That is, we proceed by dividing the problem and 
 * conquering the subproblems. 
 * However, there is a difference between this algorithm and 
 * the binary search algorithm. 
 * Although the binary search algorithm conquers 
 * only one of its subproblems at each step, 
 * maxArray conquers both. 
 * Because both subproblems are solved recursively, 
 * this approach is called multipath recursion. 
 * After maxArray conquers the subproblems, 
 * it must reconcile the two solutions—that is, 
 * it must ﬁnd the maximum of the two maximums.
 */
public class LargestValueInAnArrayUsingRecursion {

	public static void main(String[] args) {

        Integer[] anArray = new Integer[]{5, 2, 10, 1, 9, 3, 8, 4, 6, 7, 0};
        System.out.println("largestValue of anArray : " + LargestValueInAnArrayUsingRecursion.largestValue(anArray));
        
        anArray = new Integer[]{5, 2, 1, 9, 3, 8, 4, 6, 7, 0};
        System.out.println("largestValue of anArray : " + LargestValueInAnArrayUsingRecursion.largestValue(anArray));
        
        anArray = new Integer[]{5};
        System.out.println("largestValue of anArray : " + LargestValueInAnArrayUsingRecursion.largestValue(anArray));
    }

    public static int largestValue(Integer[] anArray) {
        
        int result = 0;

        if (null != anArray && anArray.length != 0)
        {
            if (anArray.length == 1)
            {
                result = anArray[0];
            }
            else
            {
                int midPoint = (anArray.length + 1)/2;
                Integer[] firstHalf = Arrays.copyOfRange(anArray, 0, midPoint);
                Integer[] secondHalf = Arrays.copyOfRange(anArray, midPoint, anArray.length);

                result = largestValue(firstHalf) > largestValue(secondHalf) ? largestValue(firstHalf) : largestValue(secondHalf);
            }
        }

        return result;
    }

}

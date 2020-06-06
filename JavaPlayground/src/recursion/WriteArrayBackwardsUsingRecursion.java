package recursion;

import java.util.Arrays;

public class WriteArrayBackwardsUsingRecursion {

	public static void main(String[] args) {
		String[] myStringArray = new String[]{"t", "e", "s", "t", "i", "n", "g"};
		WriteArrayBackwardsUsingRecursion.printArrayInReverse(myStringArray);
		
		myStringArray = new String[]{"t"};
		WriteArrayBackwardsUsingRecursion.printArrayInReverse(myStringArray);
		
		myStringArray = new String[]{};
		WriteArrayBackwardsUsingRecursion.printArrayInReverse(myStringArray);
		
	}
	
	public static void printArrayInReverse(String[] strArray) {
        
        if (null != strArray && strArray.length > 1)
        {
        	System.out.print(strArray[strArray.length -1]);
        	printArrayInReverse(Arrays.copyOfRange(strArray, 0, strArray.length - 1));
		}
		// base condition
        else if (strArray.length == 1)
        {
        	System.out.println(strArray[0]);
        }
    }

}

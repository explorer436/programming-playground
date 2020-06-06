package recursion;

import java.util.Arrays;

public class WriteArrayBackwards {

	public static void main(String[] args) {
		String[] myStringArray = new String[]{"t", "e", "s", "t", "i", "n", "g"};
		WriteArrayBackwards.printArrayInReverse_recursive(myStringArray);
		
		myStringArray = new String[]{"t"};
		WriteArrayBackwards.printArrayInReverse_recursive(myStringArray);
		
		myStringArray = new String[]{};
		WriteArrayBackwards.printArrayInReverse_recursive(myStringArray);
	}
	
	public static void printArrayInReverse_recursive(String[] strArray) {
        
        if (null != strArray && strArray.length > 1)
        {
        	System.out.print(strArray[strArray.length -1]);
        	printArrayInReverse_recursive(Arrays.copyOfRange(strArray, 0, strArray.length - 1));
		}
		// base condition
        else if (strArray.length == 1)
        {
        	System.out.println(strArray[0]);
        }
    }

}

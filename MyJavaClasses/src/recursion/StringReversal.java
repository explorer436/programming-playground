package recursion;

public class StringReversal {

	public static void main(String[] args) {
		System.out.println("reverse of cat : " + StringReversal.reverseString("cat"));
		
		System.out.println("reverse of damage : " + StringReversal.reverseString("damage"));
		
		System.out.println("reverse of empty string : " + StringReversal.reverseString(""));

	}
	
	public static String reverseString(String str) {
        String result = null;
        
        if (null != str && str.length() > 1)
        {
        	result = str.substring(str.length() -1, str.length()) + reverseString(str.substring(0, str.length() -1));
        }
        else if(str.length() == 1)
        {
        	return str;
        }

        return result;
    }

}

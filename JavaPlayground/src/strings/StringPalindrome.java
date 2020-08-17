package strings;

public class StringPalindrome {    
   
    public static void main(String[] args) {
    	StringPalindrome p = new StringPalindrome();
    	
    	// simple test cases
        System.out.println(p.isPalindrome_caseSensitive("Deleveled"));
        System.out.println(p.isPalindrome_caseInsensitive("Deleveled"));
        
        // test cases including spaces
        System.out.println(p.isPalindrome_caseSensitive("Dele eled"));
        System.out.println(p.isPalindrome_caseInsensitive("Dele eled"));
        
        System.out.println(p.isPalindrome_caseInsensitive("Dele ele eled"));
    }
    
    public boolean isPalindrome_caseSensitive(String word) {
        
    	boolean result = true;
    	
    	for (int i = 0; i < word.length(); i++)
    	{
    		int oppositeIndex = word.length() - (i + 1);
    		
    		char a = word.charAt(i);
    		char b = word.charAt(oppositeIndex);
    		
    		if (a != b)
    		{
    			result = false;
    			break;
    		}
    	}
    	
    	return result;

    }
    
    public boolean isPalindrome_caseInsensitive(String word) {
        
    	boolean result = true;
    	
    	for (int i = 0; i < word.length(); i++)
    	{
    		int oppositeIndex = word.length() - (i + 1);
    		
    		char a = word.charAt(i);
    		char b = word.charAt(oppositeIndex);
    		
    		a = Character.toLowerCase(a);
    		b = Character.toLowerCase(b);
    		
    		if (a != b)
    		{
    			result = false;
    			break;
    		}
    	}
    	
    	return result;

    }
}

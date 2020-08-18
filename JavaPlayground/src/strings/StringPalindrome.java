package strings;

public class StringPalindrome {    
   
    public static void main(String[] args) throws Exception {
    	StringPalindrome p = new StringPalindrome();
    	
    	boolean result;
    	
    	// simple test cases
    	result = p.isPalindrome_caseSensitive("Deleveled");
    	if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
    	
    	result = p.isPalindrome_caseInsensitive("Deleveled");
    	if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        // test cases including spaces
        
        result = p.isPalindrome_caseSensitive("Dele eled");
    	if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
        
        result = p.isPalindrome_caseInsensitive("Dele eled");
    	if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        result = p.isPalindrome_caseInsensitive("Dele ele eled");
        if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        System.out.println("done");
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

package com.my.company.strings;

import java.util.ArrayDeque;
import java.util.LinkedList;

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
        
        
        
        result = p.isPalindrome_usingStack("abccba");
        if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        result = p.isPalindrome_usingStack("Was it a car or a cat I saw?");
        if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        result = p.isPalindrome_usingStack("I did, did I?");
        if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        result = p.isPalindrome_usingStack("hello");
        if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
        
        result = p.isPalindrome_usingStack("Don't nod");
        if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        
        result = p.isPalindrome_usingStackAndQueue("abccba");
        if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        result = p.isPalindrome_usingStackAndQueue("Was it a car or a cat I saw?");
        if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        result = p.isPalindrome_usingStackAndQueue("I did, did I?");
        if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
        
        result = p.isPalindrome_usingStackAndQueue("hello");
        if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
        
        result = p.isPalindrome_usingStackAndQueue("Don't nod");
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
    
    public boolean isPalindrome_usingStack(String string) {
        
    	LinkedList<Character> stack = new LinkedList<>();
    	
    	StringBuilder stringNoPunctuation = new StringBuilder(string.length());
    	String lowerCase = string.toLowerCase();
    	
    	for (int i = 0; i < lowerCase.length(); i++)
    	{
    		char c = lowerCase.charAt(i);
    		
    		if (c >= 'a' && c <= 'z')
    		{
    			stack.push(c);
    			stringNoPunctuation.append(c);
    		}
    	}
    	
    	StringBuilder reversedString = new StringBuilder(string.length());
    	while (!stack.isEmpty())
    	{
    		reversedString.append(stack.pop());
    	}
    	
    	
    	return reversedString.toString().equals(stringNoPunctuation.toString());
    }
    
    public boolean isPalindrome_usingStackAndQueue(String string) {
        
    	LinkedList<Character> stack = new LinkedList<>();
    	ArrayDeque<Character> queue = new ArrayDeque<>();
    	
    	String lowerCase = string.toLowerCase();
    	
    	for (int i = 0; i < lowerCase.length(); i++)
    	{
    		char c = lowerCase.charAt(i);
    		
    		if (c >= 'a' && c <= 'z')
    		{
    			stack.push(c);
    			queue.addLast(c);
    		}
    	}
    	
    	StringBuilder reversedString = new StringBuilder(string.length());
    	while (!stack.isEmpty())
    	{
    		reversedString.append(stack.pop());
    	}
    	
    	StringBuilder initialStringQithoutPunctuation = new StringBuilder(string.length());
    	while (!queue.isEmpty())
    	{
    		initialStringQithoutPunctuation.append(queue.removeFirst());
    	}
    	
    	return reversedString.toString().equals(initialStringQithoutPunctuation.toString());
    }
}

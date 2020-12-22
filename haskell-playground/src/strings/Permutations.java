package strings;

import utility.ArrayUtils;

/**
 *
   https://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
   
   TODO - write your own implementation for this.
 *
 */
public class Permutations {
	
	/**
	 *  The second method is preferred because 
	 *  solution that converts to a char array and swaps to generate the permutations will require much less copying and generate much less garbage.
	 *  
	 *  TODO
	 *  Does this solution take repeated characters into account?
	 */
	
	public static void main(String[] args) 
	{
        int n = 3;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        perm1(elements);
        System.out.println();
        perm2(elements);
    }

    // print n! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { 
    	perm1("", s); 
    }
    
    private static void perm1(String prefix, String s) 
    {
        int n = s.length();
        if (n == 0) 
        {
        	System.out.println("prefix : " + prefix);
        }
        else 
        {
            for (int i = 0; i < n; i++)
            {
            	perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
            } 
        }
    }

    // print n! permutation of the elements of array a (not in order)
    public static void perm2(String s) 
    {
        int n = s.length();
        
        char[] a = new char[n];
        for (int i = 0; i < n; i++)
        {
        	a[i] = s.charAt(i);
        }
        perm2(a, n);
    }

    private static void perm2(char[] a, int n) 
    {
        if (n == 1) 
        {
        	System.out.println(new String(a));
            return;
        }
        
        for (int i = 0; i < n; i++) 
        {
            ArrayUtils.swap(a, i, n-1);
            perm2(a, n-1);
            ArrayUtils.swap(a, i, n-1);
        }
    }  

    
    
}

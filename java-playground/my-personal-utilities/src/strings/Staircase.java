package strings;

/**
 *
	Consider a staircase of size n = 4 :
	
	   #
	  ##
	 ###
	####
	
	Observe that its base and height are both equal to n, and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.
	
	Write a program that prints a staircase of size n.
	
	Function Description:
	
	Complete the staircase function in the editor below. It should print a staircase as described above.
	
	staircase has the following parameter(s):
	    n: an integer
	
	Input Format:
	A single integer, n, denoting the size of the staircase.
	
	Constraints:
	0 < n ,= 100.
	
	Output Format:
	Print a staircase of size n using # symbols and spaces.
	
	Note: The last line must have 0 spaces in it.
	
	Sample Input:
	6 
	
	Sample Output:
	
	     #
	    ##
	   ###
	  ####
	 #####
	######
	
	Explanation:
	The staircase is right-aligned, composed of # symbols and spaces, and has a height and width of n = 6.
 */

public class Staircase {

	// Regex
	
	public static void main(String[] args) {
		staircase(4);
		staircase(6);
	}
	
	static void staircase(int n) {
		
		String whitespace = " ";
		String hashSymbol = "#";
		
		for (int i = 1; i <= n; i++)
		{			
			int numberOfWhiteSpaces = n - i;
			System.out.print(new String(new char[numberOfWhiteSpaces]).replace("\0", whitespace));
			
			int numberOfHashes = i;
			System.out.println(new String(new char[numberOfHashes]).replace("\0", hashSymbol));
		}
	}
    
}

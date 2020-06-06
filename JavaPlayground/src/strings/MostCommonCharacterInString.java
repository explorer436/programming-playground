package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 
	Problem Statement for StringDup
	
	Create a class called StringDup. Given a string made up of ONLY letters and
	digits, determine which character is repeated the most in the string ('A' is
	different than 'a'). If there is a tie, the character which appears first in
	the string (from left to right) should be returned.
	
	Examples :
	
	aaiicccnn = c
	aabbccdd = a
	ab2sbf2dj2skl = 2
	
	Here is the method signature :
	
	public char getMax(String input);
	
	We will check to make sure that the input contains only letters and digits (no
	punctuation marks or spaces).
	
	 
	Definition
	    	
	Class:	StringDup
	Method:	getMax
	Parameters:	String
	Returns:	char
	Method signature:	char getMax(String param0)
	(be sure your method is public)
	    
 *
 */
public class MostCommonCharacterInString {

	public static void main(String[] args) {
		solution_printAllAnswers("aaiicccnn");
		solution_printAllAnswers("aabbccdd");
		solution_printAllAnswers("ab2sbf2dj2skl");
		solution_printAllAnswers("");
		solution_printAllAnswers(null);
		
		System.out.println();
		
		solution_printFirstAnswer("aaiicccnn");
		solution_printFirstAnswer("aabbccdd");
		solution_printFirstAnswer("ab2sbf2dj2skl");
		solution_printFirstAnswer("");
		solution_printFirstAnswer(null);
	}
	
	/**
	 * approach 1:
	 * build a hashmap with each of the letters and then loop through the values for each character to see which one is the greatest.
	 */
	public static void solution_printAllAnswers(String str)
	{
		HashMap<Character, Integer> letterCountMap = new HashMap<Character, Integer>();
		
		Integer currentCount;
		if (null != str)
		{
			for (char c : str.toCharArray())
			{
				currentCount = (Integer) letterCountMap.get(c);

		        if (currentCount == null)
		        {
		            letterCountMap.put(c, 1);
		        }
		        else
		        {
		            currentCount = currentCount + 1;
		            letterCountMap.put(c, (Integer) currentCount);
		        }
			}
		}
		

		// PrintUtils.printMap(letterCountMap);
		
		// The first step is to find the highest value at all.
		if (!letterCountMap.isEmpty())
		{
			int maxValue = Collections.max(letterCountMap.values());
			
			// Now iterate through all the entries of the map and add to the list keys associated with the highest value.
			List<Character> mostCommonCharactersList = new ArrayList<>();
			for (Entry<Character, Integer> entry : letterCountMap.entrySet()) {
			    if (entry.getValue() == maxValue) {
			        mostCommonCharactersList.add(entry.getKey());
			    }
			}
			
			// using streams
			List<Character> listRetrievedUsingStreams = letterCountMap.entrySet().stream()
			    .filter(entry -> entry.getValue() == maxValue)
			    .map(entry -> entry.getKey())
			    .collect(Collectors.toList());
			
			System.out.println("MostCommonCharacterInString : " + Arrays.toString(mostCommonCharactersList.toArray()));
			
			System.out.println("MostCommonCharacterInString : " + Arrays.toString(listRetrievedUsingStreams.toArray()));
		}
	}
	
	public static void solution_printFirstAnswer(String str)
	{
		HashMap<Character, Integer> letterCountMap = new HashMap<Character, Integer>();
		
		Integer currentCount;
		if (null != str)
		{
			for (char c : str.toCharArray())
			{
				currentCount = (Integer) letterCountMap.get(c);

		        if (currentCount == null)
		        {
		            letterCountMap.put(c, 1);
		        }
		        else
		        {
		            currentCount = currentCount + 1;
		            letterCountMap.put(c, (Integer) currentCount);
		        }
			}
		}

		// PrintUtils.printMap(letterCountMap);

		// The first step is to find the highest value at all.
		if (!letterCountMap.isEmpty())
		{
			int maxValue = Collections.max(letterCountMap.values());
			
			// Now iterate through all the entries of the map and add to the list keys associated with the highest value.
			List<Character> mostCommonCharactersList = new ArrayList<>();
			for (Entry<Character, Integer> entry : letterCountMap.entrySet()) {
			    if (entry.getValue() == maxValue) {
			        mostCommonCharactersList.add(entry.getKey());
			        break;
			    }
			}
			
			// using streams
			List<Character> listRetrievedUsingStreams = letterCountMap.entrySet().stream()
			    .filter(entry -> entry.getValue() == maxValue)
			    .map(entry -> entry.getKey())
			    .collect(Collectors.toList());
			
			System.out.println("MostCommonCharacterInString : " + Arrays.toString(mostCommonCharactersList.toArray()));
			
			System.out.println("MostCommonCharacterInString : " + listRetrievedUsingStreams.get(0));
		}
	}
	
	// TODO is there a more efficient way to do this?

}

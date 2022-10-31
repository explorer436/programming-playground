package com.my.company.strings;

import com.my.company.datastructures.stack.StackImplementationUsingDoubleLinkedList;
import com.my.company.datastructures.stack.StackImplementationUsingLinkedList;

/**
 * 
	A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

	Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
	
	A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
	
	By this logic, we say a sequence of brackets is balanced if the following conditions are met:
	    1. It contains no unmatched brackets.
	    2. The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
	
	Given n strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.
	
	Function Description
	
	Complete the function isBalanced in the editor below. It must return a string: YES if the sequence is balanced or NO if it is not.
	
	isBalanced has the following parameter(s):
	
	    s: a string of brackets
	
	Input Format
	
	The first line contains a single integer n, the number of strings.
	Each of the next n lines contains a single string s, a sequence of brackets.
	
	Constraints:
		1 <= n <= 10 ^ 3
		1 <= |s| <= 10 ^ 3, where |s| is the length of the sequence.
		All chracters in the sequences belongs in {, }, (, ), [, ].
	
	Output Format
		For each string, return YES or NO.
	
	Sample Input
		3
		{[()]}
		{[(])}
		{{[[(())]]}}
	
	Sample Output
		YES
		NO
		YES
	
	Explanation
	    The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
	    The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
	    The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.

 *
 */
public class BalancedParanthesis {

	public static void main(String[] args) throws Exception {
		
		boolean result;
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("{}[](){");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("{}[]()");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("{)");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("([)}");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("{[()]}");
		if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("{[(])}");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("{{[[(())]]}}");
		if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("[()]{}{[()()]()}");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreBalancedFromBeginningAndEnding("[(])");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		//-----------------------------------------------------------------------------------
		// check if they are adjacently balanced.
		// this is not a very common scenario.
		
		result = checkIfBracketsAreAdjacentBalanced("");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreAdjacentBalanced("{}[](){");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreAdjacentBalanced("{}[]()");
		if (!result)
		{
			throw new Exception("wrong answer - expected " + true + " but received " + result);
		}
		
		result = checkIfBracketsAreAdjacentBalanced("{)");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreAdjacentBalanced("([)}");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreAdjacentBalanced("{[()]}");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreAdjacentBalanced("{[(])}");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreAdjacentBalanced("{{[[(())]]}}");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreAdjacentBalanced("[()]{}{[()()]()}");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		result = checkIfBracketsAreAdjacentBalanced("[(])");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
		
		//-----------------------------------------------------------------------------------
		// check if they are balanced using string replacement technique.
		// this is not a very common scenario.

		result = isBalanced("");
		if (result)
		{
			throw new Exception("wrong answer - expected " + false + " but received " + result);
		}
				
				result = isBalanced("{}[](){");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}
				
				result = isBalanced("{}[]()");
				if (!result)
				{
					throw new Exception("wrong answer - expected " + true + " but received " + result);
				}
				
				result = isBalanced("{)");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}
				
				result = isBalanced("([)}");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}
				
				result = isBalanced("{[()]}");
				if (!result)
				{
					throw new Exception("wrong answer - expected " + true + " but received " + result);
				}
				
				result = isBalanced("{[(])}");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}
				
				result = isBalanced("{{[[(())]]}}");
				if (!result)
				{
					throw new Exception("wrong answer - expected " + true + " but received " + result);
				}
				
				result = isBalanced("[()]{}{[()()]()}");
				if (!result)
				{
					throw new Exception("wrong answer - expected " + true + " but received " + result);
				}
				
				result = isBalanced("[(])");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}

				//-----------------------------------------------------------------------------------
				// check if the input is an expression.
				// this is not a very common scenario.

				result = checkIfBracketsIsAnExpression("");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}

				result = checkIfBracketsIsAnExpression("{}[](){");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}

				result = checkIfBracketsIsAnExpression("{}[]()");
				if (!result)
				{
					throw new Exception("wrong answer - expected " + true + " but received " + result);
				}

				result = checkIfBracketsIsAnExpression("{)");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}

				result = checkIfBracketsIsAnExpression("([)}");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}

				result = checkIfBracketsIsAnExpression("{[()]}");
				if (!result)
				{
					throw new Exception("wrong answer - expected " + true + " but received " + result);
				}

				result = checkIfBracketsIsAnExpression("{[(])}");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}

				result = checkIfBracketsIsAnExpression("{{[[(())]]}}");
				if (!result)
				{
					throw new Exception("wrong answer - expected " + true + " but received " + result);
				}

				result = checkIfBracketsIsAnExpression("[()]{}{[()()]()}");
				if (!result)
				{
					throw new Exception("wrong answer - expected " + true + " but received " + result);
				}

				result = checkIfBracketsIsAnExpression("[(])");
				if (result)
				{
					throw new Exception("wrong answer - expected " + false + " but received " + result);
				}

				System.out.println("done");

	}
	
	/**
	 * This works for expressions in general. That included adjacently balanced brackets.
	 * 
	 * Complexity is O (n)
	 */
	private static boolean checkIfBracketsIsAnExpression(String str)
	{
		boolean result = false;
		
		if (null != str && str.length() > 0 && (str.length() % 2 ==0))
		{
			StackImplementationUsingLinkedList stack = new StackImplementationUsingLinkedList();
			
			for (int i = 0; i < str.length(); i++)
			{
				if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
				{
					stack.push((char) str.charAt(i));
				}
				else if (str.charAt(i) == ')')
				{
					char correspondingBracketAtTheBeginning = (char) stack.pop();
					if (correspondingBracketAtTheBeginning != '(')
					{
						return false;
					}
				}
				else if (str.charAt(i) == '}')
				{
					char correspondingBracketAtTheBeginning = (char) stack.pop();
					if (correspondingBracketAtTheBeginning != '{')
					{
						return false;
					}
				}
				else if (str.charAt(i) == ']')
				{
					char correspondingBracketAtTheBeginning = (char) stack.pop();
					if (correspondingBracketAtTheBeginning != '[')
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			
			if (stack.isEmpty())
			{
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * This is a brute force method that will work for both adjacently balanced and balanced expressions.
	 * This works for expressions in general. That included adjacently balanced brackets.
	 * 
	 * Complexity is O (n^2)
	 */
	private static boolean isBalanced(String str)
	{		
		boolean result = false;

		if (null != str && str.length() > 0 && (str.length() % 2 ==0))
		{
			// without using linked lists.

			// REMEMBER do not use while (str.length() > 0).. it will lead to infinite loop when the input is not balanced.
			while (str.contains("()") || str.contains("[]") || str.contains("{}"))
			{
				str = str.replaceAll("\\(\\)", "").replaceAll("\\[\\]", "").replaceAll("\\{\\}", "");
			}
		}
		else
		{
			return false;
		}

		if (str.length() == 0)
		{
			result = true;
		}

		return result;
	}
	
	/**
	 * This is not a valid solution. This will work only if the brackets at the beginning and at the end match.
	 * e.g. 
	 * This works for {[()]}
	 * But it does not work for {}[()]
	 */
	private static boolean checkIfBracketsAreBalancedFromBeginningAndEnding(String str)
	{
		boolean result = false;
		
		if (null != str && str.length() > 0 && (str.length() % 2 ==0))
		{
			// using double linked list for this.
			StackImplementationUsingDoubleLinkedList stack = new StackImplementationUsingDoubleLinkedList();
			
			for (int i = 0; i < str.length(); i++)
			{
				stack.pushToTheTop((char) str.charAt(i));
			}
			
			while (!stack.isEmpty())
			{
				char lastChar = (char) stack.popFromTheTop();
				
				// { {, }, (, ), [, ] }
				if (lastChar == '}')
				{
					char correspondingBracketAtTheBeginning = (char) stack.popFromTheBottom();
					if ('{' == correspondingBracketAtTheBeginning)
					{
						continue;
					}
					else
					{
						return false;
					}
				}
				else if (lastChar == ')')
				{
					char correspondingBracketAtTheBeginning = (char) stack.popFromTheBottom();
					if ('(' == correspondingBracketAtTheBeginning)
					{
						continue;
					}
					else
					{
						return false;
					}
				}
				else if (lastChar == ']')
				{
					char correspondingBracketAtTheBeginning = (char) stack.popFromTheBottom();
					if ('[' == correspondingBracketAtTheBeginning)
					{
						continue;
					}
					else
					{
						return false;
					}
				}
			}
			
			if (stack.isEmpty())
			{
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * This is not an accurate solution. This works only if the brackets are adjacently balanced.
	 * It works for {}[]()
	 * It does not work for []{()}
	 * 
	 */
	private static boolean checkIfBracketsAreAdjacentBalanced(String str)
	{
		boolean result = false;
		
		if (null != str && str.length() > 0 && (str.length() % 2 ==0))
		{
			// using single linked list for this.
			StackImplementationUsingLinkedList stack = new StackImplementationUsingLinkedList();
			
			for (int i = 0; i < str.length(); i++)
			{
				stack.push((char) str.charAt(i));
			}
			
			while (!stack.isEmpty())
			{
				char lastChar = (char) stack.pop();
				
				// { {, }, (, ), [, ] }
				if (lastChar == '}')
				{
					if ('{' == (char) stack.pop())
					{
						continue;
					}
					else
					{
						return false;
					}
				}
				else if (lastChar == ')')
				{
					if ('(' == (char) stack.pop())
					{
						continue;
					}
					else
					{
						return false;
					}
				}
				else if (lastChar == ']')
				{
					if ('[' == (char) stack.pop())
					{
						continue;
					}
					else
					{
						return false;
					}
				}
			}
			
			if (stack.isEmpty())
			{
				result = true;
			}
		}
		
		return result;
	}

}

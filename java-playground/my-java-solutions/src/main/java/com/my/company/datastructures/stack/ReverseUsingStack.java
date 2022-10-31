package com.my.company.datastructures.stack;

import java.util.Stack;

public class ReverseUsingStack {

	public static void main(String[] args) throws Exception {
		
		int[] a = new int[] { 1, 2, 3, 4 };
		
		reverseIntegerArrayUsingStack(a);
		
		String result = reverseStringArrayUsingStack("This is a test.");
		
		result = reverseStringArrayUsingStack("This is a test."); 
        if (!".tset a si sihT".equals(result))
		{
			throw new Exception("wrong answer - expected " + ".tset a si sihT" + " but received " + result);
		}
        
        System.out.println("done");
	}
	
	public static String reverseStringArrayUsingStack(String str)
	{
		Stack<Character> stack = new Stack<>();
		
		for (char c : str.toCharArray())
		{
			stack.push(c);
		}
		
		StringBuffer sb = new StringBuffer();
		
		while (!stack.isEmpty())
		{
			sb.append(stack.pop());
		}
		
		return sb.toString();
		
	}
	
	/*
	 * By the very nature of stacks,
	 * the elements inserted into them are going to be retrieved in reverse order.
	 * LIFO - last in first out.
	 */
	public static void reverseIntegerArrayUsingStack(int[] a)
	{
		// Java's native stack implementation can also be used.
		StackImplementationUsingLinkedList<Integer> integerStack = new StackImplementationUsingLinkedList<>();
		
		for (int i : a)
		{
			integerStack.push(i);
		}
		
		System.out.println("size of the stack after inserting all the elements from the array : " + integerStack.size());
		System.out.println();
		
		for (int i = integerStack.size(); i > 0; i--)
		{
			System.out.println(integerStack.pop());
		}
		
	}

}

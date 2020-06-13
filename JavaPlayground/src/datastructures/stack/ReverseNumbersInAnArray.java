package datastructures.stack;

import datastructures.linkedlist.StackImplementationUsingLinkedList;

public class ReverseNumbersInAnArray {

	public static void main(String[] args) {
		
		int[] a = new int[] { 1, 2, 3, 4 };
		
		reverseUsingStack(a);
	}
	
	/*
	 * By the very nature of stacks, the elements inserted into them are going to be retrieved in reverse order.
	 * LIFO - last in first out.
	 */
	public static void reverseUsingStack(int[] a)
	{
		StackImplementationUsingLinkedList<Integer> integerStack = new StackImplementationUsingLinkedList<Integer>(); 
		
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

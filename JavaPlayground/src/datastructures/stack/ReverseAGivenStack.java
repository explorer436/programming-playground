package datastructures.stack;

import java.util.Stack;

public class ReverseAGivenStack {

	public static void main(String[] args) throws Exception {
		Stack integerStack = new Stack<>();
        integerStack.add(4);
        integerStack.add(9);
        integerStack.add(6);
        integerStack.add(8);
        integerStack.add(10);
        integerStack.add(5);
        
        String integerStackReversedUsingTempStack = reverseUsingTempStack(integerStack);
        if (!"4 9 6 8 10 5".equals(integerStackReversedUsingTempStack))
		{
			throw new Exception("wrong answer - expected " + "T e s t i n g" + " but received " + integerStackReversedUsingTempStack);
		}
        
        integerStack = new Stack<>();
        integerStack.add(4);
        integerStack.add(9);
        integerStack.add(6);
        integerStack.add(8);
        integerStack.add(10);
        integerStack.add(5);
        
        String integerStackReversedUsingRecursion = reverseUsingRecursion("", integerStack);
        if (!"4 9 6 8 10 5".equals(integerStackReversedUsingRecursion))
		{
			throw new Exception("wrong answer - expected " + "T e s t i n g" + " but received " + integerStackReversedUsingRecursion);
		}
        
        Stack stringStack = new Stack<>();
        stringStack.add("T");
        stringStack.add("e");
        stringStack.add("s");
        stringStack.add("t");
        stringStack.add("i");
        stringStack.add("n");
        stringStack.add("g");
        
        String stringStackReversedUsingRecursion = reverseUsingRecursion("", stringStack);
        if (!"T e s t i n g".equals(stringStackReversedUsingRecursion))
		{
			throw new Exception("wrong answer - expected " + "T e s t i n g" + " but received " + stringStackReversedUsingRecursion);
		}
        
        stringStack = new Stack<>();
        stringStack.add("T");
        stringStack.add("e");
        stringStack.add("s");
        stringStack.add("t");
        stringStack.add("i");
        stringStack.add("n");
        stringStack.add("g");
        
        String stringStackReversedUsingTempStack = reverseUsingTempStack(stringStack);
        if (!"T e s t i n g".equals(stringStackReversedUsingTempStack))
		{
			throw new Exception("wrong answer - expected " + "T e s t i n g" + " but received " + stringStackReversedUsingTempStack);
		}
        
        System.out.println("done");
	}

	protected static String reverseUsingRecursion(String str, Stack stack) {
		
		// NOTE : The originalStack is not going to be preserved.
		// If the original stack needs to be preserved, this approach may not work.
		while (!stack.isEmpty())
		{
			str = reverseUsingRecursion(stack.pop() + " " + str, stack);
		}
		
		if (stack.isEmpty()) {
			return str.trim();
		}
		
		return null;
	}
	
	protected static String reverseUsingTempStack(Stack originalStack) {
		StringBuffer sb = new StringBuffer();
		
		Stack tempStack = new Stack();
		
		while (!originalStack.isEmpty())
		{
			tempStack.push(originalStack.pop());
			
			// If the originalStack needs to be preserved, 
			// we would have to push the elements into originalStack back again so that it will be intact.
		}
		
		while (!tempStack.isEmpty())
		{
			sb.append(tempStack.pop());
			sb.append(" ");
		}
		
		return sb.toString().trim();
	}

}

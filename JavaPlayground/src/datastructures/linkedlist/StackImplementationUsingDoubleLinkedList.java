package datastructures.linkedlist;

/**
 * 
	See LinkedList.md
	
	The implementation below maintains
	the stack as a linked list, with the top of the stack at the beginning, referenced by an
	instance variable first . Thus, to push() an item, we add it to the beginning of the
	list, using the code discussed in LinkedList.md - "Insert at the beginning" and 
	to pop() an item, we remove it from the
	beginning of the list, using the code discussed in LinkedList.md - "Remove from the beginning". 
	To implement size() , we keep
	track of the number of items in an instance variable N , incrementing N when we push
	and decrementing N when we pop. To implement isEmpty() we check whether first
	is null (alternatively, we could check whether N is 0 ). The implementation uses the
	generic type Item —you can think of the code <Item> after the class name as meaning
	that any occurrence of Item in the implementation will be replaced by a client-supplied
	data-type name (see FixedCapacityStack.java - Generics). For now, we omit the code to support iteration. 
	Write a box trace for a client of this class yourself (see "Trace of Stack development client"). 
	This use of linked lists achieves our optimum design goals:
	■ It can be used for any type of data.
	■ The space required is always proportional to the size of the collection.
	■ The time per operation is always independent of the size of the collection.
	
	This implementation is a prototype for many algorithm implementations that we con-
	sider. It defines the linked-list data structure and implements the client methods push()
	and pop() that achieve the specified effect with just a few lines of code. The algorithms
	and data structure go hand in hand. In this case, the code for the algorithm implemen-
	tations is quite simple, but the properties of the data structure are not at all elemen-
	tary, requiring explanations on several pages. This interaction between data
	structure definition and algorithm implementation is typical and is our focus in ADT
	implementations.
 *
 */

/*
 * This generic Stack implementation is based on a linked-list data structure. 
	It can be used to create stacks containing any type of data.
	To support iteration, add the highlighted code described 
	for Bag on page 155.
 */
public class StackImplementationUsingDoubleLinkedList<Item> {
	
	private Node firstNodeInTheStack; // Sometimes, this is named head.
	private Node lastNodeInTheStack; // Sometimes, this is named tail.
	private int n;
	
	/*
	 * See LinkedList.md - "Node record"
	 */
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	
	public boolean isEmpty()
	{
		// alternatively, we can check if first == null
		return (n == 0);
	}
	
	public int size()
	{
		return n;
	}
	
	// See LinkedList.md - "Insert at the beginning"
	public void pushToTheBeginning(Item newItem)
	{
		Node oldFirst = firstNodeInTheStack;
		
		firstNodeInTheStack = new Node();
		firstNodeInTheStack.item = newItem;
		firstNodeInTheStack.next = oldFirst;
		firstNodeInTheStack.previous = null;
		
		if (null != oldFirst)
		{
			oldFirst.previous = firstNodeInTheStack;
		}
		else
		{
			lastNodeInTheStack = firstNodeInTheStack;
		}
		
		// This is because we have to keep track of size ourselves.
		n = n + 1;
	}
	
	public void pushToTheEnding(Item newItem)
	{	
		Node oldLast = lastNodeInTheStack;
		
		lastNodeInTheStack = new Node();
		lastNodeInTheStack.item = newItem;
		lastNodeInTheStack.next = null;
		lastNodeInTheStack.previous = oldLast;
		
		if (null == oldLast)
		{
			firstNodeInTheStack = lastNodeInTheStack;
		}
		
		// This is because we have to keep track of size ourselves.
		n = n + 1;
	}
	
	// See LinkedList.md - "Remove from the beginning"
	public Item popFromTheBeginning()
	{
		if (isEmpty())
		{
			return null;
		}
		
		// This is because we have to keep track of size ourselves.
		n = n - 1;
		
		/*
		 *  we would retrieve the value of the item from the node that is being removed 
		 *  (by assigning it to a variable of type Item ) before assigning to "first" the value of "first.next"
		 */
		
		Item theItemThatIsBeingRemoved = firstNodeInTheStack.item;
		
		if (null != firstNodeInTheStack.next)
		{
			firstNodeInTheStack = firstNodeInTheStack.next;
			firstNodeInTheStack.previous = null;
		}
		
		
		return theItemThatIsBeingRemoved;
		
	}
	
	public Item popFromTheEnding()
	{
		if (isEmpty())
		{
			return null;
		}
		
		// This is because we have to keep track of size ourselves.
		n = n - 1;
		
		/*
		 *  we would retrieve the value of the item from the node that is being removed 
		 *  (by assigning it to a variable of type Item ) before assigning to "first" the value of "first.next"
		 */
		
		Item theItemThatIsBeingRemoved = lastNodeInTheStack.item;
		
		lastNodeInTheStack = lastNodeInTheStack.previous;
		
		return theItemThatIsBeingRemoved;
		
	}
	
	public void printStackStartingAtTheBeginning()
	{
		System.out.println(">>> printStackStartingAtTheBeginning");
		if (!isEmpty())
		{
			System.out.println(firstNodeInTheStack.item.toString());
						
			Node nextNode = firstNodeInTheStack.next;
			while (null != nextNode)
			{
				System.out.println(nextNode.item);
				nextNode = nextNode.next;
			}
		}
		// System.out.println("firstNodeInTheStack : " + firstNodeInTheStack);
		// System.out.println("lastNodeInTheStack : " + lastNodeInTheStack);
		System.out.println("<<< printStackStartingAtTheBeginning");
	}

	public void printStackStartingAtTheEnding()
	{
		System.out.println(">>> printStackStartingAtTheEnding");
		if (!isEmpty())
		{
			System.out.println(lastNodeInTheStack.item.toString());
						
			Node previousNode = lastNodeInTheStack.previous;
			while (null != previousNode)
			{
				System.out.println(previousNode.item);
				previousNode = previousNode.next;
			}
		}
		// System.out.println("firstNodeInTheStack : " + firstNodeInTheStack);
		// System.out.println("lastNodeInTheStack : " + lastNodeInTheStack);
		System.out.println("<<< printStackStartingAtTheEnding");
	}
	
	// Test client for StackImplementationUsingLinkedList for item type "String"
	public static void main(String[] args)
	{ 
		// Create a stack and push/pop strings as directed on StdIn.
		StackImplementationUsingDoubleLinkedList<String> s = new StackImplementationUsingDoubleLinkedList<String>();
		
		String[] inputStrList = new String[] { "to", "be", "or", "not", "to", "be" };
		
		System.out.println("number of items on the stack at the beginning : " + s.size());
		
		for (String item : inputStrList)
		{
			if (!item.equals("-"))
			{
				s.pushToTheBeginning(item);
			}			
		}
		
		System.out.println("number of items on the stack with all items in it : " + s.size());
		s.printStackStartingAtTheBeginning();
		s.printStackStartingAtTheEnding();
		
		for (int i = s.size(); i > 0; i--)
		{
			System.out.println("string popped from the beginning of the stack : " + s.popFromTheBeginning());
		}
		
		System.out.println("number of items on the stack after popping all items from it starting at the beginning : " + s.size());
		s.printStackStartingAtTheBeginning();
		
		for (String item : inputStrList)
		{
			if (!item.equals("-"))
			{
				s.pushToTheEnding(item);
			}					
		}
		
		System.out.println("number of items on the stack with all items in it : " + s.size());
		s.printStackStartingAtTheBeginning();
		
		for (int i = s.size(); i > 0; i--)
		{
			System.out.println("string popped from the ending of the stack : " + s.popFromTheEnding());
		}
		
		System.out.println("number of items on the stack after popping all items from it starting at the ending : " + s.size());
	}
}

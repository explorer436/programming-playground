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
 * This generic Stack implementation is based on a linked-list data structure. It can be used to create
	stacks containing any type of data. To support iteration, add the highlighted code described 
	for Bag on page 155.
 */
public class StackImplementationUsingLinkedList<Item> {
	
	private Node firstNodeInTheStack;
	private int n;
	
	/*
	 * See LinkedList.md - "Node record"
	 */
	private class Node {
		Item item;
		Node next;
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
	public void push(Item item)
	{
		Node oldFirst = firstNodeInTheStack;
		
		firstNodeInTheStack = new Node();
		firstNodeInTheStack.item = item;
		firstNodeInTheStack.next = oldFirst;
		
		// This is because we have to keep track of size ourselves.
		n = n + 1;
	}
	
	// See LinkedList.md - "Remove from the beginning"
	public Item pop()
	{
		// This is because we have to keep track of size ourselves.
		n = n - 1;
		
		/*
		 *  we would retrieve the value of the item from the node that is being removed 
		 *  (by assigning it to a variable of type Item ) before assigning to "first" the value of "first.next"
		 */
		
		Item theItemThatIsBeingRemoved = firstNodeInTheStack.item;
		
		firstNodeInTheStack = firstNodeInTheStack.next;
		
		return theItemThatIsBeingRemoved;
		
	}
	
	// Test client for StackImplementationUsingLinkedList for item type "String"
	public static void main(String[] args)
	{ 
		// Create a stack and push/pop strings as directed on StdIn.
		StackImplementationUsingLinkedList<String> s = new StackImplementationUsingLinkedList<String>();
		
		String[] inputStrList = new String[] { "to", "be", "or", "not", "to", "be" };
		
		System.out.println("number of items on the stack at the beginning : " + s.size());
		
		for (String item : inputStrList)
		{
			if (!item.equals("-"))
			{
				s.push(item);
			}			
			
		}
		
		System.out.println("number of items on the stack with all items in it : " + s.size());
		
		for (int i = s.size(); i > 0; i--)
		{
			System.out.println("string popped from the stack : " + s.pop());
		}
		
		System.out.println("number of items on the stack after popping all items from it : " + s.size());
	}
}
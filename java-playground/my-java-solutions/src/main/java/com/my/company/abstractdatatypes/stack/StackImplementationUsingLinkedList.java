package com.my.company.abstractdatatypes.stack;

/**
 * See LinkedList.md
 *
 * <p>The implementation below maintains the stack as a linked list, with the top of the stack at
 * the beginning, referenced by an instance variable first.
 *
 * <p>To push() an item, we add it to the beginning of the list, using the code discussed in
 * LinkedList.md - "Insert at the beginning".
 *
 * <p>To pop() an item, we remove it from the beginning of the list, using the code discussed in
 * LinkedList.md - "Remove from the beginning".
 *
 * <p>To implement size() , we keep track of the number of items in an instance variable N,
 * incrementing N when we push and decrementing N when we pop.
 *
 * <p>To implement isEmpty() we check whether first is null (alternatively, we could check whether N
 * is 0 ).
 *
 * <p>The implementation uses the generic type Item —you can think of the code <Item> after the
 * class name as meaning that any occurrence of Item in the implementation will be replaced by a
 * client-supplied data-type name (see FixedCapacityStack.java - Generics). We omit the code to
 * support iteration.
 *
 * <p>This implementation is a prototype for many algorithm implementations that we consider. It
 * defines the linked-list data structure and implements the client methods push() and pop() that
 * achieve the specified effect with just a few lines of code. The algorithms and data structure go
 * hand in hand. In this case, the code for the algorithm implemen- tations is quite simple, but the
 * properties of the data structure are not at all elemen- tary, requiring explanations on several
 * pages. This interaction between data structure definition and algorithm implementation is typical
 * and is our focus in ADT implementations.
 */

/**
 * This generic Stack implementation is based on a linked-list data structure. It can be used to
 * create stacks containing any type of data.
 */
public class StackImplementationUsingLinkedList<Item> {

    private Node firstNodeInTheStack; // Sometimes, this is named head.
    private int n;

    /*
     * See LinkedList.md - "Node record"
     */
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        // alternatively, we can check if first == null
        return (n == 0);
    }

    public int size() {
        return n;
    }

    // See LinkedList.md - "Insert at the beginning"
    public void push(Item item) {
        Node oldFirst = firstNodeInTheStack;

        firstNodeInTheStack = new Node();
        firstNodeInTheStack.item = item;
        firstNodeInTheStack.next = oldFirst;

        // This is because we have to keep track of size ourselves.
        n = n + 1;
    }

    // See LinkedList.md - "Remove from the beginning"
    public Item pop() {
        if (isEmpty()) {
            return null;
        }

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

    public Item peek() {
        if (isEmpty()) {
            return null;
        }

        /*
         *  we would retrieve the value of the item from the node that is at the top of the stack.
         */

        return firstNodeInTheStack.item;
    }

    public void printStack() {
        System.out.println(">>> printStack");
        if (!isEmpty()) {
            System.out.println(firstNodeInTheStack.item.toString());

            Node nextNode = firstNodeInTheStack.next;
            while (null != nextNode) {
                System.out.println(nextNode.item);
                nextNode = nextNode.next;
            }
        }
        System.out.println("<<< printStack");
    }

    // Test client for StackImplementationUsingLinkedList for item type "String"
    public static void main(String[] args) {
        // Create a stack and push/pop strings as directed on StdIn.
        StackImplementationUsingLinkedList<String> s = new StackImplementationUsingLinkedList<String>();

        String[] inputStrList = new String[]{"to", "be", "or", "not", "to", "be"};

        System.out.println("number of items on the stack at the beginning : " + s.size());

        for (String item : inputStrList) {
            if (!item.equals("-")) {
                s.push(item);
            }
        }

        System.out.println("number of items on the stack with all items in it : " + s.size());

        s.printStack();

        for (int i = s.size(); i > 0; i--) {
            System.out.println("string popped from the stack : " + s.pop());
        }

        System.out.println(
                "number of items on the stack after popping all items from it : " + s.size());
    }

  /*
   *

  Look at the alternative implementation in printStack().

  private static void printStack(StackImplementationUsingLinkedList<String> stack) {
  	Iterator<String> stackIterator = stack.iterator();
  	while (stackIterator.hasNext())
  	{
  		String a = stackIterator.next();
  		System.out.println("a : " + a);
  	}
  }

  private class ListIterator implements Iterator<Item>
  {
  	private Node firstNode = firstNodeInTheStack;

  	public boolean hasNext()
  	{
  		return (firstNode != null);
  	}

  	public Item next()
  	{
  		Item item = firstNode.item;
  		firstNode = firstNode.next;

  		return item;
  	}
  }

  public Iterator<Item> iterator()
  {
  	return new ListIterator();
  }*/
}

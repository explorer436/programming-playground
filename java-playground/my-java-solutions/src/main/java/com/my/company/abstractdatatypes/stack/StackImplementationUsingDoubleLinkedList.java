package com.my.company.datastructures.stack;

/**
 * See LinkedList.md
 *
 * <p>The implementation below maintains the stack as a linked list, with the top of the stack at
 * the beginning, referenced by an instance variable first . Thus, to push() an item, we add it to
 * the beginning of the list, using the code discussed in LinkedList.md - "Insert at the beginning"
 * and to pop() an item, we remove it from the beginning of the list, using the code discussed in
 * LinkedList.md - "Remove from the beginning". To implement size() , we keep track of the number of
 * items in an instance variable N , incrementing N when we push and decrementing N when we pop. To
 * implement isEmpty() we check whether first is null (alternatively, we could check whether N is 0
 * ). The implementation uses the generic type Item —you can think of the code <Item> after the
 * class name as meaning that any occurrence of Item in the implementation will be replaced by a
 * client-supplied data-type name (see FixedCapacityStack.java - Generics). For now, we omit the
 * code to support iteration. Write a box trace for a client of this class yourself (see "Trace of
 * Stack development client").
 *
 * <p>This implementation is a prototype for many algorithm implementations that we con- sider. It
 * defines the linked-list data structure and implements the client methods push() and pop() that
 * achieve the specified effect with just a few lines of code. The algorithms and data structure go
 * hand in hand. In this case, the code for the algorithm implemen- tations is quite simple, but the
 * properties of the data structure are not at all elemen- tary, requiring explanations on several
 * pages. This interaction between data structure definition and algorithm implementation is typical
 * and is our focus in ADT implementations.
 */

/*
* This generic Stack implementation is based on a linked-list data structure.
It can be used to create stacks containing any type of data.
To support iteration, add the highlighted code described for Bag on page 155.
*/
public class StackImplementationUsingDoubleLinkedList<Item> {

  private Node topNodeInTheStack; // Sometimes, this is named head.
  private Node bottomNodeInTheStack; // Sometimes, this is named tail.
  private int n;

  /*
   * See LinkedList.md - "Node record"
   */
  private class Node {
    Item item;
    Node next;
    Node previous;
  }

  public boolean isEmpty() {
    // return null == topNodeInTheStack;

    // alternatively, we can check if first == null
    return (n == 0);
  }

  public int size() {
    return n;
  }

  // See LinkedList.md
  public void pushToTheTop(Item newItem) {
    Node oldTopNode = topNodeInTheStack;

    topNodeInTheStack = new Node();
    topNodeInTheStack.item = newItem;
    topNodeInTheStack.next = null;
    topNodeInTheStack.previous = oldTopNode;

    if (null == oldTopNode) {
      bottomNodeInTheStack = topNodeInTheStack;
    } else {
      oldTopNode.next = topNodeInTheStack;
    }

    // This is because we have to keep track of size ourselves.
    n = n + 1;
  }

  public void pushToTheBottom(Item newItem) {
    Node oldBottomNode = bottomNodeInTheStack;

    bottomNodeInTheStack = new Node();
    bottomNodeInTheStack.item = newItem;
    bottomNodeInTheStack.next = oldBottomNode;
    bottomNodeInTheStack.previous = null;

    if (null == oldBottomNode) {
      topNodeInTheStack = bottomNodeInTheStack;
    } else {
      oldBottomNode.previous = bottomNodeInTheStack;
    }

    // This is because we have to keep track of size ourselves.
    n = n + 1;
  }

  // See LinkedList.md - "Remove from the beginning"
  public Item popFromTheTop() {
    if (isEmpty()) {
      return null;
    }

    // This is because we have to keep track of size ourselves.
    n = n - 1;

    /*
     *  we would retrieve the value of the item from the node that is being removed
     *  (by assigning it to a variable of type Item ) before assigning to "first" the value of "first.next"
     */

    Node theNodeThatIsBeingRemoved = topNodeInTheStack;
    theNodeThatIsBeingRemoved.next = null;

    if (null != topNodeInTheStack.previous) {
      topNodeInTheStack = topNodeInTheStack.previous;
      topNodeInTheStack.next = null;
    } else {
      // it is important to set this to null.
      // if not, topNodeInTheStack will be left as an orphan node.
      // the stack is not completely clean and it will lead to unexpected errors.
      // the size of the stack will be '1' more than the expected size.
      topNodeInTheStack = null;
    }

    return theNodeThatIsBeingRemoved.item;
  }

  public Item popFromTheBottom() {
    if (isEmpty()) {
      return null;
    }

    // This is because we have to keep track of size ourselves.
    n = n - 1;

    /*
     *  we would retrieve the value of the item from the node that is being removed
     *  (by assigning it to a variable of type Item ) before assigning to "first" the value of "first.next"
     */

    Node theNodeThatIsBeingRemoved = bottomNodeInTheStack;
    theNodeThatIsBeingRemoved.previous = null;

    if (null != bottomNodeInTheStack.next) {
      bottomNodeInTheStack = bottomNodeInTheStack.next;
    } else {
      // it is important to set this to null.
      // if not, bottomNodeInTheStack will be left as an orphan node.
      // the stack is not completely clean and it will lead to unexpected errors.
      // the size of the stack will be '1' more than the expected size.
      bottomNodeInTheStack = null;
    }

    return theNodeThatIsBeingRemoved.item;
  }

  public void printStackStartingAtTheTop() {
    System.out.println(">>> printStackStartingAtTheTop");
    if (!isEmpty()) {
      // print the first item to begin with.
      System.out.println(topNodeInTheStack.item.toString());

      Node previousNode = topNodeInTheStack.previous;
      while (null != previousNode) {
        System.out.println(previousNode.item.toString());
        previousNode = previousNode.previous;
      }
    }
    // System.out.println("topNodeInTheStack : " + topNodeInTheStack);
    // System.out.println("bottomNodeInTheStack : " + bottomNodeInTheStack);
    System.out.println("<<< printStackStartingAtTheTop");
  }

  public void printStackStartingAtTheBottom() {
    System.out.println(">>> printStackStartingAtTheBottom");
    if (!isEmpty()) {
      // print the last item to begin with.
      System.out.println(bottomNodeInTheStack.item.toString());

      Node nextNode = bottomNodeInTheStack.next;
      while (null != nextNode) {
        System.out.println(nextNode.item.toString());
        nextNode = nextNode.next;
      }
    }
    // System.out.println("topNodeInTheStack : " + topNodeInTheStack);
    // System.out.println("bottomNodeInTheStack : " + bottomNodeInTheStack);
    System.out.println("<<< printStackStartingAtTheBottom");
  }

  // Test client for StackImplementationUsingLinkedList for item type "String"
  public static void main(String[] args) {
    // Create a stack and push/pop strings as directed on StdIn.
    StackImplementationUsingDoubleLinkedList<String> stack =
        new StackImplementationUsingDoubleLinkedList<String>();

    String[] inputStrList = new String[] {"my", "name", "is", "bruce", "wayne"};

    System.out.println("number of items in the stack at the beginning : " + stack.size());

    // ------------------------------------------------

    for (String item : inputStrList) {
      stack.pushToTheTop(item);
    }
    System.out.println("number of items on the stack with all items in it : " + stack.size());

    stack.printStackStartingAtTheTop();

    for (int i = stack.size(); i > 0; i--) {
      System.out.println("string popped from the top of the stack : " + stack.popFromTheTop());
    }

    System.out.println(
        "number of items on the stack after popping all items from it starting at the top : "
            + stack.size());

    // ------------------------------------------------
    System.out.println();

    // re-populate the stack again
    for (String item : inputStrList) {
      stack.pushToTheTop(item);
    }

    System.out.println("size of the stack with all items in it : " + stack.size());

    stack.printStackStartingAtTheBottom();

    for (int i = stack.size(); i > 0; i--) {
      System.out.println(
          "string popped from the bottom of the stack : " + stack.popFromTheBottom());
    }

    System.out.println(
        "number of items on the stack after popping all items from it starting at the bottom : "
            + stack.size());

    // ------------------------------------------------

    // re-populate the stack again
    for (String item : inputStrList) {
      stack.pushToTheTop(item);
    }
    System.out.println("number of items on the stack with all items in it : " + stack.size());

    stack.printStackStartingAtTheTop();

    for (int i = stack.size(); i > 0; i--) {
      System.out.println("string popped from the top of the stack : " + stack.popFromTheTop());
    }

    System.out.println(
        "number of items on the stack after popping all items from it starting at the top : "
            + stack.size());
  }

  /*private static void printStack(StackImplementationUsingDoubleLinkedList<String> stack) {
  	Iterator<String> stackIterator = stack.iterator();
  	while (stackIterator.hasNext())
  	{
  		String a = stackIterator.next();
  		System.out.println("a : " + a);
  	}
  }

  private class ListIterator implements Iterator<Item>
  {
  	private Node bottomNode = bottomNodeInTheStack;

  	public boolean hasNext()
  	{
  		return (bottomNode != null);
  	}

  	public Item next()
  	{
  		Item item = bottomNode.item;
  		bottomNode = bottomNode.next;

  		return item;
  	}
  }

  public Iterator<Item> iterator()
  {
  	return new ListIterator();
  }*/

}

package com.my.company.datastructures.queues;

/**
 * An implementation of Queue API based on the linked-list data structure is straightforward. It
 * maintains the queue as a linked list in order from least recently to most recently added items,
 * with the beginning of the queue referenced by an instance variable first and the end of the queue
 * referenced by an instance variable last. To enqueue() an item, we add it to the end of the list
 * (see LinkedList.md "Building a linked list", augmented to set both first and last to refer to the
 * new node when the list is empty).
 *
 * <p>To dequeue() an item, we remove it from the beginning of the list (using the same code as for
 * pop() in Stack , augmented to update last when the list becomes empty).
 *
 * <p>The implementations of size() and isEmpty() are the same as for Stack.
 *
 * <p>As with Stack the implementation uses the generic type parameter Item, and we omit the code to
 * support iteration, which we consider in our Bag implementation.
 *
 * <p>This implementation uses the same data structure as does Stack —a linked list—but it
 * implements different algorithms for adding and removing items, which make the difference between
 * LIFO and FIFO for the client.
 */
public class QueueImplementationUsingLinkedList<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node currentFirstNodeInTheQueue; // Sometimes, this is named head.
    private Node currentLastNodeInTheQueue;
    private int n;

    public boolean isEmpty() {
        // alternatively, check if first == null
        return (n == 0);
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        // When a new person joins a queue, the person that is currently last in the queue now becomes
        // last but one.
        Node oldLast = currentLastNodeInTheQueue;

        currentLastNodeInTheQueue = new Node();
        currentLastNodeInTheQueue.item = item;
        currentLastNodeInTheQueue.next = null;

        if (isEmpty()) {
            currentFirstNodeInTheQueue = currentLastNodeInTheQueue;
        } else {
            oldLast.next = currentLastNodeInTheQueue;
        }

        // This is because we have to keep track of size ourselves.
        n = n + 1;
    }

    public Item dequeue() {
        Item item = currentFirstNodeInTheQueue.item;

        currentFirstNodeInTheQueue = currentFirstNodeInTheQueue.next;

        if (isEmpty()) {
            currentLastNodeInTheQueue = null;
        }

        // This is because we have to keep track of size ourselves.
        n = n - 1;

        return item;
    }

    // Test client for QueueImplementationUsingLinkedList for item type "String"
    public static void main(String[] args) {
        // Create a stack and push/pop strings as directed on StdIn.
        QueueImplementationUsingLinkedList<String> q = new QueueImplementationUsingLinkedList<String>();

        String[] inputStrList = new String[]{"to", "be", "or", "not", "to", "be"};

        System.out.println("number of items on the queue at the beginning : " + q.size());

        for (String item : inputStrList) {
            if (!item.equals("-")) {
                q.enqueue(item);
            }
        }

        System.out.println("number of items on the queue with all items in it : " + q.size());

        for (int i = q.size(); i > 0; i--) {
            System.out.println("string popped from the stack : " + q.dequeue());
        }

        System.out.println(
                "number of items on the queue after popping all items from it : " + q.size());
    }

  /*
   *

  private static void printStack(QueueImplementationUsingLinkedList<String> stack) {
  	Iterator<String> stackIterator = stack.iterator();
  	while (stackIterator.hasNext())
  	{
  		String a = stackIterator.next();
  		System.out.println("a : " + a);
  	}
  }

  private class ListIterator implements Iterator<Item>
  {
  	private Node firstNode = currentFirstNodeInTheQueue;

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

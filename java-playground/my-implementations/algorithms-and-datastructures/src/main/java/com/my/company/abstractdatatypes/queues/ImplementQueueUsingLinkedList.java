package com.my.company.abstractdatatypes.queues;

public class ImplementQueueUsingLinkedList<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node firstNodeInTheQueue; // Sometimes, this is named head.
    private Node lastNodeInTheQueue;
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
        Node oldLast = lastNodeInTheQueue;

        lastNodeInTheQueue = new Node();
        lastNodeInTheQueue.item = item;
        lastNodeInTheQueue.next = null;

        if (isEmpty()) {
            firstNodeInTheQueue = lastNodeInTheQueue;
        } else {
            oldLast.next = lastNodeInTheQueue;
        }

        // This is because we have to keep track of size ourselves.
        n = n + 1;
    }

    public Item dequeue() {
        Item item = firstNodeInTheQueue.item;

        firstNodeInTheQueue = firstNodeInTheQueue.next;

        if (isEmpty()) {
            lastNodeInTheQueue = null;
        }

        // This is because we have to keep track of size ourselves.
        n = n - 1;

        return item;
    }

    // Test client for QueueImplementationUsingLinkedList for item type "String"
    public static void main(String[] args) {
        // Create a stack and push/pop strings as directed on StdIn.
        ImplementQueueUsingLinkedList<String> q = new ImplementQueueUsingLinkedList<String>();

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

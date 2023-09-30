package com.my.company.datastructures.bags;

import java.util.Iterator;

/**
 * Implementing our Bag API using a linked-list data structure is simply a matter of changing the
 * name of push() in Stack to add() and removing the implementation of pop() , as shown in the
 * algorithm below (doing the same for Queue would also be effective but requires a bit more code).
 *
 * <p>This implementation also highlights the code needed to make Stack , Queue , and Bag all
 * iterable, by traversing the list. For Stack the list is in LIFO order; for Queue it is in FIFO
 * order; and for Bag it happens to be in LIFO order, but the order is not relevant.
 *
 * <p>To implement iteration in a collection, the first step is to include import
 * java.util.Iterator; so that our code can refer to Java’s Iterator interface. The second step is
 * to add implements Iterable<Item> to the class declaration, a promise to provide an iterator()
 * method. The iterator() method itself simply returns an object from a class that implements the
 * Iterator interface: public Iterator<Item> iterator() { return new ListIterator(); } This code is
 * a promise to implement a class that implements the hasNext() , next() , and remove() methods that
 * are called when a client uses the foreach construct. To implement these methods, the nested class
 * ListIterator in this Algorithm maintains an instance variable current that keeps track of the
 * current node on the list. Then the hasNext() method tests if current is null , and the next()
 * method saves a reference to the current item, updates current to refer to the next node on the
 * list, and returns the saved reference.
 */

/*
	This implementation maintains a linked list of the items provided in calls to add() . Code for
isEmpty() and size() is the same as in Stack and is omitted. The iterator traverses the list, main-
taining the current node in current . We can make Stack and Queue iterable by adding the code
highlighted in red to Algorithms 1.1 and 1.2, because they use the same underlying data structure
and Stack and Queue maintain the list in LIFO and FIFO order, respectively.
*/
public class BagImplementationUsingLinkedList<Item> {

  private class Node {
    Item item;
    Node next;
  }

  private Node currentFirstNodeInTheBag; // Sometimes, this is named head.

  public void add(Item item) {
    Node oldFirst = currentFirstNodeInTheBag;

    currentFirstNodeInTheBag = new Node();
    currentFirstNodeInTheBag.item = item;
    currentFirstNodeInTheBag.next = oldFirst;
  }

  private class ListIterator implements Iterator<Item> {
    private Node currentNode = currentFirstNodeInTheBag;

    public boolean hasNext() {
      return (currentNode != null);
    }

    public Item next() {
      Item item = currentNode.item;
      currentNode = currentNode.next;

      return item;
    }
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }
}

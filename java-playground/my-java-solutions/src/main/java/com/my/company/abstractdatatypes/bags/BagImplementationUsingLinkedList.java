package com.my.company.abstractdatatypes.bags;

import java.util.Iterator;

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

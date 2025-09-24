package com.my.company.datastructures.linkedlist.doublylinked;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList_Integer {

    private DoublyListNode_Integer head;
    private  DoublyListNode_Integer tail;
    private int size;

    public DoublyLinkedList_Integer(Integer value) {
        if (value != null) {
            DoublyListNode_Integer node = new DoublyListNode_Integer(value);
            head = node;
            tail = node;
            size = 1;
        }
    }

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public void prepend(Integer n) {
        DoublyListNode_Integer node = new DoublyListNode_Integer(n);
        node.setNext(head);

        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
        }

        head = node;
        size++;
    }

    public void append(Integer n) {
        DoublyListNode_Integer node = new DoublyListNode_Integer(n);

        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public DoublyListNode_Integer removeFromFront() {
        if (isEmpty()) {
            return null;
        } else {
            DoublyListNode_Integer removedNode = head;

            if (head.getNext() == null) {
                tail = null;
            } else {
                head.getNext().setPrevious(null);
            }

            head = head.getNext();
            size--;
            removedNode.setNext(null);

            return removedNode;
        }
    }

    public DoublyListNode_Integer removeFromEnd() {
        if (isEmpty()) {
            return null;
        } else {
            DoublyListNode_Integer removedNode = tail;

            if (tail.getPrevious() == null) {
                head = null;
            } else {
                tail.getPrevious().setNext(null);
            }

            tail = tail.getPrevious();
            size--;
            removedNode.setPrevious(null);

            return removedNode;
        }
    }

    public int[] traverseForward() {
        List<Integer> list = new ArrayList<>();

        DoublyListNode_Integer current = head;
        while (current != null) {
            list.add(current.getValue());
            current = current.getNext();
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] traverseBackward() {
        List<Integer> list = new ArrayList<>();

        DoublyListNode_Integer current = tail;
        while (current != null) {
            list.add(current.getValue());
            current = current.getPrevious();
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void printList(DoublyListNode_Integer head) {

        DoublyListNode_Integer currentNode = head;

        System.out.println();
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public int getValueAtIndex(int index) {
        if (isEmpty()) {
            return 0;
        }

        if (index < 0 | size < index) {
            return 0;
        }

        DoublyListNode_Integer current = head;
        for (int counter = 1; counter <= index; counter++) {
            if (counter == index) {
                return current.getValue();
            }
            current = current.getNext();
        }

        return 0;
    }

    public void setValueAtIndex(int index, int value) {
        if (isEmpty()) {
            return;
        }

        if (index < 0 | size < index) {
            return;
        }

        DoublyListNode_Integer current = head;
        for (int counter = 0; counter <= index; counter++) {
            if (counter == index) {
                current.setValue(value);
                return;
            }
            current = current.getNext();
        }
    }

    public boolean insertBeforeAnExistingNode(Integer newValue, Integer existingValue) {
        if (head == null) {
            return false;
        } else {
            DoublyListNode_Integer current = head;
            while (current != null && current.getValue() != existingValue) {
                current = current.getNext();
            }

            if (current == null) {
                return false;
            } else {
                DoublyListNode_Integer newNode = new DoublyListNode_Integer(newValue);
                newNode.setPrevious(current.getPrevious());
                newNode.setNext(current);

                current.setPrevious(newNode);
                if (head == current) {
                    head = newNode;
                } else {
                    newNode.getPrevious().setNext(newNode);
                }

                size++;
                return true;
            }
        }
    }
}

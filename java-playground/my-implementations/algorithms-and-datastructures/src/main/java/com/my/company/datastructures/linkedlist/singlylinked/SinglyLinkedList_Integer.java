package com.my.company.datastructures.linkedlist.singlylinked;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SinglyLinkedList_Integer {

    public SinglyLinkedList_Integer(Integer value) {
        if (value != null) {
            head = new Node_Integer(value);
            size = 1;
        }
    }

    protected Node_Integer head;

    public Node_Integer getHead() {
        return head;
    }

    protected int size;

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public void prepend(int i) {
        Node_Integer node = new Node_Integer(i);
        node.setNext(head);
        head = node;
        size++;
    }

    public void append(int i) {
        Node_Integer node = new Node_Integer(i);

        if (isEmpty()) {
            head = node;
            size++;
            return;
        }

        Node_Integer current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        size++;
    }

    public void addInMiddle(int data) {
        // If list is empty, make new node the head
        if (head == null) {
            head = new Node_Integer(data);
            return;
        }

        // Create new node
        Node_Integer newNode = new Node_Integer(data);

        if (head.getNext() == null) {
            head.setNext(new Node_Integer(data));
        }

        ImmutablePair<Integer, Node_Integer> abc = findMiddleNode(head);
        Node_Integer middleNode = abc.getRight();

        Node_Integer previousNext = middleNode.getNext();
            // Insert new node between prev and slow
            middleNode.setNext(newNode);
            newNode.setNext(previousNext);
    }

    public static ImmutablePair<Integer, Node_Integer> findMiddleNode(Node_Integer head) {
        Node_Integer fastPointer = head;
        Node_Integer slowPointer = head;
        int slowIndex = 0;

        // If we do not use fastPointer.getNext().getNext(),
        // in cases where the list has even number of elements,
        // the method will return the left-most element in the right half of the list - which is not what we expect.
        // We want the right-most element in the left half of the list.
        while (fastPointer != null && fastPointer.getNext() != null && fastPointer.getNext().getNext() != null) {
            slowIndex++;
            slowPointer = slowPointer.getNext();
            fastPointer =  fastPointer.getNext().getNext();
        }

        return new ImmutablePair<>(slowIndex, slowPointer);
    }

    public void insertNodeAtIndex(int index, int value) {
        if (isEmpty() && index != 0) {
            return;
        }

        if (index < 0 | size < index) {
            return;
        }

        Node_Integer current = head;
        for (int counter = 1; counter <= index; counter++) {
            if (counter == index) {
                Node_Integer newNode = new Node_Integer(value);
                newNode.setNext(current.getNext());

                current.setNext(newNode);

                size++;
                return;
            }
            current = current.getNext();
        }
    }

    // TODO
    // removeNodeAtIndex

    public int[] traverseForward(Node_Integer head) {
        List<Integer> list = new ArrayList<>();

        Node_Integer current = head;
        while (current != null) {
            list.add(current.getValue());
            current = current.getNext();
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void removeFromFront() {
        if (isEmpty()) {
            return;
        } else {
            Node_Integer removedNode = head;
            head = head.getNext();
            size--;
            removedNode.setNext(null);
        }
    }

    public void removeFromLast() {
        if (isEmpty()) {
            return;
        }

        if (size == 1) {
            head = null;
            size = 0;
            return;
        }

        Node_Integer current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
        size--;
    }

    public Node_Integer removeNodeAtIndex(Node_Integer head, int index) {
        if (isEmpty()) {
            return null;
        }
        if (size <= index) {
            return head;
        }

        if (size == 1 & index == 1) {
            head = null;
            size--;
            return head;
        }

        // Node_Integer dummy = new Node_Integer(0);
        // dummy.setNext(head);

        Node_Integer current = head;
        int counter = 0;
        while (counter < index) {
            if (counter == index - 1) {
                current.setNext(current.getNext().getNext());
                size--;
            }
            current = current.getNext();
            counter++;
        }
        return head;
    }

    public int getSize() {
        return size;
    }

    public static int calculateSize(Node_Integer head) {
        int count = 0;
        Node_Integer currentNode = head;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    public int getValueAtIndex(int index) {
        if (isEmpty()) {
            return 0;
        }

        if (index < 0 | size < index) {
            return 0;
        }

        Node_Integer current = head;
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

        Node_Integer current = head;
        for (int counter = 0; counter <= index; counter++) {
            if (counter == index) {
                current.setValue(value);
                return;
            }
            current = current.getNext();
        }
    }

    public static Node_Integer reverse_iterative(Node_Integer head) {

        // Initialize pointers for traversal.
        Node_Integer current = head;
        Node_Integer previous = null;

        while (current != null) {
            Node_Integer nextNode = current.getNext();

            // Reverse the current node's pointer
            current.setNext(previous);

            // Move on to the next one
            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public Node_Integer reverse_recursive(Node_Integer node) {

        // The base case for recursion is an empty list or a list with a single node
        if (node == null || node.getNext() == null) {
            return node;
        }

        Node_Integer newHead = reverse_recursive(node.getNext());
        // Reverse the next node's pointer
        node.getNext().setNext(node);
        node.setNext(null);

        return newHead;
    }

    public static Node_Integer getTail(Node_Integer head) {
        Node_Integer tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        return tail;
    }

    public static void printList(Node_Integer head) {

        Node_Integer currentNode = head;

        System.out.println();
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public Node_Integer removeElementsWithMatchingValue(Node_Integer head, int val) {

        // Base case: If the list is empty, return null
        if (head == null) {
            return null;
        }

        if (head.getValue() == val) {
            head = head.getNext();
            return head;
        }

        // Use a current pointer to traverse the list
        Node_Integer current = head;

        while (current.getNext() != null) {
            // If the next node's value matches the target
            if (current.getNext().getValue() == val) {
                // Skip the next node
                current.setNext(current.getNext().getNext());
            } else {
                // Otherwise, move to the next node
                current = current.getNext();
            }
        }
        return head;
    }

    public Node_Integer deleteDuplicatesFromASortedList(Node_Integer head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node_Integer current = head;

        while (current != null && current.getNext() != null) {
            if (current.getValue() == current.getNext().getValue()) {
                // Duplicate found, skip the next node
                current.setNext(current.getNext().getNext());
                size--;
            } else {
                // size++;
                // No duplicate, move to the next node
                current = current.getNext();
            }
        }

        return head;
    }

    public Node_Integer deleteDuplicatesFromAnUnsortedList(Node_Integer head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Set<Integer> mySet = new HashSet<>();

        Node_Integer current = head;
        Node_Integer previous = null;
        while (current != null) {
            if (mySet.contains(current.getValue())) {
                previous.setNext(current.getNext());
                size--;
            } else {
                mySet.add(current.getValue());
                previous = current;
            }
            current = current.getNext();
        }

        return head;
    }

}

package com.my.company.datastructures.linkedlist.singlylinked;

public class PartitionALinkedListAtAPivotElement {

    // Main method to test the solution
    public static void main(String[] args) {
        // Create the linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        Node_Integer head = new Node_Integer(1);
        head.setNext(new Node_Integer(4));
        head.getNext().setNext(new Node_Integer(3));
        head.getNext().getNext().setNext(new Node_Integer(2));
        head.getNext().getNext().getNext().setNext(new Node_Integer(5));
        head.getNext().getNext().getNext().getNext().setNext(new Node_Integer(2));

        // Value to partition around
        int x = 3;

        System.out.print("Original list: ");
        printList(head);

        // Partition the list
        PartitionALinkedListAtAPivotElement solution = new PartitionALinkedListAtAPivotElement();
        Node_Integer result = solution.partition(head, x);

        System.out.print("Partitioned list (x = " + x + "): ");
        printList(result);
    }

    public static void printList(Node_Integer head) {
        Node_Integer current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

    public Node_Integer partition(Node_Integer head, int x) {

        // Initialize two dummy nodes for the less and greater lists
        Node_Integer lessDummy = new Node_Integer(0);
        Node_Integer greaterDummy = new Node_Integer(0);

        // Pointers to build the two lists
        Node_Integer less = lessDummy;
        Node_Integer greater = greaterDummy;

        // Traverse the original list
        Node_Integer current = head;
        while (current != null) {
            if (current.getValue() < x) {
                // Add to less list
                less.setNext(current);
                less = less.getNext();
            } else {
                // Add to greater list
                greater.setNext(current);
                greater = greater.getNext();
            }
            current = current.getNext();
        }

        // Terminate the greater list
        greater.setNext(null);

        // Connect less list to greater list
        less.setNext(greaterDummy.getNext());

        // Return the head of the partitioned list
        return lessDummy.getNext();
    }

}

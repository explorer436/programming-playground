package com.my.company.datastructures.linkedlist.singlylinked;

public class DetectALoop {
    public boolean hasCycle(Node_Integer head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        Node_Integer tortoise = head;
        Node_Integer hare = head;

        while (hare != null && hare.getNext() != null) {
            tortoise = tortoise.getNext();      // Tortoise moves one step
            hare = hare.getNext().getNext();        // Hare moves two steps

            if (tortoise.getValue() == hare.getValue()) {
                return true; // Cycle detected
            }
        }
        return false; // Hare reached the end of the list, no cycle
    }

    public Node_Integer nodeInTheLoop(Node_Integer head) {
        if (head == null || head.getNext() == null) {
            return null;
        }

        Node_Integer tortoise = head;
        Node_Integer hare = head;

        while (hare != null && hare.getNext() != null) {
            tortoise = tortoise.getNext();      // Tortoise moves one step
            hare = hare.getNext().getNext();        // Hare moves two steps

            if (tortoise.getValue() == hare.getValue()) {
                return hare; // Cycle detected
            }
        }
        return null; // Hare reached the end of the list, no cycle
    }
}

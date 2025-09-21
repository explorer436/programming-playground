package com.my.company.datastructures.linkedlist.singlylinked;

public class FindIntersectionNode {

    public Node_Integer getIntersectionNode(Node_Integer headA, Node_Integer headB) {

        if (headA == null || headB == null) {
            return null;
        }

        Node_Integer pointerA = headA;
        Node_Integer pointerB = headB;

        while (pointerA.getValue() != pointerB.getValue()) {
            // If pointerA reaches the end of listA, move it to the head of listB.
            // Otherwise, move to the next node.
            if (pointerA.getNext() == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.getNext();
            }

            // If pointerB reaches the end of listB, move it to the head of listA.
            // Otherwise, move to the next node.
            if (pointerB.getNext() == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.getNext();
            }
        }

        return pointerA; // or pointerB, they are at the same node
    }

}

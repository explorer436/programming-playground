package com.my.company.datastructures.linkedlist.singlylinked;

public class AddTwoNumbers {

    public Node_Integer addTwoNumbersRepresentedInReverseOrder(Node_Integer node1, Node_Integer node2) {

        Node_Integer dummyHead = new Node_Integer(0);

        Node_Integer current = dummyHead;
        int carry = 0;

        while (node1 != null || node2 != null || carry != 0) {
            int x = (node1 != null) ? node1.getValue() : 0;
            int y = (node2 != null) ? node2.getValue() : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            current.setNext(new Node_Integer(sum % 10));
            current = current.getNext();

            if (node1 != null) {
                node1 = node1.getNext();
            }
            if (node2 != null) {
                node2 = node2.getNext();
            }
        }
        return dummyHead.getNext();
    }

    public Node_Integer addTwoNumbersRepresentedInExactOrder(Node_Integer node1, Node_Integer node2) {

        SinglyLinkedList_Integer list = new SinglyLinkedList_Integer();
        node1 = list.reverse_iterative(node1);
        node2 = list.reverse_iterative(node2);

        Node_Integer dummyHead = new Node_Integer(0);

        Node_Integer current = dummyHead;
        int carry = 0;

        while (node1 != null || node2 != null || carry != 0) {
            int x = (node1 != null) ? node1.getValue() : 0;
            int y = (node2 != null) ? node2.getValue() : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            current.setNext(new Node_Integer(sum % 10));
            current = current.getNext();

            if (node1 != null) {
                node1 = node1.getNext();
            }
            if (node2 != null) {
                node2 = node2.getNext();
            }
        }
        return dummyHead.getNext();
    }

}

package com.my.company.datastructures.linkedlist.singlylinked;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @Test
    public void test_FindALoop_1() {

        SinglyLinkedList_Integer list1 = new SinglyLinkedList_Integer();
        list1.append(3);
        list1.append(2);
        list1.append(1);
        SinglyLinkedList_Integer list2 = new SinglyLinkedList_Integer();
        list2.append(7);
        list2.append(8);
        list2.append(9);

        Node_Integer abc = addTwoNumbers.addTwoNumbersRepresentedInReverseOrder(list1.getHead(), list2.getHead());

        SinglyLinkedList_Integer.printList(abc); // 123 + 987 = 1110
    }

    @Test
    public void test_FindALoop_2() {

        SinglyLinkedList_Integer list1 = new SinglyLinkedList_Integer();
        list1.append(6);
        list1.append(5);
        list1.append(4);
        list1.append(3);
        SinglyLinkedList_Integer list2 = new SinglyLinkedList_Integer();
        list2.append(2);
        list2.append(1);

        Node_Integer abc = addTwoNumbers.addTwoNumbersRepresentedInReverseOrder(list1.getHead(), list2.getHead());

        SinglyLinkedList_Integer.printList(abc); // 12 + 3456 = 3468
    }

    @Test
    public void test_FindALoop_3() {

        SinglyLinkedList_Integer list1 = new SinglyLinkedList_Integer();
        list1.append(1);
        list1.append(2);
        list1.append(3);
        SinglyLinkedList_Integer list2 = new SinglyLinkedList_Integer();
        list2.append(9);
        list2.append(8);
        list2.append(7);

        Node_Integer abc = addTwoNumbers.addTwoNumbersRepresentedInExactOrder(list1.getHead(), list2.getHead());

        SinglyLinkedList_Integer.printList(abc); // 123 + 987 = 1110
    }

    @Test
    public void test_FindALoop_4() {

        SinglyLinkedList_Integer list1 = new SinglyLinkedList_Integer();
        list1.append(3);
        list1.append(4);
        list1.append(5);
        list1.append(6);
        SinglyLinkedList_Integer list2 = new SinglyLinkedList_Integer();
        list2.append(1);
        list2.append(2);

        Node_Integer abc = addTwoNumbers.addTwoNumbersRepresentedInExactOrder(list1.getHead(), list2.getHead());

        SinglyLinkedList_Integer.printList(abc); // 12 + 3456 = 3468
    }

}

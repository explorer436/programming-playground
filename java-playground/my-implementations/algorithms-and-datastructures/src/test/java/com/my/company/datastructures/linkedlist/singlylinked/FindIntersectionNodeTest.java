package com.my.company.datastructures.linkedlist.singlylinked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindIntersectionNodeTest {

    FindIntersectionNode findIntersectionNode = new FindIntersectionNode();

    @Test
    public void test_getIntersectionNode_2() {

        SinglyLinkedList_Integer list1 = new SinglyLinkedList_Integer(6);
        list1.append(5);
        list1.append(4);
        list1.append(3);

        SinglyLinkedList_Integer list2 = new SinglyLinkedList_Integer(2);
        list2.append(1);
        list2.append(3);
        list2.append(4);
        list2.append(7);

        Node_Integer abc = findIntersectionNode.getIntersectionNode(list1.getHead(), list2.getHead());

        assertEquals(4, abc.getValue());
    }

}

package com.my.company.datastructures.linkedlist.singlylinked.EmployeeList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeSinglyLinkedListTests {
    @Test
    public void test() {
        Employee janeJones = new Employee(123, "Jane", "Jones");
        Employee johnDoe = new Employee(4567, "John", "Dow");
        Employee marySmith = new Employee(22, "Mary", "Smith");
        Employee mikeWilson = new Employee(3245, "Mike", "Wilson");

        EmployeeSinglyLinkedList list = new EmployeeSinglyLinkedList();

        list.prepend(janeJones);
        assertEquals(list.size, 1);
        assertEquals(list.head.getEmployee(), janeJones);
        assertEquals(list.head.getNext(), null);

        list.prepend(johnDoe);
        assertEquals(list.size, 2);
        assertEquals(list.head.getEmployee(), johnDoe);
        Node nextNode = list.head.getNext();
        assertEquals(nextNode.getEmployee(), janeJones);
        assertEquals(nextNode.getNext(), null);

        list.prepend(marySmith);
        assertEquals(list.size, 3);
        assertEquals(list.head.getEmployee(), marySmith);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getEmployee(), johnDoe);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getEmployee(), janeJones);
        assertEquals(nextNode.getNext(), null);

        list.prepend(mikeWilson);
        assertEquals(list.size, 4);
        assertEquals(list.head.getEmployee(), mikeWilson);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getEmployee(), marySmith);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getEmployee(), johnDoe);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getEmployee(), janeJones);
        assertEquals(nextNode.getNext(), null);

        list.removeFromFront();
        assertEquals(list.size, 3);
        assertEquals(list.head.getEmployee(), marySmith);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getEmployee(), johnDoe);
        nextNode = nextNode.getNext();
        assertEquals(nextNode.getEmployee(), janeJones);
        assertEquals(nextNode.getNext(), null);

        list.removeFromFront();
        assertEquals(list.size, 2);
        assertEquals(list.head.getEmployee(), johnDoe);
        nextNode = list.head.getNext();
        assertEquals(nextNode.getEmployee(), janeJones);
        assertEquals(nextNode.getNext(), null);

        list.removeFromFront();
        assertEquals(list.size, 1);
        assertEquals(list.head.getEmployee(), janeJones);
        assertEquals(list.head.getNext(), null);

        list.removeFromFront();
        assertEquals(list.isEmpty(), true);
    }
}

package com.my.company.datastructures.linkedlist.doublylinked.employeelist;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeDoublyLinkedListTest {
    @org.junit.jupiter.api.Test
    public void test() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.prepend(janeJones);
        assertEquals(list.getSize(), 1);
        assertEquals(list.getHead().getEmployee(), janeJones);
        assertEquals(list.getTail().getEmployee(), janeJones);
        assertEquals(list.getHead().getNext(), null);
        assertEquals(list.traverseForward(), janeJones.toString());

        list.prepend(johnDoe);
        assertEquals(list.getSize(), 2);
        assertEquals(list.getHead().getEmployee(), johnDoe);
        assertEquals(list.getTail().getEmployee(), janeJones);
        Node next = list.getHead().getNext();
        assertEquals(next.getEmployee(), janeJones);
        assertEquals(next.getPrevious().getEmployee(), johnDoe);
        next = next.getNext();
        assertEquals(next, null);
        assertEquals(list.traverseForward(), johnDoe.toString() + janeJones.toString());
        assertEquals(list.traverseBackward(), janeJones.toString() + johnDoe.toString());

        list.prepend(marySmith);
        assertEquals(list.getSize(), 3);
        assertEquals(list.getHead().getEmployee(), marySmith);
        assertEquals(list.getTail().getEmployee(), janeJones);
        next = list.getHead().getNext();
        assertEquals(next.getEmployee(), johnDoe);
        assertEquals(next.getPrevious().getEmployee(), marySmith);
        next = next.getNext();
        assertEquals(next.getEmployee(), janeJones);
        assertEquals(next.getPrevious().getEmployee(), johnDoe);
        next = next.getNext();
        assertEquals(next, null);
        assertEquals(list.traverseForward(), marySmith.toString() + johnDoe.toString() + janeJones.toString());
        assertEquals(list.traverseBackward(), janeJones.toString() + johnDoe.toString() + marySmith.toString());

        list.prepend(mikeWilson);
        assertEquals(list.getSize(), 4);
        assertEquals(list.getHead().getEmployee(), mikeWilson);
        assertEquals(list.getTail().getEmployee(), janeJones);
        next = list.getHead().getNext();
        assertEquals(next.getEmployee(), marySmith);
        assertEquals(next.getPrevious().getEmployee(), mikeWilson);
        next = next.getNext();
        assertEquals(next.getEmployee(), johnDoe);
        assertEquals(next.getPrevious().getEmployee(), marySmith);
        next = next.getNext();
        assertEquals(next.getEmployee(), janeJones);
        assertEquals(next.getPrevious().getEmployee(), johnDoe);
        next = next.getNext();
        assertEquals(next, null);
        assertEquals(list.traverseForward(), mikeWilson.toString() + marySmith.toString() + johnDoe.toString() + janeJones.toString());
        assertEquals(list.traverseBackward(), janeJones.toString() + johnDoe.toString() + marySmith.toString() + mikeWilson.toString());

        Employee billEnd = new Employee("Bill", "End", 78);
        list.append(billEnd);
        assertEquals(list.getSize(), 5);
        assertEquals(list.getHead().getEmployee(), mikeWilson);
        assertEquals(list.getTail().getEmployee(), billEnd);
        next = list.getHead().getNext();
        assertEquals(next.getEmployee(), marySmith);
        assertEquals(next.getPrevious().getEmployee(), mikeWilson);
        next = next.getNext();
        assertEquals(next.getEmployee(), johnDoe);
        assertEquals(next.getPrevious().getEmployee(), marySmith);
        next = next.getNext();
        assertEquals(next.getEmployee(), janeJones);
        assertEquals(next.getPrevious().getEmployee(), johnDoe);
        next = next.getNext();
        assertEquals(next.getEmployee(), billEnd);
        assertEquals(next.getPrevious().getEmployee(), janeJones);
        next = next.getNext();
        assertEquals(next, null);
        assertEquals(list.traverseForward(), mikeWilson.toString() + marySmith.toString() + johnDoe.toString() + janeJones.toString() + billEnd.toString());
        assertEquals(list.traverseBackward(), billEnd.toString() + janeJones.toString() + johnDoe.toString() + marySmith.toString() + mikeWilson.toString());

        list.removeFromFront();
        assertEquals(list.getSize(), 4);
        assertEquals(list.getHead().getEmployee(), marySmith);
        assertEquals(list.getTail().getEmployee(), billEnd);
        next = list.getHead().getNext();
        assertEquals(next.getEmployee(), johnDoe);
        assertEquals(next.getPrevious().getEmployee(), marySmith);
        next = next.getNext();
        assertEquals(next.getEmployee(), janeJones);
        assertEquals(next.getPrevious().getEmployee(), johnDoe);
        next = next.getNext();
        assertEquals(next.getEmployee(), billEnd);
        assertEquals(next.getPrevious().getEmployee(), janeJones);
        next = next.getNext();
        assertEquals(next, null);
        assertEquals(list.traverseForward(), marySmith.toString() + johnDoe.toString() + janeJones.toString() + billEnd.toString());
        assertEquals(list.traverseBackward(), billEnd.toString() + janeJones.toString() + johnDoe.toString() + marySmith.toString());

        list.removeFromEnd();
        assertEquals(list.getSize(), 3);
        assertEquals(list.getHead().getEmployee(), marySmith);
        assertEquals(list.getTail().getEmployee(), janeJones);
        next = list.getHead().getNext();
        assertEquals(next.getEmployee(), johnDoe);
        assertEquals(next.getPrevious().getEmployee(), marySmith);
        next = next.getNext();
        assertEquals(next.getEmployee(), janeJones);
        assertEquals(next.getPrevious().getEmployee(), johnDoe);
        next = next.getNext();
        assertEquals(next, null);
        assertEquals(list.traverseForward(), marySmith.toString() + johnDoe.toString() + janeJones.toString());
        assertEquals(list.traverseBackward(), janeJones.toString() + johnDoe.toString() + marySmith.toString());

        Employee jamesBond = new Employee("James", "Bond", 007);
        list.insertBeforeAnExistingNode(jamesBond, johnDoe);
        assertEquals(list.getSize(), 4);
        assertEquals(list.getHead().getEmployee(), marySmith);
        assertEquals(list.getTail().getEmployee(), janeJones);
        next = list.getHead().getNext();
        assertEquals(next.getEmployee(), jamesBond);
        assertEquals(next.getPrevious().getEmployee(), marySmith);
        next = next.getNext();
        assertEquals(next.getEmployee(), johnDoe);
        assertEquals(next.getPrevious().getEmployee(), jamesBond);
        next = next.getNext();
        assertEquals(next.getEmployee(), janeJones);
        assertEquals(next.getPrevious().getEmployee(), johnDoe);
        next = next.getNext();
        assertEquals(next, null);
        assertEquals(list.traverseForward(), marySmith.toString() + jamesBond.toString() + johnDoe.toString() + janeJones.toString());
        assertEquals(list.traverseBackward(), janeJones.toString() + johnDoe.toString() + jamesBond.toString() + marySmith.toString());
    }
}

package datastructures.linkedlist.singlyLinkedIntegerList;

public class IntegerLinkedListClient {

	public static void main(String[] args) {
		SortedIntegerLinkedList list = new SortedIntegerLinkedList();
		System.out.println("-------------------");
		list.insertSorted(3);
		list.printList();
		
		System.out.println("-------------------");
		list.insertSorted(6);
		list.printList();
		
		System.out.println("-------------------");
		list.insertSorted(9);
		list.printList();
		
		System.out.println("-------------------");
		list.insertSorted(7);
		list.printList();

	}

}

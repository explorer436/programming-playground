package com.my.company.datastructures.linkedlist.singlylinked;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSublists {

    public Node_Integer removeZeroSumSublists(Node_Integer head) {

        // Create a dummy node to handle cases where the head itself needs to be removed
        Node_Integer dummy = new Node_Integer(0);
        dummy.setNext(head);

        // Use a HashMap to store the running sum and the corresponding node
        // This helps us find where a previous sum occurred
        Map<Integer, Node_Integer> map = new HashMap<>();
        map.put(0, dummy); // Initialize with sum 0 pointing to the dummy node

        int currentSum = 0;
        Node_Integer current = dummy.getNext();

        while (current != null) {
            currentSum += current.getValue();

            if (map.containsKey(currentSum)) {

                // If the currentSum has been seen before, it means the nodes between
                // the previous occurrence of this sum and the current node sum to zero.

                Node_Integer prev = map.get(currentSum);
                Node_Integer toRemove = prev.getNext();
                int sum = currentSum;

                // Remove entries from the map for the nodes that are being removed
                // This is crucial for handling multiple zero-sum sublists

                while (toRemove != current) {
                    sum += toRemove.getValue();
                    map.remove(sum);
                    toRemove = toRemove.getNext();
                }
                prev.setNext(current.getNext()); // Link the node before the zero-sum sublist to the node after it
            } else {

                // If the currentSum is new, add it to the map

                map.put(currentSum, current);
            }
            current = current.getNext();
        }

        return dummy.getNext();
    }

    public static void printList(Node_Integer head) {
        Node_Integer current = head;
        while (current != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example 1: 1 -> 2 -> -3 -> 3 -> 1
        // Expected: 1 -> 1 (since 2 -> -3 -> 3 sums to 2)
        // Oops, 2 -> -3 -> 3 sums to 2, not 0.
        // The actual zero sum sublist is 2 -> -3 -> 3 -> 1 where the sum from 2 to -3 is -1, 2 to 3 is 2
        // Wait, the correct output should be 1 -> 1.  2, -3, 3 sums to 2.
        // Let's reconsider. 1 -> [2 -> -3 -> 1] -> 3.  2, -3, 1 sums to 0. So 1 -> 3
        // Or consider 1 -> 2 -> -3 -> 3 -> 1.
        // sum = 1, map {0:dummy, 1:1}
        // sum = 1+2=3, map {0:dummy, 1:1, 3:2}
        // sum = 3-3=0, map {0:dummy, 1:1, 3:2, 0:3 (overrides)}  <- Here, 0 exists. Prev node for 0 is dummy.
        // Dummy.next = 3.next = 3.
        // Remove map entries for 1,2,-3.
        // So the list becomes 3 -> 1.
        // But the problem says "consecutive nodes that sum to zero".
        // [2, -3, 3] sum to 2. Not 0.
        // [1, 2, -3] sum to 0. So it becomes 3 -> 1.
        // Let's trace carefully:
        // 1 -> 2 -> -3 -> 3 -> 1
        // dummy -> 1 -> 2 -> -3 -> 3 -> 1
        // currentSum = 0, map = {0: dummy}

        // current = 1
        // currentSum = 1, map = {0: dummy, 1: 1}

        // current = 2
        // currentSum = 1 + 2 = 3, map = {0: dummy, 1: 1, 3: 2}

        // current = -3
        // currentSum = 3 + (-3) = 0. Map contains 0.
        // prev = map.get(0) = dummy
        // toRemove = prev.next = 1
        // sum = 0
        // Loop:
        //   toRemove = 1, current = -3. sum = 0 + 1 = 1. map.remove(1). toRemove = 2.
        //   toRemove = 2, current = -3. sum = 1 + 2 = 3. map.remove(3). toRemove = -3.
        //   toRemove = -3, current = -3. Loop terminates.
        // prev.next = current.next (dummy.next = -3.next = 3)
        // List becomes dummy -> 3 -> 1
        // current = 3

        // current = 3
        // currentSum = 0 + 3 = 3. Map contains 3.
        // prev = map.get(3) = (This would be the node 2 that was removed. This is a problem.)
        // This means when we remove nodes, we should also remove their entries from the map.
        // The fix is to clear out the map entries for the nodes that are being bypassed.

        // Let's re-trace with the fix in mind:
        // 1 -> 2 -> -3 -> 3 -> 1
        // dummy -> 1 -> 2 -> -3 -> 3 -> 1
        // currentSum = 0, map = {0: dummy}

        // current = 1
        // currentSum = 1, map = {0: dummy, 1: 1}

        // current = 2
        // currentSum = 3, map = {0: dummy, 1: 1, 3: 2}

        // current = -3
        // currentSum = 0. Map contains 0.
        // prev = map.get(0) = dummy
        // toRemove = prev.next = 1
        // sum = currentSum (which is 0)
        // Loop to clear map entries for nodes between prev and current:
        //   toRemove = 1 (val 1). Sum during removal: sum = 0 + 1 = 1. map.remove(1). toRemove = 2.
        //   toRemove = 2 (val 2). Sum during removal: sum = 1 + 2 = 3. map.remove(3). toRemove = -3.
        // Loop ends as toRemove is now -3, which is current.
        // map is now {0: dummy}
        // prev.next = current.next (dummy.next = -3.next = 3)
        // List now: dummy -> 3 -> 1
        // current = 3

        // current = 3
        // currentSum = 0 + 3 = 3. Map does not contain 3 (since it was removed earlier).
        // So add it: map = {0: dummy, 3: 3}
        // current = 1

        // current = 1
        // currentSum = 3 + 1 = 4. Map does not contain 4.
        // So add it: map = {0: dummy, 3: 3, 4: 1}
        // current = null

        // Result: 3 -> 1. This matches the example where 1, 2, -3 sum to 0.

        // Example from LeetCode: head = [1,2,-3,3,1]
        Node_Integer head1 = new Node_Integer(1);
        head1.setNext(new Node_Integer(2));
        head1.getNext().setNext(new Node_Integer(-3));
        head1.getNext().getNext().setNext(new Node_Integer(3));
        head1.getNext().getNext().getNext().setNext(new Node_Integer(1));
        System.out.print("Original list 1: ");
        printList(head1);
        RemoveZeroSumSublists removeZeroSumSublists = new RemoveZeroSumSublists();
        Node_Integer result1 = removeZeroSumSublists.removeZeroSumSublists(head1);
        System.out.print("Modified list 1: ");
        printList(result1); // Expected: 3 -> 1

        System.out.println("---");

        // Example 2: 1 -> 2 -> 3 -> -3 -> 4
        // Expected: 1 -> 2 -> 4
        Node_Integer head2 = new Node_Integer(1);
        head2.setNext(new Node_Integer(2));
        head2.getNext().setNext(new Node_Integer(3));
        head2.getNext().getNext().setNext(new Node_Integer(-3));
        head2.getNext().getNext().getNext().setNext(new Node_Integer(4));
        System.out.print("Original list 2: ");
        printList(head2);
        Node_Integer result2 = removeZeroSumSublists.removeZeroSumSublists(head2);
        System.out.print("Modified list 2: ");
        printList(result2); // Expected: 1 -> 2 -> 4

        System.out.println("---");

        // Example 3: 1 -> 2 -> 3 -> -3 -> -2
        // Expected: 1
        Node_Integer head3 = new Node_Integer(1);
        head3.setNext(new Node_Integer(2));
        head3.getNext().setNext(new Node_Integer(3));
        head3.getNext().getNext().setNext(new Node_Integer(-3));
        head3.getNext().getNext().getNext().setNext(new Node_Integer(-2));
        System.out.print("Original list 3: ");
        printList(head3);
        Node_Integer result3 = removeZeroSumSublists.removeZeroSumSublists(head3);
        System.out.print("Modified list 3: ");
        printList(result3); // Expected: 1

        System.out.println("---");

        // Example 4: 1 -> -1
        // Expected: null
        Node_Integer head4 = new Node_Integer(1);
        head4.setNext(new Node_Integer(-1));
        System.out.print("Original list 4: ");
        printList(head4);
        Node_Integer result4 = removeZeroSumSublists.removeZeroSumSublists(head4);
        System.out.print("Modified list 4: ");
        printList(result4); // Expected: null

        System.out.println("---");

        // Example 5: 3 -> 2 -> -2 -> 1
        // Expected: 3 -> 1
        Node_Integer head5 = new Node_Integer(3);
        head5.setNext(new Node_Integer(2));
        head5.getNext().setNext(new Node_Integer(-2));
        head5.getNext().getNext().setNext(new Node_Integer(1));
        System.out.print("Original list 5: ");
        printList(head5);
        Node_Integer result5 = removeZeroSumSublists.removeZeroSumSublists(head5);
        System.out.print("Modified list 5: ");
        printList(result5); // Expected: 3 -> 1

        System.out.println("---");

        // Example 6: 0 -> 0 -> 0
        // Expected: null
        Node_Integer head6 = new Node_Integer(0);
        head6.setNext(new Node_Integer(0));
        head6.getNext().setNext(new Node_Integer(0));
        System.out.print("Original list 6: ");
        printList(head6);
        Node_Integer result6 = removeZeroSumSublists.removeZeroSumSublists(head6);
        System.out.print("Modified list 6: ");
        printList(result6); // Expected: null
    }

}

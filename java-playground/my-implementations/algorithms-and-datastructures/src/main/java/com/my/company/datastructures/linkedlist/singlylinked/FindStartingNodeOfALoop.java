package com.my.company.datastructures.linkedlist.singlylinked;

public class FindStartingNodeOfALoop {

    DetectALoop detectALoop  = new DetectALoop();

    public Node_Integer findStartingNodeOfALoop(Node_Integer head) {
        if (detectALoop.hasCycle(head)) {

            Node_Integer tortoise = head;
            Node_Integer hare = detectALoop.nodeInTheLoop(head);

            while (tortoise.getValue() != hare.getValue()) {
                hare = hare.getNext();
                tortoise = tortoise.getNext();
            }

            return tortoise;
        }

        return null;
    }

}

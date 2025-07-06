package com.my.company.lru_cache_implementation;

import java.util.HashMap;

public class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            // move the old node to index 0 of the data structure
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }

        return -1;
    }

    public void remove(Node n) {

        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            existingNode.value = value;
            if (existingNode != head) {
                // move the existingNode node to index 0 of the data structure
                remove(existingNode);
                setHead(existingNode);
            }
        } else {
            Node created = new Node(key, value);

            /*
             * 1) When the cache is reaches its max capacity,
             *    1. remove the end of the list.
             *    2. remove the entry from the hash table.
             */
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }

            map.put(key, created);
        }
    }

    private void setHead(Node newNode) {

        newNode.pre = null;

        // previous head is now the second node
        if (head != null) {
            head.pre = newNode;
            newNode.next = head;
        }

        // newNode is now the current head
        head = newNode;

        // if this is the only node in the Cache
        if (end == null) {
            end = head;
        }
    }
}

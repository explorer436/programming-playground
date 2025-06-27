package com.my.company.lru_cache_implementation;

import java.util.HashMap;

public class LRUCache {

    /*
     * There is only a few details to make it better.
     *
     * 1) When the cache is reaches its max capacity you only remove the end of the
     * list. You should also remove the entry from the hash table.
     *
     * if(map.size()>=capacity) {
     * map.remove(end.key);
     * remove(end);
     * setHead(newnode);
     * }
     *
     * 2) Don't forget to update capacity every time you add a new node.
     */

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

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            // move the old node to index 0 of the data structure
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);

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

    private void setHead(Node n) {
        n.next = head;
        n.pre = null;

        if (head != null) {
            head.pre = n;
        }

        head = n;

        if (end == null) {
            end = head;
        }
    }
}

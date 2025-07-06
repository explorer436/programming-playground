package com.my.company.lfu_cache_implementation;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    // Tracks the minimum frequency
    private int minFreq;

    // Capacity of the LFU cache
    private int capacity;

    HashMap<Integer, Node> cacheMap;
    private Map<Integer, Pair<Node, Node>> frequencyMap;

    // Node head = null;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        // Initial minimum frequency is 0
        minFreq = 0;
        cacheMap = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {

        if (cacheMap.containsKey(key)) {

            Node node = cacheMap.get(key);
            updateFreq(node);

            return node.value;
        }

        return -1;
    }

    // Update the frequency of a node
    void updateFreq(Node node) {

        // Get the current frequency
        int oldFreq = node.count;

        // Increment the frequency
        node.count++;

        // Remove the node from the current frequency list
        remove(node);
        if (frequencyMap.get(oldFreq).getLeft().next == frequencyMap.get(oldFreq).getRight()) {
            frequencyMap.remove(oldFreq);

            // Update minimum frequency if needed
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }

        // Add the node to the updated frequency list
        add(node, node.count);
    }

    // Remove a node from the list
    void remove(Node node) {

        // Update pointers to exclude the node
        Node delprev = node.prev;
        Node delnext = node.next;

        delprev.next = delnext;
        delnext.prev = delprev;
    }

    // Add a node right after the head
    void add(Node node, int freq) {

        // Initialize the frequency list if it doesn't exist
        if (!frequencyMap.containsKey(freq)) {

            // Dummy head node
            Node head = new Node(-1, -1);

            // Dummy tail node
            Node tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
            frequencyMap.put(freq, new ImmutablePair(head, tail));
        }

        // Insert the node right after the head
        Node head = frequencyMap.get(freq).getLeft();
        // Previous second now becomes third.
        Node previousSecond = head.next;
        node.next = previousSecond;
        node.prev = head;
        head.next = node;
        previousSecond.prev = node;
    }

    // Function to put a key-value pair into the cache
    void put(int key, int value) {

        // Do nothing if the cache has zero capacity
        if (capacity == 0) {
            return;
        }

        // Update value if key already exists in the cache
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            updateFreq(node);
        }

        // Add a new key-value pair to the cache
        else {

            // Remove the least frequently used node if cache is full
            if (cacheMap.size() == capacity) {
                Node node = frequencyMap.get(minFreq).getRight().prev;
                cacheMap.remove(node.key);
                remove(node);

                // Remove the frequency list if it's empty
                if (frequencyMap.get(minFreq).getLeft().next == frequencyMap.get(minFreq).getRight()) {
                    frequencyMap.remove(minFreq);
                }
            }

            // Create a new node for the key-value pair
            Node node = new Node(key, value);
            cacheMap.put(key, node);

            // Reset minimum frequency to 1
            minFreq = 1;
            add(node, 1);
        }
    }
}

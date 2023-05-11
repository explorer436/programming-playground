package com.my.company.datastructures.stack;

/**
 * Fixed-capacity stack.
 *
 * <p>As a strawman, we consider an abstract data type for a fixed- capacity stack of strings. The
 * API differs from our Stack API: it works only for String values, it requires the client to
 * specify a capacity, and it does not support iteration. The primary choice in developing an API
 * implementation is to choose a representation for the data. For FixedCapacityStackOfStrings, an
 * obvious choice is to use an array of String values. Pursuing this choice leads to the
 * implementation shown at the bottom on the opposite page, which could hardly be simpler (each
 * method is a one-liner). The instance variables are an array a[] that holds the items in the stack
 * and an integer N that counts the number of items in the stack. To remove an item, we decrement N
 * and then return a[N]; to insert a new item, we set a[N] equal to the new item and then increment
 * N.
 *
 * <p>These operations preserve the following properties: ■ The items in the array are in their
 * insertion order. ■ The stack is empty when N is 0 . ■ The top of the stack (if it is nonempty) is
 * at a[N-1] .
 *
 * <p>As usual, thinking in terms of invariants of this sort is the easiest way to verify that an
 * implementation operates as intended. Be sure that you fully understand this implementation. The
 * best way to do so is to examine a trace of the stack contents for a sequence of operations, as
 * illustrated at left for the test client, which reads strings from standard input and pushes each
 * string onto a stack, unless it is "-" , when it pops the stack and prints the result. The primary
 * performance characteristic of this implementation is that the push and pop operations take time
 * independent of the stack size. For many applications, it is the method of choice because of its
 * simplicity.
 *
 * <p>But it has several drawbacks that limit its potential applicability as a general-purpose tool,
 * which we now address. With a moderate amount of effort (and some help from Java language
 * mechanisms), we can develop an implementation that is broadly useful. This effort is worthwhile
 * because the implementations that we develop serve as a model for implementations of other, more
 * powerful, abstract data types throughout the book.
 */

// An abstract data type for a fixed-capacity stack of strings
public class FixedCapacityStackOfStrings {

    private String[] a; // stack entries
    private int N; // size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public static void main(String[] args) {
    }
}

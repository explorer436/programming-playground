package com.my.company.datastructures.stack;

// See FixedCapacityStackOfStrings.java

/**
 * Generics:
 *
 * <p>The first drawback of FixedCapacityStackOfStrings is that it works only for String objects. If
 * we want a stack of double values, we would need to develop another class with similar code,
 * essentially replacing String with double everywhere.
 *
 * <p>This is easy enough but becomes burdensome when we consider building a stack of Transaction
 * values or a queue of Date values, and so forth.
 *
 * <p>Java’s parameterized types (generics) are specifically designed to address this situation, and
 * we saw several examples of client code. But how do we implement a generic stack? The code below
 * shows the details. It implements a class FixedCapacityStack that differs from
 * FixedCapacityStackOfStrings — we replace every occurrence of String with Item (with one
 * exception, discussed below) and declare the class with the following first line of code: public
 * class FixedCapacityStack<Item>
 *
 * <p>The name Item is a type parameter, a symbolic placeholder for some concrete type to be used by
 * the client. You can read FixedCapacityStack<Item> as stack of items, which is precisely what we
 * want. When implementing FixedCapacityStack, we do not know the actual type of Item, but a client
 * can use our stack for any type of data by providing a concrete type when the stack is created.
 * Concrete types must be reference types, but clients can depend on autoboxing to convert primitive
 * types to their corresponding wrapper types. Java uses the type parameter Item to check for type
 * mismatch errors— even though no concrete type is yet known, variables of type Item must be
 * assigned values of type Item, and so forth. But there is one significant hitch in this story: We
 * would like to implement the constructor in FixedCapacityStack with the code a = new Item[cap];
 * which calls for creation of a generic array. For historical and technical reasons beyond our
 * scope, generic array creation is disallowed in Java. Instead, we need to use a cast: a = (Item[])
 * new Object[cap]; This code produces the desired effect (though the Java compiler gives a warning,
 * which we can safely ignore), and we use this idiom throughout the book (the Java system library
 * implementations of similar abstract data types use the same idiom).
 */

// An abstract data type for a fixed-capacity generic stack
public class FixedCapacityStack<Item> {

  private Item[] a;
  // stack entries
  private int N;
  // size

  public FixedCapacityStack(int cap) {
    a = (Item[]) new Object[cap];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    a[N++] = item;
  }

  public Item pop() {
    return a[--N];
  }

  public static void main(String[] args) {}
}

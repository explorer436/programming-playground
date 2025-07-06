package com.my.company.datastructures.arrays;

public class ArrayResizing<Item> {

  public static void main(String[] args) {}

  // stack entries
  private Item[] a;

  // size
  private int N;

  private void resize(int max) {
    // Move stack of size N <= max to a new array of size max.
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++) temp[i] = a[i];
    a = temp;
  }

  public void push(Item item) {
    // Add item to top of stack.
    if (N == a.length) {
      resize(2 * a.length);
    }
    a[N++] = item;
  }

  public Item pop() {
    // Remove item from top of stack.
    Item item = a[--N];
    a[N] = null;

    // Avoid loitering (see text).
    if (N > 0 && N == a.length / 4) {
      resize(a.length / 2);
    }

    return item;
  }
}

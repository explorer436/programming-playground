package com.my.company.datastructures.trees;

public class Tree {

  // TODO Make this generic to support all the different types of trees
  // https://www.cs.cmu.edu/~clo/www/CMU/DataStructures/Lessons/lesson4_1.htm#:~:text=A%20tree%20is%20a%20collection,which%20are%20linear%20data%20structures

  private BinaryNode root;

  public void insert(int value) {
    if (root == null) {
      root = new BinaryNode(value);
    } else {
      root.insert(value);
    }
  }

  public void traverseInOrder() {
    if (root != null) {
      root.traverseInOrder();
    }
  }

  public void traversePreOrder() {
    if (root != null) {
      root.traversePreOrder();
    }
  }

  public BinaryNode get(int value) {
    if (root != null) {
      return root.get(value);
    } else {
      return null;
    }
  }

  public int min() {
    if (root == null) {
      return Integer.MIN_VALUE;
    } else {
      return root.min();
    }
  }

  public int max() {
    if (root == null) {
      return Integer.MAX_VALUE;
    } else {
      return root.max();
    }
  }

  public void delete(int value) {
    root = delete(root, value);
  }

  // this will basically return the replacement node - if there is a replacement node.
  private BinaryNode delete(BinaryNode subTreeRoot, int value) {
    if (subTreeRoot == null) {
      // this means that the tree is empty.
      return null;
    } else if (value < subTreeRoot.getData()) {
      subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
    } else if (value > subTreeRoot.getData()) {
      subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
    } else if (value == subTreeRoot.getData()) {
      // the element that we want to delete is the subTreeRoot.

      // when the node is the leaf or the node has one (left or right) child.
      if (subTreeRoot.getLeftChild() == null) {
        return subTreeRoot.getRightChild();
      } else if (subTreeRoot.getRightChild() == null) {
        return subTreeRoot.getLeftChild();
      }

      // the node to delete has two children.

      // we want to find the minimum value in the right subTree.
      // Replace the value in the subTreeRoot node with the smallest value from the right subtree.
      subTreeRoot.setData(subTreeRoot.getRightChild().min());

      // now we have to delete the rightChild.min() - (which is now subTreeRoot.data) element.
      // Delete the node that has the smallest value in the right subtree.
      subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
    }

    // if we reach this point, it means that the subTreeRoot is not the node that we want to delete.
    return subTreeRoot;
  }
}

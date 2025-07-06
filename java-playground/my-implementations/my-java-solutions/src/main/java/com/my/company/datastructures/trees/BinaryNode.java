package com.my.company.datastructures.trees;

public class BinaryNode {

  private int data;

  private BinaryNode leftChild;

  private BinaryNode rightChild;

  public BinaryNode(int data) {
    super();
    this.data = data;
  }

  public void insert(int value) {
    if (value == data) {
      // It is a duplicate.
      // We don't want to support duplicates. So, don't do anything.
      return;
    } else if (value < data) {
      if (leftChild == null) {
        leftChild = new BinaryNode(value);
      } else {
        leftChild.insert(value);
      }
    } else if (value > data) {
      if (rightChild == null) {
        rightChild = new BinaryNode(value);
      } else {
        rightChild.insert(value);
      }
    }
  }

  public void traverseInOrder() {
    // visit the leftChild first.
    if (leftChild != null) {
      leftChild.traverseInOrder();
    }

    // visit the current node.
    System.out.print(data + ", ");

    // And then, visit the rightChild.
    if (rightChild != null) {
      rightChild.traverseInOrder();
    }
  }

  public void traversePreOrder() {
    // visit the current node.
    System.out.print(data + ", ");

    // after that, visit the leftChild.
    if (leftChild != null) {
      leftChild.traversePreOrder();
    }

    // And then, visit the rightChild.
    if (rightChild != null) {
      rightChild.traversePreOrder();
    }
  }

  public BinaryNode get(int value) {
    if (value == data) {
      return this;
    } else if (value < data) {
      if (leftChild != null) {
        return leftChild.get(value);
      }
    } else if (value > data) {
      if (rightChild != null) {
        return rightChild.get(value);
      }
    }

    return null;
  }

  public int min() {
    if (leftChild == null) {
      return data;
    } else {
      return leftChild.min();
    }
  }

  public int max() {
    if (rightChild == null) {
      return data;
    } else {
      return rightChild.max();
    }
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public BinaryNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(BinaryNode leftChild) {
    this.leftChild = leftChild;
  }

  public BinaryNode getRightChild() {
    return rightChild;
  }

  public void setRightChild(BinaryNode rightChild) {
    this.rightChild = rightChild;
  }

  @Override
  public String toString() {
    return "TreeNode [data=" + data + "]";
  }
}

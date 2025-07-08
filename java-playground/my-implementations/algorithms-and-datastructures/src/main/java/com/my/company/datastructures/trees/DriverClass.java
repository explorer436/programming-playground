package com.my.company.datastructures.trees;

public class DriverClass {

  public static void main(String[] args) {
    Tree intTree = getTree();

    /*
    * 	In-order (LNR)
    1. Traverse the left subtree by recursively calling the in-order function.
    2. Access the data part of the current node.
    3. Traverse the right subtree by recursively calling the in-order function.
    In a binary search tree ordered such that in each node the key is greater than all keys in its left subtree and
    less than all keys in its right subtree, in-order traversal retrieves the keys in ascending sorted order.
    */
    intTree.traverseInOrder();
    // 15, 17, 20, 22, 25, 26, 27, 29, 30, 32

    System.out.println("");

    //    What do L, R and N stand for?
    //    (L)	Recursively traverse N's left subtree.
    //    (R)	Recursively traverse N's right subtree.
    //    (N)	Process the current node N itself.

    /*
    *	Pre-order (NLR)
    1. Access the data part of the current node.
    2. Traverse the left subtree by recursively calling the pre-order function.
    3. Traverse the right subtree by recursively calling the pre-order function.
    The pre-order traversal is a topologically sorted one, because a parent node is processed before any of its child nodes is done.
    */
    intTree.traversePreOrder();
    // 25, 20, 15, 17, 22, 27, 26, 30, 29, 32

    // TODO implement post order and reverse order traversals.

    /*
    * 	Post-order (LRN)
    1. Traverse the left subtree by recursively calling the post-order function.
    2. Traverse the right subtree by recursively calling the post-order function.
    3. Access the data part of the current node.
    */

    /*
    * 	Reverse in-order (RNL)
    Traverse the right subtree by recursively calling the reverse in-order function.
    Access the data part of the current node.
    Traverse the left subtree by recursively calling the reverse in-order function.
    In a binary search tree, reverse in-order traversal retrieves the keys in descending sorted order.
    */

    System.out.println("");

    System.out.println(intTree.get(27));
    System.out.println(intTree.get(17));
    System.out.println(intTree.get(8888));

    System.out.println("");

    System.out.println(intTree.min());
    System.out.println(intTree.max());

    System.out.println("");
    System.out.println("done");

    System.out.println("");

    // intTree.delete(15);
    // intTree.traverseInOrder();

    // intTree.delete(27);
    // intTree.traverseInOrder();

    // intTree.delete(25);
    // intTree.traverseInOrder();

    // intTree.delete(8888);
    // intTree.traverseInOrder();
  }

  private static Tree getTree() {
    Tree intTree = new Tree();
    intTree.insert(25);
    intTree.insert(20);
    intTree.insert(15);
    intTree.insert(27);
    intTree.insert(30);
    intTree.insert(29);
    intTree.insert(26);
    intTree.insert(22);
    intTree.insert(32);
    intTree.insert(17);

    /** 25 / \ / \ / \ 20 27 / \ / \ / \ / \ 15 22 26 30 \ / \ 17 29 32 */

    return intTree;
  }
}

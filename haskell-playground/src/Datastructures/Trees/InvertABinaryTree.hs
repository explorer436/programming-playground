module Datastructures.Trees.InvertABinaryTree (invertTree) where
  
import Datastructures.Trees.MyBinaryTree (Tree (..))

{- |
    Hi, here's your problem today. This problem was recently asked by Twitter:
    
    You are given the root of a binary tree.
    Invert the binary tree in place.
    That is, all left children should become right children, and all right children should become left children.
    
    Example:
    
        a
       / \
      b   c
     / \  /
    d   e f
    
    
    The inverted version of this tree is as follows:
    
      a
     / \
     c  b
     \  / \
      f e  d
    
    
    Here is the function signature:
    
    class Node:
      def __init__(self, value):
        self.left = None
        self.right = None
        self.value = value
      def preorder(self):
        print self.value,
        if self.left: self.left.preorder()
        if self.right: self.right.preorder()
    
    def invert(node):
      # Fill this in.
    
    root = Node('a') 
    root.left = Node('b') 
    root.right = Node('c') 
    root.left.left = Node('d') 
    root.left.right = Node('e') 
    root.right.left = Node('f') 
    
    root.preorder()
    # a b d e c f 
    print "\n"
    invert(root)
    root.preorder()
    # a c f b e d
-}

{- |
    (Medium)

    Good morning! Here's your coding interview problem for today.

    This problem was asked by Google.

    Invert a binary tree.

    For example, given the following tree:

        a
      / \
      b   c
    / \  /
    d   e f

    should become:

      a
    / \
    c  b
    \  / \
      f e  d

-}

invertTree :: Tree a -> Tree a
invertTree EmptyTree = EmptyTree
invertTree tree@(Node a EmptyTree EmptyTree) = tree
invertTree (Node a left right) = Node a (invertTree right) (invertTree left)

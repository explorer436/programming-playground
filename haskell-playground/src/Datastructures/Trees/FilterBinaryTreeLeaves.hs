module Datastructures.Trees.FilterBinaryTreeLeaves where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.UnivalSubtrees

import Data.Int

{- |
    Hi, here's your problem today. This problem was recently asked by Twitter:
    
    Given a binary tree and an integer k, filter the binary tree such that its leaves don't contain the value k. Here are the rules:
    
    - If a leaf node has a value of k, remove it.
    - If a parent node has a value of k, and all of its children are removed, remove it.
    
    Here's an example and some starter code:
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
      def __repr__(self):
        return f"value: {self.value}, left: ({self.left.__repr__()}), right: ({self.right.__repr__()})"
    
    def filter(tree, k):
      # Fill this in.
    
    #     1
    #    / \
    #   1   1
    #  /   /
    # 2   1
    n5 = Node(2)
    n4 = Node(1)
    n3 = Node(1, n4)
    n2 = Node(1, n5)
    n1 = Node(1, n2, n3)
    
    print(filter(n1, 1))
    #     1
    #    /
    #   1
    #  /
    # 2
    # value: 1, left: (value: 1, left: (value: 2, left: (None), right: (None)), right: (None)), right: (None)
-}

{- |
      (Medium)

      Good morning! Here's your coding interview problem for today.

      This question was asked by BufferBox.

      Given a binary tree where all nodes are either 0 or 1, prune the tree so that subtrees containing all 0s are removed.

      For example, given the following tree:

         0
      / \
      1   0
         / \
         1   0
      / \
      0   0

      should be pruned to:

         0
      / \
      1   0
         /
         1

      We do not remove the tree at the root or its left child because it still has a 1 as a descendant.
-}

filterBinaryTreeLeaves :: Eq t => t -> Tree t -> Tree t
filterBinaryTreeLeaves x EmptyTree = EmptyTree
filterBinaryTreeLeaves x tree@(Node a EmptyTree EmptyTree)
     | (a == x)  = EmptyTree
     | otherwise = tree
filterBinaryTreeLeaves x tree@(Node a left right)
    | (a == x && isUnival tree == True) = EmptyTree
    | otherwise                         = Node a (filterBinaryTreeLeaves x left) (filterBinaryTreeLeaves x right)

testFilter01 = filterBinaryTreeLeaves 1 (Node 1
                                              (Node 1 
                                                    (Node 2 EmptyTree EmptyTree)
                                                    EmptyTree
                                              )
                                              (Node 1 
                                                    (Node 1 EmptyTree EmptyTree)
                                                    EmptyTree
                                              )
                                        )
-- Node 1 
--      (Node 1 
--            (Node 2 EmptyTree EmptyTree) 
--            EmptyTree
--      ) 
--      EmptyTree

testFilter02 = filterBinaryTreeLeaves 1 EmptyTree
testFilter03 = filterBinaryTreeLeaves 1 (Node 1 (Node 2 EmptyTree EmptyTree) EmptyTree)
testFilter04 = filterBinaryTreeLeaves 2 (Node 1 (Node 2 EmptyTree EmptyTree) EmptyTree)

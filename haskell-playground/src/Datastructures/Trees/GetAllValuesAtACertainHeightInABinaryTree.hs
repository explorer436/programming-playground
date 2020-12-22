module Datastructures.Trees.GetAllValuesAtACertainHeightInABinaryTree where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Datastructures.Trees.MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel)

{- |
    Hi, here's your problem today. This problem was recently asked by Amazon:
    
    Given a binary tree, return all values given a certain height h.
    
    Here's a starting point:
    
    class Node():
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
    def valuesAtHeight(root, height):
      # Fill this in.
    
    #     1
    #    / \
    #   2   3
    #  / \   \
    # 4   5   7
    
    a = Node(1)
    a.left = Node(2)
    a.right = Node(3)
    a.left.left = Node(4)
    a.left.right = Node(5)
    a.right.right = Node(7)
    print valuesAtHeight(a, 3)
    # [4, 5, 7]
-}

elementsAtLevelN n tree = (listsByEachLevel tree)!!n

testTree = (Node 1
                                (Node 2
                                      (Node 4 EmptyTree EmptyTree)
                                      (Node 5 EmptyTree EmptyTree))
                                (Node 3
                                      EmptyTree
                                      (Node 7 EmptyTree EmptyTree)))

test00 = elementsAtLevelN 0 testTree -- [1]
test01 = elementsAtLevelN 1 testTree -- [2,3]
test02 = elementsAtLevelN 2 testTree -- [4,5,7]
test03 = elementsAtLevelN 3 testTree -- *** Exception: Prelude.!!: index too large
-- The last case can be handled by changing the signature to use Maybe.


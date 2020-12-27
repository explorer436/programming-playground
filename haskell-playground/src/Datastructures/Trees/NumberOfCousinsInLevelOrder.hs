module Datastructures.Trees.NumberOfCousinsInLevelOrder where

import Data.Maybe (fromJust)
import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Data.List (delete)

{- |
    Hi, here's your problem today. This problem was recently asked by Amazon:
    
    Given a binary tree and a given node value, return all of the node's cousins. 
    Two nodes are considered cousins if they are on the same level of the tree with different parents. 
    You can assume that all nodes will have their own unique value.
    
    Here's some starter code:
    
    class Node(object):
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
    class Solution(object):
      def list_cousins(self, tree, val):
        # Fill this in.
    
    #     1
    #    / \
    #   2   3
    #  / \   \
    # 4   6   5
    root = Node(1)
    root.left = Node(2)
    root.left.left = Node(4)
    root.left.right = Node(6)
    root.right = Node(3)
    root.right.right = Node(5)
    
    print Solution().list_cousins(root, 5)
    # [4, 6]
-}

solution x tree = helper x [tree]

-- helper x [] = []
helper x listOfTrees = if (x `elem` currentLevelValues) 
                         then (delete x currentLevelValues)
                       else
                        helper x (concat (map leftAndRightTrees listOfTrees))
                       where currentLevelValues = map (fromJust . rootValue) listOfTrees

-- tests
test = solution 5 (Node 1 
                        (Node 2 
                              (Node 4 EmptyTree EmptyTree)
                              (Node 6 EmptyTree EmptyTree)
                        )      
                        (Node 3 
                              EmptyTree
                              (Node 5 EmptyTree EmptyTree)
                        )      
                  )
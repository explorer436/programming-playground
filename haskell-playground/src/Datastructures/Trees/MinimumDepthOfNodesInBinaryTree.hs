module Datastructures.Trees.MinimumDepthOfNodesInBinaryTree where

import Datastructures.Trees.MyBinaryTree (Tree (..))

{-|
    Hi, here's your problem today. This problem was recently asked by LinkedIn:
    
    Given a binary tree, find the minimum depth of the binary tree. The minimum depth is the shortest distance from the root to a leaf.
    
    Here's an example and some starter code.
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
    def min_depth_bst(root):
      # Fill this in.
      
    n3 = Node(3, None, Node(4))
    n2 = Node(2, Node(3))
    n1 = Node(1, n2, n3)
    
    #     1
    #    / \
    #   2   3
    #        \
    #         4
    print(min_depth_bst(n1))
    # 1
-}

-- By definition, the values for the minimum height and the minimum depth will be the same. The reason for this is, the distance of the leaf that is the least farthest from the root is the same whether that distance is measured from the root or from the leaf. 

-- Reference: See MinimumHeightOfNodesInBinaryTree.hs

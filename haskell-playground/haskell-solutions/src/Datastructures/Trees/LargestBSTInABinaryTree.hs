module Datastructures.Trees.LargestBSTInABinaryTree (largestBSTTree) where

import Datastructures.Trees.MyBinaryTree (Tree (..), treeSize)
import Datastructures.Trees.IsGivenTreeBinarySearchTree (isBST)
import Datastructures.Trees.CompareTreesBySize (compareTreeBySize)
import Data.List (foldl')

{- |
    Hi, here's your problem today. This problem was recently asked by Twitter:
    
    You are given the root of a binary tree.
    Find and return the largest subtree of that tree, which is a valid binary search tree.
    
    Here's a starting point:
    
    class TreeNode:
      def __init__(self, key):
        self.left = None
        self.right = None
        self.key = key
    
      def __str__(self):
        # preorder traversal
        answer = str(self.key)
        if self.left:
          answer += str(self.left)
        if self.right:
          answer += str(self.right)
        return answer
    
    def largest_bst_subtree(root):
      # Fill this in.
    
    #     5
    #    / \
    #   6   7
    #  /   / \
    # 2   4   9
    
    node = TreeNode(5)
    node.left = TreeNode(6)
    node.right = TreeNode(7)
    node.left.left = TreeNode(2)
    node.right.left = TreeNode(4)
    node.right.right = TreeNode(9)
    print largest_bst_subtree(node)
    #749
-}

-- From Wikipedia:
-- Size of a tree = Number of nodes in the tree.

largestBSTTree EmptyTree                         = EmptyTree
largestBSTTree tree@(Node a EmptyTree EmptyTree) = tree
largestBSTTree tree@(Node a l r)                 = if (isBST tree)
                                                     then tree
                                                   else compareTreeBySize (largestBSTTree l) (largestBSTTree r)

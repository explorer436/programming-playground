{- |
    (Easy)
    
    Good morning! Here's your coding interview problem for today.
    
    This problem was asked by Amazon.
    
    Given a complete binary tree, count the number of nodes in faster than O(n) time. 

    Recall that a complete binary tree has every level filled except the last, and the nodes in the last level are filled starting from the left.
-}

module Datastructures.Trees.CountTheNumberOfNodesInACompleteBinaryTree (numberOfNodesInCompleteBinaryTree) where
  
import Datastructures.Trees.MyBinaryTree (Tree (..), treeLeftHeight)

numberOfNodesInCompleteBinaryTree EmptyTree = 0
numberOfNodesInCompleteBinaryTree (Node _ EmptyTree EmptyTree) = 1
numberOfNodesInCompleteBinaryTree tree = (2 ^ (treeLeftHeight tree + 1)) - 1

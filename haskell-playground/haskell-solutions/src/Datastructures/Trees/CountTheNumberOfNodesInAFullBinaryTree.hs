{- |
    Given a full binary tree, count the number of nodes in faster than O(n) time. 

    A full binary tree (sometimes proper binary tree or 2-tree) is a tree in which every node other than the leaves has two children.
-}

module Datastructures.Trees.CountTheNumberOfNodesInAFullBinaryTree (numberOfNodesInFullBinaryTree) where
  
import Datastructures.Trees.MyBinaryTree (Tree (..), treeLeftHeight)

numberOfNodesInFullBinaryTree EmptyTree = 0
numberOfNodesInFullBinaryTree (Node _ EmptyTree EmptyTree) = 1
numberOfNodesInFullBinaryTree tree = (2 ^ (treeLeftHeight tree + 1)) - 1


module Datastructures.Trees.CountTheNumberOfNodesInAFullBinaryTree (numberOfNodesInFullBinaryTree) where
  
import Datastructures.Trees.MyBinaryTree (Tree (..), treeLeftHeight)

numberOfNodesInFullBinaryTree EmptyTree = 0
numberOfNodesInFullBinaryTree (Node _ EmptyTree EmptyTree) = 1
numberOfNodesInFullBinaryTree tree = (2 ^ (treeLeftHeight tree + 1)) - 1


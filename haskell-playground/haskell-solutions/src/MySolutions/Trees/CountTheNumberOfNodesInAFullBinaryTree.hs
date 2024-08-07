module MySolutions.Trees.CountTheNumberOfNodesInAFullBinaryTree (numberOfNodesInFullBinaryTree) where
  
import MySolutions.Trees.MyBinaryTree (Tree (..), treeLeftHeight)

numberOfNodesInFullBinaryTree :: Num p => Tree a -> p
numberOfNodesInFullBinaryTree EmptyTree = 0
numberOfNodesInFullBinaryTree (Node _ EmptyTree EmptyTree) = 1
numberOfNodesInFullBinaryTree tree = (2 ^ (treeLeftHeight tree + 1)) - 1


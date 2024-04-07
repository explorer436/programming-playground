module Datastructures.Trees.CountTheNumberOfNodesInACompleteBinaryTree (numberOfNodesInCompleteBinaryTree) where
  
import Datastructures.Trees.MyBinaryTree (Tree (..), treeLeftHeight, treeRightHeight)
import Datastructures.Trees.CountTheNumberOfNodesInAFullBinaryTree (numberOfNodesInFullBinaryTree)

numberOfNodesInCompleteBinaryTree EmptyTree = 0
numberOfNodesInCompleteBinaryTree (Node _ EmptyTree EmptyTree) = 1
numberOfNodesInCompleteBinaryTree (Node _ l EmptyTree) = 2
numberOfNodesInCompleteBinaryTree tree@(Node n l r)
    | leftHeight == rightHeight                           = numberOfNodesInFullBinaryTree tree 
    | 1 + rightHeightOfLeftSubtree == treeLeftHeight tree = 1 + numberOfNodesInFullBinaryTree l + numberOfNodesInCompleteBinaryTree r
    | otherwise                                           = 1 + numberOfNodesInFullBinaryTree r + numberOfNodesInCompleteBinaryTree l
    where leftHeight = treeLeftHeight tree
          rightHeight = treeRightHeight tree
          rightHeightOfLeftSubtree = treeRightHeight l
    

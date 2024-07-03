module MySolutions.Trees.CountTheNumberOfNodesInACompleteBinaryTree (numberOfNodesInCompleteBinaryTree) where
  
import MySolutions.Trees.MyBinaryTree (Tree (..), treeLeftHeight, treeRightHeight)
import MySolutions.Trees.CountTheNumberOfNodesInAFullBinaryTree (numberOfNodesInFullBinaryTree)

numberOfNodesInCompleteBinaryTree :: Num a1 => Tree a2 -> a1
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
    

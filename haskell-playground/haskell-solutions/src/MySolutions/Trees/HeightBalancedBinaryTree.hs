module MySolutions.Trees.HeightBalancedBinaryTree (isTreeHeightBalanced) where
  
import MySolutions.Trees.MyBinaryTree (Tree (..), treeHeight)

-- Ideally, the depth of the tree should be used instead of "height". But at the tree level, the values for the depth and height are exactly the same. See MyBinarySearchTree_Depth.txt

isTreeHeightBalanced :: Tree a -> Bool
isTreeHeightBalanced EmptyTree    = True
isTreeHeightBalanced (Node a EmptyTree EmptyTree)    = True
isTreeHeightBalanced (Node _ l r) = abs(treeHeight l - treeHeight r) <= 1


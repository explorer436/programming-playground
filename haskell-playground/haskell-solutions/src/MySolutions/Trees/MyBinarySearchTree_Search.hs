module MySolutions.Trees.MyBinarySearchTree_Search (treeElem) where
  
import MySolutions.Trees.MyBinaryTree (Tree (..))

treeElem :: (Ord a) => a -> Tree a -> Bool  
treeElem x EmptyTree = False  
treeElem x (Node a left right)  
    | x == a = True  
    | x < a  = treeElem x left  
    | x > a  = treeElem x right 

-- This search algorithm runs in O(h) time, where h denotes the height of the tree.


module MySolutions.Trees.DeepestNodeInABinaryTree (deepestNodes) where

import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel)

deepestNodes :: Eq a => Tree a -> [a]
deepestNodes tree = last (listsByEachLevel tree)

module Datastructures.Trees.DeepestNodeInABinaryTree (deepestNodes) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel)

deepestNodes :: Eq a => Tree a -> [a]
deepestNodes tree = last (listsByEachLevel tree)

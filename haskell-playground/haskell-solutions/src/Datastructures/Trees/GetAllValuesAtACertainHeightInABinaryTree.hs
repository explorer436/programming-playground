module Datastructures.Trees.GetAllValuesAtACertainHeightInABinaryTree (elementsAtLevelN) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Datastructures.Trees.MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel)

elementsAtLevelN :: Eq a => Int -> Tree a -> [a]
elementsAtLevelN n tree =  listsByEachLevel tree !! n

module MySolutions.Trees.GetAllValuesAtACertainHeightInABinaryTree (elementsAtLevelN) where

import MySolutions.Trees.MyBinaryTree (Tree (..))

import MySolutions.Trees.MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel)

elementsAtLevelN :: Eq a => Int -> Tree a -> [a]
elementsAtLevelN n tree =  listsByEachLevel tree !! n

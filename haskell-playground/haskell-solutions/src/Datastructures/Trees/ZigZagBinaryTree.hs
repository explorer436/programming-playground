module Datastructures.Trees.ZigZagBinaryTree (zigzagBinaryTree) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Datastructures.Trees.MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel)

zigzagBinaryTree :: Eq a => Tree a -> [a]
zigzagBinaryTree tree = concat (invertListsAtOddPositions (zip [0..] (listsByEachLevel tree)))

-- using list comprehension instead of a map
invertListsAtOddPositions xs = [if (odd (fst x)) then (reverse (snd x)) else (snd x) | x <- xs]

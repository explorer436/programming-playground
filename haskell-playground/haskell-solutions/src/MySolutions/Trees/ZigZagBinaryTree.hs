module MySolutions.Trees.ZigZagBinaryTree (zigzagBinaryTree) where

import MySolutions.Trees.MyBinaryTree (Tree (..))

import MySolutions.Trees.MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel)

zigzagBinaryTree :: Eq a => Tree a -> [a]
zigzagBinaryTree tree = concat (invertListsAtOddPositions (zip [0..] (listsByEachLevel tree)))

-- using list comprehension instead of a map
invertListsAtOddPositions xs = [if (odd (fst x)) then (reverse (snd x)) else (snd x) | x <- xs]

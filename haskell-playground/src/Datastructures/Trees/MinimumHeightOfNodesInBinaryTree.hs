module Datastructures.Trees.MinimumHeightOfNodesInBinaryTree (minimumHeight) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

minimumHeight :: (Num a1, Ord a1) => Tree a2 -> a1
minimumHeight EmptyTree                    = -1
minimumHeight (Node a EmptyTree EmptyTree) = 0
minimumHeight (Node a l EmptyTree)         = 1 + (minimumHeight l)
minimumHeight (Node a EmptyTree r)         = 1 + (minimumHeight r)
minimumHeight (Node _ l r)                 = 1 + min (minimumHeight l) (minimumHeight r)

-- tests




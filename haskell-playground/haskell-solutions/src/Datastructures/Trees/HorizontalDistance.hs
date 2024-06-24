module Datastructures.Trees.HorizontalDistance (horizontalDistance) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Datastructures.Trees.AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1)

horizontalDistance :: Num a => Num b => Tree a -> [(a, b)]
horizontalDistance EmptyTree = []
horizontalDistance tree@(Node a left right) = [(a, 0)] ++ (map subtractOne (horizontalDistance left)) ++ (map addOne (horizontalDistance right))

addOne (a,b) = (a, b + 1)
subtractOne (a,b) = (a, b - 1)

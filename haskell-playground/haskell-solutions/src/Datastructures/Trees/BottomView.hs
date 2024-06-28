module Datastructures.Trees.BottomView (bottomViewWithDistance, bottomViewWithoutDistance) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.HorizontalDistance (horizontalDistance)
import qualified Data.Map as Map 

import Datastructures.Trees.AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1)

bottomViewWithDistance :: (Ord k, Num a, Num k) => Tree a -> Map.Map k a
bottomViewWithDistance tree@(Node a left right) = Map.fromList ([(b,a) | (a,b) <- (horizontalDistance tree)])

bottomViewWithoutDistance :: Num a => Tree a -> [a]
bottomViewWithoutDistance tree@(Node a left right) = [b | (a,b) <- 
  (Map.toList (Map.fromList ([(b,a) | (a,b) <- (horizontalDistance tree)])))]
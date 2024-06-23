module Datastructures.Trees.BottomView (bottomViewWithDistance, bottomViewWithoutDistance) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.HorizontalDistance (horizontalDistance)
import qualified Data.Map as Map 

import Datastructures.Trees.AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1)

bottomViewWithDistance tree@(Node a left right) = Map.fromList ([(b,a) | (a,b) <- (horizontalDistance tree)])

bottomViewWithoutDistance tree@(Node a left right) = [b | (a,b) <- 
  (Map.toList (Map.fromList ([(b,a) | (a,b) <- (horizontalDistance tree)])))]
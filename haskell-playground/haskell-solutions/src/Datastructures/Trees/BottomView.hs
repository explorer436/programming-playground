module Datastructures.Trees.BottomView (bottomViewWithDistance) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.HorizontalDistance (horizontalDistance)
import qualified Data.Map as Map 

import Datastructures.Trees.AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1)

bottomViewWithDistance tree@(Node a left right) = helper (horizontalDistance tree)

helper xs = Map.fromList (reverseTupleElements xs)

reverseTupleElements xs = [(b,a) | (a,b) <- xs]

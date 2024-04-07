module Datastructures.Trees.FlattenBinaryTree (flatten) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Datastructures.Trees.AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1)

flatten EmptyTree = EmptyTree
flatten tree@(Node a EmptyTree EmptyTree) = tree
flatten tree@(Node a left right) = Node a EmptyTree (appendTree2ToTheRightMostLeafOfTree1 (flatten left) (flatten right))

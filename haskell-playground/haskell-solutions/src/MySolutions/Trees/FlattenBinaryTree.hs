module MySolutions.Trees.FlattenBinaryTree (flatten) where

import MySolutions.Trees.MyBinaryTree (Tree (..))

import MySolutions.Trees.AppendOneTreeToAnotherTree (appendTree2ToTheRightMostLeafOfTree1)

flatten :: Tree a -> Tree a
flatten EmptyTree = EmptyTree
flatten tree@(Node a EmptyTree EmptyTree) = tree
flatten tree@(Node a left right) = Node a EmptyTree (appendTree2ToTheRightMostLeafOfTree1 (flatten left) (flatten right))

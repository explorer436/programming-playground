module Datastructures.Trees.TreeSize (treeSize) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

-- From Wikipedia:
-- Size of a tree = Number of nodes in the tree.

treeSize :: Num p => Tree a -> p
treeSize EmptyTree = 0
treeSize (Node a EmptyTree EmptyTree ) = 1
treeSize tree@(Node a left right) = 1 + treeSize left + treeSize right
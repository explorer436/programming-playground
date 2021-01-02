module Datastructures.Trees.TreeSize (treeSize) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

-- From Wikipedia:
-- Size of a tree = Number of nodes in the tree.

treeSize :: Num p => Tree a -> p
treeSize EmptyTree = 0
treeSize (Node a EmptyTree EmptyTree ) = 1
treeSize tree@(Node a left right) = 1 + treeSize left + treeSize right

-- tests
test01 = treeSize EmptyTree  -- expect 0
test02 = treeSize (Node 3 EmptyTree  EmptyTree )  -- expect 1
test03 = treeSize (Node 3 
                        (Node 2 EmptyTree EmptyTree )  
                        EmptyTree )  -- expect 2
test04 = treeSize (Node 3 
                        (Node 2 EmptyTree EmptyTree )  
                        (Node 1 EmptyTree EmptyTree )  
                  )  -- expect 3
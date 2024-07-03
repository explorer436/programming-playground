module MySolutions.Trees.BuildAllPossibleTrees (buildTreeList) where

import MySolutions.Trees.MyBinaryTree (Tree (..))

buildTreeList :: Tree a -> [Tree a]
buildTreeList EmptyTree = []
buildTreeList tree@(Node _ l r) = [tree] ++ buildTreeList l ++ buildTreeList r
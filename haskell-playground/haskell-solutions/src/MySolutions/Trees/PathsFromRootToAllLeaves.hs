module MySolutions.Trees.PathsFromRootToAllLeaves (paths) where

import Data.Maybe (fromJust)

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)

paths :: Tree a -> [[a]]
paths EmptyTree = [[]]
paths tree@(Node a left right) = helper tree [[]]

helper :: Tree a -> [[a]] -> [[a]]
helper tree@(Node a EmptyTree EmptyTree) [list] = [list ++ [a]]
helper tree@(Node a left EmptyTree) [list] = helper left [list ++ [a]]
helper tree@(Node a EmptyTree right) [list] = helper right [list ++ [a]]
helper tree@(Node a left right) [list] = helper left [list ++ [a]] ++ helper right [list ++ [a]]

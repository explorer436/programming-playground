module MySolutions.Trees.IsGivenTreeAFullBinaryTree (isTreeAFullBinaryTree) where

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue)

import Data.Maybe (fromJust)

isTreeAFullBinaryTree :: Tree a -> Bool
isTreeAFullBinaryTree EmptyTree = False
isTreeAFullBinaryTree tree@(Node a EmptyTree EmptyTree) = True
isTreeAFullBinaryTree tree@(Node a left EmptyTree) = False
isTreeAFullBinaryTree tree@(Node a EmptyTree right) = False
isTreeAFullBinaryTree tree@(Node a left right) = isTreeAFullBinaryTree left && isTreeAFullBinaryTree right

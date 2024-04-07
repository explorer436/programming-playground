module Datastructures.Trees.FullBinaryTree (fullBinaryTree) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue)

import Data.Maybe (fromJust)

fullBinaryTree :: Tree a -> Tree a
fullBinaryTree EmptyTree = EmptyTree
fullBinaryTree tree@(Node a EmptyTree EmptyTree) = tree
fullBinaryTree tree@(Node a left EmptyTree) = fullBinaryTree left
fullBinaryTree tree@(Node a EmptyTree right) = fullBinaryTree right
fullBinaryTree tree@(Node a left right) = Node a (fullBinaryTree left) (fullBinaryTree right)

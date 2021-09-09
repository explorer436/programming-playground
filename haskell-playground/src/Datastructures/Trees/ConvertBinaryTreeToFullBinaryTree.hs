module Datastructures.Trees.ConvertBinaryTreeToFullBinaryTree (convertBinaryTreeToFullBinaryTree) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftSubtree, rightSubtree, leftNodeValue, rightNodeValue)

{- |
(Medium)

Good morning! Here's your coding interview problem for today.

This problem was asked by Yahoo.

Recall that a full binary tree is one in which each node is either a leaf node, or has two children. Given a binary tree, convert it to a full one by removing nodes with only one child.

For example, given the following tree:

         0
      /     \
    1         2
  /            \
3                 4
  \             /   \
    5          6     7

You should convert it to:

     0
  /     \
5         4
        /   \
       6     7

-}

convertBinaryTreeToFullBinaryTree EmptyTree = EmptyTree
convertBinaryTreeToFullBinaryTree tree@(Node a EmptyTree EmptyTree) = tree
convertBinaryTreeToFullBinaryTree (Node a l EmptyTree) = convertBinaryTreeToFullBinaryTree l
convertBinaryTreeToFullBinaryTree (Node a EmptyTree r) = convertBinaryTreeToFullBinaryTree r
convertBinaryTreeToFullBinaryTree tree@(Node a l r) = Node a (convertBinaryTreeToFullBinaryTree l) (convertBinaryTreeToFullBinaryTree r)

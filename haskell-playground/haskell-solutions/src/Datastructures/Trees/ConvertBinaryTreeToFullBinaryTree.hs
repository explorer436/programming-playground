module Datastructures.Trees.ConvertBinaryTreeToFullBinaryTree (convertBinaryTreeToFullBinaryTree) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftSubtree, rightSubtree, leftNodeValue, rightNodeValue)

convertBinaryTreeToFullBinaryTree EmptyTree = EmptyTree
convertBinaryTreeToFullBinaryTree tree@(Node a EmptyTree EmptyTree) = tree
convertBinaryTreeToFullBinaryTree (Node a l EmptyTree) = convertBinaryTreeToFullBinaryTree l
convertBinaryTreeToFullBinaryTree (Node a EmptyTree r) = convertBinaryTreeToFullBinaryTree r
convertBinaryTreeToFullBinaryTree tree@(Node a l r) = Node a (convertBinaryTreeToFullBinaryTree l) (convertBinaryTreeToFullBinaryTree r)

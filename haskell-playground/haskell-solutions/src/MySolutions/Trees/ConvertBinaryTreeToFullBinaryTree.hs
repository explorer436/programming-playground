module MySolutions.Trees.ConvertBinaryTreeToFullBinaryTree (convertBinaryTreeToFullBinaryTree) where

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue, leftSubtree, rightSubtree, leftNodeValue, rightNodeValue)

convertBinaryTreeToFullBinaryTree :: Tree a -> Tree a
convertBinaryTreeToFullBinaryTree EmptyTree = EmptyTree
convertBinaryTreeToFullBinaryTree tree@(Node a EmptyTree EmptyTree) = tree
convertBinaryTreeToFullBinaryTree (Node a l EmptyTree) = convertBinaryTreeToFullBinaryTree l
convertBinaryTreeToFullBinaryTree (Node a EmptyTree r) = convertBinaryTreeToFullBinaryTree r
convertBinaryTreeToFullBinaryTree tree@(Node a l r) = Node a (convertBinaryTreeToFullBinaryTree l) (convertBinaryTreeToFullBinaryTree r)

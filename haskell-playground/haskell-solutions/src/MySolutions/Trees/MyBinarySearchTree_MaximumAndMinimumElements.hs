module MySolutions.Trees.MyBinarySearchTree_MaximumAndMinimumElements (treeMinimum, treeMaximum) where

import MySolutions.Trees.MyBinaryTree (Tree (..))

treeMinimum :: Num p => Tree p -> p
treeMinimum EmptyTree = 0
treeMinimum (Node a EmptyTree _) = a
treeMinimum (Node a left right) = treeMinimum left

treeMaximum :: Num p => Tree p -> p
treeMaximum EmptyTree = 0
treeMaximum (Node a _ EmptyTree) = a
treeMaximum (Node a left right) = treeMaximum right


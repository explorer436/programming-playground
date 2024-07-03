module MySolutions.Trees.MyBinarySearchTree_Delete (delete) where

import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.MyBinarySearchTree_MaximumAndMinimumElements (treeMinimum)

delete :: (Ord a, Num a) => a -> Tree a -> Tree a
delete _ EmptyTree = EmptyTree
delete x (Node a left right)
    | x < a  = Node a (delete x left) right
    | x > a  = Node a left (delete x right)
    | x == a = helper x left right

helper :: (Ord a, Num a) => p -> Tree a -> Tree a -> Tree a
helper x EmptyTree EmptyTree = EmptyTree
helper x left EmptyTree = left
helper x EmptyTree right = right
helper x left right = Node minimumElementFromRightSubtree left (rightSubtreeWithMinimumElementRemoved)
    where
    rightSubtreeWithMinimumElementRemoved = delete minimumElementFromRightSubtree right
    minimumElementFromRightSubtree = treeMinimum right

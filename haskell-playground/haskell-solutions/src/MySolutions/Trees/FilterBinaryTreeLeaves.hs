module MySolutions.Trees.FilterBinaryTreeLeaves (filterBinaryTreeLeaves) where

import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.UnivalSubtrees ( isUnival )

import Data.Int ()

filterBinaryTreeLeaves :: Eq t => t -> Tree t -> Tree t
filterBinaryTreeLeaves x EmptyTree = EmptyTree
filterBinaryTreeLeaves x tree@(Node a EmptyTree EmptyTree)
     | a == x  = EmptyTree
     | otherwise = tree
filterBinaryTreeLeaves x tree@(Node a left right)
    | a == x && isUnival tree = EmptyTree
    | otherwise               = Node a (filterBinaryTreeLeaves x left) (filterBinaryTreeLeaves x right)


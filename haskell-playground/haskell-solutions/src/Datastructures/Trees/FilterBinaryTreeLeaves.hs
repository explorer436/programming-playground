module Datastructures.Trees.FilterBinaryTreeLeaves (filterBinaryTreeLeaves) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.UnivalSubtrees ( isUnival )

import Data.Int ()

filterBinaryTreeLeaves :: Eq t => t -> Tree t -> Tree t
filterBinaryTreeLeaves x EmptyTree = EmptyTree
filterBinaryTreeLeaves x tree@(Node a EmptyTree EmptyTree)
     | (a == x)  = EmptyTree
     | otherwise = tree
filterBinaryTreeLeaves x tree@(Node a left right)
    | (a == x && isUnival tree == True) = EmptyTree
    | otherwise                         = Node a (filterBinaryTreeLeaves x left) (filterBinaryTreeLeaves x right)


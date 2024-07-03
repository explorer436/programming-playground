module MySolutions.Trees.MyBinarySearchTree_PermutationsFromList (permuationsOfTreesFromAList) where

import MySolutions.Trees.MyBinaryTree (Tree (..))

import MySolutions.Trees.MyBinarySearchTree_Insert (listToTreeFromRight, listToTreeFromLeft, treeInsert)

import Data.List (permutations, foldl')

-- Using Data.List.permutations here. TODO : write your own implementation for permutations.

perms :: (Num a, Enum a) => a -> [[a]]
perms n = permutations [1..n]

permuationsOfTreesFromAList n = map listToTreeFromLeft (perms n)

module MySolutions.Trees.BinaryTreeSumsByEachLevel (listWithSumsForEachLevel) where

import Data.Int ( Int8 )

import MySolutions.Trees.MyBinaryTree (Tree (..), actualRootValue, leftAndRightTrees)

listWithSumsForEachLevel :: Tree Int8 -> [Int8]
listWithSumsForEachLevel tree = breadthLevelSums [tree]

-- An alternative approach is to use MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel.breadthLevelLists 
-- and then calculating the sums for each internal list. 
-- This will give us the sum of elements at every level in the binary tree.

breadthLevelSums :: [Tree Int8] -> [Int8]
breadthLevelSums [] = []
breadthLevelSums [EmptyTree] = []
breadthLevelSums listOfTrees = sumOfRootNodeValues listOfTrees ++ breadthLevelSums (concat (map leftAndRightTrees listOfTrees))   

-- In Haskell, the ++ operator is list concatenation.

sumOfRootNodeValues :: [Tree Int8] -> [Int8]
sumOfRootNodeValues listOfTrees = [sum (map actualRootValue listOfTrees)]

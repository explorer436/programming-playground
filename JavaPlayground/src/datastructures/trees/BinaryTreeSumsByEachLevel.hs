module BinaryTreeSumsByEachLevel where

import Data.Int

import MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)

listWithSumsForEachLevel :: Tree Int8 -> [Int8]
listWithSumsForEachLevel tree = breadthLevelSums [tree]

-- An alternative approach is to use MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel.breadthLevelLists and then calculating the sums for each internal list. This will give us the sum of elements at every level in the binary tree.

breadthLevelSums :: [Tree Int8] -> [Int8]
breadthLevelSums [] = []
breadthLevelSums [EmptyTree] = []
breadthLevelSums listOfTrees = sumOfRootNodeValues listOfTrees ++ breadthLevelSums (concat (map leftAndRightTrees listOfTrees))   

sumOfRootNodeValues :: [Tree Int8] -> [Int8]
sumOfRootNodeValues listOfTrees = [sum (map actualRootValue listOfTrees)]

actualRootValue tree = case (rootValue tree) of 
                                     Just value -> value
                                     Nothing -> 0

-- tests
test01 = listWithSumsForEachLevel
            (Node 1
               (Node 4
                   (Node 3 EmptyTree EmptyTree)
                   (Node 2 EmptyTree EmptyTree))
               (Node 5
                   (Node 4 EmptyTree EmptyTree)
                   (Node (-1) EmptyTree EmptyTree)))
-- [1,9,8]

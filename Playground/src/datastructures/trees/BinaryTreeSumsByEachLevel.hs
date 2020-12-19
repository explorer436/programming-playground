module BinaryTreeSumsForEachLevel where

import Data.Int

import MyBinaryTree

listWithSumsForEachLevel :: Tree Int8 -> [Int8]
listWithSumsForEachLevel tree = breadthLevelSums [tree]

breadthLevelSums :: [Tree Int8] -> [Int8]
breadthLevelSums [] = []
breadthLevelSums [EmptyTree] = []
breadthLevelSums listOfTrees = sumOfRootNodeValues listOfTrees ++ breadthLevelSums (concat (map leftAndRightTrees listOfTrees))   

sumOfRootNodeValues :: [Tree Int8] -> [Int8]
sumOfRootNodeValues listOfTrees = [sum (map rootValue listOfTrees)]

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

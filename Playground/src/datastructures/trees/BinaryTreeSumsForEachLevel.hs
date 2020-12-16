module BinaryTreeSumsForEachLevel where

import MyBinaryTree

listWithSumsForEachLevel :: Tree Integer -> [Integer]
listWithSumsForEachLevel tree = breadthLevelSums [tree]

breadthLevelSums :: [Tree Integer] -> [Integer]
breadthLevelSums [] = []
breadthLevelSums [EmptyTree] = []
breadthLevelSums listOfTrees = sumOfRootNodeValues listOfTrees ++ breadthLevelSums (concat (map leftAndRightTrees listOfTrees))   

leftAndRightTrees :: Tree a -> [Tree a]
leftAndRightTrees (Node _ EmptyTree EmptyTree) = []
leftAndRightTrees (Node _ EmptyTree b)     = [b]
leftAndRightTrees (Node _ a EmptyTree)     = [a]
leftAndRightTrees (Node _ a b)         = [a,b]

sumOfRootNodeValues :: [Tree Integer] -> [Integer]
sumOfRootNodeValues listOfTrees = [sum (map nodeValue listOfTrees)]

nodeValue :: Tree Integer -> Integer
nodeValue (Node a _ _) = a

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
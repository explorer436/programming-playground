import MyBinaryTree

import Data.Maybe (fromJust)
import Data.List (minimumBy)

import BinaryTreeSumsForEachLevel (listWithSumsForEachLevel)

{- |

    Hi, here's your problem today. This problem was recently asked by Twitter:

    You are given the root of a binary tree. Find the level for the binary tree with the minimum sum, and return that value.

    For instance, in the example below, the sums of the trees are 10, 2 + 8 = 10, and 4 + 1 + 2 = 7. So, the answer here should be 7.

    class Node:

      def __init__(self, value, left=None, right=None):
        self.val = value
        self.left = left
        self.right = right

    def minimum_level_sum(root):
      # Fill this in.

    #     10
    #    /  \
    #   2    8
    #  / \    \
    # 4   1    2

    node = Node(10)
    node.left = Node(2)
    node.right = Node(8)
    node.left.left = Node(4)
    node.left.right = Node(1)
    node.right.right = Node(2)

    print minimum_level_sum(node)
-}

customImplementationForCompare :: (Ord a) => a -> a -> Ordering  
a `customImplementationForCompare` b  
    | a > b     = GT  
    | a == b    = EQ  
    | otherwise = LT

-- For reference, see MaxElementInAListAndItsIndex.hs
-- TODO: Do not use the implementation below. Re-write this using foldl'
findFirstMinimumElementInTheListAndIndex xs = minimumBy (\(a, i) (b, j) -> customImplementationForCompare (customImplementationForCompare a b) (customImplementationForCompare i j)) $ zip xs [0..]
testFindFirstMinimumElementInTheListAndIndex = findFirstMinimumElementInTheListAndIndex [10,7,7]

smallestSumOfAllNodesInALevel tree = fst (findFirstMinimumElementInTheListAndIndex (listWithSumsForEachLevel tree))
levelOfTreeWhereSumOfAllNodesIsTheSmallest tree = snd (findFirstMinimumElementInTheListAndIndex (listWithSumsForEachLevel tree))

-- tests
testFindFirstMinimumElementInTheListAndIndex01 = findFirstMinimumElementInTheListAndIndex (listWithSumsForEachLevel testTree01) -- (7,2)
testMinSum01 = smallestSumOfAllNodesInALevel testTree01 -- 7
testLevelOfTreeWithMinimumSum01 = levelOfTreeWhereSumOfAllNodesIsTheSmallest testTree01 -- 2

testTree01 = (Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 8
                   (EmptyTree)
                   (Node 2 EmptyTree EmptyTree)))

testFindFirstMinimumElementInTheListAndIndex02 = findFirstMinimumElementInTheListAndIndex (listWithSumsForEachLevel testTree02) -- (7,1)
testMinSum02 = smallestSumOfAllNodesInALevel testTree02 -- 7
testLevelOfTreeWithMinimumSum02 = levelOfTreeWhereSumOfAllNodesIsTheSmallest testTree02 -- 1

testTree02 = (Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 5
                   (EmptyTree)
                   (Node 2 EmptyTree EmptyTree)))

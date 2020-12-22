module Datastructures.Trees.LevelOfTreeWithMinimumSum where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Data.Int
import Data.Maybe (fromJust)
import Data.List (minimumBy, foldl')

import Datastructures.Trees.BinaryTreeSumsByEachLevel (listWithSumsForEachLevel)

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

{- |
        (Easy)

        Good morning! Here's your coding interview problem for today.

        This problem was asked by Facebook.

        Given a binary tree, return the level of the tree with minimum sum.
-}

-- For reference, see MaxElementInAListAndItsIndex.hs
-- findFirstMinimumElementInTheListAndIndex :: (Int a, Int b) => [(a, b)] -> Maybe (a, b)
findFirstMinimumElementInTheListAndIndex [] = Nothing
findFirstMinimumElementInTheListAndIndex xs = Just (foldl' (\acc x -> 
                                                        if ((fst acc) > (fst x)) 
                                                            then x 
                                                        else if ((fst acc) == (fst x)) 
                                                            then (if (snd acc < snd x) 
                                                                    then acc 
                                                                  else x) 
                                                        else acc) (head xs) xs)

tupleWithMinimumSum tree = fromJust $ findFirstMinimumElementInTheListAndIndex (zip (listWithSumsForEachLevel tree)[0..])
minimumSum tree = fst $ tupleWithMinimumSum tree
levelWithMinimumSum tree = snd $ tupleWithMinimumSum tree

-- tests
testTupleWithMinimumSum01 = fromJust $ findFirstMinimumElementInTheListAndIndex (zip (listWithSumsForEachLevel testTree01)[0..]) -- (7,2)
testMinSum01 = minimumSum testTree01 -- 7
testLevelWithMinimumSum01 = levelWithMinimumSum testTree01 -- 2

testTree01 = (Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 8
                   (EmptyTree)
                   (Node 2 EmptyTree EmptyTree)))

testTupleWithMinimumSum02 = fromJust $ findFirstMinimumElementInTheListAndIndex (zip (listWithSumsForEachLevel testTree02)[0..]) -- (7,1)
testMinSum02 = minimumSum testTree02 -- 7
testLevelWithMinimumSum02 = levelWithMinimumSum testTree02 -- 1

testTree02 = (Node 10
               (Node 2
                   (Node 4 EmptyTree EmptyTree)
                   (Node 1 EmptyTree EmptyTree))
               (Node 5
                   (EmptyTree)
                   (Node 2 EmptyTree EmptyTree)))

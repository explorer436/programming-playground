module FloorAndCeilingOfAnElementInAGivenBST where

import MyBinaryTree (Tree (..), rootValue, leftSubtree, rightSubtree, leftNodeValue, rightNodeValue)
import Data.Maybe (fromJust)
import Debug.Trace

{- |
    Hi, here's your problem today. This problem was recently asked by Apple:
    
    Given an integer k and a binary search tree, 
    find the floor (less than or equal to) of k, 
    and the ceiling (larger than or equal to) of k.
    If either does not exist, then print them as None.
    
    Here is the definition of a node for the tree.
    
    class Node:
      def __init__(self, value):
        self.left = None
        self.right = None
        self.value = value
    
    def findCeilingFloor(root_node, k, floor=None, ceil=None):
      # Fill this in.
    
    root = Node(8) 
    root.left = Node(4) 
    root.right = Node(12) 
      
    root.left.left = Node(2) 
    root.left.right = Node(6) 
      
    root.right.left = Node(10) 
    root.right.right = Node(14) 
    
    print findCeilingFloor(root, 5)
    # (4, 6)
-}

-- ceilingOfAnElement :: Ord a => a -> Tree a -> Maybe a
ceilingOfAnElement x EmptyTree                    = Nothing
ceilingOfAnElement x (Node a EmptyTree EmptyTree) = if (x == a) then Just a else if (x < a) then Just a else Nothing
ceilingOfAnElement x tree@(Node a left right)     = trace ("DEBUG: ceilingOfAnElement - x:" ++ show x ++ ", tree:" ++ show tree) 
                                                    (if (x == a) then Just a
                                                     else if (x < a) then (
                                                       if (left == EmptyTree) then Just a
                                                       else if (fromJust (leftNodeValue tree) == x) then (leftNodeValue tree)
                                                       else if (x < fromJust (leftNodeValue tree)) then (
                                                         case (leftSubtree left) of 
                                                           Nothing -> (Just a)
                                                           Just value -> if (value == EmptyTree) then (Just a) else (ceilingOfAnElement x left)
                                                       )
                                                       else if (x > fromJust (leftNodeValue tree)) then (
                                                         case (rightSubtree left) of 
                                                           Nothing -> (Just a)
                                                           Just value -> if (value == EmptyTree) then (Just a) else (ceilingOfAnElement x left)
                                                       )
                                                       else Nothing
                                                     )
                                                     else if (x > a) then (
                                                       if (right == EmptyTree) then Just a
                                                       else if (fromJust (rightNodeValue tree) == x) then (rightNodeValue tree)
                                                       else if (x < fromJust (rightNodeValue tree)) then (
                                                         case (leftSubtree right) of 
                                                           Nothing -> (Just a)
                                                           Just value -> if (value == EmptyTree) then (Just a) else (ceilingOfAnElement x right)
                                                       )
                                                       else if (x > fromJust (rightNodeValue tree)) then (
                                                         case (rightSubtree right) of 
                                                           Nothing -> (Just a)
                                                           Just value -> if (value == EmptyTree) then (Just a) else (ceilingOfAnElement x right)
                                                       )
                                                       else Nothing
                                                     )
                                                     else Nothing)

testCeiling00 = ceilingOfAnElement 1 EmptyTree -- Nothing
testCeiling01 = ceilingOfAnElement 1 (Node 1 EmptyTree EmptyTree) -- Just 1
testCeiling02 = ceilingOfAnElement 1 (Node 2 EmptyTree EmptyTree) -- Just 2
testCeiling03 = ceilingOfAnElement 2 (Node 1 
                                           EmptyTree
                                           (Node 2 EmptyTree EmptyTree) 
                                    ) -- Just 2
testCeiling04 = ceilingOfAnElement 1 (Node 2 
                                           EmptyTree
                                           (Node 3 EmptyTree EmptyTree) 
                                    ) -- Just 2
testCeiling05 = ceilingOfAnElement 1 (Node 2 
                                           (Node 1 EmptyTree EmptyTree) 
                                           EmptyTree
                                    ) -- expect Just 1
testCeiling06 = ceilingOfAnElement 1 (Node 4
                                           (Node 2 EmptyTree EmptyTree) 
                                           (Node 6 EmptyTree EmptyTree)
                                    ) -- expect Just 2
testCeiling07 = ceilingOfAnElement 3 (Node 4
                                           (Node 2 EmptyTree EmptyTree) 
                                           (Node 6 EmptyTree EmptyTree)
                                    ) -- expect Just 4
testCeiling08 = ceilingOfAnElement 2 (Node 4
                                           (Node 2 EmptyTree EmptyTree) 
                                           (Node 6 EmptyTree EmptyTree)
                                    ) -- expect Just 2
testCeiling09 = ceilingOfAnElement 3 testTree -- expect Just 4
testCeiling10 = ceilingOfAnElement 4 testTree -- expect Just 4
testCeiling11 = ceilingOfAnElement 5 testTree -- expect Just 4
testCeiling12 = ceilingOfAnElement 11 testTree -- expect Just 12
testCeiling13 = ceilingOfAnElement 13 testTree -- expect Just 12

-- testFloor01 = fromJust $ floorOfAnElement 5 testTree

testTree = Node 8
                (Node 4
                      (Node 2 EmptyTree EmptyTree)
                      (Node 6 EmptyTree EmptyTree)
                )
                (Node 12
                      (Node 10 EmptyTree EmptyTree)
                      (Node 14 EmptyTree EmptyTree)
                )

module Datastructures.Trees.CeilingOfAnElementInAGivenBST (ceilingOfAnElement) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftSubtree, rightSubtree, leftNodeValue, rightNodeValue)
import Data.Maybe (fromJust)
import Debug.Trace ( trace )

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
ceilingOfAnElement :: (Show a, Ord a) => a -> Tree a -> Maybe a
ceilingOfAnElement x EmptyTree                    = Nothing
ceilingOfAnElement x (Node a EmptyTree EmptyTree) = Just a
ceilingOfAnElement x tree@(Node a left right)     = trace ("DEBUG: ceilingOfAnElement - x:" ++ show x ++ ", tree:" ++ show tree) 
                                                    (if (x == a) then Just a
                                                     else if (x < a) then (xIsLesserThanRootValue x tree)
                                                     else if (x > a) then (xIsGreaterThanRootValue x tree)
                                                     else Nothing)

xIsLesserThanRootValue :: (Show a, Ord a) => a -> Tree a -> Maybe a
xIsLesserThanRootValue x tree@(Node a left right) = trace ("DEBUG: xIsLesserThanRootValue - x:" ++ show x ++ ", tree:" ++ show tree) 
                                                    (
                                                      if (left == EmptyTree) then Just a
                                                      else if (fromJust (leftNodeValue tree) == x) then (leftNodeValue tree)
                                                      else if (x < fromJust (leftNodeValue tree)) then (
                                                        case (leftSubtree left) of 
                                                          Nothing -> (Just a)
                                                          Just value -> if (value == EmptyTree) then (leftNodeValue tree) else (ceilingOfAnElement x left)
                                                      )
                                                      else if (x > fromJust (leftNodeValue tree)) then (
                                                        case (rightSubtree left) of 
                                                          Nothing -> (Just a)
                                                          Just value -> if (value == EmptyTree) then (Just a) else (ceilingOfAnElement x left)
                                                      )
                                                      else Nothing
                                                    )

xIsGreaterThanRootValue :: (Show a, Ord a) => a -> Tree a -> Maybe a
xIsGreaterThanRootValue x tree@(Node a left right) = trace ("DEBUG: xIsGreaterThanRootValue - x:" ++ show x ++ ", tree:" ++ show tree) 
                                                     (
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
                                                           Just value -> if (value == EmptyTree) then (rightNodeValue tree) else (ceilingOfAnElement x right)
                                                       )
                                                       else Nothing
                                                     )



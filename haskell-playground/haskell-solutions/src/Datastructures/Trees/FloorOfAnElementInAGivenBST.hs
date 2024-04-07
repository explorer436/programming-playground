module Datastructures.Trees.FloorOfAnElementInAGivenBST (floorOfAnElement) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftSubtree, rightSubtree, leftNodeValue, rightNodeValue)
import Data.Maybe (fromJust)
import Debug.Trace ( trace )

-- floorOfAnElement :: Ord a => a -> Tree a -> Maybe a
floorOfAnElement :: (Show a, Ord a) => a -> Tree a -> Maybe a
floorOfAnElement x EmptyTree                    = Nothing
floorOfAnElement x (Node a EmptyTree EmptyTree) = Just a
floorOfAnElement x tree@(Node a left right)     = trace ("DEBUG: floorOfAnElement - x:" ++ show x ++ ", tree:" ++ show tree) 
                                                    (if (x == a) then Just a
                                                     else if (x < a) then (xIsLesserThanRootValue x tree)
                                                     else if (x > a) then (xIsGreaterThanRootValue x tree)
                                                     else Nothing)

xIsLesserThanRootValue :: (Show a, Ord a) => a -> Tree a -> Maybe a
xIsLesserThanRootValue x tree@(Node a left right) = trace ("DEBUG: xIsLesserThanRootValue - x:" ++ show x ++ ", tree:" ++ show tree) 
                                                    (
                                                      if (left == EmptyTree) then Nothing
                                                      else if (fromJust (leftNodeValue tree) == x) then (leftNodeValue tree)
                                                      else if (x < fromJust (leftNodeValue tree)) then (
                                                        case (leftSubtree left) of 
                                                          Nothing -> (Just a)
                                                          Just value -> if (value == EmptyTree) then Nothing else (floorOfAnElement x left)
                                                      )
                                                      else if (x > fromJust (leftNodeValue tree)) then (
                                                        case (rightSubtree left) of 
                                                          Nothing -> (Just a)
                                                          Just value -> if (value == EmptyTree) then (leftNodeValue tree) else (floorOfAnElement x left)
                                                      )
                                                      else Nothing
                                                    )

xIsGreaterThanRootValue :: (Show a, Ord a) => a -> Tree a -> Maybe a
xIsGreaterThanRootValue x tree@(Node a left right) = trace ("DEBUG: xIsGreaterThanRootValue - x:" ++ show x ++ ", tree:" ++ show tree) 
                                                     (
                                                       if (right == EmptyTree) then Nothing
                                                       else if (fromJust (rightNodeValue tree) == x) then (rightNodeValue tree)
                                                       else if (x < fromJust (rightNodeValue tree)) then (
                                                         case (leftSubtree right) of 
                                                           Nothing -> (Just a)
                                                           Just value -> if (value == EmptyTree) then (rightNodeValue tree) else (floorOfAnElement x right)
                                                       )
                                                       else if (x > fromJust (rightNodeValue tree)) then (
                                                         case (rightSubtree right) of 
                                                           Nothing -> (Just a)
                                                           Just value -> if (value == EmptyTree) then Nothing else (floorOfAnElement x right)
                                                       )
                                                       else Nothing
                                                     )



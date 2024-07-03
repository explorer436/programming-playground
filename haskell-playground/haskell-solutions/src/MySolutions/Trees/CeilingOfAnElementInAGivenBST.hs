module MySolutions.Trees.CeilingOfAnElementInAGivenBST (ceilingOfAnElement) where

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue, leftSubtree, rightSubtree, leftNodeValue, rightNodeValue)
import Data.Maybe (fromJust)
import Debug.Trace ( trace )

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



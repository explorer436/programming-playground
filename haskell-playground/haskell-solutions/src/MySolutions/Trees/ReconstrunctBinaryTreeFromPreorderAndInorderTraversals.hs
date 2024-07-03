module MySolutions.Trees.ReconstrunctBinaryTreeFromPreorderAndInorderTraversals (reconstruct, leftHalfInOrder, leftHalfPreOrder, rightHalfInOrder, rightHalfPreOrder) where

import MySolutions.Trees.MyBinaryTree (Tree (..))
import Debug.Trace ( trace, traceShow )

reconstruct [] [] = EmptyTree
reconstruct [] _ = EmptyTree
reconstruct _ [] = EmptyTree
reconstruct inorderList preorderList = trace ("DEBUG: reconstruct - inorderList:" ++ show inorderList)
                                       trace ("DEBUG: reconstruct - preorderList:" ++ show preorderList)
                                       trace ("DEBUG: reconstruct - leftHalfInOrder:" ++ show leftHalfInOrder)
                                       Node rootValue 
                                            (reconstruct leftHalfInOrder leftHalfPreOrder)
                                            (reconstruct rightHalfInOrder rightHalfPreOrder)
                                       where leftHalfPreOrder = take (length leftHalfInOrder) (tail preorderList)
                                             rightHalfPreOrder = drop (length leftHalfInOrder) (tail preorderList)
                                             leftHalfInOrder = takeWhile (/= rootValue) inorderList
                                             rightHalfInOrder = tail $ dropWhile (/= rootValue) inorderList
                                             rootValue = head preorderList

-- SEPARATING THESE FOR DEBUGGING AND UNIT TESTING PURPOSES. 

-- leftHalfInOrder :: Ord a => [a] -> [a] -> [a]
leftHalfInOrder inorderList preorderList = trace ("DEBUG: leftHalfInOrder - inorderList:" ++ show inorderList)
                                           trace ("DEBUG: leftHalfInOrder - preorderList:" ++ show preorderList)
                                           takeWhile (/= rootValue) inorderList
                                           where rootValue = head preorderList

-- rightHalfInOrder :: Ord a => [a] -> [a] -> [a]
rightHalfInOrder inorderList preorderList = trace ("DEBUG: rightHalfInOrder - inorderList:" ++ show inorderList)
                                            trace ("DEBUG: rightHalfInOrder - preorderList:" ++ show preorderList)
                                            tail $ dropWhile (/= rootValue) inorderList
                                            where rootValue = head preorderList

-- rightHalfPreOrder :: Ord a => [a] -> [a] -> [a]
rightHalfPreOrder inorderList preorderList = trace ("DEBUG: rightHalfPreOrder - inorderList:" ++ show inorderList)
                                             trace ("DEBUG: rightHalfPreOrder - preorderList:" ++ show preorderList)
                                             drop (length (leftHalfInOrder inorderList preorderList)) (tail preorderList)

-- leftHalfPreOrder :: Ord a => [a] -> [a] -> [a]
leftHalfPreOrder inorderList preorderList = trace ("DEBUG: leftHalfPreOrder - inorderList:" ++ show inorderList)
                                            trace ("DEBUG: leftHalfPreOrder - preorderList:" ++ show preorderList)
                                            take (length (leftHalfInOrder inorderList preorderList)) (tail preorderList)


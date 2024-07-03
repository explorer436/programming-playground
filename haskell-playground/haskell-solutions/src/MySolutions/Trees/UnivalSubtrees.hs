module MySolutions.Trees.UnivalSubtrees (isUnival, countUnivalSubtrees) where

import Data.Maybe (fromJust)

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue)

isUnival :: Eq a => Tree a -> Bool
isUnival EmptyTree = False
isUnival (Node a EmptyTree EmptyTree) = True
isUnival (Node a left EmptyTree) 
    | isAEqualToLeftNodeValue && (isUnival left) = True
    | otherwise                                  = False
    where
        isAEqualToLeftNodeValue = case (rootValue left) of 
                                     Just value -> (a == value)  
                                     Nothing -> False
isUnival (Node a EmptyTree right) 
    | isAEqualToRightNodeValue && (isUnival right) = True
    | otherwise                                    = False
    where
        isAEqualToRightNodeValue = case (rootValue right) of 
                                     Just value -> (a == value)  
                                     Nothing -> False
isUnival (Node a left right) 
    | isAEqualToLeftNodeValue && isAEqualToRightNodeValue && (isUnival left) && (isUnival right) = True
    | otherwise                                                                                  = False
    where
        isAEqualToRightNodeValue = case (rootValue right) of 
                                     Just value -> (a == value)  
                                     Nothing -> False
        isAEqualToLeftNodeValue = case (rootValue left) of 
                                     Just value -> (a == value)  
                                     Nothing -> False

-- testIsUnival01 = isUnival EmptyTree -- False. This seems to be working when tested from the ghci interpreter.

countUnivalSubtrees EmptyTree                    = 0
countUnivalSubtrees (Node a EmptyTree EmptyTree) = 1
countUnivalSubtrees tree@(Node a left right) 
    | isUnival tree == True                               = 1 + countUnivalSubtrees left + countUnivalSubtrees right
    | isUnival tree /= True                               = countUnivalSubtrees left + countUnivalSubtrees right

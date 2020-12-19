module UnivalSubtrees where

import Data.Maybe (fromJust)

import MyBinaryTree

{- |
    Good morning! Here's your coding interview problem for today.
    
    (Easy)
    
    This problem was asked by Google.
    
    A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
    
    Given the root to a binary tree, count the number of unival subtrees.
    
    For example, the following tree has 5 unival subtrees:
    
       0
      / \
     1   0
        / \
       1   0
      / \
     1   1
-}

isUnival :: Eq a => Tree a -> Bool
isUnival EmptyTree = False
isUnival (Node a EmptyTree EmptyTree) = True
isUnival (Node a left EmptyTree) 
    | isAEqualToLeftRootValue && (isUnival left) = True
    | otherwise                                  = False
    where
        isAEqualToLeftRootValue = case (rootValue left) of 
                                     Just value -> (a == value)  
                                     Nothing -> False
isUnival (Node a EmptyTree right) 
    | isAEqualToRightRootValue && (isUnival right) = True
    | otherwise                                    = False
    where
        isAEqualToRightRootValue = case (rootValue right) of 
                                     Just value -> (a == value)  
                                     Nothing -> False
isUnival (Node a left right) 
    | isAEqualToLeftRootValue && isAEqualToRightRootValue && (isUnival left) && (isUnival right) = True
    | otherwise                                                                                  = False
    where
        isAEqualToRightRootValue = case (rootValue right) of 
                                     Just value -> (a == value)  
                                     Nothing -> False
        isAEqualToLeftRootValue = case (rootValue left) of 
                                     Just value -> (a == value)  
                                     Nothing -> False

-- testIsUnival01 = isUnival EmptyTree -- False. This seems to be working when tested from the ghci interpreter.
testIsUnival02 = isUnival (Node 3 EmptyTree EmptyTree) -- True
testIsUnival03 = isUnival (Node 1
                                (Node 4
                                      (Node 3 EmptyTree EmptyTree)
                                      (Node 2 EmptyTree EmptyTree))
                                (Node 5
                                      (Node 4 EmptyTree EmptyTree)
                                      (Node (-1) EmptyTree EmptyTree))) -- False
testIsUnival04 = isUnival (Node 4
                                (Node 4
                                      (Node 4 EmptyTree EmptyTree)
                                      (Node 4 EmptyTree EmptyTree))
                                (Node 4
                                      (Node 4 EmptyTree EmptyTree)
                                      (Node 4 EmptyTree EmptyTree))) -- True
testIsUnival05 = isUnival (Node 1
                                (Node 1 EmptyTree EmptyTree)
                                EmptyTree
                          )

countUnivalSubtrees EmptyTree                    = 0
countUnivalSubtrees (Node a EmptyTree EmptyTree) = 1
countUnivalSubtrees tree@(Node a left right) 
    | isUnival tree == True                               = 1 + countUnivalSubtrees left + countUnivalSubtrees right
    | isUnival tree /= True                               = countUnivalSubtrees left + countUnivalSubtrees right

testCountUnivalSubtrees01 = countUnivalSubtrees (Node 4 EmptyTree EmptyTree) -- 1
testCountUnivalSubtrees02 = countUnivalSubtrees (Node 4
                                                       (Node 4
                                                             (Node 4 EmptyTree EmptyTree)
                                                             (Node 4 EmptyTree EmptyTree))
                                                       (Node 4
                                                             (Node 4 EmptyTree EmptyTree)
                                                             (Node 4 EmptyTree EmptyTree))) -- 7
testCountUnivalSubtrees03 = countUnivalSubtrees (Node 1
                                                       (Node 4
                                                             (Node 3 EmptyTree EmptyTree)
                                                             (Node 2 EmptyTree EmptyTree))
                                                       (Node 5
                                                             (Node 4 EmptyTree EmptyTree)
                                                             (Node (-1) EmptyTree EmptyTree))) -- 4
testCountUnivalSubtrees04 = countUnivalSubtrees (Node 0
                                                        (Node 1 EmptyTree EmptyTree)
                                                        (Node 0
                                                              (Node 1 
                                                                    (Node 1 EmptyTree EmptyTree)
                                                                    (Node 1 EmptyTree EmptyTree) 
                                                              )
                                                              (Node 0 EmptyTree EmptyTree))
                                                  ) -- 5

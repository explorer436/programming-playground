module Datastructures.Trees.UnivalSubtrees (isUnival, countUnivalSubtrees) where

import Data.Maybe (fromJust)

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue)

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

{- |
    Hi, here's your problem today. This problem was recently asked by Microsoft:
    
    A unival tree is a tree where all the nodes have the same value. Given a binary tree, return the number of unival subtrees in the tree.
    
    For example, the following tree should return 5:
    
       0
      / \
     1   0
        / \
       1   0
      / \
     1   1
    
    
    The 5 trees are:
    - The three single '1' leaf nodes. (+3)
    - The single '0' leaf node. (+1)
    - The [1, 1, 1] tree at the bottom. (+1)
    
    Here's a starting point:
    
    class Node(object):
      def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
    
    def count_unival_subtrees(root):
      # Fill this in.
    
    a = Node(0)
    a.left = Node(1)
    a.right = Node(0)
    a.right.left = Node(1)
    a.right.right = Node(0)
    a.right.left.left = Node(1)
    a.right.left.right = Node(1)
    
    print count_unival_subtrees(a)
    # 5
-}

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
                                                              (Node 0 EmptyTree EmptyTree)
                                                        )
                                                ) -- 5

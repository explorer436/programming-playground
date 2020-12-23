module Datastructures.Trees.CreateABalancedBinarySearchTree (createBalancedBST) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Debug.Trace ( trace )

{- |
    Hi, here's your problem today. This problem was recently asked by LinkedIn:
    
    Given a sorted list of numbers, change it into a balanced binary search tree.
    You can assume there will be no duplicate numbers in the list.
    
    Here's a starting point:
    
    from collections import deque
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
      def __str__(self):
        # level-by-level pretty-printer
        nodes = deque([self])
        answer = ''
        while len(nodes):
          node = nodes.popleft()
          if not node:
            continue
          answer += str(node.value)
          nodes.append(node.left)
          nodes.append(node.right)
        return answer
    
    
    def createBalancedBST(nums):
      # Fill this in.
    
    print createBalancedBST([1, 2, 3, 4, 5, 6, 7])
    # 4261357
    #   4
    #  / \
    # 2   6
    #/ \ / \
    #1 3 5 7
-}


-- From BinarySearch.java, int mid = lo + (hi - lo) / 2;

createBalancedBST :: Show a => [a] -> Tree a
createBalancedBST [] = EmptyTree 
createBalancedBST [x] = Node x EmptyTree EmptyTree 
createBalancedBST xs = trace ("DEBUG: createBalancedBST - xs:" ++ show xs) 
                       (Node (middleElement xs) (createBalancedBST firstHalf) (createBalancedBST secondHalf))
                       where indexOfMiddleElement = (length xs - 1 ) `div` 2
                             firstHalf = take indexOfMiddleElement xs
                             secondHalf = drop (indexOfMiddleElement + 1) xs

middleElement :: [a] -> a
middleElement xs = xs !! middle 
            where middle = (length xs - 1 ) `div` 2
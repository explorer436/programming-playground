module Datastructures.Trees.ReconstrunctBinaryTreeFromPreorderAndInorderTraversals (reconstruct, leftHalfInOrder, leftHalfPreOrder, rightHalfInOrder, rightHalfPreOrder) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Debug.Trace ( trace, traceShow )

{- |
    Hi, here's your problem today. This problem was recently asked by Microsoft:
    
    You are given the preorder and inorder traversals of a binary tree in the form of arrays.
    Write a function that reconstructs the tree represented by these traversals.
    
    Example:
    Preorder: [a, b, d, e, c, f, g]
    Inorder: [d, b, e, a, f, c, g]
    
    The tree that should be constructed from these traversals is:
    
        a
       / \
      b   c
     / \ / \
    d  e f  g
    
    
    Here's a start:
    
    from collections import deque
    
    class Node(object):
      def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
    
      def __str__(self):
        q = deque()
        q.append(self)
        result = ''
        while len(q):
          n = q.popleft()
          result += n.val
          if n.left:
            q.append(n.left)
          if n.right:
            q.append(n.right)
    
        return result
    
    
    def reconstruct(preorder, inorder):
      # Fill this in.
    
    tree = reconstruct(['a', 'b', 'd', 'e', 'c', 'f', 'g'],
                       ['d', 'b', 'e', 'a', 'f', 'c', 'g'])
    print tree
    # abcdefg
-}

{- |
    (Medium)
    
    Good morning! Here's your coding interview problem for today.
    
    This problem was asked by Google.
    
    Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
    
    For example, given the following preorder traversal:
    
    [a, b, d, e, c, f, g]
    
    And the following inorder traversal:
    
    [d, b, e, a, f, c, g]
    
    You should return the following tree:
    
        a
       / \
      b   c
     / \ / \
    d  e f  g
-}

{-

In a Preorder sequence, the leftmost element is the root of the tree. So we know ‘A’ is the root for given sequences. By searching ‘A’ in the Inorder sequence, we can find out all elements on the left side of ‘A’ is in the left subtree, and elements on right in the right subtree. So we know the below structure now. 

                 A
               /   \
             /       \
           D B E     F C
We recursively follow the above steps and get the following tree.

         A
       /   \
     /       \
    B         C
   / \        /
 /     \    /
D       E  F

-}

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


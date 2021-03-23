module Datastructures.Trees.ReconstrunctBinaryTreeFromPreorderAndInorderTraversals (reconstruct) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

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

reconstruct :: Ord a => [a] -> [a] -> Tree a
reconstruct [] [] = EmptyTree
reconstruct inorderList preorderList = Node rootValue (reconstruct leftHalfInOrder leftHalfPreOrder) (reconstruct rightHalfInOrder rightHalfPreOrder)
                                       where leftHalfInOrder = takeWhile (< rootValue) inorderList
                                             rightHalfInOrder = dropWhile (<= rootValue) inorderList
                                             rootValue = head preorderList
                                             rightHalfPreOrder = drop (length leftHalfInOrder) (tail preorderList)
                                             leftHalfPreOrder = take (length leftHalfInOrder) (tail preorderList)

-- SEPARATING THESE FOR DEBUGGING PURPOSES. 
-- These are not needed because they are already defined in the where clause.

leftHalfInOrder :: Ord a => [a] -> [a] -> [a]
leftHalfInOrder inorderList preorderList = takeWhile (< rootValue) inorderList
                                           where rootValue = head preorderList

rightHalfInOrder :: Ord a => [a] -> [a] -> [a]
rightHalfInOrder inorderList preorderList = dropWhile (<= rootValue) inorderList
                                            where rootValue = head preorderList

rightHalfPreOrder :: Ord a => [a] -> [a] -> [a]
rightHalfPreOrder inorderList preorderList = drop (length (leftHalfInOrder inorderList preorderList)) (tail preorderList)

leftHalfPreOrder :: Ord a => [a] -> [a] -> [a]
leftHalfPreOrder inorderList preorderList = take (length (leftHalfInOrder inorderList preorderList)) (tail preorderList)


{- |
    Node 'F' 
         (Node 'B' 
               (Node 'A' EmptyTree EmptyTree) 
               (Node 'D' 
                     (Node 'C' EmptyTree EmptyTree) 
                     (Node 'E' EmptyTree EmptyTree))) 
         (Node 'G' 
               EmptyTree 
               (Node 'I' 
                     (Node 'H' EmptyTree EmptyTree) 
                     (Node 'J' 
                           EmptyTree 
                           (Node 'K' EmptyTree EmptyTree)))
         )
-}

-- tests
testReconstruct :: Tree Char
testReconstruct = reconstruct "ABCDEFGHIJK" "FBADCEGIHJK"

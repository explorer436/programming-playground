module Datastructures.Trees.MyBinarySearchTree_Insert where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Data.List (permutations, foldl')

----------------------------------------------------------------------------------------------------

singleton :: a -> Tree a  
singleton x = Node x EmptyTree EmptyTree  
  
treeInsert :: (Ord a) => a -> Tree a -> Tree a  
treeInsert x EmptyTree = singleton x  
treeInsert x (Node a left right)   
    | x == a = Node x left right  
    | x < a  = Node a (treeInsert x left) right  
    | x > a  = Node a left (treeInsert x right)

{- |
   BUILDING TREES:

    All we had to do was write up the previous paragraph in code. 
    Let's have some fun with our trees! 
    Instead of manually building one (although we could), 
    we'll use a fold to build up a tree from a list. 
    Remember, 
    pretty much everything that traverses a list one by one and 
    then returns some sort of value can be implemented with a fold! 
    We're going to start with the empty tree and 
    then approach a list from the right and 
    just insert element after element into our accumulator tree.
-}

-- using a right fold here.
treeFromRight :: (Foldable t, Ord a) => t a -> Tree a
treeFromRight xs = foldr treeInsert EmptyTree xs

nums = [8,6,4,1,7,3,5]  
numsTreeFromRight = treeFromRight nums
-- Node 5 (Node 3 (Node 1 EmptyTree EmptyTree) (Node 4 EmptyTree EmptyTree)) (Node 7 (Node 6 EmptyTree EmptyTree) (Node 8 EmptyTree EmptyTree))  

{- |
                          5
                        /  \ 
                       /    \
                      /      \
                     3        7 
                    / \      / \
                   /   \    /   \
                  1     4  6     8 

-}

{- |
    In the foldr for treeFromRight, 
    treeInsert was the folding function 
    (it takes a tree and a list element and produces a new tree) and 
    EmptyTree was the starting accumulator. 
    nums, of course, was the list we were folding over.
    
    The root node is 5 and then it has two sub-trees, 
    one of which has the root node of 3 and the other a 7, etc.
-}

----------------------------------------------------------------------------------------------------

-- building a tree starting from the first element of a list:
-- Using a left fold here.
-- For left fold, the order of the accumulator and the variable x in the lambda is important. The accumulator has to be on the left side of the variable.
treeFromLeft :: (Foldable t, Ord a) => t a -> Tree a
treeFromLeft xs = foldl (\acc x -> treeInsert x acc) EmptyTree xs

nums2 = [25, 20, 15, 27, 30, 29, 26, 22, 32, 17]
numsTreeFromLeft = treeFromLeft nums2

{- |
                         25
                        /  \ 
                       /    \
                      /      \
                     20       27
                    /  \     /  \
                   /    \   /    \
                 15    22 26     30
                  \             /  \
                  17          29   32
-}

----------------------------------------------------------------------------------------------------

-- Using Data.List.permutations here. TODO : write your own implementation for permutations.
perms n = permutations [1..n]
testGenerateBinarySearchTrees = map treeFromLeft (perms 3)
-- [
-- Node 1 EmptyTree (Node 2 EmptyTree (Node 3 EmptyTree EmptyTree)),
-- Node 1 EmptyTree (Node 3 (Node 2 EmptyTree EmptyTree) EmptyTree),
-- Node 2 (Node 1 EmptyTree EmptyTree) (Node 3 EmptyTree EmptyTree),   [2,3,1] and [2,1,3] are going to give the same Binary Search Tree.
-- Node 2 (Node 1 EmptyTree EmptyTree) (Node 3 EmptyTree EmptyTree),
-- Node 3 (Node 1 EmptyTree (Node 2 EmptyTree EmptyTree)) EmptyTree,
-- Node 3 (Node 2 (Node 1 EmptyTree EmptyTree) EmptyTree) EmptyTree
-- ]

----------------------------------------------------------------------------------------------------

module Datastructures.Trees.MyBinarySearchTree_Insert where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Data.List (permutations, foldl')

----------------------------------------------------------------------------------------------------

{- |
    HOW DO WE BUILD A TREE?

    Instead of manually building a tree, we're going to make a function that takes a tree and an element and inserts an element. 
    We do this by comparing the value we want to insert to the root node and then if it's smaller, we go left, if it's larger, we go right. 
    We do the same for every subsequent node until we reach an empty tree. 
    Once we've reached an empty tree, we just insert a node with that value instead of the empty tree.
    
    In languages like C, we'd do this by modifying the pointers and values inside the tree. 
    In Haskell, we can't really modify our tree.
    So, we have to make a new sub-tree each time we decide to go left or right 
    and in the end the insertion function returns a completely new tree, 
    because Haskell doesn't really have a concept of pointer, just values. 
    Hence, the type for our insertion function is going to be something like 
    a -> Tree a - > Tree a. 
    It takes an element and a tree and returns a new tree that has that element inside. 
    This might seem like it's inefficient but laziness takes care of that problem.
    
    So, here are two functions. 

    1. The first one is a utility function for making a singleton tree (a tree with just one node).
       The singleton function is just a shortcut for making a node that has something and then two empty sub-trees. 

    2. The second one is a function to insert an element into a tree.
       In the insertion function, we first have the edge condition as a pattern. 
       If we've reached an empty sub-tree, that means we are where we want and instead of the empty tree, we put a singleton tree with our element. 
       If we're not inserting into an empty tree, then we have to check some things. 
       First off, if the element we're inserting is equal to the root element, 
       just return a tree that's the same. 
       If it's smaller, return a tree that has the same root value, 
       the same right sub-tree but instead of its left sub-tree, 
       put a tree that has our value inserted into it. 
       Same (but the other way around) goes if our value is bigger than the root element.
-}

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

{- |
   GenerateBinarySearchTrees
  
    Hi, here's your problem today. This problem was recently asked by Amazon:
    
    Given a number n, generate all binary search trees that can be constructed with nodes 1 to n.
    
    Here's some code to start with:
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
      def __str__(self):
        result = str(self.value)
        if self.left:
          result = result + str(self.left)
        if self.right:
          result = result + str(self.right)
        return result
    
    def generate_bst(n):
      # Fill this in.
    
    for tree in generate_bst(3):
      print tree
    
    # Pre-order traversals of binary trees from 1 to n.
    # 123
    # 132
    # 213
    # 312
    # 321
    
    #   1      1      2      3      3
    #    \      \    / \    /      /
    #     2      3  1   3  1      2
    #      \    /           \    /
    #       3  2             2  1
-}

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

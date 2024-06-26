module Datastructures.Trees.MyBinarySearchTree_Insert (listToTreeFromRight, listToTreeFromLeft, treeInsert) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Data.List (permutations, foldl')

singleton :: a -> Tree a  
singleton x = Node x EmptyTree EmptyTree  
  
treeInsert :: (Ord a) => a -> Tree a -> Tree a  
treeInsert x EmptyTree = singleton x  
treeInsert x tree@(Node a EmptyTree EmptyTree)   
    | x == a = tree
    | x < a  = Node a (singleton x) EmptyTree
    | x > a  = Node a EmptyTree (singleton x)
treeInsert x tree@(Node a EmptyTree right)   
    | x == a = tree
    | x < a  = Node a (singleton x) right  
    | x > a  = Node a EmptyTree (treeInsert x right)
treeInsert x tree@(Node a left EmptyTree)   
    | x == a = tree
    | x < a  = Node a (treeInsert x left) EmptyTree
    | x > a  = Node a left (singleton x)
treeInsert x tree@(Node a left right)   
    | x == a = tree
    | x < a  = Node a (treeInsert x left) right  
    | x > a  = Node a left (treeInsert x right)


--  Instead of manually building one (although we could), we'll use a fold to build up a tree from a list. 
--  Pretty much everything that traverses a list one by one and then returns some sort of value can be implemented with a fold.
--  We're going to start with the empty tree and then approach a list from the right and just insert element after element into our accumulator tree.
-- using a right fold here.

listToTreeFromRight :: (Foldable t, Ord a) => t a -> Tree a
listToTreeFromRight xs = foldr treeInsert EmptyTree xs

-- In the foldr for listToTreeFromRight, treeInsert was the folding function 
-- (it takes a tree and a list element and produces a new tree) and 
-- EmptyTree was the starting accumulator. 
-- nums, of course, was the list we were folding over.
    
--  The root node is 5 and then it has two sub-trees, 
--  one of which has the root node of 3 and the other a 7, etc.


-- Building a tree starting from the first element of a list:
-- Using a left fold here.
-- For left fold, the order of the accumulator and the variable x in the lambda is important. The accumulator has to be on the left side of the variable.

listToTreeFromLeft :: (Foldable t, Ord a) => t a -> Tree a
listToTreeFromLeft xs = foldl (\acc x -> treeInsert x acc) EmptyTree xs



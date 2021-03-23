module Datastructures.Trees.MyBinarySearchTree_MaximumAndMinimumElements (treeMinimum, treeMaximum) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

{- |
   Finding the minimum and maximum elements in a tree:
   
   Implementing the find-minimum operation requires knowing where the minimum element is in the tree. By definition, the smallest key must reside in the left subtree of the root, since all keys in the left subtree have values less than that of the root. Therefore, the minimum element must be the leftmost descendent of the root. 
   Similarly, the maximum element must be the rightmost descendent of the root.

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



treeMinimum :: Num p => Tree p -> p
treeMinimum EmptyTree = 0
treeMinimum (Node a EmptyTree _) = a
treeMinimum (Node a left right) = treeMinimum left

treeMaximum :: Num p => Tree p -> p
treeMaximum EmptyTree = 0
treeMaximum (Node a _ EmptyTree) = a
treeMaximum (Node a left right) = treeMaximum right


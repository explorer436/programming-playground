module MyBinarySearchTree_MaximumAndMinimumElements where

import MyBinaryTree

----------------------------------------------------------------------------------------------------

-- TODO

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

sampleTree = Node 25 
           (Node 20 
               (Node 15 EmptyTree (Node 17 EmptyTree EmptyTree)) 
               (Node 22 EmptyTree EmptyTree)
           ) 
           (Node 27 
               (Node 26 EmptyTree EmptyTree) 
               (Node 30 (Node 29 EmptyTree EmptyTree) (Node 32 EmptyTree EmptyTree))
           )

treeMinimum :: Num p => Tree p -> p
treeMinimum EmptyTree = 0
treeMinimum (Node a EmptyTree _) = a
treeMinimum (Node a left right) = treeMinimum left

testMinimum01 = treeMinimum sampleTree
testMinimum02 = treeMinimum (Node 8 EmptyTree EmptyTree)


treeMaximum :: Num p => Tree p -> p
treeMaximum EmptyTree = 0
treeMaximum (Node a _ EmptyTree) = a
treeMaximum (Node a left right) = treeMaximum right

testMaximum = treeMaximum sampleTree

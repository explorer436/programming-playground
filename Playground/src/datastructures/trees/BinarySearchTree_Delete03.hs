module BinarySearchTree_Delete03 where

import BinarySearchTrees01

----------------------------------------------------------------------------------------------------

-- TODO
-- delete an element from a tree

{- |
   Finding the minimum and maximum elements in a tree:
   
   Implementing the find-minimum operation requires knowing where the minimum element is in the tree. By definition, the smallest key must reside in the left subtree of the root, since all keys in the left subtree have values less than that of the root. Therefore, the minimum element must be the leftmost descendent of the root. 
   Similarly, the maximum element must be the rightmost descendent of the root.
-}

----------------------------------------------------------------------------------------------------
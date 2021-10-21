module Datastructures.Trees.CompareTreesBySize (largerTreeBySize) where

import Datastructures.Trees.MyBinaryTree (Tree (..), treeSize)

largerTreeBySize tree1 tree2
    | treeSize tree1 == treeSize tree2 = tree1
    | treeSize tree1 > treeSize tree2  = tree1
    | treeSize tree1 < treeSize tree2  = tree2

module Datastructures.Trees.CompareTreesBySize (compareTreeBySize) where

import Datastructures.Trees.MyBinaryTree (Tree (..), treeSize)

compareTreeBySize tree1 tree2
    | treeSize tree1 == treeSize tree2 = tree1
    | treeSize tree1 > treeSize tree2  = tree1
    | treeSize tree1 < treeSize tree2  = tree2

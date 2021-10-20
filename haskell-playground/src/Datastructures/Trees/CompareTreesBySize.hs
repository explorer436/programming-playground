module Datastructures.Trees.CompareTreesBySize (largerTreeBySize) where

largerTreeBySize tree1 tree2
    | treeSize tree1 == treeSize tree2 = tree1
    | treeSize tree1 > treeSize tree2  = tree1
    | treeSize tree1 < treeSize tree2  = tree2
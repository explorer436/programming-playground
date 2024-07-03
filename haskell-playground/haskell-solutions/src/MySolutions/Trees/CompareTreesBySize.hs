module MySolutions.Trees.CompareTreesBySize (compareTreeBySize) where

import MySolutions.Trees.MyBinaryTree (Tree (..), treeSize)

compareTreeBySize tree1 tree2
    | treeSize tree1 == treeSize tree2 = tree1
    | treeSize tree1 > treeSize tree2  = tree1
    | treeSize tree1 < treeSize tree2  = tree2

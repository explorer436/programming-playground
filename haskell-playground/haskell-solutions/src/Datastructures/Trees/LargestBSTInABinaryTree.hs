module Datastructures.Trees.LargestBSTInABinaryTree (largestBSTTree) where

import Datastructures.Trees.MyBinaryTree (Tree (..), treeSize)
import Datastructures.Trees.IsGivenTreeBinarySearchTree (isBST)
import Datastructures.Trees.CompareTreesBySize (compareTreeBySize)
import Data.List (foldl')

-- From Wikipedia:
-- Size of a tree = Number of nodes in the tree.

largestBSTTree EmptyTree                         = EmptyTree
largestBSTTree tree@(Node a EmptyTree EmptyTree) = tree
largestBSTTree tree@(Node a l r)                 = if (isBST tree)
                                                     then tree
                                                   else compareTreeBySize (largestBSTTree l) (largestBSTTree r)

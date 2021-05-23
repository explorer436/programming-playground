{- |
    (Easy)
    
    Good morning! Here's your coding interview problem for today.
    
    This question was asked by Apple.
    
    Given a binary tree, find a minimum path sum from root to a leaf.
    
    For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.
    
      10
     /  \
    5    5
     \     \
       2    1
           /
         -1
-}

-- Hint: use PathsFromRootToAllLeaves.hs


module Datastructures.Trees.MinimumPathSumFromRootToLeaf (minimumPathSumFromRootToLeaf) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Datastructures.Trees.PathsFromRootToAllLeaves (paths)
import Data.List (foldl')

minimumPathSumFromRootToLeaf tree = 

  foldl'

    -- the lambda
    (\ (currentMinSumPath) currentPath ->
        if (sum currentPath < sum currentMinSumPath) 
          then currentPath
        else currentMinSumPath
    )

    -- the initial value
    (head (allPossiblePaths))

    -- the list
    allPossiblePaths

  where allPossiblePaths = paths tree

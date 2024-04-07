module Datastructures.Trees.MinimumPathSumFromRootToLeaf (minimumPathSumFromRootToLeaf) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Datastructures.Trees.PathsFromRootToAllLeaves (paths)
import Data.List (foldl')

-- Hint: use PathsFromRootToAllLeaves.hs

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

module MySolutions.Trees.MinimumPathSumFromRootToLeaf (minimumPathSumFromRootToLeaf) where

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import MySolutions.Trees.PathsFromRootToAllLeaves (paths)
import Data.List (foldl')

-- Hint: use PathsFromRootToAllLeaves.hs

minimumPathSumFromRootToLeaf :: (Ord a, Num a) => Tree a -> [a]
minimumPathSumFromRootToLeaf tree = 

  foldl'

    -- the lambda
    (\ currentMinSumPath currentPath ->
        if sum currentPath < sum currentMinSumPath
          then currentPath
        else currentMinSumPath
    )

    -- the initial value
    (head allPossiblePaths)

    -- the list
    allPossiblePaths

  where allPossiblePaths = paths tree

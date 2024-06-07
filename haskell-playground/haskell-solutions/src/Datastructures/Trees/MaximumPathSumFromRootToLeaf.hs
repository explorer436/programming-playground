module Datastructures.Trees.MaximumPathSumFromRootToLeaf (maximumPathSumFromRootToLeaf) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Datastructures.Trees.PathsFromRootToAllLeaves (paths)
import Data.List (foldl')

-- Hint: use PathsFromRootToAllLeaves.hs

maximumPathSumFromRootToLeaf :: (Ord a, Num a) => Tree a -> [a]
maximumPathSumFromRootToLeaf tree = 

  foldl'

    -- the lambda
    (\ currentMaxSumPath currentPath ->
        if sum currentPath > sum currentMaxSumPath
          then currentPath
        else currentMaxSumPath
    )

    -- the initial value
    (head allPossiblePaths)

    -- the list
    allPossiblePaths

  where allPossiblePaths = paths tree

module Datastructures.Trees.TargetSumFromRootToLeaf (pathWithMatchingSum) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Datastructures.Trees.PathsFromRootToAllLeaves (paths)

pathWithMatchingSum :: (Eq a, Num a) => a -> Tree a -> [[a]]
pathWithMatchingSum inputNumber tree = filter (\x -> sum x == inputNumber) (paths tree)

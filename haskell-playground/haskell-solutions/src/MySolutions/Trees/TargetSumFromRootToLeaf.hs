module MySolutions.Trees.TargetSumFromRootToLeaf (pathWithMatchingSum) where

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import MySolutions.Trees.PathsFromRootToAllLeaves (paths)

pathWithMatchingSum :: (Eq a, Num a) => a -> Tree a -> [[a]]
pathWithMatchingSum inputNumber tree = filter (\x -> sum x == inputNumber) (paths tree)

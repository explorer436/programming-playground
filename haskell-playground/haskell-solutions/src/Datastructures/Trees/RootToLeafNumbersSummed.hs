module Datastructures.Trees.RootToLeafNumbersSummed (rootToLeavesNumbersSummed) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Datastructures.Trees.PathsFromRootToAllLeaves (paths)
import Numbers.ConvertListToDecimalNumber (decimalNumberfromDigits)

rootToLeavesNumbersSummed :: Num a => Tree a -> a
rootToLeavesNumbersSummed tree = sum $ map decimalNumberfromDigits (paths tree)


module MySolutions.Trees.RootToLeafNumbersSummed (rootToLeavesNumbersSummed) where

import MySolutions.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import MySolutions.Trees.PathsFromRootToAllLeaves (paths)
import MySolutions.Numbers.ConvertListToDecimalNumber (decimalNumberfromDigits)

rootToLeavesNumbersSummed :: Num a => Tree a -> a
rootToLeavesNumbersSummed tree = sum $ map decimalNumberfromDigits (paths tree)


module Datastructures.Trees.NumberOfCousinsInLevelOrder (numberOfCousinsInLevelOrder) where

import Data.Maybe (fromJust)
import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Data.List (delete)

numberOfCousinsInLevelOrder :: Eq t => t -> Tree t -> [t]
numberOfCousinsInLevelOrder x tree = helper x [tree]

-- helper x [] = []
helper :: Eq t => t -> [Tree t] -> [t]
helper x listOfTrees = if x `elem` currentLevelValues 
                         then delete x currentLevelValues
                       else
                        helper x (concatMap leftAndRightTrees listOfTrees)
                       where currentLevelValues = map (fromJust . rootValue) listOfTrees

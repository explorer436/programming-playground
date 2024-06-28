module Datastructures.Trees.DepthOfAPeculiarlyRepresentedTree (depthOfAPeculiarlyRepresentedTree) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Trees.HorizontalDistance (horizontalDistance)
import qualified Data.Map as Map 
import Debug.Trace ( trace )
import Text.Printf

import Strings.CountNumberOfOccurancesOfSubstringInAString (countNumberOfOccurancesOfSubstringInAString)
import Strings.RemoveSubstringFromAString (changeSubstringInAString)

depthOfAPeculiarlyRepresentedTree :: Num p => String -> String -> String -> p
depthOfAPeculiarlyRepresentedTree sb "" changeTo = -1
depthOfAPeculiarlyRepresentedTree sb xs changeTo = 
                                                   trace ("depthOfAPeculiarlyRepresentedTree - sb:" ++ show sb ++ ", xs:" ++ show xs) 
                                                   (if sb == xs then 0
                                                   else (countAndDoRecursion sb xs changeTo) - 1)

countAndDoRecursion sb xs changeTo =
    trace ("countAndDoRecursion - sb:" ++ show sb ++ ", xs:" ++ show xs)
    ((myCountFunc sb xs) + (myRecusiveFunc sb xs changeTo))

myCountFunc sb xs =
    trace ("myCountFunc - sb:" ++ show sb ++ ", xs:" ++ show xs)
    countNumberOfOccurancesOfSubstringInAString sb xs

myRecusiveFunc sb xs changeTo =
    trace ("myRecusiveFunc - sb:" ++ show sb ++ ", xs:" ++ show xs)
    depthOfAPeculiarlyRepresentedTree sb newXs changeTo
      where newXs = changeSubstringInAString sb xs changeTo


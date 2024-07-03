module MySolutions.Trees.DepthOfAPeculiarlyRepresentedTree (depthOfAPeculiarlyRepresentedTree) where

import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Trees.HorizontalDistance (horizontalDistance)
import qualified Data.Map as Map
import Debug.Trace ( trace )
import Text.Printf ()

import MySolutions.Strings.CountNumberOfOccurancesOfSubstringInAString (countNumberOfOccurancesOfSubstringInAString)
import MySolutions.Strings.ChangeSubstringInAString (changeSubstringInAString)

depthOfAPeculiarlyRepresentedTree :: Num p => String -> String -> p
depthOfAPeculiarlyRepresentedTree "" changeTo = -1
depthOfAPeculiarlyRepresentedTree xs changeTo =
                                                   trace (">>> depthOfAPeculiarlyRepresentedTree - xs:" ++ show xs)
                                                   (if "(00)" == xs then 0
                                                   else countAndDoRecursion1 xs changeTo + countAndDoRecursion2 xs changeTo)

countAndDoRecursion1 :: Num a => String -> String -> a
countAndDoRecursion1 xs changeTo =
    trace (">>> countAndDoRecursion1 - xs:" ++ show xs)
    (countNumberOfOccurancesOfSubstringInAString "((00)(00))" xs + depthOfAPeculiarlyRepresentedTree (changeSubstringInAString "((00)(00))" xs "0") changeTo)                                                   

countAndDoRecursion2 :: Num a => String -> String -> a
countAndDoRecursion2 xs changeTo =
    trace (">>> countAndDoRecursion2 - xs:" ++ show xs)
    (countNumberOfOccurancesOfSubstringInAString "(00)" xs + depthOfAPeculiarlyRepresentedTree (changeSubstringInAString "00" xs changeTo) changeTo)


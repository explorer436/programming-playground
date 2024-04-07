module Datastructures.Trees.LevelOfTreeWithMinimumSum (tupleWithMinimumSum, levelWithMinimumSum, minimumSum) where

import Datastructures.Trees.MyBinaryTree (Tree (..))

import Data.Int
import Data.Maybe (fromJust)
import Data.List (minimumBy, foldl')

import Datastructures.Trees.BinaryTreeSumsByEachLevel (listWithSumsForEachLevel)

-- For reference, see MaxElementInAListAndItsIndex.hs
-- findFirstMinimumElementInTheListAndIndex :: (Int a, Int b) => [(a, b)] -> Maybe (a, b)
findFirstMinimumElementInTheListAndIndex :: (Ord a, Ord b) => [(a, b)] -> Maybe (a, b)
findFirstMinimumElementInTheListAndIndex [] = Nothing
findFirstMinimumElementInTheListAndIndex xs = Just (foldl' (\acc x -> 
                                                        if ((fst acc) > (fst x)) 
                                                            then x 
                                                        else if ((fst acc) == (fst x)) 
                                                            then (if (snd acc < snd x) 
                                                                    then acc 
                                                                  else x) 
                                                        else acc) (head xs) xs)

tupleWithMinimumSum :: (Ord b, Num b, Enum b) => Tree Int8 -> (Int8, b)
tupleWithMinimumSum tree = fromJust $ findFirstMinimumElementInTheListAndIndex (zip (listWithSumsForEachLevel tree)[0..])
minimumSum :: Tree Int8 -> Int8
minimumSum tree = fst $ tupleWithMinimumSum tree
levelWithMinimumSum :: (Ord b, Num b, Enum b) => Tree Int8 -> b
levelWithMinimumSum tree = snd $ tupleWithMinimumSum tree



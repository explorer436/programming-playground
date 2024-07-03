module MySolutions.Trees.LevelOfTreeWithMaximumSum (levelWithMaximumSum, maximumSum) where

import MySolutions.Trees.MyBinaryTree (Tree (..))

import Data.Int
import Data.List (maximumBy, foldl')
import Data.Maybe (fromJust)
import MySolutions.Trees.BinaryTreeSumsByEachLevel (listWithSumsForEachLevel)

-- For reference, see MaxElementInAListAndItsIndex.hs
findFirstMaximumElementInTheListAndIndex :: (Integral a, Integral b) => [(a, b)] -> Maybe (a, b)
findFirstMaximumElementInTheListAndIndex [] = Nothing
findFirstMaximumElementInTheListAndIndex xs = Just (foldl' (\acc x -> 
                                                        if ((fst acc) < (fst x)) 
                                                            then x 
                                                        else if ((fst acc) == (fst x)) 
                                                            then (if (snd acc < snd x) 
                                                                    then x 
                                                                  else acc) 
                                                        else acc) (head xs) xs)

tupleWithMaximumSum :: Integral b => Tree Int8 -> (Int8, b)
tupleWithMaximumSum tree = fromJust $ findFirstMaximumElementInTheListAndIndex (zip (listWithSumsForEachLevel tree)[0..])
maximumSum :: Tree Int8 -> Int8
maximumSum tree = fst $ tupleWithMaximumSum tree
levelWithMaximumSum :: Integral b => Tree Int8 -> b
levelWithMaximumSum tree = snd $ tupleWithMaximumSum tree



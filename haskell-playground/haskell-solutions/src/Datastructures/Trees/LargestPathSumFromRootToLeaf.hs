
module Datastructures.Trees.LargestPathSumFromRootToLeaf (largestPathSum) where

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)
import Datastructures.Trees.PathsFromRootToAllLeaves (paths)
import Data.List (foldl')

largestPathSum :: (Ord a, Num a) => Tree a -> [a]
largestPathSum tree = (foldl' (\acc x -> if (sum acc < sum x) then x else acc) (head xs) xs)
                                  where xs = paths tree

{- |
findFirstMaximumElementInTheListAndIndex xs = Just (foldl' (\acc x -> 
                                                        if ((fst acc) < (fst x)) 
                                                            then x 
                                                        else if ((fst acc) == (fst x)) 
                                                            then (if (snd acc < snd x) 
                                                                    then x 
                                                                  else acc) 
                                                        else acc) (head xs) xs)                                  
-}                                                        
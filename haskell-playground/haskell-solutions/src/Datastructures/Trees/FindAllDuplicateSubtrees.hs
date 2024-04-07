{-# LANGUAGE FlexibleContexts #-}
module Datastructures.Trees.FindAllDuplicateSubtrees (findDuplicateSubtrees) where

import Datastructures.Trees.MyBinaryTree (Tree (..))
import Datastructures.Lists.CountFrequencyOfElementsInAList (countFrequencyOfAllElements)
import Datastructures.Trees.BuildAllPossibleTrees (buildTreeList)

findDuplicateSubtrees :: (Num a1, Ord a1, Ord a2, Enum a1) => Tree a2 -> [(Tree a2, a1)]
findDuplicateSubtrees tree = filter (\x -> snd x > 1) $ countFrequencyOfAllElements (buildTreeList tree)

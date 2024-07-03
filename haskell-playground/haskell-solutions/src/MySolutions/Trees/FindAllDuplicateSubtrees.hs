{-# LANGUAGE FlexibleContexts #-}
module MySolutions.Trees.FindAllDuplicateSubtrees (findDuplicateSubtrees) where

import MySolutions.Trees.MyBinaryTree (Tree (..))
import MySolutions.Lists.CountFrequencyOfElementsInAList (countFrequencyOfAllElements)
import MySolutions.Trees.BuildAllPossibleTrees (buildTreeList)

findDuplicateSubtrees :: (Num a1, Ord a1, Ord a2, Enum a1) => Tree a2 -> [(Tree a2, a1)]
findDuplicateSubtrees tree = filter (\x -> snd x > 1) $ countFrequencyOfAllElements (buildTreeList tree)

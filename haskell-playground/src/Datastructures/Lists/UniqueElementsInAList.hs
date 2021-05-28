module Datastructures.Lists.UniqueElementsInAList (removeElementsWithMultipleFrequency) where

import Data.List ( nub )
import Datastructures.Lists.CountFrequencyOfElementsInAList (countFrequencyOfAnElementUsingRecursion)

-- How to find the unique numbers in an array
-- e.g. input [1, 2, 1, 3], the result should be [2, 3]

removeElementsWithMultipleFrequency :: Eq a => [a] -> [a]
removeElementsWithMultipleFrequency inputList = [x | x <- inputList, countFrequencyOfAnElementUsingRecursion inputList x == 1]


------------------------------------------------------------------------

-- This is not the same as nub.
-- nub just removes the duplicates from a list.
-- It would still keep one copy of the duplicate elements in the list.
nubTest3 = nub [1,2,3,4,5,1,2]
-- [1,2,3,4,5]

-- TODO Can we write a custom implementation for this.   ?

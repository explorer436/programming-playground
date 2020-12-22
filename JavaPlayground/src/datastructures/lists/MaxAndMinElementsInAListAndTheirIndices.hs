import Data.List (minimumBy, maximumBy, foldl')
import Data.Maybe (fromJust)

-- MAXIMUM ELEMENTS AND THEIR INDICES

testMaximum01 = maximum [1,53,9001,10] -- 9001

-- comparing elements in a single list
testMaximumBy01 = maximumBy compare [1,53,9001,10] -- 9001

-- using the default "compare" function on touples seems to be resulting in comparing by the fst elements and the last index of the greatest element when it occurs multiple times in the list.
-- (value, index) = maximumBy (compare) (zip list [0..])
testMaximumBy02 = maximumBy (compare) (zip [2,7,3,7] [0..]) -- (7, 3)
testMaximumBy03 = maximumBy compare (zip [0..] [2,7,3,1]) -- (3, 1)

-- compare the first elements first and if they are equal, then compare the second elements.
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

testFindFirstMaximumElementInTheListAndIndex01 = fromJust $ findFirstMaximumElementInTheListAndIndex [(4,0),(9,1),(3,2),(7,3)] -- (9,1)
testFindFirstMaximumElementInTheListAndIndex02 = fromJust $ findFirstMaximumElementInTheListAndIndex [(4,0),(9,1),(9,2),(7,3)] -- (9,2)
testFindFirstMaximumElementInTheListAndIndex03 = findFirstMaximumElementInTheListAndIndex [] -- Nothing

----------------------------------------------------------------------------

-- MINIMUM ELEMENTS AND THEIR INDICES


-- using the default "compare" function on touples seems to be resulting in comparing by the fst elements and the last index of the smallest element when it occurs multiple times in the list.
-- This may not be the behavior we would want all the time.
-- (value, index) = minimumBy (compare) (zip list [0..])
testMinimumBy01 = minimumBy (compare) (zip [4,2,3,7] [0..]) -- (2,1)
testMinimumBy02 = minimumBy (compare) (zip [4,2,2,7] [0..]) -- (2,1)
testMinimumBy03 = minimumBy compare (zip [0..] [4,2,2,1]) -- (0,4)


-- compare the first elements first and if they are equal, then compare the second elements.
-- findFirstMinimumElementInTheListAndIndex [] = null
findFirstMinimumElementInTheListAndIndex :: (Integral a, Integral b) => [(a, b)] -> Maybe (a, b)
findFirstMinimumElementInTheListAndIndex [] = Nothing
findFirstMinimumElementInTheListAndIndex xs = Just (foldl' (\acc x -> 
                                                        if ((fst acc) > (fst x)) 
                                                            then x 
                                                        else if ((fst acc) == (fst x)) 
                                                            then (if (snd acc < snd x) 
                                                                    then acc 
                                                                  else x) 
                                                        else acc) (head xs) xs)
-- tests
testFindFirstMinimumElementInTheListAndIndex01 = fromJust $ findFirstMinimumElementInTheListAndIndex [(4,0),(2,1),(3,2),(7,3)] -- (2,1)
testFindFirstMinimumElementInTheListAndIndex02 = fromJust $ findFirstMinimumElementInTheListAndIndex [(4,0),(2,1),(2,2),(7,3)] -- (2,1)
testFindFirstMinimumElementInTheListAndIndex03 = findFirstMinimumElementInTheListAndIndex [] -- Nothing

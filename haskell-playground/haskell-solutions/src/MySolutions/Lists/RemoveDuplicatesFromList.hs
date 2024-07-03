module MySolutions.Lists.RemoveDuplicatesFromList (removeDuplicateFromListLeftFold, removeDuplicateFromListRightFold) where

-- Given a list of integers, select at most one occurence of each integer, 
-- i.e. if the input is [1, 2, 3, 3, 2, 4] the output should be [1, 2, 3, 4].
-- You will be unable to write this function using only the filter function. 
-- This is because the condition in step 2, the lambda that you are passing, needs access to the result of each step.
-- This is exactly what foldl' gives you. 

removeDuplicateFromListLeftFold :: (Foldable t, Eq a) => t a -> [a]
removeDuplicateFromListLeftFold xs = foldl (\result x -> if (x `elem` result) then result else (x:result)) [] xs



removeDuplicateFromListRightFold :: (Foldable t, Eq a) => t a -> [a]
removeDuplicateFromListRightFold xs = foldr (\x result -> if (x `elem` result) then result else (x:result)) [] xs



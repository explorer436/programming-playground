module Datastructures.Lists.GetTheMiddleElementsOfAList (getMiddleElementsOfAList) where
{-|
    Print the middle character of a string

    Given string str, the task is to print the middle character of a string. If the length of the string is even, then there would be two middle characters.
    
    Examples:
    
    Input: str = “hello”
    Output: l
    
    Input: str = “hell”
    Output: el
 -}

getMiddleElementsOfAList :: [a] -> [a]
getMiddleElementsOfAList [] = []
getMiddleElementsOfAList xs
    | odd n     = [xs !! halfN]
    | otherwise = (xs !! (halfN - 1)) : [xs !! halfN]
    where
    n = length xs
    halfN = n `div` 2

{-|
    Print the middle character of a string

    Given string str, the task is to print the middle character of a string. If the length of the string is even, then there would be two middle characters.
    
    Examples:
    
    Input: str = “hello”
    Output: l
    
    Input: str = “hell”
    Output: el
 -}

module Strings.GetTheMiddleCharactersOfAString where

import Datastructures.Lists.GetTheMiddleElementsOfAList (getMiddleElementsOfAList)

getTheMiddleCharactersOfAString :: [a] -> [a]
getTheMiddleCharactersOfAString = getMiddleElementsOfAList
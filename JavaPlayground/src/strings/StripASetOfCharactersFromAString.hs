module StripASetOfCharactersFromAString where

-- The returned string should contain the second string, stripped of any characters in the first string.

solution setOfCharactersToBeRemoved str = [x | x <- str, not (x `elem` setOfCharactersToBeRemoved)] 

--tests

solutionTest01 = solution "-" "123-45"
-- 12345

solutionTest02 = solution "not" "This is not good."
-- "This is  gd."

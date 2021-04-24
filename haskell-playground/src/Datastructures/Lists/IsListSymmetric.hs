module Datastructures.Lists.IsListSymmetric (isListSymmetric) where

-- Same logic as that of Palindrome.hs
-- Strings are lists in Haskell. So, we don't need two separate files for lists and strings. Only one of them can be used for both.




isListSymmetric :: Eq a => [a] -> Bool
isListSymmetric [] = False
isListSymmetric [x] = True
isListSymmetric xs 
    | xs == reverse xs = True
    | otherwise        = False



-- tests
test01 = isListSymmetric [1,2,3,4,3,2,1] -- expect True
test02 = isListSymmetric [1,2,3,4,5,2,1] -- expect False
test03 = isListSymmetric [1,2,3,4,4,3,2,1] -- expect True
test04 = isListSymmetric "testing" -- expect False
test05 = isListSymmetric "deleveled" -- expect True

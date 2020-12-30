module Datastructures.Lists.IsListSymmetric where

-- Same logic as that of Palindrome.hs
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
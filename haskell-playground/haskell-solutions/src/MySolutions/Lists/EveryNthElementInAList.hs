module MySolutions.Lists.EveryNthElementInAList where

everyNthElement :: [a] -> Int -> [a]
everyNthElement [] _ = []
everyNthElement list n
    | (length listAfterDroppingNMinusOneElementsAtTheBeginning > 0) = 
        (head listAfterDroppingNMinusOneElementsAtTheBeginning) : (everyNthElement (tail listAfterDroppingNMinusOneElementsAtTheBeginning) n)
    | otherwise                                                     = []
    where listAfterDroppingNMinusOneElementsAtTheBeginning = drop (n-1) list

-- tests

everyNthElementTest01 = everyNthElement [] 2
everyNthElementTest02 = everyNthElement [1..20] 2
everyNthElementTest03 = everyNthElement [1..20] 3
everyNthElementTest04 = everyNthElement [1..20] 4
everyNthElementTest05 = everyNthElement [1..20] 5
everyNthElementTest06 = everyNthElement [1..20] 6
everyNthElementTest07 = everyNthElement [1..20] 7
everyNthElementTest08 = everyNthElement [1..20] 8
everyNthElementTest09 = everyNthElement [1..20] 9
everyNthElementTest10 = everyNthElement [1..20] 10
everyNthElementTest11 = everyNthElement [1..20] 11
everyNthElementTest20 = everyNthElement [1..20] 20
everyNthElementTest21 = everyNthElement [1..20] 21

everyNthElementTest22 = everyNthElement ['a'..'z'] 3

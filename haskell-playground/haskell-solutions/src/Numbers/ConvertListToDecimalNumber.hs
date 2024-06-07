module Numbers.ConvertListToDecimalNumber (convertListToDecimal, decimalNumberfromDigits) where

import Data.Int

-- [1,3,4] should return 134

-- This works when the list has numbers with more than one digit.
-- show - convert each number in the list to string
-- concat - combine all the strings together
-- read - convert the combined string into a number again
convertListToDecimal :: [Int8] -> Int
convertListToDecimal [] = 0
convertListToDecimal xs = read (concat (map (show) xs))
--tests
testConvertListToDecimal01 = convertListToDecimal [1,3,4] -- expect 134
testConvertListToDecimal02 = convertListToDecimal [13,45] -- expect 1345
testConvertListToDecimal03 = convertListToDecimal [] -- expect 0


-- This behaves differently when the input list has numbers with more than one digit.
-- If you need the solution to work when the input list has numbers with more than one digit, use convertListToDecimal instead.
decimalNumberfromDigits xs = foldl addDigit 0 xs
                          where addDigit num d = 10*num + d
{- |

    Module:	Prelude
    Function:	foldl
    Type:	(a -> b -> a) -> a -> [b] -> a
    Description:	it takes the second argument and the first item of the list and applies the function to them, then feeds the function with this result and the second argument and so on. See scanl for intermediate results.

    foldl walks through the list from left to right, adding the elements to accumulate some value.
    The second argument of foldl, 0 in this case, is the starting value of the process.
 -}

-- tests
testDecimalNumberfromDigits01 = decimalNumberfromDigits [1,3,4] -- expect 134
testDecimalNumberfromDigits02 = decimalNumberfromDigits [13,45] -- expect 175
testDecimalNumberfromDigits03 = decimalNumberfromDigits [] -- expect 0

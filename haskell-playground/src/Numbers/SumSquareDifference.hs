module Numbers.SumSquareDifference where

{- |
    Sum square difference
    The sum of the squares of the first ten natural numbers is,

    1^2 + 2^2 + ... + 10^2 = 385
    The square of the sum of the first ten natural numbers is,

    (1 + 2 + ... + 10)^2 = 552 = 3025
    Hence the difference between 
    the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

    Find the difference between the sum of the squares of the first “N” numbers and the square of the sum.
-}

-- Note: This can also be implemented using folds.

solution :: Integral a => a -> a
solution n = squareOfSumOfFirstNNaturalNumbers n - sumOfSquaresOfFirstNNaturalNumbers n
-- tests
solutionTest01 = solution 10

sumOfSquaresOfFirstNNaturalNumbers :: Integral a => a -> a
sumOfSquaresOfFirstNNaturalNumbers n = sum (map (^2) (takeWhile (<= n) [1..]))

--tests
sumOfSquaresOfFirstNNaturalNumbersTest01 = sumOfSquaresOfFirstNNaturalNumbers 10
-- 385

squareOfSumOfFirstNNaturalNumbers :: Integral a => a -> a
squareOfSumOfFirstNNaturalNumbers n = (sum ((takeWhile (<= n) [1..])))^2

--tests
squareOfSumOfFirstNNaturalNumbersTest01 = squareOfSumOfFirstNNaturalNumbers 10
--3025
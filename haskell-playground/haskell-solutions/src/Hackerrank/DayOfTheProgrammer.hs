module Hackerrank.DayOfTheProgrammer where

import Text.Printf ( printf )

leapDay :: Int -> String
leapDay = printf "12.09.%d"

normalDay :: Int -> String
normalDay = printf "13.09.%d"

julian :: Int -> String
julian year
  | year `mod` 4 == 0 = leapDay year
  | otherwise        = normalDay year


gregorian :: Int -> String
gregorian year
  | year `mod` 400 == 0                          = leapDay year
  | year `mod` 400 == 0 && (year `mod` 100 /= 0) = leapDay year
  | otherwise                                    = normalDay year

russian :: Int -> String
russian year
  | year <= 1917 = julian year
  | year == 1918 = "26.09.1918"
  | otherwise    = gregorian year

main :: IO()
main = interact  $ russian . read

--tests
test01 = russian 2020
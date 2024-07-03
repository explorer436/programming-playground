module MySolutions.Hackerrank.MigratoryBirds where

import Data.List ( group, sort, minimumBy )
import Data.Function ( on )

solution :: [Int] -> Int
solution xs = head $ minimumBy (flip compare `on` length) (group $ sort xs)

-- See minimumBy
-- See flip
-- See Data.Function `on` 


-- Why do we need to sort it?
-- If we do not sort it, the value from the first group will be returned - even though if it is not the smallest in the list.


main :: IO()
main = interact  $ show . solution . map read . tail . words

test01 = solution [1,4,4,4,4,5,3,3,3]

test02 = solution [1,6,6,6,4,4,4,5,3,3,3]
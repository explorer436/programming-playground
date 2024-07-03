module MySolutions.SortingAlgorithms.LinearTimeSort where

import Data.Array

{- |
    Given a list of n integers, each between 0 and 9999, sort the list.

    Algorithms like merge sort take n*logn time.
    But those time ranges are for algorithms that are based on comparison.

    In linear time sort, we follow a different approach based on an important assumption. The assumption is, each of the elements in the input is in a range (min and max).
-}

-- This takes time O(n + 10000)



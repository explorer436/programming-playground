module MySolutions.Strings.LongestCommonSubsequenceBetweenTwoStrings (lcssUsingSimpleRecursion, lcssUsingRecursionOnIndices, lcssUsingArrays, lcssUsingArraysStringsAsArrays) where

import Data.Array

{-|
   Given two strings str1 and str2, find the length of the longest common subsequence of str1 and str2.
   e.g.

   lcss "agcat" "gact" = 3
   because - "gat" is the subsequence common to both of them.

   lcss "abracadabra" "bacarrat" = 6
   because - "bacara" is the subsequence common to both of them.
-}

---------------------------------------------------------------------------

-- This takes time >= O(2 power n), when cs and ds are of length n - which is pretty bad.
-- The same recursive call is made multiple times.
-- To improve efficiency, do not use this method.
-- Instead, write an alternate solution that stores the computed values for efficiency.
lcssUsingSimpleRecursion "" _ = 0
lcssUsingSimpleRecursion _ "" = 0
lcssUsingSimpleRecursion (c:cs) (d:ds)
    | c == d = 1 + lcssUsingSimpleRecursion cs ds
    | otherwise = max (lcssUsingSimpleRecursion (c:cs) ds)
                      (lcssUsingSimpleRecursion cs (d:ds))

---------------------------------------------------------------------------

-- m and n are the last indices of str1 and str2

lcssUsingRecursionOnIndices :: (Num a1, Ord a1, Eq a2) => [a2] -> [a2] -> a1
lcssUsingRecursionOnIndices str1 str2 = lcss' 0 0
                  where
                     m = length str1 - 1 
                     n = length str2 - 1
                     lcss' i j
                       | i > m || j > n     = 0
                       | str1!!i == str2!!j = 1 + lcss' (i+1) (j+1)
                       | otherwise          = max (lcss' i (j+1)) (lcss' (i+1) j)

---------------------------------------------------------------------------

-- This is an extension of lcssUsingRecursionOnIndices
-- We used array instead of listArray because it is easier to provide the values of the array in terms of an associative list.

lcssUsingArrays :: (Num e, Ord e, Eq a) => [a] -> [a] -> e
lcssUsingArrays str1 str2 = lcssA!(0,0)
    where
      m = length str1
      n = length str2
      lcssA = array ((0,0),(m,n)) [((i,j),f i j) | i <- [0..m], j <- [0..n]]
      f i j
        | i >= m || j >= n   = 0
        | str1!!i == str2!!j = 1 + lcssA ! ((i+1),(j+1))
        | otherwise          = max (lcssA ! (i,(j+1))) (lcssA ! ((i+1),j))

{- |
    lcssA = array ((0,0),(5,4)) 
    [((0,0),3),((0,1),3),((0,2),2),((0,3),1),((0,4),0),
     ((1,0),3),((1,1),2),((1,2),2),((1,3),1),((1,4),0),
     ((2,0),2),((2,1),2),((2,2),2),((2,3),1),((2,4),0),
     ((3,0),2),((3,1),2),((3,2),1),((3,3),1),((3,4),0),
     ((4,0),1),((4,1),1),((4,2),1),((4,3),1),((4,4),0),
     ((5,0),0),((5,1),0),((5,2),0),((5,3),0),((5,4),0)]
-}

-- lcssA is a two-dimensional array. Indices are of type (Int,Int)
-- Drawback? Repeated use of (!!) in accessing str1 and str2
-- Solution? Turn the strings to arrays.

---------------------------------------------------------------------------

lcssUsingArraysStringsAsArrays :: (Num e1, Ord e1, Eq e2) => [e2] -> [e2] -> e1 
lcssUsingArraysStringsAsArrays str1 str2 = lcssA!(0,0)
    where
      m = length str1
      n = length str2
      ar1 = listArray (0,m) str1
      ar2 = listArray (0,n) str2
      lcssA = array ((0,0),(m,n)) [((i,j),f i j) | i <- [0..m], j <- [0..n]]
      f i j
        | i >= m || j >= n   = 0
        | ar1!i == ar2!j = 1 + lcssA ! ((i+1),(j+1))
        | otherwise          = max (lcssA ! (i,(j+1))) (lcssA ! ((i+1),j))

{- |
    lcssA = array ((0,0),(5,4)) 
    [((0,0),3),((0,1),3),((0,2),2),((0,3),1),((0,4),0),
     ((1,0),3),((1,1),2),((1,2),2),((1,3),1),((1,4),0),
     ((2,0),2),((2,1),2),((2,2),2),((2,3),1),((2,4),0),
     ((3,0),2),((3,1),2),((3,2),1),((3,3),1),((3,4),0),
     ((4,0),1),((4,1),1),((4,2),1),((4,3),1),((4,4),0),
     ((5,0),0),((5,1),0),((5,2),0),((5,3),0),((5,4),0)]
-}

-- This runs in O(mn) time - because all we have to do is fill in the array with elements.
-- The number of elements in the array is m times n.

---------------------------------------------------------------------------

import Data.Array

-- http://www.zvon.org/other/haskell/Outputarray/listArray_f.html
{- |
    Module: 	Array
    Function: 	listArray
    Type: 	Ix a => (a,a) -> [b] -> Array a b
    Related: 	accumArray, array
-}

-- Ix is the class of all index types, those that can be used as indicies in arrays.
-- If Ix, a, x and y are of type a and x < y, then the range of values between x and y is defined and finite.

-- Ix inclues Int, Char, (Int, Int), (Int, Int, Char) etc. but not Float or [Int].

-- The first argument of listArray specifies the smallest and largest index of the array.
-- The second argument is the list of values to be stored in the array.

myArray01 = listArray (0,2) ['a', 'b', 'c']
-- array (0,2) [(0,'a'),(1,'b'),(2,'c')]

myArray02 = listArray (1,1) [100..199]
-- array (1,1) [(1,100)] - because there is only one index.

myArray03 = listArray ('m','p') [0,2..]
-- array ('m','p') [('m',0),('n',2),('o',4),('p',6)]

myArray04 = listArray ('b','a') [1..]
-- array ('b','a') []

myArray05 = listArray (0,4) [100..]
-- array (0,4) [(0,100),(1,101),(2,102),(3,103),(4,104)]

myArray06 = listArray (1,3) ['a','b']
-- array (1,3) [(1,'a'),(2,'b'),(3,*** Exception: (Array.!): undefined array element

{- |
    The value at index i of an array is accessed using arr!i (unline !! for list access)
    arr!i returns an exception if no value has been defined for index i.
    
    Haskell arrays are lazy: the whole array need not be defined before some elements are accessed.
    For example, we can fill in locations 0 and 1 of arr, and define arr!i in terms of arr!(i-1) and arr!(i-2), for i >= 2.
    list Array takes time proportional to the range of indices.
-}

{- |
    There is another way to create arrays.
    http://www.zvon.org/other/haskell/Outputarray/array_f.html
    
    Module: 	Array
    Function: 	array
    Type: 	Ix a => (a,a) -> [(a,b)] -> Array a b
    Description: 
    
    If a is an index type and b is any type, the type of arrays with indices in a and elements in b is written Array a b. An array may be created by the function array. The first argument of array is a pair of bounds, each of the index type of the array. These bounds are the lowest and highest indices in the array, in that order. For example, a one-origin vector of length 10 has bounds (1,10), and a one-origin 10 by 10 matrix has bounds ((1,1),(10,10)).
    
    The second argument of array is a list of associations of the form (index, value). Typically, this list will be expressed as a comprehension. An association (i, x) defines the value of the array at index i to be x. The array is undefined (i.e. _|_) if any index in the list is out of bounds. If any two associations in the list have the same index, the value at that index is undefined (i.e. _|_). Because the indices must be checked for these errors, array is strict in the bounds argument and in the indices of the association list, but nonstrict in the values.
    
    Not every index within the bounds of the array need appear in the association list, but the values associated with indices that do not appear will be undefined. 
-}
-- This creates an array from an associative list.
-- The associative list need not be in ascending order of indices.
myArray07 = array (0,2) [(1, "one"), (0, "zero"), (2, "two")]

-- The associative list may also omit elements. Is this true?
myArray08 = array (0,2) [(0, "abc"), (2, "xyz")]
-- array (0,2) [(0,"abc"),(1,"*** Exception: (Array.!): undefined array element

-- array also takes time proportional to the range of indices.

---------------------------------------------------------------------------

-- Take a look at the concept called "memoization" - https://en.wikipedia.org/wiki/Memoization

-- Recursive programs can sometimes be very inefficient, recomputing the same value again and again.
-- Memoization is a technique that renders this process efficient, by storing values the first time they are computed.
-- Haskell arrays provides an efficient implementation of these techniques.
-- Important tool to keep in our arsenal.

-- For examples showing the implementation of memoization using arrays, take a look at FibonacciSequence.hs and LongestCommonSubsequenceBetweenTwoStrings.hs

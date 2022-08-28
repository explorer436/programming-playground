module Datastructures.Lists.LengthOfAList where

customLengthImplementationUsingPatternMatchingAndRecursion :: (Num b) => [a] -> b  
customLengthImplementationUsingPatternMatchingAndRecursion [] = 0  
customLengthImplementationUsingPatternMatchingAndRecursion (_:xs) = 1 + customLengthImplementationUsingPatternMatchingAndRecursion xs  
-- tests
customLengthImplementationUsingPatternMatchingAndRecursionTest0  = customLengthImplementationUsingPatternMatchingAndRecursion ""
customLengthImplementationUsingPatternMatchingAndRecursionTest1  = customLengthImplementationUsingPatternMatchingAndRecursion "h"
customLengthImplementationUsingPatternMatchingAndRecursionTest2  = customLengthImplementationUsingPatternMatchingAndRecursion "he"
customLengthImplementationUsingPatternMatchingAndRecursionTest3  = customLengthImplementationUsingPatternMatchingAndRecursion "hel"
customLengthImplementationUsingPatternMatchingAndRecursionTest4  = customLengthImplementationUsingPatternMatchingAndRecursion "hell"
customLengthImplementationUsingPatternMatchingAndRecursionTest5  = customLengthImplementationUsingPatternMatchingAndRecursion "hello"


customImplementationForLengthUsingListComprehension :: Num a => [t] -> a
customImplementationForLengthUsingListComprehension xs = sum [1 | _ <- xs]   
customImplementationForLengthUsingListComprehensionTest1 = customImplementationForLengthUsingListComprehension [1..9]
-- 9
customImplementationForLengthUsingListComprehensionTest2 = customImplementationForLengthUsingListComprehension "bruce wayne"
-- 11

{- |
 Ranges are a way of making lists 
 that are arithmetic sequences of elements that can be enumerated. 
 Numbers can be enumerated. 
 One, two, three, four, etc. 
 Characters can also be enumerated. 
 The alphabet is an enumeration of characters from A to Z. 
 Names can't be enumerated. 
-}
rangesExample1 = [1..20]  
rangesExample2 = ['a'..'z']  
rangesExample3 = ['K'..'Z']  
-- Ranges are cool because you can also specify a step. 
-- What if we want all even numbers between 1 and 20? Or every third number between 1 and 20?
rangesExample4 = [2,4..20]  
rangesExample5 = [3,6..20]  
{- |
 It's simply a matter of separating the first two elements with a comma and 
 then specifying what the upper limit is. 
 To make a list with all the numbers from 20 to 1, you can't just do [20..1], 
 you have to do [20,19..1].
 rangesExample6 = [20..1]  -- this gives a compilation error.

 While pretty smart, ranges with steps aren't as smart as some people expect them to be. 
 You can't do [1,2,4,8,16..100] and expect to get all the powers of 2. 
 Firstly because you can only specify one step. 
 And secondly because some sequences that aren't arithmetic are ambiguous 
 if given only by a few of their first terms.
 
-}
rangesExample7 = [20,19..1]  

{- |
 Watch out when using floating point numbers in ranges! 
 Because they are not completely precise (by definition), 
 their use in ranges can yield some pretty funky results.
 My advice is not to use them in list ranges.
-}
rangesExample8 = [0.1, 0.3 .. 1]  
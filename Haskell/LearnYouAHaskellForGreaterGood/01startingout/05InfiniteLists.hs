-- infinite lists


{- |
  if you don't specify the upper limit, it will be an infinite list.
  e.g. How will you get the first 24 multiples of 13?
  other than doing [13,26..24*13]
-}
rangesExample9 = take 24 [13, 26..]

-- here are a handful of collections that produce infinite lists..

{- |
 cycle takes a list and cycles it into an infinite list. 
 If you just try to display the result, it will go on forever so you have to slice it off somewhere.
-}
cycleExample1 = take 10 (cycle [1,2,3])
cycleExample2 = take 12 (cycle "LOL ")

-- repeat takes an element and produces an infinite list of just that element. It's like cycling a list with only one element.
repeatExample1 = take 10 (repeat 5) 

-- use the replicate function if you want a finite list with the same element in the list. 
replicateExample = replicate 3 10
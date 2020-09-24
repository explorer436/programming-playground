square x = x * x

doubleMe x = x + x

--  doubleUs x y = x*2 + y*2
doubleUs x y = doubleMe x + doubleMe y

doubleSmallNumber x = if x > 10
then x
else x*2

l1 = [1,2,3,4]
l2 = [9,10,11,12]
puttingTwoListsTogether l1 l2 = l1 ++ l2

printHelloWorld = "hello" ++ " " ++ "world!"

printWoot = ['w','o'] ++ ['o','t']

{- |
 When you put together two lists (even if you append a singleton list to a list, 
 for instance: [1,2,3] ++ [4]), 
 internally, Haskell has to walk through the whole list on the left side of ++. 
 That's not a problem when dealing with lists that aren't too big. 
 But putting something at the end of a list that's fifty million entries long is going to take a while. 
 However, putting something at the beginning of a list using the : operator 
 (also called the cons operator - short for construct) is instantaneous. 
-}

consOperatorFirstSample = 'A':" small cat"
consOperatorSecondSample = 5:[1,2,3,4,5]

{- |
 The difference between ++ and the cons operator is, 
 ++ operates on lists and cons operator operates on a single number (or character) and a list of numbers (or characters).
 You might be tempted to try writing [1,2]:3 to add an element to the end of a list, 
 but ghci will reject this with an error message, because the first argument of (:) must be an element, 
 and the second must be a list.
 How to append an element at the end of a list in Haskell?
-}

getElementOutOfAListByIndex = "Steve Buschmi" !! 6

{- |
 hint: look up Lexicographical order in wikipedia
 They are compared in lexicographical order. 
 First the heads are compared. 
 If they are equal then the second elements are compared, etc.
 If a result can be determined by just looking at the first elements, the subsequent elements are ignored.
-}
listComparisonResult1 = [3,2,1] > [2,1,0]  -- true
listComparisonResult2 = [3,2,1] > [2,10,100]  -- true because 3 > 2
listComparisonResult3 = [3,2,1] > [3,10,100]  -- false because 2 > 10
listComparisonResult4 = [3,4,2] > [3,4]  -- true
listComparisonResult5 = [3,4,2] > [2,4]  -- true
listComparisonResult6 = [3,4,2] == [3,4,2]  -- true
listComparisonResult7 = [2,12,1] > [3,10,100]  -- false


sampleList = [6,5,4,3,2,1]
headExample = head sampleList -- takes a list and returns its head. The head of a list is basically its first element. 
tailExample = tail sampleList -- takes a list and returns its tail. In other words, it chops off a list's head.
lastExample = last sampleList -- takes a list and returns its last element.
initExample = init sampleList -- takes a list and returns everything except its last element.
lengthExample = length sampleList
nullExample1 = null sampleList -- checks if a list is empty
nullExample2 = null [] -- checks if a list is empty
reverseExample = reverse sampleList
-- takes number and a list. It extracts that many elements from the beginning of the list.
takeExample1 = take 3 sampleList
takeExample2 = take 1 sampleList
takeExample3 = take 100 sampleList -- If we try to take more elements than there are in the list, it just returns the list. 
takeExample4 = take 0 sampleList -- If we try to take 0 elements, we get an empty list. 
-- drops a number of elements from the beginning of a list.
dropExample1 = drop 3 sampleList
dropExample2 = drop 1 sampleList
dropExample3 = drop 100 sampleList -- If we try to take more elements than there are in the list, it just returns the list. 
dropExample4 = drop 0 sampleList -- If we try to take 0 elements, we get an empty list. 
maximumExample = maximum sampleList
minimumExample = minimum sampleList
sumExample = sum sampleList -- sum takes a list of numbers and returns their sum.
productExample = product sampleList -- product takes a list of numbers and returns their product. 
-- elem takes a thing and a list of things and tells us if that thing is an element of the list.
-- It's usually called as an infix function because it's easier to read that way.
elemOrInfixExample1 = 4 `elem` sampleList
elemOrInfixExample2 = 6 `elem` sampleList
elemOrInfixExample3 = 10 `elem` sampleList

{- |
 Ranges are a way of making lists that are arithmetic sequences of elements that can be enumerated. 
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
 It's simply a matter of separating the first two elements with a comma and then specifying what the upper limit is. 
 While pretty smart, ranges with steps aren't as smart as some people expect them to be. 
 You can't do [1,2,4,8,16..100] and expect to get all the powers of 2. 
 Firstly because you can only specify one step. 
 And secondly because some sequences that aren't arithmetic are ambiguous if given only by a few of their first terms.
 To make a list with all the numbers from 20 to 1, you can't just do [20..1], you have to do [20,19..1].
 rangesExample6 = [20..1]  -- this gives a compilation error.
-}
rangesExample7 = [20,19..1]  

{- |
 Watch out when using floating point numbers in ranges! 
 Because they are not completely precise (by definition), their use in ranges can yield some pretty funky results.
 My advice is not to use them in list ranges.
-}
rangesExample8 = [0.1, 0.3 .. 1]  

-- producing infinite lists

{- |
 cycle takes a list and cycles it into an infinite list. 
 If you just try to display the result, it will go on forever so you have to slice it off somewhere.
-}
cycleExample1 = take 10 (cycle [1,2,3])
cycleExample2 = take 12 (cycle "LOL ")

-- repeat takes an element and produces an infinite list of just that element. It's like cycling a list with only one element.
repeatExample1 = take 10 (repeat 5) 

-- use the replicate function if you want a number of the same elements in a list. 
replicateExample = replicate 3 10

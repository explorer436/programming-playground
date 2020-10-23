testBuiltInSuccessorFunction_01 = succ 8
testBuiltInSuccessorFunction_02 = succ 36

-- usually, when calling a function, just separate the function name from the parameter with a space.
-- if a function needs more than one parameter, just separate the parameters with spaces.
testBuiltInMinFunction_01 = min 9 10
testBuiltInMinFunction_02 = min 3.4 3.2

testBuiltInMaxFunction_01 = max 100 101

-- function application has the highest precedence.
testFunctionPrecedence_01 = succ 9 + max 5 4 * 2
-- 10 + 5 * 2 = 20

testFunctionPrecedence_02 = succ (9 + max 5 4) * 2
-- succ (9 + 5) * 2 = 15 * 2 = 30

-- we can call a function that takes two parameters as an infix function by surroungding it with backticks.
testPrefixNotation_01 = div 92 10
testInfixNotation_01 = 92 `div` 10

-----------------------------------------------------------------------------------------

-- Custom functions

square x = x * x
testSquareFunction_01 = square 4

doubleANumber x = x + x
-- alternatively, 2 * x
testDoubleANumberFunction_01 = doubleANumber 9
-- 18

--  doubleUs x y = x*2 + y*2
doubleUs x y = doubleANumber x + doubleANumber y
testDoubleUsFunction_01 = doubleUs 9 10
-- 38


-- introduction to if statement
-- the else part is mandatory in Haskell.

-- the if statement is an expression - a piece of code that returns a value.

doubleSmallNumber x = if x > 10
then x
else x * 2
testDoubleSmallNumber_01 = doubleSmallNumber 8
--  16
testDoubleSmallNumber_02 = doubleSmallNumber 17
-- 17

-- function names cannot begin with capital letters.


-----------------------------------------------------------------------------------------

-- introduction to lists

-- In Haskell, lists are homogenous (stores same type of elements).

{- |
 In Haskell, strings are just a list of characters. 
 "hello" is just syntactic sugar for ['h', 'e', 'l', 'l', 'o'].
 Because strings are lists, we can use list functions on them, which is really handy.
-}

{- |
 When you put together two lists (even if you append a singleton list to a list, 
 for instance: [1,2,3] ++ [4]), 
 internally, Haskell has to walk through the whole list on the left side of ++. 
 That's not a problem when dealing with lists that aren't too big. 
 But putting something at the end of a list that's fifty million entries long is going to take a while.  
-}

puttingTwoListsTogether l1 l2 = l1 ++ l2
testList1 = [1,2,3,4]
testList2 = [9,10,11,12]
testPuttingTwoListsTogether = puttingTwoListsTogether testList1 testList2
-- [1,2,3,4,9,10,11,12]

printHelloWorld = "hello" ++ " " ++ "world!"

printWoot = ['w','o'] ++ ['o','t']

{- |
 However, putting something at the beginning of a list using the : operator 
 (also called the cons operator - short for construct) is instantaneous. 
-}
consOperatorFirstSample = 'A':" small cat"
consOperatorSecondSample = 5:[1,2,3,4,5]

{- |
 The difference between ++ and the cons operator is, 
 ++ operates on lists and 
 cons operator operates on a single number (or character) 
 and a list of numbers (or characters).
 You might be tempted to try writing [1,2]:3 to 
 add an element to the end of a list, 
 but ghci will reject this with an error message, 
 because the first argument of (:) must be an element, 
 and the second must be a list.
-}
-- How to append an element at the end of a list in Haskell?
-- Not preferrable because Haskell has to 
-- walk through the whole list on the left side first.
testAppendingAnElementAtTheEndOfAList_01 = "hello" ++ ['b']
testAppendingAnElementAtTheEndOfAList_02 = [1,2,3] ++ [4]

{- |
[1, 2, 3] is just syntactic sugar for 1:2:3:[]
[] is an empty list.
So, 5:[1,2,3,4] is syntactic sugar for 5:1:2:3:4:[]
-}


getElementOutOfAListByIndex = "Steve Buschmi" !! 6
-- indexes start at 0.

-- list of lists.
testListOfLists = [[3,2,1], [2,12,1,17], [3,10,100,72,365]]
-- list of list of lists.
testListOfListOfLists = [testListOfLists, [[1111], [2222]]]


-- list comparison
-- lists can be compared if the stuff they contain can be compared.
{- |
 hint: look up Lexicographical order in wikipedia
 They are compared in lexicographical order.
 If a result can be determined by just looking at the first elements, the subsequent elements are ignored.
-}
testListComparison_1 = [3,2,1] > [2,1,0]  -- true
testListComparison_2 = [3,2,1] > [2,10,100]  -- true because 3 > 2. Having found a result, the comparison stops here.
testListComparison_3 = [3,2,1] > [3,1,100]  -- false because 3 is not greater than 3
testListComparison_4 = [3,4,2] > [3,4]  -- true
testListComparison_5 = [3,4,2] > [2,4]  -- true
testListComparison_6 = [3,4,2] == [3,4,2]  -- true
testListComparison_7 = [2,12,1] > [3,10,100]  -- false
testListComparison_8 = [3] == [3]  -- true
testListComparison_9 = [3,4] == [3,5] -- false
testListComparison_10 = [3,4] > [3,5] -- true
testListComparison_11 = [3,4] < [3,5] -- false
{- |
 A nice example for when lexicographical ordering does not result in what the user would expect is 
 file names in Windows. 
 If you have files named xyz1.txt, xyz2.txt, xyz10.txt and xyz20.txt, 
 the lexicographical order would be: 
 xyz1.txt, xyz10.txt, xyz2.txt, xyz20.txt

The comparison does not stop at the first evaluation.
It continues evaluating until a decision can be made.
And a decision can be made as soon as there is an i so that a[i] and b[i] are not equal.
Otherwise the arrays are considered equal.
-}



sampleList = [6,5,4,3,2,1]
testHead = head sampleList -- takes a list and returns its head. The head of a list is basically its first element. 
testTail = tail sampleList -- takes a list and returns its tail. In other words, it chops off a list's head.
testLast = last sampleList -- takes a list and returns its last element.
testInit = init sampleList -- takes a list and returns everything except its last element. In other words, it chops off a list's last element.
testLength = length sampleList
testNull_1 = null sampleList -- checks if a list is empty
    -- false
testNull_2 = null [] -- checks if a list is empty
    -- true
    -- use this instead of xs == null (to check whether xs is null or not)
testReverse = reverse sampleList
-- takes number and a list. It extracts that many elements from the beginning of the list.
testTake_1 = take 3 sampleList
testTake_2 = take 1 sampleList
testTake_3 = take 100 sampleList -- If we try to take more elements than there are in the list, it just returns the list. 
testTake_4 = take 0 sampleList -- If we try to take 0 elements, we get an empty list. 
-- drops a number of elements from the beginning of a list.
testDrop_1 = drop 3 sampleList
testDrop_2 = drop 1 sampleList
testDrop_3 = drop 100 sampleList -- If we try to drop more elements than there are in the list, it just returns an empty list. 
testDrop_4 = drop 0 sampleList -- If we try to drop 0 elements, we get the initial list without any changes.
testMaximum = maximum sampleList
testMinimum = minimum sampleList
testSum = sum sampleList -- sum takes a list of numbers and returns their sum.
testProduct = product sampleList -- product takes a list of numbers and returns their product. 
-- elem takes a thing and a list of things and tells us if that thing is an element of the list.
-- It's usually called as an infix function because it's easier to read that way.
testElem_1 = 4 `elem` sampleList
testElem_2 = 6 `elem` sampleList
testElem_3 = 10 `elem` sampleList

-----------------------------------------------------------------------------------------

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

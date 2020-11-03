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

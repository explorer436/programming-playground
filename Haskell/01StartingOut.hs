-- Getting help : Enter :? at the ghci prompt

-- exit or quit out of ghci : Ctrl D

--  Open terminal and type ghci to launch ghci to go into GHCI!
--  The prompt here is Prelude> and that will work for minor functions.
--  If you want to write your functions in a file, write them in a file called 'baby.hs'.
--  To load this file into ghci, type `:l baby`
--  If you change the .hs script, just run :l myfunctions again or do :r, 
-- which is equivalent because it reloads the current script.
--  To unload this file from ghci, type `:m` (short for module)

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

-- When you put together two lists (even if you append a singleton list to a list, 
-- for instance: [1,2,3] ++ [4]), 
-- internally, Haskell has to walk through the whole list on the left side of ++. 
-- That's not a problem when dealing with lists that aren't too big. 
-- But putting something at the end of a list that's fifty million entries long is going to take a while. 
-- However, putting something at the beginning of a list using the : operator 
-- (also called the cons operator - short for construct) is instantaneous. 

consOperatorFirstSample = 'A':" small cat"
consOperatorSecondSample = 5:[1,2,3,4,5]

-- The difference between ++ and the cons operator is, 
-- ++ operates on lists and cons operator operates on a single number (or character) and a list of numbers (or characters).
-- You might be tempted to try writing [1,2]:3 to add an element to the end of a list, 
-- but ghci will reject this with an error message, because the first argument of (:) must be an element, 
-- and the second must be a list.
-- How to append an element at the end of a list in Haskell?

getElementOutOfAListByIndex = "Steve Buschmi" !! 6

-- hint: look up Lexicographical order in wikipedia
-- They are compared in lexicographical order. 
-- First the heads are compared. 
-- If they are equal then the second elements are compared, etc.
-- If a result can be determined by just looking at the first elements, the subsequent elements are ignored.
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

-- Ranges are a way of making lists that are arithmetic sequences of elements that can be enumerated. 
-- Numbers can be enumerated. 
-- One, two, three, four, etc. 
-- Characters can also be enumerated. 
-- The alphabet is an enumeration of characters from A to Z. 
-- Names can't be enumerated. 
rangesExample1 = [1..20]  
rangesExample2 = ['a'..'z']  
rangesExample3 = ['K'..'Z']  
-- Ranges are cool because you can also specify a step. 
-- What if we want all even numbers between 1 and 20? Or every third number between 1 and 20?
rangesExample4 = [2,4..20]  
rangesExample5 = [3,6..20]  
-- It's simply a matter of separating the first two elements with a comma and then specifying what the upper limit is. 
-- While pretty smart, ranges with steps aren't as smart as some people expect them to be. 
-- You can't do [1,2,4,8,16..100] and expect to get all the powers of 2. 
-- Firstly because you can only specify one step. 
-- And secondly because some sequences that aren't arithmetic are ambiguous if given only by a few of their first terms.
-- To make a list with all the numbers from 20 to 1, you can't just do [20..1], you have to do [20,19..1].
-- rangesExample6 = [20..1]  -- this gives a compilation error.
rangesExample7 = [20,19..1]  

-- Watch out when using floating point numbers in ranges! 
-- Because they are not completely precise (by definition), their use in ranges can yield some pretty funky results.
-- My advice is not to use them in list ranges.
rangesExample8 = [0.1, 0.3 .. 1]  

-- producing infinite lists

-- cycle takes a list and cycles it into an infinite list. 
-- If you just try to display the result, it will go on forever so you have to slice it off somewhere.
cycleExample1 = take 10 (cycle [1,2,3])
cycleExample2 = take 12 (cycle "LOL ")

-- repeat takes an element and produces an infinite list of just that element. It's like cycling a list with only one element.
repeatExample1 = take 10 (repeat 5) 

-- use the replicate function if you want a number of the same elements in a list. 
replicateExample = replicate 3 10

-- list comprehensions
-- A basic comprehension for a set that contains the first ten even natural numbers is S = {2.x | x (- N, x = 10 )}
listComprehensionExample1 = take 10 [2,4..]
-- But what if we didn't want doubles of the first 10 natural numbers but some kind of more complex function applied on them? 
-- We could use a list comprehension for that. 
-- List comprehensions are very similar to set comprehensions.
listComprehensionExample2 = [x*2 | x <- [1..10]]
-- Now let's add a condition (or a predicate) to that comprehension.
-- Predicates go after the binding parts and are separated from them by a comma. 
-- Let's say we want only the elements which, doubled, are greater than or equal to 12. 
listComprehensionExample3 = [x*2 | x <- [1..10], x*2 >= 12]
-- How about if we wanted all numbers from 50 to 100 whose remainder when divided with the number 7 is 3?
listComprehensionExample4 = [x | x <- [50..100], x `mod` 7 == 3]
-- Weeding out lists by predicates is also called filtering. We took a list of numbers and we filtered them by the predicate.

-- Let's say we want a comprehension that replaces each odd number greater than 10 with "BANG!" 
-- and each odd number that's less than 10 with "BOOM!". 
-- If a number isn't odd, we throw it out of our list. 
listComprehensionExample5 = [ if x < 5 then "BOOM!" else "BANG!" | x <- [1..10], odd x]   
-- The last part of the comprehension is the predicate. 
-- The function odd returns True on an odd number and False on an even one. 
-- The element is included in the list only if all the predicates evaluate to True. 

-- We can include several predicates. If we wanted all numbers from 10 to 20 that are not 13, 15 or 19, we'd do:
listComprehensionExample6 = [ x | x <- [10..20], x /= 13, x /= 15, x /= 19]  

-- Not only can we have multiple predicates in list comprehensions 
-- (an element must satisfy all the predicates to be included in the resulting list), 
-- we can also draw from several lists. 
-- When drawing from several lists, comprehensions produce all combinations of the given lists 
-- and then join them by the output function we supply. 
-- A list produced by a comprehension that draws from two lists of length 4 will have a length of 16, 
-- provided we don't filter them. 
-- If we have two lists, [2,5,10] and [8,10,11] and 
-- we want to get the products of all the possible combinations between numbers in those lists : 
listComprehensionExample7 = [ x*y | x <- [10,20,30], y <- [3,4,6]]  
-- As expected, the length of the new list is 9. What if we wanted all possible products that are more than 50?
listComprehensionExample8 = [ x*y | x <- [10,20,30], y <- [3,4,6], x*y > 50]  
-- How about a list comprehension that combines a list of adjectives and a list of nouns?
nouns = ["bruce","arun","explorer"]  
adjectives = ["smart","hard-working","patient"]  
listComprehensionExample9 = [adjective ++ " " ++ noun | adjective <- adjectives, noun <- nouns] 

-- Let's write our own version of length! We'll call it length'.
customImplementationForLengthUsingListComprehension xs = sum [1 | _ <- xs]   
customImplementationForLengthUsingListComprehensionTest1 = customImplementationForLengthUsingListComprehension [1..9]
-- "_" means that we don't care what we'll draw from the list anyway.
-- So instead of writing a variable name that we'll never use, we just write _. 
-- This function replaces every element of a list with 1 and then sums that up.
-- This means that the resulting sum will be the length of our list.

-- because strings are lists, we can use list comprehensions to process and produce strings. 
-- Here's a function that takes a string and removes everything except uppercase letters from it.
-- The word "string" in the line below can also be called "characterList"
removeNonUppercase string = [ c | c <- string, c `elem` ['A'..'Z']]   
-- Testing it out:
listComprehensionExample11 = removeNonUppercase "Free and Open Source Software"  
listComprehensionExample12 = removeNonUppercase "IdontLIKEFROGS"  

-- Nested list comprehensions are also possible if you're operating on lists that contain lists. 
-- A list contains several lists of numbers. 
-- Let's remove all odd numbers without flattening the list.
xxs = [[1,3,5,2,3,1,2,4,5],[1,2,3,4,5,6,7,8,9],[1,2,4,2,1,6,3,1,3,2,3,6]]  
listComprehensionExample13 = [ [ x | x <- xs, even x ] | xs <- xxs]  

-- You can write list comprehensions across several lines. 
-- So if you're not in GHCI, it's better to split longer list comprehensions across multiple lines, especially if they're nested.
-- This is where linters and syntax highlighters for the language might help.

-- Tuplies
-- Look into the topic called tuples. They seem analogous to Enums in Java.
-- They seem very similar to lists - with a few important differences.
-- A list of numbers is a list of numbers. 
-- That's its type and it doesn't matter if it has only one number in it or an infinite amount of numbers.
-- However, tuples are used when you know exactly how many values you want to combine and 
-- its type depends on how many components it has and the types of the components. 
-- They are denoted with parentheses and their components are separated by commas.
-- Unlike lists, they don't have to be homogenous. Unlike a list, a tuple can contain a combination of several types.
-- Think about how we'd represent a two-dimensional vector in Haskell. 
-- One way would be to use a list. 
-- That would kind of work. 
-- So what if we wanted to put a couple of vectors in a list to represent points of a shape on a two-dimensional plane? 
-- We could do something like [[1,2],[8,11],[4,5]]. 
-- The problem with that method is that we could also do stuff like [[1,2],[8,11,5],[4,5]], 
-- which Haskell has no problem with since it's still a list of lists with numbers but it kind of doesn't make sense. 
-- But a tuple of size two (also called a pair) is its own type, 
-- which means that a list can't have a couple of pairs in it and then a triple (a tuple of size three), 
-- so let's use that instead. 
-- Instead of surrounding the vectors with square brackets, we use parentheses: [(1,2),(8,11),(4,5)].
tupleExample1 = [(1,2),(8,11),(4,5)]

-- Using this, we cannot make a shape like this : [(1,2),(8,11,5),(4,5)]

-- Tuples can also be used to represent a wide variety of data. 
-- For instance, if we wanted to represent someone's name and age in Haskell, 
-- we could use a triple: ("Christopher", "Walken", 55). 
-- As seen in this example, tuples can also contain lists.
tupleExample2 = ("Christopher", "Walken", 55)
tupleExample3 = [("Christopher", "Walken", 55), ("John", "Rambo", 58)]

-- Use tuples when you know in advance how many components some piece of data should have. 
-- Tuples are much more rigid because each different size of tuple is its own type, 
-- so you can't write a general function to append an element to a tuple — 
-- you'd have to write a function for appending to a pair, 
-- one function for appending to a triple, one function for appending to a 4-tuple, etc.

-- While there are singleton lists, there's no such thing as a singleton tuple. 
-- It doesn't really make much sense when you think about it. 
-- A singleton tuple would just be the value it contains and as such would have no benefit to us.

-- Collections.singletonList() in Java - "Returns an immutable list containing only the specified object. 
-- The returned list is serializable."
-- Why have a separate method to do it? Why would I want to have a separate method to do that?
-- Primarily as a convenience ... to save you having to write a sequence of statements to:
--    1. create an empty list object
--    2. add an element to it, and
--    3. wrap it with an immutable wrapper.
-- Collections.singletonList will create an immutable List. 
-- An immutable List (also referred to as an unmodifiable List) cannot have it's contents changed. 
-- The methods to add or remove items will throw exceptions if you try to alter the contents.
-- A singleton List contains only that item and cannot be altered.

-- Like lists, tuples can be compared with each other if their components can be compared. 
-- Only you can't compare two tuples of different sizes, whereas you can compare two lists of different sizes. 
-- Two useful functions that operate on pairs:

-- fst takes a pair and returns its first component.
tupleExample4 = fst (8,11)  
tupleExample5 = fst ("Wow", False)  

-- snd takes a pair and returns its second component. Surprise!
tupleExample6 = snd (8,11)  
tupleExample7 = snd ("Wow", False)  

-- Note: these functions operate only on pairs. 
-- They won't work on triples, 4-tuples, 5-tuples, etc. 
-- We'll go over extracting data from tuples in different ways a bit later.

-- A cool function that produces a list of pairs: zip. 
-- It takes two lists and then zips them together into one list by joining the matching elements into pairs. 
-- It's a really simple function but it has loads of uses. 
-- It's especially useful for when you want to combine two lists in a way or traverse two lists simultaneously. 

tupleExample8 = zip [1,2,3,4,5] [6,6,6,6,6]  
tupleExample9 = zip [1 .. 5] ["one", "two", "three", "four", "five"]  

-- It pairs up the elements and produces a new list. 
-- The first element goes with the first, the second with the second, etc. 
-- Notice that because pairs can have different types in them, zip can take two lists that contain different types and zip them up. 
-- What happens if the lengths of the lists don't match?
tupleExample10 = zip [5,3,2,6,2,7,2,5,4,6,6] ["im","a","turtle"] 
-- The longer list simply gets cut off to match the length of the shorter one. 
-- Because Haskell is lazy, we can zip finite lists with infinite lists:
tupleExample11 = zip [1..] ["apple", "orange", "cherry", "mango"]

-- Here's a problem that combines tuples and list comprehensions: 
-- Which right triangle that has integers for all sides and all sides equal to or smaller than 10 has a perimeter of 24?
-- First, let's try generating all triangles with sides equal to or smaller than 10:
tupleTriangles = [ (a,b,c) | c <- [1..10], b <- [1..10], a <- [1..10] ] 
tupleRigtTriangles = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b] , a^2 + b^2 == c^2 ]
tupleRigtTriangleWithPerimeter24 = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b] , a^2 + b^2 == c^2 , a + b + c == 24]

-- Types and Typeclasses
-- Haskell has a static type system. The type of every expression is known at compile time, which leads to safer code.
-- Unlike Java or Pascal, Haskell has type inference. 
-- If we write a number, we don't have to tell Haskell it's a number. 
-- It can infer that on its own, so we don't have to explicitly write out the types of our functions and expressions to get things done.

-- Using GHCI to examine the types of some expressions. 
-- We'll do that by using the :t command which, followed by any valid expression, tells us its type.
-- ghci> :t 'a'  
-- ghci> :t True  
-- ghci> :t "HELLO!"  
-- ghci> :t (True, 'a')  
-- ghci> :t 4 == 5  

-- :: is read as "has type of". 
-- Explicit types are always denoted with the first letter in capital case.
-- Unlike lists, each tuple length has its own type. So the expression of (True, 'a') has a type of (Bool, Char), 
-- whereas an expression such as ('a','b','c') would have the type of (Char, Char, Char).

-- ghci has a command, :set, that lets us change a few of its default behaviours. 
-- We can tell it to print more type information as follows
-- :set +t

-- That it variable is a handy ghci shortcut. It lets us use the result of the expression we just evaluated in a new expression.
-- ghci> "foo"
-- "foo"
-- it :: [Char]
-- ghci> it ++ "bar"
-- "foobar"
-- it :: [Char]


-- When evaluating an expression, ghci won't change the value of it if the evaluation fails. 
-- This lets you write potentially bogus expressions with something of a safety net.

-- ghci> it
-- "foobar"
-- it :: [Char]
-- ghci> it ++ 3
-- 
-- <interactive>:1:6:
--     No instance for (Num [Char])
--       arising from the literal `3' at <interactive>:1:6
--     Possible fix: add an instance declaration for (Num [Char])
--     In the second argument of `(++)', namely `3'
--     In the expression: it ++ 3
--     In the definition of `it': it = it ++ 3
-- ghci> it
-- "foobar"
-- it :: [Char]
-- ghci> it ++ "baz"
-- "foobarbaz"
-- it :: [Char]
-- 
-- When we couple it with liberal use of the arrow keys to recall and edit the last expression we typed, 
-- we gain a decent way to experiment interactively: the cost of mistakes is very low.

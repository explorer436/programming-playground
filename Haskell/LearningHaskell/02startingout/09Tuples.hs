import Data.Char (toLower)
import Data.List (foldl')

-----------------------------------------------------------------------------------------
-- Tuples
{- |

 Tuples are like lists - they are a way to store several values into a single value.
 They seem very similar to lists - with a few important differences.
 
 A list of numbers is a list of numbers. 
 That's its type and it doesn't matter if it has only one number in it or an infinite amount of numbers.

 However, tuples are used when you know exactly how many values you want to combine and 
   its type depends on how many components it has and the types of the components. 
   
They are denoted with parentheses and their components are separated by commas.

 Unlike lists, they don't have to be homogenous. 
 Unlike a list, a tuple can contain a combination of several types.

 Think about how we'd represent a two-dimensional vector in Haskell. 
 One way would be to use a list. 
 That would kind of work. 
 So what if we wanted to put a couple of vectors in a list 
    to represent points of a shape on a two-dimensional plane? 
 We could do something like [[1,2],[8,11],[4,5]]. 
 
 The problem with that method is that we could also do stuff like [[1,2],[8,11,5],[4,5]], 
 which Haskell has no problem with since it's still a list of lists 
   with numbers but it kind of doesn't make sense. 
 
 But a tuple of size two (also called a pair) is its own type, 
   which means that a list can't have a couple of pairs in it and 
   then a triple (a tuple of size three).. 
 Instead of surrounding the vectors with square brackets, we use parentheses: [(1,2),(8,11),(4,5)].

 As seen in this example, tuples can also contain lists.
-}
tupleExample1 = [(1,2),(8,11),(4,5)]

-- Using this, we cannot make a shape like this : [(1,2),(8,11,5),(4,5)]

{- |
 Tuples can be used to represent a wide variety of data. 
 For instance, if we wanted to represent someone's name and age in Haskell, 
 we could use a triple: ("Christopher", "Walken", 55). 
-}
tupleExample2 = ("Christopher", "Walken", 55)
tupleExample3 = [("Christopher", "Walken", 55), ("John", "Rambo", 58)]

{- |
 Use tuples when you know in advance how many components some piece of data should have. 
 Tuples are much more rigid because each different size of tuple is its own type, 
 so you can't write a general function to append an element to a tuple — 
 you'd have to write a function for appending to a pair, 
 one function for appending to a triple, one function for appending to a 4-tuple, etc.
-}

{- |
 While there are singleton lists, there's no such thing as a singleton tuple. 
 It doesn't really make much sense when you think about it. 
 A singleton tuple would just be the value it contains and as such would have no benefit to us.

 Notes about singleton lists:
   Collections.singletonList() in Java - "Returns an immutable list containing only the specified object. 
   The returned list is serializable."
   Why have a separate method to do it? Why would I want to have a separate method to do that?
   Primarily as a convenience ... to save you having to write a sequence of statements to:
      1. create an empty list object
      2. add an element to it, and
      3. wrap it with an immutable wrapper.
   Collections.singletonList() will create an immutable List. 
   An immutable List (also referred to as an unmodifiable List) cannot have it's contents changed. 
   The methods to add or remove items will throw exceptions if you try to alter the contents.
   A singleton List contains only that item and cannot be altered.
-}

{- |
 Like lists, tuples can be compared with each other if their components can be compared. 
 Only you can't compare two tuples of different sizes, whereas you can compare two lists of different sizes. 
-}

-- Two useful functions that operate on pairs:

-- fst takes a pair and returns its first component.
tupleExample4 = fst (8,11)  
-- 8
tupleExample5 = fst ("Wow", False)  
-- "Wow"

-- snd takes a pair and returns its second component. Surprise!
tupleExample6 = snd (8,11)  
-- 11
tupleExample7 = snd ("Wow", False)  
-- False

{- |
 Note: these functions operate only on pairs. 
 They won't work on triples, 4-tuples, 5-tuples, etc. 
 We'll go over extracting data from tuples in different ways a bit later.
-}

{- |
 A cool function that produces a list of pairs: zip. 
 It takes two lists and then zips them together into one list by joining the matching elements into pairs. 
 It's a really simple function but it has loads of uses. 
 It's especially useful for when you want to combine two lists in a way or traverse two lists simultaneously. 
-}
tupleExample8 = zip [1,2,3,4,5] [6,6,6,6,6]  
-- [(1,6),(2,6),(3,6),(4,6),(5,6)]
tupleExample9 = zip [1 .. 5] ["one", "two", "three", "four", "five"]  
-- [(1,"one"),(2,"two"),(3,"three"),(4,"four"),(5,"five")]

{- |
 It pairs up the elements and produces a new list. 
 The first element goes with the first, the second with the second, etc. 
 Notice that because pairs can have different types in them, zip can take two lists that contain different types and zip them up. 
 What happens if the lengths of the lists don't match?
-}
tupleExample10 = zip [5,3,2,6,2,7,2,5,4,6,6] ["im","a","turtle"] 
-- [(5,"im"),(3,"a"),(2,"turtle")]
{- |
 The longer list simply gets cut off to match the length of the shorter one. 
 Because Haskell is lazy, we can zip finite lists with infinite lists:
-}
tupleExample11 = zip [1..] ["apple", "orange", "cherry", "mango"]
-- [(1,"apple"),(2,"orange"),(3,"cherry"),(4,"mango")]

{- |
 Here's a problem that combines tuples and list comprehensions: 
 Which right triangle that has integers for all sides and all sides equal to or smaller than 10 has a perimeter of 24?
 First, let's try generating all triangles with sides equal to or smaller than 10:
-}
tupleTriangles = [ (a,b,c) | c <- [1..10], b <- [1..10], a <- [1..10] ] 
tupleRigtTriangles = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b] , a^2 + b^2 == c^2 ]
tupleRigtTriangleWithPerimeter24 = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b] , a^2 + b^2 == c^2 , a + b + c == 24]
-- [(6,8,10)]

-- Returning multiple values from functions

-- Whenever you want to return multiple values from a function where the type and number of return-values is known at the time of writing the code (compile time, as opposed to run-time). 
-- For example, take a look at the divMod function, which divides two integers, and returns the quotient and the remainder. 
-- The return type is a 2-tuple of type (Int, Int). 
-- Again, here’s the simplified tyep-signature of divmod (what you’ll see in GHCi will be different):
-- divMod :: Int -> Int -> (Int, Int)

-- GHCi> divMod 10 2
-- (5, 0)

-- GHCi> divMod 10 3
-- (3, 1)

-- How do we use the return value of this function? 
-- Let’s understand by using divMod in a real-world example of time arithemetic. 
-- Say, you want to write a function that calculates the end-time of an event, given the start-time and the duration of the event (in minutes):

calculateEndTime :: Int -> Int -> Int -> (Int, Int)
calculateEndTime hr mn durationInMins =
  let (addHour, finalMins) = divMod (mn + durationInMins) 60
  in (hr + addHour, finalMins)

testCalculateEndTime01 = calculateEndTime 10 30 45
-- (11, 15)

testCalculateEndTime02 = calculateEndTime 10 30 115
-- (12, 25)



{- | 

	Passing multiple values to a lambda which accept only a single parameter
	
	How do we actually transform our flat list of contacts to a list of tuples? 
	That is, we want to build the following data transformation:
	Transform this => [ "Adam", "Bhushan", "Bimal", "Chilgoza", "Beth", "Anurag", ...]
	To this =>
	[ ('a', ["Adam", "Anurag", ...]
	, ('b', ["Beth", "Bhushan", ...]
	, ('c', ["Chaman, "Charlie", ...]
	]
	
	This is where we will use tuples to pass multiple values to a lambda which accepts only a single value.
	
	foldl' will give you access to a single accumulator variable, of any type b. 
	What if you want to write logic where you need access to two accumulator variables (which seems to be what we need in our case)? 
	Tuples to the rescue!
	
	Remember, that b cany be any type. 
	foldl' doesn’t care. 
	All it says is that, the lambda’s first argument, the lambda’s return value, and the initial value passed to the foldl' (which is technically the second argument) should be of the same type. 
	Well, in that case b can very well be an n-tuple, if we need it to be!

-}

-- The list may not necessarily be sorted alphabetically
contactsList = [ "Adam", "Bhushan", "Bimal", "Chilgoza", "Beth", "Anurag", "Ashton", "Chaman", "Charlie", "Banksky"]

groupNamesByAlphabet :: Char -> [String] -> (Char, [String])
groupNamesByAlphabet alpha names =
  foldl'

    -- the lambda
    (\ (alphabet, collectedNames) name ->
        if (length name > 0) && (toLower (head name) == (toLower alphabet))
        then (alphabet, collectedNames ++ [name])
        else (alphabet, collectedNames)
    )

    -- the initial value
    (alpha, [])

    -- the list
    names

-- tests
testGroupNamesByAlphabet01 = groupNamesByAlphabet 'a' [ "Adam", "Bhushan", "Bimal", "Chilgoza", "Beth", "Anurag", "Ashton", "Chaman", "Charlie", "Banksky"]
-- ('a',["Adam","Anurag","Ashton"])

groupNamesByAllAlphabets :: [String] -> [(Char, [String])]
-- groupNamesByAllAlphabets names = map (\alphabet -> groupNamesByAlphabet alphabet names) "abcdefghijklmnopqwxyz"
groupNamesByAllAlphabets names = map (\alphabet -> groupNamesByAlphabet alphabet names) ['a'..'z']
testGroupNamesByAllAlphabets = groupNamesByAllAlphabets contactsList
-- [('a',["Adam","Anurag","Ashton"]),
--  ('b',["Bhushan","Bimal","Beth","Banksky"]),
--  ('c',["Chilgoza","Chaman","Charlie"]),
--  ('d',[]), ('e',[]), ('f',[]),('g',[]),('h',[]),('i',[]),('j',[]),('k',[]),('l',[]),('m',[]),('n',[]),('o',[]),('p',[]),('q',[]),('w',[]),('x',[]),('y',[]),('z',[])]


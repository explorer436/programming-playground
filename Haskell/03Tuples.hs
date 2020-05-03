-- Tuples
{- |
 Look into the topic called tuples. They seem analogous to Enums in Java.
 They seem very similar to lists - with a few important differences.
 A list of numbers is a list of numbers. 
 That's its type and it doesn't matter if it has only one number in it or an infinite amount of numbers.
 However, tuples are used when you know exactly how many values you want to combine and 
 its type depends on how many components it has and the types of the components. 
 They are denoted with parentheses and their components are separated by commas.
 Unlike lists, they don't have to be homogenous. Unlike a list, a tuple can contain a combination of several types.
 Think about how we'd represent a two-dimensional vector in Haskell. 
 One way would be to use a list. 
 That would kind of work. 
 So what if we wanted to put a couple of vectors in a list to represent points of a shape on a two-dimensional plane? 
 We could do something like [[1,2],[8,11],[4,5]]. 
 The problem with that method is that we could also do stuff like [[1,2],[8,11,5],[4,5]], 
 which Haskell has no problem with since it's still a list of lists with numbers but it kind of doesn't make sense. 
 But a tuple of size two (also called a pair) is its own type, 
 which means that a list can't have a couple of pairs in it and then a triple (a tuple of size three), 
 so let's use that instead. 
 Instead of surrounding the vectors with square brackets, we use parentheses: [(1,2),(8,11),(4,5)].
-}
tupleExample1 = [(1,2),(8,11),(4,5)]

-- Using this, we cannot make a shape like this : [(1,2),(8,11,5),(4,5)]

{- |
 Tuples can also be used to represent a wide variety of data. 
 For instance, if we wanted to represent someone's name and age in Haskell, 
 we could use a triple: ("Christopher", "Walken", 55). 
 As seen in this example, tuples can also contain lists.
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
-}

{- |
 Collections.singletonList() in Java - "Returns an immutable list containing only the specified object. 
 The returned list is serializable."
 Why have a separate method to do it? Why would I want to have a separate method to do that?
 Primarily as a convenience ... to save you having to write a sequence of statements to:
    1. create an empty list object
    2. add an element to it, and
    3. wrap it with an immutable wrapper.
 Collections.singletonList will create an immutable List. 
 An immutable List (also referred to as an unmodifiable List) cannot have it's contents changed. 
 The methods to add or remove items will throw exceptions if you try to alter the contents.
 A singleton List contains only that item and cannot be altered.
-}

{- |
 Like lists, tuples can be compared with each other if their components can be compared. 
 Only you can't compare two tuples of different sizes, whereas you can compare two lists of different sizes. 
 Two useful functions that operate on pairs:
-}

-- fst takes a pair and returns its first component.
tupleExample4 = fst (8,11)  
tupleExample5 = fst ("Wow", False)  

-- snd takes a pair and returns its second component. Surprise!
tupleExample6 = snd (8,11)  
tupleExample7 = snd ("Wow", False)  

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
tupleExample9 = zip [1 .. 5] ["one", "two", "three", "four", "five"]  

{- |
 It pairs up the elements and produces a new list. 
 The first element goes with the first, the second with the second, etc. 
 Notice that because pairs can have different types in them, zip can take two lists that contain different types and zip them up. 
 What happens if the lengths of the lists don't match?
-}
tupleExample10 = zip [5,3,2,6,2,7,2,5,4,6,6] ["im","a","turtle"] 
{- |
 The longer list simply gets cut off to match the length of the shorter one. 
 Because Haskell is lazy, we can zip finite lists with infinite lists:
-}
tupleExample11 = zip [1..] ["apple", "orange", "cherry", "mango"]

{- |
 Here's a problem that combines tuples and list comprehensions: 
 Which right triangle that has integers for all sides and all sides equal to or smaller than 10 has a perimeter of 24?
 First, let's try generating all triangles with sides equal to or smaller than 10:
-}
tupleTriangles = [ (a,b,c) | c <- [1..10], b <- [1..10], a <- [1..10] ] 
tupleRigtTriangles = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b] , a^2 + b^2 == c^2 ]
tupleRigtTriangleWithPerimeter24 = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b] , a^2 + b^2 == c^2 , a + b + c == 24]

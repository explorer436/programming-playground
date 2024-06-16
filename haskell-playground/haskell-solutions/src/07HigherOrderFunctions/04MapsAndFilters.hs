-- `map` takes a function and a list 
-- and applies that function to every element in the list, producing a new list.

map' :: (a -> b) -> [a] -> [b]  
map' _ [] = []  
map' f (x:xs) = f x : map f xs 

{- |
    The type signature says that it takes 
        a function that takes an a and returns a b, 
        a list of a's and returns a list of b's. 
    It is interesting that just by looking at a function's type signature, 
        you can sometimes tell what it does. 
    `map` is one of those really versatile higher-order functions 
        that can be used in millions of different ways.
-}

-- intentionally using Prelude.map here.
testMap01 = map (+3) [1,5,3,1,6]  
-- [4,8,6,4,9]  
testMap02 = map (++ "!") ["BIFF", "BANG", "POW"]  
-- ["BIFF!","BANG!","POW!"]  
testMap03 = map (replicate 3) [3..6]  
-- [[3,3,3],[4,4,4],[5,5,5],[6,6,6]]  
testMap04 = map (map (^2)) [[1,2],[3,4,5,6],[7,8]]  
-- [[1,4],[9,16,25,36],[49,64]]  
testMap05 = map fst [(1,2),(3,5),(6,3),(2,6),(2,5)]  
-- [1,3,6,2,2]

{- |
    Each of these could be achieved with a list comprehension. 
    map (+3) [1,5,3,1,6] is the same as writing [x+3 | x <- [1,5,3,1,6]]. 
    However, using map is much more readable for cases 
        where you only apply some function to the elements of a list, 
        especially once you're dealing with maps of maps 
        and then the whole thing with a lot of brackets can get a bit messy.
-}


----------------------------------------------------------------

{- |
    filter is a function that takes a predicate 
        (a predicate is a function that tells whether something is true or not, 
        so in our case, a function that returns a boolean value) 
        and a list 
        and then returns the list of elements that satisfy the predicate. 
        The type signature and implementation go like this:
-}

filter' :: (a -> Bool) -> [a] -> [a]  
filter' _ [] = []  
filter' p (x:xs)   
    | p x       = x : filter' p xs  
    | otherwise = filter' p xs 

-- If p x evaluates to True, the element gets included in the new list. 
-- If it doesn't, it stays out.    

testFilter01 =  filter (>3) [1,5,3,2,1,6,4,3,2,1]  
-- [5,6,4]  
testFilter02 =  filter (==3) [1,2,3,4,5]  
-- [3]  
testFilter03 =  filter even [1..10]  
-- [2,4,6,8,10]  
testFilter04 =  let notNull x = not (null x) in filter notNull [[1,2,3],[],[3,4,5],[2,2],[],[],[]]  
-- [[1,2,3],[3,4,5],[2,2]]  
testFilter05 =  filter (`elem` ['a'..'z']) "u LaUgH aT mE BeCaUsE I aM diFfeRent"  
-- "uagameasadifeent"  
testFilter06 =  filter (`elem` ['A'..'Z']) "i lauGh At You BecAuse u r aLL the Same"  
-- "GAYBALLS" 

{- |
    All of this could also be achived with list comprehensions by the use of predicates. 
    There's no set rule for when to use map and filter versus using list comprehension, 
        you just have to decide what's more readable depending on the code and the context. 
    The filter equivalent of applying several predicates in a list comprehension is 
        either filtering something several times 
        or joining the predicates with the logical && function.
-}

----------------------------------------------------------------

{- |
    Mapping and filtering is the bread and butter of every functional programmer's toolbox. 
    It doesn't matter if you do it with the map and filter functions or list comprehensions. 
    Recall how we solved the problem of finding right triangles with a certain circumference. 
    With imperative programming, 
        we would have solved it by nesting three loops 
        and then testing if the current combination satisfies a right triangle 
        and if it has the right perimeter. 
    If that's the case, we would have printed it out to the screen or something. 
    In functional programming, that pattern is achieved with mapping and filtering. 
    You make a function that takes a value and produces some result. 
    We map that function over a list of values 
        and then we filter the resulting list out for the results that satisfy our search. 
    Thanks to Haskell's laziness, 
        even if you map something over a list several times and filter it several times,
        it will only pass over the list once.
-}

-- See LargestNumberUnderNDivisibleByAGivenNumber.hs

-- See SumOfAllOddSquaresSmallerThanN.hs for details about Haskell's `takeWhile` function.

-- See CollatzSequences.hs for details about `chain` function.

----------------------------------------------------------------

{- |
    Using map, we can also do stuff like map (*) [0..], 
    if not for any other reason than to illustrate how currying works 
        and how (partially applied) functions are real values that you can pass around 
        to other functions or put into lists (you just can't turn them to strings). 
    So far, we've only mapped functions that take one parameter over lists, 
        like map (*2) [0..] to get a list of type (Num a) => [a], 
        but we can also do map (*) [0..] without a problem. 
    What happens here is that the number in the list is applied to the function *, 
        which has a type of (Num a) => a -> a -> a. 
    Applying only one parameter to a function that takes two parameters 
        returns a function that takes one parameter. 
    If we map * over the list [0..], 
        we get back a list of functions that only take one parameter, 
        so (Num a) => [a -> a]. map (*) [0..] 
        produces a list like the one we'd get by writing [(0*),(1*),(2*),(3*),(4*),(5*)...

    Getting the element with the index 4 from our list 
        returns a function that's equivalent to (4*). 
    And then, we just apply 5 to that function. 
    So that's like writing (4*) 5 or just 4 * 5.
-}

listOfFuns = map (*) [0..]  
-- tests
testListOfFuns01 = (listOfFuns !! 4) 5  
-- 20  
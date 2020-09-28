import Data.List

-----------------------------------------------------------------------------------------
-- list comprehensions

{- |
 https://en.wikipedia.org/wiki/List_comprehension

     A list comprehension is a syntactic construct available in 
     some programming languages for creating a list based on existing lists. 
     It follows the form of the mathematical set-builder notation (set comprehension)
     as distinct from the use of map and filter functions.
-}

{- |
 https://en.wikipedia.org/wiki/Set-builder_notation

     In set theory and its applications to logic, mathematics, and computer science,
     set-builder notation is a mathematical notation for 
     describing a set by enumerating its elements, 
     or stating the properties that its members must satisfy.

     Defining sets by properties is also known as set comprehension, 
     set abstraction or as defining a set's intension.
-}

-- set comprehensions are usually used for building more specific sets out of general sets.
-- A basic comprehension for a set that contains the first ten even natural numbers is S = {2.x | x (belongs to) N, x <= 10 )}
-- The part before the pipe is called the output function,
-- x is the variable,
-- N is the input set,
-- and `x <= 10` is the predicate.
-- In Haskell, it can be represented like this.
setComprehensionExample1 = take 10 [2,4..]

{- |
 But what if we didn't want doubles of the first 10 natural numbers but some kind of more complex function applied on them? 
 We could use a list comprehension for that. 
 List comprehensions are very similar to set comprehensions.
 The same condition from above can be represented with list comprehensions like this.
 Every element in [1..10] is bound to the variable x.
 Do the operation on x and return the list after doing the operation on all the elements in it.
-}
listComprehensionExample2 = [x*2 | x <- [1..10]]

{- |
 Now let's add a condition (or a predicate) to that comprehension.
 Predicates go after the binding parts and are separated from them by a comma. 
 Let's say we want only the elements which, doubled, are greater than or equal to 12. 
-}
listComprehensionExample3 = [x*2 | x <- [1..10], x*2 >= 12]

-- How about if we wanted all numbers from 50 to 100 whose remainder when divided with the number 7 is 3?
listComprehensionExample4 = [x | x <- [50..100], x `mod` 7 == 3]

-- Filtering : Weeding out lists by predicates is also called filtering.
-- The predicates do all the work when it comes to filtering.
-- We took a list of numbers and we filtered them by the predicate.

{- |
 Let's say we want a comprehension that replaces each odd number greater than 10 with "BANG!" 
 and each odd number that's less than 10 with "BOOM!". 
 If a number isn't odd, we throw it out of our list. (filtering)
-}
boomBangs xs = [ if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]   
listComprehensionExample5 = boomBangs [3..22]
{- |
 The last part of the comprehension is the predicate. 
 The function odd returns True on an odd number and False on an even one. 
 The element is included in the list only if all the predicates evaluate to True. 
-}

-- We can include several predicates. 
-- If we wanted all numbers from 10 to 20 that are not 13, 15 or 19, we'd do:
listComprehensionExample6 = [ x | x <- [10..20], x /= 13, x /= 15, x /= 19]  

{- |
 Not only can we have multiple predicates in list comprehensions 
 (an element must satisfy all the predicates to be included in the resulting list), 
 we can also draw from several lists. 
 When drawing from several lists, comprehensions produce all combinations of the given lists 
 and then join them by the output function we supply. 
 A list produced by a comprehension that draws from two lists of length 4 will have a length of 16, 
 provided we don't filter them. 
 If we have two lists, [2,5,10] and [8,10,11] and 
 we want to get the products of all the possible combinations between numbers in those lists : 
-}
listComprehensionExample7 = [ x*y | x <- [10,20,30], y <- [3,4,6]]  
-- As expected, the length of the new list is 9. 

-- What if we wanted all possible products that are more than 50?
listComprehensionExample8 = [ x*y | x <- [10,20,30], y <- [3,4,6], x*y > 50]  

-- How about a list comprehension that combines a list of adjectives and a list of nouns?
nouns = ["bruce","arun","explorer"]  
adjectives = ["smart","hard-working","patient"]  
listComprehensionExample9 = [adjective ++ " " ++ noun | adjective <- adjectives, noun <- nouns] 


-- Let's write our own version of length! We'll call it length'.
customImplementationForLengthUsingListComprehension xs = sum [1 | _ <- xs]   
customImplementationForLengthUsingListComprehensionTest1 = customImplementationForLengthUsingListComprehension [1..9]
-- 9
customImplementationForLengthUsingListComprehensionTest2 = customImplementationForLengthUsingListComprehension "bruce wayne"
-- 11

{- |
 "_" means that we don't care what we'll draw from the list anyway.
 So instead of writing a variable name that we'll never use, we just write _. 
 This function replaces every element of a list with 1 and then sums that up.
 This means that the resulting sum will be the length of our list.
-}


{- |
 Since strings are lists, we can use list comprehensions to process and produce strings. 
 Here's a function that takes a string and removes everything except uppercase letters from it.
 The word "string" in the line below can also be called "characterList"
-}
removeNonUppercase :: [Char] -> [Char]
removeNonUppercase string = [ c | c <- string, c `elem` ['A'..'Z']]   
-- Testing it out:
listComprehensionExample11 = removeNonUppercase "Free and Open Source Software"  
listComprehensionExample12 = removeNonUppercase "IdontLIKEFROGS"  

{- |
 Nested list comprehensions are also possible if you're operating on lists that contain lists. 
 A list contains several lists of numbers. 
 Let's remove all odd numbers without flattening the list.
-}
xxs = [[1,3,5,2,3,1,2,4,5],[1,2,3,4,5,6,7,8,9],[1,2,4,2,1,6,3,1,3,2,3,6]]  
listComprehensionExample13 = [ [ x | x <- xs, even x ] | xs <- xxs]  

{- |
 You can write list comprehensions across several lines. 
 So if you're not in GHCI, 
     it is better to split longer list comprehensions across multiple lines,
     especially if they're nested.
 This is where linters and syntax highlighters for the language might help.
-}



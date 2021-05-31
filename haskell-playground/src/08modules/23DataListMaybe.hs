
------------------------------------------------------------------------


-- Let’s look at the type signature for the find function
-- Prelude> :t Data.List.find
-- Data.List.find :: Foldable t => (a -> Bool) -> t a -> Maybe a

-- We can see this function takes two arguments; 
-- firstly a function of type a -> Bool, and secondly a value of type Foldable t => t a. 
-- This function then returns another wrapper type. 
-- This one is called Maybe, and it is wrapping the same type that our Foldable t => t is wrappering.

-- What does this function do, though? 
-- Well, it takes that function of a -> Bool and applies it to each of the items in the Foldable t => t a. 
-- If it can’t find any that return True, it returns the Nothing value, which comes from the Maybe a type. 
-- If it does find any that return True, it returns the first one, wrapped in the Just value constructor from the Maybe a type.

-- Maybe is a type that takes another type to make types with (this is called a type constructor). 
-- That means you can have values of type Maybe Int, Maybe Cat, Maybe House, or Maybe any other concrete type you like.
-- It’s a sort of wrapper for other types, and it’s what we use in Haskell when we want to make a type’s value optional.

-- Take a look at 03ADTProductTypes.hs for an example demonstrating its use.

-- In the case of the cat example in 03ADTProductTypes, we can’t be 100% sure if the list that is passed to findOldestCat will contain something. 
-- If it is empty, then we obviously can’t pass a Cat back at all. 
-- The way Maybe values work is there’s a value called Nothing which represents “no value” of the wrapped type, and there’s a value called “Just a” which represents any other value of our wrapped type. 
-- Take a look at the following values and their type signatures:

-- Just 5 :: Num a => Maybe a
-- Just "Heya" :: Maybe String
-- Just (Cat "YOOBEY" Sphynx 8) :: Maybe Cat
-- Nothing :: Maybe Cat
-- Nothing :: Maybe Integer
-- Nothing :: Maybe a

-- You might be surprised to know that Nothing :: Maybe Cat can’t be compared to Nothing :: Maybe Integer. 
-- This is because Cat is a different type than Integer and you can’t compare differently typed values 
-- (unless they’re polymorphic values — that is, values whose types have type variables like Nothing :: Maybe a, or 5 :: Num a => a).

-- So, Nothing :: Maybe Cat means “there are no cats”, and Just (Cat "YOOBEY" Sphynx 8) means “a value of the optional-Cat type that has a Cat in it). 
-- This is different than the values whose type is Cat, because a value of the type Cat must be a Cat as defined by the type - it can’t be empty at all.

-- This is a very nice property for a programming language to have. 
-- If there is a value whose type is Integer, you can be sure it won’t have anything other than exactly that in it, which makes reading and reasoning about programs much much easier.

-- However, every positive side has a negative side, too, and the negative side of this is that it makes working with empty things slightly more complicated than if there were just a general value that means an empty thing. 
-- We definitely think the complexity is worth it, though, because these optional types are some of the biggest sources of errors in programming languages that don’t have this feature of “typed optionality”.

testFind01 = find (>4) [1,2,3,4,5,6]  
-- Just 5  
testFind02 = find (>9) [1,2,3,4,5,6]  
-- Nothing  

-- find takes a list and a predicate and returns the first element that satisfies the predicate.
-- But it returns that element wrapped in a Maybe value.
-- We'll be covering algebraic data types more in depth in the next chapter but for now,
-- this is what you need to know: 
-- a Maybe value can either be Just something or Nothing.
-- Much like a list can be either an empty list or a list with some elements, a Maybe value can be either no elements or a single element.
-- And like the type of a list of, say, integers is [Int], the type of maybe having an integer is Maybe Int.


-- Notice the type of find. Its result is Maybe a. 
-- That's kind of like having the type of [a], only a value of the type Maybe can contain either no elements or one element, 
-- whereas a list can contain no elements, one element or several elements.

-- Remember when we were searching for the first time our stock went over $1000. 
-- We did head (dropWhile (\(val,y,m,d) -> val < 1000) stock). 
-- Remember that head is not really safe. 
-- What would happen if our stock never went over $1000? 
-- Our application of dropWhile would return an empty list 
-- and getting the head of an empty list would result in an error. 
-- However, if we rewrote that as find (\(val,y,m,d) -> val > 1000) stock, 
-- we'd be much safer. 
-- If our stock never went over $1000 (so if no element satisfied the predicate), 
-- we'd get back a Nothing. 
-- But there was a valid answer in that list, we'd get, say, Just (1001.4,2008,9,4).

------------------------------------------------------------------------

-- elemIndex is kind of like elem, only it doesn't return a boolean value. 
-- It maybe returns the index of the element we're looking for. 
-- If that element isn't in our list, it returns a Nothing.

-- ghci> :t elemIndex  
-- elemIndex :: (Eq a) => a -> [a] -> Maybe Int  

testElemIndex01 = 4 `elemIndex` [1,2,3,4,5,6]  
-- Just 3  
testElemIndex02 = 10 `elemIndex` [1,2,3,4,5,6]  
-- Nothing  

-- elemIndices is like elemIndex, 
-- only it returns a list of indices, 
-- in case the element we're looking for crops up in our list several times. 
-- Because we're using a list to represent the indices, 
-- we don't need a Maybe type, 
-- because failure can be represented as the empty list, 
-- which is very much synonymous to Nothing.

testElemIndices01 = ' ' `elemIndices` "Where are the spaces?"  
-- [5,9,13]  

------------------------------------------------------------------------

-- findIndex is like find, 
-- but it maybe returns the index of the first element that satisfies the predicate. 
-- findIndices returns the indices of all elements 
-- that satisfy the predicate in the form of a list.

testFindIndex01 = findIndex (==4) [5,3,2,1,6,4]  
-- Just 5  
testFindIndex02 = findIndex (==7) [5,3,2,1,6,4]  
-- Nothing  
testFindIndices01 = findIndices (`elem` ['A'..'Z']) "Where Are The Caps?"  
-- [0,6,10,14]  

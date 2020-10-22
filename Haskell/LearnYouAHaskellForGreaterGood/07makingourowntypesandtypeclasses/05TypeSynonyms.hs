-- Type synonyms

-- Previously, we mentioned that when writing types, 
-- the [Char] and String types are equivalent and interchangeable. 
-- That's implemented with type synonyms.
-- Type synonyms don't really do anything per se,
-- they're just about giving some types different names 
-- so that they make more sense to someone reading our code and documentation.
-- Here's how the standard library defines String as a synonym for [Char].

type String = [Char]  

-- We've introduced the type keyword.
-- The keyword might be misleading to some,
-- because we're not actually making anything new 
-- (we did that with the data keyword),
-- but we're just making a synonym for an already existing type.

-- If we make a function that converts a string to uppercase 
-- and call it toUpperString or something,
-- we can give it a type declaration of 
-- toUpperString :: [Char] -> [Char] or toUpperString :: String -> String. 
-- Both of these are essentially the same, only the latter is nicer to read.

-- When we were dealing with the Data.Map module,
-- we first represented a phonebook with an association list 
-- before converting it into a map.
-- As we've already found out, 
-- an association list is a list of key-value pairs.
-- Let's look at a phonebook that we had.

phoneBook :: [(String,String)]  
phoneBook =      
    [("betty","555-2938")     
    ,("bonnie","452-2928")     
    ,("patsy","493-2928")     
    ,("lucille","205-2928")     
    ,("wendy","939-8282")     
    ,("penny","853-2492")     
    ]  

-- We see that the type of phoneBook is [(String,String)].
-- That tells us that it's an association list that maps from 
-- strings to strings, but not much else.
-- Let's make a type synonym to convey 
-- some more information in the type declaration.

type PhoneBook = [(String,String)]  

-- Now the type declaration for our phonebook can be 
-- phoneBook :: PhoneBook. Let's make a type synonym for String as well.

type PhoneNumber = String  
type Name = String  
type PhoneBook = [(Name,PhoneNumber)]

-- Giving the String type synonyms is something that 
-- Haskell programmers do when they want to 
-- convey more information about what 
-- strings in their functions should be used as and what they represent.

-- So now, when we implement a function that takes 
-- a name and a number 
-- and sees if that name and number combination is in our phonebook,
-- we can give it a very pretty and descriptive type declaration.

inPhoneBook :: Name -> PhoneNumber -> PhoneBook -> Bool  
inPhoneBook name pnumber pbook = (name,pnumber) `elem` pbook  

-- If we decided not to use type synonyms, 
-- our function would have a type of 
-- String -> String -> [(String,String)] -> Bool.
-- In this case, the type declaration 
-- that took advantage of type synonyms is easier to understand.
-- However, you shouldn't go overboard with them.
-- We introduce type synonyms either to 
-- describe what some existing type represents in our functions 
-- (and thus our type declarations become better documentation) 
-- or when something has a long-ish type that is repeated a lot 
-- (like [(String,String)]) 
-- but represents something more specific in the context of our functions.


-- Type synonyms can also be parameterized.
-- If we want a type that represents an association list type 
-- but still want it to be general 
-- so it can use any type as the keys and values,
-- we can do this:

type AssocList k v = [(k,v)] 

-- Now, a function that gets the value by a key in an association list 
-- can have a type of (Eq k) => k -> AssocList k v -> Maybe v.
-- AssocList is a type constructor that takes two types 
-- and produces a concrete type, 
-- like AssocList Int String, for instance.

-- Fonzie says: Aaay! When I talk about concrete types 
-- I mean like fully applied types like Map Int String or 
-- if we're dealin' with one of them polymorphic functions,
-- [a] or (Ord a) => Maybe a and stuff.
-- And like, sometimes me and the boys say that Maybe is a type,
-- but we don't mean that, 
-- cause every idiot knows Maybe is a type constructor.
-- When I apply an extra type to Maybe, like Maybe String, 
-- then I have a concrete type. 
-- You know, values can only have types that are concrete types! 
-- So in conclusion, live fast, love hard and don't let anybody else use your comb!

-- Just like we can partially apply functions to get new functions, 
-- we can partially apply type parameters 
-- and get new type constructors from them.
-- Just like we call a function with too few parameters to get back a new function, 
-- we can specify a type constructor with too few type parameters 
-- and get back a partially applied type constructor.
-- If we wanted a type that represents a map (from Data.Map) 
-- from integers to something, we could either do this:

type IntMap v = Map Int v  

-- Or we could do it like this:

type IntMap = Map Int  

-- Either way, the IntMap type constructor takes one parameter and that is the type of what the integers will point to.

-- Oh yeah. If you're going to try and implement this, 
-- you'll probably going to do a qualified import of Data.Map. 
-- When you do a qualified import,
-- type constructors also have to be preceeded with a module name.
-- So you'd write type IntMap = Map.Map Int.

-- Make sure that you really understand the distinction between 
-- type constructors and value constructors.
-- Just because we made a type synonym called IntMap or AssocList 
-- doesn't mean that we can do stuff like AssocList [(1,2),(4,5),(7,9)].
-- All it means is that we can refer to its type by using different names. 
-- We can do [(1,2),(3,5),(8,9)] :: AssocList Int Int, 
-- which will make the numbers inside assume a type of Int, 
-- but we can still use that list as we would any normal list 
-- that has pairs of integers inside.
-- Type synonyms (and types generally) 
-- can only be used in the type portion of Haskell.
-- We're in Haskell's type portion whenever we're defining new types 
-- (so in data and type declarations) 
-- or when we're located after a ::. 
-- The :: is in type declarations or in type annotations.


-- Another cool data type that takes two types as its parameters is 
-- the Either a b type. 
-- This is roughly how it's defined:

data Either a b = Left a | Right b deriving (Eq, Ord, Read, Show) 

-- It has two value constructors.
-- If the Left is used, then its contents are of type a 
-- and if Right is used, then its contents are of type b. 
-- So we can use this type to encapsulate a value of one type or another 
-- and then when we get a value of type Either a b, 
-- we usually pattern match on both Left and Right 
-- and we different stuff based on which one of them it was.

ghci> Right 20  
-- Right 20  
ghci> Left "w00t"  
-- Left "w00t"  
ghci> :t Right 'a'  
-- Right 'a' :: Either a Char  
ghci> :t Left True  
-- Left True :: Either Bool b

-- So far, we've seen that Maybe a was mostly used to represent 
-- the results of computations that could have either failed or not.
-- But somtimes, Maybe a isn't good enough 
-- because Nothing doesn't really convey much information 
-- other than that something has failed.
-- That's cool for functions that can fail in only one way 
-- or if we're just not interested in how and why they failed. 
-- A Data.Map lookup fails only if the key we were looking for wasn't in the map, 
-- so we know exactly what happened.
-- However, when we're interested in how some function failed or why, 
-- we usually use the result type of Either a b, 
-- where a is some sort of type that can tell us something about 
-- the possible failure 
-- and b is the type of a successful computation.
-- Hence, errors use the Left value constructor while results use Right.

-- An example: a high-school has lockers so that 
-- students have some place to put their Guns'n'Roses posters. 
-- Each locker has a code combination. 
-- When a student wants a new locker, 
-- they tell the locker supervisor which locker number they want 
-- and he gives them the code.
-- However, if someone is already using that locker,
-- he can't tell them the code for the locker 
-- and they have to pick a different one. 
-- We'll use a map from Data.Map to represent the lockers. 
-- It'll map from locker numbers 
-- to a pair of whether the locker is in use or not and the locker code.

import qualified Data.Map as Map  
  
data LockerState = Taken | Free deriving (Show, Eq)  
  
type Code = String  
  
type LockerMap = Map.Map Int (LockerState, Code)  

-- Simple stuff. 
-- We introduce a new data type to represent 
-- whether a locker is taken or free 
-- and we make a type synonym for the locker code. 
-- We also make a type synonym for 
-- the type that maps from integers to pairs of locker state and code.
-- And now, we're going to make a function that searches for the code 
-- in a locker map.
-- We're going to use an Either String Code type to represent our result,
-- because our lookup can fail in two ways — 
-- the locker can be taken, 
-- in which case we can't tell the code 
-- or the locker number might not exist at all.
-- If the lookup fails, 
-- we're just going to use a String to tell what's happened.

lockerLookup :: Int -> LockerMap -> Either String Code  
lockerLookup lockerNumber map =   
    case Map.lookup lockerNumber map of   
        Nothing -> Left $ "Locker number " ++ show lockerNumber ++ " doesn't exist!"  
        Just (state, code) -> if state /= Taken   
                                then Right code  
                                else Left $ "Locker " ++ show lockerNumber ++ " is already taken!"  

-- We do a normal lookup in the map.
-- If we get a Nothing, we return a value of type Left String,
-- saying that the locker doesn't exist at all.
-- If we do find it,
-- then we do an additional check to see if the locker is taken.
-- If it is,
-- return a Left saying that it's already taken.
-- If it isn't, then return a value of type Right Code,
-- in which we give the student the correct code for the locker.
-- It's actually a Right String,
-- but we introduced that type synonym to introduce 
-- some additional documentation into the type declaration.
-- Here's an example map:

lockers :: LockerMap  
lockers = Map.fromList   
    [(100,(Taken,"ZD39I"))  
    ,(101,(Free,"JAH3I"))  
    ,(103,(Free,"IQSA9"))  
    ,(105,(Free,"QOTSA"))  
    ,(109,(Taken,"893JJ"))  
    ,(110,(Taken,"99292"))  
    ]  

-- Now let's try looking up some locker codes.

ghci> lockerLookup 101 lockers  
-- Right "JAH3I"  
ghci> lockerLookup 100 lockers  
-- Left "Locker 100 is already taken!"  
ghci> lockerLookup 102 lockers  
-- Left "Locker number 102 doesn't exist!"  
ghci> lockerLookup 110 lockers  
-- Left "Locker 110 is already taken!"  
ghci> lockerLookup 105 lockers  
-- Right "QOTSA"  

-- We could have used a Maybe a to represent the result but then we wouldn't know why we couldn't get the code. But now, we have information about the failure in our result type.

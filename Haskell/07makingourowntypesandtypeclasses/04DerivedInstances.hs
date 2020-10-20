 -- In the Typeclasses 101 section, we explained the basics of typeclasses.
 -- We explained that a typeclass is a sort of an interface 
 -- that defines some behavior.
 -- A type can be made an instance of a typeclass 
 -- if it supports that behavior.
 -- Example: the Int type is an instance of the Eq typeclass 
 -- because the Eq typeclass defines behavior for stuff that can be equated.
 -- And because integers can be equated, 
 -- Int is a part of the Eq typeclass.
 -- The real usefulness comes with 
 -- the functions that act as the interface for Eq, 
 -- namely == and /=. 
 -- If a type is a part of the Eq typeclass,
 -- we can use the == functions with values of that type.
 -- That's why expressions like 4 == 4 and "foo" /= "bar" typecheck.

-- We also mentioned that they're often confused with classes 
-- in languages like Java, Python, C++ and the like, 
-- which then baffles a lot of people.
-- In those languages, classes are a blueprint from which 
-- we then create objects that contain state and can do some actions.
-- Typeclasses are more like interfaces.
-- We don't make data from typeclasses.
-- Instead, we first make our data type 
-- and then we think about what it can act like.
-- If it can act like something that can be equated,
-- we make it an instance of the Eq typeclass.
-- If it can act like something that can be ordered,
-- we make it an instance of the Ord typeclass.

-- In the next section, we'll take a look at 
-- how we can manually make our types instances of typeclasses 
-- by implementing the functions defined by the typeclasses.
-- But right now, let's see how Haskell can automatically make our type 
-- an instance of any of the following typeclasses: 
-- Eq, Ord, Enum, Bounded, Show, Read.
-- Haskell can derive the behavior of our types in these contexts 
-- if we use the deriving keyword when making our data type.

-- Consider this data type:

data Person = Person { firstName :: String  
                     , lastName :: String  
                     , age :: Int  
                     }  
-- It describes a person.
-- Let's assume that no two people have the same combination of 
-- first name, last name and age.
-- Now, if we have records for two people, 
-- does it make sense to see if they represent the same person? 
-- Sure it does. 
-- We can try to equate them and see if they're equal or not.
-- That's why it would make sense for this type 
-- to be part of the Eq typeclass.
-- We'll derive the instance.

data Person = Person { firstName :: String  
                     , lastName :: String  
                     , age :: Int  
                     } deriving (Eq) 

-- When we derive the Eq instance for a type 
-- and then try to compare two values of that type with == or /=, 
-- Haskell will see if the value constructors match 
-- (there's only one value constructor here though) 
-- and then it will check if all the data contained inside matches 
-- by testing each pair of fields with ==. 
-- There's only one catch though, 
-- the types of all the fields also have to be part of the Eq typeclass.
-- But since both String and Int are, we're OK.
-- Let's test our Eq instance.

ghci> let mikeD = Person {firstName = "Michael", lastName = "Diamond", age = 43}  
ghci> let adRock = Person {firstName = "Adam", lastName = "Horovitz", age = 41}  
ghci> let mca = Person {firstName = "Adam", lastName = "Yauch", age = 44}  
ghci> mca == adRock  
-- False  
ghci> mikeD == adRock  
-- False  
ghci> mikeD == mikeD  
-- True  
ghci> mikeD == Person {firstName = "Michael", lastName = "Diamond", age = 43}  
-- True  

-- Of course, since Person is now in Eq, 
-- we can use it as the a for all functions 
-- that have a class constraint of Eq a in their type signature, such as elem.

ghci> let beastieBoys = [mca, adRock, mikeD]  
ghci> mikeD `elem` beastieBoys  
-- True  

-- The Show and Read typeclasses are for things 
-- that can be converted to or from strings, respectively.
-- Like with Eq, if a type's constructors have fields, 
-- their type has to be a part of Show or Read 
-- if we want to make our type an instance of them.
-- Let's make our Person data type a part of Show and Read as well.

data Person = Person { firstName :: String  
                     , lastName :: String  
                     , age :: Int  
                     } deriving (Eq, Show, Read)  

-- Now we can print a person out to the terminal.

ghci> let mikeD = Person {firstName = "Michael", lastName = "Diamond", age = 43}  
ghci> mikeD  
-- Person {firstName = "Michael", lastName = "Diamond", age = 43}  
ghci> "mikeD is: " ++ show mikeD  
-- "mikeD is: Person {firstName = \"Michael\", lastName = \"Diamond\", age = 43}" 

-- Had we tried to print a person on the terminal 
-- before making the Person data type part of Show,
-- Haskell would have complained at us,
-- claiming it doesn't know how to represent a person as a string.
-- But now that we've derived a Show instance for it, it does know.

-- Read is pretty much the inverse typeclass of Show.
-- Show is for converting values of our a type to a string,
-- Read is for converting strings to values of our type.
-- Remember though, when we use the read function,
-- we have to use an explicit type annotation to tell Haskell 
-- which type we want to get as a result.
-- If we don't make the type we want as a result explicit,
-- Haskell doesn't know which type we want.

ghci> read "Person {firstName =\"Michael\", lastName =\"Diamond\", age = 43}" :: Person  
-- Person {firstName = "Michael", lastName = "Diamond", age = 43}  

-- If we use the result of our read later on in a way that Haskell can infer that it should read it as a person, we don't have to use type annotation.

ghci> read "Person {firstName =\"Michael\", lastName =\"Diamond\", age = 43}" == mikeD  
-- True  

-- We can also read parameterized types,
-- but we have to fill in the type parameters.
-- So we can't do read "Just 't'" :: Maybe a,
-- but we can do read "Just 't'" :: Maybe Char.

-- We can derive instances for the Ord type class,
-- which is for types that have values that can be ordered.
-- If we compare two values of the same type 
-- that were made using different constructors,
-- the value which was made with a constructor 
-- that is defined first is considered smaller.
-- For instance, consider the Bool type, 
-- which can have a value of either False or True.
-- For the purpose of seeing how it behaves when compared,
-- we can think of it as being implemented like this:

data Bool = False | True deriving (Ord)  

-- Because the False value constructor is specified first 
-- and the True value constructor is specified after it,
-- we can consider True as greater than False.

ghci> True `compare` False  
-- GT  
ghci> True > False  
-- True  
ghci> True < False  
-- False 

-- In the Maybe a data type, 
-- the Nothing value constructor is specified before the Just value constructor, 
-- so a value of Nothing is always smaller than a value of Just something, 
-- even if that something is minus one billion trillion.
-- But if we compare two Just values,
-- then it goes to compare what's inside them.

ghci> Nothing < Just 100  
-- True  
ghci> Nothing > Just (-49999)  
-- False  
ghci> Just 3 `compare` Just 2  
-- GT  
ghci> Just 100 > Just 50  
-- True  

-- But we can't do something like Just (*3) > Just (*2),
-- because (*3) and (*2) are functions,
-- which aren't instances of Ord.

-- We can easily use algebraic data types to make enumerations 
-- and the Enum and Bounded typeclasses help us with that. 
-- Consider the following data type:

data Day = Monday | Tuesday | Wednesday | Thursday | Friday | Saturday | Sunday  

-- Because all the value constructors are nullary 
-- (take no parameters, i.e. fields), 
-- we can make it part of the Enum typeclass.
-- The Enum typeclass is for things that have predecessors and successors. 
-- We can also make it part of the Bounded typeclass, 
-- which is for things that have a lowest possible value 
-- and highest possible value.
-- And while we're at it, 
-- let's also make it an instance of all the other derivable typeclasses 
-- and see what we can do with it.

data Day = Monday | Tuesday | Wednesday | Thursday | Friday | Saturday | Sunday   
           deriving (Eq, Ord, Show, Read, Bounded, Enum)  

-- Because it's part of the Show and Read typeclasses, we can convert values of this type to and from strings.

ghci> Wednesday  
-- Wednesday  
ghci> show Wednesday  
-- "Wednesday"  
ghci> read "Saturday" :: Day  
-- Saturday  

-- Because it's part of the Eq and Ord typeclasses,
-- we can compare or equate days.

ghci> Saturday == Sunday  
-- False  
ghci> Saturday == Saturday  
-- True  
ghci> Saturday > Friday  
-- True  
ghci> Monday `compare` Wednesday  
-- LT  

-- It's also part of Bounded, so we can get the lowest and highest day.

ghci> minBound :: Day  
-- Monday  
ghci> maxBound :: Day  
-- Sunday  

-- It's also an instance of Enum.
-- We can get predecessors and successors of days and 
-- we can make list ranges from them!

ghci> succ Monday  
-- Tuesday  
ghci> pred Saturday  
-- Friday  
ghci> [Thursday .. Sunday]  
-- [Thursday,Friday,Saturday,Sunday]  
ghci> [minBound .. maxBound] :: [Day]  
-- [Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday]  

-- That's pretty awesome.

-- A value constructor can take some values parameters and 
-- then produce a new value.
-- For instance, the Car constructor takes three values and produces a car value.
-- In a similar manner,
-- type constructors can take types as parameters to produce new types.
-- This might sound a bit too meta at first,
-- but it's not that complicated.
-- If you're familiar with templates in C++, you'll see some parallels.
-- To get a clear picture of what type parameters work like in action,
-- let's take a look at how a type we've already met is implemented.

data Maybe a = Nothing | Just a  

-- The a here is the type parameter.
-- And because there's a type parameter involved,
-- we call Maybe a type constructor.
-- Depending on what we want this data type to hold when it's not Nothing,
-- this type constructor can end up producing a type of 
-- Maybe Int, Maybe Car, Maybe String, etc.
-- No value can have a type of just Maybe,
-- because that's not a type per se, it's a type constructor.
-- In order for this to be a real type that a value can be part of,
-- it has to have all its type parameters filled up.

-- So if we pass Char as the type parameter to Maybe,
-- we get a type of Maybe Char.
-- The value Just 'a' has a type of Maybe Char, for example.

-- You might not know it,
-- but we used a type that has a type parameter before we used Maybe.
-- That type is the list type.
-- Although there's some syntactic sugar in play,
-- the list type takes a parameter to produce a concrete type.
-- Values can have an [Int] type, a [Char] type, a [[String]] type,
-- but you can't have a value that just has a type of [].

-- Let's play around with the Maybe type.

ghci> Just "Haha"  
Just "Haha"  
ghci> Just 84  
Just 84  
ghci> :t Just "Haha"  
Just "Haha" :: Maybe [Char]  
ghci> :t Just 84  
Just 84 :: (Num t) => Maybe t  
ghci> :t Nothing  
Nothing :: Maybe a  
ghci> Just 10 :: Maybe Double  
Just 10.0  

-- Type parameters are useful because 
-- we can make different types with them depending on 
-- what kind of types we want contained in our data type.
-- When we do :t Just "Haha", 
-- the type inference engine figures it out to be of the type Maybe [Char],
-- because if the a in the Just a is a string,
-- then the a in Maybe a must also be a string.

-- Notice that the type of Nothing is Maybe a.
-- Its type is polymorphic.
-- If some function requires a Maybe Int as a parameter,
-- we can give it a Nothing,
-- because a Nothing doesn't contain a value anyway and so it doesn't matter.
-- The Maybe a type can act like a Maybe Int if it has to,
-- just like 5 can act like an Int or a Double.
-- Similarly, the type of the empty list is [a].
-- An empty list can act like a list of anything.
-- That's why we can do [1,2,3] ++ [] and ["ha","ha","ha"] ++ [].

-- Using type parameters is very beneficial,
-- but only when using them makes sense.
-- Usually we use them when our data type would work 
-- regardless of the type of the value it then holds inside it,
-- like with our Maybe a type.
-- If our type acts as some kind of box,
-- it's good to use them.
-- We could change our Car data type from this:

data Car = Car { company :: String  
               , model :: String  
               , year :: Int  
               } deriving (Show)  
To this:

data Car a b c = Car { company :: a  
                     , model :: b  
                     , year :: c   
                     } deriving (Show)  

-- But would we really benefit? The answer is: probably no,
-- because we'd just end up defining functions that only work on
-- the Car String String Int type.
-- For instance, given our first definition of Car,
-- we could make a function that displays the car's properties in a nice little text.

tellCar :: Car -> String  
tellCar (Car {company = c, model = m, year = y}) = 
    "This " ++ c ++ " " ++ m ++ " was made in " ++ show y  
ghci> let stang = Car {company="Ford", model="Mustang", year=1967}  
ghci> tellCar stang  
-- "This Ford Mustang was made in 1967"  

-- A cute little function! 
-- The type declaration is cute and it works nicely.
-- Now what if Car was Car a b c?

tellCar :: (Show a) => Car String String a -> String  
tellCar (Car {company = c, model = m, year = y}) = "This " ++ c ++ " " ++ m ++ " was made in " ++ show y  

-- We'd have to force this function to 
-- take a Car type of (Show a) => Car String String a.
-- You can see that the type signature is more complicated 
-- and the only benefit we'd actually get would be that 
-- we can use any type that's an instance of the Show typeclass as the type for c.

ghci> tellCar (Car "Ford" "Mustang" 1967)  
-- "This Ford Mustang was made in 1967"  
ghci> tellCar (Car "Ford" "Mustang" "nineteen sixty seven")  
-- "This Ford Mustang was made in \"nineteen sixty seven\""  
ghci> :t Car "Ford" "Mustang" 1967  
-- Car "Ford" "Mustang" 1967 :: (Num t) => Car [Char] [Char] t  
ghci> :t Car "Ford" "Mustang" "nineteen sixty seven"  
-- Car "Ford" "Mustang" "nineteen sixty seven" :: Car [Char] [Char] [Char]  

-- In real life though,
-- we'd end up using Car String String Int most of the time 
-- and so it would seem that parameterizing the Car type isn't really worth it.
-- We usually use type parameters when the type that is contained inside 
-- the data type's various value constructors isn't really that important 
-- for the type to work.
-- A list of stuff is a list of stuff 
-- and it doesn't matter what the type of that stuff is, 
-- it can still work.
-- If we want to sum a list of numbers,
-- we can specify later in the summing function that 
-- we specifically want a list of numbers.
-- Same goes for Maybe.
-- Maybe represents an option of either having nothing or 
-- having one of something.
-- It doesn't matter what the type of that something is.

-- Another example of a parameterized type that we've already met is 
-- Map k v from Data.Map.
-- The k is the type of the keys in a map and the v is the type of the values.
-- This is a good example of where type parameters are very useful.
-- Having maps parameterized enables us to have mappings 
-- from any type to any other type,
-- as long as the type of the key is part of the Ord typeclass.
-- If we were defining a mapping type,
-- we could add a typeclass constraint in the data declaration:

data (Ord k) => Map k v = ...  

-- However, it's a very strong convention in Haskell to 
-- never add typeclass constraints in data declarations.
-- Why? Well, because we don't benefit a lot,
-- but we end up writing more class constraints,
-- even when we don't need them.
-- If we put or don't put the Ord k constraint in the data declaration 
-- for Map k v, we're going to have to put the constraint into functions 
-- that assume the keys in a map can be ordered.
-- But if we don't put the constraint in the data declaration,
-- we don't have to put (Ord k) => in the type declarations of functions 
-- that don't care whether the keys can be ordered or not.
-- An example of such a function is toList,
-- that just takes a mapping and converts it to an associative list. 
-- Its type signature is toList :: Map k a -> [(k, a)]. 
-- If Map k v had a type constraint in its data declaration,
-- the type for toList would have to be toList :: (Ord k) => Map k a -> [(k, a)], 
-- even though the function doesn't do any comparing of keys by order.

-- So don't put type constraints into data declarations 
-- even if it seems to make sense,
-- because you'll have to put them into the function type declarations either way.

-- Let's implement a 3D vector type and add some operations for it.
-- We'll be using a parameterized type because 
-- even though it will usually contain numeric types,
-- it will still support several of them.

data Vector a = Vector a a a deriving (Show)  
  
vplus :: (Num t) => Vector t -> Vector t -> Vector t  
(Vector i j k) `vplus` (Vector l m n) = Vector (i+l) (j+m) (k+n)  
  
vectMult :: (Num t) => Vector t -> t -> Vector t  
(Vector i j k) `vectMult` m = Vector (i*m) (j*m) (k*m)  
  
scalarMult :: (Num t) => Vector t -> Vector t -> t  
(Vector i j k) `scalarMult` (Vector l m n) = i*l + j*m + k*n  

-- vplus is for adding two vectors together.
-- Two vectors are added just by adding their corresponding components.
-- scalarMult is for the scalar product of two vectors and 
-- vectMult is for multiplying a vector with a scalar.
-- These functions can operate on types of 
-- Vector Int, Vector Integer, Vector Float, whatever, 
-- as long as the a from Vector a is from the Num typeclass.
-- Also, if you examine the type declaration for these functions,
-- you'll see that they can operate only on vectors of the same type 
-- and the numbers involved must also be of the type 
-- that is contained in the vectors.
-- Notice that we didn't put a Num class constraint in the data declaration, 
-- because we'd have to repeat it in the functions anyway.

-- Once again, it's very important to distinguish between the type constructor 
-- and the value constructor.
-- When declaring a data type,
-- the part before the = is the type constructor and 
-- the constructors after it (possibly separated by |'s) are value constructors.
-- Giving a function a type of Vector t t t -> Vector t t t -> t would be wrong,
-- because we have to put types in type declaration and 
-- the vector type constructor takes only one parameter,
-- whereas the value constructor takes three.
-- Let's play around with our vectors.

ghci> Vector 3 5 8 `vplus` Vector 9 2 8  
-- Vector 12 7 16  
ghci> Vector 3 5 8 `vplus` Vector 9 2 8 `vplus` Vector 0 2 3  
-- Vector 12 9 19  
ghci> Vector 3 9 7 `vectMult` 10  
-- Vector 30 90 70  
ghci> Vector 4 9 5 `scalarMult` Vector 9.0 2.0 4.0  
-- 74.0  
ghci> Vector 2 9 3 `vectMult` (Vector 4 9 5 `scalarMult` Vector 9 2 4)  
-- Vector 148 666 222  


-----------------------------------------------------------------------------------------
-- Types classes

{- |
  A typeclass is a sort of interface that defines some behaviour.
  If a type is a part of a typeclass, 
    it means that it supports and implements the behaviour the typeclass describes.
  These are not like classes in OOP languages.
  Think of them as Java interfaces, only better.

  (Note:
  If a function is comprised only of special characters, it is considered to be an infix function by default.
  If we want to examine its type, pass it to another function or call it as a prefix function, we have to surround it in paranthesis.)

  What is the type signature of the `==` function?
  Prelude> :t (==)
  (==) :: Eq a => a -> a -> Bool
  Prelude> :t (+)
  (+) :: Num a => a -> a -> a

  
  Everything before the `=>` is called a class constraint.
  Read it like this:
  The equality function takes any two values that are of the same type and returns a Bool.
  The type of those two values must be a member of the `Eq` class (this was the class constraint).

  The `Eq` typeclass provides an interface for testing for equality.
      Any type where it makes sense to test for equality between two values of that type should be a member of the `Eq` class.
      All standard Haskell types (except for IO) and functions are a part of the `Eq` typeclass.

      Prelude> :t elem
      elem :: (Foldable t, Eq a) => a -> t a -> Bool

      If there is an `Eq` class constraint for a type variable in a function, 
        it uses `==` or `/=` somewhere inside its definition.

      Prelude> :t (>)
      (>) :: Ord a => a -> a -> Bool

  `Ord` typeclass is for types that have an ordering.
      The compare function takes two `Ord` members of the same type and returns an ordering.
      Ordering is a type tht can be GT, LT or EQ.

      Prelude> "Abrakadabra" < "Zebra"
      True

      Prelude> "Abrakadabra" `compare` "Zebra"
      LT

      Prelude> 5 >= 2
      True

      Prelude> 5 `compare` 3
      GT

  `Show` is for types that can be presented as string.
      The function `show` uses the typeclass 'Show'.
      It takes a value whose type is a member of `Show` and presents it to us as a string.

      Prelude> :t show
      show :: Show a => a -> String

      Prelude> show 3
      "3"
      it :: String

      Prelude> show 5.334
      "5.334"
      it :: String

      Prelude> show True
      "True"
      it :: String

  `Read` is sort of the opposite typeclass os `Show`.
      The function 'read' takes a string and returns a type which is a member of `Read`.

      Prelude> read "True" || False
      True
      it :: Bool

      Prelude> read "8.2" + 3.8
      12.0
      it :: (Read a, Fractional a) => a

      Prelude> read "5" - 2
      3
      it :: (Num a, Read a) => a

      Prelude> read "[1,2,3,4]" ++ [3]
      [1,2,3,4,3]
      it :: (Read a, Num a) => [a]

      Prelude> read "4" will throw an exception because 
        we are not telling GHCI what to do with the result of `read`.
      So it cannot infer what kind of result we want out of the `read`.
      If we use it as a boolean, it knows that it had to be a `Bool`.
      But the command above tells it that we want some type that is part of the `Read` class,
        it just does not know which one.

      Prelude> :t read
      read :: Read a => String -> a

      `read` returns a type that is part of `Read` but 
        if we do not try to use it in some way later,
        it has no way of knowing which type.
      This is why we can use explicit type annotations.
      Type annotations are a way of explicitly saying what the type of an expression should be.
      We do that by adding `::` at the end of the expression and then specifying a type.

      Prelude> read "4" :: Int
      4
      it :: Int

      Prelude> read "4" :: Float
      4.0
      it :: Float

      Prelude> (read "4" :: Float) * 5
      20.0
      it :: Float

      Prelude> read "[1,2,3,4]" :: [Int]
      [1,2,3,4]
      it :: [Int]

      Prelude> read "(3, 'a')" :: (Int, Char)
      (3,'a')
      it :: (Int, Char)

      Most expressions are such that the compiler can infer what their type is by itself.
      But sometimes, the compiler does not know whether to return 
        a value of type `Int` or `Float` for an expression like `read "5"`
      To see what the type is, Haskell would have to evaluate `read "5"`
      But since Haskell is a statically typed language, 
        it has to know all the types before the code is compiled 
        (or in the case of GHCI, evaluated).
      So we have to tell Haskell, "this expression should have this type"

  `Enum` members are sequentially ordered types.
      Prelude> ['a'..'e']
      "abcde"
      it :: [Char]

      Prelude> [LT .. GT]
      [LT,EQ,GT]
      it :: [Ordering]

      Prelude> [3 .. 5]
      [3,4,5]
      it :: (Num a, Enum a) => [a]

      Prelude> succ 'B'
      'C'
      it :: Char

  `Bounded` members have an upper and a lower bound.
      Prelude> minBound :: Int
      -9223372036854775808
      it :: Int

      Prelude> maxBound :: Char
      '\1114111'
      it :: Char

      Prelude> maxBound :: Bool
      True
      it :: Bool

      Prelude> minBound :: Bool
      False
      it :: Bool

      Prelude> :t minBound
      minBound :: Bounded a => a

      Prelude> :t maxBound
      maxBound :: Bounded a => a

      minBound and maxBound are polymorphic constants.

      All tuples are also part of `Bounded` if the components are also in it.
      Prelude> maxBound :: (Bool, Int, Char)
      (True,9223372036854775807,'\1114111')
      it :: (Bool, Int, Char) 

  `Num` is a numeric typeclass.
      Prelude> :t 20
      20 :: Num p => p

      Whole numbers are also polymorphic constants.
      Prelude> 20 :: Int
      20
      it :: Int

      Prelude> 20 :: Integer
      20
      it :: Integer

      Prelude> 20 :: Float
      20.0
      it :: Float

      Prelude> 20 :: Double
      20.0
      it :: Double
 
      Prelude> :t (*)
      (*) :: Num a => a -> a -> a

      (5 :: Int) * (6 :: Integer) will result in a type error.
      5 * (6 :: Integer) will work just fine.

  `Integral` is also a numeric typeclass.
      `Num` includes all numbers, including real numbers and integral numbers.
      `Integral` only integral (whole) numbers - Int and Integer.

  `Floating` includes only floating point numbers.
      `Float` and `Double`

  A very useful function when dealing with numbers is `fromIntegral`.
    Prelude> :t fromIntegral
    fromIntegral :: (Integral a, Num b) => a -> b

    This is useful when you want integral and floating point types to work together nicely.
    e.g.
    Prelude> :t length
    length :: Foldable t => t a -> Int
    (instead of giving us a `Num`)
    
    Prelude> length [1,2,3] + 3.2
    <interactive>:209:18: error:
        • No instance for (Fractional Int) arising from the literal ‘3.2’
        • In the second argument of ‘(+)’, namely ‘3.2’
          In the expression: length [1, 2, 3] + 3.2
          In an equation for ‘it’: it = length [1, 2, 3] + 3.2
    
    Prelude> fromIntegral (length [1,2,3]) + 3.2
    6.2
    it :: Fractional a => a

    Notice that fromIntegral has several class constraints in its type signature.
    The class constraints are separated by commas inside parantheses.


-}


-----------------------------------------------------------------------------------------
-- Types and Typeclasses

{- |
 Haskell has a static type system.
 The type of every expression is known at compile time, which leads to safer code.
 Everything in Haskell has a type, so the compiler can reason quite a lot about your program before compiling it.

 Unlike Java or Pascal, Haskell has type inference. 
 If we write a number, we don't have to tell Haskell it's a number. 
 It can infer that on its own, 
  so we don't have to explicitly write out the types of our 
  functions and expressions to get things done.

 Understanding the type system is a very important part of learning Haskell.

 A type is a kind of label that every expression has.
 It tells us in which category of things that expression fits.
 e.g. true is boolean. "hello" is string.

 How to use GHCI to examine the types of some expressions?
 We do that by using the :t command which, 
  followed by any valid expression, tells us its type.
 ghci> :t 'a'  
 'a' :: Char
 ghci> :t True  
 True :: Bool
 ghci> :t "HELLO!"  
 "hello" :: [Char]
 ghci> :t ['a','b']
 ['a','b'] :: [Char]
 ghci> :t (True, 'a')  
 (True, 'a') :: (Bool, Char)
 ghci> :t 4 == 5  
 4 == 5 :: Bool
 ghci> :t [1,2,3]
 [1,2,3] :: Num a => [a]
 ghci> :t [1.2,3.4]
 [1.2,3.4] :: Fractional a => [a]

 :: is read as "has type of". 
 Explicit types are always denoted with the first letter in capital case.
 
 Unlike lists, each tuple length has its own type. 
 So the expression of (True, 'a') has a type of (Bool, Char), 
 whereas an expression such as ('a','b','c') would have the type of (Char, Char, Char).
-}

{- |
 ghci has a command, :set, that lets us change a few of its default behaviours. 
 We can tell it to print more type information as follows
 :set +t
 ghci> "foo"
 "foo"
 it :: [Char]

 The `it` variable is a handy ghci shortcut. It lets us use the result of the expression we just evaluated in a new expression.
 
 ghci> it ++ "bar"
 "foobar"
 it :: [Char]

 When evaluating an expression, ghci won't change the value of it if the evaluation fails. 
 This lets you write potentially bogus expressions with something of a safety net.

 ghci> it
 "foobar"
 it :: [Char]
 ghci> it ++ 3
 
 <interactive>:1:6:
     No instance for (Num [Char])
       arising from the literal `3' at <interactive>:1:6
     Possible fix: add an instance declaration for (Num [Char])
     In the second argument of `(++)', namely `3'
     In the expression: it ++ 3
     In the definition of `it': it = it ++ 3
 ghci> it
 "foobar"
 it :: [Char]
 ghci> it ++ "baz"
 "foobarbaz"
 it :: [Char]
 
 When we couple it with liberal use of the arrow keys to recall and 
  edit the last expression we typed, 
  we gain a decent way to experiment interactively: the cost of mistakes is very low.
-}

{- |
Functions also have types.
When writing our own functions, we can choose to give them an explicit type declaration.
This is generally considered to be good practice except when writing very short functions.
-}

-- The parameters are separated with ->
-- And there is no separate distinction between the parameters and the return type.
-- The return type is the last item in the declaration and the parameters are the first three.
addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

testAddThree_01 = addThree 2 5 7

-- This is not going to work.
-- testAddThree_02 = addThree 2.1 5.2 7.3

{- |
  If you want to give your function a type declaration but you are unsure as to what it should be,
  you can always just write the function without it and 
  then check it with `:t`.
  Functions are expressions too, so `:t` works on them without a problem.
-}

-----------------------------------------------------------------------------------------
-- Types variables

{- |
  What is the type of the head function?
  head takes a list of any type and returns the first element of the list.

  Prelude> :t head
  head :: [a] -> a

  Types are written in capital case. So `a` can't exactly be a type.
  It is a type variable.
  It means, a can be of any type.
  It is much like generics in other languages.
  It allows us to easily write very general functions if 
    they don't use any specific behaviour of the types in them.
  Functions that have type variables are called polymorphic functions.
  The type declaration of head states that it takes a list of any type and returns one element of that type.

  Prelude> :t fst
  fst :: (a, b) -> a
-}

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

-----------------------------------------------------------------------------------------
-- Types

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


-- Function Types
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


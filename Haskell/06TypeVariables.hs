
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


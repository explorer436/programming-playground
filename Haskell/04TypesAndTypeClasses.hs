-- Types and Typeclasses
{- |
 Haskell has a static type system. The type of every expression is known at compile time, which leads to safer code.
 Unlike Java or Pascal, Haskell has type inference. 
 If we write a number, we don't have to tell Haskell it's a number. 
 It can infer that on its own, so we don't have to explicitly write out the types of our functions and expressions to get things done.
-}

{- |
 Using GHCI to examine the types of some expressions. 
 We'll do that by using the :t command which, followed by any valid expression, tells us its type.
 ghci> :t 'a'  
 ghci> :t True  
 ghci> :t "HELLO!"  
 ghci> :t (True, 'a')  
 ghci> :t 4 == 5  
-}

{- |
 :: is read as "has type of". 
 Explicit types are always denoted with the first letter in capital case.
 Unlike lists, each tuple length has its own type. So the expression of (True, 'a') has a type of (Bool, Char), 
 whereas an expression such as ('a','b','c') would have the type of (Char, Char, Char).
-}

{- |
 ghci has a command, :set, that lets us change a few of its default behaviours. 
 We can tell it to print more type information as follows
 :set +t
-}

{- |
 That it variable is a handy ghci shortcut. It lets us use the result of the expression we just evaluated in a new expression.
 ghci> "foo"
 "foo"
 it :: [Char]
 ghci> it ++ "bar"
 "foobar"
 it :: [Char]
-}


{- |
 When evaluating an expression, ghci won't change the value of it if the evaluation fails. 
 This lets you write potentially bogus expressions with something of a safety net.
-}

{- |
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
 
 When we couple it with liberal use of the arrow keys to recall and edit the last expression we typed, 
 we gain a decent way to experiment interactively: the cost of mistakes is very low.
-}


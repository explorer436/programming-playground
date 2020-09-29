
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

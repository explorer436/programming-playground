{- |
    Functions 
    
    A function is a relation between one type and another type, and they’re used in expressions with values. 
    In Haskell a function is itself a value. 
    If you provide a function with an input value, (by applying the function to the value), it will return (give you back) the corresponding output value of the output type when it’s evaluated.
    
    Be careful how you think about this! Function means something different in Haskell than in most other programming languages. Functions in Haskell are not sets of steps for the computer to follow.
-}

main = putStrLn "Polly wants a cracker"

-- If you were to run this first program, it will put "Polly wants a cracker" on to the screen.


{- |
  
    main = putStrLn "Polly wants a cracker"

    |______________________________________| -> definition

    |__| -> term

           |_______| -> a function

                    |_____________________| -> a String 

           |______________________________| -> expression
  
-}



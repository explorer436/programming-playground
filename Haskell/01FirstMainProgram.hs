{- |
  To run this, load this file into ghci and call `main`
-}

helloString :: String
helloString = "Hello world!"

main :: IO ()
main = putStrLn helloString

----------------------------------------------------------------

If you were to run this first program, it will put "Polly wants a cracker" on to the screen.


{- |
  
    main = putStrLn "Polly wants a cracker"

    |______________________________________| -> definition

    |__| -> term

           |_______| -> a function

                    |_____________________| -> a String 

           |______________________________| -> expression
  
-}



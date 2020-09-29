{- |
  To run this, load this file into ghci and call `main`
-}

helloString :: String
helloString = "Hello world!"

main :: IO ()
main = putStrLn helloString

----------------------------------------------------------------


{- |
  
    main = putStrLn "Polly wants a cracker"

    |______________________________________| -> definition

    |__| -> term

           |_______| -> a function

                    |_____________________| -> a String 

           |______________________________| -> expression
  
-}

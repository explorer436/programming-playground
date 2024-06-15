{- |
  To run this, load this file into ghci and call `main`

  Getting help : Enter :? at the ghci prompt

  To exit or quit out of ghci : Ctrl D

  Open terminal and type ghci to launch ghci to go into GHCI!
  The prompt here is Prelude> and that will work for minor functions.
  If you want to write your functions in a file, write them in a file called 'baby.hs'.
  To load this file into ghci, type `:l baby`
  If you change the .hs script, just run `:l baby` again or do `:r`, 
  which is equivalent because it reloads the current script.
  To unload this file from ghci, type `:m` (short for module).
  This will take you back to Prelude> 
-}

helloString :: String
helloString = "Hello world!"

main :: IO ()
main = putStrLn helloString

-- After loading the file into ghci, just call the name of the method (and pass in arguments if necessary).
-- > helloworld

-- What is the type signature of a function? Just ask ghci
-- > :t largestDivisible

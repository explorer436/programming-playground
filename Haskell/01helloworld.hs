-- lines beginning with "--" are comments.

-- Getting help : Enter :? at the ghci prompt

-- exit or quit out of ghci : Ctrl D

{- |
  Open terminal and type ghci to launch ghci to go into GHCI!
  The prompt here is Prelude> and that will work for minor functions.
  If you want to write your functions in a file, write them in a file called 'baby.hs'.
  To load this file into ghci, type `:l baby`
  If you change the .hs script, just run `:l baby` again or do `:r`, 
  which is equivalent because it reloads the current script.
  To unload this file from ghci, type `:m` (short for module).
  This will take you back to Prelude> 
-}

helloworld = "hello" ++ " " ++ "world!"

-- After loading the file into ghci, just call the name of the method (and pass in arguments if necessary).
-- helloworld
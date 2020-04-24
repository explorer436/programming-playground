--  Open terminal and type ghci to launch ghci to go into GHCI!
--  The prompt here is Prelude> and that will work for minor functions.
--  If you want to write your functions in a file, write them in a file called 'baby.hs'.
--  To load this file into ghci, type `:l baby`
--  If you change the .hs script, just run :l myfunctions again or do :r, which is equivalent because it reloads the current script.
--  To unload this file from ghci, type `:m` (short for module)

square x = x * x

doubleMe x = x + x

--  doubleUs x y = x*2 + y*2
doubleUs x y = doubleMe x + doubleMe y

doubleSmallNumber x = if x > 10
then x
else x*2

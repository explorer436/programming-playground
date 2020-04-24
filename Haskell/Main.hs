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

l1 = [1,2,3,4]
l2 = [9,10,11,12]
puttingTwoListsTogether l1 l2 = l1 ++ l2

printHelloWorld = "hello" ++ " " ++ "world!"

printWoot = ['w','o'] ++ ['o','t']

-- When you put together two lists (even if you append a singleton list to a list, for instance: [1,2,3] ++ [4]), 
-- internally, Haskell has to walk through the whole list on the left side of ++. 
-- That's not a problem when dealing with lists that aren't too big. 
-- But putting something at the end of a list that's fifty million entries long is going to take a while. 
-- However, putting something at the beginning of a list using the : operator (also called the cons operator) is instantaneous. 

consOperatorFirstSample = 'A':" small cat"
consOperatorSecondSample = 5:[1,2,3,4,5]

-- The difference between ++ and the cons operator is, ++ operates on lists and cons operator operates on a single number (or character) and a list of numbers (or characters).

getElementOutOfAListByIndex = "Steve Buschmi" !! 6

-- Fridge - The Game

-- This is one of the simplest horror games ever. The original idea was by Peter Halasz of http://becauseofgames.com who created it in the programming language C when he was learning how to program.

-- We’re going to use this little game to learn how to get some input from the user, to sequence chunks of IO code together, and also to see a way to make a program continue until the user wants to stop.

main :: IO ()
main = do
  putStrLn "You are in a fridge. What do you want to do?"
  putStrLn "1. Try to get out."
  putStrLn "2. Eat."
  putStrLn "3. Die."
  command <- getLine
  case command of
    "1" ->
        putStrLn "You try to get out. You fail. You die."
    "2" ->
        do
          putStrLn "You eat. You eat some more."
          putStrLn "Damn, this food is tasty!"
          putStrLn "You eat so much you die."
    "3" ->
        putStrLn "You die."
    _   ->
        putStrLn "Did not understand."
  putStrLn "Play again? write y if you do."
  playAgain <- getLine
  if playAgain == "y"
  then main
  else putStrLn "Thanks for playing."

-- Do Block Nesting
-- Notice, also, that you can put do blocks within do blocks. This is called nesting. We’re doing this by having another do block in the “2” branch of the case expression.

-- Whole-Program Recursion
-- This game has two sections. 
-- First it tells the user their options and asks for their input with getLine, and then depending on what they wrote, it tells them what happened. 
-- Next, it asks if they want to play again, and if they do, it runs the whole thing again by calling main. 
-- This is recursion of the whole program. 
-- The program is an IO action, and do blocks allow us to compose IO actions, so it’s perfectly fine to have the whole program at the end recursively.

-- One last thing to note about do blocks, though, is that they must always end with the same type as the whole do block. 
-- So, because ours ends with an if expression whose resultant type is IO (), which is the type of the main function itself, it will work just fine. 

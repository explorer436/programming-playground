Fridge - The Game

This is one of the simplest horror games ever. The original idea was by Peter Halasz of http://becauseofgames.com who created it in the programming language C when he was learning how to program.

We’re going to use this little game to learn how to get some input from the user, to sequence chunks of IO code together, and also to see a way to make a program continue until the user wants to stop.

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


Do Blocks with IO

Firstly, all of the actions in an IO do block are executed in the order they’re written. That is, they’re sequenced together. Secondly, using “<-”, you can connect an inner value from an IO action on its right to a variable on its left. It’s worth noting that you can only use this <- syntax within a do block, though.

You’ll also notice that we have a case expression. We can use any Haskell expressions we like in a do block as long as they result in an action of the same type as the do block’s type.

Anyway, let’s see these things in action with two tiny example programs, one for do blocks combining and sequencing IO actions, and one for gathering input from the user.


main :: IO ()
main =
  do
    putStrLn "Hello"
    putStrLn "There"

Ok, so this program will first print Hello on the screen, then it will print There on the next line. The do block takes one or more actions, and packs them into a single action. The type of that do block above is IO (), just like main, and in IO, these actions will be sequenced one after the other as we’ve written them down the page.

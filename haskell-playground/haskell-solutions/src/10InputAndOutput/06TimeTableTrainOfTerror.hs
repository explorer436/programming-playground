-- a game Level is simply a pair
-- of Integer values
type Level = (Integer, Integer)

levels :: [Level]
levels =
    concat $ map pairsForNum [3,5..12]
  where
    pairsForNum num = zip [2..12] $ repeat num


pairsForNum num = zip [2..12] $ repeat num

-- Main> zip [2..12] $ repeat [3,5..12]
-- [(2,[3,5,7,9,11]),(3,[3,5,7,9,11]),(4,[3,5,7,9,11]),(5,[3,5,7,9,11]),(6,[3,5,7,9,11]),(7,[3,5,7,9,11]),(8,[3,5,7,9,11]),(9,[3,5,7,9,11]),(10,[3,5,7,9,11]),(11,[3,5,7,9,11]),(12,[3,5,7,9,11])]

-- Main> pairsForNum [3,5..12]
-- [(2,[3,5,7,9,11]),(3,[3,5,7,9,11]),(4,[3,5,7,9,11]),(5,[3,5,7,9,11]),(6,[3,5,7,9,11]),(7,[3,5,7,9,11]),(8,[3,5,7,9,11]),(9,[3,5,7,9,11]),(10,[3,5,7,9,11]),(11,[3,5,7,9,11]),(12,[3,5,7,9,11])]

-- Main> map pairsForNum [3,5..12]
-- [[(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,3)],
--  [(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),(9,5),(10,5),(11,5),(12,5)],
--  [(2,7),(3,7),(4,7),(5,7),(6,7),(7,7),(8,7),(9,7),(10,7),(11,7),(12,7)],
--  [(2,9),(3,9),(4,9),(5,9),(6,9),(7,9),(8,9),(9,9),(10,9),(11,9),(12,9)],
--  [(2,11),(3,11),(4,11),(5,11),(6,11),(7,11),(8,11),(9,11),(10,11),(11,11),(12,11)]]


-- Main> levels
-- [(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,3),
--  (2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),(9,5),(10,5),(11,5),(12,5),
--  (2,7),(3,7),(4,7),(5,7),(6,7),(7,7),(8,7),(9,7),(10,7),(11,7),(12,7),
--  (2,9),(3,9),(4,9),(5,9),(6,9),(7,9),(8,9),(9,9),(10,9),(11,9),(12,9),
--  (2,11),(3,11),(4,11),(5,11),(6,11),(7,11),(8,11),(9,11),(10,11),(11,11),(12,11)]

-- Determining the Level Number
-- Here’s a function we’ll use in our program to work out what number level the player is at:

levelNumber :: [a] -> Int
levelNumber remainingLevels =
    totalLevels - levelsLeft
  where totalLevels = length levels + 1
        levelsLeft  = length remainingLevels

-- We take a list of remaining levels, then subtract the number of levels left (using the length function) from the number of levels we started with plus one. 
-- As the player “moves up” the train, we’ll be reducing the size of the list, so the remaining levels will get less, and the level number will go up. 
-- Notice from the type signature that we don’t care what the element type of the list passed into it is, as long as it’s a list.

main :: IO ()
main = do
  putStrLn "Suddenly, you wake up. Oh no, you're on..."
  putStrLn "The Times-Table Train of Terror!"
  putStrLn "Try to get to the end. We DARE you!"
  trainLoop levels

-- Each time the player gets done with a level, we remove it from the list, then pass the rest of the levels back into the trainLoop function and start it again.
trainLoop :: [Level] -> IO ()
trainLoop [] =
  putStrLn "You won! Well done."
trainLoop remainingLevels @ (currentLevel : levelsAfterThisOne) =
  do
    let currentLevelNumber =
            levelNumber remainingLevels
        (num1, num2) =
            currentLevel
    putStrLn $
      "You are in a Train Carriage "
      ++ show currentLevelNumber
      ++ " of " ++ (show $ length levels)
    putStrLn "Do you want to:"
    putStrLn "1. Go to the next Carriage"
    putStrLn "2. Jump out of the train"
    putStrLn "3. Eat some food"
    putStrLn "q. Quit"
    activity <- getLine
    case activity of
      "1" ->
        do
          putStrLn $ "You try to go to the next carriage."
                   ++ " The door is locked."
          putStrLn "Answer this question to unlock the door:"
          putStrLn $ "What is " ++ show num1
                    ++ " times " ++ show num2 ++ "?"
          answer <- getLine
          if answer == (show $ num1 * num2)
          then do
            putStrLn "The lock is opened!"
            trainLoop levelsAfterThisOne
          else do
            putStrLn $ "Wrong. You try to open the lock,"
                     ++ " but it won't open."
            trainLoop remainingLevels
      "2" -> jumpingFutility
      "3" -> eatingFutility
      "q" -> putStrLn $ "You decide to quit."
                      ++ " Thanks for playing. Bah-Bye!"
      _   -> do
        putStrLn "That makes NO sense! Try again."
        trainLoop remainingLevels

jumpingFutility :: IO ()
jumpingFutility = do
  putStrLn "You try to jump out of the train."
  putStrLn "You fail and die."
  trainLoop levels

eatingFutility :: IO ()
eatingFutility = do
  putStrLn "You see a delicious looking cupcake."
  putStrLn "You eat it. It's a time travel cupcake!"
  trainLoop levels

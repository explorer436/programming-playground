import qualified Data.List as L

-- We’ll see a game that lets us imagine that we’re a squirrel and we live in a tree. 
-- Our new game will only have two areas, but it will provide more capability than before. 

-- To keep it ultra-simple, let’s say we (our squirrel) could be able to go between only the inside and outside of the tree, perhaps. 
-- The program we’ll be discovering in this section is a lot more complicated than the Fridge game, but it’s about one of the most simple, basic text adventures possible.

-- A GameObject type whose values can be either Player or Acorn. A sum type.
-- deriving (Eq, Show) - this is a way to make a type become an instance of the typeclasses Eq and Show without having to write the code for it manually ourselves. 
-- Being an instance of Eq means we can use (==) and other comparison functions on values of this type, and being an instance of Show means it can be converted to strings with the show function.
data GameObject = Player | Acorn deriving (Eq, Show)

-- The Room type is a product type and it has a type constructor called Room as well as a value constructor of the same name, which is used to make values of the Room type. 
-- It has fields of Description, and a list of type GameObject which is used to hold the contents of the Room. 
-- So, because of the way the GameObject type is defined, a Room can have one or more Player or Acorn values in it. 
-- Our game will only ever have one of each in the whole game.
data Room = Room Description [GameObject] deriving (Show)

-- Type synonyms
type Description = String
type Inventory = [GameObject]
type GameMap = [Room]
type GameState = (GameMap, Inventory)

-- The GameState type will be what we use to store all the changing pieces of our game as the player plays it. 
-- The GameMap will be all the rooms in the game, and the Inventory is what the player is holding moment by moment.

initialState :: GameState
initialState =
  ( [ Room "You are inside a tree." [Player]
    , Room "You are outside of a tree." [Acorn]]
  , [] )

main :: IO ()
main = do
  putStrLn "Welcome to Skwak the Squirrel."
  putStrLn "You are a squirrel."
  gameLoop initialState

gameLoop :: GameState -> IO ()
gameLoop (rooms, currentInv) = do
  let currentRoom =
        case findRoomWithPlayer rooms of
        Just r -> r
        Nothing -> error $ "Somehow the player "
                         ++ "ended up outside the map!"
      possibleCmds =
        validCommands currentRoom currentInv
  if playerWon (rooms, currentInv)
  then gameOverRestart
  else do
    describeWorld currentRoom currentInv possibleCmds
    takeActionThenLoop
      currentRoom currentInv possibleCmds rooms

findRoomWithPlayer :: [Room] -> Maybe Room
findRoomWithPlayer rooms =
  L.find (\(Room _ obs) -> any (== Player) obs) rooms

takeActionThenLoop :: Room ->
                      Inventory ->
                      [String] ->
                      [Room] ->
                      IO ()
takeActionThenLoop currentRoom
                   currentInv
                   possibleCmds
                   rooms =
  do
    command <- getCommand
    if any (==command) possibleCmds
    then case command of
      "go" ->
          do
            putStrLn "You go..."
            gameLoop $ movePlayer (rooms, currentInv)
      "take" ->
          do
            putStrLn "You take the acorn..."
            gameLoop $
              moveAcornToInventory (rooms, currentInv)
      "put" ->
          do
            putStrLn "You put the acorn down..."
            gameLoop $
              moveAcornFromInventory (rooms, currentInv)
      "quit" ->
          putStrLn $ "You decide to give up."
                   ++ " Thanks for playing."
      _ ->
          do
            putStrLn "That is not a command."
            gameLoop (rooms, currentInv)
    else do
      putStrLn $ "Command not possible here,"
               ++ " or that is not a command."
      gameLoop (rooms, currentInv)

movePlayer :: GameState -> GameState
movePlayer (rooms, inv) =
    (newRooms, inv)
  where
    newRooms =
      map adjustRooms rooms
    adjustRooms (Room d objs) =
      if any (==Player) objs
      then (Room d (filter (/=Player) objs))
      else (Room d (Player : objs))

moveAcornToInventory :: GameState -> GameState
moveAcornToInventory (rooms, inv) =
    (newRooms, newInv)
  where
    newInv =
      Acorn : inv
    newRooms =
      map adjustRooms rooms
    adjustRooms (Room d objs) =
      Room d (filter (/=Acorn) objs)

moveAcornFromInventory :: GameState -> GameState
moveAcornFromInventory (rooms, inv) =
    (newRooms, newInv)
  where
    newInv =
      filter (/=Acorn) inv
    newRooms =
      map adjustRooms rooms
    adjustRooms (Room d objs) =
      if any (==Player) objs
      then Room d (Acorn : objs)
      else Room d objs

getCommand :: IO String
getCommand = do
  putStrLn "What do you want to do?"
  getLine

describeWorld :: Room ->
                 Inventory ->
                 [String] ->
                 IO ()
describeWorld currentRoom
              currentInv
              possibleCmds =
  do
    putStrLn $ describeRoom currentRoom
    putStrLn $ describeInventory currentInv
    putStrLn $ describeCommands possibleCmds

describeRoom :: Room -> String
describeRoom (Room desc objs) =
  desc ++ if any (==Acorn) objs
          then " There is an acorn here"
          else ""

describeInventory :: Inventory -> String
describeInventory [] =
  "You are holding nothing"
describeInventory inv =
  "You are holding: " ++
  (concat $ map show inv)

describeCommands :: [String] -> String
describeCommands commands =
  "Commands: "
  ++ (L.intercalate ", " commands)

gameOverRestart :: IO ()
gameOverRestart = do
  putStrLn $ "You won!"
    ++ "You have successfully stored the acorn"
    ++ " for winter. Well done!"
  putStrLn "Do you want to play again? y = yes"
  playAgain <- getLine
  if playAgain == "y"
  then gameLoop initialState
  else putStrLn "Thanks for playing!"

playerWon :: GameState -> Bool
playerWon (rooms, currentInv) =
    any hasAcornAndInside rooms
  where hasAcornAndInside (Room desc objs) =
          desc == "You are inside a tree."
          && any (==Acorn) objs

validCommands :: Room -> Inventory -> [String]
validCommands (Room _ gameObjs) invItems =
    ["go"] ++ takeCommandList
    ++ dropCommandList ++ ["quit"]
  where
    takeCommandList =
      if somethingToTake gameObjs
      then ["take"]
      else []
    dropCommandList =
      if length invItems > 0
      then ["put"]
      else []

somethingToTake :: [GameObject] -> Bool
somethingToTake objs =
  any (/= Player) objs

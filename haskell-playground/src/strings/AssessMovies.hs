import qualified Data.List as L

-- Let’s say we have a movie collection, and for some reason, 
-- we're only interested in movies whose first letter is in the first half of the alphabet ('a'..'z'). 
-- In our program, we'll call those good movies, and the others bad.

movies =
  [ "Aeon Flux"
  , "The Black Cat"
  , "Superman"
  , "Stick It"
  , "The Matrix Revolutions"
  , "The Raven"
  , "Inception"
  , "Looper"
  , "Hoodwinked"
  , "Tell-Tale"
  ]

-- We'd like to be able to make a new list of our movies 
-- with “good” or “bad” appended to the name so we know which we can watch.

isGood :: String -> Bool
isGood (x:_) = x <= 'M'
isGood _     = False

assess :: String -> String
assess movie = movie ++ " - " ++ assessment
  where assessment = if isGood movie
                     then "Good"
                     else "Bad"

assessMovies :: [String] -> [String]
assessMovies = map assess

assessedMovies :: [String]
assessedMovies = assessMovies movies
-- ["Aeon Flux - Good","The Black Cat - Bad","Superman - Bad","Stick It - Bad","The Matrix Revolutions - Bad","The Raven - Bad","Inception - Good","Looper - Good","Hoodwinked - Good","Tell-Tale - Bad"]

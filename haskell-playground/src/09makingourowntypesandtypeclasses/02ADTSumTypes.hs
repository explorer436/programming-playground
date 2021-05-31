-- In the example, we’ll introduce you to an awesome feature of Haskell: 
-- the ability to make your own data types, and values of those types.

-- To do this, we’ll use the data keyword which creates a new data type, 
-- and specifies all the values it can possibly be. 

-- Sum Types
-- Another name for these kinds of types is a sum type, 
-- because the values of the type “summed together” make up the whole type.

data Animal = Giraffe
            | Elephant
            | Tiger
            | Flea
            deriving (Show)

-- We’re saying that we want Haskell to make a new type, named Animal. 
-- We’re also saying that the data for the Animal type can be any one of Giraffe, Elephant, Tiger or Flea, but nothing else. 
-- These values are also called value constructors, even though they’re each only able to construct the value that they are.


-- Let’s see the type for Zoo next:
type Zoo = [Animal]


-- Pretty simple. A Zoo is an Animal list. 
-- You might recognise this is just a type synonym, for our convenience and documentation. 
-- Next we’ll see a definition for a Zoo:
localZoo :: Zoo
localZoo = [ Elephant
           , Tiger
           , Tiger
           , Giraffe
           , Elephant
           ]

-- Ok, the Zoo named localZoo has some Animal values in it. 
-- Let’s put all of this together and 
-- create a function that uses a case expression to give some advice when a particular animal escapes.

-- Pattern Matching with Sum Types
adviceOnEscape :: Animal -> String
adviceOnEscape animal =
  case animal of
    Giraffe   -> "Look up"
    Elephant  -> "Ear to the ground"
    Tiger     -> "Check the morgues"
    Flea      -> "Don't worry"
-- There is no default case, usually marked with an underscore, 
-- because we know this function is total already, 
-- because it has one item for each of the possible data values of the Animal type, 
-- so there’s nothing left to catch for a default case.

adviceOnLocalZooEscapeForEachAnimal :: Zoo -> [String]
adviceOnLocalZooEscapeForEachAnimal xs = map adviceOnEscape xs

joinWithCommaBetweenTwoElements :: Animal -> [Char] -> [Char]
joinWithCommaBetweenTwoElements a b = (show a) ++ ", " ++ b 

adviceForLocalZooForAllAnimals = zipWith joinWithCommaBetweenTwoElements localZoo (adviceOnLocalZooEscapeForEachAnimal localZoo)
-- ["Elephant, Ear to the ground","Tiger, Check the morgues","Tiger, Check the morgues","Giraffe, Look up","Elephant, Ear to the ground"]

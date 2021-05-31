import qualified Data.List as L

-- A street has ten houses on it. 
-- Each house has a cat of a different breed living in it. 
-- Write a program that finds the oldest of the cats on the street and 
-- prints out where they live, along with their age in equivalent human years.

-- a sum type for cat breed.
data CatBreed =
    Siamese | Persian | Bengal | Sphynx
  | Burmese | Birman | RussianBlue
  | NorwegianForest | CornishRex | MaineCoon

-- Next, we’ll see a data type for Cat.

type Name = String
type Age = Integer
data Cat = Cat Name CatBreed Age

-- This is a new kind of data type called a product type. 
-- This lets us make values that combine more than one type. 
-- When we saw tuples, you may remember we said that there are better ways to combine multiple values into one value. 
-- Well, this is that better way. 
-- A Cat can have an Age, and a Name, and a breed (CatBreed).

-- This tells Haskell that Cat is a new type for data, and that it has only one value constructor.

-- Our code also tells Haskell that Cat is the name of the value constructor, 
-- as well as the name of the type. 
-- So how does Haskell know when we’re talking about the type, 
-- and when we’re talking about the value? 
-- Well, by looking at the places we’re using it, it can use inference to work it out.

-- Notice the Cat type is defined as one single Cat data constructor, 
-- which has variable “slots” for the name, breed and age. 
-- This actually tells Haskell to make the value constructor 
-- function Cat :: Name -> CatBreed -> Age -> Cat and 
-- this can be used to make Cat values 
-- (which is why it’s called a data constructor), 
-- as well as pattern match for these values.

-- a product type for house
type HouseNumber = Int
data House = House HouseNumber Cat

-- a function to work out how old a cat is in human years:
-- this is a commonly agreed upon way to work out cat ages
humanAge :: Cat -> Age
humanAge (Cat _ _ catAge)
  | catAge <= 0 = 0
  | catAge == 1 = 15
  | catAge == 2 = 25
  | otherwise   = 25 + (catAge - 2) * 4

-- Notice that the first argument to humanAge is a Cat, a single value of the Cat type, but it’s being kind of “pulled apart” by the pattern match using the value constructor. 
-- This takes the first two fields of the Cat data type and ignores them (by matching them to “_” which as you might know by now, basically throws them away), and then binds a variable name to the age of the Cat called catAge, so the rest of the function can compare and do math with it.

-- some data for street
-- So, street is a value whose type is [House].
--  The type of House says it has a single data constructor, 
--  also called House which takes two fields (House :: HouseNumber -> Cat -> House) and returns a House value. 
--  Each of these houses has an embedded Cat value in it constructed with the Cat data constructor 
--  which is building a Cat out of a Name, its CatBreed, and its Age.
street :: [House]
street =
  [ House 1 (Cat "George" Siamese 10)
  , House 2 (Cat "Mr Bigglesworth" Persian 5)
  , House 3 (Cat "Mr Tinkles" Birman 1)
  , House 4 (Cat "Puddy" Burmese 3)
  , House 5 (Cat "Tiger" Bengal 7)
  , House 6 (Cat "The Ninja" RussianBlue 12)
  , House 7 (Cat "Mr Tinklestein" NorwegianForest 8)
  , House 8 (Cat "Plain Cat" MaineCoon 9)
  , House 9 (Cat "Shnooby" Sphynx 7)
  , House 10 (Cat "Crazy Ears Sam" CornishRex 3)
  ]

getCatFromHouse :: House -> Cat
getCatFromHouse (House _ c) = c

getHumanAgeOfCatFromHouse :: House -> Age
getHumanAgeOfCatFromHouse =
  humanAge . getCatFromHouse

findOldestCat :: [House] -> Maybe Cat
findOldestCat []     = Nothing
findOldestCat houses = Just oldestCat
  where
    oldestCat = getCatFromHouse houseWithOldestCat
    houseWithOldestCat = head housesSortedByCatAge
    housesSortedByCatAge = L.sortBy catAgeComparer houses
    catAgeComparer (House _ (Cat _ _ age1))
                   (House _ (Cat _ _ age2))
      = compare age2 age1

findOldestCatHouse :: [House] -> Maybe House
findOldestCatHouse houses =
    if length housesSortedByCatAge > 0
    then Just (head housesSortedByCatAge)
    else Nothing
  where housesSortedByCatAge
          = L.sortBy catAgeComparer houses
        catAgeComparer (House _ (Cat _ _ age1))
                       (House _ (Cat _ _ age2))
          = compare age2 age1

-- catAgeComparer is a function that takes two houses and compares the ages of the cats contained within. 
-- It does this by pattern matching the ages out of the cats, and the cats out of each house all at once (its type is House -> House -> Ordering).

-- An Ordering is a built-in sum data type which has values of LT, EQ and GT which stand for less than, equal to and greater than respectively. Ordering values are used by sorting functions in Haskell.

-- The sortBy :: (a -> a -> Ordering) -> [a] -> [a] function from Data.List takes a function whose type is (a -> a -> Ordering) to sort its second argument: a list. That fits the type of catAgeComparer, which is why we’re using sortBy in our definition of housesSortedByCatAge in the line above that. Put another way, the sortBy function takes a comparing function (that is, one that returns an Ordering), and a list, and returns that list sorted by using the comparing function on adjacent elements.

-- Because we want to sort oldest to youngest, our application of the compare function in catAgeComparer has age2 first. If age1 was first, it’d sort youngest to oldest.

-- It is only safe to use the head function when we can be absolutely sure there is at least one item in the list we’re applying it to. 
-- Otherwise it will cause your program to crash (crashing is a term that means the program unexpectedly stopped working). 
-- We are sure that there is at least one item in the list we’re applying head to because we have a clause that matches on the empty list and returns Nothing.

getCatName :: Cat -> String
getCatName (Cat name _ _) = name

getHouseNumber :: House -> String
getHouseNumber (House number _) = show number

oldest =
      case findOldestCatHouse street of
        Nothing ->
          "There is no oldest cat!"
        Just house ->
          "The oldest cat is "
          ++ getCatName (getCatFromHouse house)
          ++ ", is "
          ++ show (getHumanAgeOfCatFromHouse house)
          ++ " equivalent human years old"
          ++ " and it lives in Number "
          ++ getHouseNumber house
-- "The oldest cat is The Ninja, is 65 equivalent human years old and it lives in Number 6"

main :: IO ()
main = putStrLn oldest
-- The oldest cat is The Ninja, is 65 equivalent human years old and it lives in Number 6

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

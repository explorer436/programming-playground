type Name = String
type Year = Int
data Person = Person
    { personFirstName :: Name
    , personLastName :: Name
    , yearOfBirth :: Year }
  deriving (Show)

blaise :: Person
blaise =
  Person { personFirstName = "Blaise"
         , personLastName = "Pascal"
         , yearOfBirth = 1623 }
-- *Main> blaise 
-- Person {personFirstName = "Blaise", personLastName = "Pascal", yearOfBirth = 1623}         

-- This is called record update syntax. 
traise :: Person
traise = blaise { personFirstName = "Traise" }

-- *Main> traise 
-- Person {personFirstName = "Traise", personLastName = "Pascal", yearOfBirth = 1623}

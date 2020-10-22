-- OK, we've been tasked with creating a data type that describes a person. 
-- The info that we want to store about that person is: 
-- first name, last name, age, height, phone number, and favorite ice-cream flavor. 
-- I don't know about you, but that's all I ever want to know about a person. 
-- Let's give it a go!

data Person = Person String String Int Float String String deriving (Show)

-- Okay. 
-- The first field is the first name, the second is the last name, 
-- the third is the age and so on. 
-- Let's make a person.

ghci> let guy = Person "Buddy" "Finklestein" 43 184.2 "526-2928" "Chocolate"  
ghci> guy  
Person "Buddy" "Finklestein" 43 184.2 "526-2928" "Chocolate"  

-- That's kind of cool, although slightly unreadable. 
-- What if we want to create a function to get seperate info from a person? 
-- A function that gets some person's first name, 
-- a function that gets some person's last name, etc. 
-- Well, we'd have to define them kind of like this.

firstName :: Person -> String  
firstName (Person firstname _ _ _ _ _) = firstname  
  
lastName :: Person -> String  
lastName (Person _ lastname _ _ _ _) = lastname  
  
age :: Person -> Int  
age (Person _ _ age _ _ _) = age  
  
height :: Person -> Float  
height (Person _ _ _ height _ _) = height  
  
phoneNumber :: Person -> String  
phoneNumber (Person _ _ _ _ number _) = number  
  
flavor :: Person -> String  
flavor (Person _ _ _ _ _ flavor) = flavor  

-- Whew! I certainly did not enjoy writing that! 
-- Despite being very cumbersome and BORING to write, this method works.

ghci> let guy = Person "Buddy" "Finklestein" 43 184.2 "526-2928" "Chocolate"  
ghci> firstName guy  
"Buddy"  
ghci> height guy  
184.2  
ghci> flavor guy  
"Chocolate"  
-- There must be a better way, you say! Well no, there isn't, sorry.

-- Just kidding, there is. Hahaha! 
-- The makers of Haskell were very smart and anticipated this scenario.
-- They included an alternative way to write data types.
-- Here's how we could achieve the above functionality with record syntax.

data Person = Person { firstName :: String  
                     , lastName :: String  
                     , age :: Int  
                     , height :: Float  
                     , phoneNumber :: String  
                     , flavor :: String  
                     } deriving (Show)   

-- So instead of just naming the field types one after another and 
-- separating them with spaces, we use curly brackets. 
-- First we write the name of the field, for instance, 
-- firstName and then we write a double colon :: 
-- (also called Paamayim Nekudotayim, haha) and 
-- then we specify the type. 
-- The resulting data type is exactly the same. 
-- The main benefit of this is that it creates functions 
-- that lookup fields in the data type. 
-- By using record syntax to create this data type, 
-- Haskell automatically made these functions: 
-- firstName, lastName, age, height, phoneNumber and flavor.                     

ghci> :t flavor  
flavor :: Person -> String  
ghci> :t firstName  
firstName :: Person -> String  

-- There's another benefit to using record syntax. 
-- When we derive Show for the type, it displays it differently 
-- if we use record syntax to define and instantiate the type. 
-- Say we have a type that represents a car. 
-- We want to keep track of the company that made it, 
-- the model name and its year of production. Watch.

data Car = Car String String Int deriving (Show)  
ghci> Car "Ford" "Mustang" 1967  
Car "Ford" "Mustang" 1967  
-- If we define it using record syntax, 
-- we can make a new car like this.

data Car = Car {company :: String, model :: String, year :: Int} deriving (Show)  
ghci> Car {company="Ford", model="Mustang", year=1967}  
Car {company = "Ford", model = "Mustang", year = 1967}  

-- When making a new car, 
-- we don't have to necessarily put the fields in the proper order, 
-- as long as we list all of them. 
-- But if we don't use record syntax, we have to specify them in order.

-- Use record syntax when a constructor has several fields and 
-- it is not obvious which field is which. 
-- If we make a 3D vector data type by doing data 
-- Vector = Vector Int Int Int, it's pretty obvious that 
-- the fields are the components of a vector. 
-- However, in our Person and Car types, 
-- it wasn't so obvious and we greatly benefited from using record syntax.

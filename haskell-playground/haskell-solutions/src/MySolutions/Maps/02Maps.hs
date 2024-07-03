import qualified Data.Map as Map

-- Maps operate similarly in concept to association lists. 
-- The Data.Map module provides functions for adding and removing data from maps. 
-- It also lets us filter them, modify them, fold over them, and convert to and from association lists. 
-- The library documentation for this module is good, so instead of going into detail on each function, we will present an example that ties together many of the concepts we've discussed in this chapter.

-- Functions Are Data, Too

-- Part of Haskell's power is the ease with which it lets us create and manipulate functions. 
-- Let's take a look at a record that stores a function as one of its fields.


{- | Our usual CustomColor type to play with -}
data CustomColor = CustomColor {red :: Int, green :: Int, blue :: Int} deriving (Eq, Show, Read)


{- | A new type that stores a name and a function.

The function takes an Int, applies some computation to it, and returns an Int along with a CustomColor -}
data FuncRec = FuncRec {name :: String, colorCalc :: Int -> (CustomColor, Int)}
-- Notice the type of the colorCalc field: it's a function. It takes an Int and returns a tuple of (CustomColor, Int).
-- FuncRec itself has no field to store the color in, yet that value somehow becomes part of the function itself. 
-- This is called a closure.

plus5func :: Num b => a -> b -> (a, b)
plus5func color x = (color, x + 5)

purple :: CustomColor
purple = CustomColor 255 0 255


-- We create two FuncRec records: purplePlus5 and purpleAlways0. 
-- Notice that the colorCalc for both of them will always return the color purple.

purplePlus5 :: FuncRec
purplePlus5 = FuncRec {name = "purplePlus5", colorCalc = plus5func purple}

purpleAlways0 :: FuncRec
purpleAlways0 = FuncRec {name = "purpleAlways0", colorCalc = \_ -> (purple, 0)}


-- :t purplePlus5
-- purplePlus5 :: FuncRec

testName = name purplePlus5
-- "purplePlus5"

-- :t colorCalc purplePlus5
-- colorCalc purplePlus5 :: Int -> (CustomColor, Int)

testPurplePlus5 = colorCalc purplePlus5 7
-- (CustomColor {red = 255, green = 0, blue = 255},12)

-- :t colorCalc purpleAlways0
-- colorCalc purpleAlways0 :: Int -> (CustomColor, Int)

testPurpleAlways0 = colorCalc purpleAlways0 7
-- (CustomColor {red = 255, green = 0, blue = 255},0)
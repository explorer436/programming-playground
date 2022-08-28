import qualified Data.Map as Map

-- You might wonder how to do something more advanced, such as making a piece of data available in multiple places. 
-- A type construction function can be helpful. 
-- Here's an example.

data FuncRec = FuncRec {name :: String, calc :: Int -> Int, namedCalc :: Int -> (String, Int)}

mkFuncRec :: String -> (Int -> Int) -> FuncRec
mkFuncRec name calcfunc = FuncRec {name = name, calc = calcfunc, namedCalc = \x -> (name, calcfunc x)}

plus5 :: FuncRec
plus5 = mkFuncRec "plus5" (+ 5)

always0 :: FuncRec
always0 = mkFuncRec "always0" (\_ -> 0)

-- Here we have a function called mkFuncRec that takes a String and another function as parameters, and returns a new FuncRec record. 

-- Notice how both parameters to mkFuncRec are used in multiple places. 

-- :t plus5
-- plus5 :: FuncRec


-- :t name
-- name :: FuncRec -> String


-- :t calc 
-- calc :: FuncRec -> Int -> Int


-- :t namedCalc 
-- namedCalc :: FuncRec -> Int -> (String, Int)


testName = name plus5
-- "plus5"


testPlus5 = calc plus5 5
-- 10


testPlus5NamedCalc = namedCalc plus5 5
-- ("plus5",10)


plus5a = plus5 {name = "PLUS5A"}


testPlus5aName = name plus5a
-- "PLUS5A"


testPlus5aNamedCalc01 :: (String, Int)
testPlus5aNamedCalc01 = namedCalc plus5a 5
-- ("plus5",10)

testPlus5aNamedCalc02 :: (String, Int)
testPlus5aNamedCalc02 = namedCalc (mkFuncRec "plus5a" (+ 5)) 6
-- ("plus5a",11)


-- Notice the creation of plus5a. 
-- We changed the name field, but not the namedCalc field. 
-- That's why name has the new name, but namedCalc still returns the name that was passed to mkFuncRec; 
-- it doesn't change unless we explicitly change it.
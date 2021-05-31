-----------------------------------------------------------------------
-- WHERE

-- REMEMBER : in the pipe conditions, all the `equal to` symbols should be in a straigh line.
-- If not, the compiler will throw an error.

{- |
 In the previous implementation for `calculateBmiFromHeightAndWeightAndCommentOnIt`, 
     we repeat ourselves three times. 
 Since we repeat the same expression three times, 
     it would be ideal if we could calculate it once, 
     bind it to a name and then use that name instead of the expression. 
 Well, we can modify our function like this:
-}


calculateBmiOnlyOnceFromHeightAndWeightAndCommentOnIt :: (RealFloat a) => a -> a -> String  
calculateBmiOnlyOnceFromHeightAndWeightAndCommentOnIt weight height  
    | bmi <= 18.5 = "You're underweight!"  
    | bmi <= 25.0 = "You're supposedly normal!"  
    | bmi <= 30.0 = "You're fat! Lose some weight!"  
    | otherwise   = "You're a whale, congratulations!"  
    where bmi = weight / height ^ 2
-- tests
calculateBmiOnlyOnceFromHeightAndWeightAndCommentOnItTest1 = calculateBmiOnlyOnceFromHeightAndWeightAndCommentOnIt 85 1.90  


{- | 
We put the keyword where after the guards 
    (usually it's best to indent it as much as the pipes are indented) 
    and then we define several names or functions. 
These names are visible across the guards and 
    give us the advantage of not having to repeat ourselves. 
If we decide that we want to calculate BMI a bit differently, 
    we only have to change it once. 
It also improves readability by giving names to things and 
    can make our programs faster since stuff like our bmi variable here is calculated only once. 
We could go a bit overboard and present our function like this:
-}

bmiTell :: (RealFloat a) => a -> a -> String  
bmiTell weight height  
    | bmi <= skinny = "You're underweight!"  
    | bmi <= normal = "You're supposedly normal!"  
    | bmi <= fat    = "You're fat! Lose some weight!"  
    | otherwise     = "You're a whale, congratulations!"  
    where bmi = weight / height ^ 2  
          skinny = 18.5  
          normal = 25.0  
          fat = 30.0 
bmiTellTest1 = bmiTell 85 1.90  

{- |
The names we define in the where section of a function are only visible to that function, 
    so we don't have to worry about them polluting the namespace of other functions. 
Notice that all the names are aligned at a single column. 
If we don't align them nice and proper, 
    Haskell gets confused because then it doesn't know they're all part of the same block.
 

`where` bindings aren't shared across function bodies of different patterns. 
If you want several patterns of one function to access some shared name, 
    you have to define it globally.
-}

{- | 
You can also use where bindings to pattern match!
We could have rewritten the where section of our previous function as:
    ...  
    where bmi = weight / height ^ 2  
          (skinny, normal, fat) = (18.5, 25.0, 30.0)
-}

-- Let's make another fairly trivial function where we get 
-- a first and a last name and give someone back their initials.

initialsUsingPatternMatchingInWhereClause :: String -> String -> String  
initialsUsingPatternMatchingInWhereClause firstname lastname = [f] ++ ". " ++ [l] ++ "."  
    where (f:_) = firstname  
          (l:_) = lastname
-- tests
initialsUsingPatternMatchingInWhereClauseTest1 = initialsUsingPatternMatchingInWhereClause "Bruce" "Wayne"
-- B. W.

{- |
We could have done this pattern matching directly in the function's parameters 
    (it would have been shorter and clearer actually) 
    but this just goes to show that it's possible to do it in where bindings as well.
-}

initialsUsingPatternMatchingOnParameters :: String -> String -> String  
initialsUsingPatternMatchingOnParameters (f:_) (l:_)  = [f] ++ ". " ++ [l] ++ "."  
-- tests
initialsUsingPatternMatchingOnParametersTest1 = initialsUsingPatternMatchingOnParameters "Bruce" "Wayne"
-- B. W.

addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)  
addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)  

addVectorsTest = addVectors (1, 2) (3, 4)

{- |
Just like we've defined constants in where blocks, 
    you can also define functions. 
Staying true to our healthy programming theme, 
    let's make a function that takes a list of weight-height pairs and returns a list of BMIs.
-}
calcBmis :: (RealFloat a) => [(a, a)] -> [a]  
calcBmis xs = [bmi w h | (w, h) <- xs]  
    where bmi weight height = weight / height ^ 2
-- tests
calcBmisTest1 = calcBmis [(2,3), (5,6)]

{- |
The reason we had to introduce bmi as a function in this example is because 
    we can't just calculate one BMI from the function's parameters. 
We have to examine the list passed to the function and there's a different BMI for every pair in there.
-}

{- |
`where` bindings can also be nested. 
It's a common idiom to make a function and 
    define some helper function in its where clause and 
    then to give those functions helper functions as well, each with its own where clause.
-}

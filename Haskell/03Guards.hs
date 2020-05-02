{- |
 Whereas patterns are a way of making sure a value conforms to some form and deconstructing it, 
 guards are a way of testing whether some property of a value (or several of them) are true or false. 
 That sounds a lot like an if statement and it's very similar. 
 The thing is that guards are a lot more readable when you have several conditions and 
 they play really nicely with patterns.
-}

{- |
 We're going to make a simple function that berates you differently depending on your BMI (body mass index). 
 Your BMI equals your weight divided by your height squared. 
 If your BMI is less than 18.5, you're considered underweight. 
 If it's anywhere from 18.5 to 25 then you're considered normal. 
 25 to 30 is overweight and more than 30 is obese. 
 So here's the function (we won't be calculating it right now, 
 this function just gets a BMI and tells you off)    
-}

{-|
bmiTell :: (RealFloat a) => a -> String  
bmiTell bmi  
    | bmi <= 18.5 = "You're underweight, you emo, you!"  
    | bmi <= 25.0 = "You're supposedly normal. Pffft, I bet you're ugly!"  
    | bmi <= 30.0 = "You're fat! Lose some weight, fatty!"  
    | otherwise   = "You're a whale, congratulations!" 
-}

{-|
 Guards are indicated by pipes that follow a function's name and its parameters. 
 Usually, they're indented a bit to the right and lined up. 
 A guard is basically a boolean expression. 
 If it evaluates to True, then the corresponding function body is used. 
 If it evaluates to False, checking drops through to the next guard and so on. 
 If we call this function with 24.3, it will first check if that's smaller than or equal to 18.5. 
 Because it isn't, it falls through to the next guard. 
 The check is carried out with the second guard and because 24.3 is less than 25.0, the second string is returned.    
-}

{-|
 This is very reminiscent of a big if else tree in imperative languages, 
 only this is far better and more readable. 
 While big if else trees are usually frowned upon, 
     sometimes a problem is defined in such a discrete way that you can't get around them. 
 Guards are a very nice alternative for this.    
-}

{-|
 Many times, the last guard is otherwise. 
 otherwise is defined simply as otherwise = True and catches everything. 
 This is very similar to patterns, only they check if the input satisfies a pattern but 
     guards check for boolean conditions. 
 If all the guards of a function evaluate to False 
     (and we haven't provided an otherwise catch-all guard), 
     evaluation falls through to the next pattern. 
 That's how patterns and guards play nicely together. 
 If no suitable guards or patterns are found, an error is thrown.    
-}

{-|
 Of course we can use guards with functions that take as many parameters as we want. 
 Instead of having the user calculate his own BMI before calling the function, 
 let's modify this function so that it takes a height and weight and calculates it for us.    
-}

{- |
bmiTell :: (RealFloat a) => a -> a -> String  
bmiTell weight height  
    | weight / height ^ 2 <= 18.5 = "You're underweight, you emo, you!"  
    | weight / height ^ 2 <= 25.0 = "You're supposedly normal. Pffft, I bet you're ugly!"  
    | weight / height ^ 2 <= 30.0 = "You're fat! Lose some weight, fatty!"  
    | otherwise                 = "You're a whale, congratulations!"  

bmiTellTest1 = bmiTell 85 1.90  
-}    


-- Note that there's no = right after the function name and its parameters, before the first guard.

customImplementationForMax :: (Ord a) => a -> a -> a  
customImplementationForMax a b   
    | a > b     = a  
    | otherwise = b
customImplementationForMaxTest1 = customImplementationForMax 2 3   

{- |
 Guards can also be written inline, 
     although I'd advise against that because it's less readable, even for very short functions.
-}

{- |
customImplementationForMax :: (Ord a) => a -> a -> a  
customImplementationForMax a b | a > b = a | otherwise = b 
-}

customImplementationForCompare :: (Ord a) => a -> a -> Ordering  
a `customImplementationForCompare` b  
    | a > b     = GT  
    | a == b    = EQ  
    | otherwise = LT
customImplementationForCompareTest1 =  2 `customImplementationForCompare` 3
customImplementationForCompareTest2 = customImplementationForCompare 5 4    

{- |
 Note: Not only can we call functions as infix with backticks, 
     we can also define them using backticks. 
 Sometimes it's easier to read that way.
-}

{- |
 In the previous implementation for bmiTell, 
     we repeat ourselves three times. 
 Since we repeat the same expression three times, 
     it would be ideal if we could calculate it once, 
     bind it to a name and then use that name instead of the expression. 
 Well, we can modify our function like this:
-}

{- | 
bmiTell :: (RealFloat a) => a -> a -> String  
bmiTell weight height  
    | bmi <= 18.5 = "You're underweight, you emo, you!"  
    | bmi <= 25.0 = "You're supposedly normal. Pffft, I bet you're ugly!"  
    | bmi <= 30.0 = "You're fat! Lose some weight, fatty!"  
    | otherwise   = "You're a whale, congratulations!"  
    where bmi = weight / height ^ 2
bmiTellTest1 = bmiTell 85 1.90  
-}

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
    | bmi <= skinny = "You're underweight, you emo, you!"  
    | bmi <= normal = "You're supposedly normal. Pffft, I bet you're ugly!"  
    | bmi <= fat    = "You're fat! Lose some weight, fatty!"  
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
-}

{- |
where bindings aren't shared across function bodies of different patterns. 
If you want several patterns of one function to access some shared name, 
    you have to define it globally.
-}

{- | 
You can also use where bindings to pattern match! We could have rewritten the where section of our previous function as:
    ...  
    where bmi = weight / height ^ 2  
          (skinny, normal, fat) = (18.5, 25.0, 30.0)
-}

-- Let's make another fairly trivial function where we get a first and a last name and give someone back their initials.

initials :: String -> String -> String  
initials firstname lastname = [f] ++ ". " ++ [l] ++ "."  
    where (f:_) = firstname  
          (l:_) = lastname
initialsTest1 = initials "Bruce" "Wayne"

{- |
We could have done this pattern matching directly in the function's parameters 
    (it would have been shorter and clearer actually) 
    but this just goes to show that it's possible to do it in where bindings as well.
TODO : implement it that way.
-}

{- |
Just like we've defined constants in where blocks, 
    you can also define functions. 
Staying true to our healthy programming theme, 
    let's make a function that takes a list of weight-height pairs and returns a list of BMIs.
-}
calcBmis :: (RealFloat a) => [(a, a)] -> [a]  
calcBmis xs = [bmi w h | (w, h) <- xs]  
    where bmi weight height = weight / height ^ 2
calcBmisTest1 = calcBmis [(2,3), (5,6)]

{- |
The reason we had to introduce bmi as a function in this example is because 
    we can't just calculate one BMI from the function's parameters. 
We have to examine the list passed to the function and there's a different BMI for every pair in there.
-}

{- |
where bindings can also be nested. 
It's a common idiom to make a function and 
    define some helper function in its where clause and 
    then to give those functions helper functions as well, each with its own where clause.
-}
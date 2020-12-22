-----------------------------------------------------------------------
-- GUARDS

-- Use Guards as opposed to patterns when 
-- checking for boolean conditions on the input parameters for a function.

{- |
 Whereas patterns are a way of making sure a value conforms to some form and deconstructing it, 
    guards are a way of testing whether some property of a value 
    (or several of them) are true or false. 
 That sounds a lot like an if statement and it's very similar. 
 The thing is that guards are a lot more readable when you have several conditions and 
    they play really nicely with patterns.

 When you have to look at the input parameters (or properties of input paremeters) 
  and evaluate them to true or false, 
  use guards instead of pattern matching.
 Guards and pattern matching work together with each other. Not one instead of another.
-}

{- |
 We're going to make a simple function that berates you differently 
    depending on your BMI (body mass index). 
 Your BMI equals your weight divided by your height squared. 
 If your BMI is less than 18.5, you're considered underweight. 
 If it's anywhere from 18.5 to 25 then you're considered normal. 
 25 to 30 is overweight and more than 30 is obese. 
 So here's the function (we won't be calculating it right now, 
 this function just gets a BMI and tells you off)    
-}


commentOnBmi :: (RealFloat a) => a -> String  
commentOnBmi bmi  
    | bmi <= 18.5 = "You're underweight!"  
    | bmi <= 25.0 = "You're supposedly normal!"  
    | bmi <= 30.0 = "You're fat! Lose some weight!"  
    | otherwise   = "You're a whale, congratulations!" 
testCommentOnBmi_01 = commentOnBmi 16.0    
testCommentOnBmi_02 = commentOnBmi 18.5    
testCommentOnBmi_03 = commentOnBmi 20.3    
testCommentOnBmi_04 = commentOnBmi 25.0    
testCommentOnBmi_05 = commentOnBmi 27.9    
testCommentOnBmi_06 = commentOnBmi 30.0    
testCommentOnBmi_07 = commentOnBmi 36.0    

{-|
 Guards are indicated by pipes that follow a function's name and its parameters. 
 Usually, they're indented a bit to the right and lined up. 
 A guard is basically a boolean expression. 
 If it evaluates to True, then the corresponding function body is used. 
 If it evaluates to False, checking drops through to the next guard and so on. 
 If we call this function with 24.3, it will first check if that's smaller than or equal to 18.5. 
 Because it isn't, it falls through to the next guard. 
 The check is carried out with the second guard and because 24.3 is less than 25.0, 
    the second string is returned.    


 This is very reminiscent of a big if else tree in imperative languages, 
    only this is far better and more readable. 
 While big if else trees are usually frowned upon, 
     sometimes a problem is defined in such a discrete way that you can't get around them. 
 Guards are a very nice alternative for this.    
 

 Many times, the last guard is `otherwise`. 
 `otherwise` is defined simply as otherwise = True and catches everything. 
 This is very similar to patterns, only they check if the input satisfies a pattern but 
     guards check for boolean conditions. 
 If all the guards of a function evaluate to False 
     (and we haven't provided an otherwise catch-all guard), 
     evaluation falls through to the next pattern. 
 That's how patterns and guards play nicely together. 
 If no suitable guards or patterns are found, an error is thrown.    
 

 We can use guards with functions that take as many parameters as we want. 
 Instead of having the user calculate his own BMI before calling the function, 
 let's modify this function so that it takes a height and weight and calculates it for us.    
-}


calculateBmiFromHeightAndWeightAndCommentOnIt :: (RealFloat a) => a -> a -> String  
calculateBmiFromHeightAndWeightAndCommentOnIt weight height  
    | weight / height ^ 2 <= 18.5 = "You're underweight!"  
    | weight / height ^ 2 <= 25.0 = "You're supposedly normal!"  
    | weight / height ^ 2 <= 30.0 = "You're fat! Lose some weight!"  
    | otherwise                 = "You're a whale, congratulations!"  

testCalculateBmiFromHeightAndWeightAndCommentOnIt_01 = 
    calculateBmiFromHeightAndWeightAndCommentOnIt 85 1.90    


-- Note that there's no `=` right after the function name and its parameters, 
-- before the first guard.


customImplementationForMax :: (Ord a) => a -> a -> a  
customImplementationForMax a b   
    | a > b     = a  
    | otherwise = b
testCustomImplementationForMax_01 = customImplementationForMax 2 3   


{- |
 Guards can also be written inline, 
     although I'd advise against that because it's less readable, 
     even for very short functions.
 
customImplementationForMax :: (Ord a) => a -> a -> a  
customImplementationForMax a b | a > b = a | otherwise = b 
-}



{- |
 Note: Not only can we call functions as infix with backticks, 
     we can also define them using backticks. 
 Sometimes it's easier to read that way.
 That is what we did with `customImplementationForCompare` below.
-}
customImplementationForCompare :: (Ord a) => a -> a -> Ordering  
a `customImplementationForCompare` b  
    | a > b     = GT  
    | a == b    = EQ  
    | otherwise = LT
customImplementationForCompareTest1 =  2 `customImplementationForCompare` 3
customImplementationForCompareTest2 = customImplementationForCompare 5 4    


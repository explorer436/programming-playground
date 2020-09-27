-----------------------------------------------------------------------
-- CASE EXPRESSIONS


{- |
Many imperative languages (C, C++, Java, etc.) have case syntax and 
if you've ever programmed in them, you probably know what it's about. 
It's about taking a variable and 
then executing blocks of code for specific values of that variable and 
then maybe including a catch-all block of code in case 
the variable has some value for which we didn't set up a case.

Haskell takes that concept and one-ups it. 
Like the name implies, case expressions are expressions, 
    much like `if else` expressions and `let` bindings. 
Not only can we evaluate expressions based on the possible cases of the value of a variable, 
    we can also do pattern matching. 
Hmmm, taking a variable, pattern matching it, evaluating pieces of code based on its value, 
where have we heard this before? 
Oh yeah, pattern matching on parameters in function definitions! 
Well, that's actually just syntactic sugar for case expressions. 
These two pieces of code do the same thing and are interchangeable:
-}

customImplementationForHeadUsingPatternMatching :: [a] -> a  
customImplementationForHeadUsingPatternMatching [] = error "Can't call head on an empty list, dummy!"  
customImplementationForHeadUsingPatternMatching (x:_) = x  
-- tests
customImplementationForHeadUsingPatternMatchingTest1 = 
    customImplementationForHeadUsingPatternMatching [4,5,6]  
customImplementationForHeadUsingPatternMatchingTest2 = 
    customImplementationForHeadUsingPatternMatching "Hello"  
customImplementationForHeadUsingPatternMatchingTest3 = 
    customImplementationForHeadUsingPatternMatching []
customImplementationForHeadUsingPatternMatchingTest4 = 
    customImplementationForHeadUsingPatternMatching ""  
customImplementationForHeadUsingPatternMatchingTest5 = 
    customImplementationForHeadUsingPatternMatching "h"  

-- Implementation for head using case expressions : 
customImplementationForHeadUsingCaseExpression :: [a] -> a  
customImplementationForHeadUsingCaseExpression xs = 
    case xs of [] -> error "No head for empty lists!"  
               (x:_) -> x 
-- tests
customImplementationForHeadUsingCaseExpressionTest1 = 
    customImplementationForHeadUsingCaseExpression [4,5,6]  
customImplementationForHeadUsingCaseExpressionTest2 = 
    customImplementationForHeadUsingCaseExpression "Hello"  
customImplementationForHeadUsingCaseExpressionTest3 = 
    customImplementationForHeadUsingCaseExpression []
customImplementationForHeadUsingCaseExpressionTest4 = 
    customImplementationForHeadUsingCaseExpression ""  
customImplementationForHeadUsingCaseExpressionTest5 = 
    customImplementationForHeadUsingCaseExpression "h"                        


{- |
The syntax for case expressions is pretty simple:

    case expression of pattern -> result  
                       pattern -> result  
                       pattern -> result  
                       ...  

`expression` is matched against the patterns. 
The pattern matching action is the same as expected: 
the first pattern that matches the expression is used. 
If it falls through the whole case expression and no suitable pattern is found, 
    a runtime error occurs.

Whereas pattern matching on function parameters can only be done when defining functions, 
case expressions can be used pretty much anywhere. 
For instance:
-}


describeList1 :: [a] -> String  
describeList1 xs = "The list is " ++ case xs of [] -> "empty."  
                                                [x] -> "a singleton list."   
                                                xs -> "a longer list."  


{- |
They are useful for pattern matching against something in the middle of an expression. 
Because pattern matching in function definitions is syntactic sugar for case expressions, 
we could have also defined this like so:
-}

describeList2 :: [a] -> String  
describeList2 xs = "The list is " ++ what xs  
    where what [] = "empty."  
          what [x] = "a singleton list."  
          what xs = "a longer list." 

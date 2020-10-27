Previously we mentioned that Haskell has a static type system. The type of every expression is known at compile time, which leads to safer code. If you write a program where you try to divide a boolean type with some number, it won't even compile. That's good because it's better to catch such errors at compile time instead of having your program crash. Everything in Haskell has a type, so the compiler can reason quite a lot about your program before compiling it.

Unlike Java or Pascal, Haskell has type inference. If we write a number, we don't have to tell Haskell it's a number. It can infer that on its own, so we don't have to explicitly write out the types of our functions and expressions to get things done. We covered some of the basics of Haskell with only a very superficial glance at types. However, understanding the type system is a very important part of learning Haskell.

A type is a kind of label that every expression has. It tells us in which category of things that expression fits. The expression True is a boolean, "hello" is a string, etc.

Now we'll use GHCI to examine the types of some expressions. We'll do that by using the :t command which, followed by any valid expression, tells us its type. Let's give it a whirl.

ghci> :t 'a'  
'a' :: Char  
ghci> :t True  
True :: Bool  
ghci> :t "HELLO!"  
"HELLO!" :: [Char]  
ghci> :t (True, 'a')  
(True, 'a') :: (Bool, Char)  
ghci> :t 4 == 5  
4 == 5 :: Bool 

Here we see that doing :t on an expression prints out the expression followed by :: and its type. :: is read as "has type of". Explicit types are always denoted with the first letter in capital case. 'a', as it would seem, has a type of Char. It's not hard to conclude that it stands for character. True is of a Bool type. That makes sense. But what's this? Examining the type of "HELLO!" yields a [Char]. The square brackets denote a list. So we read that as it being a list of characters. Unlike lists, each tuple length has its own type. So the expression of (True, 'a') has a type of (Bool, Char), whereas an expression such as ('a','b','c') would have the type of (Char, Char, Char). 4 == 5 will always return False, so its type is Bool.

Functions also have types. When writing our own functions, we can choose to give them an explicit type declaration. This is generally considered to be good practice except when writing very short functions. From here on, we'll give all the functions that we make type declarations. Remember the list comprehension we made previously that filters a string so that only caps remain? Here's how it looks like with a type declaration.

removeNonUppercase :: [Char] -> [Char]  
removeNonUppercase st = [ c | c <- st, c `elem` ['A'..'Z']]   
removeNonUppercase has a type of [Char] -> [Char], meaning that it maps from a string to a string. That's because it takes one string as a parameter and returns another as a result. The [Char] type is synonymous with String so it's clearer if we write removeNonUppercase :: String -> String. We didn't have to give this function a type declaration because the compiler can infer by itself that it's a function from a string to a string but we did anyway. But how do we write out the type of a function that takes several parameters? Here's a simple function that takes three integers and adds them together:

addThree :: Int -> Int -> Int -> Int  
addThree x y z = x + y + z  


The parameters are separated with -> and there's no special distinction between the parameters and the return type. The return type is the last item in the declaration and the parameters are the first three. Later on we'll see why they're all just separated with -> instead of having some more explicit distinction between the return types and the parameters like Int, Int, Int -> Int or something.

If you want to give your function a type declaration but are unsure as to what it should be, you can always just write the function without it and then check it with :t. Functions are expressions too, so :t works on them without a problem.

Here's an overview of some common types.

Int stands for integer. It's used for whole numbers. 7 can be an Int but 7.2 cannot. Int is bounded, which means that it has a minimum and a maximum value. Usually on 32-bit machines the maximum possible Int is 2147483647 and the minimum is -2147483648.

Integer stands for, er … also integer. The main difference is that it's not bounded so it can be used to represent really really big numbers. I mean like really big. Int, however, is more efficient.

factorial :: Integer -> Integer  
factorial n = product [1..n]  
ghci> factorial 50  
30414093201713378043612608166064768844377641568960512000000000000  
Float is a real floating point with single precision.

circumference :: Float -> Float  
circumference r = 2 * pi * r  
ghci> circumference 4.0  
25.132742  
Double is a real floating point with double the precision!

circumference' :: Double -> Double  
circumference' r = 2 * pi * r  
ghci> circumference' 4.0  
25.132741228718345  
Bool is a boolean type. It can have only two values: True and False.

Char represents a character. It's denoted by single quotes. A list of characters is a string.

Tuples are types but they are dependent on their length as well as the types of their components, so there is theoretically an infinite number of tuple types, which is too many to cover in this tutorial. Note that the empty tuple () is also a type which can only have a single value: ()


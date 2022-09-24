Reference: haskelltutorials.com

Note: For details about setting up a project, see the section "Setup your first throw-away project" from the document "SettingUpYourHaskellDevelopmentEnvironment.md"

Basic operators

|   |   |
|---|---|
| Arithmetic “operators” |	+, -, *, / |
| Boolean “operators” |	&&, ||, ==, /=, not |
| String concatenation |	++ |
| List concatenation |	++ |

Note:

The “not-equal” operator in Haskell is /=, which is unlike most other languages which use != for the same purpose.
The boolean negation operation in Haskell is not, which is unlike most other languages which use ! for the same purpose.

Defining functions

The syntax for defining functions and the syntax for calling a function is going to look alien to you for a couple of days (or weeks). Then you’ll get used to it. If you’re brain is repulsing to this syntax, just think about the first time you saw the expression x = x + 1, or x + y = 10; y = 3; find 'x' in 4th or 5th grade. You took some time to understand it, and now you don’t even think about it… you brain just knows!

For example, here’s a function that takes two Int arguments and adds them to return an Int result:

```
addInts :: Int -> Int -> Int
addInts x y = x + y
```

The first line, addInts :: Int -> Int -> Int is the function’s type signature. This tells the compilers that we will be defining a function called addInts which will take two integer arguments and return an integer value. In fact, if you comment out the second line, you will get a compiler error.

In Int -> Int -> Int, the first Int corresponds to the type of x, i.e. the first argument, the second Int corresponds to the type of y, i.e. the second argument, and the third Int corresponds to the return value of the function. The pointy-arrows in between is the syntax that indicates that this is a function as opposed to a regular variable.

The second line, addInts x y = x + y is the function definition, or the function body. Please note, that the = is not variable assignment. Everything to the left of that = contains variable names for each argument specified in the type signature (i.e. two arguments); and everything to the right of that = is the actual function definition. Because of your muscle-memory (built by working with languages like C/Java/Javascript), there is a bit of re-wiring that you brain will have to undergo to stop thinking “variable assignment” whenever it sees an = in a function definition.

This is equivalent to the following C code…
```
int add_ints (int x, int y) {
  return (x + y);
}
```

…or the following Javascript code:
```
function addInts(x, y) {
  return (x + y);
}
```

Notice that in Haskell we didn’t have to explicitly write return. The return value of a function is the value of the last expression evaluated. In some senses, this is similar to Ruby, where you can omit the return keyword.
```
def add_ints (x, y)
  x + y
end
```

And here is how you call the Haskell function:
```
GHCi> addInts 10 20
30
```

Notice how the syntax for calling functions in Haskell is very different from other languages. Compare it with how functions are called in C (or Javascript):
add_ints(10, 20);

If most of your experience has been with languages like Java & C# you will probably take some time to unlearn the muscle-memory of passing (function, arguments, in, parentheses). 

To recap:

* There is no semi-colon at the end of the statement
* No curly-braces.
* There are no parentheses around function arguments
* Function arguments are separated by spaces instead of commas
* Function signatures, i.e. Int -> Int -> Int, do not have variable names. The variable names are given directly in the function definition/body.
* In fact, function signatures don’t use any special syntax for the return-type of a function. The type after the last pointy-arrow (->) is the return-type of the function.
* The function definition is almost written like a mathematical equation. Do not be afraid of this. In a few days’/weeks’ you will become familiar with this syntax and will not even think about this.
* Do not confuse the = symbol in the function definition with variable assignment.
* There is no return statement. The return value of a function is the value of the last expression evaluated, which in this case is x + y

There is a very good reason why function signatures and function definitions are written this way. However, explaining that will require a detour into the theory of currying and partial function application - undoubtedly useful concepts for intermediate Haskell code - but entirely unsuitable for the first chapter of this book!

“if-then-else”

if-then-else in Haskell works very similar to other languages. For example, here’s a function to return "odd" / "even" depending upon the input number:

```
module Throwaway where

checkNumber :: Int -> String
checkNumber y =
  if (mod y 2) == 0
    then "even"
    else "odd"
```

Here’s how you can call it in your GHCi…

```
GHCi> :l Throwaway
GHCi> checkNumber 10
"even"
GHCi> checkNumber 7
"odd"
```

Again, notice how we didn’t have to explicitly write a return statement. Also, we didn’t need an explicit puts / print / printf statement. The return value of our function was automatically printed by GHCi.

No “truthy” or “falsy” values

Unlike other languages, Haskell doesn’t have the concept of truthy and falsy values. Some other languages treat a number of non-boolean values, like 0, 1, any string, empty array, empty object, etc, as either a boolean True or a boolean False. Haskell doesn’t do that. Haskell has only two boolean values - True or False. This is a result of the strong & principled type-system of Haskell.

Example of truth-y / false-y in Javascript:
```
if (0) {
  console.log("truthy");
} else {
  console.log("falsy");
}
// OUTPUT: falsy
```

Example of truth-y / false-y in Ruby:
```
if "abc" then
  puts "truthy"
else
  puts "falsy"
end
// OUTPUT: truthy
```

Getting stuff done without loops & without variables

We now have enough ammunition to start attacking text-book problems. Yes, we haven’t introduced any looping constructs. Yes, we haven’t even introduced variable assignment. This is one of the unlearning goals of this chapter.

We will demonstrate how it’s possible to write code without loops and variables. Using only functions, and recursion.

Note

This is not how loops are written in real-world Haskell code (we have high-level constructs to deal with it). However, values of variables are certainly not changed in real-world Haskell code. This is what makes Haskell an “immutable” language. And it’s important to undestand how it’s possible to write code without actually changing values of variables.

Summing up a list of integers

First, let’s quickly look at the head and tail functions that operate on lists:

```
GHCi> head [1, 2, 3, 4]
1

GHCi> tail [1, 2, 3, 4]
[2,3,4]
```

Now, let’s use this functions to write our own function that computes the sum of a list of integers:

```
module SumOfList where

sumOfList :: Int -> [Int] -> Int
sumOfList total lst =
  if (lst == [])
    then total
    else sumOfList (total + (head lst)) (tail lst)
```

Try it out in GHCi:
```
GHCi> :l SumOfList
GHCi> sumOfList 0 [1, 2, 3, 4, 5]
15
```

If you notice, we had to pass-in the initial value of the total as 0. If you don’t like this, you can move the core logic to a different function and put the initialisation code in another function, as shown below:

```
module SumOfList where

sumOfList :: [Int] -> Int
sumOfList lst = sumOfListInternal 0 lst

sumOfListInternal :: Int -> [Int] -> Int
sumOfListInternal total lst =
  if (lst == [])
    then total
    else sumOfListInternal (total + (head lst)) (tail lst)
```

Notice, how we haven’t used any for or do-while loop. We aren’t even changing the value of any variable. Each step in the recursion is passing new values to the next function call (which happens to be itself!)

Summing-up all even numbers in a list of integers

Now, let’s modify our previous code to sum-up only the even numbers in a list:

```
module SumOfList where

sumOfEven :: Int -> [Int] -> Int
sumOfEven total lst =
  if (lst == [])
    then total
    else if (mod (head lst) 2) == 0
      then sumOfEven (total + (head lst)) (tail lst)
      else sumOfEven total (tail lst)
```

Doubling all numbers in a list of integers
```
module Throwaway where

doubleList :: [Int] -> [Int] -> [Int]
doubleList processedList remainingList =
  if (remainingList == [])
    then processedList
    else doubleList (processedList ++ [(head remainingList) * 2]) (tail remainingList)

-- GHCi> :l Throwaway
-- GHCi> doubleList [] [1, 2, 3, 4]
-- [2, 4, 6, 8]
-- TODO implement this without passing the processedList to the function
```

Converting a String to uppercase
```
module Throwaway where

-- NOTE: importing the `toUpper` function from the Data.Char module.
-- You should look up the signature of this function from the docs
import Data.Char (toUpper)

toUppercase :: String -> String -> String
toUppercase processedString remainingString =
  if (remainingString == [])
    then processedString
    else toUppercase (processedString ++ [toUpper (head remainingString)] (tail remainingString)

-- GHCi> :l Throwaway
-- GHCi> toUppercase [] "hello world"
-- "HELLO WORLD"
```

Please observe that the String is being treated as a list. This should not surprise you because, in Haskell, String is just another name for [Char], i.e. a string is just a list of Char. Try changing the signature to toUppercase :: [Char] -> [Char] -> [Char] and verify this for yourself.

Checking if all characters in a String are contained in another String

Tip: You should take a pen & paper and understand how the logic & recursion is working in this example.

```

isCharPresent :: Char -> [Char] -> Bool
isCharPresent needle remainingString =
  if (remainingString == [])
    then False
    else if (need == (head remainingString))
      then True
      else isCharPresent needle (tail remainingString)

allCharsPresent :: [Char] -> [Char] -> Bool
allCharsPresent remainingNeedles haystack =
  if (remainingNeedles == [])
    then True
    else if isCharPresent (head remainingNeedles) haystack
      then allCharsPresent (tail remainingNeedles) haystack
      else False

-- GHCi> :l Throwaway
-- GHCi> allCharsPresent "hlo" "hello world"
-- True
--
-- GHCi> allCharsPresent "hxo" "hello world"
-- False
```

Generating a list of all even numbers till “N”
Let’s quickly look at the : operator, which is used to add an element to the beginning of a list:

GHCi> 1:[1, 3]
[1, 1, 3]

GHCi> 1:[]
[1]

GHCi> 'a':"bcde"
"abcde"

Note:

With repsect to the last example, remember how a String is basically just a Char, so we can use the : operator to add a Char to the beginning of a String. Please take note of the single quotes: '. Can you explain why the following doesn’t work?

GHCi> "a":"bcde"

-- ERROR: • Couldn't match type ‘Char’ with ‘[Char]’
Also, notice how : is used differently from ++. The former is used to add an item to a list, whereas the latter is used to concatenate two lists:

GHCi> 1:[2, 3]
[1, 2, 3]

GHCi> [2, 3] ++ [1]
[2, 3, 1]

GHCi> [2, 3] ++ [1, 2]
[2, 3, 1, 2]

Now, generating a list of all even numbers till “N”:

```
evenList :: Int -> [Int] -> [Int]
evenList n lst =
  if (n==0)
    then lst
    else if (mod n 2) == 0

      -- the `:` operator adds an item to the beginning of a list.
      then evenList (n - 1) (n:lst)
      else evenList (n - 1) lst

-- GHCi> evenList 100 []
-- [2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100]
```

Before you start the exercises

Remember to add type-signatures to your functions

Unlike other typed languages that you make have come across, like Java or C#, Haskell doesn’t really need type-signatures. One of the ground-breaking features of Haskell is called type-inference through which it can make very good guesses of what the type of a variable or value is. However, if you don’t put type signatures and inadvertently end-up writing incorrect code (which, as a beginner is going to happen quite a lot!), the compiler may end-up inferring a type that is completely different from what you intended. This will result in incomprehensible error messages for a newbie.

Keep API docs handy
While solving the exercises given below, you will need to use common functions that work with the built-in types, eg.

* How to check if an element exists in a list?
* How to find the index of an an element in a list?
* Filter all elements that match a certain condition in a list?
* Join multiple lists
* Split a string into multiple words

First, Make sure you are reading the correct docs (visit the section "Make sure you are reading the correct docs" in SettingUpYourHaskellDevelopmentEnvironment.md) - this is very important. Next, keep the docs for the following modules/functions open in multiple tabs:

* Data.List
* Data.String
* Data.Char
* Integral, RealFrac and Fractional - all of them will be part of a module called Prelude. The functions documented here will look funny for now. Hang-on till you read about type-classes. For now, anything under Integral can be used on Int values. Anything in RealFrac and Fractional can be used on Float or Double values.
PS: I am not linking to the docs deliberately. To become a successful Haskeller you have to be adept at navigating API docs, and you better get started rightaway.

You do NOT need to print anything to the terminal
Please remember, none of these exercises require you to actually print anything to the terminal/console. A function “returning” a value is not the same as a function printing a value in Haskell. You will appreciate this more once we talk about Monads & side-effects in later chapters. Just take this as a hard diktat for now.

A function’s return value will automatically be printed by GHCi. Just call the function with the correct arguments in GHCi - you do not have to do anything extra.

Tips on how to debug compilation errors
Most of the your time will be spent in one of the following three things, while doing these exercises:

Actually coming up with the logic
Expressing that logic without for loops (you can use Recursive iteration instead)
Pulling your hair-out when you get compiler errors
Here are some tips to help you debug compiler errors:

Rule #1: DO NOT PANIC. Breathe.
Rule #2: Remember to add type-signatures to your functions
After making sure that you have added function signatures, reload and re-run your function.
Rule #3: Read the error message. It has a lot of clues. Awaken your inner Sherlock.

Example #1

module Lib where

isEven :: Int -> Bool
isEven x = (x mod 2) == 0

-- ERROR:
--
-- /private/tmp/exercises/src/Lib.hs:4:13: error:
-- • Couldn't match expected type ‘(Integer -> Integer -> Integer)
--                                -> Int -> Integer’
--              with actual type ‘Int’
-- • The function ‘x :: Int’ is applied to two arguments,
--  but its type ‘Int’ has none
--  In the first argument of ‘(==)’, namely
--    ‘((x :: Int) mod (2 :: Int))’
--  In the expression: ((x :: Int) mod (2 :: Int)) == 0
-- Failed, modules loaded: none.
Let’s break down this error message:

/private/tmp/exercises/src/Lib.hs:4:13: error:
 • Couldn't match expected type ‘(Integer -> Integer -> Integer)
                                -> Int -> Integer’
              with actual type ‘Int’
First clue: The error is in line #4 (highlighted below), column #13 (which is where x mod 2 starts). Btw, the exact expression containing the error is also reported in the error message towards the end.

module Lib where

isEven :: Int -> Bool
isEven x = (x mod 2) == 0
Second clue: If you read the first line of the error message, it says that Coulnd't match type <some scary type> with actual type "Int". So, the compiler is expecting some scary/weird type, but you are actually passing it in an Int. Where is the compiler getting this scary type from? Let’s dig deeper, by looking at the next line of the error message:

The function ‘x :: Int’ is applied to two arguments, but its type ‘Int’ has none
Third clue: The compiler is saying that you are applying a function to two arguments (in other words, you are passing a function two arguments) but the function seems to take no arguments. Which function is the compiler talking about? x? Wait, what?! How is x a function?

Now, we are getting closer. Go and read function_application and re-read line #4 (where the error is being reported):

if (x mod 2) == 0
The compiler is thinking that x is a function, because we’re using it as function (we are passing it mod and 2 as the two arguments)! Now, re-read the second line of the error message. The compiler knows that the type of x is Int (thanks to the type-signature), but because we are trying to use it as a function, it’s complaining.

And finally, here’s the fix:

-- Use `mod` as the function and pass it `x` and `2` as the arguments
if (mod x 2) == 0

-- Or, use `mod` as an infix operator:
if (x `mod` 2) == 0

Exercises

Leap year

Write a function which checks if a given year is a leap year:

module Leap where

isLeapYear :: Int -> Bool
isLeapYear yr = _todo
Here is the logic for determining a leap year:

every year that is evenly divisible by 4 is a leap year
except every year that is evenly divisible by 100
unless the year is also evenly divisible by 400
Hint: You will need to use the mod function and a bunch of if-then-else statements to get this done.

Again, remember your function does not have to print anything directly to the console. Just write a function with the following type-signature. Simple calling that function in GHCi will print the result of the function.

GHCi> :l Leap
GHCi> isLeapYear 2000
True
GHCi> isLeapYear 1999
False

Generate a list of first “N” even numbers
In Generating a list of all even numbers till “N”, we had generated a list of all even numbers till “N”. Can you change that to generate a list of first N even numbers:

evenList :: Int -> [Int] -> [Int]
evenList remainingCount lst = _todo

-- GHCi> evenList 5 []
-- [2, 4, 6, 8, 10]
Multiples of 3 or 5
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000. That is, you have to write the following function:

multipleSum :: Int -> Int -> Int
multipleSum currenNumber total = _todo

-- GHCi> multipleSum 1000 0
-- 234168
Note: You don’t necessarily need a list of number from 1 to 1000 to solve this exercise.

Sum of first “N” multiples of 3 or 5
Change your solution of Multiples of 3 or 5 to compute the sum of first N multiple of 3 or 5. For example, the first 10 multiples of 3 or 5 are 3, 5, 6, 9, 10, 12, 15, 18, 20, 21 and their sum is 119.

multipleSum :: Int -> Int -> Int
multipleSum remainingCount total = _todo

-- GHCi> multipleSum 10 0
-- 119
Sum square difference
The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)^2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first “N” numbers and the square of the sum.

square :: Int -> Int
square x = _todo

sumOfSquares :: Int -> Int -> Int
sumOfSquares remainingCount total = _todo

squareOfSum :: Int -> Int -> Int
squareOfSum remainingCount total = _todo

difference :: Int -> Int
difference n = _todo

-- GHCi> difference 10
-- 2640
Even Fibonacci numbers
Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
Find the sum of all even-valued Fibonacci terms which are less than “maxValue”. For example, all even-valued Fibonacci numbers under 55 are…

2, 8, 34
… and their sum is 44.

There are multiple ways to solve this problem. First start with the most obvious one, i.e. by writing the following two functions:

-- This function returns the **n-th** number of the Fibonacci sequence
--
fibonacci :: Int -> Int
fibonacci n = _todo

-- For every `n`, this function calls the `fibonacci` function defined
-- above, adds the result to `total` and iterates/recurses till a condition is
-- met. What is that condition?
--
evenSum :: Int -> Int -> Int -> Int
evenSum maxValue n total = _todo

-- This is how you can call this function in your REPL:
--
-- GHCi> evenSum 55 1 0
-- 44
Another way to solve this problem is by “fusing” the two functions defined above into a single function:

-- `a` is the n-th term of the Fibonacci sequence.
-- `b` is the (n+1)-th term of the Fibonacci sequence
-- `total` is the total of all the even Fibonacci numbers till the **(n-1)-th** term
--
evenSum :: Int -> Int -> Int -> Int -> Int
evenSum maxValue a b total = _todo

-- This is how you can call this function in your REPL:
--
-- GHCi> evenSum 4000000 1 2 0
-- 4613732
ISBN Verifier
ISBN numbers are unique numeric codes given to every book. You can pickup any text-book or fiction book and you should find them usually on the back cover, along with a bar-code. For example: http://lionslayer.yoeyar.com/wp-content/uploads/2011/04/ISBN.jpg

ISBNs come in two flavours - 10 digit and 13 digit. They are usually written with hyphens between them. For example:

3-598-21508-8 or 0-86381-580-4 - 10 digit ISBN with separating hyphens
9-780863-815805 - 13 digit ISBN with separating hyphens
However, not every 10-digit (or 13-digit) number is a valid ISBN. All valid ISBNs must comply with, what is known as a checksum. Here is how one can verify if a 10-digit ISBN is valid or not:

3598215088 (same ISBN as above, but without hyphens)

  (3 * 10) -- Successively multiply each digit of the number with 10, 9, 8, 7.... 1
+ (5 *  9)
+ (9 *  8)
+ (8 *  7)
+ (2 *  6)
+ (1 *  5)
+ (5 *  4)
+ (0 *  3)
+ (8 *  2)
+ (8 *  1)
----------
       264 -- then adding them up
----------

-- Now check if the remainder of dividing by 11 is zero, or not

264 `mod` 11 == 0 -- This is a valid ISBN
The first part of this exercise is to write a function that checks if a given 10-digit ISBN without hyphens is valid, or not. The ISBN will be provided as String, so you will need a way to conver a Char to an Int. Go to your Stackage docs and search the exact signature of the function that you’ll need, i.e. Char -> Int

-- NOTE: In this part of the exercise you can assume
-- that the ISBN will be provided without hyphens.
--
isValidIsbn :: String -> Bool
isValidIsbn isbn = _todo

isValidIsbnInternal :: String -> Int -> Int -> Bool
isValidIsbnInternal remainingIsbn currentMultiplier total = _todo
The second part of this exercise is to modify your solution to the first part, such that it is able to “skip” hyphens anywhere in the ISBN, i.e. you can’t assume that the hyphens are in fixed/known places. The function signatures need not change.

The third part of this exercise is to modify your solution to the second part, such that ISBNs that are not exactly 10 digits are reported invalid. For example, the following ISBN should be reported as invalid even though the checksum is a multiple of 11.

GHCi> isValidIsbn "123-45"
Tip

You can get more ISBNs for testing via http://isbndb.com/ Remember to use the ISBN10, not the ISBN13.

_static/isbn.png
Pangram
Write a function to determine if a given string is a pangram. A pangram is defined as a sentence that uses every letter of the alphabet at least once. It is allowed to use some letters more than once, but it must use every letter at least once. For example:

-- This is pangram. Notice that it uses 'o', 't', 'h', 'e' more than once.

The quick brown fox jumps over the lazy dog
More pangrams for testing your code:

Pack my box with five dozen liquor jugs
We promptly judged antique ivory buckles for the next prize
Sixty zippers were quickly picked from the woven jute bag
Sphinx of black quartz: judge my vow
Using the techniques that we have covered till now, here’s one possible way of building your solution

module Pangram where

-- You will need to handle the case where a character in the sentence may be in
-- uppercase, or may be a punctuation. `toLower` and `isAlpha` should help you with that.
--
import Data.Char (toLower, isAlpha)

charPresent :: Char -> String -> Bool
charPresent needle haystack = _todo

isPangram :: String -> String -> Bool
isPangram remainingChars remainingString = _todo

GHCi> :l Pangram
GHCi> isPangram "abcdefghijklmnopqrstuvwxyz" "The quick brown fox jumps over the lazy dog"
True
Another possible way of writing this function is using the delete function:

GHCi> import Data.List as DL
GHCi> DL.delete 'm' "abcdefghijklmnopqrstuvwxyz"
"abcdefghijklnopqrstuvwxyz"
Using delete as a building block of your logic, try completing the following program:

module Pangram where

-- In this approach you don't need to check whether something is a letter or punctuation.
-- So, you don't need the `isAlpha` function.
--
import Data.Char (toLower)
import Data.List (delete)

isPangram :: String -> String -> Bool
isPangram remainingChars remainingString = _todo
Rail Fence Cipher
The Rail Fence cipher is a form of transposition cipher that gets its name from the way in which it’s encoded. It was already used by the ancient Greeks. In the Rail Fence cipher, the message is written downwards on successive “rails” of an imaginary fence, then moving up when we get to the bottom (like a zig-zag). Finally the message is then read off in rows.

For example, using three “rails” and the message “WE ARE DISCOVERED FLEE AT ONCE”, the cipherer writes out:

1 | W . . . E . . . C . . . R . . . L . . . T . . . E  --> Reads off as "WECRLTE"
2 | . E . R . D . S . O . E . E . F . E . A . O . C .  --> Reads off as "ERDSOEEFEAOC"
3 | . . A . . . I . . . V . . . D . . . E . . . N . .  --> Reads off as "AIVDEN"
The final encoded message is:

WECRLTEERDSOEEFEAOCAIVDEN
The first part of this exercise is to write a function that encodes a given string using the Rails Fence Cipher.

withoutSpaces :: String -> String -> String
withoutSpaces inputStirng processedString = _todo

-- In the recursion, we maintain the content in each of the
-- three rails in `rail1`, `rail2`, and `rail3`.
--
-- We also maintain the rail in which the next character has
-- to be pushed (currentRail).
--
-- The last one is the tricky part. We need to alternate between rails:
-- 1 -> 2 -> 3 -> 2 -> 1 -> 2 -> 3 -> ....
-- So, we store either +1 or -1 in movementDirection to indicate how the
-- value of currentRails should be changed in the next recursion.
--
encodeMessage :: String -> String -> String -> String -> Int -> Int -> String
encodeMessage inputString rail1 rail2 rails3 currentRail movementDirection = _todo

GHCi> encodeMessage (withoutSpaces "WE ARE DISCOVERED FLEE AT ONCE" "") [] [] [] 1 -1
"WECRLTEERDSOEEFEAOCAIVDEN"

GHCi> encodeMessage (withoutSpaces "hel" "") [] [] [] 1 -1
"hel"

GHCi> encodeMessage (withoutSpaces "hello" "") [] [] [] 1 -1
"hoell"

GHCi> encodeMessage (withoutSpaces "hello world" "") [] [] [] 1 -1
"holelwrdlo"

Stuff that you might struggle with

Indentation
Like Python, indenting code correctly is very important in Haskell. The same code, if indented differently, can have a completely different meaning for the compiler. However, unlike Python, Haskell doesn’t have “One Right Way” of doing indentation.

To complete the exercises given above with what you have learnt till now, you’ll have to learn how to indent let blocks & if-then-else expressions correctly.

Weird-looking types
:t True is reported as a Bool, but :t 5 looks like rocket-science! Hang-in there till you read about type-classes. Then you will be able to understand why any kind of number in Haskell has this additional layer of complexity (eg. Int, Integer, Float, Double, Decimal, etc).

As a result of this, you might struggle with dividing two Int values.

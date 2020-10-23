Note: For details about setting up a project, see the section "Setup your first throw-away project" from the document "SettingUpYourHaskellDevelopmentEnvironment.md"

Learning Goal

We will dive into basic text-book exercises with basic data-types, specifically stressing upon solving problem without necessarily using for loops and without traditional/mutable variables.

Unlearning goal

We will spend quite some time solving problems without using for loops and without changing the value of variables. This is going to be in stark constrast to learning other languages!

Basic data-types

| Java  | Haskell  | Example values in Haskell  |
|---|---|---|
| int |	Int	| 1, 2, -1, -2, etc |
| float |	Float |	1.0, -1.23, -2.5, etc |
| bool |	Bool |	True, False. Nothing else (see notes below) |
| char |	Char |	'a', 'b', 'c', '\n', '\r', '\t', etc. |
| String |	String |	"hello world", "abc", "a", "b" (notice the single quotes - ' vs double quotes - " difference between Char and String) |
| double |	Double |	1.0, -1.23, -2.5, etc (basically larger values than Float) |
| void |	() |	() - see notes below |
| int[], bool[], double[], String[] |	`[Int]`, `[Bool]`, `[Double]`, `[String]` |	[1, 2, 3, 4] or [True, False, False], or [1.0, 5.6, 12.34] or ["hello", "world", "haskell", "rocks"] |
| int[][], bool[][], int[][][], float[][][] |	`[[Int]]`, `[[Bool]]`, `[[[Int]]]`, `[[[Float]]]`	| `[[1, 2], [3, 4, 5], [6, 7, 8]]` or `[["Multi", "dim"], ["list", "in", "haskell"]]` |

Lists, not arrays

An important point to keep at the back-of-your-mind (for now), is that C/Java arrays do not correspond 1:1 with the [Int], [Float], [Bool], etc. in Haskell. In C/Java, usually when you declare an array a continuous area in memory is reserved for it. This makes index-based lookups really efficient, because the n-th element in array can simply be looked-up via pointer arithmetic.

However, dynamically growing or shrinking an array at run-time becomes an expensive operation because a new contiguous region of memory must be reserved and the shrunk/grown array must be copied into the new region. In fact, the C language doesn’t really have a buit-in way to dynamically grow/shrink an array at runtime. You have to resort to manual memory management, or use a special library to do this for you.

However, in Haskell a list is literally a linked list internally. Thankfully, you don’t have to traverse the linked list manually - the language takes care of all of this plumbing, giving you a very simple interface to do a variety of operations on your list, eg. add an element, remove an element, lookup an element by index, find an element within a list, etc.

Having a list, as opposed to an array, means index-based lookups are inefficient. This is becasue, to lookup the n-th element, one needs to traverse all (n - 1) elements till n-th element is reached. On the other hand, appending an element to the beginning of a list is an extremely efficient operation.

For this chapter, we will be using lists to solve all our problems because efficiency is not our main concern. However, in a real-world Haskell program if it is established (or anticipated) that using lists will slow down the program, Data.Vector can be used instead.

Lists must contain elements of the same type

Another important difference between Haskell lists and arrays in dynamic languages, like Ruby, Javascript, and Python, is that, in Haskell, all elements in a list must be of the same type. 

It should be noted that data-structures that deal with collection of differently-typed elements do exist in Haskell. It’s just that they aren’t lists and we will be covering them later.

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


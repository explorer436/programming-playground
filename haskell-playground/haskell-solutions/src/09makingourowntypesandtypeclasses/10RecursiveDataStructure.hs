As we've seen, a constructor in an algebraic data type can have several (or none at all) fields and each field must be of some concrete type. 
With that in mind, we can make types whose constructors have fields that are of the same type! 
Using that, we can create recursive data types, where one value of some type contains values of that type, which in turn contain more values of the same type and so on.

Think about this list: [5]. 
That's just syntactic sugar for 5:[]. 
On the left side of the :, there's a value and on the right side, there's a list. 
And in this case, it's an empty list. 
Now how about the list [4,5]? 
Well, that desugars to 4:(5:[]). 
Looking at the first :, we see that it also has an element on its left side and a list (5:[]) on its right side. 
Same goes for a list like 3:(4:(5:6:[])), which could be written either like that or like 3:4:5:6:[] (because : is right-associative) or [3,4,5,6].

We could say that a list can be an empty list or it can be an element joined together with a : with another list (that can be either the empty list or not).

Let's use algebraic data types to implement our own list then!

data List a = Empty | Cons a (List a) deriving (Show, Read, Eq, Ord) 

This reads just like our definition of lists from one of the previous paragraphs. 
It's either an empty list or a combination of a head with some value and a list. 
If you're confused about this, you might find it easier to understand in record syntax.

data List a = Empty | Cons { listHead :: a, listTail :: List a} deriving (Show, Read, Eq, Ord)  

You might also be confused about the Cons constructor here. 
cons is another word for :. 
You see, in lists, : is actually a constructor that takes a value and another list and returns a list. 
We can already use our new list type! 
In other words, it has two fields. 
One field is of the type of a and the other is of the type [a].

ghci> Empty  
Empty  
ghci> 5 `Cons` Empty  
Cons 5 Empty  
ghci> 4 `Cons` (5 `Cons` Empty)  
Cons 4 (Cons 5 Empty)  
ghci> 3 `Cons` (4 `Cons` (5 `Cons` Empty))  
Cons 3 (Cons 4 (Cons 5 Empty))  

We called our Cons constructor in an infix manner so you can see how it's just like :. 
Empty is like [] and 4 `Cons` (5 `Cons` Empty) is like 4:(5:[]).

We can define functions to be automatically infix by making them comprised of only special characters. 
We can also do the same with constructors, since they're just functions that return a data type. 
So check this out.

infixr 5 :-:  
data List a = Empty | a :-: (List a) deriving (Show, Read, Eq, Ord) 

First off, we notice a new syntactic construct, the fixity declarations. 
When we define functions as operators, we can use that to give them a fixity (but we don't have to). 
A fixity states how tightly the operator binds and whether it's left-associative or right-associative. 
For instance, *'s fixity is infixl 7 * and +'s fixity is infixl 6. 
That means that they're both left-associative (4 * 3 * 2 is (4 * 3) * 2) but * binds tighter than +, because it has a greater fixity, 
so 5 * 4 + 3 is (5 * 4) + 3.

Otherwise, we just wrote a :-: (List a) instead of Cons a (List a). 
Now, we can write out lists in our list type like so:

ghci> 3 :-: 4 :-: 5 :-: Empty  
(:-:) 3 ((:-:) 4 ((:-:) 5 Empty))  
ghci> let a = 3 :-: 4 :-: 5 :-: Empty  
ghci> 100 :-: a  
(:-:) 100 ((:-:) 3 ((:-:) 4 ((:-:) 5 Empty)))  

When deriving Show for our type, Haskell will still display it as if the constructor was a prefix function, hence the parentheses around the operator (remember, 4 + 3 is (+) 4 3).

Let's make a function that adds two of our lists together. 
This is how ++ is defined for normal lists:

infixr 5  ++ 
(++) :: [a] -> [a] -> [a]  
[]     ++ ys = ys  
(x:xs) ++ ys = x : (xs ++ ys)  

So we'll just steal that for our own list. We'll name the function .++.

infixr 5  .++  
(.++) :: List a -> List a -> List a   
Empty .++ ys = ys  
(x :-: xs) .++ ys = x :-: (xs .++ ys)  

And let's see if it works ...

ghci> let a = 3 :-: 4 :-: 5 :-: Empty  
ghci> let b = 6 :-: 7 :-: Empty  
ghci> a .++ b  
(:-:) 3 ((:-:) 4 ((:-:) 5 ((:-:) 6 ((:-:) 7 Empty))))  

Nice. Is nice. 
If we wanted, we could implement all of the functions that operate on lists on our own list type.

Notice how we pattern matched on (x :-: xs). 
That works because pattern matching is actually about matching constructors. 
We can match on :-: because it is a constructor for our own list type and we can also match on : because it is a constructor for the built-in list type. 
Same goes for []. 
Because pattern matching works (only) on constructors, we can match for stuff like that, normal prefix constructors or stuff like 8 or 'a', which are basically constructors for the numeric and character types, respectively.


As we will see in Trees.hs, algebraic data structures are a really cool and powerful concept in Haskell. 
We can use them to make anything from boolean values and weekday enumerations to binary search trees and more!

Here is another example of recursive data type from Haskell standard library:
-- https://hackage.haskell.org/package/data-nat-0.1.2/docs/src/Data-Nat.html#Nat
data Nat = Zero | Succ Nat
           deriving (Eq, Ord, Read, Show MAYBE_TYPEABLE MAYBE_GENERIC)

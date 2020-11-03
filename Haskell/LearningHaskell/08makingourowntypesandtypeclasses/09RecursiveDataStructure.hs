As we've seen, 
a constructor in an algebraic data type can have several (or none at all) fields and 
each field must be of some concrete type. 
With that in mind, 
we can make types whose constructors have fields that are of the same type! 
Using that, we can create recursive data types, 
where one value of some type contains values of that type, 
which in turn contain more values of the same type and so on.

Think about this list: [5]. 
That's just syntactic sugar for 5:[]. 
On the left side of the :, there's a value and on the right side, there's a list. 
And in this case, it's an empty list. 
Now how about the list [4,5]? 
Well, that desugars to 4:(5:[]). 
Looking at the first :, 
we see that it also has an element on its left side and a list (5:[]) on its right side. 
Same goes for a list like 3:(4:(5:6:[])), 
which could be written either like that or like 3:4:5:6:[] 
(because : is right-associative) or [3,4,5,6].

We could say that a list can be an empty list or 
it can be an element joined together with a : with another list 
(that can be either the empty list or not).

Let's use algebraic data types to implement our own list then!

data List a = Empty | Cons a (List a) deriving (Show, Read, Eq, Ord) 

This reads just like our definition of lists from one of the previous paragraphs. 
It's either an empty list or a combination of a head with some value and a list. 
If you're confused about this, you might find it easier to understand in record syntax.

data List a = Empty | Cons { listHead :: a, listTail :: List a} deriving (Show, Read, Eq, Ord)  

You might also be confused about the Cons constructor here. 
cons is another word for :. 
You see, in lists, : is actually a constructor that takes a value and 
another list and returns a list. 
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

We can define functions to be automatically infix by 
making them comprised of only special characters. 
We can also do the same with constructors, 
since they're just functions that return a data type. 
So check this out.

infixr 5 :-:  
data List a = Empty | a :-: (List a) deriving (Show, Read, Eq, Ord) 

First off, 
we notice a new syntactic construct, the fixity declarations. 
When we define functions as operators, 
we can use that to give them a fixity (but we don't have to). 
A fixity states how tightly the operator binds and 
whether it's left-associative or right-associative. 
For instance, *'s fixity is infixl 7 * and +'s fixity is infixl 6. 
That means that they're both left-associative (4 * 3 * 2 is (4 * 3) * 2) 
but * binds tighter than +, 
because it has a greater fixity, 
so 5 * 4 + 3 is (5 * 4) + 3.

Otherwise, we just wrote a :-: (List a) instead of Cons a (List a). 
Now, we can write out lists in our list type like so:

ghci> 3 :-: 4 :-: 5 :-: Empty  
(:-:) 3 ((:-:) 4 ((:-:) 5 Empty))  
ghci> let a = 3 :-: 4 :-: 5 :-: Empty  
ghci> 100 :-: a  
(:-:) 100 ((:-:) 3 ((:-:) 4 ((:-:) 5 Empty)))  

When deriving Show for our type, 
Haskell will still display it as if the constructor was a prefix function, 
hence the parentheses around the operator (remember, 4 + 3 is (+) 4 3).

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
If we wanted, 
we could implement all of the functions that operate on lists on our own list type.

Notice how we pattern matched on (x :-: xs). 
That works because pattern matching is actually about matching constructors. 
We can match on :-: because it is a constructor for our own list type and 
we can also match on : because it is a constructor for the built-in list type. 
Same goes for []. 
Because pattern matching works (only) on constructors, 
we can match for stuff like that, 
normal prefix constructors or stuff like 8 or 'a', 
which are basically constructors for the numeric and character types, 
respectively.

Now, we're going to implement a binary search tree. 
If you're not familiar with binary search trees from languages like C, 
here's what they are - 
an element points to two elements, 
one on its left and one on its right. 
The element to the left is smaller, the element to the right is bigger. 
Each of those elements can also point to two elements (or one, or none). 
In effect, 
each element has up to two sub-trees. 
And a cool thing about binary search trees is that 
we know that all the elements at the left sub-tree of, say, 5 are going to be smaller than 5. 
Elements in its right sub-tree are going to be bigger. 
So if we need to find if 8 is in our tree, 
we'd start at 5 and then because 8 is greater than 5, we'd go right. 
We're now at 7 and because 8 is greater than 7, we go right again. 
And we've found our element in three hops! 
Now if this were a normal list (or a tree, but really unbalanced), 
it would take us seven hops instead of three to see if 8 is in there.

Sets and maps from Data.Set and Data.Map are implemented using trees, 
only instead of normal binary search trees, 
they use balanced binary search trees, 
which are always balanced. 
But right now, we'll just be implementing normal binary search trees.

Here's what we're going to say: 
a tree is either an empty tree or 
it's an element that contains some value and two trees. 
Sounds like a perfect fit for an algebraic data type!

data Tree a = EmptyTree | Node a (Tree a) (Tree a) deriving (Show, Read, Eq) 

Okay, good, this is good. 
Instead of manually building a tree, 
we're going to make a function that takes a tree and an element and 
inserts an element. 
We do this by comparing the value we want to insert 
to the root node and then if it's smaller, we go left, 
if it's larger, we go right. 
We do the same for every subsequent node until we reach an empty tree. 
Once we've reached an empty tree, 
we just insert a node with that value instead of the empty tree.

In languages like C, 
we'd do this by modifying the pointers and values inside the tree. 
In Haskell, we can't really modify our tree, 
so we have to make a new sub-tree each time we decide to go left or right 
and in the end the insertion function returns a completely new tree, 
because Haskell doesn't really have a concept of pointer, just values. 
Hence, the type for our insertion function is going to be something like 
a -> Tree a - > Tree a. 
It takes an element and a tree and returns a new tree that has that element inside. 
This might seem like it's inefficient but laziness takes care of that problem.

So, here are two functions. 
One is a utility function for making a singleton tree (a tree with just one node) 
and a function to insert an element into a tree.

singleton :: a -> Tree a  
singleton x = Node x EmptyTree EmptyTree  
  
treeInsert :: (Ord a) => a -> Tree a -> Tree a  
treeInsert x EmptyTree = singleton x  
treeInsert x (Node a left right)   
    | x == a = Node x left right  
    | x < a  = Node a (treeInsert x left) right  
    | x > a  = Node a left (treeInsert x right)
    
The singleton function is just a shortcut for making a node 
that has something and then two empty sub-trees. 
In the insertion function, 
we first have the edge condition as a pattern. 
If we've reached an empty sub-tree, 
that means we're where we want and instead of the empty tree, 
we put a singleton tree with our element. 
If we're not inserting into an empty tree, 
then we have to check some things. 
First off, if the element we're inserting is equal to the root element, 
just return a tree that's the same. 
If it's smaller, return a tree that has the same root value, 
the same right sub-tree but instead of its left sub-tree, 
put a tree that has our value inserted into it. 
Same (but the other way around) goes if our value is bigger than the root element.

Next up, we're going to make a function that checks if some element is in the tree. 
First, let's define the edge condition. 
If we're looking for an element in an empty tree, then it's certainly not there. 
Notice how this is the same as the edge condition when searching for elements in lists. 
If we're looking for an element in an empty list, it's not there. 
Anyway, if we're not looking for an element in an empty tree, then we check some things. 
If the element in the root node is what we're looking for, great! 
If it's not, what then? 
Well, we can take advantage of knowing that all the left elements are smaller than the root node. 
So if the element we're looking for is smaller than the root node, 
check to see if it's in the left sub-tree. 
If it's bigger, check to see if it's in the right sub-tree.

treeElem :: (Ord a) => a -> Tree a -> Bool  
treeElem x EmptyTree = False  
treeElem x (Node a left right)  
    | x == a = True  
    | x < a  = treeElem x left  
    | x > a  = treeElem x right 
    
All we had to do was write up the previous paragraph in code. 
Let's have some fun with our trees! 
Instead of manually building one (although we could), 
we'll use a fold to build up a tree from a list. 
Remember, 
pretty much everything that traverses a list one by one and 
then returns some sort of value can be implemented with a fold! 
We're going to start with the empty tree and 
then approach a list from the right and 
just insert element after element into our accumulator tree.
        
ghci> let nums = [8,6,4,1,7,3,5]  
ghci> let numsTree = foldr treeInsert EmptyTree nums  
ghci> numsTree  
Node 5 (Node 3 (Node 1 EmptyTree EmptyTree) (Node 4 EmptyTree EmptyTree)) (Node 7 (Node 6 EmptyTree EmptyTree) (Node 8 EmptyTree EmptyTree))  

In that foldr, 
treeInsert was the folding function 
(it takes a tree and a list element and produces a new tree) and 
EmptyTree was the starting accumulator. 
nums, of course, was the list we were folding over.

When we print our tree to the console, 
it's not very readable, but if we try, we can make out its structure. 
We see that the root node is 5 and then it has two sub-trees, 
one of which has the root node of 3 and the other a 7, etc.

ghci> 8 `treeElem` numsTree  
True  
ghci> 100 `treeElem` numsTree  
False  
ghci> 1 `treeElem` numsTree  
True  
ghci> 10 `treeElem` numsTree  
False  

Checking for membership also works nicely. Cool.

So as you can see, 
algebraic data structures are a really cool and powerful concept in Haskell. 
We can use them to make anything from boolean values and 
weekday enumerations to binary search trees and more!


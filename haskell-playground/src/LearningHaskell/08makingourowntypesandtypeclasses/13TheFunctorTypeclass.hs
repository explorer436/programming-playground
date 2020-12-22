So far, we've encountered a lot of the typeclasses in the standard library. 
We've played with Ord, which is for stuff that can be ordered. 
We've palled around with Eq, which is for things that can be equated. 
We've seen Show, which presents an interface for types whose values can be displayed as strings. 
Our good friend Read is there whenever we need to convert a string to a value of some type. 
And now, we're going to take a look at the Functor typeclass, 
which is basically for things that can be mapped over. 
You're probably thinking about lists now, 
since mapping over lists is such a dominant idiom in Haskell. 
And you're right, the list type is part of the Functor typeclass.

What better way to get to know the Functor typeclass than to see how it's implemented? 
Let's take a peek.

class Functor f where  
    fmap :: (a -> b) -> f a -> f b  
    
We see that it defines one function, fmap, and doesn't provide any default implementation for it. 
The type of fmap is interesting. 
In the definitions of typeclasses so far, 
the type variable that played the role of the type in the typeclass was a concrete type, 
like the a in (==) :: (Eq a) => a -> a -> Bool. 
But now, the f is not a concrete type (a type that a value can hold, like Int, Bool or Maybe String), 
but a type constructor that takes one type parameter. 
A quick refresher example: Maybe Int is a concrete type, 
but Maybe is a type constructor that takes one type as the parameter. 
Anyway, we see that fmap takes a function from one type to another and 
a functor applied with one type and returns a functor applied with another type.

If this sounds a bit confusing, don't worry. 
All will be revealed soon when we check out a few examples. 
Hmm, this type declaration for fmap reminds me of something. 
If you don't know what the type signature of map is, it's: map :: (a -> b) -> [a] -> [b].

Ah, interesting! 
It takes a function from one type to another and a list of one type and returns a list of another type. 
My friends, I think we have ourselves a functor! 
In fact, map is just a fmap that works only on lists. 
Here's how the list is an instance of the Functor typeclass.

instance Functor [] where  
    fmap = map  

That's it! 
Notice how we didn't write instance Functor [a] where, 
because from fmap :: (a -> b) -> f a -> f b, 
we see that the f has to be a type constructor that takes one type. 
[a] is already a concrete type (of a list with any type inside it), 
while [] is a type constructor that takes one type and can produce types such as [Int], [String] or even [[String]].

Since for lists, fmap is just map, we get the same results when using them on lists.

map :: (a -> b) -> [a] -> [b]  
ghci> fmap (*2) [1..3]  
[2,4,6]  
ghci> map (*2) [1..3]  
[2,4,6]  

What happens when we map or fmap over an empty list? 
Well, of course, we get an empty list. 
It just turns an empty list of type [a] into an empty list of type [b].

Types that can act like a box can be functors. 
You can think of a list as a box that has an infinite amount of little compartments and they can all be empty, 
one can be full and the others empty or a number of them can be full. 
So, what else has the properties of being like a box? 
For one, the Maybe a type. 
In a way, it's like a box that can either hold nothing, 
in which case it has the value of Nothing, 
or it can hold one item, like "HAHA", 
in which case it has a value of Just "HAHA". 
Here's how Maybe is a functor.

instance Functor Maybe where  
    fmap f (Just x) = Just (f x)  
    fmap f Nothing = Nothing  

Again, notice how we wrote instance Functor Maybe where instead of instance Functor (Maybe m) where, 
like we did when we were dealing with Maybe and YesNo. 
Functor wants a type constructor that takes one type and not a concrete type. 
If you mentally replace the fs with Maybes, 
fmap acts like a (a -> b) -> Maybe a -> Maybe b for this particular type, which looks OK. 
But if you replace f with (Maybe m), 
then it would seem to act like a (a -> b) -> Maybe m a -> Maybe m b, 
which doesn't make any damn sense because Maybe takes just one type parameter.

Anyway, the fmap implementation is pretty simple. 
If it's an empty value of Nothing, then just return a Nothing. 
If we map over an empty box, we get an empty box. 
It makes sense. 
Just like if we map over an empty list, we get back an empty list. 
If it's not an empty value, but rather a single value packed up in a Just, 
then we apply the function on the contents of the Just.

ghci> fmap (++ " HEY GUYS IM INSIDE THE JUST") (Just "Something serious.")  
Just "Something serious. HEY GUYS IM INSIDE THE JUST"  
ghci> fmap (++ " HEY GUYS IM INSIDE THE JUST") Nothing  
Nothing  
ghci> fmap (*2) (Just 200)  
Just 400  
ghci> fmap (*2) Nothing  
Nothing  

Another thing that can be mapped over and made an instance of Functor is our Tree a type. 
It can be thought of as a box in a way (holds several or no values) 
and the Tree type constructor takes exactly one type parameter. 
If you look at fmap as if it were a function made only for Tree, 
its type signature would look like (a -> b) -> Tree a -> Tree b. 
We're going to use recursion on this one. 
Mapping over an empty tree will produce an empty tree. 
Mapping over a non-empty tree will be a tree consisting of 
our function applied to the root value and 
its left and right sub-trees will be the previous sub-trees, 
only our function will be mapped over them.

instance Functor Tree where  
    fmap f EmptyTree = EmptyTree  
    fmap f (Node x leftsub rightsub) = Node (f x) (fmap f leftsub) (fmap f rightsub)  

ghci> fmap (*2) EmptyTree  
EmptyTree  
ghci> fmap (*4) (foldr treeInsert EmptyTree [5,7,3,2,1,7])  
Node 28 (Node 4 EmptyTree (Node 8 EmptyTree (Node 12 EmptyTree (Node 20 EmptyTree EmptyTree)))) EmptyTree  

Nice! Now how about Either a b? Can this be made a functor? 
The Functor typeclass wants a type constructor that takes only one type parameter but Either takes two. 
Hmmm! I know, we'll partially apply Either by feeding it only one parameter so that it has one free parameter. 
Here's how Either a is a functor in the standard libraries:

instance Functor (Either a) where  
    fmap f (Right x) = Right (f x)  
    fmap f (Left x) = Left x  

Well well, what did we do here? 
You can see how we made Either a an instance instead of just Either. 
That's because Either a is a type constructor that takes one parameter, whereas Either takes two. 
If fmap was specifically for Either a, 
the type signature would then be (b -> c) -> Either a b -> Either a c because that's the same as (b -> c) -> (Either a) b -> (Either a) c. 
In the implementation, 
we mapped in the case of a Right value constructor, 
but we didn't in the case of a Left. 
Why is that? Well, if we look back at how the Either a b type is defined, it's kind of like:

data Either a b = Left a | Right b  

Well, if we wanted to map one function over both of them, 
a and b would have to be the same type. 
I mean, if we tried to map a function that takes a string and returns a string 
and the b was a string but the a was a number, that wouldn't really work out. 
Also, from seeing what fmap's type would be if it operated only on Either values, 
we see that the first parameter has to remain the same 
while the second one can change 
and the first parameter is actualized by the Left value constructor.

This also goes nicely with our box analogy 
if we think of the Left part as sort of an empty box with an error message 
written on the side telling us why it's empty.

Maps from Data.Map can also be made a functor because 
they hold values (or not!). 
In the case of Map k v, 
fmap will map a function v -> v' over a map of type Map k v 
and return a map of type Map k v'.

Note, the ' has no special meaning in types 
just like it doesn't have special meaning when naming values.
It's used to denote things that are similar, only slightly changed.
Try figuring out how Map k is made an instance of Functor by yourself!

With the Functor typeclass, 
we've seen how typeclasses can represent pretty cool higher-order concepts. 
We've also had some more practice with partially applying types and making instances. 
In one of the next chapters, we'll also take a look at some laws that apply for functors.

Just one more thing! 
Functors should obey some laws so that they may have 
some properties that we can depend on and not think about too much. 
If we use fmap (+1) over the list [1,2,3,4], 
we expect the result to be [2,3,4,5] and not its reverse, [5,4,3,2]. 
If we use fmap (\a -> a) 
(the identity function, which just returns its parameter) over some list, 
we expect to get back the same list as a result. 
For example, if we gave the wrong functor instance to our Tree type, 
using fmap over a tree where 
the left sub-tree of a node only has elements that are smaller than the node 
and the right sub-tree only has nodes that are larger than the node 
might produce a tree where that's not the case. 
We'll go over the functor laws in more detail in one of the next chapters.
    
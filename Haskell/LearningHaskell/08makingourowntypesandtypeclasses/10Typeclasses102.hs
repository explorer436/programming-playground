So far, we've learned about some of the standard Haskell typeclasses 
and we've seen which types are in them. 
We've also learned how to automatically make our own types 
instances of the standard typeclasses by asking Haskell to 
derive the instances for us. 
In this section, 
we're going to learn how to make our own typeclasses and 
how to make types instances of them by hand.

A quick recap on typeclasses: typeclasses are like interfaces. 
A typeclass defines some behavior 
(like comparing for equality, comparing for ordering, enumeration) 
and then types that can behave in that way are made instances of that typeclass. 
The behavior of typeclasses is achieved by 
defining functions or just type declarations that we then implement. 
So when we say that a type is an instance of a typeclass, 
we mean that we can use the functions that the typeclass defines with that type.

Typeclasses have pretty much nothing to do with classes in languages like Java or Python. 
This confuses many people, 
so I want you to forget everything you know about classes in imperative languages right now.

For example, 
the Eq typeclass is for stuff that can be equated. 
It defines the functions == and /=. 
If we have a type (say, Car) and 
comparing two cars with the equality function == makes sense, 
then it makes sense for Car to be an instance of Eq.

This is how the Eq class is defined in the standard prelude:

class Eq a where  
    (==) :: a -> a -> Bool  
    (/=) :: a -> a -> Bool  
    x == y = not (x /= y)  
    x /= y = not (x == y)  
    
Woah, woah, woah! Some new strange syntax and keywords there! 
Don't worry, this will all be clear in a second. 
First off, when we write class Eq a where, 
this means that we're defining a new typeclass and that's called Eq. 
The a is the type variable and 
it means that a will play the role of the type that we will soon be making an instance of Eq. 
It doesn't have to be called a, 
it doesn't even have to be one letter, 
it just has to be a lowercase word. 
Then, we define several functions. 
It's not mandatory to implement the function bodies themselves, 
we just have to specify the type declarations for the functions.

Some people might understand this better if we wrote 
class Eq equatable where 
and then specified the type declarations like (==) :: equatable -> equatable -> Bool.

Anyway, we did implement the function bodies for the functions that Eq defines, 
only we defined them in terms of mutual recursion. 
We said that two instances of Eq are equal if they are not different and they are different if they are not equal. 
We didn't have to do this, really, 
but we did and we'll see how this helps us soon.

If we have say class Eq a where 
and then define a type declaration within that class like (==) :: a -> -a -> Bool, 
then when we examine the type of that function later on, 
it will have the type of (Eq a) => a -> a -> Bool.
So once we have a class, what can we do with it? 
Well, not much, really. 
But once we start making types instances of that class, 
we start getting some nice functionality. 

So check out this type:

data TrafficLight = Red | Yellow | Green  

It defines the states of a traffic light. 
Notice how we didn't derive any class instances for it. 
That's because we're going to write up some instances by hand, 
even though we could derive them for types like Eq and Show. 
Here's how we make it an instance of Eq.

instance Eq TrafficLight where  
    Red == Red = True  
    Green == Green = True  
    Yellow == Yellow = True  
    _ == _ = False  

We did it by using the instance keyword. 
So class is for defining new typeclasses and instance is for making our types instances of typeclasses. 
When we were defining Eq, 
we wrote class Eq a where 
and we said that a plays the role of whichever type will be made an instance later on. 
We can see that clearly here, 
because when we're making an instance, we write instance Eq TrafficLight where. 
We replace the a with the actual type.

Because == was defined in terms of /= and vice versa in the class declaration, 
we only had to overwrite one of them in the instance declaration. 
That's called the minimal complete definition for the typeclass — 
the minimum of functions that we have to implement so that our type can behave like the class advertises. 
To fulfill the minimal complete definition for Eq, 
we have to overwrite either one of == or /=. 

If Eq was defined simply like this:

class Eq a where  
    (==) :: a -> a -> Bool  
    (/=) :: a -> a -> Bool  
    
we'd have to implement both of these functions when making a type an instance of it, 
because Haskell wouldn't know how these two functions are related. 
The minimal complete definition would then be: both == and /=.

You can see that we implemented == simply by doing pattern matching. 
Since there are many more cases where two lights aren't equal, 
we specified the ones that are equal and then 
just did a catch-all pattern saying that if it's none of the previous combinations, 
then two lights aren't equal.

Let's make this an instance of Show by hand, too. 
To satisfy the minimal complete definition for Show, 
we just have to implement its show function, 
which takes a value and turns it into a string.

instance Show TrafficLight where  
    show Red = "Red light"  
    show Yellow = "Yellow light"  
    show Green = "Green light"  
    
Once again, we used pattern matching to achieve our goals. 
Let's see how it works in action:

ghci> Red == Red  
True  
ghci> Red == Yellow  
False  
ghci> Red `elem` [Red, Yellow, Green]  
True  
ghci> [Red, Yellow, Green]  
[Red light,Yellow light,Green light]  

Nice. We could have just derived Eq and it would have had the same effect 
(but we didn't for educational purposes). 
However, deriving Show would have just directly translated the value constructors to strings. 
But if we want lights to appear like "Red light", 
then we have to make the instance declaration by hand.

You can also make typeclasses that are subclasses of other typeclasses. 
The class declaration for Num is a bit long, but here's the first part:

class (Eq a) => Num a where  
   ...    

As we mentioned previously, there are a lot of places where we can cram in class constraints. 
So this is just like writing class Num a where, 
only we state that our type a must be an instance of Eq. 
We're essentially saying that we have to make a type an instance of Eq before we can make it an instance of Num. 
Before some type can be considered a number, 
it makes sense that we can determine whether values of that type can be equated or not. 
That's all there is to subclassing really, 
it's just a class constraint on a class declaration! 
When defining function bodies in the class declaration or when defining them in instance declarations, 
we can assume that a is a part of Eq and so we can use == on values of that type.

But how are the Maybe or list types made as instances of typeclasses? 
What makes Maybe different from, say, TrafficLight is that 
Maybe in itself isn't a concrete type, 
it is a type constructor that takes one type parameter (like Char or something) 
to produce a concrete type (like Maybe Char). 
Let's take a look at the Eq typeclass again:

class Eq a where  
    (==) :: a -> a -> Bool  
    (/=) :: a -> a -> Bool  
    x == y = not (x /= y)  
    x /= y = not (x == y)   
    
From the type declarations, 
we see that the a is used as a concrete type because all the types in functions have to be concrete 
(remember, you can't have a function of the type a -> Maybe but you can have a function of a -> Maybe a or Maybe Int -> Maybe String). 
That's why we can't do something like

instance Eq Maybe where  
    ...    
    
Because like we've seen, 
the a has to be a concrete type but Maybe isn't a concrete type. 
It's a type constructor that takes one parameter and then produces a concrete type. 
It would also be tedious to write instance Eq (Maybe Int) where, instance Eq (Maybe Char) where, etc. for every type ever. 
So we could write it out like so:

instance Eq (Maybe m) where  
    Just x == Just y = x == y  
    Nothing == Nothing = True  
    _ == _ = False  
        
This is like saying that we want to make all types of the form Maybe something an instance of Eq. 
We actually could have written (Maybe something), but we usually opt for single letters to be true to the Haskell style. 
The (Maybe m) here plays the role of the a from class Eq a where. 
While Maybe isn't a concrete type, Maybe m is. 
By specifying a type parameter (m, which is in lowercase), 
we said that we want all types that are in the form of Maybe m, where m is any type, to be an instance of Eq.

There's one problem with this though. 
Can you spot it? 
We use == on the contents of the Maybe but we have no assurance that what the Maybe contains can be used with Eq! 
That's why we have to modify our instance declaration like this:

instance (Eq m) => Eq (Maybe m) where  
    Just x == Just y = x == y  
    Nothing == Nothing = True  
    _ == _ = False  
        
We had to add a class constraint! 
With this instance declaration, we say this: 
we want all types of the form Maybe m to be part of the Eq typeclass, 
but only those types where the m (so what's contained inside the Maybe) is also a part of Eq. 
This is actually how Haskell would derive the instance too.

Most of the times, 
class constraints in class declarations are used for making a typeclass a subclass of another typeclass and 
class constraints in instance declarations are used to express requirements about the contents of some type. 
For instance, here we required the contents of the Maybe to also be part of the Eq typeclass.

When making instances, 
if you see that a type is used as a concrete type in the type declarations (like the a in a -> a -> Bool), 
you have to supply type parameters and add parentheses so that you end up with a concrete type.

Take into account that the type you're trying to make an instance of 
will replace the parameter in the class declaration. 
The a from class Eq a where will be replaced with a real type when you make an instance, 
so try mentally putting your type into the function type declarations as well. 
(==) :: Maybe -> Maybe -> Bool doesn't make much sense but (==) :: (Eq m) => Maybe m -> Maybe m -> Bool does. 
But this is just something to think about, 
because == will always have a type of (==) :: (Eq a) => a -> a -> Bool, no matter what instances we make.
Ooh, one more thing, check this out! 
If you want to see what the instances of a typeclass are, just do :info YourTypeClass in GHCI. 
So typing :info Num will show which functions the typeclass defines 
and it will give you a list of the types in the typeclass. 
:info works for types and type constructors too. 
If you do :info Maybe, it will show you all the typeclasses that Maybe is an instance of. 
Also :info can show you the type declaration of a function. I think that's pretty cool.
        
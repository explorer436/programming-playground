In JavaScript and some other weakly typed languages, 
you can put almost anything inside an if expression. 
For example, you can do all of the following: 
if (0) alert("YEAH!") else alert("NO!"), 
if ("") alert ("YEAH!") else alert("NO!"), 
if (false) alert("YEAH") else alert("NO!), etc. 
and all of these will throw an alert of NO!. 
If you do if ("WHAT") alert ("YEAH") else alert("NO!"), 
it will alert a "YEAH!" because JavaScript considers non-empty strings to be a sort of true-ish value.

Even though strictly using Bool for boolean semantics works better in Haskell, 
let's try and implement that JavaScript-ish behavior anyway. 
For fun! Let's start out with a class declaration.

class YesNo a where  
    yesno :: a -> Bool  
    
Pretty simple. The YesNo typeclass defines one function. 
That function takes one value of a type that can be considered to hold some concept of true-ness 
and tells us for sure if it's true or not. 
Notice that from the way we use the a in the function, a has to be a concrete type.

Next up, let's define some instances. 
For numbers, we'll assume that (like in JavaScript) any number that isn't 0 is true-ish and 0 is false-ish.

instance YesNo Int where  
    yesno 0 = False  
    yesno _ = True  
    
Empty lists (and by extensions, strings) are a no-ish value, 
while non-empty lists are a yes-ish value.

instance YesNo [a] where  
    yesno [] = False  
    yesno _ = True  
    
Notice how we just put in a type parameter a in there to make the list a concrete type, 
even though we don't make any assumptions about the type that's contained in the list. 
What else, hmm ... I know, 
Bool itself also holds true-ness and false-ness and it's pretty obvious which is which.

instance YesNo Bool where  
    yesno = id     
    
Huh? What's id? 
It's just a standard library function that takes a parameter and returns the same thing, 
which is what we would be writing here anyway.

Let's make Maybe a an instance too.

instance YesNo (Maybe a) where  
    yesno (Just _) = True  
    yesno Nothing = False  
    
We didn't need a class constraint because we made no assumptions about the contents of the Maybe. 
We just said that it's true-ish if it's a Just value and false-ish if it's a Nothing. 
We still had to write out (Maybe a) instead of just Maybe because if you think about it, 
a Maybe -> Bool function can't exist (because Maybe isn't a concrete type), 
whereas a Maybe a -> Bool is fine and dandy. 
Still, this is really cool because now, any type of the form Maybe something is part of YesNo 
and it doesn't matter what that something is.

Previously, we defined a Tree a type, that represented a binary search tree. 
We can say an empty tree is false-ish and anything that's not an empty tree is true-ish.

instance YesNo (Tree a) where  
    yesno EmptyTree = False  
    yesno _ = True  
    
Can a traffic light be a yes or no value? 
Sure. If it's red, you stop. If it's green, you go. If it's yellow? 
Eh, I usually run the yellows because I live for adrenaline.

instance YesNo TrafficLight where  
    yesno Red = False  
    yesno _ = True  
    
Cool, now that we have some instances, let's go play!

ghci> yesno $ length []  
False  
ghci> yesno "haha"  
True  
ghci> yesno ""  
False  
ghci> yesno $ Just 0  
True  
ghci> yesno True  
True  
ghci> yesno EmptyTree  
False  
ghci> yesno []  
False  
ghci> yesno [0,0,0]  
True  
ghci> :t yesno  
yesno :: (YesNo a) => a -> Bool  

Right, it works! 
Let's make a function that mimics the if statement, but it works with YesNo values.

yesnoIf :: (YesNo y) => y -> a -> a -> a  
yesnoIf yesnoVal yesResult noResult = if yesno yesnoVal then yesResult else noResult
  
Pretty straightforward. It takes a yes-no-ish value and two things. 
If the yes-no-ish value is more of a yes, it returns the first of the two things, otherwise it returns the second of them.

ghci> yesnoIf [] "YEAH!" "NO!"  
"NO!"  
ghci> yesnoIf [2,3,4] "YEAH!" "NO!"  
"YEAH!"  
ghci> yesnoIf True "YEAH!" "NO!"  
"YEAH!"  
ghci> yesnoIf (Just 500) "YEAH!" "NO!"  
"YEAH!"  
ghci> yesnoIf Nothing "YEAH!" "NO!"  
"NO!"  
    
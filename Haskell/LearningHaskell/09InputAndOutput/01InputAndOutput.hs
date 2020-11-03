Input and Output

We've mentioned that Haskell is a purely functional language. 
Whereas in imperative languages you usually get things done by 
giving the computer a series of steps to execute, 
functional programming is more of defining what stuff is. 
In Haskell, a function can't change some state, 
like changing the contents of a variable 
(when a function changes state, we say that the function has side-effects). 
The only thing a function can do in Haskell is 
give us back some result based on the parameters we gave it. 
If a function is called two times with the same parameters, 
it has to return the same result. 
While this may seem a bit limiting when you're coming from an imperative world, 
we've seen that it's actually really cool. 
In an imperative language, 
you have no guarantee that a simple function 
that should just crunch some numbers won't burn down your house, 
kidnap your dog and scratch your car with a potato while crunching those numbers. 
For instance, 
when we were making a binary search tree, 
we didn't insert an element into a tree by modifying some tree in place. 
Our function for inserting into a binary search tree actually returned a new tree, 
because it can't change the old one.

While functions being unable to change state is good 
because it helps us reason about our programs, 
there's one problem with that. 
If a function can't change anything in the world, 
how is it supposed to tell us what it calculated? 
In order to tell us what it calculated, 
it has to change the state of an output device 
(usually the state of the screen), 
which then emits photons that travel to our brain and change the state of our mind, man.

Do not despair, all is not lost. 
It turns out that Haskell actually has a really clever system 
for dealing with functions that have side-effects 
that neatly separates the part of our program that is pure 
and the part of our program that is impure, 
which does all the dirty work like talking to the keyboard and the screen. 
With those two parts separated, 
we can still reason about our pure program and 
take advantage of all the things that purity offers, 
like laziness, robustness and modularity 
while efficiently communicating with the outside world.

Lists - not arrays

An important point to keep at the back-of-your-mind (for now), is that C/Java arrays do not correspond 1:1 with the [Int], [Float], [Bool], etc. in Haskell. 
In C/Java, usually when you declare an array a continuous area in memory is reserved for it. 
This makes index-based lookups really efficient, because the n-th element in array can simply be looked-up via pointer arithmetic.

However, dynamically growing or shrinking an array at run-time becomes an expensive operation because a new contiguous region of memory must be reserved and the shrunk/grown array must be copied into the new region. 
In fact, the C language doesn’t really have a buit-in way to dynamically grow/shrink an array at runtime. 
You have to resort to manual memory management, or use a special library to do this for you.

However, in Haskell a list is literally a linked list internally. 
Thankfully, you don’t have to traverse the linked list manually - 
the language takes care of all of this plumbing, giving you a very simple interface to do a variety of operations on your list, 
eg. add an element, remove an element, lookup an element by index, find an element within a list, etc.

Having a list, as opposed to an array, means index-based lookups are inefficient. 
This is becasue, to lookup the n-th element, one needs to traverse all (n - 1) elements till n-th element is reached. 
On the other hand, appending an element to the beginning of a list is an extremely efficient operation.

For this chapter, we will be using lists to solve all our problems because efficiency is not our main concern. 
However, in a real-world Haskell program if it is established (or anticipated) that using lists will slow down the program, Data.Vector can be used instead.

Lists must contain elements of the same type

Another important difference between Haskell lists and arrays in dynamic languages, like Ruby, Javascript, and Python, is that, in Haskell, all elements in a list must be of the same type. 

It should be noted that data-structures that deal with collection of differently-typed elements do exist in Haskell. 
It’s just that they aren’t lists and we will be covering them later.

If there is a necessity for accessing any element in the datastructure in linear time, arrays must be used.
Take a look at LinearTimeSort.hs for an example.

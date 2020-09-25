Functional vs. Procedural Programming Languages

Procedural Programming:

These include C, C++, Fortran, Pascal, and Basic (See wikipedia for a complete list).

A procedural program is written as a list of instructions, telling the computer, step-by-step, what to do: Open a file, read a number, multiply by 4, display something. Program units include the main or program block, subroutines, functions, procedures; file scoping; includes/modules; libraries.

Procedural programming is fine for small projects. It is the most natural way to tell a computer what to do, and the computer processor's own language, machine code, is procedural, so the translation of the procedural high-level language into machine code is straightforward and efficient. What is more, procedural programming has a built-in way of splitting big lists of instructions into smaller lists: the function.


Functional Programming:

Functional programming languages emphasize rules and pattern-matching. While they appear non-intuitive to those who have only experienced procedural languages, they provide succinct and natural programming structures for those who gain some experience. Functional programming is particularly useful for mathematical work, where the notion of ``function'' is already a well established concept.

It was true that functional programs generally ran more slowly than procedural programs. However, runtime is not the whole story in terms of efficiency. The time it takes to develop code, and even more importantly, to modify programs, is substantially faster for functional programs than for procedural programs. This is important for protyping and carrying out exploratory research.

An additional factor that needs to be taken into account when evaluating the efficiency of a language for computer simulation work is related to what computing tasks are going to be carried out.

Functional programming constructs allow you to do many things in one line that would normally take several loops in other languages. When you add Fold[] and Nest[] into the mix, you can do some pretty powerful things in a couple of lines... 

Remember, ``if you aren't programming functionally, you're programming dysfunctionally''!

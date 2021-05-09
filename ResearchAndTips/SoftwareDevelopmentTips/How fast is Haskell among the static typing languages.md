How fast is Haskell among the static typing languages?
https://stackoverflow.com/questions/57619666/how-fast-is-haskell-among-the-static-typing-languages

Carlton Mills, lives in Urbana, IL

One can assume that Haskell with optimization turned on will be close to C/C++ in speed. Usually not faster but close. However in Exploiting Vector Instructions with Generalized Stream Fusion (https://www.microsoft.com/en-us/research/wp-content/uploads/2016/07/haskell-beats-C.pdf) the authors’ Haskell numeric programs are faster than C. The speed up is striking when running with multi-cores.

Intel did a research code generator for Haskell where Haskell programs were faster than hand coded C; both using the Intel vector instructions.

It is true that a Haskell program with compiler optimization turned off can be world class in slowness - in sometimes making Ruby look like a speed demon.
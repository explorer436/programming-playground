What is Haskell actually useful for?

Aaron Christianson · Updated November 10 I like to write programs--little ones.

It’s kind of shocking that other answers neglect to mention the thing that Haskell is most useful for—and indeed, the thing it was created for.

Aside from those things that others mention, Haskell is supremely useful for programming language research, which is a real thing that large tech companies spend millions of dollars on.

Haskell was artificially constrained to pure functions and lazy evaluation as an experiment. This was quite rough at first. In the beginning, a Haskell program was a function that took text as input and produced text as output and did absolutely nothing else. You can write some interesting programs in this way (such as compilers), but it makes it difficult to write a lot of other things (like a web server). The performance was also not great because the obvious way to approach lazy evaluation is not very performant.

Over time, Haskell changed. There was an awkward middle phase where the output of the program was a series of instructions which the computer would execute, so Haskell was basically a purely functional language for generating imperative programs for a bit there.

Eventually, Haskell’s laziness was reimplemented in terms of graph rewriting (don’t ask me how), which made it much faster, and the language finally settled on monadic effects as the way to write useful programs while still being a (kind of) purely functional language. Basically it calls out to runtime libraries in another language (normally C) to perform the actual effects, but it wraps the whole process up in monads so effects can be represented as values on the Haskell side to keep the effects from “contaminating” the rest of the language.

This approach of representing effects in the type system has actually been quite a big deal in programming language research and elements of it have started to trickle into industrial languages such as Rust, where mutation is represented by and constrained on type, making data races impossible in the language.

Along the same line, Haskell also popularized using monadic optional types and result types, which seem to be featured in every new statically typed language that comes out these days. This is in part because Haskell’s type system supports high-order polymorphism (i.e. type constructors can be represented as variables), which makes it possible to design and experiment with categories of abstraction that are normally hard-coded in other languages.

Haskell does have industrial applications as well that other answers mention, but that’s simply a, uh, “side effect” of it being tuned over decades as a research language—an area in which it has been extremely successful and influential.


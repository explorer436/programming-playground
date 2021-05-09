What did Jon Von Neumann contribute to computers in contrast to Alan Turing?

------------------------

Alan Kay , Still trying to learn how to think better Updated June 27 · Upvoted by David Joyce , studied Mathematics & Computer Science at University of Michigan (1973)

Alan Turing in the mid 30s explored computability*, which was triggered by interest in Goedel’s demonstration that most interesting systems of logic were not completely decidable.

Turing did this by inventing a thought experiment that could do the simple human actions of following a limited form of recipe and writing and reading marks on a “tape” (like a long strip of paper).

The most important of the results showed that a very simple machine was capable of simulating *any* machine (this is called a “Universal Turing Machine”, and many very simple versions were subsequently devised).

Von Neumann was one of the great mathematicians of his day. During WWII both he (in the US) and Turing (in the UK codebreaking project) separately got involved with mathematics and machines that could “do math”.

It wasn’t just von Neumann who realized that Turing’s thesis model actually could make a lot of sense as a physical computer. This because the equivalent of the “tape” (some form of “memory”) — can be a lot cheaper than the recipe following hardware — which could then be made as small as possible because more complex computers could be emulated.

But von Neumann’s influence in pushing this idea was very important in getting some of the first programmable computers to be developed after WWII.

(There had already been several examples: in Germany by Zuse, and in the US by Atanasoff-Berry).

And in the US progress was slow enough so that Maurice Wilkes from the UK who had attended the seminars in the US, decided to “just do one”, and this resulted in the EDSAC at Cambridge ca. end of ‘48 (which is my vote for the first available programmable computer**)

In practice, the “simple logic” part of these early computers was made much more complex than Turing’s theories demanded. This is because everything was really s l o w , especially given the memory technologies available. This got the designers to want to put more into the fixed part of the machine and do less emulation using the “tape”.

This mismatch of speeds is still the case. The intermediate ground of making the fixed part of the machine be an emulator has been a very good solution (it made the work at Xerox Parc possible), but is oddly not found in most commercial CPUs. This has affected many things adversely, including software development, design of higher level programming languages, etc.

------------------------

Dave Chapman Answered June 26

Turing worked on fundamental questions in the 1930s, questions like:

-Is it possible to build a machine which “does math”?

-Is it possible to build a “machine which thinks”?

-Are there problems which cannot, in principle, be solved by a computer?

He also designed the “Turing Machine”, which was originally only a theory, and whose main purpose was to explore the set of functions which a computer could perform. The Turing Machine was wildly impractical. AFAIK, nobody built one during Turing’s lifetime.

von Neumann, on the other hand, had a major role in building the early practical computers, and especially the “von Neumann Architecture”. Most of this work took place in the 1940s. Over 99% of the computers in the world today use the von Neumann Architecture.

Many people consider von Neumann to have been the greatest Mathematician of the 20th century (I personally was very impressed with his “Monte Carlo” algorithms), but he is mainly remembered for his work on computers.

------------------------

Ian Joyner Answered July 19

Adding to Jeff Drobman’s answer – Turing describes the what (descriptive) and Von Neumann the how (prescriptive). So Turing describes the logical concept and Von Neumann the implementation.

Many things taught about computer architecture are implementation, such as memory hierarchy. These are taught as essential to computing, but they are not and Turing’s computational model “says no” (sounding like Little Britain now!).

I think that gives us great scope to reimagine computing. Many things in computing turn out to be skeuomorphic historical constraints that should no longer be relevant.

------------------------

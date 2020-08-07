Andrii Melnykov
·
September 26, 2019
10+ years of PM and technical leadership

Why do programmers use Haskell when there are simpler languages available to them?

Why don’t everybody use shovels to dig? The same idea applies here. Simplicity is not a good argument - more complex tools offer more than just complexity.

I think you experience what I experienced with learning Haskell. There was a phase I called “fighting with the type checker”. It was very hard to me to produce small code which does compile without errors. This is pretty similar to trying to use an excavator for the first time. Unfortunately, in case of Haskell this phase lasts pretty long - months to years.

But when you finally get it (note that in case of Haskell there are several milestones of getting it) then the language doesn’t hinder your productivity anymore.

Unfortunately, in case of Haskell the main performance boost comes from the fact that it’s interesting to code. This also explains the fact that too few projects in Haskell ever get completed - often the author (there are very few projects with more than 1 author) abandons the project completely when the main coding fun is over and it’s time to fix bugs, improve performance and implement the least interesting features.

So yes, people choose Haskell because it isn’t too complex to slow them down, and because it offers several advantages ranging from fun to improved expressiveness and lack of boilerplate.

For me, the Go language is very simple, but due to lack of expressiveness (you can’t express a monoid in their type system - are they serious??) the amount of boilerplate is excruciating when you know what is possible in more complex languages.


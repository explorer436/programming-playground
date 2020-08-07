What is Haskell used for?
Tikhon Jelvis

Updated September 30, 2019 professional Haskeller Originally Answered: Why do we use Haskell programming?

I use Haskell because it gives me the best combination of expressiveness and maintainability of any language I have ever tried. And I’ve tried a lot of languages!

The practical upside is simple: Haskell lets me write the code I want the way I want and still maintain it years later. In a lot of languages—the Javas, Pythons and Gos of the world—I have to take a problem and meld it to fit the language; in Haskell, I can meld my language to fit the problem. Haskell lets me cleanly express exactly the abstractions I need (even when the abstractions get abstract) and is a wonderfully capable host for domain-specific languages too.

And yet, despite the language’s power, my codebase does not turn into a big ball of mud

. If anything, it’s the opposite: Haskell gives me the tools to design codebases that are better-factored and better-organized than code I write in any other language. Haskell’s design naturally pushes me to organize my code with more care, especially around separating logic from execution and effects.

This last note is probably the single most important idea I’ve learned using Haskell, and it’s an idea that now underpins my design philosophy in any language. Despite having this mindset across languages, my Haskell code is still consistently better-factored and more easily testable than code I write in any other language.

I can go back to the first Haskell project I ever wrote

(an interpreter for a little language I designed) and still comfortably read the code. It’s not written to the standard I have today—especially in terms of documentation!—but I would have no problems supporting or extending that code, even though it’s been six years since I’ve touched the codebase at all.

This isn’t new. I wrote a review of Haskell back when Quora had a review feature saying exactly the same things. That was, what, six years ago? Hard to believe, but the date on the post doesn’t lie! Where did all that time go?

But I digress.

The point is that my view of Haskell has not changed substantially. The older, more experienced Tikhon of 2019 stands by what the Tikhon of 2013 wrote wholeheartedly.

The intervening years have been busy: I’ve progressed in my skills as a software engineer and worked on larger and larger projects in a variety of languages¹, and Haskell is still my goto for personal projects. I don’t always choose Haskell, but I need a strong reason to choose anything else.

footnotes
¹ In the past six years, I’ve worked on non-trivial, team-based projects in Haskell, OCaml, TypeScript, Java, Rust and Python. I like to think I have more context for evaluating Haskell as a language than that of a pure Haskell user.

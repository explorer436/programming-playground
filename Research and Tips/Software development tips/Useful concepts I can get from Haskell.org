What are the most useful concepts I can get from Haskell FP and still be useful in other FP impure languages?

Aaron Christianson · June 29 Software Developer at Goethe University Frankfurt (2016–present)

The separation of Church and state.

This refers to a quip Guy Steele

(one of the greatest PL gurus of our time) made about Haskell:

    Some people prefer not to commingle the functional, lambda-calculus part of a language with the parts that do side effects. It seems they believe in the separation of Church and state.

The “Church” in question is Alonzo Church, the creator of the Lambda Calculus, doctoral advisor of Alan Turing, and a forefather of functional programming.

The cool thing about Haskell Is that it places a sort of “monadic iron curtain” of separation between code that preforms effects (code that changes the universe) and pure functional code that simply maps input values to output values.

While using this system takes some time to get used to, monadic effects are one of the favorite features of Haskell users. It may be impractical at times, but keeping effectful code and pure code separate is actually great practice in any language and greatly simplifies debugging and testing.

Obviously other languages will rely on effects at times—you can’t built an array without effects, but you can keep those kinds of small effects localized. i.e. you use mutation while building up the array in your function, but any given input will always produce a new array of equal value (without modifying the inputs, of course). Using this kind of approach, a function will not be pure in the strictest sense, but it will be referentially transparent to the caller.

When it comes to I/O, it actually isn’t that difficult to maintain this separation: You just make a rule for yourself: functions that do computation don’t do I/O. You compute your output values in a pure way and return them to a context where the I/O is happening.

In many ways, Haskell uses monads to enforce what should be considered best practice in other languages. Being forced to write code this way in Haskell makes it easier to imagine and deploy these kinds of architectures in other languages.

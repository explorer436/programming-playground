What is so great about Erlang compared to Haskell?

--------------------------------------

Dmytro Sirenko, https://github.com/EarlGray
Answered November 15, 2015
Erlang and Haskell are two quite different beasts.

Haskell is strongly statically typed functional programming in its very pure form (with all its advantages and drawbacks), whereas Erlang is a hybrid of dynamically typed functional programming language with strong logic programming influence on top of a quite elaborated run-time actor system with actor primitives built in the language. Haskell is more of a traditional (and somewhat complicated) general-purpose language, whereas Erlang is more of a (distributed) operating environment with a rather simple language on top of it.

Erlang is prominently great in its distributed niche, since it's built in "the Apple way", so to say: it has the unifying vision of a malleable distributed system throughout its stack. That dictates the language implementation:

no complicated types (that are rather hard to serialize, transmit and synchronize between nodes and software updates);
pervasive pattern-matching that makes sending and receiving complicated messages trivial;
(de-)serialization of everything (including closures!) into sequence of bytes, easily transmittable over a network;
simple, packable language (`erl_parse` and `erl_eval` give it almost Lisp-ish feel), also easy transmittable over a network;
actors primitives, massive concurrency with no node borders;
awesome binary pattern matching that makes network packets parsing almost no-brainer.

Haskell is rather a general purpose language designed to run on top of traditional operating systems on a single node; it is rather a fortunate coincidence that it also has immutability and easy concurrency making concurrent/distributed programming relatively easy. But when you try build a distributed system in Haskell, it looks like a Lego set without manual, you have to rediscover all the trivia that Erlang and BEAM are built around from the start.

On the other hand, Erlang is pretty weak outside its niche: its expressiveness is just okay compared to awesome Haskell ability to abstract and formalize invariants and semantics. In Erlang, I constantly miss Haskell easy lambdas, recursive local definitions and point-free notation. There is no useful way to express more abstract patterns like monads in Erlang and that's quite limiting. The very nature of Erlang makes it rather hard to compile and execute efficiently, whereas Haskell code is very transparent for compiler and optimizer.

The strong sides of Erlang in distributed programming are what it does not have. To create a great programming environment for distributed systems you have to avoid many features that are common in general-purpose programming; Erlang does that perfectly.

--------------------------------------

Stan Hanks, I've forgotten more languages than I use...
Answered November 13, 2015
Erlang was written by telecommunications switch engineers with decades of experience in building systems that never, ever, EVER fail, involving hundreds of thousands of simultaneous connections.

It was designed expressly to make building such systems easier. It was designed expressly to make such systems, when built, easier to debug and maintain.

It is a micro-edge obsidian scalpel, the sharpest knife in the drawer, for this sort of work.

Haskell is nice and all, but it's not Erlang.

--------------------------------------

Bernhard Støcker, Coding in 8 languages
Answered November 13, 2015
Haskell has the reputation to be very academic. What I mean by that is that any kind of sideeffect needs to be encapsulated into a monad. The point with many applications is that a huge part consists of side effects like storing stuff inside a database, calling webrequests to other services. That results in writing more code (boilerplate code) compared to other languages. Erlang is much more pragmatic here. You need a sideeffect like storing something into a db? Or call other services? Great: just do it without encapsulating it (of course you can and writing a separate function is not a bad idea, but I think you get what I mean).

Erlang was created for practical purposes, Haskell not. Don't get me wrong: Haskell is a very interesting language, but in most cases I wouldn't use it inside my production code.

--------------------------------------

Yushi Wang, Learn a lot of different programming languages
Answered November 13, 2015
Erlang's Let it crash! The Erlang Approach to Building Reliable Services is unique in building reliable distributed software.

Erlang was designed with concurrency and reliability in mind. So it is a well polished platform for building heavy loaded, concurrent system. Like the IM software WhatsApp(Only Needs 50 Engineers for Its 900M Users) bought by Facebook for 19 billion, is mainly build with Erlang.

Haskell's lazy evaluation model makes the estimation of the space complexity extremely harder even for senior Haskell programmers. Take the Issue 1858: high memory usage when getting repos of darcs(a distributed version system like git written in Haskell) for example.

--------------------------------------

Alberto Gómez Corona, physicist, programmer
Updated February 3, 2016
Erlang has a well tested distributed architecture that all functional languages try to imitate, but only Erlang and possibly Scala has it in a mature state.

Cloud Haskell is the Erlang distributed architecture codified in Haskell. It offer extra type safety, but this does not offer the justification for switching from Erlang to Haskell since the Erlang platform is much more complete and it has been tested in commercial settings.

But I think that Haskell promises a better distributed architecture, more composable, not based on the actor model but in the haskell abstractions: monad/applicative/alternative. A sort of cloud monad where entire distributed applications can be managed and combined like normal procedures.

This is is something that is being done now, but it is under research.

--------------------------------------


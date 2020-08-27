How is Microsoft able to consistently rally and compete with younger tech giants in cloud computing and software even though it's known to pay software engineers less than Google and Facebook?

Terry Lambert · Updated November 20, 2019 Senior Software Engineer: Novell, Artisoft, IBM, Array Networks, Apple, Google

Why don’t we just lay it out bluntly, shall we?

Note: This will end up offensive to some people, who think a lot more of themselves than I think of them, but so be it.

Being young means being inexperienced.

Microsoft’s primary business, since it started, has been writing operating systems.

Writing operating systems is hard. In fact, it’s not just hard, it’s damn hard,

Harder than most new college graduates had ever had to personally deal with, since many of them were taught using interpreted languages, object oriented paradigms, and garbage collection and automatic scoping.

Even the ones who were not writing the operating system itself — which, even today, if the OS dies, it takes every single program running on the system with it — we’re working without a net.

Windows was not, prior to Windows NT, at its core, a protected mode OS.

A program could touch anything it wanted, and if it touched the wrong thing in the wrong way, or worse, had a bug that made it touch things it wasn’t supposed to, could crash the entire OS, and all the other programs running as well.

Just like an OS crash, except there was a fix for it: “Don’t run that program; it sucks”.

When protected mode operating systems became a “thing” at the consumer level, when a program crashed, instead of blue screening, it would complain about an exception, usually in a library, usually in a library Microsoft wrote, because the programmer handed it bad data.

One of the most brilliant engineers at Microsoft — and I really have absolutely no idea who it was, but I hope he or she is a gazillionaire because of it — walked the crash back one stack frame into the calling program, and reported the program as having caused an exception in the Windows component.

If they gave that person even 0.1% of the money that saved Microsoft in technical support calls, they’d be that gazillionaire. And they’d deserve it.

These people are used to working without a net.

It’s not just that, though.

Until at least about the mid 1990’s, if not later, your tools were out to get you.

It wasn’t intentional, but someone had to work on tools, and if you could work on operating systems, you did, and if you couldn’t, you worked on tools.

And if you couldn’t work on tools, you worked on application programs.

Often, your tools would do broken things, because no one would have ever tested these things, because most of the code which exists today had not been written yet, and so all of the perverse corner cases were sitting there, in the corners, waiting to bite the ankles of some unsuspecting programmer.

I ran into a nifty bug in Turbo C, which I tracked down to a bug in a library function; strcpy(), in fact, and I tried to get them to send me a T-shirt for telling them the bug, and they wouldn’t even consider it, so I didn’t tell them the bug. They got to keep their T-shirt, and they got to keep their bug.

I ran into a Lattice C bug having to do with interior scoping and variables declared inside an interior scope; if the variables didn’t fit into a register, then Lattice C would give them stack space, which was already in use in the parent scope, and cheerfully overwrite it. I guess they didn’t test with more than 3 variables in an interior scope.

I ran into a great little bug in the SunSoft C compiler, which was the reason OSF/Motif wasn’t working on the platform for a long time, and they decided to throw in the towel, and develop OpenLook, instead. It turns out that if you had a variable, and it was in a register, and you pushed the variable to call a function where the variable was being assigned to a function of itself, then when the function returned, it assigned the value of the result of the function into the register. And then popped the old value back in on top of the new value (it was based on the Berkeley portable C compiler, and that compiler was “caller pop” instead of “callee pop”; this became known as “the Berkeley pop order bug”).

These people are used to working without maliciously buggy tools, and having to dig in, at the assembly language level, to debug not just their buggy programs, but the buggy tools they were using to write their buggy programs, which maybe turned out to be not so buggy.

It’s not just that though.

Optimizing compilers didn’t really become a “thing” until at least the mid to late 1990’s. This was mostly driven by the complexities of the RISC architectures, and having to deal with things like SPARC CPU register window spills.

I had, by that point, written a book called “C For Race Car Drivers”, and distributed its photocopies for use as a textbook in a couple of classes at a couple of Universities.

It dealt with how to write C code, such that the compiler would generate good assembly code from it, rather than generating bad assembly code, and what constructs were OK to use with what compilers, and which ones would have you changing the compiler’s diaper because they’d made a mess.

That, of course, lasted until optimizing compilers started to get real.

The compiler companies hired away a lot of OS people, because they needed people who could work at that level of complexity, and its requirements for sheer correctness, which just wasn’t there in tools or applications before that point in time. It was just in the OS.

A lot of these tools people, who needed OS people, were hired at Microsoft.

Even Microsoft’s tools people ended up being as good as OS people.

It’s not just that though.

(You should have expected that, by now).

Even the applications programmers, the ones that made the cut, up until the mid 1990’s, at least, were working in an actively hostile programming environment.

The ones which got hired to work on application, at small companies, too, but at big companies like Novell, or Broderbund, or Electronic Arts, or whoever wasn’t Microsoft?

Those are the ones who survived that actively hostile programming environment, to become gainfully employed writing code.

What this mean?

It means a lot of this has gotten embedded into the older software companies at a genetic level.

It’s like having a pet cat.

“I’m your cat. And ever since you brought me home that day,.. I’ve been plotting to destroy you.”

You can maybe believe that the new cats are soft, and fluffy, and love you, and the scariest thing they do is purr loudly at you while you are trying to sleep.

But.

If you are an old hand, or have been indoctrinated in old hand ways, and schooled in them by Microsoft?

In the back of your mind… buried deep… you know for a fact that the damn things are out to get you, and you just have to make one mistake, and then you’re hoping they find your body before it’s in a closed casket at your funeral.

This is what the younger tech giants are competing with, when they compete with Microsoft.

If someone is doing front end work these days?

Yeah, we used to have the monkeys do the front end work. It doesn’t take a lot of brain power, and you could have someone redo it in a couple of days, if you had to, and some of the monkeys are actually rough hewn actual programmers, just needing a couple of years of indoctrination.

Two Years Before the Mast ought to do it, if it’s going to happen at all.

Honestly, the younger tech giants don’t stand a chance.

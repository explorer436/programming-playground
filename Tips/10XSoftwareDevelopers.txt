John Brothers
·
Updated October 21, 2018
Programmer/Architect w/28 years of professional experience
What do 10x software developers understand that other programmers don't?

I can only truly speak for myself as a 10x developer, and here’s what I believe to be different about me and the other 10x (or even 100x) developers vs my 1–2x peers:

    Understanding how things work.
        I hate “magic” software frameworks and I will spend countless hours making sure I understand what’s going on behind the scenes before I’ll write production software in that system.
        There’s no shame in not understanding how something works and spending time learning it. Even if it takes you longer than your friend.
    Understanding how software and related hardware things fit together.
        Similarly to the above - I hate “magic” systems - I won’t trust myself to work with a system I’m talking to until I understand how it works (at a medium level).
        For example, I learned how to use TCP/IP very early and I really dove in - I wrote clients and servers, hand-wrote HTTP clients and such, because I wanted to prove to myself that I understood how it worked.
    Understanding the business/problem domain well before we design and write software for the domain.
        For example - if I’m working for a company that sells products in stores, I try to understand as much as I can about the business - what types of products, what types of customers, what types of business rules, etc. Especially the first few times you do this, you will be amazed at how much software you can avoid writing to solve problems that won’t exist.
            Note that this is one of the keys to being 10x: don’t write software that you don’t need.
    Identifying and anticipating the most common changes that are likely to be made by our customers, and building our software to support those types of changes, BUT NO OTHERS.
        Many developers think that they’re being smart by abstracting everything, but really, they’re just mimicking more skilled developers without understanding why.
        Anticipating the few most likely changes is smart. 70% of the time, the changes will be in those areas. Trying to design your software to support any possible change is a huge waste of time for everyone.
        This requires experience, which takes time, be patient.
    Not writing software to show off our sophistication, intellect or skill.
        I focus on solving the problem in a clear and understandable way.
        The most likely future reader of my software is me, and after a few weeks, I’ll be completely lost if I didn’t write it clearly the first time.
            If I come back to my software and I find it confusing and complicated, I immediately rewrite it if I can, so it is no longer confusing and complicated.
    Writing our software with the assumption that we won’t remember how it works the next time we look at it.
        I love Test-First Development, because it forces me to think about the software as a client, rather than the developer.
            It also makes my software more modular, because I have to think about the different pieces as individually testable elements.
        I write lots of unit tests where I can.
            Partially because it makes my software better.
            Mostly because I work on so many different software projects over time that whenever there’s a bug 3 months down the road, I can use the unit tests to help re-orient me to the software I’m debugging.

I also have a few personal habits that I’ve developed over time:

    When I was younger, I wrote lots of libraries because I didn’t like the libraries that were out there, they weren’t intuitive enough for me.
        This taught me how the libraries worked, which was really helpful.
        But over time, I grew to accept that it was much more efficient to spend my time understanding the philosophy of the person who wrote the library, rather than writing my own version of it.
            After you do this a few times, you start to recognize the common philosophical approaches, and it cuts down on your learning time for new libraries, which makes you more effective.
    There are douchebags everywhere who will criticize every line of software produced that doesn’t conform to their exact preferred strategy. They will try to make you feel inferior and stupid for not “doing it their way”.
        Almost without exception, they are far better at shaming than they are at software development.
        In other words, to the extent possible, don’t let them take up your time or energy. Just smile, nod and do it your way anyway.
    This is classic “correlation, not causation”, but I spent a lot of time building with Lego when I was younger.
    I try to treat every developer with respect, and am always trying to be modest in my approach, and learn what I can from them, no matter how junior they are, they may have something new to teach me.
        I recognize that calling myself “modest” when also asserting that I am a 10x developer is ironic, but I’ve been doing this for a long time and have consistently been called “one of the best developers I’ve ever worked with”. But there are still countless ways I could be better.

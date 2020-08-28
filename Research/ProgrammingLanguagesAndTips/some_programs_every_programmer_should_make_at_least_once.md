What are some programs every programmer should make at least once?

Jake G Wood , Electrical Engineer (BS/MS), Career Software Developer Answered June 29, 2017

The only code that absolutely every single programmer should write is the code that solves a problem that the programmer finds interesting and results in a useful program for him or her to use.

I’ve watched numerous friends go through books, school semesters and problem sets implementing all these “classic” problems, and slowly but surely many of them get tired of printing “Hello, World”, sorting lists, implementing stacks and heaps, etc. and they go find some other hobby/career. Other friends who build their own website, write some fun app or automate their home with an Arduino are generally hooked on coding for life. Sure, you may argue that the first group has some greater theoretical knowledge of computer architecture and whatnot, but I’d argue (and have seen) that the genuine interest that the second group develops allows them to quickly close that knowledge gap.

Don’t get me wrong - I agree that there are reasons that some of these problems are “classic” and that “everyone” has done them. However, the idea that there is some laundry list of example programs you write and then all the sudden you just “become a programmer” is completely unrealistic. Additionally saying the Linus Torvalds is any less of a programmer because he hasn’t done the Traveling Salesman problem (arbitrary example, no idea whether he has or hasn’t, but you could definitely write a solid OS without knowing that problem/its implications) is equally absurd.

You may say that trying to build a real, useable product/solution right off the bat is too much all at once, but I’d argue that even if you’ve been coding out these theoretical problems and programs for years, the switch to building something real and practical will always be daunting. You’re transitioning from problems that are closed-ended and have well-defined solutions to open-ended problems that will require designing, collaborating and maintaining. When you solve some textbook problem, you’ll tinker with it for a few hours, do some debugging, find your solution and be done. Anything practical that’s useful to yourself and others you’ll constantly be questioning how you can make it better, and forcing yourself to learn to answer those questions.

-----------------------------------

Martin Michelsen , I push buttons for a living.  Answered November 23, 2012 · Upvoted by Eric Johnson , 30 years PC programming experience

Exactly what he/she wants to.

I wouldn't say that there's any program that every programmer should write. Still, I see some overlap of this answer with the other answers here, and I'd guess that those projects mentioned multiple times would be more interesting or more instructive for the average programmer.

For someone interested in systems and infrastructure (like me), I'd recommend experience with:

    Networking. Write a server or two. A simple static-file HTTP server is a good start, or an SMTP server. If you want to get into concurrency, write a multithreaded IM server or game server. For the ambitious, implement a peer-discovery system and make it do something useful - for example, build a serverless local chat service.
    Storage. Build a simple filesystem. FUSE can abstract away the kernel interfaces for you; all you have to do is implement the basic filesystem functions. Flattening a complex directory structure in a consistent, reliable, and expandable way isn't easy, and there are many edge cases to consider.
    Assembly. Even if you never plan to use it in a real project, it's essential to understand how the computer actually works. Write a simple program or algorithm in assembly - quicksort is a good choice. Try to optimize it as much as possible. Implement setjmp() and longjmp() too - these will push you to break the rules you may have learned from higher-level languages.
    OS concepts. Writing malloc() and free() is not as easy as you might think. Have you ever wondered why free() can fail in weird ways when free()ing non-malloc()'d pointers? (You can fix this, but it'll be slow.) Writing a thread scheduler might be overkill, but you'll learn a lot about locking and concurrency.
    Languages. Write a compiler/interpreter for a language. Maybe even design your own language. Generating working code is a good start, but try to optimize the generated code if you can.


For someone interested in game development, I might recommend a different set of expertise:

    Graphics. You want your game to look good. Write some simple OpenGL programs. Make a spinning cube first, then maybe add some sort of interactions with it. Make a particle system that follows some pre-defined rules, and play with rendering methods to make it look like something else (a fiery or smoky plume, or water droplets, for example). What you can display on the screen is limited only by your imagination.
    OS concepts. Games are complex systems, and each piece has to behave in a certain way at a certain time. There's a lot of work to be done that the player doesn't see, but the game always has to be responsive when the player does something.
    Networking. If you want people on different machines to be able to play with or against each other, you'll need to come up with a way for them to communicate. Design a protocol that's fast, but also allows room for expansion as you add new features.
    Security. Players will always try to cheat, and usually security involves staying one step ahead. Try to think of everything players could possibly do with your program, and restrict them to the set of things they should be allowed to do. Some of the techniques involved can be tricky - for example, you can't stop players from reading your game's memory, but you can make it hard to search by moving sensitive data around in memory often.
    Artificial intelligence. Players may want to play with other people, or by themselves (with AIs). I don't have any recommendations here since my AI/ML background is rather lacking.


These are only two examples. Maybe you're interested in data processing or Web design or computer vision, for example, and for each of those there would be a different set of interesting projects and useful skills.

---------------------------------------

Brian Wigginton , Software Developer Answered November 27, 2012

A Port Scanner

As a programmer, it's important to broaden your horizons and learn some new languages every once in a while, and when I'm first trying to pick up a new language I usually try and build a port scanner. The great thing about writing port scanners is that they can be as simple or as complex as you want it to be, and it forces you to learn a lot of different aspects of the language. Here's a quick list of learnings you'll go through while building a port scanner:

    Language Syntax: obviously
    Command Line Interfaces: I usually start by building a simple scanner that runs via the command line. You must learn how to process command line arguments, take user input, and format output if you want to do any kind of advanced reporting. Look for command line app libraries, that make building console apps easier. Example: node-optimist (https://github.com/substack/node-optimist)


    Networking 101: You'll need to understand what a port is and how to connect to both tcp and udp ports. Thus you get an introduction to some foundational networking concepts.
    Multithreading: Sure you can connect to ports in a linear fashion, or you could use some sort of thread pool to speed things up. Multithreading is a pretty important programming concept that every developer needs to learn, and all languages do it differently.
    Exception Handling: What happens when you can't connect to a port, or you're not connected to the internet. I'm guessing an exception will be thrown at some point and you'll have to handle it.
    GUI: Once the command line interface is done, try to integrate a GUI to run the app.
    Language Libraries: There's usually libraries that can do all the heavy lifting for you. Examples could include: cli libs, tcp libs, udp libs, text formatting apis... This is important as you're getting a look into the bazaar that makes up your language of choice.


The more complex you make your port scanner the more you'll learn. If you want to play with a port scanner right now to understand how it works, I recommend nmap: http://nmap.org/ (https://nmap.org/) .

---------------------------------------

Akin Williams , Remote Full Stack Developer (2017-present) Updated November 4, 2018 · 

The Knight’s Tour is both a mathematical and logical problem in which a knight visits every square on a chess board of variable size only once and, optionally, returns to the first square after the tour is complete. It is a good way of evaluating algorithm design and efficiency.

Programmers with a classical CS background will have encountered this problem, or one like it, in their education.

As a predominantly self-taught programmer, attempting to solve the Knight’s Tour gave me a lot of insight into what programmers should think about when designing applications. It tested my ability to think laterally and devise creative solutions to a real-world problem.

I started with a brute-force approach: considering every square within two moves and then backtracking out of dead-ends. Then I re-evaluated and refined the logic in my tour program to consider more efficient methods of solving the problem on boards of variable sizes. I tried different strategies like making smaller “virtual” boards from bigger ones, ranking move choices, checking efficiency from different starting points, etc.

It was a really fun and cool little experiment.

Update: My tiny mind might have expanded just a bit when I implemented Warnsdorff’s Heuristic (https://en.wikipedia.org/wiki/Knight's_tour#Warnsdorf.27s_rule) in my path finding algorithm. At first, it seemed counter-intuitive that searching for positions with the fewest subsequent moves would improve efficiency. That was before I figured out that I had been focusing on “finding” viable paths instead of eliminating unviable ones. Dead-ends are the enemy of my knight’s efficiency, so eliminating them at all costs should be the priority. The following basic algorithm looks for a path with the fewest branches, which statistically eliminates more dead-ends and raises efficiency.

    Set P to be a random initial position on the board
    Mark the board at P with the move number “1”
    Do following for each move number from 2 to the number of squares on the board:
        let S be the set of positions accessible from P.
        Set P to be the position in S with minimum accessibility
        Mark the board at P with the current move number
    Return the marked board — each square will be marked with the move number on which it is visited.

Source: Warnsdorff's algorithm for Knight’s tour problem - GeeksforGeeks (https://www.geeksforgeeks.org/warnsdorffs-algorithm-knights-tour-problem/)

The updated version is on my Github repo for anyone that is interested.

---------------------------------------

6. Try implementing a simple binary search tree (Red–black tree - https://en.wikipedia.org/wiki/Red%E2%80%93black_tree is a nice one for starter ;) ) (This should be a good exercise as debugging this when things go wrong is great fun in both logical thinking and programming implementation! )

7. (Optional, later stage) Maybe also implement a graph data structure and populate it randomly (if you are feeling adventurous try making it graph of your facebook friends ;) ) and find the shortest path (Dijkstra's algorithm - https://en.wikipedia.org/wiki/Dijkstra's_algorithm ). (Implementing a graph data structure and its related operations yourself gives a good appreciation for various language capabilities as well, apart from good )

---------------------------------------

Victor Eijkhout , Has thought deeply about mental models in programming, parallel in particular.  Updated October 26, 2014

In my limited field of scientific computing I claim that every one should at least once program the distributed sparse matrix vector product. It sounds so elementary, and is such a test of your understanding of many parallelism related concepts. The problem here is that processors don't know who they need to be communicating with. Setting that up efficiently is a good exercise.

Some experience with threading is also useful. I have found that programming the Fibonacci sequence is a great exercise. The basic idea is that the task/thread that computes f(n) spawns two new threads for f(n-1) and f(n-2). The trick is that these threads only need to compute if that value has never been computed before; otherwise they need to just read it from a memory location. (Yes, I know that this program becomes essentially sequential. That's not the point.) The trouble is that reading and setting the status variable for an f(n) value needs to be done atomically. This is much harder than it looks.

---------------------------------------

Henry Dietz , PhD Computer Science, NYU Tandon School of Engineering (1987) Answered June 24, 2017 · 

I generally have people starting to work with my research group implement a simple type of machine learning program on a parallel computer.

Traditionally, after writing various small programs, writing a compiler is the single programming project that will give you the broadest exposure to data structures and algorithms while helping you understand how programs really work on computer hardware. Compilers also tend to be complex enough to force good design practices. However, all those things are covered in the usual sequence of courses one would take as a computer engineering student — parallel programming and machine learning methods often aren’t.

Parallel processing — breaking a problem into multiple pieces that the computer can work on simultaneously — is the primary way modern computers can solve bigger problems, and solve them faster, than older systems could. It isn’t as important which of the many parallel programming languages or libraries one uses (MPI, OpenMP, Cuda, MapReduce, etc.), but knowing how to decompose problems for parallel execution is what enables you to solve problems other people cannot.

---------------------------------------

Matthew Mirman , Masters in programming language theory from CMU Answered November 22, 2012

Disclaimer: my standard for what constitutes a good programmer is likely a bit higher than most.

In no particular order:

    server/browser/proxy - you'll learn about some of the lower levels of the web. This is arguably the most important thing you can ever program.
    optimizing compiler - you'll understand what to and not to care about when programming in C
    a good garbage collector - you'll understand why garbage collection is so wonderful
    malloc - you'll understand why malloc is so hateful
    a shell - you'll really learn about processes and handles
    Distributed Raytracer/Password cracker - you'll learn at least a little bit about distributed computing and how to take advantage of embarrassingly parallel problems
    drivers - knowing how to do this comes in very handy.
    scripts for your editor - what use is a programming environment if you can't program it?
    a makefile - you'll only ever really need one of these (if it is good), but you should really know how it works.
    lambda calc interpreter - you'll learn how to parse things well, and what the lambda calculus is.

---------------------------------------

Daniel Deutsch , CMU CS 2014 Updated November 23, 2012

A quine.

If you do not know the solution, then writing a quine can be a very interesting logic puzzle, and the "aha" moment once you figure out how to write one is something every programmer should go through. If you have written a quine at least once before (or have found out the "trick" through some other means) then it is probably not as interesting. It can still be a decent way to learn a language, however, and writing the shortest obfuscated quine you can is a real testament to your hacky-ness and knowledge of the language.

For more information on the theoretical interestingness of quines, check Quines (self-replicating programs) http://www.madore.org/~david/computers/quine.html

---------------------------------------

Hatem Faheem , SDE II @Amazon Answered April 4, 2017

Whenever I want to learn or onboard with a new programming language I write only 1 program that walks me through the language.

N-grams calculator

    Get a large set of text files (e.g. English Wikipedia).
    Limit your memory usage (don't load everything in memory).
    Build a table of sorted N-grams (e.g. Tri-grams) counts.

What you'll learn from this?

    Reading & writing files.
    Using generators/iteratots/streams to process large data sets.
    Using built-in data structures and algorithms for counting and sorting.
    You can introduce some threading to enhance the time.
    You can introduce some OOP to separate reading/writing files from processing them.
    You can introduce a preprocessor to remove special characters and stop words from the data. This may include managing between the preprocessor and the counter in case both run in parallel (i.e. a message queue).

You can extend this to whatever you want. I consider this a very good learning project for any level depending on the complexities involved.

---------------------------------------

Sudoku Solver: Using backtracking,try to implement a Sudoku ,so that you need not to give your 20 minutes daily for newspaper Sudoku puzzle.

---------------------------------------

Arjun Ramachandran , Answered January 30, 2014

Multithreading - It just doesn't get boring with multithreading and when combined with distributed systems , that's a whole new level of concurrency , resource management (Threadpool , Heap memory , DB connections) and locking challenges to deal with .

Client/Server architecture - Makes you think about defining a protocol accounting scalability and extendability . This is definitely worth a stint !!

Game programming - Trees , Graphs .... Name a data structure/algorithm that u wont have to use . Best served with optmization algorithms !!

Framework - This is my personal favorite as ur customers are fellow engineers . Nothing like writing a framework to sharpen your design skills . Abstraction , modularity ,choosing your design patterns and what not !!!

---------------------------------------

David Edwards , CTO @ Vendavo Answered April 4, 2017 · 

Try your hand at the following problems, which will certainly enhance your skills as a software engineer.

    Write a compiler for a simple LL grammar, which includes a tokenizer, parser and code generator. Why? It is a synthesis of many fundamental building blocks that you will find applicable during your entire career.
    Implement a hash map that conforms to the map interface in the collections library of your language choice. Why? It not only gives you an appreciation of the mechanics of nontrivial data structures, but prepares you to write your own well-formed collection when the time comes.
    Implement a blocking thread-synchronous queue. Why? It teaches you a thing or two about concurrency and thread synchronization, much of which is abstracted away from developers in modern languages.

---------------------------------------

Rudi Kershaw , IT Technician at RDC Answered June 25, 2017

If you are relatively new to programming write a calculator, including a user interface, completely from scratch. Now this might sound like a very boring suggestion but it will give you a good and thorough understanding of the complexities involved in programming in general.

Writing the logic for parsing maths expressions is actually quite tough. Writing this logic yourself will give you an appreciation for how something that appears quite simple can be rather difficult. If done correctly it will show you the usefulness of a variety of abstract data types such as stacks and queues.

Writing the UI, in whichever language you choose, gives you an appreciation for front end development. Even if you have no intention of being a front-end developer, you should at least have an appreciation for how difficult it can be at times.

With that all said, a calculator is something you should be able to throw together in a relatively short period of time. Writing a complete program is actually very satisfying, so any projects you can complete in a short time is worth trying.

---------------------------------------

Ajay Gaur , Learner Answered May 31, 2015

Although I am a newbie to Competitive Programming, but some programs which are must for competitive programming are :
1) Computing the a power b in log(n) time.
2) Computing nCr mod m.
3) Advance data Structures like Trie, Segment Trees.(They really help in contests)
4) Dynamic Programming in bottom up fashion. (Recursion always confuses me :P)
5) Topological Sort, Adjacency List Representation of graph, Adjacency Matrix, DFS, BFS.
6) KMP, Rabin Karp and other string matching algorithms as well. (Suffix trees as well)
7) Binary Search, Quick Sort, Merge Sort. (Though libraries are always available in every programming language.)
8) Algorithms involving bit-operations.

---------------------------------------

Shubham Yadav , Campus Ambassador at Rcpl (2017-present) Answered March 13, 2017

One of the basic programs every programmer should know and learn are:

    Find the Transpose of a given Matrix
    Compute the Product of Two Matrices
    Perform Matrix Multiplication using Recursion
    Different sorting algorithms
    Tower of Hanoi
    Separating coefficients of different powers in a polynomial equation, addition and multiplication of such two equations
    Problems based on stack, queues and trees
    Searching algorithms problems
    Fibonacci series using recursion
    C Program to Convert Binary Code of a Number into its Equivalent Gray’s Code using Recursion
    C Program to Perform Shell Sort without using Recursion
    C Program to Reverse a Stack using Recursion
    Create a calendar for any year
    Dynamic allocation problems
    Program for Floyd’s triangle
    Program to Delete a specific Line from a Text File
    Program to Replace a specified Line in a Text File
    Program to List Files in Directory
    Program to Collect Statistics of a Source File like Total Lines, Total no. of Blank Lines, Total no. of Lines ending with Semicolon
    Program to Calculate the value of nCr
    Program to Find Sum of the Series 1/1! + 2/2! + 3/3! + ……1/N!
    Program to Solve the Magic Squares Puzzle

---------------------------------------


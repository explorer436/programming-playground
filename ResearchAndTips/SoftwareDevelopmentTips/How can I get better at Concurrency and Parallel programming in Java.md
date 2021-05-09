How can I get better at concurrency and parallel programming in Java?

Dimitris Athanasiou , Software Engineer, Pianist Answered March 19, 2016

To start with, read Amazon.co.uk: Brian Goetz, Tim Peierls, Joshua Bloch, Joseph Bowbeer, David Holmes, Doug Lea: 0785342349603: Books (http://www.amazon.co.uk/Java-Concurrency-Practice-Brian-Goetz/dp/0321349601/ref=sr_1_1?ie=UTF8&qid=1458398123&sr=8-1&keywords=java%2Bconcurrency%2Bin%2Bpractice)

. Read it many times. When you think you've read it enough times, read it some more.

Wrap your head around the concept of correct publication. Most people do not realize how often they violate the correct publication rules, thus their threaded code works by accident. Most threaded code out there works by accident.

After you've read that, many times, practice. Build some multi-threaded application. Test it real hard. Notice that no matter how well you think it works, an occasional bug happens, but you cannot reproduce it. That means something's not working right. Go back in your code and check for all things that could go wrong based on the book.

Finally, once you feel you understand concurrency really well, avoid applying it unless it is impossible to do otherwise. That's right. Correct threading is hard. Really hard. Today we have other tools to achieve concurrency without having shared-memory models. Some times it's of course impossible to avoid using threading, but when it's not, it's better to stay away from it.

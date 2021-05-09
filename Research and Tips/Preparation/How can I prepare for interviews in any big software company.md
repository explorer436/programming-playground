How can I prepare for interviews in any big software company?

This question previously had details. They are now in a comment.
Mohan Gupta - Amazon, Microsoft, Flipkart, Cisco

A little bit about me: Have taken 100s of coding interviews at Amazon, Microsoft, and Flipkart. And got offers from most of the big technology companies. (not bragging just establishing credibility).

There are two parts to this: 1) What a CS engineer should know and understand, irrespective of you interview anywhere or not, just like a doctor should know medicine. 2) How to prepare for the interview.

1) What a Software engineer should know?

If you don't know some of the basic and fundamental things about CS then you should not call yourself a CS engineer. It's not the B.tech/BE degree which you hold but the understanding of the concepts that make you an engineer.

a) The computing model: A CPU which performs operations by moving and transforming bits from one memory location to another. So, you must understand every algo boils down to the interaction between CPU and RAM. What is a stack/heap or what is meant by malloc/free/paging/segmentation fault/ null access etc everything is all out how CPU interacts with RAM? Understand this and you understand how computing actually works.

b) Data structures and algorithms: Understand why we need a data-structure and why we go such a length to develop an algo? How does a O(n) and O(n^2) differ in practice, not the concept but in actuality? Like, try to implement bubble sort and quick sort and run it on an array of size 100 million. Now once you understand the immense importance of this, then try to learn about the most common DS and Algos and understand how and WHY is one better suited to one situation than other? ex: if I need to find if an element is present in the set what should I use? A hashtable? but what if I need to perform that operation just 2 times? Wouldn't an array make more sense? (more of this in part 2), Also understand when a linked list is not a great solution and when a BST is better than an array? Now try to imagine a world where BST was not known to mankind and if you were to invent BST, how might you arrive at it? What is the motivation behind BST? I am not saying get it right, but at least give it a try, try to think deeply about what makes BST special (this will help if you have to arrive at your own algorithms).

c) Operating systems /Networks: Similar to (b), what matters more is "WHY" something works rather than "HOW".

d) Large-scale system design: To be honest this is one thing you can truly know only after a good experience of this over and over again. This is more of an art than science. You want to develop senses which let you break down a large system into small parts, to take out each of such part and decide on what services that part renders and how each of these micro-services fit together to bring about the service.

2) Preparing for interview:

The process of interview is flawed, it is grossly unfair *BUT* in absence of any better alternative, we will have to bear with it. Personal example: I did not even qualify the written test for Amazon and within 7 days I had an offer from another team at Amazon ( I cleared all interviews (6 of them) with ease). What changed? Nothing, just that (which I later realized), the other people who came for the written test were already aware of the question and gave a perfect solution (which I obviously did not).

Now that you understand computer science, let's learn the tricks (yes they are tricks and nothing more, you are still the same person but now you know how to clear interviews):

Principles of interviewing:

a) Its never about the right answer, its always about the approach you take, the clarity of thought and the methodology of the process you employ to *try* to solve the problem.

b) Start from the naive solution, and then incrementally try to get to a better solution, ex, how can you remove that log(n) to search inside that O(n) loop, use a hashtable perhaps? but won't that increase the memory required? Is that OK with the given problem size? Ask the interviewer.

c) Listen to the question properly, a lot of hints are hidden in the question itself. Once you are done with (a)/(b), now try to see, if you can use some property of the input to get a better solution, perhaps the input is characters from a to z, characters AHA? Can I now use that hashtable which will just have size O(26)?

d) Also, the expectations vary from company to company. ex, Amazon might focus more on an optimized solution and be a little lenient on corner cases but Microsoft would rather have you take care of each and every corner case and be flexible with the algo. You can get this by reading about the companies interview strategies on Google or Bing.

Getting ready for the perfect interview :

a) Practice questions from Carrercup and Geeksforgeek

. What you want to learn is not the solution to the problem but *HOW* to solve such problems, how to approach and how to arrive at the solution. Try to solve it yourself first and if you get stuck, look just at the minimal hits and try again.

b) Read this book

: (Cracking the coding interview). A little out of date but still provides valuable insights into how major technology companies go about their interviews. Discusses 1-2 problems from each of these companies.

c) Hacking the coding interview course:

(GetInterviewed course.) A thorough course on how to structure your response, decoding what makes a great answer. Understanding what an interviewer is looking for, real-interview scenarios 1:1 mock interviews for all the rounds like machine-coding, problem-solving, design and hiring rounds.

d) Practice, practice, practice ...

Also remember, those interviews are just a means to land a job, they are not the ends in themselves. What you want to do is to learn, learn why something works, learn how to solve complicated problems.

Best of luck.

How should I prepare for the Amazon online coding interview?
------------------------------------------------------------

Janko Jerinic, former Senior Software Development Engineer at Amazon (2015-2017)

The online coding interview is the pre-screening part of the journey, in which we should decide whether or not it makes sense to fly you out to an onsite interview or not. Obviously, we don't want to spend a lot of time and money on someone who doesn't stand a chance of at least meeting the bar, but we also don't want to go overboard in the initial screen, so there's a balance to be found in the complexity of programming questions which are asked in the online interviews.

Hence, unlike certain people who're trying to make a career out of consulting armies of young engineers who see meaning of life in getting a job in Silicon Valley (or die trying), let me tell you the distilled truth about the technical interviews for new grads:

It's nothing special, really.

See, you were either sitting on your ears in school, or you tried to make something out of it. You either loved your work and had genuine passion for computer science, or you tried to game the system so you can pass, somehow. In case of the former, you didn't restrict yourself to school materials - you read, and then you read some more, and then researched even more and coded the most. If you're that type of guy or girl, then these technical interviews will be no more difficult than what you had for homework, or exams.

Sure, brush up on things. Go through Cracking the Coding Interview if you must; by all means, revisit CLRS, but ultimately, these should be just subtle differences if you really have it in you. The knowledge that will be probed in the interviews should be deep in your head by now. Does that seem unreasonable?

If you do have the knowledge, than your psyche is your worst enemy, because your nerves may inhibit your reasoning. The best way to handle future stressful situations is envisioning them and playing them out in your head, over and over, until you grow accustomed to all those unpleasant sensations with which your body will react. This has been said and written so many times, it's almost a cliche, but - do mock interviews and practice writing code on whiteboards and talking to people while you do it, until you're comfortable with it. With online interviews, you might experience bad audio and you might not understand everything the interviewer says, especially if they have a heavy accent. Don't panic, ask questions, clarify and don't move until you understand what you're asked. You can prepare for that by practicing that with your friends, over the phone.

TL;DR;

Focus on managing psychological part of the interview if you have the technical abilities. If you don't, well then good luck with that.

Yeah, and what those other guys said about those websites that help you prepare by showing you how to reverse a linked list.

-------------------------------------------------------------------------

Sanket Dialani, Co-founder at GeekyPrep.com,Ex-SDE at Amazon.com, BITS-Pilani CSE 08-12

Thanks for the A2A.

Well, you need to first understand the difference between companies such as Google, Microsoft, Amazon, Facebook etc and other software companies.

How are their engineers different?

What extra thing does it take to get into these for engineering positions?

Why do engineers in these companies get paid higher (and much higher in some countries) as compared to other companies ?

Yes, engineers in these companies and other companies write code as well. The main difference comes in terms of day to day responsibilities and ownership.

In these companies, you own your module completely and you have to come up with the design of the piece of software you will be writing to solve a problem. Coding part is just the implementation and roughly takes 20-30% of the time allotted to a project. Most of the time goes into designing things with the best and optimum algorithms to save on company�s resources(servers, computation power etc). This is the main reason why interviews in these companies are focused on algorithms as they want people who can think out of the box to design algorithms which can save the company thousands of dollars.

So the bottomline is that you have to be good at Data Structures and Algorithms to get into these. There is no other alternative to it.

About the coding part during the interviews, after algorithm is discussed for a problem, the candidate is expected to write clear code which is syntactically and semantically correct. So that has to be practiced extensively.

Use the time to prepare well for Tree and Graph Algorithms, Dynamic Programming, Backtracking, Greedy Algorithms etc. These are always the hot topics for interviews at these companies.

Some common problems asked in Amazon Interviews(both online and F2F) :

    Save all leaf nodes of a Binary tree in a Doubly Linked List by using Right node as Next node and Left Node as Previous Node.
    Given an array,find the maximum j � i such that arr[j] > arr[i]
    Remove Alternate Duplicate characters from a char array you have to do it in Place.Like keeping only the odd occurences of each character.

    Example: Input: �you got beautiful eyes�
    Output: �you gtbeaiful es�
    Allowed Time Complexity was O(n) 
    and Space Complexity was O(1)

    In a file there are 1 million words . Find 10 most frequent words in that file.
    Find all nodes at k-distance from a given node in a binary tree
    Clone a linked list with next and random pointer
    Serialise and Deserialise a linked list with next and random pointer.
    Construct a binary tree from given inorder and preorder traversals.
    Return a tree such that each internal node stores sum of all its child nodes. Each leaf node stores zero.
    How will you implement linked list with 1 million nodes? How will you access 999999 th node? Give some optimal design strategy and implementation.
    Reversal of Linked List in groups of K.
    Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1�s.
    Check whether given binary tree is balanced or not. Definition was no two leaves should have height difference of greater than one.
    Remove duplicates from string in place in O(n).
    Connect nodes on same level in a binary tree.
    Find sum of data of all leaves of a binary tree on same level and then multiply sums obtained of all levels.
    Given a matrix of characters and a word.
    you have to count the number of occurrences of that word in that matrix. you can move to any of the eight valid directions from current position.
    You are given an string as input which represents a path. You have to normalize that path inplace(NO EXTRA SPACE).

    e.g. input : "\a\b\c\..\..\file.txt"
    output: "\a\file.txt"

    Least common ancestor of two nodes in a binary tree
    Given two sorted arrays (with repetitive elements) find the kth minimum number from both arrays.
    Given the root to a binary tree, a value n and k.Find the sum of nodes at distance k from node with value n
    Find an element in a rotated array
    Given two linked lists both represent a number. Create a linked list that contains its sum.
    Given a binary search tree , print the path which has the sum equal to k and has minimum hops. i.e if there are multiple paths with the sum equal to k then print the path with minimum number of nodes.
    A MxN matrix containing integers (positive, negative and zero�s). For every position containing 0, mark the corresponding row and column as 0.
    Rotate MxN matrix by 90 degress.
    Find the nth number that contains the digit k or is divisible by k. (2 <= k <= 9)
    Write a program to connect next left node in a binary tree. Also first node of each level should be pointing to last node of next level? (Without using Queue)
    Convert a binary tree to its sum tree(each node is the sum of its children)
    Given a directed graph. Construct another graph from given graph such that if path exists from vertices A to vertices B and from B to C, then path from A to C and from C to A also should exists.
    Implement hashmap on your own. Write good hashing function for string.
    Given an array, arrange the elements such that the number formed by concatenating the elements is highest.
    E.g.: input = [9, 93, 24, 6], the output should be: [9,93,6,24]. This is because if you concatenate all the numbers, 993624 is the highest number that can be formed.
    Given a string, find the longest substring which is palindrome.
    Given that integers are read from a data stream. Find median of elements read so for in efficient way. For simplicity assume there are no duplicates.
    Write an efficient program for printing k largest elements in an array. Elements in array can be in any order.
    Given unsorted array and a number K. Find 2 numbers such that sum is K.
    Given n-ary tree. zigzag level order traversal.
    Given string s and string t find whether all permutation of t is present as substring in s.
    Design a stack which holds an integer value such that getMinimum() function should return the minimum element in the stack. Implement popMin() function which would pop minimum element from the original stack.
    Given a set of intervals like 5-10, 15-20, 25-40, 30-45, 50-100. Find the ith smallest number in these intervals. Assume there are no duplicate numbers.

    e.g:  1st smallest number = 5	  
    6th smallest number = 10	  
    7th smallest number = 15 and so on. 

    Given an array which is first strictly increasing and then strictly decreasing. Find an element in this array.
    Given a string example : shoppingwithflipkartiseasy, Now we are given this string and a dictionary containing valid words , now we need to break the sentence into words separated by space. Output : shopping with flipkart is easy
    Given a series 2,3,4,5,6,8,9,10,��, here in this series all the numbers are present which have factors only and only either 2,3 or 5. Need to write a node to generate nth number for the series . With best approach and complexity
    Given a tree with edge weights, find any path in the tree with maximum sum of edges.
    Merge k sorted arrays.
    Given a maze, a start point and end point find the shortest path to reach the end point from the starting point.
    Given a sentence and a set of characters. Find the minimum window within which the set of characters can be found in the sentence in any order.
    You are given a string of 0�s and 1�s you have to find the number of substrings in the string which starts and end with a 1.

    eg : input : 0010110010
    output : 6

    You are given a mapping like a -> 1, b-> 2� z-> 26. You have to print all possible combinations of a given number using the above information.

    eg : input : 121
    output : aba,la,au

    Given a dictionary of 50,000 words. Given a phrase without spaces, add spaces to make it a proper sentence.

    e.g:input:  thequickbrownfoxjumpoverlazydog	
    output: the quick brown fox jump over lazy dog

    Get the next bigger number using the same digits of a number.
    Eg, For 123456, next number would be 123465

There are some good interview experiences, MCQs, Puzzles, HR and Design Questions with appropriate answers on Hub for GeekyPrep.com. Join us, Prepare for Interviews, Get Hired!!

For coding practice online you can checkout HackerEarth - Programming challenges and Developer jobs
and HackerRank

Good luck!

-------------------------------------------------------------------------

Mohan Gupta, Amazon, Microsoft, Flipkart, Cisco

Online coding interviews at big technology companies can get a little bit tricky. Unlike a face-to-face interview, you can not get clues from the body language, nor can you can the reactions of the interviewers to your idea. It's a tough nut to crack :(.

Let's understand the motivation of such interviews and how to master them.

Why are online coding interviews taken at companies like Amazon?

On the other hand, you need to understand that online rounds are mainly used quick filters (on most situations), so even though the questions might not be easy but the evaluation criteria is somewhat liberal.

All the interviewer is looking for is, shall we invite this candidate for the full loop? The idea is to only invite candidate who seems even a little bit likely to clear the full loops.

Also in most cases, the feedback on the online round is not even taken into much consideration while deciding on the final offer to the candidate.

How to ace the online coding interview?

Like any technical interview online rounds are mostly a small assortment of all skills you would be tested deeply in the full loop. There are elements of problem-solving, coding, design etc.

Assuming you are preparing to actually get an offer and hence have been /are preparing for the full set of interviews here is a detailed Quora answer I have for how to prepare for technical stuff and hacking the interview process to structure a near perfect answer:

Mohan Gupta's answer to How can I prepare for interviews in any big software company?

Now let's discuss specific challenges for online coding rounds.

Here you need to write the code on a shared screen/Google Doc and the interviewer can see in real time as you type. So you don�t want to write, delete, modify continuously and not want to come across as someone who jumps to solutions and doesn�t have a clear mind.

Understand the problem

A better approach is to talk to your interviewer, do not make unilateral assumptions, ask questions to clarify your doubts about the question setting and make explicit all your assumptions.

After the problem is clear to you, take 2�3 minutes to think deeply about it and possible solutions and then enunciate (so that the interviewer can understand your thought process) what you are thinking. Formulate a couple of solutions and discuss the merits/demerits of the solutions you are proposing.

Your interviewer would be happy to drop hints to guide you to the right path, so keep listening intently and once both you have agreed on one solution, he will ask you to code up the solution.

Again take a couple of minutes to think about how would you want to structure the code, have a layout in your mind and then start typing. Try to write as clean a code as you can, if possible do put comments and use informative variable/function names.

Writing code on shared screen

Always remember to validate the function arguments or write a comment with a TODO to do so. Documents the assumptions you have as comments above the function definition and if you do not remember a syntax, make a TODO comment and tell your interviewer that you are not exactly sure of the syntax at XYZ line and usually you will look up such things.

After the code is written, go through it once to make sure there are no obvious bugs, do a line-by-line run through of the code with a couple of examples and only then refer the code to the interviewer.

The last piece of advice before I go, always keep talking about what you are doing or thinking. On phone/skype, a long silence might feel like that you are stumped and not making progress.

Hope this helps. Best of luck.

-------------------------------------------------------------------------

Naman Trivedi, B.E. Computer Engineering & Entrepreneurship, Savitribai Phule Pune University

I have earlier talked about How to crack Google interviews as Google hiring process is pretty similar to what of Amazon.

Here are some tips and tricks:-

    Don't interview before you're ready. Get some experience solving real-world problems first so you can demonstrate that you don't just know stuff but you can apply it as well to problems that you've never seen before.
    Do some internships related to this field as they will increase your chance of getting into Amazon.
    Or, Try doing some freelance work, Online challenges, or contribute to open source projects to at least get some practice in what you can do and demonstrate that you've enough passion and initiative to seek out those opportunities.
    Look at some local recruiting events where you can sign up for interviews and apply for them there.
    Search someone in LinkedIn who is already working in Amazon, connect with them send your resume as it almost guaranteed that your resume gets looked at by the hiring manager.
    There is an interview preparation program like ZENITH Placement Program

on websites like PrepBytes

    that are just a Google search away that will give you lots of sample interview questions for a pretty much any engineering job you can dream up and some of them are specific to specific companies too so you can use them and prepare yourself. There will be live coding and doubt solving sessions. You will get Practice, review, and guidance under experts. This program will also include Aptitude practice, Interview questions, and Mock tests.
    If you're brought in for an interview you'll probably be asked to code or architect things on a whiteboard.
    Know what to expect.
    Stay Communicated.
    Understand the Company's Value: At Amazon, they have a set of leadership principles that are very important to them. Part of your interview will be assessing whether you exemplify these principles so be prepared to offer examples of how you have demonstrated these principles in your past work.

Amazon's Leadership Principles are as follows:-

    Customer Obsession: When you're given an open-ended question always think from the customer's benefit point-of-view and definitely you'll get some bonus points.
    Ownership: Welfare of your organization as a whole and not just a focused job that you do.
    Invent & Simplify: Have you ever came up with a different idea? Also, keep in mind that the Amazon values Simplicity in its technologies and has a distaste for overly complex systems that are difficult to maintain.
    Are right a lot: Think about when your intuition proved to be correct but you should also be someone who admits what you don't know and seek diverse opinions from others.
    Learn & Curious: This is essential for engineers. Think about times when you've taught yourself a new skill on your own initiative and be ready to talk about it.
    Hire and develop the best: If you're not new to the industry how have you helped your peers to grow.
    Insist on the Highest Standards: Think of a time where something just wasn't good enough and so you made it better.
    Think Big: Have you ever came up with a big idea that wasn't some narrowly focussed technical solution.
    Bias for action: They want people who take initiatives and don't just do what they are told.
    Frugality: You're unlikely to be questioned on this during an interview but Amazon doesn't usually like throwing a large number of people or money at a problem if they don't have to.
    Earn Trust: Do your peers trust you because you're a good listener and self-critical and candid and treat others with respect. This falls under being a good team player category.
    Dive deep: If you've ever dug into a problem only to uncover a much deeper one that you ended up solving instead that's also a good story to have ready.
    Have backbone; disagree and commit: Think of times where you didn't initially agree with the decision and you voiced your opinion but ultimately committed to it if that was the final decision.
    Deliver Results: This is last but perhaps the most important. Amazon and Google both want the people who are an order of magnitude more productive than most engineers because they are driven, focussed, and know if they are doing.

So, be prepared to talk about your more impressive accomplishments and how long it took you to do them.

-------------------------------------------------------------------------

Abu Bakkar, Designer (2012-present)

Amazon is one of the top IT/technology company in the world. It is huge. Many excellent software engineers want to work for Amazon and so do I. I applied to Amazon three times in total. THe first two times were not successful and at http://amazon.jobs it says �was not selected�.

MY AMAZON INTERVIEW EXPERIENCE

I found the Amazon jobs advertisements on LinkedIn, and the first two were based in Cambridge. The third time, I applied an Amazon jobs in London, which is a fixed-term contract.

Luckily the third time, Amazon emailed me Saturday midnight (it was from Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more USA technical recruitment team), in the email, I was asked to do an online coding exercise within 7 days.

There were two puzzles/problems to solve. Once started, you can�t pause it, so be prepared to find a 2 hour slot that you are free from disturb so that you can focus on solving them.

These two problems are real world problems i.e. you don�t expect straight text-book questions e.g how to do a quick sort. Instead, you need to read and understand the problem and solve them using proper algorithms.

For each problem, two sample inputs and corresponding outputs are given. You can choose any programming language as you wish. You type in your solution in the browser (coding editor). You will need to compile your code and submit your solution once you are happy with. However, once compiled and run in the browser, your solution will be submitted for a complete set of test cases around 30. And you will be notified if your solution passes all of them or fail at one of them.

I finished two questions within 1 hours (you are given maximum of 1.5 hours to solve them). You then can take a break of 10 minutes if you wish, and then followed by a few questions asking you the approach to solve the puzzles (time complexity). The last part is the survey. The online coding

interview is conducted by third party that do not belong to Amazon.

I was contacted on LinkedIn by one of the Amazon technical recruiters. She asked me if I am interested in Amazon ACSC (Amazon Catlog Selection Control?) job in London. I told her that I just finished the coding exercise that morning and later she invited for a interview in London because ACSC would come to London for 3 day event. However, I would need to withdraw the application from amazon.job and she said the ASCS job would be permanent, which is better.

The technical recruiter sent me a few interview tips and advised which Computer Science knowledge to review. This includes data structures, algorithms, design pattern, cloud computing etc.

I prepared for two weeks and went to London for the Amazon interview which took place from 2PM to 7PM (they also had morning sessions from 8 to 1PM).

On the day, I was invited to a small meeting room and on the door, it says �Welcome, [My Name]�. One of the interviewer says �you are going to stay in this room for the rest of the day and you are free to get a drink or food/fruits in the kitchen��. Amazon has provided free food/fruit/drinks but I didn�t take a chance I guess I was a bit nervous.

Each interview took around 40 minutes followed by 10 minutes question time and 10 minutes break. The first around, there were two interviewers one of them was like getting familiar with the interviewing process. The last round was the manager you might work with if you are successful. The second round, it was basically all the behaviour questions where the interviewer asked you all the stories to see if you are a culture fit e.g. describe a time that you don�t agree with your manager and how did you cope with that. There are no right/wrong answers but you have to prepare at least 10 stories beforehand � you don�t want to tell a same story to all interviewers (I guess they will meet later and share the answers).

I was asked to write the code on the paper and the interviewers will meantime type on their laptop. And they took away your answer sheets at the end of the interview.

Before you arrive at Interview, you need to print out and sign a NDA agreement. But I think it would be OK if you don�t because they will give you a copy to sign onsite.

Each interview will ask you behaviour questions apart from technical questions but each will focus on different aspects. In general, you need to be very familiar with data structures e.g. trees, hash tables, queue etc. You also need to design some prototypes that can be scalable (Amazon deals with huge amount of data every day and being scalable is something they are very interested in).

I finished my interview almost exactly at 7:00PM when I was almost exhausted. Three days later, I was called by the technical recruiter and unfortnately Amazon would not give any feedbacks due to legal issues.

-------------------------------------------------------------------------

Mark Ali, Interned at Google, Facebook and got my full-time offer

To be honest, I don't see much difference between preparing general coding interviews from Amazon online coding interviews. At its core, this type of interviews are all about your coding skills and understanding of basic data structures/algorithms.

It's worth noting that you certainly need to practice a lot of coding questions before you can easily pass the interview. However, this doesn't mean you should randomly select and solve programming questions without thinking. I would highly recommend you read Practice Coding Questions � The Complete Guide to Google Interview Preparation
as it has tons of tips about how to prepare smartly.

To highlight few points here, the best tip I got is to track your time. To be honest with you, I think people in general are terrible at estimating time. Previously, I never realized how slow I was in coding. It's not about typing speed, but everything from thinking to finalizing the code. Part of the reason is that sometimes I would start coding without a clear mind, which turns out to be a waste of time. Plus I definitely needed more practice at that time.

The thing is that once you realize your weak point, you'll try to improve it. But very few people put a timer when solving coding questions and they never know if it's a problem.

Another point is to think out loud, which certainly needs a lot of practice. My lesson is that you can't practice in silence and hope you'll soon be able to think out loud in real interviews. In the beginning, I found this quite distracting and I couldn't focus on my thoughts. A more general idea is to do exactly the same thing as interviews in preparation, e.g. if you're gonna write code on a piece of paper, do the same thing at home. Never expect to be comfortable with something without enough practice.

-------------------------------------------------------------------------



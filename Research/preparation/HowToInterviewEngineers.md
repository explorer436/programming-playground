How to interview engineers

spakhm.com Slava Akhmechet 16-20 minutes

This is my super secret proprietary no-nonsense guide on how to interview engineers. Another guide? Yes, because today's interviews are filled with posturing, political correctness, and small socially convenient falsehoods that have everything to do with large company recruiting constraints and nothing to do with you. Microsoft started it, FAANG cloned it, and everyone else cloned FAANG. If you're basing your interviews on industry standard practices, you're now three levels of cargo-culting deep.

This guide is for interviewing very talented people. It's applicable if you're building an extraordinary team at a hard technology startup. If your startup is technology-enabled, or you're designing an interview process at a large company, or you're hiring for well-established roles to do specialized tasks, this guide isn't for you. You will not find references to "junior vs senior" or "front-end vs back-end" here. From the perspective of what we're trying to accomplish, specialization is for insects.

There are three things you need to determine about a candidate: talent, judgement, and personality. Think of hiring an engineer as if you're buying a race car. The first thing you must look for in a race car is horsepower, because without horsepower the car is useless for racing. The horsepower of engineers is talent. Without talent, engineers are useless for building products, so it's the first thing you must look for in a candidate. It doesn't matter how nice the person is, or how hard-working. No horsepower, no race.

Talent alone is insufficient. The world is filled with talented people who never get anywhere for a myriad reasons. Laziness, anxiety, fragility, impulsivity, egotism, victimhood, just to list a few. So once you've identified talent, you have to determine the shape and quality of its vessel. Where will the person direct their talent? And are they well-adapted to the demands of the external world?

--------------------------------------

Talent

Talent is a combination of speed, working memory, taste, knowledge of the toolchain, understanding how computers work, and ability to program. It's IQ, but specialized for engineers. IQ is 50-80% heritable, impossible to improve, normally distributed, and strongly correlated with success in fields like science and engineering.

This matters for candidate selection because someone can improve within their talent band, but they can't jump talent bands. A person with IQ of 145 (σ=3) is dramatically better than a person with IQ of 115 (σ=1). If you watch both people work, it's like they're from different galaxies. So your job as an interviewer is to find out the candidate's talent band.

Here's how you do that. Tell the candidate in advance to have a laptop with their favorite development environment ready. They can use any operating system, any editor, any programming language— whatever makes them the most comfortable.

When the interview starts, have them share the screen. You'll be watching as they type. Then, give them a problem. The one I gave for years is to write a program that plays every possible tic-tac-toe game, and then prints the number of valid games. You should make up your own problem, but this is roughly the difficulty you're shooting for, give or take. The candidate's goal is to write the program, compile it, run it, and get it to produce the correct answer.

Take note of the time and let them do their thing. Answer any questions they might have as they go. The moment the program outputs the correct answer, take note of the time again. That's all you have to do to evaluate how talented the candidate is. The technical aspect of the interview is over. (Yes, you read that right!)

Here is what will happen. The most talented candidates will think about it for a few seconds, then write the program as fast as they can type (and they'll type fast). You can almost sense their frustration because they think way faster than the keyboard allows them to interface with the computer. Typing speed is their bottleneck. When they're done typing, they'll probably have a few compiler errors and runtime bugs that they'll fix instantly. Have them compare their result with the answer on Google. If the answers don't match, they'll look at the program for a few seconds, exclaim "oh, right!", fix the bug, rerun the program and get the correct answer. The whole process will take about 10 minutes from start to finish.

Slightly less talented candidates will do the same thing, but a little slower. You'll get a sense that their thinking speed and typing speed are balanced— neither is the bottleneck. They might take a bit longer to iron out the bugs and spot the mistake if the program doesn't give the correct answer the first time they run it. They'll get the whole thing done in 15 minutes. Maaaybe 20, if they're having a bad day.

The rest of the candidates will type much more slowly than they normally could. They're capable of much faster typing speed, but the speed of their thinking is the bottleneck. For our purposes, that's a no hire. When you sense that, let them keep working for 15 minutes to save face, then politely interrupt them, thank them for their time, and hang up. The silver lining of the pandemic is that you no longer have to be in a situation where you find out five minutes into the interview the candidate isn't good, and then waste everyone's time for a few more hours because it's too awkward to send them home.

Note that this interview question covered everything we defined as talent— speed, working memory, knowledge of the toolchain, understanding how computers work, and ability to program. To evaluate taste you have to pay attention to their code, choice of tools, and the thinking process as they write the program. But you could probably ignore all that. I've never met a candidate who could solve this problem in less than 15 minutes but had no taste. Like IQ, the various aspects of talent that you want in a candidate tend to be tightly correlated. When they have a couple of desired qualities in abundance, they usually have the rest.

--------------------------------------

Aside

Let me pause for a moment and answer a few frequently asked questions.

First, I cannot myself pass this interview. Last time I tried, I got the correct answer after about forty minutes or so. I could get it down with practice, but it doesn't matter-- I think slower than I type. That's a no hire. The point of the interview is to hire extremely talented engineers, not engineers as talented as me.

Second, algorithms questions are currently out of fashion, timing the candidate is downright blasphemous, and untimed work-specific questions are in vogue. Instead of asking the candidate to solve a programming problem like above, you're supposed to ask them to glue APIs together, and to take as long as they need. There are all sorts of very good arguments for why you should do this, all of which remind me of the following quote by Deirdre McCloskey in her essay The Natural (which, by the way, is excellent and you should read):

    Richard Bower is an economist right down to his wing tip shoes. He knows Sophocles and Shakespeare alright, but he believes in economics. […] Give him any social situation, from insider trading to an obstreperous teenage child, and he looks to economics for an answer, or at least for a good running start.

The economics answer is that people switched interview styles right in the middle of a tech boom when demand for software engineers dramatically exceeded supply, and then made up a bunch of reasons for why the new way of interviewing is better than the old way. FAANG companies hire entire engineering armies every year. No recruiting organization can sustain that without lowering the bar. But unlike managers at FAANG, your compensation doesn't depend on team size and you're not hiring bodies just to fill seats. When you need very talented people to join you, you must do the grueling, unscalable work to find and recruit them.

Third, system design and architecture questions are useful for candidates that think slower than they type. For exceptional people these types of questions are a waste of time. I've never met anyone able to write a complex program as fast as they can type but unable to figure out that they need a load balancer, or how to set one up on AWS.

--------------------------------------

Judgement

Judgement tends to be weakly correlated with talent, and comes down to this: there is a difference between a tinkerer and an engineer. They're close, but they aren't the same thing. Tinkering is building a Rube Goldberg machine for the sheer delight of building it. Engineering is discovering and satisfying (often unintuitive) constraints. The tinkerer works for the machine. The engineer makes the machine work for him.

Most engineers aren't tinkerers, they're in it for the money. Don't hire those because they have no soul and hanging around them will slowly poison your own soul by osmosis. Conversely, many tinkerers aren't engineers. Don't hire those either, because they'll build beautifully complex structures that serve no purpose other than their own existence. You want people who take great delight in building Rude Goldberg machines, but balance it with a broader sense of what they're trying to accomplish.

Another way of thinking about it is that talent is a combination of general aptitude and programming tactics. Judgement is programming strategy.

You don't need every engineer on your team to be Sun Tzu, but you do need them to have one of two qualities. Either the candidate should have good strategic intuition, or, at a minimum, they must be aware that strategy exists and be willing to acquiescence to someone with better judgement. The worst case scenario is a candidate with awful strategic intuition, but who thinks he's good. They'll end up wasting everyone's time in pointless discussions, and eventually will get disgruntled and quit.

How do you test for judgement? One school of thought is to ask the candidate a revealing set of questions. This is the "what are your weaknesses" question, version 2.0. Industry lore is filled with them. You're supposed to ask the candidate questions like "how lucky would you say you are?" or "tell me about a time you took unexpected initiative", and their answer will reveal crucial information about their deeply hidden mental structures.

A good rule of thumb is that if a question could be asked by an intern in HR, it's a non-differential signaling question. Good signaling questions are differential. For example, it’s much easier for a smart person to signal intelligence than for a dumb person. But it's equally easy for anyone to make up a time when they took initiative. The only information the answer transmits is willingness to comply with the interview ritual. A literal interpretation is "will you be a good corporate drone?" with the candidate's answer compressing into a binary "yes" or "no". And even then, it's trivial to lie about your intentions. People who need a job do that all the time.

Like the talent section of the interview, the judgement section must be differential. The medium for expressing tactical engineering talent is code. The medium for expressing strategic judgement is the memo (or its open counterpart, the essay). And like writing code is much easier for talented programmers, writing technical essays is much easier for people with good strategic intuition.

There are many examples of classic pieces of strategic technical writing: 1 2 3 4 5 6 7 8. Every lasting project and company has produced at least one such classic, but that inverts the cause and effect. What makes building enduring software more likely is having people capable of superb judgement and expressing it in written form. You want to get those people on your team.

Here is how you run this part of the interview. Pick a technical decision that has strategic significance. Give it to the candidate as a prompt. They're making the call for the company, and communicating their decision in writing to the engineering organization. Answer all of their questions. For many people strategic clarity tends to strike in the shower, but since it's inappropriate to ask the candidate to shower as part of the interview, give them plenty of time instead. An hour, or perhaps 90 minutes— you can calibrate for what works best. As they write you must be available to answer questions over DM.

After reading a few of these you'll see that the quality varies dramatically between candidates. You're looking for writing that's terse, clear, compelling and engaging. If the memo compels you to follow the course of action outlined by the candidate, they passed. If you vehemently disagree with them, but it's difficult to rebut their argument, they passed. If you get the sense that their judgement is better than yours, they passed. If the writing compels you to throw the memo in the trash bin, but the candidate signals that this is outside their circle of competence, they passed.

Otherwise, no hire.

--------------------------------------

Personality

By now you know the candidate is a great programmer and they have good judgement. The last thing you need to verify is that working with them won't be a massive pain in the ass.

The easiest way to think about it is in terms of the big five personality traits. These are kind of like Myers Briggs, except real. The three traits you especially care about are conscientiousness, agreeableness and neuroticism. Psychologists have precise technical definitions for these terms, but in plain language you're trying to find out (a) whether the candidate is lazy or hard working, (b) are they an asshole, and (c) are they going to be stuck in analysis paralysis and invent life emergencies for themselves all the time instead of working.

So the good news is that as far as interviews are concerned, the mental framework for personality is simple. The bad news is that you can't find any of this information out until after you've hired the candidate. You can set up a low pass filter that might trap a few bad apples, but almost everyone is on their best behavior during interviews. Personal flaws rarely come out until long after the person is working for you.

If a candidate is belligerent to people during the interview, obviously don't hire them. If you call the references and find out the person barely did any work or if the references don't know the person at all, don't hire them. If they give you really weird vibes, don't hire them. But other than that, there isn't much you can do during the interview.

I've interviewed hundreds of people and hired dozens. My sixth sense for picking out talent and judgement is pretty good. But for personality it's only slightly better than random. So unless you have magic powers in this area, set up a low pass filter and later fire bad personalities as they reveal themselves.

--------------------------------------

Theatrics

If you decide you want to hire the candidate, the interview must last at least six hours (with an hour break for lunch). Have your engineers interview the person, one by one, for about 45 minutes to an hour each. Every time they should give the candidate progressively more difficult technical problems. It doesn't matter what the problems are. Your goal is to calibrate the process to each candidate so they fail to solve a problem by the middle of the day. It should be a problem they feel is within their reach, but is hard enough that they run out of time. For the remaining part of the day, take the difficulty down a notch, and give the candidate problems they will solve with some effort. You don't want to completely exhaust the lad (or lass) until the day is over.

Why spend six hours interviewing someone if you already know you want to hire them? Two reasons.

First, the candidate needs to feel they've earned the privilege to work at your company. If you give them an offer after only three hours of interviewing they will deliberate about their options for a week or two, and then go work for Facebook because your company is probably filled with bozos. After all, you only take three hours to interview people. This is also why you give them one problem they can't solve, even though they feel like they ought to be able to. I've tested this extensively. It turns out the candidate is much more likely to accept an offer if they fail to solve a problem during the interview, and if they're mentally exhausted by the end of the day. People want to suffer in order to feel really good about joining a company. Don't take that away from them.

Second, your engineers need to feel they know the measure of whoever they're going to be working with. One of the worst things about large companies is that someone can suddenly appear on your team, and you now have to work with them. You couldn't do a better job destroying camaraderie if you tried. Engineers need to have solved problems with their potential future colleague, had friendly banter, found out where they break. They need to be able to chat about the candidate with each other, and build up anticipation of having a new member join the team.

When the day is over, thank the candidate for their time, offer to answer any questions, tell them you'll be in touch and wish them good night. Give the offer in the afternoon the next day. The candidate needs to sleep on the interview, and more importantly spend time having a little trepidation about how they did.


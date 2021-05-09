How often do tech companies ask LeetCode Hard questions during interviews?

Jérôme Cukier · November 7, 2019 Interviewed hundreds of candidates

A tech company will never ask you a “LeetCode question”.

Even if the wording of the question were the same, in a LeetCode problem, you submit code to a service that tests it against several use cases and only care about its memory usage and execution time. When you start a LeetCode problem, you have all the information you need in written form, you don’t have to ask for clarifications, but the flip side is that you can’t ask someone questions if needed.

So the interviewing experience is fundamentally different from leetCode.

That being said, what makes a leetcode problem hard?

It can ba problems where finding even a basic solution is hard (“trick questions”). Those problems might be good training, but they are not interesting in an interview setting. A lot of the interviewing time would be wasted by the candidate just trying to figure things out. This problem is a possible example - https://leetcode.com/problems/dungeon-game/

once you develop the right abstraction, it’s kind of straightforward but it’s very easy to go astray and not see the way into it.

It can be that while a basic solution is intuitive, the optimal solution is hard to find, and only the optimal solution (or a variation thereof) can pass all the test cases in the allocated time and space constraints. There are lots of examples like that in leetcode.

Interviewers are not only interested in the best solution though. There are lots of signal to be found when candidates implement a more accessible solution. From there, a path to a better solution can be found through discussion between interviewer and candidate.

It can be that the solution requires a very specific intuition. The problem I have in mind is this: https://leetcode.com/problems/maximal-square/
which is only a medium one. It’s possible to come up with a very efficient solution without exactly replicating what’s described in https://leetcode.com/problems/maximal-square/solution/

but if you have this in mind, it really helps.

It can be that a simplified version of the problem may be easy but a generalized one will run into annoying edge cases. This problem comes to mind https://leetcode.com/problems/max-points-on-a-line/

. This used to be my go-to interviewing question (ie as an interviewer, and it wasn’t on leetcode then at least not to my knowledge… ) 4 years ago but I restricted it to integer coordinates. If points in this exercise can have float coordinates, it becomes harder because dividing floats isn’t an accurate operation so you need a workaround. Coming up with that workaround though isn’t terribly interesting in an interview (as opposed to the overall algorithm).

My conclusion is that it’s unlikely that you’re asked a hard problem (in the leetcode sense) in an interview and if you are, then you can unpack the difficulty with the interviewer. So being able to solve hard leetCode problems is not required to pass a big tech interview.

It’s also not enough. Some of the most efficient solutions submitted to leetcode are terribly written, with 1-letter variables galore and super obfuscated syntax. In an interview, unlike when writing for a computer program, coding style and comments matter, not just the hard performance.

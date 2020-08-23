Common developer pitfalls that even seniors struggle with

Terry Karavoulias
Apr 12, 2019 · 5 min read

I’ve been building websites, software, and services a couple of decades. I’ve worked with, managed, and mentored a few dozen full-stack developers. Over the course of my career, I’ve worked with many people who have struggled with similar problems. I too have fallen victim to some of these developer pitfalls. The following is advice on how to overcome the most common ones.

If you want eggs for breakfast, don’t build a farm.

I see this one all the time — many developers will over-engineer a simple project because of the prospect that one day they might need to add extra features that are not on the plan. This makes the code more complex, takes longer to write, pushes back deadlines, and requires a considerable amount of testing. Instead, try to focus on the task at hand and not what the project may possibly look like in the future. When your users start using your product, you’ll likely have to rewrite those extra features anyway since users are reliable at not behaving the way you’d expect them to.

Choose the tools that you need and stick with them

When you’re starting from scratch, it’s crucial to only use tools that are complete, proven and that fit the needs of your project in their current state. Your project should be able to be completed and do everything as you’d expect with the current versions of these tools. If you find yourself thinking “oh this framework will be out of beta by the time I’m done” or “this feature will probably be available in two months anyway” then those are signs that the tool doesn’t meet your needs. Additionally, when looking at open source projects, look at how often they get updated, how many open issues exist and how many active contributors there are. A stale project or one that only has the original author as a contributor are signs that you should look elsewhere.

Most programming languages have a way to specify and lock down versions of your tools. You’ll probably want to lock them at a major release at most. So for example, you could say: “For this particular tool, I only want version 2.*” or even better “2.4.*”. You don’t want to spend time constantly upgrading your toolkit rather than doing actual work.

Learn to use your tools

If you’re using a framework, there are probably a ton of built-in solutions to problems that you’re trying to overcome. Perhaps some special helpers for database queries, or array/object manipulation. I see a lot of custom code that’s written that could be replaced with a simpler solution that the framework already offers. Read the documentation before you begin on a new task. Don’t be afraid to dig into the framework’s code–this will not only help you understand how a particular function works but looking at the professionally written code will help you further develop your skills.

Make sure that you’re using a good editor or IDE. Learn its keyboard shortcuts and code snippets. Make your own snippets to speed up common tasks. Most importantly, learn to debug. Printing out the contents of your variables or the word “here” to see if you make it into an if statement is not proper debugging. If it’s just a quick debug, then outputting the contents of a variable is fine. However, if it’s going to take over a minute to resolve an issue, use a debugger. It will show you all the values of all active variables and guide you through code paths. Valuable information and a huge time saver.

Bad comments are infinitely worse than no comments

What’s a bad comment? It’s a comment that states the obvious. It’s a comment that doesn’t explain what the block of code actually does. For example, a function named FetchExtractProcessData with a comment that writes “This function is in charge of fetching, extracting, and processing the data.” That comment gives you no explanation. Other examples of bad comments include outdated statements, code that is not maintained anymore or poor and misleading grammar. You also don’t need comments that state the obvious or explain how a framework works.

Can a comment-blind person read your code?

Here’s a fun task. Take all the comments in your code base and ditch them entirely. Can someone still read your code without difficulty? The FetchExtractProcessData example from above is an example of horrible naming. It doesn’t explain what the function is actually doing and the multiple verbs suggest that it's doing too much.

It’s considerably more important to have functions, classes, and variables that are properly named and explicit. Don’t abbreviate any of them. Use natural language but do try to keep both variable and function names short, three to five words max. Use a code linter and formatter to keep things tidy and easy to read. Make sure you follow a standard that already exists for your programming language instead of establishing your own.

The user-facing frontend is more important than the backend

Here’s something that might seem controversial but your frontend is without a doubt more important than your backend. Unless your project is not people facing or is meant to be consumed by other applications or services, then your frontend should be your primary focus.

You can worry about scaling, caching, and optimizations later — After all, you’re not going to magically start with a million users. If you do, then that is a good problem to have and consider yourself lucky. Think about all the websites and apps you use. Do you use them because they run the latest and greatest tech stack? No, you use them because they present their content in a way that you find easy to consume and their experience is not frustrating.

This isn’t a knock on backend code or developers, without a proper foundation the whole project will collapse. However, don’t spend a huge chunk of your time working on things that only you or a very tiny amount of people will see or use or aren’t crucial to the success of your project. Think of the bigger picture, always.
You’re building for an actual person, not an engineer

It’s important to know your audience and design the experience around them. You don’t want a language that only an engineer would understand. “Abort”, “system failure”, “critical issue” will scare your users away. Use simple, natural language that they will understand and be comfortable with. Don’t read from the database and publish as is. If you’re using “destroy” to signify a record being deleted from the database, that’s great but keep it to yourself. “Your comment has been successfully removed” is a lot more friendly than “Success: Record was destroyed”.

Final thoughts

It’s very easy to get caught up in your day-to-day while trying to strive for perfection. Take a step back occasionally and look at the bigger picture. Is what you’re working on causing progress or are you spending too much time on an aspect that doesn’t really matter. Keep things clean and simple, and remember your audience. Most importantly, have fun. Coding should never feel like a chore.


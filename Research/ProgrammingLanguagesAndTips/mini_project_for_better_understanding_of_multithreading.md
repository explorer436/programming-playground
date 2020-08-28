What mini-project/assignment would you suggest for better understanding of multithreading?

Barry Rountree · December 10, 2017 - HPC is what I do for a living

Consider nanopond (https://github.com/adamierymenko/nanopond)

. It’s a really cool artificial life/evolution simulator. Nice visuals.

    The 2.0 version adds multithreading. Does the existing implementation prevent race conditions?
    Run a single-threaded version for some number of timesteps, and then run a multithreaded version for the same number of timesteps using the same random number seed. Do the results agree? What changes would you need to make to get identical results for serial and parallel versions?
    “Strong scaling” refers to increasing parallelism for the same problem, while “weak scaling” refers to keeping the problem size the same for each thread — more parallelism allows solving larger problems. How well does your implementation in #2 scale in both the strong and weak sense? What bottlenecks do you run into?
    Several cloud providers allow renting compute nodes by the hour at very reasonable rates. How well does your implementation scale on compute nodes with much larger numbers of cores?
    If you were to relax the constraint of “bitwise reproducibility”, how much more performance could you gain? How does relaxing that constraint change the behavior of the simulation? (Given a set of statistics from a race-free and racy implementation, can you tell which is which?)
    “Overcommitting” refers to creating more threads than there are cores to run them. If you enable hyperthreading on your processor, does overcommitting lead to higher performance? Is there any performance benefit from using hyperthreads? Is there any performance benefit from creating more threads than hyperthreads per core x number of cores?
    How much performance is lost from choosing the next location at random? How would you use a multithreaded implementation to hide that memory latency? Do the characteristics of the application change with non-random selection (which should give much, much better cache behavior)?

Now that you’ve mastered multithreading on a tiny program, have a look at ReSCAL (http://www.ipgp.fr/~rozier/rescal/rescal.html)
.

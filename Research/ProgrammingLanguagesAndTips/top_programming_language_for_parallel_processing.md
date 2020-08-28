What are the top programming language for parallel processing, both in ease of use and capability?

Nicolae Marasoiu · June 16, 2019 - 13 years Java, J2EE, Spring, Scala, Haskell, big data, reactive FP, DDD, HPC.

Haskell, Scala, Julia, Fortran, Matlab and clones.

But libraries like Open MPI, Kafka Streams, Akka Streams, and clusters like Apache Spark, Apache Flink, or even data grids with processing capabilities like GridGain/ Apache Ignite or Hazelcast, all these are very helpful in working at a high level, in a functional declarative style, with monadic imutable collection like types, bound to input streaming or batch sources including databases or other storage types.

Haskell notably has an automatic parallelization feature in the compiler, able to introduce parallelism in the implementation just by discovering data dependencies, a good indication of the power of declarative programming.


My thoughts about using Maven or Gradle as build tools for java applications:


Starting out with Gradle may seem easy, but based on previous experiences, using Maven will give us much more flexibility.
When it comes to Maven's power at confuguring profiles, environment variables, etc. the time spent to learn it once will be a good investment.

Just stick to using maven (and not Gradle) as much as you can.

Based on what I have seen so far, Maven is much more powerful and flexible if you invest a little bit of time learning it once.

Spend some time to understand further differences between the two.

-----------------------------

How to force a maven project to use older version of a dependency instead of a new version from another dependency?

You can exclude the cyclic dependencies by using the <exclusions> tag in your pom.xml like this:

<dependency>
  <groupId>sample.ProjectB</groupId>
  <artifactId>Project-B</artifactId>
  <version>1.0-SNAPSHOT</version>
  <exclusions>
    <exclusion>
      <groupId>sample.ProjectE</groupId> <!-- Exclude Project-E from Project-B -->
      <artifactId>Project-E</artifactId>
    </exclusion>
  </exclusions>
</dependency>

Reference: https://maven.apache.org/guides/introduction/introduction-to-optional-and-excludes-dependencies.html

----------------------------------

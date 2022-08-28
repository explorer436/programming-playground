Sample application to show the dockerization of a springboot application.

See 

https://spring.io/guides/gs/spring-boot-docker/

https://docs.spring.io/spring-boot/docs/current/reference/html/container-images.html

### Running the application

If you use Maven, run the following command:

./mvnw package && java -jar target/springboot-docker-demo-0.0.1-SNAPSHOT.jar

Then go to localhost:8080 to see your “Hello Docker World” message.

### Containerize It

Docker has a simple "Dockerfile" file format that it uses to specify the “layers” of an image.

If you use Maven, you can run it with the following command:
```
docker build -t springdemo/my-spring-boot-docker-demo .
```
This command builds an image and tags it as `springdemo/my-spring-boot-docker-demo`


Run it using this command:
```
docker run -p 8080:8080 springdemo/my-spring-boot-docker-demo
```
By default, Spring Boot applications run on port 8080 inside the container, and we mapped that to the same port on the host by using `-p` on the command line.


##### Version 1

```
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

This Dockerfile is very simple, but it is all you need to run a Spring Boot app with no frills: just Java and a JAR file. The build creates a spring user and a spring group to run the application. It is then copied (by the COPY command) the project JAR file into the container as app.jar, which is run in the ENTRYPOINT. The array form of the Dockerfile ENTRYPOINT is used so that there is no shell wrapping the Java process.

##### Version 2

https://docs.docker.com/engine/install/linux-postinstall/

```
FROM openjdk:11
RUN addgroup --system springgroup
RUN adduser --system springuser
RUN adduser springuser springgroup
USER springuser:springgroup
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Running applications with non-user privileges helps to mitigate some risks (see, for example, a thread on StackExchange). So, an important improvement to the Dockerfile is to run the application as a non-root user

You can see the username in the application startup logs when you build and run the application.

Note the started by in the first INFO log entry:

```
 :: Spring Boot ::                (v2.6.2)

2022-01-19 04:17:45.403  INFO 1 --- [           main] c.e.s.SpringbootDockerDemoApplication    : Starting SpringbootDockerDemoApplication v0.0.1-SNAPSHOT using Java 11.0.13 on 313af7247794 with PID 1 (/app.jar started by springuser in /)

```

##### Version 3

There is a clean separation between dependencies and application resources in a Spring Boot fat JAR file, and we can use that fact to improve performance. The key is to create layers in the container filesystem. The layers are cached both at build time and at runtime (in most runtimes), so we want the most frequently changing resources (usually the class and static resources in the application itself) to be layered after the more slowly changing resources. Thus, we use a slightly different implementation of the Dockerfile:

```
FROM openjdk:11
RUN addgroup --system springgroup
RUN adduser --system springuser
RUN adduser springuser springgroup
USER springuser:springgroup

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.springbootdockerdemo.SpringbootDockerDemoApplication"]
```

This Dockerfile has a `DEPENDENCY` parameter pointing to a directory where we have unpacked the fat JAR.

To use the `DEPENDENCY` parameter with Maven, run the following command: `mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)`

If we get that right, it already contains a `BOOT-INF/lib` directory with the dependency JARs in it, and a `BOOT-INF/classes` directory with the application classes in it. Notice that we use the application’s own main class: `hello.Application` (use this format to build this: `packageName.className`). (This is faster than using the indirection provided by the fat JAR launcher.)

Exploding the JAR file can result in the classpath order being [different at runtime](https://github.com/spring-projects/spring-boot/issues/9128#issuecomment-510577157). A well-behaved and well-written application should not care about this, but you may see behavior changes if the dependencies are not carefully managed.

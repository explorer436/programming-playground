package com.my.company.processapi;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetCurrentProcessInformationTestDriver {

    public static void main(String[] args) {

        String np = "Not Present";
        ProcessHandle currentProcess = ProcessHandle.current();
        ProcessHandle.Info info = currentProcess.info();
        
        System.out.printf("Process ID : %s%n", currentProcess.pid());
        System.out.printf("Command name : %s%n", info.command().orElse(np));
        System.out.printf("Command line : %s%n", info.commandLine().orElse(np));

        Optional<String[]> infoArguments = info.arguments();
        Optional<String> cmd =  info.commandLine();
        Optional<Instant> startTime = info.startInstant();
        Optional<Duration> cpuUsage = info.totalCpuDuration();

        System.out.printf("Start time: %s%n",
                startTime
                        .map(i -> i.atZone(ZoneId.systemDefault())
                                .toLocalDateTime().toString())
                        .orElse(np));

        System.out.printf("Arguments : %s%n",
                infoArguments
                        .map(a -> Stream.of(a).collect(
                                Collectors.joining(" ")))
                        .orElse(np));

        System.out.printf("User : %s%n", info.user().orElse(np));

    }

    /*
        /home/explorer436/.sdkman/candidates/java/current/bin/java -javaagent:/home/explorer436/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=37585:/home/explorer436/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/my-java-solutions/target/classes:/home/explorer436/.m2/repository/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar:/home/explorer436/.m2/repository/org/apache/commons/commons-lang3/3.14.0/commons-lang3-3.14.0.jar:/home/explorer436/.m2/repository/org/slf4j/slf4j-simple/2.0.16/slf4j-simple-2.0.16.jar:/home/explorer436/.m2/repository/org/slf4j/slf4j-api/2.0.16/slf4j-api-2.0.16.jar com.my.company.processapi.GetCurrentProcessInformationTestDriver
        Process ID : 162781
        Command name : /home/explorer436/.sdkman/candidates/java/21.0.3-zulu/bin/java
        Command line : /home/explorer436/.sdkman/candidates/java/21.0.3-zulu/bin/java -javaagent:/home/explorer436/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=37585:/home/explorer436/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/my-java-solutions/target/classes:/home/explorer436/.m2/repository/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar:/home/explorer436/.m2/repository/org/apache/commons/commons-lang3/3.14.0/commons-lang3-3.14.0.jar:/home/explorer436/.m2/repository/org/slf4j/slf4j-simple/2.0.16/slf4j-simple-2.0.16.jar:/home/explorer436/.m2/repository/org/slf4j/slf4j-api/2.0.16/slf4j-api-2.0.16.jar com.my.company.processapi.GetCurrentProcessInformationTestDriver
        Start time: 2024-09-12T12:16:56.920
        Arguments : -javaagent:/home/explorer436/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=37585:/home/explorer436/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/my-java-solutions/target/classes:/home/explorer436/.m2/repository/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar:/home/explorer436/.m2/repository/org/apache/commons/commons-lang3/3.14.0/commons-lang3-3.14.0.jar:/home/explorer436/.m2/repository/org/slf4j/slf4j-simple/2.0.16/slf4j-simple-2.0.16.jar:/home/explorer436/.m2/repository/org/slf4j/slf4j-api/2.0.16/slf4j-api-2.0.16.jar com.my.company.processapi.GetCurrentProcessInformationTestDriver
        User : explorer436

        Process finished with exit code 0
     */

}

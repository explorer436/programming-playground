package com.my.company.processapi;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpawnANewProcessTestDriver {

    public static void main(String[] args) throws IOException, InterruptedException {

        // runEchoCommand();

        // runListCommand();

        demoApacheExec();

        // extracted();
    }

    // Build and execute a command with ProcessBuilder
    private static void runListCommand() throws IOException, InterruptedException {
        // Windows machines
        // ProcessBuilder pb = new ProcessBuilder("notepad.exe");

        // ProcessBuilder pb = new ProcessBuilder("bash", "-c", "ls /home");
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", "ls /home/explorer436/Downloads")
                .inheritIO();
        processBuilder.start().waitFor();
    }

    // Build and execute a command with Apache Commons Exec
    // Prerequisite: org.apache.commons - commons-exec
    // Working samples
    private static void demoApacheExec()
            throws IOException, ExecuteException {
        var cmd = new CommandLine("sh");
        cmd.addArgument("-c");
        // cmd.addArgument("echo test 1", false);
        // cmd.addArgument("ls /home/explorer436/Downloads", false);
        cmd.addArgument("sh /home/explorer436/PullFromGitRepositories.sh", false);
        System.out.println("Command: " + cmd);

        var executor = new DefaultExecutor();
        executor.execute(cmd);
    }

    // Didn't work
    private static void extracted() throws IOException, InterruptedException {
        // Windows machines
        // ProcessBuilder pb = new ProcessBuilder("notepad.exe");

        // Run a shell command
        // ProcessBuilder pb = new ProcessBuilder("bash", "-c", "ls /home");
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", "ls /home/explorer436/Downloads").inheritIO();
        processBuilder.start().waitFor();


        // Run a shell script
        // processBuilder.command("/home/explorer436/PullFromGitRepositories.sh");

        String np = "Not Present";
        Process process = processBuilder.start();
        process.waitFor();
        ProcessHandle.Info info = process.info();

        // map view of this process builder's environment
        Map<String, String> envMap = processBuilder.environment();
        // checking map view of environment
        for (Map.Entry<String, String> entry : envMap.entrySet()) {
            // checking key and value separately
            // System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        System.out.printf("Process ID : %s%n", process.pid());
        System.out.println("Command name : " + info.command().orElse(np));
        System.out.println("Command line : " + info.commandLine().orElse(np));

        System.out.printf("Start time: %s%n",
                info.startInstant().map(i -> i.atZone(ZoneId.systemDefault())
                        .toLocalDateTime().toString()).orElse(np));

        System.out.printf("Arguments : %s%n",
                info.arguments().map(a -> Stream.of(a).collect(
                        Collectors.joining(" "))).orElse(np));

        System.out.printf("User : %s%n", info.user().orElse(np));
    }

    // Working sample
    private static void runEchoCommand() throws InterruptedException, IOException {
        // Working sample
        ProcessBuilder pb = new ProcessBuilder("sh", "-c", "echo test 2").inheritIO();
        System.out.println("Command: " + pb.command());
        pb.start().waitFor();
    }

}

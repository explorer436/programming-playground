package com.my.company.mycustomclasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CleanAndRegenerateHugoWebsite {

    // This did not work.
    // There are no errors in the terminal output but the expected files are not getting generated.

    private static final String folderLocation =
            "/home/explorer436/Downloads/GitRepositories/hugo-blog";
    
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        regenerateMdFiles(folderLocation);
        System.out.println("--finished--");

        long endTime = System.nanoTime();

        long timeTaken = (endTime - startTime);

        System.out.println(">>> timeTaken in seconds : " + TimeUnit.SECONDS.convert(timeTaken, TimeUnit.NANOSECONDS));
    }

    private static void regenerateMdFiles(String folderLocation) {
        cleanup(folderLocation);

        File folder = new File(folderLocation + "/org");
        File[] listOfFiles = folder.listFiles();

        /*Arrays.stream(listOfFiles).forEach(f -> {
            if (f.isFile() && !f.getName().contains("~")) {
                try {
                    String absoluteFilename = String.valueOf(f.getAbsoluteFile());
                    System.out.println("absoluteFilename: " + absoluteFilename);

                    String command = "emacs --batch -l " + folderLocation + "/init.el -l " + folderLocation + "/jethrow-publish.el --eval \'\\(jethro/publish \"" + absoluteFilename + "\"\\)\'";
                    System.out.println("command: " + command);

                    Process proc = Runtime.getRuntime().exec(command);

                    // Read the output
                    BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                    String line = "";
                    while((line = reader.readLine()) != null) {
                        System.out.print(line + "\n");
                    }
                    proc.waitFor();
                } catch (Exception e) {
                    // System.out.println("processing failed for filename: " + listOfFiles[i].getName());
                    e.printStackTrace();
                }
            }
        });*/

        int successCount = 0;
        // for (int i = 0; i < listOfFiles.length; i++) {
        for (int i = 0; i < 10; i++) {

            if (listOfFiles[i].isFile() && !listOfFiles[i].getName().contains("~")) {
                try {

                    System.out.println(">>> i : " + i);

                    // System.out.println("File name " + listOfFiles[i].getName());

                    String absoluteFilename = String.valueOf(listOfFiles[i].getAbsoluteFile());
                    System.out.println("absoluteFilename: " + absoluteFilename);

                    // working sample String command = "emacs --batch -l " + folderLocation + "/init.el -l " + folderLocation + "/jethrow-publish.el --eval \'\\(jethro/publish \"" + absoluteFilename + "\"\\)\'";

                    // String command = "emacs --batch -l " + folderLocation + "/init.el -l " + folderLocation + "/jethrow-publish.el --eval \'(jethro/publish \"" + absoluteFilename + "\")\'";

                    String[] args = new String[] {"emacs", "--batch -l ", folderLocation + "/init.el -l ", folderLocation + "/jethrow-publish.el", "--eval '(jethro/publish ", absoluteFilename, ")'"};
                    Process proc = new ProcessBuilder(args).start();

                    // System.out.println("command: " + command);

                    // Process proc = Runtime.getRuntime().exec(command);

                    // Read the output
                    BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                    String line = "";
                    while((line = reader.readLine()) != null) {
                        System.out.print(line + "\n");
                    }
                    proc.waitFor();
                } catch (Exception e) {
                    // System.out.println("processing failed for filename: " + listOfFiles[i].getName());
                    e.printStackTrace();
                }

                successCount++;

                // writer.write(listOfFiles[i].getName() + "\n");
            }
        }
        System.out.println("successCount: " + successCount);
    }

    private static void cleanup(String folderLocation) {

        List<String> places = Arrays.asList(
                "rm -rf " + folderLocation + "/content/posts/",
                "rm -rf " + folderLocation + "/public/ox-hugo/",
                "rm -rf " + folderLocation + "/static/ox-hugo/",
                "rm -rf " + folderLocation + "/public/posts/");

        places.stream().forEach(c -> {
            Process proc = null;
            try {
                proc = Runtime.getRuntime().exec(c);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = "";
            while(true) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(line + "\n");
            }
            try {
                proc.waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}

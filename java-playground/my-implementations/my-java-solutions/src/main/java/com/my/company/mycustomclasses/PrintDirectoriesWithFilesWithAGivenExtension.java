package com.my.company.mycustomclasses;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.io.File;
import java.util.Objects;

public class PrintDirectoriesWithFilesWithAGivenExtension {

    private static final String folderLocation =
            "/home/explorer436/pCloudDrive/FromSync";

    private static final String SUB_DIRECTORY_NAME = "convert";

    private static final String FILE_EXTENSION = ".HEIC";

    public static void main(String[] args) {

        StopWatch watch = new StopWatch();
        watch.start();

        helper(folderLocation);
        System.out.println("--finished--");

        watch.stop();
        System.out.println("Time Elapsed: " + watch.getTime() / 1000 + " seconds.");
    }

    private static void helper(String folderLocation) {
        File folder = new File(folderLocation);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {

            if (listOfFiles[i].isDirectory()) {
                // do a recursive call
                helper(listOfFiles[i].getPath());
            } else {
                String oldName = listOfFiles[i].getAbsoluteFile().getPath();

                int indexOfExtension = oldName.lastIndexOf('.');
                String ext = null;
                if (indexOfExtension != -1) {
                    ext = oldName.substring(indexOfExtension);
                }

                if (StringUtils.equals(FILE_EXTENSION, ext) && !listOfFiles[i].getParent().endsWith("/" + SUB_DIRECTORY_NAME)) {

                    // This directory has HEIC files. So, print the name.

                    String parent = listOfFiles[i].getParent();
                    System.out.println(parent);
                }
            }
        }
    }
}

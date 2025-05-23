package com.my.company.mycustomclasses;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class MoveFilesWithAGivenExtensionIntoASubfolder {

    private static final String SUB_DIRECTORY_NAME = "convert";

    private static final String FILE_EXTENSION = ".HEIC";

    public static void main(String[] args) {

        List<String> folderLocations = Stream.of("/home/explorer436/Downloads/here/DevEnglishSongs").toList();;

        folderLocations.forEach(MoveFilesWithAGivenExtensionIntoASubfolder::helper);
    }

    private static void helper(String folderLocation) {
        File folder = new File(folderLocation);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
            if (listOfFiles[i].isDirectory() && !listOfFiles[i].getName().equals(SUB_DIRECTORY_NAME)) {
                helper(folderLocation + "/" + listOfFiles[i].getName());
            }
            if (listOfFiles[i].isFile()) {
                String oldName = listOfFiles[i].getAbsoluteFile().getPath();

                System.out.println("Absolute Old File Name: " + oldName);

                int indexOfExtension = oldName.lastIndexOf('.');
                String ext = oldName.substring(indexOfExtension);

                if (StringUtils.equals(FILE_EXTENSION, ext)) {

                    // move into a sub-directory with the name SUB_DIRECTORY_NAME

                    System.out.println("ext : " + ext);
                    String name = listOfFiles[i].getName();
                    System.out.println("name: " + name);
                    System.out.println("path: " + listOfFiles[i].getPath());
                    String parent = listOfFiles[i].getParent();
                    System.out.println("parent: " + parent);

                    boolean subdirectoryCreated = createSubdirectoryIfItDoesNotExist(parent);
                    System.out.println("subdirectoryCreated: " + subdirectoryCreated);

                    boolean moved = listOfFiles[i].renameTo(new File(parent + "/" + SUB_DIRECTORY_NAME + "/" + name));
                    System.out.println("moved: " + moved);
                }
            }
        }
    }

    private static boolean createSubdirectoryIfItDoesNotExist(String parent) {
        if (!new File(parent + "/" + SUB_DIRECTORY_NAME).exists()) {
            return new File(parent + "/" + SUB_DIRECTORY_NAME).mkdirs();
        }
        return false;
    }
}

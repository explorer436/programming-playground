package com.my.company.mycustomclasses;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DeleteFileBasedOnExtension {

  private static final String folderLocation1 = "C:\\Users\\n0281526\\Desktop";

  private static final String folderLocation2 =
      "C:\\Users\\n0281526\\eclipse\\java-2018-09\\eclipse";

  private static final String folderLocation3 =
      "C:\\Users\\n0281526\\AppData\\Local\\Google\\Chrome\\User Data\\Crashpad\\reports";

  private static List<String> filesWithextensionsToBeDeleted = Arrays.asList("dmp,trc".split(","));

  private static List<String> filesWithNamesToBeDeleted = Arrays.asList("javacore".split(","));

  public static void main(String[] args) {
    readFolders(folderLocation1);
    readFolders(folderLocation2);
    readFolders(folderLocation3);
    System.out.println("--finished--");
  }

  private static void readFolders(String folderLocation) {
    try {
      File folder = new File(folderLocation);
      File[] listOfFiles = folder.listFiles();
      File file = null;
      for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
          try {
            // file name only
            file = new File(listOfFiles[i].getPath());
            System.out.println("printing file name : " + file.getName());
            String extension = "";
            int indexOfDot = file.getName().lastIndexOf('.');
            // System.out.println("indexOfDot : " + indexOfDot);
            if (indexOfDot > 0) {
              extension = file.getName().substring(indexOfDot + 1);
            }
            System.out.println("extension : " + extension);
            if (filesWithextensionsToBeDeleted.contains(extension)
                || doesFileWithThisNmaeNeedsToBeDeleted(file.getName())) {
              if (file.delete()) {
                System.out.println(file.getName() + " deleted from " + folderLocation);
              } else {
                System.out.println(file.getName() + " doesn't exists in " + folderLocation);
              }
            }
          } catch (Exception e) {
            // Auto-generated catch block
            e.printStackTrace();
          }
        } else if (listOfFiles[i].isDirectory()) {
          // System.out.println("Author : "+listOfFiles[i].getName());
          readBooks(listOfFiles[i].getName(), folderLocation + "/" + listOfFiles[i].getName());
        }
      }
    } catch (IOException ex) {
      // Report
      System.out.println("IO exception : " + ex.toString());
    } finally {

    }
  }

  private static boolean doesFileWithThisNmaeNeedsToBeDeleted(String fileName) {
    boolean result = false;
    for (String str : filesWithNamesToBeDeleted) {
      if (fileName.contains(str)) {
        result = true;
      }
    }
    return result;
  }

  private static void readBooks(String authorName, String location) throws IOException {
    File folder = new File(location);
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        // System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {

      }
    }
  }
}

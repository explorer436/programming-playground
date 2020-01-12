/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsha;

import java.io.File;

/**
 *
 * @author harshavardhane
 */
public class PrintFileNamesInAFolder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String folderLocation = "/Users/harshavardhanedupuganti/Google Drive/Complete references";
        readAuthors(folderLocation);
    }
    private static void readAuthors(String folderLocation){
        File folder = new File(folderLocation);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            System.out.println("File " + listOfFiles[i].getName());
          } else if (listOfFiles[i].isDirectory()) {
            //System.out.println("Author : "+listOfFiles[i].getName());
            readBooks(folderLocation+"/"+listOfFiles[i].getName());
          }
        }
    }
    private static void readBooks(String location){
        File folder = new File(location);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            //System.out.println("File " + listOfFiles[i].getName());
          } else if (listOfFiles[i].isDirectory()) {
            System.out.println( location.substring(62) +" } " + listOfFiles[i].getName());  
            //System.out.println("Book : " + listOfFiles[i].getName());
          }
        }
    }
}

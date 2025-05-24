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

        List<String> folderLocations = Stream.of("/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Devotional/DevEnglishSongs",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Diwali/2021",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Info@all/IDBI BankDetails/Teju@IDBI",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Info@all/Miscellaneous",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Info@all/Teju PolamPassbook",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Manasvi pics",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/MeMomNimmyMunnyDad@kanuru/All Pics",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Mounica/Documents",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Our Cooking",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Sweet HOME/HouseWarming-23rd Oct",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/Sweet HOME/TegaCay_Underconstruction_House pics",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/TejuMiscellaneous/TejuPicsAfterMarriage",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/YASHWIN BABY/21stDayCradleCermony",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/YASHWIN BABY/Feb2024",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 April Spring",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Aug OdiornePointBeach",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Bangalore Trip",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 BoatRidePortsmouth",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Dec FloridaTrip/2019-12-23 FL KeyWest",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Dec FloridaTrip/2019-12-24 FL EvergladesPark",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Dec FloridaTrip/2019-12-24 FL MiamiBoatRide",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Dec FloridaTrip/2019-12-25 MiamiBeachSunrise",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Dec FloridaTrip/MiamiApartment",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Dec FloridaTrip/SandeepsHome",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 December NewJackets",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Dover Bowling",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 DoverCommunityTrail",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 HarshaBday",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 HiltonPark",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Jan Aadvika",
                "/home/explorer436/pCloudDrive/FromSync/Personal_stuff/Photos After Marriage/2019/2019 Jan Hanuman Junction").toList();;

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

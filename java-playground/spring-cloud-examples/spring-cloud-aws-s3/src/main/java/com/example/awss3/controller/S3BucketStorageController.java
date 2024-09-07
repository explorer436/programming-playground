package com.example.awss3.controller;

import java.io.IOException;
import java.util.List;

import com.example.awss3.service.S3StorageServiceForFolders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.awss3.service.S3StorageServiceForFiles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class S3BucketStorageController {

    private final S3StorageServiceForFiles s3StorageServiceForFiles;
    private final S3StorageServiceForFolders s3StorageServiceForFolders;

    @PostMapping("/file/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("fileName") String fileName,
                                             @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(s3StorageServiceForFiles.uploadFile(fileName, file), HttpStatus.OK);
    }

    @DeleteMapping("/file/delete")
    public ResponseEntity<String> deleteFile(@RequestParam("fileName") String fileName) {
        return new ResponseEntity<>(s3StorageServiceForFiles.deleteFile(fileName), HttpStatus.OK);
    }

    @GetMapping("/file/download")
    public ResponseEntity<String> downloadFile(@RequestParam("fileName") String fileName,
                                               @RequestParam("presignedUrl") boolean presignedUrl) {
        return new ResponseEntity<>(s3StorageServiceForFiles.downloadFile(fileName, presignedUrl), HttpStatus.OK);
    }

    @GetMapping("/list/files")
    public ResponseEntity<List<String>> getListOfFiles() {
        return new ResponseEntity<>(s3StorageServiceForFiles.listFilesInBucket(), HttpStatus.OK);
    }

    @GetMapping("/presignedurl")
    public ResponseEntity<String> getPresignedUrl(@RequestParam("fileName") String fileName) {
        return new ResponseEntity<>(s3StorageServiceForFiles.generatePUTPresignedURL(fileName), HttpStatus.OK);
    }

    @GetMapping("/presignedurl/get")
    public ResponseEntity<String> generateGetPresignedUrl(@RequestParam("fileName") String fileName) {
        return new ResponseEntity<>(s3StorageServiceForFiles.generateGETPresignedURL(fileName), HttpStatus.OK);
    }

    @GetMapping("/presignedurl/filename")
    public ResponseEntity<String> getFileNameFromPresignedUrl(@RequestParam("presignedurl") String presignedurl) {
        return new ResponseEntity<>(s3StorageServiceForFiles.getFileNameFromPresignedUrl(presignedurl), HttpStatus.OK);
    }

    @GetMapping("/zip")
    public ResponseEntity zip() throws IOException {
        s3StorageServiceForFiles.zip();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/unzip")
    public ResponseEntity unzip(@RequestParam("zipFileName") String zipFileName) throws IOException {
        s3StorageServiceForFiles.unzip(zipFileName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/pickTxtFileFromDirectory")
    public ResponseEntity pickTxtFileFromDirectory(@RequestParam("folderName") String folderName) throws IOException {
        List<String> txtFilesList = s3StorageServiceForFiles.pickTxtFileFromDirectory(folderName);
        return new ResponseEntity<>(txtFilesList, HttpStatus.OK);
    }

    @PostMapping("/folder/upload")
    public ResponseEntity uploadFolder() throws IOException {
        s3StorageServiceForFolders.uploadFolder();
        return new ResponseEntity(HttpStatus.OK);
    }
}
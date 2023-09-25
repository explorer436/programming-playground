package com.example.springcloudlocalstacks3.controller;

import com.example.springcloudlocalstacks3.service.S3StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class S3BucketStorageController {

    private final S3StorageService service;

    @PostMapping("/file/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("fileName") String fileName,
                                             @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(fileName, file), HttpStatus.OK);
    }

    @DeleteMapping("/file/delete")
    public ResponseEntity<String> deleteFile(@RequestParam("fileName") String fileName) {
        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
    }

    @GetMapping("/file/download")
    public ResponseEntity<String> downloadFile(@RequestParam("fileName") String fileName,
                                               @RequestParam("rawContent") boolean rawContent) {
        return new ResponseEntity<>(service.downloadFile(fileName, rawContent), HttpStatus.OK);
    }

    @GetMapping("/list/files")
    public ResponseEntity<List<String>> getListOfFiles() {
        return new ResponseEntity<>(service.listFiles(), HttpStatus.OK);
    }

    @GetMapping("/presignedurl")
    public ResponseEntity<String> getPresignedUrl(@RequestParam("fileName") String fileName) {
        return new ResponseEntity<>(service.generatePUTPresignedURL(fileName), HttpStatus.OK);
    }
}
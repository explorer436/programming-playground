package com.example.springfileiodemo.controller;

import com.example.springfileiodemo.model.FileInfo;
import com.example.springfileiodemo.model.FileSystemResponseMessage;
import com.example.springfileiodemo.service.FilesStorageOnFileSystemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/io")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class FilesOnFileSystemController {

    private final FilesStorageOnFileSystemService storageService;

    @PostMapping("/upload")
    public ResponseEntity<FileSystemResponseMessage> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        log.info(">>> uploadFile() - multipartFile: {}", multipartFile);

        String message = "";
        try {
            storageService.save(multipartFile);

            message = "Uploaded the multipartFile successfully: " + multipartFile.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new FileSystemResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the multipartFile: " + multipartFile.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileSystemResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesOnFileSystemController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @DeleteMapping("/files/{filename:.+}")
    public ResponseEntity<FileSystemResponseMessage> deleteFile(@PathVariable String filename) {
        String message = "";

        try {
            boolean existed = storageService.delete(filename);

            if (existed) {
                message = "Delete the file successfully: " + filename;
                return ResponseEntity.status(HttpStatus.OK).body(new FileSystemResponseMessage(message));
            }

            message = "The file does not exist!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new FileSystemResponseMessage(message));
        } catch (Exception e) {
            message = "Could not delete the file: " + filename + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FileSystemResponseMessage(message));
        }
    }
}

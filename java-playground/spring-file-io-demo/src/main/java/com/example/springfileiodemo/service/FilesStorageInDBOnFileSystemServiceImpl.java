package com.example.springfileiodemo.service;

import com.example.springfileiodemo.entities.FileDB;
import com.example.springfileiodemo.repository.FileDBRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilesStorageInDBOnFileSystemServiceImpl {

    private final FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        FileDB FileDB = com.example.springfileiodemo.entities.FileDB.builder()
                .name(fileName)
                .type(file.getContentType())
                .data(file.getBytes())
                .build();

        return fileDBRepository.save(FileDB);
    }

    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}

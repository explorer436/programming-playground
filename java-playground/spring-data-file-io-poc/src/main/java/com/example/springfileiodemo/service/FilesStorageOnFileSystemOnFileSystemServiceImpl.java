package com.example.springfileiodemo.service;

import com.example.springfileiodemo.entities.FileDB;
import com.example.springfileiodemo.repository.FileDBRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilesStorageOnFileSystemOnFileSystemServiceImpl implements FilesStorageOnFileSystemService {

    private final FileDBRepository fileDBRepository;

    private final Path root = Paths.get("doc-uploads").toAbsolutePath().normalize();

    @Override
    public void init() {
        try {
            Path abc = Files.createDirectories(root);
            log.info("created path : " + abc);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        log.info(">>> save()");
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));

            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            FileDB FileDB = com.example.springfileiodemo.entities.FileDB.builder()
                    .name(fileName)
                    .type(file.getContentType())
                    .data(file.getBytes())
                    .build();

            fileDBRepository.save(FileDB);

        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        log.info(">>> load() - filename: {}", filename);
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    @Override
    public boolean delete(String filename) {
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}

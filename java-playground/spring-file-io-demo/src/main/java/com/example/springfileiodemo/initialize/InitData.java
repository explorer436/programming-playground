package com.example.springfileiodemo.initialize;

import com.example.springfileiodemo.service.FilesStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {

    private final FilesStorageService storageService;

    @PostConstruct
    public void load() {
        storageService.init();
    }

}

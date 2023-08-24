package com.example.springhttpdemo.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyService {

    private final MyServletRequestUtils myServletRequestUtils;

    private final WebUtils webUtils;

    @Async
    public void doSomethingAsynchronously(HttpServletRequest httpServletRequest) {

        log.info("printing headers in the async method");
        log.info(httpServletRequest.toString());
        webUtils.printHeadersInfo(httpServletRequest);

        HttpServletRequest clonedHttpServletRequest = myServletRequestUtils.cloneHttpServletRequest(httpServletRequest);

        log.info("printing headers in the async cloned req");
        log.info(clonedHttpServletRequest.toString());
        webUtils.printHeadersInfo(clonedHttpServletRequest);

        CompletableFuture.runAsync(() -> doSomethingSynchronously(clonedHttpServletRequest));
    }

    // The httpServletRequest that is passed into this method is not the original one.
    public void doSomethingSynchronously(HttpServletRequest httpServletRequest) {
        log.info("printing headers in the sync method");
        webUtils.printHeadersInfo(httpServletRequest);
    }
}

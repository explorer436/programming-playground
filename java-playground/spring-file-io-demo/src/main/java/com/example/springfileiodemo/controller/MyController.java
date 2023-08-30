package com.example.springfileiodemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class MyController {

    @Value("classpath:sample_pdf_file.pdf")
    Resource pdfFile;

    /**
     * Using the built in support in Spring with it's ResourceHttpMessageConverter.
     * This will set the content-length and content-type if it can determine the mime-type.
     * Showing samples for pdf and txt files below.
     */

    /**
     * What happens if we don't set "produces = "application/pdf" in @RequestMapping?
     * Spring will set "Content-Type: application/json" and the client application (browser) will not know what type of a file it is.
     * If they already know the type of the file, they can parse it.
     * But setting it this way seems like a good idea.
     *
     * How can we set it on the fly? pdf, txt, csv, etc?
     */
    @RequestMapping(value = "/files/1", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public FileSystemResource getFile1() throws IOException {

        // Accessing a resource from the classpath using ClassPathResource:
        // From Resource, we can easily jump to Java standard representations like InputStream or File.

        Resource r = new ClassPathResource("sample_pdf_file.pdf");
        return new FileSystemResource(r.getFile());

        /*File file = new ClassPathResource("sample_pdf_file.pdf").getFile();
        return new FileSystemResource(file);*/
    }

    @RequestMapping(value = "/files/2", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource getFile2() throws IOException {

        // Accessing a resource from the classpath using ClassPathResource:
        // From Resource, we can easily jump to Java standard representations like InputStream or File.

        File file = new ClassPathResource("sample3.txt").getFile();
        return new FileSystemResource(file);
    }
}
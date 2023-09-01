package com.example.springfileiodemo.controller;

import com.example.springfileiodemo.service.UserExcelExporter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class MyController {

    @Value("classpath:sample_pdf_file.pdf")
    Resource pdfFile;

    private final UserExcelExporter userExcelExporter;

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

    @RequestMapping(value = "/files/2", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public FileSystemResource getFile2() throws IOException {

        // Accessing a resource from the classpath using ClassPathResource:
        // From Resource, we can easily jump to Java standard representations like InputStream or File.

        File file = new ClassPathResource("sample3.txt").getFile();
        return new FileSystemResource(file);
    }

    @RequestMapping(value = "/files/3", method = RequestMethod.GET, produces = "text/csv")
    @ResponseBody
    public FileSystemResource getFile3() throws IOException {

        // Accessing a resource from the classpath using ClassPathResource:
        // From Resource, we can easily jump to Java standard representations like InputStream or File.

        File file = new ClassPathResource("addresses.csv").getFile();
        return new FileSystemResource(file);
    }

    @GetMapping(value="/downloadExcelFile")
    public ResponseEntity<ByteArrayResource> downloadTemplate() throws Exception {
        try {

            // We can set the filename dynamically - if necessary

            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "force-download"));
            header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductTemplate.xlsx");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            XSSFWorkbook workbook = userExcelExporter.getXlsxWorkbook();
            workbook.write(stream);
            workbook.close();

            return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
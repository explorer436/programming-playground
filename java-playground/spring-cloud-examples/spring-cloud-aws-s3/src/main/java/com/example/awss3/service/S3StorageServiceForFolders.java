package com.example.awss3.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.example.awss3.service.unzip.S3UnzipManager;
import com.example.awss3.service.unzip.strategy.NoSplitUnzipStrategy;
import com.example.awss3.service.unzip.strategy.UnzipStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.transfer.s3.S3TransferManager;
import software.amazon.awssdk.transfer.s3.model.CompletedDirectoryUpload;
import software.amazon.awssdk.transfer.s3.model.DirectoryUpload;
import software.amazon.awssdk.transfer.s3.model.UploadDirectoryRequest;
import software.amazon.awssdk.transfer.s3.model.UploadFileRequest;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
@RequiredArgsConstructor
@Service
public class S3StorageServiceForFolders {

    record MyCustomObject(String name,
                          String description,
                          String filename,
                          String fileContent,
                          String recipientId,
                          String metafield) {}

    private final S3TransferManager transferManager;

    @Value("${bucket.name}")
    private String bucketName;

    /**
     * Uploads a list of objects to a folder in a bucket in S3
     */
    public void uploadFolder() throws IOException {

        List<MyCustomObject> myCustomObjects = Arrays.asList(
                new MyCustomObject("first-object-name", "first-object-description", "firstFilename", "first-file-content", "first-file-recipient", "first-file-metafield"),
                new MyCustomObject("second-object-name", "second-object-description", "secondFilename", "second-file-content", "second-file-recipient", "second-file-metafield")
        );

        File tempDir = Files.createTempDirectory("my-temp-dir").toFile();
        tempDir.deleteOnExit();

        myCustomObjects.forEach(new Consumer<MyCustomObject>() {
            @Override
            public void accept(MyCustomObject myCustomObject) {
                File file = new File(tempDir.getPath() + File.separator + myCustomObject.filename());
                try {
                    FileUtils.writeStringToFile(file, myCustomObject.fileContent());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        uploadDirectory(transferManager, tempDir.toURI(), myCustomObjects);
    }

    public Integer uploadDirectory(S3TransferManager transferManager,
                                   URI sourceDirectory,
                                   List<MyCustomObject> myCustomObjects) {

        UploadDirectoryRequest uploadDirectoryRequest = UploadDirectoryRequest.builder()
                .bucket(bucketName)
                // Setting this here makes ufr.build().putObjectRequest().key() = subdirectory1/firstFilename. We don't want that.
                // .s3Prefix("sub-directory-1")
                // We need to specify prefix name only once - and that can be done in PutObjectRequest.builder()
                .source(Paths.get(sourceDirectory))
                .uploadFileRequestTransformer(ufr -> ufr.putObjectRequest(
                        PutObjectRequest.builder()
                                .key("sub-directory-1" + File.separator + ufr.build().putObjectRequest().key())
                                // .key(ufr.build().putObjectRequest().key())
                                .bucket(bucketName)
                                .metadata(getMetadata(ufr.build().putObjectRequest().key(), myCustomObjects))
                                .contentType("text/plain")
                                .build())
                )
                .build();

        DirectoryUpload directoryUpload = transferManager.uploadDirectory(uploadDirectoryRequest);

        CompletedDirectoryUpload completedDirectoryUpload = directoryUpload.completionFuture().join();
        completedDirectoryUpload.failedTransfers()
                .forEach(fail -> log.warn("Object [{}] failed to transfer", fail.toString()));
        return completedDirectoryUpload.failedTransfers().size();
    }

    private Map<String, String> getMetadata(String name, List<MyCustomObject> myCustomObjects) {
        Map<String, String> metadata = new HashMap<>();
        MyCustomObject myCustomObject = myCustomObjects.stream().filter(f -> f.filename().equals(name)).findFirst().get();
        metadata.put("recipientId", myCustomObject.recipientId());
        metadata.put("metafield", myCustomObject.metafield());
        return metadata;
    }

}

package com.example.awss3.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class S3StorageService {

    private final AmazonS3 amazonS3Client;

    private final static String S3_URL = "s3://%s/%s";

    @Value("${bucket.name}")
    private String bucketName;

    @Value("${bucket.uploadExpirationTime}")
    private Long bucketUploadExpirationTime;

    @Value("${bucket.downloadExpirationTime}")
    private Long bucketDownloadExpirationTime;

    /**
     * Upload file into AWS S3
     *
     * @param fileName
     * @param file
     * @return String
     */
    public String uploadFile(String fileName, MultipartFile file) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucketName, fileName, file.getInputStream(), metadata);

            // create a S3 download link for the file
            return generateGETPresignedURL(fileName);
            // return "File uploaded: " + fileName;
        } catch (IOException ioe) {
            log.error("IOException: " + ioe.getMessage());
        } catch (AmazonServiceException serviceException) {
            log.info("AmazonServiceException: " + serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
            log.info("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        }
        return "File not uploaded: " + fileName;
    }

    /**
     * Deletes file from AWS S3 bucket
     *
     * @param fileName
     * @return
     */
    public String deleteFile(final String fileName) {
        amazonS3Client.deleteObject(bucketName, fileName);
        return "Deleted File: " + fileName;
    }

    /**
     * Downloads file using amazon S3 client from S3 bucket
     *
     * @param fileName
     * @return ByteArrayOutputStream
     */
    public String downloadFile(String fileName, boolean rawContent) {
        String result = null;
        try {
            if (rawContent) {
                result = generateGETPresignedURL(fileName);
            } else {
                S3Object s3object = amazonS3Client.getObject(new GetObjectRequest(bucketName, fileName));

                InputStream is = s3object.getObjectContent();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int len;
                byte[] buffer = new byte[4096];
                while ((len = is.read(buffer, 0, buffer.length)) != -1) {
                    outputStream.write(buffer, 0, len);
                }

                result = outputStream.toString("UTF-8");
            }
        } catch (IOException ioException) {
            log.error("IOException: " + ioException.getMessage());
        } catch (AmazonServiceException serviceException) {
            log.info("AmazonServiceException Message:    " + serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
            log.info("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        }

        return result;
    }

    /**
     * Get all files from S3 bucket
     *
     * @return
     */
    public List<String> listFiles() {

        ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName);

        List<String> keys = new ArrayList<>();

        ObjectListing objects = amazonS3Client.listObjects(listObjectsRequest);

        while (true) {
            List<S3ObjectSummary> objectSummaries = objects.getObjectSummaries();
            if (objectSummaries.size() < 1) {
                break;
            }

            for (S3ObjectSummary item : objectSummaries) {
                if (!item.getKey().endsWith("/"))
                    keys.add(item.getKey());
            }

            objects = amazonS3Client.listNextBatchOfObjects(objects);
        }

        return keys;
    }

    public String generatePUTPresignedURL(final String fileName) {
        Date expirationDate = computeExpirationDate(bucketUploadExpirationTime);
        GeneratePresignedUrlRequest r = new GeneratePresignedUrlRequest(bucketName, fileName).withMethod(HttpMethod.PUT).withExpiration(expirationDate);
        URL url = amazonS3Client.generatePresignedUrl(r);
        return url.toString();
    }

    public String generateGETPresignedURL(final String fileName) {
        Date expirationDate = computeExpirationDate(bucketDownloadExpirationTime);
        GeneratePresignedUrlRequest r = new GeneratePresignedUrlRequest(bucketName, fileName).withMethod(HttpMethod.GET).withExpiration(expirationDate);
        URL url = amazonS3Client.generatePresignedUrl(r);
        return url.toString();
    }

    private Date computeExpirationDate(long expirationTimeMillis) {
        Date expirationDate = new Date();
        long expTimeMillis = Instant.now().toEpochMilli();
        expTimeMillis = expTimeMillis + expirationTimeMillis;
        expirationDate.setTime(expTimeMillis);
        return expirationDate;
    }

}

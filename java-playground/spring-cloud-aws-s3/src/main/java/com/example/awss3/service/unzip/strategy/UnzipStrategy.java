package com.example.awss3.service.unzip.strategy;

import com.amazonaws.services.s3.AmazonS3;
import com.example.awss3.service.unzip.S3ZipFile;

public interface UnzipStrategy {

    void unzip(S3ZipFile zipFile, AmazonS3 s3Client);
}

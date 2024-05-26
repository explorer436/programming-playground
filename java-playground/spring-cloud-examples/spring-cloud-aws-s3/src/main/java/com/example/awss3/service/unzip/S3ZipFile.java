package com.example.awss3.service.unzip;

import lombok.Value;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Value
public class S3ZipFile {
    String bucketName;
    String outputPrefix;
    ZipInputStream inputStream;
    ZipEntry zipEntry;

    public String filename() {
        return zipEntry.getName();
    }

    public long compressedSize() {
        return zipEntry.getCompressedSize();
    }

    public long size() {
        return zipEntry.getSize();
    }

    public String key() {
        return outputPrefix + filename();
    }
}
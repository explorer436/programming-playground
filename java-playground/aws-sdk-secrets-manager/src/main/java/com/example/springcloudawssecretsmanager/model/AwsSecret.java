package com.example.springcloudawssecretsmanager.model;

import lombok.Data;

@Data
public class AwsSecret {
    private String secretKey;
    private String secretValue;
}

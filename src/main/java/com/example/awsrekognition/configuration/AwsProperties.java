package com.example.awsrekognition.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("aws")
public class AwsProperties {

    private String accessKey;

    private String secretKey;
}

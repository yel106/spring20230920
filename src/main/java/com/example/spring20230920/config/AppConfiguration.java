package com.example.spring20230920.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AppConfiguration {

    @Value("${aws.accessKeyId}")  // custom.properties에 있는걸 주입받으려면 이 어노테이션 사용
    private String accessKeyId;
    @Value("${aws.secretAccessKey}")
    private String secretAccessKey;


    @Bean
    public S3Client s3Client() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);
        AwsCredentialsProvider provider = StaticCredentialsProvider.create(credentials);

        return  S3Client.builder()
                .region(Region.AP_NORTHEAST_2) //이게 서울 가리키는것
                .credentialsProvider(provider)
                .build();
    }

}

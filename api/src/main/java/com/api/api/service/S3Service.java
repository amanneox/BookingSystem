package com.api.api.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class S3Service {

    private Logger logger = LoggerFactory.getLogger(S3Service.class);

    @Autowired
    private AmazonS3 s3client;

    @Value("${cloud.aws.bucket}")
    private String bucketName;

    @Value("${cloud.aws.bucket.baseurl}")
    private String baseurl;

    public String uploadFile(MultipartFile img) {
        String keyName = UUID.randomUUID().toString()+".png";
        try {

            File convFile = new File(keyName);
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(img.getBytes());
            fos.close();

            s3client.putObject(new PutObjectRequest(bucketName, keyName, convFile ));
            logger.info("===================== Upload File - Done! =====================");

            Files.deleteIfExists(Paths.get(keyName));

        } catch (AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
            logger.error("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.error("AWS Error Code:   " + ase.getErrorCode());
            logger.error("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.error("Caught an AmazonClientException: ");
            logger.error("Error Message: " + ace.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  baseurl+keyName;
    }
}

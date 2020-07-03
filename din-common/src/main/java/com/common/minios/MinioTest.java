package com.common.minios;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class MinioTest {

  public static void main(String[] args) throws InvalidKeyException,
      NoSuchAlgorithmException, IOException, XmlPullParserException {
    try {
      String accessKey = "minioadmin";
      String secretKey = "minioadmin";

      MinioClient minioClient = new MinioClient("http://127.0.0.1:9000", accessKey,secretKey);

      boolean isExist = minioClient.bucketExists("firstbucket");
      if (isExist) {
        System.out.println("Bucket already exists.");
      }
      else {
        minioClient.makeBucket("kid");
      }

      minioClient.listBuckets().forEach(b -> System.out.println(b.name()));

      URL url = new URL(
          "https://images-na.ssl-images-amazon.com/images/I/81X4TID9IML._SL1500_.jpg");
      Path tempFile = Files.createTempFile("kid", ".jpg");
      try (InputStream in = url.openStream()) {
        Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
      }

      minioClient.putObject("firstbucket", "kid.jpg", tempFile.toString());
      Files.delete(tempFile);
    }
    catch (MinioException e) {
      System.out.println("Error occurred: " + e);
    }

  }

}
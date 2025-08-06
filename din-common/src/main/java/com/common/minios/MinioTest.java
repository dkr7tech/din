package com.common.minios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;

public class MinioTest {

	private static final String accessKey = "minioadmin";
	private static final String secretKey = "minioadmin";
	private static final String MINIO_ENDPOINT = "http://127.0.0.1:9000";

	private static final String BUCKET_NAME = "my-test-bucket";

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		try {

			MinioClient minioClient = MinioClient.builder().endpoint(MINIO_ENDPOINT).credentials(accessKey, secretKey)
					.build();

			BucketExistsArgs args2 = BucketExistsArgs.builder().bucket(BUCKET_NAME).build();

			boolean isExist = minioClient.bucketExists(args2);

			if (isExist) {
				System.out.println("Bucket already exists.");
			} else {
				minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
			}

			minioClient.listBuckets().forEach(b -> System.out.println(b.name()));

			URL url = new URL("https://images-na.ssl-images-amazon.com/images/I/81X4TID9IML._SL1500_.jpg");
			Path tempFilePath = Files.createTempFile("kid", ".jpg");
			try (InputStream in = url.openStream()) {
				Files.copy(in, tempFilePath, StandardCopyOption.REPLACE_EXISTING);
			}

			// minioClient.putObject(PutObjectArgs.builder().bucket("user1").object("Resume.pdf")
			// .stream(new FileInputStream("/tmp/Resume.pdf"), Files.size(tempFile),
			// -1).build());

			minioClient.putObject(PutObjectArgs.builder().bucket(BUCKET_NAME).object("kid.jpg")
					.stream(new FileInputStream(tempFilePath.toFile()), Files.size(tempFilePath), -1).build());

			try (InputStream stream = minioClient
					.getObject(GetObjectArgs.builder().bucket(BUCKET_NAME).object("kid.jpg").build())) {
				// Read the stream
			}
			// Files.delete(tempFile);
		} catch (MinioException e) {
			System.out.println("Error occurred: " + e);
		}

	}

}
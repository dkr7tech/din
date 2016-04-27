package com.common.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncryptionUtil {
	public static String generateSalt(String passowrd) {
		String salt = BCrypt.hashpw(passowrd, BCrypt.gensalt());
		return salt;
	}
	
	public static String generateWithGivenSalt(String passowrd,String salt) {
		String newSalt = BCrypt.hashpw(passowrd, salt);
		return newSalt;
	}

	public static boolean isValidPassword(String pwd, String saltPassword) {
		return BCrypt.checkpw(pwd, saltPassword);
	}

}

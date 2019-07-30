package com.modest.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author
 */
public class MD5Utils {
	/**
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;

		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("找不到md5算法");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		StringBuffer stringBuffer = new StringBuffer("0");
		int count = 32;
		for (int i = 0; i < count - md5code.length(); i++) {
			stringBuffer = stringBuffer.append(md5code);
//			md5code = "0" + md5code;
		}
		return md5code;
	}
	
	public static void main(String[] args) {
		System.out.println(md5("123!qwe@fs"));
		//1a08858a5302c00a9356d761224b6ab0
	}
}

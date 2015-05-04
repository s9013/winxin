package com.wind.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 验证util
 * @author : Jay
 * @fileName : com.wind.util.CheckUtil.java
 * @date : 2015年5月4日
 */
public class CheckUtil {

	private static final String token = "wind";

	public static boolean checkSignature(String signature, String timestamp,
			String nonce) {
		String[] arr = new String[] { token, timestamp, nonce };

		// 排序
		Arrays.sort(arr);

		// 生成字符串
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}

		// sha1 加密
		EncryptUtil sha1 = new EncryptUtil();
		String str = sha1.Encrypt(sb.toString(), "SHA-1") ;
		System.out.println(str);
		return signature.equals(str);

	}

}

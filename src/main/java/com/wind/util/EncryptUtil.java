package com.wind.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密util
 * @author : Jay
 * @fileName : com.wind.util.Sha1.java
 * @date : 2015年5月4日
 */
public class EncryptUtil {

	public String Encrypt(String strSrc, String encName) {
		// parameter strSrc is a string will be encrypted,
		// parameter encName is the algorithm name will be used.
		// encName dafault to "MD5"
		MessageDigest md = null;
		String strDes = null;

		byte[] bt = strSrc.getBytes();
		try {
			if (encName == null || encName.equals("")) {
				encName = "MD5";
			}
			md = MessageDigest.getInstance(encName);
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes;
	}

	public String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	public static void main(String[] args) {
		EncryptUtil te = new EncryptUtil();
		String strSrc = "可以加密汉字.Oh,and english";
		System.out.println("Source String:" + strSrc);
		System.out.println("Encrypted String:");
		System.out.println("Use Def:" + te.Encrypt(strSrc, null));
		System.out.println("Use MD5:" + te.Encrypt(strSrc, "MD5"));
		System.out.println("Use SHA:" + te.Encrypt(strSrc, "SHA-1"));
		System.out.println("Use SHA-256:" + te.Encrypt(strSrc, "SHA-256"));
	}

}

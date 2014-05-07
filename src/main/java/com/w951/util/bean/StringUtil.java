package com.w951.util.bean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class StringUtil {
	/**
	 * MD5加密
	 * @param str
	 * @return
	 */
	public static String toMD5(String str) {
		String md5str = null;
		if (str != null && str.length() != 0) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(str.getBytes());
				byte b[] = md.digest();
				
				int i;
				StringBuffer sb = new StringBuffer("");
				for (int offset = 0; offset < b.length ; offset++) {
					i = b[offset];
					if (i < 0) {
						i += 256;
					}
					if (i < 16) {
						sb.append("0");
					}
					sb.append(Integer.toHexString(i));
				}
				md5str = sb.toString().substring(8, 24);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return md5str;
	}
	
	/**
	 * MD5加密-32
	 * @param str
	 * @return
	 */
	public static String to32MD5(String str) {
		String md5str = null;
		if (str != null && str.length() != 0) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(str.getBytes());
				byte b[] = md.digest();
				
				int i;
				StringBuffer sb = new StringBuffer("");
				for (int offset = 0; offset < b.length ; offset++) {
					i = b[offset];
					if (i < 0) {
						i += 256;
					}
					if (i < 16) {
						sb.append("0");
					}
					sb.append(Integer.toHexString(i));
				}
				md5str = sb.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return md5str;
	}
	
	/**
	 * 获取一个UUID
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}

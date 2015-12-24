package com.remix.session.app3;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;
// 采用base64编码转换字节序列明文
public class Md5Util {
	public static String md5(String message){
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] b = md.digest(message.getBytes());
			BASE64Encoder base64 = new BASE64Encoder();
			return base64.encode(b);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}

package com.remix.session.app3;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;
// ����base64����ת���ֽ���������
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

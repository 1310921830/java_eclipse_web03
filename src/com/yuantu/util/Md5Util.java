package com.yuantu.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
	public static String encrypt(String str) throws UnsupportedEncodingException {
		System.out.println(str);
		byte[] data = str.getBytes("utf-8");
		//��ȡ��ϢժҪ����
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�����ݸ���������У�ֻ����byte����
		md5.update(data);	
		//���ܽ��
		byte[] result = md5.digest(); //16��byte
		
		//ת��Ϊ16�����ַ���
		String str1 = new BigInteger(1, result).toString(16);
		return str1;
	}
	
}

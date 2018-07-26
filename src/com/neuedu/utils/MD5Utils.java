package com.neuedu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	
	public static String getMD5(String str){
		
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] bytes=md.digest(str.getBytes());
			
			String s="";
			for(byte b:bytes){
				s+=Integer.toHexString(b>>>4 & 0X0F);
				s+=Integer.toHexString(b & 0x0f);
			}
			return s;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}

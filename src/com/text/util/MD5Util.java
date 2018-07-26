package com.text.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	public static String MD5(String str){
		
		try {
			if(str!=null){
				MessageDigest md=MessageDigest.getInstance("MD5");
				
				byte[] bytes=str.getBytes();
				
				md.update(bytes);
				
				byte[] out=md.digest();
				
				StringBuffer s=new StringBuffer();
				
				for(byte b:out){
					s.append(Integer.toHexString(b>>>4 & 0X0F));
					s.append(Integer.toHexString(b & 0X0F));
				}
				return s.toString();
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

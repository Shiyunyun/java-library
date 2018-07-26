package com.neuedu.utils;

public class StringUtils {
/**
 * 判断字符串是否有效
 * @param str
 * @return
 */
	public static boolean mathStr(String str){
		if(str!=null && !str.trim().equals("")){
			return true;
		}
		return false;
	}
}

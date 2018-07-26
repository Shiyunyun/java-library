package com.text.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public static String formats(Date date){
		if(date!=null){
			
			return sdf.format(date);
		}
		return null;
	}
	
	public static Date toDate(String str){
		if(str!=null){
			try {
				return new Date(sdf.parse(str).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

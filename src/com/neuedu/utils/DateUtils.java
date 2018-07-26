package com.neuedu.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class DateUtils {
		static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		public static String changerString(Date date){
			if(date!=null){
				return sdf.format(date);
			}
			return null;
		}
		
		public static Date toDate(String str) throws ParseException{
				if(StringUtils.mathStr(str)){
					return  new Date(sdf.parse(str).getTime()); 
					
				}
				return null;
		}
		
		
}

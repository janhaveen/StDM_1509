package com.data.service.impl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;

public class CurrentDateTime {
	
	public static String CurrentTime()
	{
		LocalDateTime dateStart = LocalDateTime.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	     String formatDateTime = dateStart.format(formatter);
		return formatDateTime;
	}
	
	public static Timestamp CurrentTimestamp()
	{
		long time = System.currentTimeMillis();
		
		Timestamp timestamp = new Timestamp(time);
		
		return timestamp;
		
	}
	
	public static void main(String[] args) 
	{
		System.out.println(CurrentTimestamp());
	}
	
	public static java.sql.Timestamp convertToTimestamp(String date){
		Timestamp ts = Timestamp.valueOf(date);
	    return ts;
	}

	public static Date convertToSqlDate(String strDate1) {
		java.util.Date date;
		Date sqlDate;
		String strDate=strDate1.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
		
		try {
			date = sdf.parse(strDate);
			sqlDate = new Date(date.getTime());
		} catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			sqlDate =null;
		}
		
		return sqlDate;
	}
	
	public static Time convertToSqlTime(String myTime ) {
    
	 SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
	 Time t;
	 long ms;
	 try {
	  ms = sdf.parse(myTime).getTime();
	  t = new Time(ms);
	 } catch (ParseException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	  t=null;
	 }
	 return t;
	}

	public static String convertToSqlTimeStamp(String myTime1) { System.out.println(myTime1);
		String ts = null;
		 SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy hh:mm a");
		 java.util.Date date; Date sqlDate; Time t; long ms;
		 try {
			 date = sdf.parse(myTime1);
			 sqlDate = new Date(date.getTime());
			 ms = sdf.parse(myTime1).getTime();
			 t = new Time(ms);// System.out.println(sqlDate+"sddsdscdcds"+t);
			 String s=sqlDate.toString()+" " +t.toString();
			 ts=sqlDate.toString()+" " +t.toString();
		 } catch (ParseException e) {
		  // TODO Auto-generated catch block
			  e.printStackTrace();
		 }
		 return ts;
	}
	
	public static java.sql.Date getCurrentSqlDate()
	{
		 long millis = System.currentTimeMillis();  
	        
		 java.sql.Date date = new java.sql.Date(millis);  
			
	     return date;  
	}
}

package com.collabera.account_management_system.utility;

import java.sql.Timestamp;

public  class TimestampGenerator {
	
	static Timestamp timestamp;
	
	public static  String getTimeStamp() {
		
		timestamp=new Timestamp(System.currentTimeMillis());
		System.out.println("timeStamp = "+timestamp);
		return timestamp.toString();
	}

}

package com.collabera.account_management_system.utility;

import java.time.LocalDate;

public class TimestampGenerator {

	static LocalDate localDate;

	public static LocalDate getTimeStamp() {
		
		localDate=LocalDate.now(); 
		return localDate;
			
		
	}

}
